package com.aylfq5.online.tutor.entity;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/4/12 9:36
 * @Version: 1.0
 */
public class UserDTO {
    /**
     * 密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;
    /**
     * 确认密码
     */
    private String confirmPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
