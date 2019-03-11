package com.aylfq5.online.tutor.exception;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/7 17:59
 * @Version: 1.0
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String msg) {
        super(msg);
    }
}
