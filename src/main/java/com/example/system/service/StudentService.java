package com.example.system.service;

import com.example.system.pojo.Student;

public interface StudentService {

    //查询账号是否存在
    Student ifRight(String username,String password);

    //注册
    boolean registerStudent(Student student);
}