package com.aylfq5.online.tutor.service;

import com.aylfq5.online.tutor.domain.Permission;
import com.aylfq5.online.tutor.util.OnlineTutorResult;

import java.util.List;

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

    OnlineTutorResult getPermById(Long permId);

    OnlineTutorResult updatePerm(Permission permission);

    OnlineTutorResult deletePerm(Long permId);

    OnlineTutorResult getRolesList();
}
