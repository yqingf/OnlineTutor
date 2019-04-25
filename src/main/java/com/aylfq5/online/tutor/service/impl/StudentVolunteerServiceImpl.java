package com.aylfq5.online.tutor.service.impl;

import com.aylfq5.online.tutor.constant.ResponseStatusCode;
import com.aylfq5.online.tutor.dao.StudentVolunteerMapper;
import com.aylfq5.online.tutor.domain.Condition;
import com.aylfq5.online.tutor.entity.DoubleSelectedResult;
import com.aylfq5.online.tutor.service.StudentVolunteerService;
import com.aylfq5.online.tutor.util.OnlineTutorResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/4/25 15:24
 * @Version: 1.0
 */
@Service
public class StudentVolunteerServiceImpl implements StudentVolunteerService {

    @Resource
    private StudentVolunteerMapper studentVolunteerMapper;

    @Override
    public OnlineTutorResult getDoubleSelectionResult(Condition condition) {
        Integer page = condition.getPage();
        Integer rows = condition.getRows();
        PageHelper.startPage(page == null ? 1 : page, rows == null ? 20 : rows);
        List<DoubleSelectedResult> resultList = studentVolunteerMapper.getDoubleSelectionResult(condition);
        PageInfo pageInfo = new PageInfo(resultList);
        long total = pageInfo.getTotal();
        return OnlineTutorResult.build(ResponseStatusCode.SUCCESS, "ok", (int) total, resultList);
    }
}
