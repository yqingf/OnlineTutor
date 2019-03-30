package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.domain.Permission;
import com.aylfq5.online.tutor.service.AuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/30 9:47
 * @Version: 1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @RequestMapping("/getUserPerms")
    public List<Permission> getUserPerms() {
        List<Permission> permissionList = authService.getUserPerms();
        return permissionList;
    }
}
