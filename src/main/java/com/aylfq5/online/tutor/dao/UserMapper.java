package com.aylfq5.online.tutor.dao;

import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.exception.DataDoException;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByNumber(String number);

    /**
     * 获取用户列表
     * @param type
     * @return
     */
    List<User> getUserList(int type);
}