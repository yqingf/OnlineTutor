package com.aylfq5.online.tutor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/2/27 10:10
 * @Version: 1.0
 */
@Controller
public class IndexController {

    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }

    @RequestMapping("/403.html")
    public String toUnauthorizedUrl(){
        return "403";
    }
}
