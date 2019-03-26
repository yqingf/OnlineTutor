package com.aylfq5.online.tutor.service.impl;

import com.aylfq5.online.tutor.dao.TutorInfoMapper;
import com.aylfq5.online.tutor.domain.TutorInfo;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.service.TutorService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/15 9:11
 * @Version: 1.0
 */
@Service
public class TutorServiceImpl implements TutorService {

    @Resource
    private TutorInfoMapper tutorInfoMapper;

    @Override
    public OnlineTutorResult getTutorDetailById(Long id) {
        TutorInfo info = tutorInfoMapper.selectByPrimaryKey(id);
        return OnlineTutorResult.ok(info);
    }
}
