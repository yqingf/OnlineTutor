package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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


    @RequestMapping("/toLogin.html")
    public String toLogin() {
        return "/user/login";
    }

    @RequestMapping("/login")
    public String login(User user) {
        System.out.println(user);
        return "/user/login";
    }


    /**
     * 查看用户详情
     *
     * @param id
     * @return
     */
    @GetMapping("/v1/{id}")
    public String toDetail(@PathVariable String id, Model model) {
        OnlineTutorResult result = userService.selectByPrimaryKey(Long.parseLong(id));
        model.addAttribute("result", result.getData());
        return "/tutor/detail";
    }
    /**
     * 用户列表
     *
     * @param type 类型 1-学生  2-导师  3-管理员
     * @return
     */
    @RequestMapping("/v1")
    @ResponseBody
    public OnlineTutorResult getUserList(Integer type) {
        OnlineTutorResult result = userService.getUserList(type);
        return result;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/v1/{id}")
    @ResponseBody
    public OnlineTutorResult delete(@PathVariable String id) {
        OnlineTutorResult result = userService.deleteByPrimaryKey(Long.parseLong(id));
        return result;
    }

    @DeleteMapping("/v1")
    @ResponseBody
    public OnlineTutorResult deleteBatch(String[] ids) {
        OnlineTutorResult result = userService.deleteBatch(ids);
        return result;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping("/v1")
    @ResponseBody
    public OnlineTutorResult insert(User user) {
        OnlineTutorResult result = userService.insert(user);
        return result;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @PutMapping("/v1")
    @ResponseBody
    public OnlineTutorResult update(User user) {
        OnlineTutorResult result = userService.updateByPrimaryKeySelective(user);
        return result;
    }




}