package com.aylfq5.online.tutor.service.impl;

import com.aylfq5.online.tutor.dao.RoleMapper;
import com.aylfq5.online.tutor.dao.UserRoleMapper;
import com.aylfq5.online.tutor.domain.Role;
import com.aylfq5.online.tutor.domain.UserRoleKey;
import com.aylfq5.online.tutor.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/4/3 14:54
 * @Version: 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> selectByUserId(Long id) {
        // 获取所有角色
        List<Role> roleList = roleMapper.selectByExample(null);
        // 获取该用户拥有的角色
        List<UserRoleKey> userRoleKeyList = userRoleMapper.selectByUserId(id);
        for (UserRoleKey userRoleKey : userRoleKeyList) {
            // 设置该用户下的哪些角色是选中状态
            for (Role role : roleList) {
                if (role.getId().longValue() == userRoleKey.getRoleId().longValue()) {
                    role.setChecked(true);
                }
            }
        }
        return roleList;
    }
}
