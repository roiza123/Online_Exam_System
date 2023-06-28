package com.example.system.service.impl;

import com.example.system.mapper.TeacherMapper;
import com.example.system.pojo.Exam;
import com.example.system.pojo.Teacher;
import com.example.system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public Teacher ifRight(String username, String password) {
        Teacher teacher=teacherMapper.ifRight(username,password);
        return teacher;
    }

    @Override
    public boolean registerTeacher(Teacher teacher) {
        //查看老师是否存在
        String tId = teacher.getTId();
        Teacher teacher1=teacherMapper.getTeacher(tId);
        if (teacher1 == null){
            //插入信息
            boolean isInsert = teacherMapper.insertTeacher(
                    teacher.getTId(),
                    teacher.getTName(),
                    teacher.getTPassword(),
                    teacher.getTPhone(),
                    teacher.getTRole()
            );
            return isInsert;
        }
        return false;
    }

    @Override
    public Collection<Exam> searchExam() {
        Collection<Exam>exams=teacherMapper.searchExam();
        return exams;
    }


}