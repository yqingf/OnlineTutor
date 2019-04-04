package com.aylfq5.online.tutor.service;

import com.aylfq5.online.tutor.domain.Permission;
import com.aylfq5.online.tutor.domain.Role;
import com.aylfq5.online.tutor.util.OnlineTutorResult;

import java.util.List;

/**
* @Description:
* @Author:         aylfq5
* @CreateDate:     2019/4/2 13:55
* @Version:        1.0
*/
public interface AuthService {
    /**
     * 获取用户权限
     *
     * @return
     */
    List<Permission> getUserPerms();

    /**
     * 获取所有权限
     *
     * @return
     */
    List<Permission> getPermsList();

    /**
     * 权限详情
     *
     * @param permId
     * @return
     */
    OnlineTutorResult getPermById(Long permId);

    /**
     * 更新权限
     *
     * @param permission
     * @return
     */
    OnlineTutorResult updatePerm(Permission permission);

    /**
     * 删除权限
     *
     * @param permId
     * @return
     */
    OnlineTutorResult deletePerm(Long permId);

    /**
     * 获取所有角色
     *
     * @return
     */
    OnlineTutorResult getRolesList();

    /**
     * 角色详情
     *
     * @param id
     * @return
     */
    OnlineTutorResult getRoleInfo(Long id);

    /**
     * 更新角色
     *
     * @param permIds
     * @param role
     * @return
     */
    OnlineTutorResult updateRole(String permIds, Role role);

    /**
     * 添加角色
     *
     * @param permIds
     * @param role
     * @return
     */
    OnlineTutorResult addRole(String permIds, Role role);

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    OnlineTutorResult deleteRole(Long roleId);

    /**
     * 添加权限
     *
     * @param permission
     * @return
     */
    OnlineTutorResult addPerm(Permission permission);
}
