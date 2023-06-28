package com.example.system.mapper;

import com.example.system.pojo.Exam;
import com.example.system.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

@Mapper
public interface TeacherMapper {
    Teacher ifRight(@Param("username") String username, @Param("password") String password);

    boolean insertTeacher(@Param("tId") String tId, @Param("tName") String tName, @Param("tPassword") String tPassword, @Param("tPhone") String tPhone, @Param("tRole") String tRole);

    Teacher getTeacher(@Param("tId") String tId);

    Collection<Exam> searchExam();
}