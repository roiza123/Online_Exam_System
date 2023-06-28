package com.example.system.mapper;

import com.example.system.pojo.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExamMapper {

    //找试卷编号是否存在
    Exam findExam(@Param("eId") String eId);

    //添加试卷编号
    void addTitle1(@Param("eId") String eId, @Param("tId") String tId);

    //添加试卷的杂七杂八
    void addTitle2(@Param("eSubject") String eSubject, @Param("eBegin") String eBegin, @Param("eEnd") String eEnd,@Param("eId")String eId);
}