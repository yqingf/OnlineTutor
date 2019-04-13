package com.aylfq5.online.tutor.entity;

import java.io.Serializable;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/4/10 10:53
 * @Version: 1.0
 */
public class VolunteerDTO implements Serializable {

    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 电话
     */
    private String cellphone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 志愿序列
     */
    private Integer volunteerSequences;
    /**
     * 志愿状态
     */
    private Integer status;
    /**
     * 班级
     */
    private String office;
    /**
     * 专业
     */
    private String direction;

    /**
     * 版本
     */
    private Integer version;

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
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getVolunteerSequences() {
        return volunteerSequences;
    }

    public void setVolunteerSequences(Integer volunteerSequences) {
        this.volunteerSequences = volunteerSequences;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
