package com.aylfq5.online.tutor.dao;

import com.aylfq5.online.tutor.domain.ExceptionLog;

public interface ExceptionLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExceptionLog record);

    int insertSelective(ExceptionLog record);

    ExceptionLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExceptionLog record);

    int updateByPrimaryKey(ExceptionLog record);
}