package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.entity.UserDTO;
import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
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

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequiresRoles("superman")
    @DeleteMapping("/v1/{id}")
    @ResponseBody
    public OnlineTutorResult delete(@PathVariable String id) {
        OnlineTutorResult result = userService.deleteByPrimaryKey(Long.parseLong(id));
        return result;
    }

    /**
     * 批量删除
     *
     * @param userList
     * @return
     */
    @DeleteMapping("/v1")
    @ResponseBody
    public OnlineTutorResult deleteBatch(@RequestBody List<User> userList) {
        OnlineTutorResult result = userService.deleteBatch(userList);
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
    public OnlineTutorResult insert(User user, String roleIds) {
        OnlineTutorResult result = userService.insert(user, roleIds);
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
    public OnlineTutorResult update(User user, String roleIds) {
        OnlineTutorResult result = userService.updateByPrimaryKeySelective(user, roleIds);
        return result;
    }

    /**
     * 登录
     *
     * @param user
     * @param rememberMe
     * @return
     */
    @PostMapping("/v1/login")
    @ResponseBody
    public OnlineTutorResult login(User user, Boolean rememberMe) {
        OnlineTutorResult result = userService.login(user, rememberMe);
        return result;
    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/user/toLogin.html";
    }

    /**
     * 启用/停用
     * @param user
     * @return
     */
    @PostMapping("/update/status")
    @ResponseBody
    public OnlineTutorResult updateStatus(User user) {
        OnlineTutorResult result = userService.updateStatus(user);
        return result;
    }

    /**
     * 修改密码
     * @param userDTO
     * @return
     */
    @PutMapping("/update/password")
    @ResponseBody
    public OnlineTutorResult updatePassword(UserDTO userDTO) {
        OnlineTutorResult result = userService.updatePassword(userDTO);
        return result;
    }
}