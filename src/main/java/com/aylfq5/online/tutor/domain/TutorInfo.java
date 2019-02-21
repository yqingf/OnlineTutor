package com.aylfq5.online.tutor.domain;

import java.io.Serializable;
import java.util.Date;

public class TutorInfo implements Serializable {
    private Integer userId;

    private String professionalTitle;

    private String avatar;

    private Byte selectedNumbers;

    private Byte expectedNumbers;

    private String researchDirection;

    private String primaryCourse;

    private String office;

    private String studentRequest;

    private String teachingAndResearchAchievements;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle == null ? null : professionalTitle.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Byte getSelectedNumbers() {
        return selectedNumbers;
    }

    public void setSelectedNumbers(Byte selectedNumbers) {
        this.selectedNumbers = selectedNumbers;
    }

    public Byte getExpectedNumbers() {
        return expectedNumbers;
    }

    public void setExpectedNumbers(Byte expectedNumbers) {
        this.expectedNumbers = expectedNumbers;
    }

    public String getResearchDirection() {
        return researchDirection;
    }

    public void setResearchDirection(String researchDirection) {
        this.researchDirection = researchDirection == null ? null : researchDirection.trim();
    }

    public String getPrimaryCourse() {
        return primaryCourse;
    }

    public void setPrimaryCourse(String primaryCourse) {
        this.primaryCourse = primaryCourse == null ? null : primaryCourse.trim();
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office == null ? null : office.trim();
    }

    public String getStudentRequest() {
        return studentRequest;
    }

    public void setStudentRequest(String studentRequest) {
        this.studentRequest = studentRequest == null ? null : studentRequest.trim();
    }

    public String getTeachingAndResearchAchievements() {
        return teachingAndResearchAchievements;
    }

    public void setTeachingAndResearchAchievements(String teachingAndResearchAchievements) {
        this.teachingAndResearchAchievements = teachingAndResearchAchievements == null ? null : teachingAndResearchAchievements.trim();
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