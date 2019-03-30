package com.aylfq5.online.tutor.domain;

import java.io.Serializable;

public class RolePermissionKey implements Serializable {
    private Long permitId;

    private Long roleId;

    private static final long serialVersionUID = 1L;

    public Long getPermitId() {
        return permitId;
    }

    public void setPermitId(Long permitId) {
        this.permitId = permitId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}