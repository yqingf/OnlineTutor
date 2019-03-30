package com.aylfq5.online.tutor.service.impl;

import com.aylfq5.online.tutor.dao.PermissionMapper;
import com.aylfq5.online.tutor.domain.Permission;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.service.AuthService;
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
}
