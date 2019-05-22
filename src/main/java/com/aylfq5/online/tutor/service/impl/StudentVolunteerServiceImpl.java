package com.aylfq5.online.tutor.service.impl;

import com.aylfq5.online.tutor.constant.ResponseStatusCode;
import com.aylfq5.online.tutor.dao.StudentVolunteerMapper;
import com.aylfq5.online.tutor.dao.UserMapper;
import com.aylfq5.online.tutor.domain.Condition;
import com.aylfq5.online.tutor.domain.StudentVolunteer;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.entity.DoubleSelectedResult;
import com.aylfq5.online.tutor.service.StudentVolunteerService;
import com.aylfq5.online.tutor.util.IDUtils;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/4/25 15:24
 * @Version: 1.0
 */
@Service
public class StudentVolunteerServiceImpl implements StudentVolunteerService {

    @Resource
    private StudentVolunteerMapper studentVolunteerMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public OnlineTutorResult getDoubleSelectionResult(Condition condition) {
        Integer page = condition.getPage();
        Integer rows = condition.getRows();
        PageHelper.startPage(page == null ? 1 : page, rows == null ? 20 : rows);
        List<DoubleSelectedResult> resultList = studentVolunteerMapper.getDoubleSelectionResult(condition);
        PageInfo pageInfo = new PageInfo(resultList);
        long total = pageInfo.getTotal();
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "ok", (int) total, resultList);
    }

    @Override
    public OnlineTutorResult assignTutor(Long studentId, Long tutorId) {
        StudentVolunteer exist = studentVolunteerMapper.selectAgreedByStudentId(studentId);
        if (exist != null) {
            return OnlineTutorResult.error("该学生已有导师！");
        }
        User user = userMapper.selectByPrimaryKey(tutorId);
        int count = studentVolunteerMapper.getAgreeCountByTutorId(tutorId);
        Integer numbers = user.getExpectedNumbers() == null ? 0 : user.getExpectedNumbers();
        if (numbers == 0 || numbers <= count) {
            return OnlineTutorResult.error("导师名额已满！");
        }
        StudentVolunteer studentVolunteer = new StudentVolunteer();
        studentVolunteer.setId(IDUtils.genItemId());
        studentVolunteer.setStudentId(studentId);
        studentVolunteer.setTutorId(tutorId);
        studentVolunteer.setVolunteerStatus(3);
        studentVolunteer.setVolunteerLevel(6);
        int i = studentVolunteerMapper.insertSelective(studentVolunteer);
        if (i > 0) {
            return OnlineTutorResult.build(200, "指派成功！");
        }
        return OnlineTutorResult.error("指派失败！");
    }
}
