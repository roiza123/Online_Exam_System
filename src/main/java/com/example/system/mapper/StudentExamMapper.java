package com.example.system.mapper;

import com.example.system.model.StudentExamAllDetailModel;
import com.example.system.model.StudentScoreListModel;
import com.example.system.pojo.Exam;
import com.example.system.pojo.StudentExam;
import com.example.system.pojo.Title;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

@Mapper
public interface StudentExamMapper {

    //找到考试安排
    Collection<Exam> searchExam();

    //找出考试题目
    Collection<Title> getTitles(@Param("eId") String eId);

    void addStudentExam(@Param("seId") String seId, @Param("sId") String sId, @Param("eId") String eId);

    void updateExamScore(@Param("seId") String seId, @Param("choiceScore") int choiceScore);

    //找到所有考试的学生
    Collection<StudentExam> getAllStudents(@Param("eId") String eId);

    Integer getStudentScore(@Param("seId") String seId);

    void updateStudentCorrentScore(@Param("seId") String seId, @Param("score") int score);

    Collection<StudentScoreListModel> findAllExamResult(@Param("sId") String sId);

    Collection<StudentScoreListModel> geAllStudentScore(@Param("eSubject") String eSubject);

    Collection<StudentExamAllDetailModel> getOneExamTitlesDetail(@Param("seId") String seId);
}