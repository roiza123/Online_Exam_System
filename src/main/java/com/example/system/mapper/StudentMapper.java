package com.example.system.mapper;

import com.example.system.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {

    Student ifRight(@Param("username") String username, @Param("password") String password);

    Student getStudent(@Param("sId") String sId);

    boolean insertStudent(@Param("sId") String sId,
                          @Param("sName") String sName,
                          @Param("sPassword") String sPassword,
                          @Param("sGrade") Integer sGrade,
                          @Param("sMajor") String sMajor,
                          @Param("sClass") Integer sClass,
                          @Param("sSex") String sSex,
                          @Param("sCollege") String sCollege);
}