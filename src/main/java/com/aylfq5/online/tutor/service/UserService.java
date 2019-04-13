package com.aylfq5.online.tutor.service;

import com.aylfq5.online.tutor.domain.Condition;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.entity.UserDTO;
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
     * 按条件获取用户列表
     * @param condition
     * @return
     */
    OnlineTutorResult getUserList(Condition condition);

    OnlineTutorResult deleteBatch(List<User> userList);

    OnlineTutorResult login(User user, Boolean rememberMe);

    User selectByNumber(String number);

    OnlineTutorResult updateStatus(User user);

    OnlineTutorResult updatePassword(UserDTO userDTO);
}
