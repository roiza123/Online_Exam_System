package com.example.system.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface ExamService {

    //加题1.0：加老师和加试卷编号
    void addTitle1(@Param("eId") String eId, @Param("tId") String tId);

    //加题2.0：加别的7788
    void addTitle2(@Param("eSubject") String eSubject, @Param("eBegin") String eBegin, @Param("eEnd") String eEnd,@Param("eId")String eId);
}