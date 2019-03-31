package com.aylfq5.online.tutor.service.impl;

import com.aylfq5.online.tutor.constant.ResponseMsg;
import com.aylfq5.online.tutor.constant.ResponseStatusCode;
import com.aylfq5.online.tutor.dao.PermissionMapper;
import com.aylfq5.online.tutor.dao.RoleMapper;
import com.aylfq5.online.tutor.domain.Permission;
import com.aylfq5.online.tutor.domain.Role;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.service.AuthService;
import com.aylfq5.online.tutor.util.IDUtils;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/30 10:30
 * @Version: 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private RoleMapper roleMapper;

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Override
    public List<Permission> getUserPerms() {
        logger.debug("根据用户id查询限树列表！");
        List<Permission> permissionList = null;
        /*User user = (User) SecurityUtils.getSubject().getPrincipal();

        if (user == null) {
            logger.debug("根据用户id查询限树列表！用户未登录");
            return null;
        }*/
        permissionList = permissionMapper.getUserPerms(1L);
        return permissionList;
    }

    @Override
    public List<Permission> getPermsList() {
        logger.debug("权限列表！");
        List<Permission> permissionList = permissionMapper.selectByExample(null);
        logger.debug("权限列表查询=permList:" + permissionList);
        return permissionList;
    }

    @Override
    public OnlineTutorResult getPermById(Long permId) {
        Permission permission = permissionMapper.selectByPrimaryKey(permId);
        return OnlineTutorResult.ok(permission);
    }

    @Override
    public OnlineTutorResult updatePerm(Permission permission) {
        if (permission == null) {
            return OnlineTutorResult.error();
        }
        if (permission.getId() != null) {
            int res = permissionMapper.updateByPrimaryKey(permission);
            if (res <= 0) {
                return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, ResponseMsg.UPDATE_FAIL);
            }
            return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, ResponseMsg.UPDATE_SUCCESS);
        }
        permission.setId(IDUtils.genItemId());
        int res = permissionMapper.insert(permission);
        if (res <= 0) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, ResponseMsg.INSERT_FAIL);
        }
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, ResponseMsg.INSERT_SUCCESS);
    }

    @Override
    public OnlineTutorResult deletePerm(Long permId) {
        int res = permissionMapper.deleteByPrimaryKey(permId);
        if (res <= 0) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, ResponseMsg.DELETE_FAIL);
        }
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, ResponseMsg.DELETE_SUCCESS);
    }

    @Override
    public OnlineTutorResult getRolesList() {
        List<Role> roles = roleMapper.selectByExample(null);
        return OnlineTutorResult.ok(roles);
    }
}
