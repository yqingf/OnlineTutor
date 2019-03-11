package com.aylfq5.online.tutor.exception;

import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

import static com.aylfq5.online.tutor.constant.ResponseStatusCode.*;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/7 17:47
 * @Version: 1.0
 */
@ControllerAdvice
@ResponseBody
public class CommonExceptionAdvice extends RuntimeException {

    private static Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public OnlineTutorResult handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.error("参数缺失错误！", e);
        return OnlineTutorResult.build(MISSING_REQUEST_PARAMETER_EXCEPTION, "参数缺失错误!");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public OnlineTutorResult handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败!", e);
        return OnlineTutorResult.build(HTTP_MESSAGE_NOT_READABLE_EXCEPTION, "参数解析失败!");
    }

    /**
     * 4003 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public OnlineTutorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("参数验证失败!", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        return OnlineTutorResult.build(METHOD_ARGUMENT_NOT_VALID_EXCEPTION, "参数验证失败!" + message);
    }

    /**
     * 4007 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public OnlineTutorResult handleBindException(BindException e) {
        logger.error("参数绑定失败!", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        return OnlineTutorResult.build(REQUEST_PARAMETER_BIND_EXCEPTION, "参数绑定失败!" + message);
    }


    /**
     * 4008 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public OnlineTutorResult handleServiceException(ConstraintViolationException e) {
        logger.error("违反约束异常!", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        return OnlineTutorResult.build(CONSTRAINT_VIOLATION_EXCEPTION, "违反约束异常!" + message);
    }

    /**
     * 4006 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public OnlineTutorResult handleValidationException(ValidationException e) {
        logger.error("参数验证失败!", e);
        return OnlineTutorResult.build(4006, "参数验证失败");
    }

    /**
     * 4004 - Not Found
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public OnlineTutorResult noHandlerFoundException(NoHandlerFoundException e) {
        logger.error("Not Found", e);
        return OnlineTutorResult.build(NO_HANDLER_FOUND_EXCEPTION, "Not Handle Found");
    }


    /**
     * 4005 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public OnlineTutorResult handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法!", e);
        return OnlineTutorResult.build(REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION, "request_method_not_supported");
    }

    /**
     * 4015 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public OnlineTutorResult handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        logger.error("不支持当前媒体类型", e);
        return OnlineTutorResult.build(CONTENT_TYPE_NOT_SUPPORTED_EXCEPTION, "content_type_not_supported");
    }

    /**
     * 业务层需要自己声明异常的情况
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServiceException.class)
    public OnlineTutorResult handleServiceException(ServiceException e) {
        logger.error("业务逻辑异常!", e);
        return OnlineTutorResult.build(SERVICE_EXCEPTION, "业务逻辑异常");
    }

    /**
     * 操作数据或库出现异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataDoException.class)
    public OnlineTutorResult handleException(DataDoException e) {
        logger.error("操作数据库出现异常:", e);
        return OnlineTutorResult.build(DATA_DAO_EXCEPTION, "操作数据库出现异常：字段重复、有外键关联等");
    }

    /**
     * 获取其它异常。包括500
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public OnlineTutorResult defaultErrorHandler(Exception e) {
        logger.error("Exception", e);
        return OnlineTutorResult.build(OTHER_EXCEPTION, "其他异常！");

    }
}
