package com.aylfq5.online.tutor.dao;

import com.aylfq5.online.tutor.domain.RolePermissionKey;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(RolePermissionKey key);

    int insert(RolePermissionKey record);

    int insertSelective(RolePermissionKey record);
}