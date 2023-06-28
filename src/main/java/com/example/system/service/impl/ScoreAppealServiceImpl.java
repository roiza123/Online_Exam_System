package com.example.system.service.impl;

import com.example.system.mapper.ScoreAppealMapper;
import com.example.system.model.ScoreExamTeacherDetailModel;
import com.example.system.pojo.ScoreAppeal;
import com.example.system.service.ScoreAppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ScoreAppealServiceImpl implements ScoreAppealService {

    @Autowired
    private ScoreAppealMapper scoreAppealMapper;

    @Override
    public Collection<ScoreAppeal> findAllAppeal(String sId) {
        return scoreAppealMapper.findAllAppeal(sId);
    }

    @Override
    public Collection<ScoreAppeal> findAllAppealDetails(String teId, String sId) {
        return scoreAppealMapper.findAllAppeals(sId,teId);
    }

    @Override
    public void addAppeal(String sId, String teId, String saContent) {
        scoreAppealMapper.addApeal(sId,teId,saContent);
    }

    @Override
    public Collection<ScoreAppeal> getAllNoReviewAppeal() {
        return scoreAppealMapper.getAllNoReviewAppeal();
    }

    @Override
    public ScoreExamTeacherDetailModel findAllAppealDetailsTeacher(String sId, String teId) {
        return scoreAppealMapper.findAllApealDetailsTeacher(sId,teId);
    }

    @Override
    public void addTeacherAppeal(String sId, String teId, String saResult, String saBackContent, String sedScore, String seId) {
        scoreAppealMapper.addTeacherAppeal(sId,teId,saResult,saBackContent);
        scoreAppealMapper.updateStudentScore(teId,seId,sedScore);
    }


}