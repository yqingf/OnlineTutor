package com.aylfq5.online.tutor.domain;

import java.io.Serializable;
import java.util.Date;

/**
* @Description:    异常日志实体
* @Author:         aylfq5
* @CreateDate:     2019/3/1 10:19
* @Version:        1.0
*/
public class ExceptionLog implements Serializable {
    /**主键*/
    private Long id;
    /**异常对象json形式*/
    private String exceptionJson;
    /**异常简单信息,相当于e.getMessage()*/
    private String exceptionMessage;
    /**异常产生时间*/
    private Date happenTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExceptionJson() {
        return exceptionJson;
    }

    public void setExceptionJson(String exceptionJson) {
        this.exceptionJson = exceptionJson == null ? null : exceptionJson.trim();
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage == null ? null : exceptionMessage.trim();
    }

    public Date getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }
}