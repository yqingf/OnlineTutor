package com.aylfq5.online.tutor.domain;

import java.io.Serializable;
import java.util.Date;
/**
* @Description:    导师信息实体
* @Author:         aylfq5
* @CreateDate:     2019/2/22 9:32
* @Version:        1.0
*/
public class TutorInfo implements Serializable {

    /**导师ID*/
    private Long id;
    /**职称*/
    private String professionalTitle;
    /**头像*/
    private String avatar;
    /**已选人数*/
    private Integer selectedNumbers;
    /**预带人数*/
    private Integer expectedNumbers;
    /**研究方向*/
    private String researchDirection;
    /**主讲课程*/
    private String primaryCourse;
    /**办公室*/
    private String office;
    /**学生要求*/
    private String studentRequest;
    /**教研成果*/
    private String teachingAndResearchAchievements;
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