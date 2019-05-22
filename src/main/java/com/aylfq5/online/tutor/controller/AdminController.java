package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.domain.Condition;
import com.aylfq5.online.tutor.domain.Role;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.entity.DoubleSelectedResult;
import com.aylfq5.online.tutor.service.RoleService;
import com.aylfq5.online.tutor.service.StudentVolunteerService;
import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import com.aylfq5.online.tutor.util.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/2/26 13:36
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private StudentVolunteerService studentVolunteerService;

    @Operation("后台首页")
    @RequestMapping("index.html")
    public String index() {
        return "admin/index";
    }
    @RequestMapping("welcome.html")
    public String welcome() {
        return "admin/welcome";
    }


    /**
     * 跳转到修改页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/student/edit/{id}")
    public String toEdit(@PathVariable Long id, Model model) {
        OnlineTutorResult result = userService.selectByPrimaryKey(id);
        // 查询所有角色
        List<Role> roleList = roleService.selectByUserId(id);
        model.addAttribute("roleList", roleList);
        model.addAttribute("result", result.getData());
        return "/student/edit";
    }

    /**
     * 双选结果页面
     * @return
     */
    @GetMapping("/list.html")
    public String toDoubleSelectionResult() {
        return "/admin/list";
    }

    /**
     * 双选结果
     * @return
     */
    @GetMapping("/double/selected/result")
    @ResponseBody
    public OnlineTutorResult getDoubleSelectionResult(Condition condition) {
        OnlineTutorResult result = studentVolunteerService.getDoubleSelectionResult(condition);
        return result;
    }

    /**
     * 指派导师页面
     * @return
     */
    @GetMapping("/assign/tutor.html")
    public String assignTutor() {
        return "/admin/assign-tutor";
    }

    /**
     * 没有被老师录取的学生列表
     * @param condition
     * @return
     */
    @GetMapping("/assign/tutor")
    @ResponseBody
    public OnlineTutorResult getNoTutorStudentList(Condition condition) {
        OnlineTutorResult result = userService.getNoTutorStudentList(condition);
        return result;
    }

    /**
     * 指派
     * @return
     */
    @GetMapping("/assign")
    @ResponseBody
    public OnlineTutorResult assignTutor(Long studentId, Long tutorId) {
        OnlineTutorResult result = studentVolunteerService.assignTutor(studentId, tutorId);
        return result;
    }
    /**
     *
     * @return
     */
    @GetMapping("/vacancy/tutor")
    @ResponseBody
    public OnlineTutorResult getVacancyTutor() {
        OnlineTutorResult result = userService.getVacancyTutor();
        return result;
    }
}
