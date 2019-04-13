package com.aylfq5.online.tutor.entity;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/4/9 10:27
 * @Version: 1.0
 */
public class TutorDTO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 预带人数
     */
    private Integer expectedNumbers;
    /**
     * 志愿填报人数
     */
    private Integer volunteerNumbers;
    /**
     * 已选人数
     */
    private Integer selectedNumbers;
    /**
     * 是否选择
     * 1：已选择
     * 2: 未选择
     */
    private Integer checked;

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

    public Integer getExpectedNumbers() {
        return expectedNumbers;
    }

    public void setExpectedNumbers(Integer expectedNumbers) {
        this.expectedNumbers = expectedNumbers;
    }

    public Integer getSelectedNumbers() {
        return selectedNumbers;
    }

    public void setSelectedNumbers(Integer selectedNumbers) {
        this.selectedNumbers = selectedNumbers;
    }

    public Integer getVolunteerNumbers() {
        return volunteerNumbers;
    }

    public void setVolunteerNumbers(Integer volunteerNumbers) {
        this.volunteerNumbers = volunteerNumbers;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
