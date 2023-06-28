package com.example.system.service.impl;

import com.example.system.mapper.StudentExamDetailMapper;
import com.example.system.mapper.StudentExamMapper;
import com.example.system.model.StudentExamNotChoiceModel;
import com.example.system.pojo.StudentExamDetail;
import com.example.system.pojo.Title;
import com.example.system.service.StudentExamDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public  class StudentExamDetailServiceImpl implements StudentExamDetailService {
    @Autowired
    private StudentExamDetailMapper studentExamDetailMapper;

    @Override
    public Collection<Title> findAllTitles(String eId) {
        Collection<Title> titles = studentExamDetailMapper.findAll(eId);
        return titles;
    }

    @Override
    public boolean addStudentExamDatil(StudentExamDetail studentExamDetail) {
        return studentExamDetailMapper.addStudentExamDetail(studentExamDetail.getSeId(),
                studentExamDetail.getTeId(),
                studentExamDetail.getSedAnswer(),
                studentExamDetail.getSedScore());
    }

    @Override
    public Collection<StudentExamDetail> getChoiceScore(String seId) {
        return studentExamDetailMapper.getChoiceScore(seId);
    }

    @Override
    public Collection<StudentExamNotChoiceModel> findTitles(String seId) {
        return studentExamDetailMapper.getTitles(seId);
    }

    @Override
    public void updateScore(String seId, String teId, String score,String tId) {
        studentExamDetailMapper.updateScore(seId,teId,score,tId);
    }
}