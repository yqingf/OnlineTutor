package com.aylfq5.online.tutor.service;

import com.aylfq5.online.tutor.domain.Condition;
import com.aylfq5.online.tutor.util.OnlineTutorResult;

public interface SearchService {
    OnlineTutorResult combinationQuery(Condition condition);
}
