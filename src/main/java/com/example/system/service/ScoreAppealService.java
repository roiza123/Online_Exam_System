package com.example.system.service;

import com.example.system.model.ScoreExamTeacherDetailModel;
import com.example.system.pojo.ScoreAppeal;

import java.util.Collection;

public interface ScoreAppealService {
    Collection<ScoreAppeal> findAllAppeal(String sId);

    Collection<ScoreAppeal> findAllAppealDetails(String teId, String sId);

    void addAppeal(String sId, String teId, String saContent);

    Collection<ScoreAppeal> getAllNoReviewAppeal();


    ScoreExamTeacherDetailModel findAllAppealDetailsTeacher(String sId, String teId);


    void addTeacherAppeal(String sId, String teId, String saResult, String saBackContent, String sedScore, String seId);
}