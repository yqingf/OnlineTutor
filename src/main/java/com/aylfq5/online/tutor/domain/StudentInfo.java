package com.aylfq5.online.tutor.domain;

import java.io.Serializable;
import java.util.Date;

public class StudentInfo implements Serializable {
    private Integer id;

    private String professionalDirection;

    private String specialties;

    private String tutorExpectation;

    private Long volunteerSequence;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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