package com.aylfq5.online.tutor.service.impl;

import com.aylfq5.online.tutor.dao.StudentInfoMapper;
import com.aylfq5.online.tutor.service.StudentService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/26 11:18
 * @Version: 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentInfoMapper studentInfoMapper;

}
