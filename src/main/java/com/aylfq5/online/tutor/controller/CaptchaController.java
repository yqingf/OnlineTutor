package com.aylfq5.online.tutor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/29 8:35
 * @Version: 1.0
 */
@Controller
public class CaptchaController {

    public static final String KEY_CAPCHA = "KEY_CAPCHA";

    @RequestMapping("/captcha/random")
    public void genCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 验证码字符个数
        int count = 4;
        String str = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz0123456789";
        // 随机数生成器
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            stringBuffer.append(str.charAt(random.nextInt(58)));
        }
        request.getSession().setAttribute(KEY_CAPCHA,stringBuffer.toString());
        PrintWriter out = response.getWriter();
        out.print(stringBuffer);
    }
}
