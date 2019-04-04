package com.aylfq5.online.tutor.dao;

import com.aylfq5.online.tutor.domain.UserRoleKey;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

    List<UserRoleKey> selectByUserId(Long userId);
}