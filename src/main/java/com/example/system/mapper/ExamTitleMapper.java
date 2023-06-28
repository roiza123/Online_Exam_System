package com.example.system.mapper;

import com.example.system.pojo.Exam;
import com.example.system.pojo.ExamTitle;
import com.example.system.pojo.Title;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

@Mapper
public interface ExamTitleMapper {

    //添加题目
    void addTitles(@Param("eId") String eId, @Param("teId") String teId);

    //查找题目
    Collection<Title> search(@Param("eId") String eId);

    //查找该卷有没有该题目
    Collection<ExamTitle> searchone(@Param("eId") String eId, @Param("teId") String teId);


//    //发送试卷编号
//    void postId(@Param("eId") String eId);
}