package com.aylfq5.online.tutor.dao;

import com.aylfq5.online.tutor.domain.UserRoleKey;

public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);
}