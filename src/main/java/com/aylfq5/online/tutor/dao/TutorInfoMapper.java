package com.aylfq5.online.tutor.dao;

import com.aylfq5.online.tutor.domain.TutorInfo;

public interface TutorInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TutorInfo record);

    int insertSelective(TutorInfo record);

    TutorInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TutorInfo record);

    int updateByPrimaryKey(TutorInfo record);
}