package com.aylfq5.online.tutor.service;

import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.entity.VolunteerDTO;
import com.aylfq5.online.tutor.util.OnlineTutorResult;

/**
 * @Description: ${description}
 * @Author: aylfq5
 * @CreateDate: 2019/3/15 9:06
 * @Version: 1.0
 */
public interface TutorService {

    /**
     * 导师详情
     *
     * @param id
     * @return
     */
    OnlineTutorResult getTutorDetailById(Long id);

    /**
     * 学生志愿列表
     *
     * @return
     */
    OnlineTutorResult getVolunteerList();

    /**
     * 接收或拒绝学生申请
     *
     * @param volunteerDTO
     * @return
     */
    OnlineTutorResult chooseOrRefuse(VolunteerDTO volunteerDTO);

    /**
     * 我的学生列表
     *
     * @return
     */
    OnlineTutorResult getStudentList();

    OnlineTutorResult updateByPrimaryKeySelective(User user);
}
