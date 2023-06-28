package com.example.system.service;

import com.example.system.pojo.ExamTitle;
import com.example.system.pojo.Title;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

public interface ExamTitleService {

    //插入题目
    void addTitles(@Param("eId") String eId, @Param("teId") String teId);

    //查找插入的题目
    Collection<Title> searchTitles(@Param("eId") String eId);

//    //插入试卷编号
//    void postId(@Param("eId") String eId);

}