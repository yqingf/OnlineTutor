package com.aylfq5.online.tutor.domain;

import java.io.Serializable;
import java.util.Date;

/**
* @Description:    学生志愿实体类
* @Author:         aylfq5
* @CreateDate:     2019/2/22 9:32
* @Version:        1.0
*/
public class StudentVolunteer implements Serializable {

    /**ID*/
    private Long id;
    /**学生ID*/
    private Long studentId;
    /**导师ID*/
    private Long tutorId;
    /**志愿等级*/
    private Boolean volunteerLevel;
    /**处理状态:1-未处理, 2-已驳回, 3-已接受*/
    private Integer volunteerStatus;
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public Boolean getVolunteerLevel() {
        return volunteerLevel;
    }

    public void setVolunteerLevel(Boolean volunteerLevel) {
        this.volunteerLevel = volunteerLevel;
    }

    public Integer getVolunteerStatus() {
        return volunteerStatus;
    }

    public void setVolunteerStatus(Integer volunteerStatus) {
        this.volunteerStatus = volunteerStatus;
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