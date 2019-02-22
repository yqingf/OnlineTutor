package com.aylfq5.online.tutor.domain;

import java.io.Serializable;
import java.util.Date;

/**
* @Description:    用户实体
* @Author:         aylfq5
* @CreateDate:     2019/2/22 9:21
* @Version:        1.0
*/
public class User implements Serializable {
    /**ID*/
    private Long id;
    /**姓名*/
    private String name;
    /**性别:1-男, 2-女*/
    private Boolean gender;
    /**学号/教师号*/
    private String number;
    /**密码*/
    private String password;
    /**用户类型:1-学生, 2-导师, 3-管理员*/
    private Integer userType;
    /**手机号*/
    private String cellphone;
    /**QQ*/
    private String qq;
    /**电子邮箱*/
    private String email;
    /**个人简介*/
    private String personalProfile;
    /**创建时间*/
    private Date createTime;
    /**修改时间*/
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile == null ? null : personalProfile.trim();
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
}