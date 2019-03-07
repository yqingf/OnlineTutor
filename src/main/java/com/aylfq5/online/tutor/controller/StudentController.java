package com.aylfq5.online.tutor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 学生管理Controller
 * @Author: aylfq5
 * @CreateDate: 2019/2/28 9:06
 * @Version: 1.0
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("add.html")
    public String toTutorAdd() {
        return "/user/student-add";
    }
    @RequestMapping("delete.html")
    public String tutorDelete() {
        return "/user/student-list";
    }
    @RequestMapping("edit.html")
    public String toTutorEdit() {
        return "/user/student-edit";
    }
    @RequestMapping("list.html")
    public String toTutorList() {
        return "/user/student-list";
    }
}
