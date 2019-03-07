package com.aylfq5.online.tutor.log;

import com.aylfq5.online.tutor.dao.ExceptionLogMapper;
import com.aylfq5.online.tutor.dao.RequestLogMapper;
import com.aylfq5.online.tutor.domain.ExceptionLog;
import com.aylfq5.online.tutor.domain.RequestLog;
import com.aylfq5.online.tutor.util.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description: aop切面类
 * @Author: aylfq5
 * @CreateDate: 2019/3/1 10:24
 * @Version: 1.0
 */
@Aspect
@Component
public class RequestLogAspect {

    @Resource
    private RequestLogMapper requestLogMapper;
    @Resource
    private ExceptionLogMapper exceptionLogMapper;
    @Resource
    private HttpServletRequest request;

    private RequestLog requestLog = new RequestLog();

    private ExceptionLog exceptionLog = new ExceptionLog();

    private Long startTime;

    private Long returnTime;

    /**
     * 切入点
     * @param operation
     * 此处切入点为所有声明@Operation注解的方法
     */
    @Pointcut(value = "@annotation(operation)")
    public void serviceStatistics(Operation operation) {}

    /**
     * 前置通知
     * @param joinPoint
     * @param operation
     */
    @Before("serviceStatistics(operation)")
    public void doBefore(JoinPoint joinPoint, Operation operation) {
        // 获取切入点参数
        Map<String, Object> joinPointInfo = RequestUtil.getJoinPointInfoMap(joinPoint);
        // 设置请求信息
        startTime = System.currentTimeMillis();
        requestLog.setId(IDUtils.genItemId());
        requestLog.setStartTime(DateUtils.parse(startTime));
        requestLog.setIp(RequestUtil.getRequestIp(request));
        requestLog.setClasspath(joinPointInfo.get("classpath").toString());
        requestLog.setMethodName(joinPointInfo.get("methodName").toString());
        requestLog.setWay(request.getMethod());
        requestLog.setParam((String) joinPointInfo.get("paramMap"));
        requestLog.setType(RequestUtil.getRequestType(request));
        requestLog.setSessionId(request.getSession().getId());
        requestLog.setUrl(request.getRequestURI());
        requestLog.setOperation(operation.value());
    }

    /**
     * 返回通知
     * @param operation
     * @param returnValue
     */
    @AfterReturning(value = "serviceStatistics(operation)", returning = "returnValue")
    public void doAfterReturning(Operation operation, Object returnValue) {
        // 完善请求信息
        returnTime = System.currentTimeMillis();
        requestLog.setReturnTime(DateUtils.parse(returnTime));
        requestLog.setFinishTime(DateUtils.timeDifferLong(startTime, returnTime));
        requestLog.setReturnData(JsonUtils.objectToJson(returnValue));
        // 保存请求日志数据信息
        requestLogMapper.insert(requestLog);
    }

    /**
     * 异常通知
     * @param operation
     * @param e
     */
    @AfterThrowing(value = "serviceStatistics(operation)", throwing = "e")
    public void doAfterThrowing(Operation operation, Throwable e) {
        // 设置异常信息
        long happenTime = System.currentTimeMillis();
        exceptionLog.setId(IDUtils.genItemId());
        exceptionLog.setHappenTime(DateUtils.parse(happenTime));
        String json = JsonUtils.objectToJson(e);
        System.out.println(json);
        exceptionLog.setExceptionJson(JsonUtils.objectToJson(e));
        exceptionLog.setExceptionMessage(e.getMessage());
        // 保存异常日志记录
        exceptionLogMapper.insert(exceptionLog);
    }
}
