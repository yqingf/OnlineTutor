package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.util.JsonUtils;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Random;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/22 15:50
 * @Version: 1.0
 */
@RestController
@RequestMapping("/qi/niu")
public class UploadController {

    private static Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Value("${qiniu.accesskey}")
    private String accessKey;
    @Value("${qiniu.secretkey}")
    private String secretKey;
    @Value("${qiniu.bucket}")
    private String bucket;
    @Value("${qiniu.source-prefix}")
    private String prefix;
    /**
     * 文件上传
     *
     * @return
     */
    @RequestMapping("/upload")
    public OnlineTutorResult upload(@RequestParam(value = "file", required = true) MultipartFile[] files) {
        Configuration configuration = new Configuration(Zone.zone1());
        UploadManager uploadManager = new UploadManager(configuration);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        long currentTime = System.currentTimeMillis();
        DefaultPutRet putRet = null;
        try {
            for (MultipartFile file : files) {
                // 得到图片原文件名
                String originalFilename = file.getOriginalFilename();
                // 得到扩展名
                String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
                // 新文件名 = 当前系统时间戳 + 6位随机数 + 扩展名
                String filename = currentTime + new Random().nextInt(1000000) + extName;
                Response response = uploadManager.put(file.getBytes(), filename, upToken);
                putRet = JsonUtils.jsonToPojo(response.bodyString(), DefaultPutRet.class);
                logger.info("key:" + putRet.key);
                logger.info("hash:" + putRet.hash);
            }
            //解析上传成功的结果
        } catch (QiniuException ex) {
            logger.error("上传失败！", ex);
        } catch (IOException e) {
            logger.error("IO异常！", e);
        }
        putRet.key = prefix + putRet.key;
        return OnlineTutorResult.ok(putRet);
    }
}
