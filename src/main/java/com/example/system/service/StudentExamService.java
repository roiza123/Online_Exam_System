package com.example.system.service;

import com.example.system.model.StudentExamAllDetailModel;
import com.example.system.model.StudentScoreListModel;
import com.example.system.pojo.Exam;
import com.example.system.pojo.StudentExam;
import com.example.system.pojo.Title;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

public interface StudentExamService {

    //找到考试的内容
    Collection<Exam> searchExam();

    //找出考试题目
    Collection<Title> getTitles(@Param("eId") String eId);

    void addStudentExam(StudentExam studentExam);

    void updateExamScore(String seId, int choiceScore);

    //找出所有学生去考试
    Collection<StudentExam> getAllStudent(String eId);

    Integer getStudentScore(String seId);

    void updateStudentCorrentScore(String seId, int score);

    Collection<StudentScoreListModel> findAllExamResult(String sId);

    Collection<StudentScoreListModel> getAllStudentScore(String eSubject);

    Collection<StudentExamAllDetailModel> getOneExamTitlesDetail(String seId);
}