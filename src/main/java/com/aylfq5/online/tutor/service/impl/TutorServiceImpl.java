package com.aylfq5.online.tutor.service.impl;

import com.alibaba.druid.sql.dialect.mysql.ast.MysqlForeignKey;
import com.aylfq5.online.tutor.constant.ResponseMsg;
import com.aylfq5.online.tutor.constant.ResponseStatusCode;
import com.aylfq5.online.tutor.dao.StudentVolunteerMapper;
import com.aylfq5.online.tutor.dao.TutorInfoMapper;
import com.aylfq5.online.tutor.dao.UserMapper;
import com.aylfq5.online.tutor.domain.StudentVolunteer;
import com.aylfq5.online.tutor.domain.TutorInfo;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.entity.VolunteerDTO;
import com.aylfq5.online.tutor.service.TutorService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.apache.shiro.SecurityUtils;
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
    @Resource
    private StudentVolunteerMapper studentVolunteerMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public OnlineTutorResult getTutorDetailById(Long id) {
        TutorInfo info = tutorInfoMapper.selectByPrimaryKey(id);
        return OnlineTutorResult.ok(info);
    }

    @Override
    public OnlineTutorResult getVolunteerList() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<VolunteerDTO> volunteerList = studentVolunteerMapper.getByTutorId(user.getId());
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "ok", volunteerList.size(), volunteerList);
    }

    @Override
    public OnlineTutorResult chooseOrRefuse(VolunteerDTO volunteerDTO) {

        if (volunteerDTO.getId() == null || volunteerDTO.getStatus() == null) {
            return OnlineTutorResult.error("请求参数缺失！");
        }
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        StudentVolunteer studentVolunteer = studentVolunteerMapper.selectByTutorIdAndStudentId(user.getId(), volunteerDTO.getId(), null);
        // 如果拒绝
        if (volunteerDTO.getStatus() == 2) {
            // 该状态为已拒绝
            studentVolunteer.setVolunteerStatus(2);
            int res = studentVolunteerMapper.updateByPrimaryKeySelective(studentVolunteer);
            if (res <= 0) {
                return OnlineTutorResult.error("当前数据有误，请刷新后重试！");
            }
            return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "操作成功！");
        }
        // 如果接受
        if (volunteerDTO.getStatus() == 3) {

            // 判断是否有导师已经同意该生申请
            StudentVolunteer agreed = studentVolunteerMapper.selectAgreedByStudentId(volunteerDTO.getId());
            if (agreed!= null) {
                return OnlineTutorResult.error("该生已被其他老师接收");
            }

            // 该状态为已接受
            studentVolunteer.setVolunteerStatus(3);
            int res = studentVolunteerMapper.updateByPrimaryKeyVersionSelective(studentVolunteer);
            if (res <= 0) {
                return OnlineTutorResult.error("当前数据有误，请刷新后重试！");
            }
            return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "操作成功！");
        }
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "操作成功！");
    }

    @Override
    public OnlineTutorResult getStudentList() {
        // 获取当前导师
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        // 根据导师获取学生
        List<User> userList = studentVolunteerMapper.getAgreeByTutorId(user.getId());
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "ok",userList.size(), userList);
    }

    @Override
    public OnlineTutorResult updateByPrimaryKeySelective(User user) {
        int res = userMapper.updateByPrimaryKeySelective(user);
        if (res <= 0) {
            return OnlineTutorResult.build(ResponseStatusCode.DATA_DAO_EXCEPTION, ResponseMsg.UPDATE_FAIL);
        }
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, ResponseMsg.UPDATE_SUCCESS);
    }
}
