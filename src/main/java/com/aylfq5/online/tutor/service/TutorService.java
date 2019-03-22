package com.aylfq5.online.tutor.service;

import com.aylfq5.online.tutor.util.OnlineTutorResult;

/**
* @Description:    ${description}
* @Author:         aylfq5
* @CreateDate:     2019/3/15 9:06
* @Version:        1.0
*/
public interface TutorService {
    OnlineTutorResult getTutorList();

    OnlineTutorResult getTutorDetailById(Long id);
}
