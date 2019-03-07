package com.aylfq5.online.tutor.dao;

import com.aylfq5.online.tutor.domain.RequestLog;

public interface RequestLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RequestLog record);

    int insertSelective(RequestLog record);

    RequestLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RequestLog record);

    int updateByPrimaryKeyWithBLOBs(RequestLog record);

    int updateByPrimaryKey(RequestLog record);
}