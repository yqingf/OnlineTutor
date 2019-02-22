package com.aylfq5.online.tutor.dao;

import com.aylfq5.online.tutor.domain.StudentInfo;

public interface StudentInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
}