package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @ClassName ExcelController
 * @Description
 * @Author aylfq5
 * @Date 2019/5/15 15:32
 * @Version 1.0
 */
@RestController
public class ExcelController {


    @Resource
    private UserService userService;

    /**
     * 导入学生
     * @param file xls文件
     * @return
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    @RequestMapping("/import/student")
    public OnlineTutorResult importStudent(MultipartFile file) throws IOException, CloneNotSupportedException {
        OnlineTutorResult result = userService.importStudent(file);
        return result;
    }

    /**
     * Excel批量导入导师
     * @param file
     * @return
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    @RequestMapping("/import/tutor")
    public OnlineTutorResult importTutor(MultipartFile file) throws IOException, CloneNotSupportedException {
        OnlineTutorResult result = userService.importTutor(file);
        return result;
    }
}
