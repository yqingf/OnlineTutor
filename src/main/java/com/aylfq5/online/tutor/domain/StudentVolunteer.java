package com.aylfq5.online.tutor.domain;

import java.io.Serializable;
import java.util.Date;

public class StudentVolunteer implements Serializable {
    private Integer id;

    private Integer studentId;

    private Integer tutorId;

    private Boolean volunteerLevel;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTutorId() {
        return tutorId;
    }

    public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
    }

    public Boolean getVolunteerLevel() {
        return volunteerLevel;
    }

    public void setVolunteerLevel(Boolean volunteerLevel) {
        this.volunteerLevel = volunteerLevel;
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