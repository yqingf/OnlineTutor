package com.aylfq5.online.tutor.shiro;

import com.aylfq5.online.tutor.constant.UserStatusMsg;
import com.aylfq5.online.tutor.dao.PermissionMapper;
import com.aylfq5.online.tutor.dao.RoleMapper;
import com.aylfq5.online.tutor.dao.UserMapper;
import com.aylfq5.online.tutor.domain.Permission;
import com.aylfq5.online.tutor.domain.Role;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.service.AuthService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/27 9:29
 * @Version: 1.0
 */
public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("权限配置-->ShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();

        if (user.getUserType() == UserStatusMsg.ROLE_ADMIN) {
            // 超级管理员，添加所有角色、添加所有权限
            authorizationInfo.addRole("*");
            authorizationInfo.addStringPermission("*");
        }
        Long userId = user.getId();
        // 获取用户所有角色
        List<Role> roleList = roleMapper.selectByUserId(userId);
        for (Role role : roleList) {
            authorizationInfo.addRole(role.getCode());
            // 获取角色下的权限
            List<Permission> permList = permissionMapper.selectByRoleId(role.getId());
            for (Permission permission : permList) {
                authorizationInfo.addStringPermission(permission.getCode());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("用户登录认证：验证当前Subject时获取到token为：" + token.toString());
        String number = token.getUsername();
        // 通过number从数据库中查询user对象，如果找到
        User user = userMapper.selectByNumber(number);
        if (user == null) {
            // 用户不存在
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(user, DigestUtils.md5Hex(user.getPassword()), getName());
        return authorizationInfo;
    }
}
