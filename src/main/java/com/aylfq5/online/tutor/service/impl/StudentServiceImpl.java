package com.aylfq5.online.tutor.service.impl;

import com.aylfq5.online.tutor.constant.ResponseMsg;
import com.aylfq5.online.tutor.constant.ResponseStatusCode;
import com.aylfq5.online.tutor.dao.StudentInfoMapper;
import com.aylfq5.online.tutor.dao.StudentVolunteerMapper;
import com.aylfq5.online.tutor.dao.UserMapper;
import com.aylfq5.online.tutor.domain.StudentVolunteer;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.entity.TutorDTO;
import com.aylfq5.online.tutor.entity.VolunteerDTO;
import com.aylfq5.online.tutor.service.StudentService;
import com.aylfq5.online.tutor.util.IDUtils;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MissingServletRequestParameterException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    @Resource
    private StudentVolunteerMapper studentVolunteerMapper;
    @Resource
    private UserMapper userMapper;
    @Override
    public OnlineTutorResult getTutorList(Integer page, Integer rows) {
        // 获取当前用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PageHelper.startPage(page == null ? 1 : page, rows == null ? 20 : rows);
        // 获取导师列表
        List<TutorDTO> tutorList = studentInfoMapper.getTutorList();
        // 遍历
        for (TutorDTO tutorDTO : tutorList) {
            // 获取已选择导师人数
            int volunteerNumbers = studentVolunteerMapper.getCountByTutorId(tutorDTO.getId());
            tutorDTO.setVolunteerNumbers(volunteerNumbers);
            // 获取导师已确认的人数
            int selectedCount = studentVolunteerMapper.getAgreeCountByTutorId(tutorDTO.getId());
            tutorDTO.setSelectedNumbers(selectedCount);
            // 查看是否选择
            StudentVolunteer studentVolunteer = studentVolunteerMapper.selectByTutorIdAndStudentId(tutorDTO.getId(), user.getId(), null);
            // 未选择
            tutorDTO.setChecked(2);
            if(studentVolunteer != null) {
                // 已选择
                tutorDTO.setChecked(1);
            }
        }
        PageInfo pageInfo = new PageInfo(tutorList);
        long total = pageInfo.getTotal();
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "ok", (int) total, tutorList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OnlineTutorResult chooseMentor(TutorDTO tutorDTO) {
        if (tutorDTO.getId() == null) {
            return OnlineTutorResult.error("请求参数缺失！");
        }
        // 获取当前用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        // 获取用户当前选择过的导师
        List<StudentVolunteer> studentVolunteers = studentVolunteerMapper.selectByStudentId(user.getId());

        // 选择导师
        if (tutorDTO.getChecked() == 1) {
            // 判断是否有导师已经同意该学生选择
            StudentVolunteer selected = studentVolunteerMapper.selectAgreedByStudentId(user.getId());
            if (selected != null) {
                return OnlineTutorResult.error("已有导师同意您的选择，不能再选！");
            }
            if (studentVolunteers.size() == 5) {
                return OnlineTutorResult.error("您的志愿数量已达5个，不能再选！");
            }
            // 导师指标是否已满
            int agreeCount = studentVolunteerMapper.getAgreeCountByTutorId(tutorDTO.getId());
            User tutor = userMapper.selectByPrimaryKey(tutorDTO.getId());
            if (agreeCount >= tutor.getExpectedNumbers()) {
                return OnlineTutorResult.error("该导师指标已满，请您选择其他导师！");
            }
            // 插入记录
            StudentVolunteer studentVolunteer = new StudentVolunteer();
            studentVolunteer.setId(IDUtils.genItemId());
            studentVolunteer.setStudentId(user.getId());
            studentVolunteer.setTutorId(tutorDTO.getId());
            studentVolunteer.setVolunteerStatus(1);
            // 志愿等级
            studentVolunteer.setVolunteerLevel(studentVolunteers.size() + 1);
            studentVolunteerMapper.insertSelective(studentVolunteer);
            return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "操作成功！");
        }
        // 取消选择
        if (tutorDTO.getChecked() == 2) {
            // 判断当前老师是否已经同意
            StudentVolunteer studentVolunteer = studentVolunteerMapper.selectByTutorIdAndStudentId(tutorDTO.getId(), user.getId(), 3);
            if (studentVolunteer != null) {
                return OnlineTutorResult.error("该导师已经同意您的选择，不能退选！");
            }
            studentVolunteer = studentVolunteerMapper.selectByTutorIdAndStudentId(tutorDTO.getId(), user.getId(), null);
            StudentVolunteer curr = studentVolunteer;
            if (studentVolunteers.size() > studentVolunteer.getVolunteerLevel()) {
                Iterator<StudentVolunteer> iterator = studentVolunteers.subList(studentVolunteer.getVolunteerLevel(), studentVolunteers.size()).iterator();
                while (iterator.hasNext()) {
                    StudentVolunteer next = iterator.next();
                    Integer level = next.getVolunteerLevel();
                    next.setVolunteerLevel(curr.getVolunteerLevel());
                    curr.setVolunteerLevel(level);
                    studentVolunteerMapper.updateByPrimaryKeySelective(next);
                }
            }
            int res = studentVolunteerMapper.deleteByPrimaryKey(studentVolunteer.getId());
            if (res <= 0) {
                return OnlineTutorResult.error("取消失败！");
            }
        }
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "操作成功！");
    }

    @Override
    public OnlineTutorResult updateByPrimaryKeySelective(User user) {
        int res = userMapper.updateByPrimaryKeySelective(user);
        if (res <= 0) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, ResponseMsg.UPDATE_FAIL);
        }
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, ResponseMsg.UPDATE_SUCCESS);
    }

    @Override
    public OnlineTutorResult getVolunteerList() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<VolunteerDTO> volunteerList = studentVolunteerMapper.getByStudentId(user.getId());
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "ok", volunteerList.size(), volunteerList);
    }

    @Override
    public OnlineTutorResult getAgreeTutor() {
        // 获取当前用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        // 获取被同意的志愿
        StudentVolunteer studentVolunteer = studentVolunteerMapper.selectAgreedByStudentId(user.getId());
        if (studentVolunteer == null) {
            return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "ok",0);
        }
        // 获取导师信息
        User tutor = userMapper.selectByPrimaryKey(studentVolunteer.getTutorId());
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "ok", 1, new User[]{tutor});
    }
}
