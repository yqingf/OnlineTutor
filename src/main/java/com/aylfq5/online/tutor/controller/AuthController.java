package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.domain.Permission;
import com.aylfq5.online.tutor.domain.Role;
import com.aylfq5.online.tutor.service.AuthService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("/user/perms")
    public List<Permission> getUserPerms() {
        List<Permission> permissionList = authService.getUserPerms();
        return permissionList;
    }

    /**
     * 获取全部权限
     *
     * @return
     */
    @RequestMapping("/permission/list.html")
    public ModelAndView getPermList() {
        ModelAndView model = new ModelAndView("/auth/permList");
        List<Permission> permissionList = authService.getPermsList();
        model.addObject("permList", permissionList);
        return model;
    }

    /**
     * 获取全部权限
     *
     * @return
     */
    @RequestMapping("/permission/list")
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
    @RequestMapping("/permission/detail")
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
    @RequestMapping("/permission/update")
    public OnlineTutorResult updatePerm(Permission permission) {
        OnlineTutorResult result = authService.updatePerm(permission);
        return result;
    }

    /**
     * 添加权限页面
     *
     * @param parentId
     * @return
     */
    @RequestMapping("/permission/add.html/{parentId}")
    public ModelAndView toAddPerm(@PathVariable Long parentId) {
        ModelAndView model = new ModelAndView("/auth/permission");
        model.addObject("parentId", parentId);
        return model;
    }

    /**
     * 添加权限
     *
     * @param permission
     * @return
     */
    @RequestMapping("/permission/add")
    public OnlineTutorResult addPerm(Permission permission) {
        OnlineTutorResult result = authService.addPerm(permission);
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

    /**
     * 角色列表
     *
     * @return
     */
    @RequestMapping("/role/list.html")
    public ModelAndView roleList() {
        ModelAndView model = new ModelAndView("/auth/roleManage");
        Map<String, Object> map = new HashMap<>();
        map.put("roleDetail", new Role());
        map.put("permissionList", new ArrayList<Permission>());
        model.addObject("res", map);
        return model;
    }

    /**
     * 角色列表
     *
     * @return
     */
    @RequestMapping("/role/list")
    public OnlineTutorResult getRoleList() {
        OnlineTutorResult result = authService.getRolesList();
        return result;
    }

    /**
     * 跳转到角色更新页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/role/update/{id}")
    public ModelAndView toUpdateRole(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("/auth/roleManage");

        OnlineTutorResult result = authService.getRoleInfo(id);
        mv.addObject("flag", "updateRole");
        mv.addObject("res", result.getData());
        return mv;
    }

    /**
     * 修改角色
     *
     * @param permIds
     * @param role
     * @return
     */
    @RequestMapping("/role/update")
    public OnlineTutorResult updateRole(@RequestParam("rolePermIds") String permIds, Role role) {
        OnlineTutorResult result = authService.updateRole(permIds, role);
        return result;
    }

    /**
     * 添加角色
     *
     * @param permIds
     * @param role
     * @return
     */
    @RequestMapping("/role/add")
    public OnlineTutorResult addRole(@RequestParam("permIds") String permIds, Role role) {
        OnlineTutorResult result = authService.addRole(permIds, role);
        return result;
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/role/delete")
    public OnlineTutorResult deleteRole(@RequestParam("roleId") Long roleId) {
        OnlineTutorResult result = authService.deleteRole(roleId);
        return result;
    }

}
