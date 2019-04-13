package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.domain.Condition;
import com.aylfq5.online.tutor.domain.Role;
import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.entity.VolunteerDTO;
import com.aylfq5.online.tutor.service.RoleService;
import com.aylfq5.online.tutor.service.TutorService;
import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 导师Controller
 * @Author: aylfq5
 * @CreateDate: 2019/2/28 8:59
 * @Version: 1.0
 */
@Controller
@RequestMapping("/tutor")
public class TutorController {

    @Resource
    private UserService userService;
    @Resource
    private TutorService tutorService;
    @Resource
    private RoleService roleService;


    @RequestMapping("add.html")
    public String toTutorAdd() {
        return "/tutor/add";
    }

    /**
     * 导师详情
     *
     * @param id
     * @return
     */
    @GetMapping("/v1/{id}")
    public String toDetail(@PathVariable String id, Model model) {
        OnlineTutorResult result = userService.selectByPrimaryKey(Long.parseLong(id));
        model.addAttribute("result", result.getData());
        return "/tutor/detail";
    }
    /**
     * 跳转到个人信息修改页面
     *
     * @param model
     * @return
     */
    @GetMapping("/v1/edit.html")
    public String toEdit(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        OnlineTutorResult result = userService.selectByPrimaryKey(user.getId());
        model.addAttribute("result", result.getData());
        return "/tutor/info-edit";
    }


    @PutMapping("/v1")
    @ResponseBody
    public OnlineTutorResult update(User user) {
        OnlineTutorResult result = tutorService.updateByPrimaryKeySelective(user);
        return result;
    }


    /**
     * 跳转到修改页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/v1/edit/{id}")
    public String toEdit(@PathVariable Long id, Model model) {
        OnlineTutorResult result = userService.selectByPrimaryKey(id);
        // 查询所有角色
        List<Role> roleList = roleService.selectByUserId(id);
        model.addAttribute("roleList", roleList);
        model.addAttribute("result", result.getData());
        return "/tutor/edit";
    }

    /**
     * 导师列表页面
     *
     * @return
     */
    @RequestMapping("list.html")
    public String toTutorList() {
        return "/tutor/list";
    }

    /**
     * 导师列表数据
     *
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public OnlineTutorResult getTutorList(Condition condition) {
        OnlineTutorResult result = userService.getUserList(condition);
        return result;
    }

    /**
     * 志愿列表页面
     *
     * @return
     */
    @RequestMapping("/volunteer/list.html")
    public String toVolunteerList() {
        return "/tutor/volunteer-list";
    }

    /**
     * 学生志愿列表
     *
     * @return
     */
    @GetMapping("/volunteer/list")
    @ResponseBody
    public OnlineTutorResult getVolunteerList() {
        OnlineTutorResult result = tutorService.getVolunteerList();
        return result;
    }

    /**
     * 接收或拒绝学生
     *
     * @param volunteerDTO
     * @return
     */
    @PostMapping("/choose/student")
    @ResponseBody
    public OnlineTutorResult chooseOrRefuse(VolunteerDTO volunteerDTO) {
        OnlineTutorResult result = tutorService.chooseOrRefuse(volunteerDTO);
        return result;
    }

    /**
     * 我的学生列表
     *
     * @return
     */
    @GetMapping("/student/list.html")
    public String toStudentList() {
        return "/tutor/student-list";
    }

    /**
     * 我的学生列表
     *
     * @return
     */
    @GetMapping("/student/list")
    @ResponseBody
    public OnlineTutorResult myStudentList() {
        OnlineTutorResult result = tutorService.getStudentList();
        return result;
    }
}
