package com.aylfq5.online.tutor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/2/21 11:35
 * @Version: 1.0
 */
@RestController
public class HelloSpringBoot {
    /**
     * 通过设置RequestMapping的method属性便可以设置该方法可处理的对应请求了，例如下面的getRequestDemo方法只会处理get请求
     */
    @RequestMapping(path = {"/getRequestDemo"},method = RequestMethod.GET)
    public String getRequestDemo (@RequestParam(value="param1",required = false) int param){
        System.out.println("get request test ,get param " + param);
        return "success get param";
    }
    /**
     * 下面的deleteRequestDemo方法只会处理delete请求
     */
    @RequestMapping(path = {"/deleteRequestDemo"},method = RequestMethod.DELETE)
    public String deleteRequestDemo (@RequestParam(value="param1",required = false) int param){
        System.out.println("delete request test ,get param " + param);
        return "success get param";
    }
}
