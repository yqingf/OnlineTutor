package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.domain.User;
import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 导师Controller
 * @Author: aylfq5
 * @CreateDate: 2019/2/28 8:59
 * @Version: 1.0
 */
@Controller
@RequestMapping("tutor")
public class TutorController {

    @Resource
    private UserService userService;

    @RequestMapping("add.html")
    public String toTutorAdd() {
        return "/tutor/add";
    }
    @RequestMapping("delete.html")
    public String tutorDelete() {
        return "/tutor/list";
    }
    @RequestMapping("edit.html")
    public String toTutorEdit() {
        return "/tutor/edit";
    }
    @RequestMapping("list.html")
    public String toTutorList() {
        return "/tutor/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public OnlineTutorResult getTutorList() {
        OnlineTutorResult result = userService.getUserList(2);
        return result;
    }
}
