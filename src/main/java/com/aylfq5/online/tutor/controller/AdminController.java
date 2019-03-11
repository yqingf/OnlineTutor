package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.exception.DataDoException;
import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import com.aylfq5.online.tutor.util.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/2/26 13:36
 * @Version: 1.0
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Resource
    private UserService userService;
    @Operation("后台首页")
    @RequestMapping("index.html")
    public String index() {
        return "admin/index";
    }
    @RequestMapping("welcome.html")
    public String welcome() {
        return "admin/welcome";
    }

    @PostMapping("createUser")
    @ResponseBody
    public OnlineTutorResult createUser(User user) {
        OnlineTutorResult result = userService.insert(user);
        return result;
    }


}
