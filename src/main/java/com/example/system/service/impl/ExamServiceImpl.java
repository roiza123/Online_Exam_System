package com.example.system.service.impl;

import com.example.system.mapper.ExamMapper;
import com.example.system.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public void addTitle1(String eId, String tId) {
        if(examMapper.findExam(eId) == null){
            examMapper.addTitle1(eId,tId);
        }
    }

    @Override
    public void addTitle2(String eSubject, String eBegin, String eEnd,String eId) {
        examMapper.addTitle2(eSubject,eBegin,eEnd,eId);
    }
}