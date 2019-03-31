package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.domain.Permission;
import com.aylfq5.online.tutor.service.AuthService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    /**
     * 获取用户所有权限
     *
     * @return
     */
    @RequestMapping("/getUserPerms")
    public List<Permission> getUserPerms() {
        List<Permission> permissionList = authService.getUserPerms();
        return permissionList;
    }

    /**
     * 获取全部权限
     *
     * @return
     */
    @RequestMapping("/permList")
    public ModelAndView getPermList() {
        ModelAndView model = new ModelAndView("/auth/permList");
        List<Permission> permissionList = authService.getPermsList();
        model.addObject("permList", permissionList);
        return model;
    }

    @RequestMapping("/selectPerms")
    public List<Permission> selectPerms() {
        List<Permission> permsList = authService.getPermsList();
        return permsList;
    }

    /**
     * 获取权限详情
     *
     * @param permId
     * @return
     */
    @RequestMapping("/getPerm")
    public OnlineTutorResult getPermById(Long permId) {
        OnlineTutorResult result = authService.getPermById(permId);
        return result;
    }

    /**
     * 更新权限
     *
     * @param permission
     * @return
     */
    @RequestMapping("/updatePerm")
    public OnlineTutorResult updatePerm(Permission permission) {
        OnlineTutorResult result = authService.updatePerm(permission);
        return result;
    }

    /**
     * 删除权限
     *
     * @param permId
     * @return
     */
    @RequestMapping("/delete/perm")
    public OnlineTutorResult deletePerm(Long permId) {
        OnlineTutorResult result = authService.deletePerm(permId);
        return result;
    }

    @RequestMapping("/role/list.html")
    public ModelAndView roleList() {
        return new ModelAndView("/auth/roleManage");
    }

    @RequestMapping("/role/list")
    public OnlineTutorResult getRoleList() {
        OnlineTutorResult result = authService.getRolesList();
        return result;
    }
}
