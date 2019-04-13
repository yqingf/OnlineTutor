package com.aylfq5.online.tutor.service;

import com.aylfq5.online.tutor.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> selectByUserId(Long id);
}
