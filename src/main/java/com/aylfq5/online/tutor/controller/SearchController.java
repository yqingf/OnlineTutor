package com.aylfq5.online.tutor.controller;

import com.aylfq5.online.tutor.domain.Condition;
import com.aylfq5.online.tutor.service.SearchService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/4/12 10:30
 * @Version: 1.0
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @Resource
    private SearchService searchService;

    @RequestMapping("/combination/query")
    public OnlineTutorResult combinationQuery(Condition condition) {
        OnlineTutorResult result = searchService.combinationQuery(condition);
        return result;
    }
}

