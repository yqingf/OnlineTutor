package com.aylfq5.online.tutor.dao;

import com.aylfq5.online.tutor.domain.StudentVolunteer;

public interface StudentVolunteerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentVolunteer record);

    int insertSelective(StudentVolunteer record);

    StudentVolunteer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentVolunteer record);

    int updateByPrimaryKey(StudentVolunteer record);
}