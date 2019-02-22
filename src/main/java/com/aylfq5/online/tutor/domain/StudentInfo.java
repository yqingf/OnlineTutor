package com.aylfq5.online.tutor.domain;

import java.io.Serializable;
import java.util.Date;

/**
* @Description:    学生信息实体
* @Author:         aylfq5
* @CreateDate:     2019/2/22 9:32
* @Version:        1.0
*/
public class StudentInfo implements Serializable {

    /**学生ID*/
    private Long id;
    /**专业方向*/
    private String professionalDirection;
    /**专业特长*/
    private String specialties;
    /**导师期望*/
    private String tutorExpectation;
    /**志愿序列*/
    private Long volunteerSequence;
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

    public String getProfessionalDirection() {
        return professionalDirection;
    }

    public void setProfessionalDirection(String professionalDirection) {
        this.professionalDirection = professionalDirection == null ? null : professionalDirection.trim();
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

    public Long getVolunteerSequence() {
        return volunteerSequence;
    }

    public void setVolunteerSequence(Long volunteerSequence) {
        this.volunteerSequence = volunteerSequence;
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