package com.aylfq5.online.tutor.entity;

/**
 * @Description: 双选结果
 * @Author: aylfq5
 * @CreateDate: 2019/4/25 15:17
 * @Version: 1.0
 */
public class DoubleSelectedResult {

    /**
     * 导师ID
     */
    private String tutorId;
    /**
     * 导师名字
     */
    private String tutorname;

    /**
     * 导师电话
     */
    private String tutorphone;

    private String stuId;
    /**
     * 学生名字
     */
    private String stuname;

    /**
     * 班级
     */
    private String office;
    /**
     * 学生电话
     */
    private String stuphone;

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorname() {
        return tutorname;
    }

    public void setTutorname(String tutorname) {
        this.tutorname = tutorname;
    }

    public String getTutorphone() {
        return tutorphone;
    }

    public void setTutorphone(String tutorphone) {
        this.tutorphone = tutorphone;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuphone() {
        return stuphone;
    }

    public void setStuphone(String stuphone) {
        this.stuphone = stuphone;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
