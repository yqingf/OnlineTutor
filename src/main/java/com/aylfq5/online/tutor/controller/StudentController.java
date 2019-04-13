package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.domain.Condition;
import com.aylfq5.online.tutor.domain.Role;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.entity.TutorDTO;
import com.aylfq5.online.tutor.service.RoleService;
import com.aylfq5.online.tutor.service.StudentService;
import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 学生管理Controller
 * @Author: aylfq5
 * @CreateDate: 2019/2/28 9:06
 * @Version: 1.0
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    @RequestMapping("add.html")
    public String toTutorAdd() {
        return "/student/add";
    }

    /**
     * 学生详情
     *
     * @param id
     * @return
     */
    @GetMapping("/v1/{id}")
    public String toDetail(@PathVariable String id, Model model) {
        OnlineTutorResult result = userService.selectByPrimaryKey(Long.parseLong(id));
        model.addAttribute("result", result.getData());
        return "/student/detail";
    }

    /**
     * 跳转到修改页面
     *
     * @param model
     * @return
     */
    @GetMapping("/v1/edit.html")
    public String toEdit(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        OnlineTutorResult result = userService.selectByPrimaryKey(user.getId());
        model.addAttribute("result", result.getData());
        return "/student/info-edit";
    }

    /**
     * 学生个人信息修改
     *
     * @param user
     * @return
     */
    @PutMapping("/v1")
    @ResponseBody
    public OnlineTutorResult update(User user) {
        OnlineTutorResult result = studentService.updateByPrimaryKeySelective(user);
        return result;
    }

    /**
     * 学生列表页面
     *
     * @return
     */
    @RequestMapping("/list.html")
    public String toStudentList() {
        return "/student/list";
    }

    /**
     * 获取学生列表数据
     *
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public OnlineTutorResult getTutorList(Condition condition) {
        OnlineTutorResult result = userService.getUserList(condition);
        return result;
    }

    /**
     * 备选导师页面
     *
     * @return
     */
    @RequestMapping("/tutor/list.html")
    public String toTutorList() {
        return "/student/tutor-list";
    }

    /**
     * 备选导师列表
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/tutor/list")
    @ResponseBody
    public OnlineTutorResult tutorList(Integer page, Integer rows) {
        OnlineTutorResult result = studentService.getTutorList(page, rows);
        return result;
    }


    /**
     * 选择（取消选择）导师
     *
     * @param tutorDTO
     * @return
     */
    @PostMapping("/choose/mentor")
    @ResponseBody
    public OnlineTutorResult chooseMentor(TutorDTO tutorDTO) {
        OnlineTutorResult result = studentService.chooseMentor(tutorDTO);
        return result;
    }

    /**
     * 学生志愿列表
     *
     * @return
     */
    @RequestMapping("/volunteer/list.html")
    public String toVolunteerList() {
        return "/student/volunteer-list";
    }

    /**
     * 学生志愿列表
     * @return
     */
    @GetMapping("/volunteer/list")
    @ResponseBody
    public OnlineTutorResult volunteerList() {
        OnlineTutorResult result = studentService.getVolunteerList();
        return result;
    }

    /**
     * 我的双选结果页面
     * @return
     */
    @GetMapping("/result.html")
    public String toResult() {
        return "/student/result";
    }

    /**
     * 我的双选结果
     * @return
     */
    @GetMapping("/result")
    @ResponseBody
    public OnlineTutorResult result() {
        OnlineTutorResult result = studentService.getAgreeTutor();
        return result;
    }
}
