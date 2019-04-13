package com.aylfq5.online.tutor.dao;

import com.aylfq5.online.tutor.domain.StudentVolunteer;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.entity.VolunteerDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentVolunteerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentVolunteer record);

    int insertSelective(StudentVolunteer record);

    StudentVolunteer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentVolunteer record);

    int updateByPrimaryKey(StudentVolunteer record);

    int getCountByTutorId(Long tutorId);

    int getAgreeCountByTutorId(Long tutorId);

    StudentVolunteer selectByTutorIdAndStudentId(@Param("tutorId") Long tutorId, @Param("studentId") Long studentId, @Param("status") Integer status);

    List<StudentVolunteer> selectByStudentId(Long studentId);

    StudentVolunteer selectAgreedByStudentId(Long id);

    List<VolunteerDTO> getByStudentId(Long studentId);

    List<VolunteerDTO> getByTutorId(Long tutorId);

    int updateByPrimaryKeyVersionSelective(StudentVolunteer studentVolunteer);

    List<User> getAgreeByTutorId(Long tutorId);
}