package com.example.system.service.impl;

import com.example.system.mapper.StudentExamMapper;
import com.example.system.model.StudentExamAllDetailModel;
import com.example.system.model.StudentScoreListModel;
import com.example.system.pojo.Exam;
import com.example.system.pojo.StudentExam;
import com.example.system.pojo.Title;
import com.example.system.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentExamServiceImpl implements StudentExamService {

    @Autowired
    private StudentExamMapper studentExamMapper;

    @Override
    public Collection<Exam> searchExam() {
        Collection<Exam> exams= studentExamMapper.searchExam();
        return  exams;
    }

    @Override
    public Collection<Title> getTitles(String eId) {
        Collection<Title> titles=studentExamMapper.getTitles(eId);
        return  titles;
    }

    @Override
    public void addStudentExam(StudentExam studentExam) {
        studentExamMapper.addStudentExam(studentExam.getSeId(),studentExam.getSId(),studentExam.getEId());
    }

    @Override
    public void updateStudentCorrentScore(String seId, int score) {
        studentExamMapper.updateStudentCorrentScore(seId,score);
    }

    @Override
    public Collection<StudentScoreListModel> findAllExamResult(String sId) {
        return studentExamMapper.findAllExamResult(sId);
    }

    @Override
    public void updateExamScore(String seId, int choiceScore) {
        studentExamMapper.updateExamScore(seId,choiceScore);
    }

    @Override
    public Collection<StudentExam> getAllStudent(String eId) {
        Collection<StudentExam> studentExams=studentExamMapper.getAllStudents(eId);
        return studentExams;
    }

    @Override
    public Integer getStudentScore(String seId) {
        return studentExamMapper.getStudentScore(seId);
    }

    @Override
    public Collection<StudentScoreListModel> getAllStudentScore(String eSubject) {
        return studentExamMapper.geAllStudentScore(eSubject);
    }

    @Override
    public Collection<StudentExamAllDetailModel> getOneExamTitlesDetail(String seId) {
        return  studentExamMapper.getOneExamTitlesDetail(seId);
    }
}