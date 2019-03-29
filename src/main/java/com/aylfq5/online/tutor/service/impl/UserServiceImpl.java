package com.aylfq5.online.tutor.service.impl;

import com.aylfq5.online.tutor.controller.CaptchaController;
import com.aylfq5.online.tutor.dao.StudentInfoMapper;
import com.aylfq5.online.tutor.dao.TutorInfoMapper;
import com.aylfq5.online.tutor.dao.UserMapper;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.IDUtils;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import com.aylfq5.online.tutor.util.Operation;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
            return OnlineTutorResult.build(400, "该职工号/学号已存在!", 0);
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
        User user = userMapper.selectByPrimaryAndNumber(record);
        if (user != null) {
            return OnlineTutorResult.build(400, "职工号已存在！");
        }
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
    public OnlineTutorResult getUserList(Integer page, Integer rows, Integer type) {
        PageHelper.startPage(page == null ? 1 : page, rows == null ? 20 : rows);
        List<User> userList = userMapper.getUserList(type);
        if (userList.size() <= 0) {
            return OnlineTutorResult.build(4001, "暂无数据!", 0);
        }
        PageInfo pageInfo = new PageInfo(userList);
        long total = pageInfo.getTotal();

        return OnlineTutorResult.build(200, "ok", (int) total, userList);
    }

    @Override
    public OnlineTutorResult deleteBatch(List<User> userList) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (User user : userList) {
            sb.append(user.getId());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        System.out.println(sb.toString());
        int res = userMapper.deleteBatch(sb.toString());
        if (res < 0) {
            return OnlineTutorResult.build(400, "删除失败");
        }
        return OnlineTutorResult.build(200, "删除成功！");
    }

    @Override
    public OnlineTutorResult login(User user, Boolean rememberMe) {

        UsernamePasswordToken token = new UsernamePasswordToken(user.getNumber(), user.getPassword(), rememberMe);
        Subject subject = SecurityUtils.getSubject();
        String vcode= (String) subject.getSession().getAttribute(CaptchaController.KEY_CAPCHA);
        if (!vcode.toLowerCase().equals(user.getCode().trim().toLowerCase())) {
            return OnlineTutorResult.build(400, "验证码错误！");
        }
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                Session session = subject.getSession();
                session.setAttribute("user", userMapper.selectByNumber(user.getNumber()));
            }
            return OnlineTutorResult.ok();
        } catch (UnknownAccountException e) {
            return OnlineTutorResult.build(400, "账号未注册!");
        } catch (IncorrectCredentialsException e) {
            return OnlineTutorResult.build(400, "密码不正确!");
        } catch (AuthenticationException e) {
            return OnlineTutorResult.build(403, "认证失败!");
        }
    }
}
