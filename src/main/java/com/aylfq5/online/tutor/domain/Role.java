package com.aylfq5.online.tutor.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
* @Description:
* @Author:         aylfq5
* @CreateDate:     2019/4/2 14:12
* @Version:        1.0
*/
public class Role implements Serializable {
    private Long id;

    private String roleName;

    private String description;

    private String code;

    private Long insertUid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Date updateTime;

    private List<RolePermissionKey> rolePerms;

    private Boolean checked;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getInsertUid() {
        return insertUid;
    }

    public void setInsertUid(Long insertUid) {
        this.insertUid = insertUid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<RolePermissionKey> getRolePerms() {
        return rolePerms;
    }

    public void setRolePerms(List<RolePermissionKey> rolePerms) {
        this.rolePerms = rolePerms;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}