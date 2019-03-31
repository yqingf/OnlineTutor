package com.aylfq5.online.tutor.constant;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/8 14:12
 * @Version: 1.0
 */
public class ResponseStatusCode {
    public static final Integer SUCCESS = 200;

    private ResponseStatusCode() {}

    /**
     * 请求参数缺失
     */
    public static final int MISSING_REQUEST_PARAMETER_EXCEPTION = 4001;
    /**
     * 参数解析异常
     */
    public static final int HTTP_MESSAGE_NOT_READABLE_EXCEPTION = 4002;
    /**
     * 方法参数验证异常
     */
    public static final int METHOD_ARGUMENT_NOT_VALID_EXCEPTION = 4003;
    /**
     * 未找到处理器异常
     */
    public static final int NO_HANDLER_FOUND_EXCEPTION = 4004;
    /**
     * 请求方式异常
     */
    public static final int REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION = 4005;
    /**
     * 参数绑定异常
     */
    public static final int REQUEST_PARAMETER_BIND_EXCEPTION = 4007;
    /**
     * 违反约束异常
     */
    public static final int CONSTRAINT_VIOLATION_EXCEPTION = 4008;
    /**
     * 业务层异常
     */
    public static final int SERVICE_EXCEPTION = 4010;
    /**
     * 数据层异常
     */
    public static final int DATA_DAO_EXCEPTION = 4011;
    /**
     * 不支持的媒体类型
     */
    public static final int CONTENT_TYPE_NOT_SUPPORTED_EXCEPTION = 4015;
    /**
     * 其他类型异常，包括500
     */
    public static final int OTHER_EXCEPTION = 500;
}
