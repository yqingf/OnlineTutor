package com.aylfq5.online.tutor.domain;

import java.io.Serializable;
import java.util.Date;

/**
* @Description:    日志实体
* @Author:         aylfq5
* @CreateDate:     2019/3/1 10:08
* @Version:        1.0
*/
public class RequestLog implements Serializable {
    /**主键*/
    private Long id;
    /**请求ip*/
    private String ip;
    /**请求地址*/
    private String url;
    /**请求方式: 1-普通请求, 2-ajax请求*/
    private Integer type;
    /**请求方式,get,post等*/
    private String way;
    /**请求执行的类路径*/
    private String classpath;
    /**请求方法名*/
    private String methodName;
    /**请求参数,json格式*/
    private String param;
    /**操作类型*/
    private String operation;
    /**请求开始时间*/
    private Date startTime;
    /**请求完成时间,毫秒值*/
    private Long finishTime;
    /**接口返回时间*/
    private Date returnTime;
    /**接口返回值*/
    private String returnData;
    /**请求接口唯一标识*/
    private String sessionId;
    /***/
    private static final long serialVersionUID = 1L;
    /***/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way == null ? null : way.trim();
    }

    public String getClasspath() {
        return classpath;
    }

    public void setClasspath(String classpath) {
        this.classpath = classpath == null ? null : classpath.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData == null ? null : returnData.trim();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }
}