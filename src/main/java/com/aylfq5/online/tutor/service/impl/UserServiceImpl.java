package com.aylfq5.online.tutor.service.impl;

import com.aylfq5.online.tutor.constant.ResponseMsg;
import com.aylfq5.online.tutor.constant.ResponseStatusCode;
import com.aylfq5.online.tutor.controller.CaptchaController;
import com.aylfq5.online.tutor.dao.*;
import com.aylfq5.online.tutor.domain.Condition;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.domain.UserExample;
import com.aylfq5.online.tutor.domain.UserRoleKey;
import com.aylfq5.online.tutor.entity.UserDTO;
import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.IDUtils;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import com.aylfq5.online.tutor.util.Operation;
import com.aylfq5.online.tutor.util.POIUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
    private StudentVolunteerMapper studentVolunteerMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private RoleMapper roleMapper;


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
    @Transactional(rollbackFor = Exception.class)
    public OnlineTutorResult insert(User record, String roleIds) {
        // 用户ID
        record.setId(IDUtils.genItemId());
        // 判断该职工号/学号是否已存在
        User user = userMapper.selectByNumber(record.getNumber());
        if (user != null) {
            return OnlineTutorResult.build(ResponseStatusCode.METHOD_ARGUMENT_NOT_VALID_EXCEPTION, "该职工号/学号已存在!", 0);
        }
        // 密码和确认密码是否匹配
        if (!record.getPassword().equals(record.getConfirmPassword())) {
            return OnlineTutorResult.build(ResponseStatusCode.METHOD_ARGUMENT_NOT_VALID_EXCEPTION, "密码和确认密码不一致!", 0);
        }
        // 对密码进行md5加密
        String md5Password = DigestUtils.md5Hex(record.getPassword().getBytes());
        record.setPassword(md5Password);
        // 插入
        int res = userMapper.insert(record);
        if (res <= 0) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, ResponseMsg.INSERT_FAIL);
        }
        // 给用户添加角色
        addRole(record.getId(), roleIds.split(","));
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "用户添加成功!", 0);
    }

    private void addRole(Long userId, String[] roleIds) {
        for (String roleId : roleIds) {
            UserRoleKey userRoleKey = new UserRoleKey();
            userRoleKey.setUserId(userId);
            userRoleKey.setRoleId(Long.parseLong(roleId));
            userRoleMapper.insertSelective(userRoleKey);
        }
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
    @Transactional(rollbackFor = Exception.class)
    public OnlineTutorResult updateByPrimaryKeySelective(User record, String roleIds) {
        if (StringUtils.isEmpty(roleIds)) {
            return OnlineTutorResult.build(ResponseStatusCode.MISSING_REQUEST_PARAMETER_EXCEPTION, "请选择角色!");
        }
        User user = userMapper.selectByPrimaryAndNumber(record);
        if (user != null) {
            return OnlineTutorResult.error("职工号已存在！");
        }
        int res = userMapper.updateByPrimaryKeySelective(record);
        if (res <= 0) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, ResponseMsg.UPDATE_FAIL);
        }
        // 查询用户的角色
        List<UserRoleKey> userRoleKeyList = userRoleMapper.selectByUserId(record.getId());
        // 删除用户原来的角色
        batchDeleteRole(userRoleKeyList);
        // 给用户添加新的角色
        addRole(record.getId(), roleIds.split(","));
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, ResponseMsg.UPDATE_SUCCESS);
    }

    private void batchDeleteRole(List<UserRoleKey> userRoleKeyList) {
        for (UserRoleKey userRoleKey : userRoleKeyList) {
            userRoleMapper.deleteByPrimaryKey(userRoleKey);
        }
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
    public OnlineTutorResult getUserList(Condition condition) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        Integer page = condition.getPage();
        Integer rows = condition.getRows();
        PageHelper.startPage(page == null ? 1 : page, rows == null ? 20 : rows);
        // 姓名
        if (StringUtils.isNotEmpty(condition.getName())) {
            criteria.andNameLike("%" + condition.getName().trim() + "%");
        }
        // 账号
        if (StringUtils.isNotEmpty(condition.getNumber())) {
            criteria.andNumberLike("%" + condition.getNumber().trim() + "%");
        }
        // 性别
        if (condition.getGender() != null) {
            criteria.andGenderEqualTo(condition.getGender());
        }
        // 状态
        if (condition.getStatus() != null) {
            criteria.andStatusEqualTo(condition.getStatus());
        }
        // 职称
        if (StringUtils.isNotEmpty(condition.getProfessionalTitle())) {
            criteria.andProfessionalTitleEqualTo(condition.getProfessionalTitle().trim());
        }
        // 班级
        if (StringUtils.isNotEmpty(condition.getOffice())) {
            criteria.andOfficeEqualTo(condition.getOffice().trim());
        }
        // 专业
        if (StringUtils.isNotEmpty(condition.getDirection())) {
            criteria.andDirectionEqualTo(condition.getDirection().trim());
        }
        // 用户类型
        criteria.andUserTypeEqualTo(condition.getType());
        List<User> userList = userMapper.selectByExample(example);
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

        UsernamePasswordToken token = new UsernamePasswordToken(user.getNumber(), DigestUtils.md5Hex(user.getPassword()), rememberMe);
        Subject subject = SecurityUtils.getSubject();
        String vcode = (String) subject.getSession().getAttribute(CaptchaController.KEY_CAPCHA);
        if (!vcode.toLowerCase().equals(user.getCode().trim().toLowerCase())) {
            return OnlineTutorResult.build(400, "验证码错误！");
        }
        try {
            subject.login(token);
            return OnlineTutorResult.ok();
        } catch (UnknownAccountException e) {
            return OnlineTutorResult.build(400, "账号未注册!");
        } catch (IncorrectCredentialsException e) {
            return OnlineTutorResult.build(400, "密码不正确!");
        } catch (AuthenticationException e) {
            return OnlineTutorResult.build(403, "认证失败!");
        }
    }

    @Override
    public User selectByNumber(String number) {
        return userMapper.selectByNumber(number);
    }

    @Override
    public OnlineTutorResult updateStatus(User user) {
        int res = userMapper.updateByPrimaryKeySelective(user);
        if (res <= 0) {
            return OnlineTutorResult.error("操作失败！");

        }
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "操作成功！");
    }

    @Override
    public OnlineTutorResult updatePassword(UserDTO userDTO) {
        // 取当前登录用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        // 判断确认密码和密码是否一致
        if (!userDTO.getNewPassword().equals(userDTO.getConfirmPassword())) {
            return OnlineTutorResult.error("两次密码输入不一致！");
        }
        // 判断原密码是否正确
        String md5Pass = DigestUtils.md5Hex(userDTO.getPassword());
        if (!user.getPassword().equals(md5Pass)) {
            return OnlineTutorResult.error("原密码不正确！");
        }
        // 加密新密码
        String newMd5pass = DigestUtils.md5Hex(userDTO.getNewPassword());
        user.setPassword(newMd5pass);
        int res = userMapper.updateByPrimaryKeySelective(user);
        if (res <= 0) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, ResponseMsg.UPDATE_FAIL);
        }
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, ResponseMsg.UPDATE_SUCCESS);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OnlineTutorResult importStudent(MultipartFile file) throws CloneNotSupportedException, IOException {
        List<User> userList = new ArrayList<>();
        List<String[]> strings = POIUtils.readExcel(file);
        User user = new User();
        for (int i = 0; i < strings.size(); i++) {
//            long id = IDUtils.genItemId();
            IDUtils idUtils = new IDUtils(0,0);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String[] arr = strings.get(i);
            User cloneUser = user.clone();
            cloneUser.setId(idUtils.nextId());
            cloneUser.setName(arr[1]);
            cloneUser.setPassword("4297f44b13955235245b2497399d7a93");
            cloneUser.setUserType(1);
            cloneUser.setGender("男".equals(arr[2]) ? 1 : 2);
            cloneUser.setNumber(arr[0]);
            cloneUser.setDirection(arr[3]);
            cloneUser.setCellphone(arr[5]);
            cloneUser.setQq(arr[6]);
            cloneUser.setEmail(arr[7]);
            cloneUser.setOffice(arr[4]);
            userList.add(cloneUser);
        }
        int count = userMapper.batchInsert(userList);
        grantRole(userList, 1);
        return OnlineTutorResult.ok(count);
    }

    private void grantRole(List<User> userList, int type) throws CloneNotSupportedException {
        // 查询学生角色ID
        Long roleId = roleMapper.getUserRoleId(type);
        List<UserRoleKey> list = new ArrayList<>();
        UserRoleKey userRoleKey = new UserRoleKey();
        for (User user : userList) {
            UserRoleKey clone = (UserRoleKey) userRoleKey.clone();
            clone.setRoleId(roleId);
            clone.setUserId(user.getId());
            list.add(clone);
        }
        // 批量插入
        userRoleMapper.batchInsert(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OnlineTutorResult importTutor(MultipartFile file) throws IOException, CloneNotSupportedException {
        List<User> userList = new ArrayList<>();
        List<String[]> strings = POIUtils.readExcel(file);
        User user = new User();
        for (int i = 0; i < strings.size(); i++) {
            long id = IDUtils.genItemId();
            String[] arr = strings.get(i);
            User cloneUser = user.clone();
            cloneUser.setId(id);
            cloneUser.setName(arr[1]);
            cloneUser.setPassword("4297f44b13955235245b2497399d7a93");
            cloneUser.setUserType(2);
            cloneUser.setGender("男".equals(arr[2]) ? 1 : 2);
            cloneUser.setProfessionalTitle(arr[3]);
            cloneUser.setExpectedNumbers(Integer.valueOf(arr[4]));
            cloneUser.setNumber(arr[0]);
            cloneUser.setCellphone(arr[5]);
            userList.add(cloneUser);
        }
        int count = userMapper.batchInsert(userList);
        grantRole(userList, 2);
        return OnlineTutorResult.ok(count);
    }

    @Override
    public OnlineTutorResult getNoTutorStudentList(Condition condition) {
        Integer page = condition.getPage();
        Integer rows = condition.getRows();
        PageHelper.startPage(page == null ? 1 : page, rows == null ? 10 : rows);
        // 获取还未被导师选中的学生列表
        List<User> userList = userMapper.getNoTutorStudentList();
        if (userList.size() <= 0) {
            return OnlineTutorResult.build(4001, "暂无数据!", 0);
        }
        PageInfo pageInfo = new PageInfo(userList);
        long total = pageInfo.getTotal();

        return OnlineTutorResult.build(200, "ok", (int) total, userList);
    }

    @Override
    public synchronized OnlineTutorResult getVacancyTutor() {
        List<User> userList = new ArrayList<>();
        // 获取导师列表
        List<User> tutorList = userMapper.getUserList(2);
        for (User user : tutorList) {
            int agreeCount = studentVolunteerMapper.getAgreeCountByTutorId(user.getId());
            int expectedNumbers = user.getExpectedNumbers() == null ? 0 : user.getExpectedNumbers();
            if (agreeCount < expectedNumbers) {
                userList.add(user);
            }
        }
        return OnlineTutorResult.ok(userList);
    }
}
