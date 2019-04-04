package com.aylfq5.online.tutor.constant;

/**
 * @Description: 用户类型
 * @Author: aylfq5
 * @CreateDate: 2019/2/28 17:19
 * @Version: 1.0
 */
public interface UserStatusMsg {
    /**
     * 学生
     */
    int ROLE_STUDENT = 1;
    /**
     * 学生
     */
    int ROLE_TUTOR = 2;
    /**
     * 管理员
     */
    int ROLE_ADMIN = 3;

    int getCode();

    String getMsg();

    /**
     * @Description: ${description}
     * @Author: aylfq5
     * @CreateDate: 2019/4/2 14:27
     * @Version: 1.0
     */
    enum SystemStatus implements UserStatusMsg {
        /**
         * 请求成功
         */
        SUCCESS(200, "SUCCESS"),
        /**
         * 请求失败
         */
        ERROR(1001, "ERROR"),
        /**
         * 请求参数有误
         */
        PARAM_ERROR(1002, "PARAM_ERROR"),

        /**
         * 成功匹配
         */
        SUCCESS_MATCH(1003, "SUCCESS_MATCH"),
        /**
         * 未登录
         */
        NO_LOGIN(1100, "NO_LOGIN"),
        /**
         * 未注册
         */
        NO_REGISTER(1101, "NO_REGISTER"),
        /**
         * 用户信息或权限已更新(需退出重新登录)
         */
        UPDATE(1102, "UPDATE");
        /**
         * 状态码
         */
        private int code;
        /**
         * 响应消息
         */
        private String msg;

        SystemStatus(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        @Override
        public int getCode() {
            return this.code;
        }

        @Override
        public String getMsg() {
            return this.msg;
        }
    }
}
