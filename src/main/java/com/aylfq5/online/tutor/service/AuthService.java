package com.aylfq5.online.tutor.service;

import com.aylfq5.online.tutor.domain.Permission;

import java.util.List;

public interface AuthService {
    List<Permission> getUserPerms();
}
