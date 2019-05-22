package com.aylfq5.online.tutor.service;

import com.aylfq5.online.tutor.domain.Condition;
import com.aylfq5.online.tutor.util.OnlineTutorResult;

public interface StudentVolunteerService {
    OnlineTutorResult getDoubleSelectionResult(Condition condition);

    OnlineTutorResult assignTutor(Long studentId, Long tutorId);
}
