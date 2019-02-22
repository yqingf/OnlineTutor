package com.aylfq5.online.tutor.dao;

import com.aylfq5.online.tutor.domain.StudentVolunteer;

public interface StudentVolunteerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentVolunteer record);

    int insertSelective(StudentVolunteer record);

    StudentVolunteer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentVolunteer record);

    int updateByPrimaryKey(StudentVolunteer record);
}