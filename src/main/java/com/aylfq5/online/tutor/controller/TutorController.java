package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.constant.UserType;
import com.aylfq5.online.tutor.service.TutorService;
import com.aylfq5.online.tutor.service.UserService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
     * 跳转到修改页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/v1/edit/{id}")
    public String toEdit(@PathVariable String id, Model model) {
        OnlineTutorResult result = userService.selectByPrimaryKey(Long.parseLong(id));
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
    public OnlineTutorResult getTutorList(Integer page, Integer rows, int type) {
        OnlineTutorResult result = userService.getUserList(page, rows, type);
        return result;
    }
}
