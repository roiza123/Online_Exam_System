package com.example.system.service;

import com.example.system.pojo.Exam;
import com.example.system.pojo.Teacher;

import java.util.Collection;

public interface TeacherService {

    //验证登录
    Teacher ifRight(String username, String password);

    //注册信息
    boolean registerTeacher(Teacher teacher);

    //找到所有考试
    Collection<Exam> searchExam();

//    //判断老师
//    boolean whichTeacher(String tId);
}