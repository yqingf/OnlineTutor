package com.aylfq5.online.tutor.service;

import com.aylfq5.online.tutor.domain.User;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/2/21 14:27
 * @Version: 1.0
 */
public interface UserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
