package com.aylfq5.online.tutor.service.impl;

import com.aylfq5.online.tutor.constant.ResponseMsg;
import com.aylfq5.online.tutor.constant.ResponseStatusCode;
import com.aylfq5.online.tutor.dao.PermissionMapper;
import com.aylfq5.online.tutor.dao.RoleMapper;
import com.aylfq5.online.tutor.dao.RolePermissionMapper;
import com.aylfq5.online.tutor.dao.UserMapper;
import com.aylfq5.online.tutor.domain.Permission;
import com.aylfq5.online.tutor.domain.Role;
import com.aylfq5.online.tutor.domain.RolePermissionKey;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.service.AuthService;
import com.aylfq5.online.tutor.util.IDUtils;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Resource
    private RolePermissionMapper rolePermissionMapper;
    @Resource
    private UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Override
    public List<Permission> getUserPerms() {
        logger.debug("根据用户id查询限树列表！");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            logger.debug("根据用户id查询限树列表！用户未登录");
            return null;
        }
        List<Permission> permissionList = permissionMapper.getUserPerms(user.getId());
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
            int res = permissionMapper.updateByPrimaryKeySelective(permission);
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

    @Override
    public OnlineTutorResult getRoleInfo(Long id) {
        if (id == null) {
            return OnlineTutorResult.build(ResponseStatusCode.MISSING_REQUEST_PARAMETER_EXCEPTION, "角色ID不能为空!");
        }
        // 角色详情
        Role role = roleMapper.selectByPrimaryKey(id);
        // 获取角色的权限
        List<RolePermissionKey> rolePermissionList = rolePermissionMapper.getPermsByRoleId(id);
        // 获取所有权限
        List<Permission> permissionList = permissionMapper.selectByExample(null);
        for (RolePermissionKey rolePermissionKey : rolePermissionList) {
            // 设置角色下的权限是否为选中状态
            for (Permission permission : permissionList) {
                if (rolePermissionKey.getPermitId().longValue() == permission.getId().longValue()) {
                    permission.setChecked(true);
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("permissionList", permissionList.toArray());
        map.put("roleDetail", role);
        return OnlineTutorResult.ok(map);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OnlineTutorResult updateRole(String permIds, Role role) {
        if (StringUtils.isEmpty(permIds)) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, "permIds不能为空");
        }
        int res = roleMapper.updateByPrimaryKeySelective(role);
        if (res <= 0) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, ResponseMsg.UPDATE_FAIL);
        }
        Long roleId=role.getId();
        String[] arrays=permIds.split(",");
        // 删除原角色权限；
        batchDelRolePerms(roleId);
        // 添加新的角色权限数据；
        setRolePerms(roleId, arrays);
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, ResponseMsg.UPDATE_SUCCESS);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OnlineTutorResult addRole(String permIds, Role role) {
        if (StringUtils.isEmpty(permIds)) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, "permIds不能为空");
        }
//        User user = (User) SecurityUtils.getSubject().getPrincipal();
//        if (user == null) {
//            return OnlineTutorResult.error("用户未登录!");
//        }
        // 补齐角色属性
        Long roleId = IDUtils.genItemId();
        role.setId(roleId);
//        role.setInsertUid(user.getId());
        // 添加角色
        int res = roleMapper.insertSelective(role);
        if (res <= 0) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, ResponseMsg.INSERT_FAIL);
        }
        // 给角色添加权限
        setRolePerms(roleId, permIds.split(","));
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, ResponseMsg.INSERT_SUCCESS);
    }

    @Override
    public OnlineTutorResult deleteRole(Long roleId) {
        int res = roleMapper.deleteByPrimaryKey(roleId);
        if (res <= 0) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, ResponseMsg.DELETE_FAIL);
        }
        // 删除该角色对应的权限
        batchDelRolePerms(roleId);
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, ResponseMsg.DELETE_SUCCESS);
    }

    @Override
    public OnlineTutorResult addPerm(Permission permission) {
        if (permission == null) {
            return OnlineTutorResult.error();
        }
        if (permission.getParentId() == null) {
            return OnlineTutorResult.error();
        }
        permission.setId(IDUtils.genItemId());
        int res = permissionMapper.insertSelective(permission);
        if (res <= 0) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, ResponseMsg.INSERT_FAIL);
        }
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, ResponseMsg.INSERT_SUCCESS);
    }

    private void setRolePerms(Long roleId, String[] arrays) {
        for (String permId : arrays) {
            RolePermissionKey rolePermissionKey = new RolePermissionKey();
            rolePermissionKey.setPermitId(Long.parseLong(permId));
            rolePermissionKey.setRoleId(roleId);
            rolePermissionMapper.insert(rolePermissionKey);
        }
    }

    private void batchDelRolePerms(Long roleId) {
        List<RolePermissionKey> permissionKeys = rolePermissionMapper.getPermsByRoleId(roleId);
        for (RolePermissionKey rolePermissionKey : permissionKeys) {
            rolePermissionMapper.deleteByPrimaryKey(rolePermissionKey);
        }
    }
}
