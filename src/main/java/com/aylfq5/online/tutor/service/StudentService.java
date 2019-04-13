package com.aylfq5.online.tutor.service;

import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.entity.TutorDTO;
import com.aylfq5.online.tutor.util.OnlineTutorResult;

/**
 * @Description: ${description}
 * @Author: aylfq5
 * @CreateDate: 2019/3/26 11:18
 * @Version: 1.0
 */
public interface StudentService {
    /**
     * 待选导师列表
     * @param page
     * @param rows
     * @return
     */
    OnlineTutorResult getTutorList(Integer page, Integer rows);

    /**
     * 选择(取消选择)导师
     * @param tutorDTO
     * @return
     */
    OnlineTutorResult chooseMentor(TutorDTO tutorDTO);

    /**
     * 修改学生个人信息
     * @param user
     * @return
     */
    OnlineTutorResult updateByPrimaryKeySelective(User user);

    OnlineTutorResult getVolunteerList();

    OnlineTutorResult getAgreeTutor();
}
