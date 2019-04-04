package com.aylfq5.online.tutor.service;

import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.util.OnlineTutorResult;

import java.util.List;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/2/21 14:27
 * @Version: 1.0
 */
public interface UserService {
    OnlineTutorResult deleteByPrimaryKey(Long id);

    OnlineTutorResult insert(User record, String roleIds);

    int insertSelective(User record);

    OnlineTutorResult selectByPrimaryKey(Long id);

    OnlineTutorResult updateByPrimaryKeySelective(User record, String roleIds);

    OnlineTutorResult updateByPrimaryKey(User record);

    /**
     * 获取用户列表
     *
     * @param type 用户类型(1-学生, 2-导师, 3-管理员)
     * @return
     */
    OnlineTutorResult getUserList(Integer page, Integer rows, Integer type);

    OnlineTutorResult deleteBatch(List<User> userList);

    OnlineTutorResult login(User user, Boolean rememberMe);

    User selectByNumber(String number);
}
