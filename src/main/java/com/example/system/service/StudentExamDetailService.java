package com.example.system.service;

import com.example.system.model.StudentExamNotChoiceModel;
import com.example.system.pojo.StudentExamDetail;
import com.example.system.pojo.Title;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

public interface StudentExamDetailService {

    //查询试卷的所有题目
    Collection<Title> findAllTitles( String eId);

    boolean addStudentExamDatil(StudentExamDetail studentExamDetail);

    Collection<StudentExamDetail> getChoiceScore(String seId);

    Collection<StudentExamNotChoiceModel> findTitles(String seId);

    void updateScore(String seId, String teId, String score,String tId);
}