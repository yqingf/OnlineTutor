package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/2/21 14:26
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model){
        Long userId = Long.parseLong(request.getParameter("id"));
        System.out.println(userId);
        User user = this.userService.selectByPrimaryKey(userId);
        model.addAttribute("users",user);
        return "/user/list";
    }

    @RequestMapping("/toLogin.html")
    public String toLogin(){
        return "/user/login";
    }
    @RequestMapping("/login")
    public String login(User user){
        System.out.println(user);
        return "/user/login";
    }
}