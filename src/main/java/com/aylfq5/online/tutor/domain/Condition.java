package com.aylfq5.online.tutor.domain;

/**
 * @Description: 组合查询条件
 * @Author: aylfq5
 * @CreateDate: 2019/4/12 10:25
 * @Version: 1.0
 */
public class Condition {
    /**
     * 姓名
     */
    private String name;
    /**
     * 职工号
     */
    private String number;

    /**
     * 性别 1-男， 2-女
     */
    private Integer gender;
    /**
     * 专业
     */
    private String direction;
    /**
     * 班级
     */
    private String office;
    /**
     * 职称
     */
    private String professionalTitle;

    /**
     * 类型 1-学生
     * 2-老师
     */
    private Integer type;
    /**
     * 状态 0-启用， 1-停用
     */
    private Integer status;
    /**
     * 当前页码
     */
    private Integer page;
    /**
     * 每页记录数
     */
    private Integer rows;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
