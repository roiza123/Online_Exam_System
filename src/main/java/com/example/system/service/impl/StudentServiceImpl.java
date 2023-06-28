package com.example.system.service.impl;

import com.example.system.mapper.StudentMapper;
import com.example.system.pojo.Student;
import com.example.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public Student ifRight(String username, String password) {
        return studentMapper.ifRight(username, password);
    }

    @Override
    public boolean registerStudent(Student student) {
//       查看学生是否存在
        String sId = student.getSId();
        Student student1 = studentMapper.getStudent(sId);
        if (student1 == null) {
//            插入学生信息
            boolean isInsert = studentMapper.insertStudent(student.getSId(),
                    student.getSName(),
                    student.getSPassword(),
                    student.getSGrade(),
                    student.getSMajor(),
                    student.getSClass(),
                    student.getSSex(),
                    student.getSCollege());
            return isInsert;
        }
        return false;
    }
}