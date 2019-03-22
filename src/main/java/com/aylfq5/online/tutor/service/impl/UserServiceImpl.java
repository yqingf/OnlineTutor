package com.aylfq5.online.tutor.service.impl;

import com.aylfq5.online.tutor.constant.UserType;
import com.aylfq5.online.tutor.dao.StudentInfoMapper;
import com.aylfq5.online.tutor.dao.TutorInfoMapper;
import com.aylfq5.online.tutor.dao.UserMapper;
import com.aylfq5.online.tutor.domain.StudentInfo;
import com.aylfq5.online.tutor.domain.TutorInfo;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.IDUtils;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import com.aylfq5.online.tutor.util.Operation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/2/21 14:28
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private TutorInfoMapper tutorInfoMapper;
    @Resource
    private StudentInfoMapper studentInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public OnlineTutorResult deleteByPrimaryKey(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        tutorInfoMapper.deleteByPrimaryKey(Long.parseLong(user.getNumber()));
        int count = userMapper.deleteByPrimaryKey(id);
        if (count > 0) {
            return OnlineTutorResult.build(200, "删除成功！");
        }
        return OnlineTutorResult.build(400, "删除失败！");
    }

    @Operation("创建用户")
    @Override
    public OnlineTutorResult insert(User record) {
        // 用户ID
        record.setId(IDUtils.genItemId());
        // 判断该职工号/学号是否已存在
        User user = userMapper.selectByNumber(record.getNumber());
        if (user != null) {
            return OnlineTutorResult.build(400,"该职工号/学号已存在!", 0);
        }
        // 密码和确认密码是否匹配
        if (!record.getPassword().equals(record.getConfirmPassword())) {
            return OnlineTutorResult.build(400, "密码和确认密码不一致!", 0);
        }
        // 对密码进行md5加密
        String md5Password = DigestUtils.md5DigestAsHex(record.getPassword().getBytes());
        record.setPassword(md5Password);
        // 插入
        userMapper.insert(record);
        return OnlineTutorResult.build(200, "用户添加成功!", 0);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public OnlineTutorResult selectByPrimaryKey(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return OnlineTutorResult.ok(user);
    }

    @Override
    public OnlineTutorResult updateByPrimaryKeySelective(User record) {
        int res = userMapper.updateByPrimaryKeySelective(record);
        if (res <= 0) {
            return OnlineTutorResult.build(400, "修改失败！");
        }
        return OnlineTutorResult.build(200, "修改成功！");
    }

    @Override
    public OnlineTutorResult updateByPrimaryKey(User record) {
        int res = userMapper.updateByPrimaryKey(record);
        if (res <= 0) {
            return OnlineTutorResult.build(400, "修改失败！");
        }
        return OnlineTutorResult.build(200, "修改成功！");
    }

    @Operation("获取用户列表")
    @Override
    public OnlineTutorResult getUserList(int type) {
        List<User> userList = userMapper.getUserList(type);
        if (userList.size() <= 0) {
            return OnlineTutorResult.build(4001, "暂无数据!", 0);
        }
        return OnlineTutorResult.build(200, "ok",userList.size(), userList);
    }
}
