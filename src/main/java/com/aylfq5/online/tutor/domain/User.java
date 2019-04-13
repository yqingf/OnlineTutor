package com.aylfq5.online.tutor.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    /**主键*/
    private Long id;
    /**姓名*/
    private String name;
    /**性别:1-男, 2-女*/
    private Integer gender;
    /**头像*/
    private String avatar;
    /**学号/教师号*/
    private String number;
    /**密码*/
    private String password;
    /**确认密码*/
    private String confirmPassword;
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
    /**专业/研究方向*/
    private String direction;
    /**专业特长/主讲课程*/
    private String specialties;
    /**导师期望/学生要求*/
    private String tutorExpectation;
    /**导师职称*/
    private String professionalTitle;
    /**已选人数*/
    private Integer selectedNumbers;
    /**预带人数*/
    private Integer expectedNumbers;
    /**办公室*/
    private String office;
    /**验证码*/
    private String code;
    /**教研成果*/
    private String achievements;
    /**版本*/
    private Integer version;
    /**
     * 状态 0-启用，1-停用
     */
    private Integer status;
    /**
     * 角色
     */
    private List<Role> roleList;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties == null ? null : specialties.trim();
    }

    public String getTutorExpectation() {
        return tutorExpectation;
    }

    public void setTutorExpectation(String tutorExpectation) {
        this.tutorExpectation = tutorExpectation == null ? null : tutorExpectation.trim();
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle == null ? null : professionalTitle.trim();
    }

    public Integer getSelectedNumbers() {
        return selectedNumbers;
    }

    public void setSelectedNumbers(Integer selectedNumbers) {
        this.selectedNumbers = selectedNumbers;
    }

    public Integer getExpectedNumbers() {
        return expectedNumbers;
    }

    public void setExpectedNumbers(Integer expectedNumbers) {
        this.expectedNumbers = expectedNumbers;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office == null ? null : office.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements == null ? null : achievements.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
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