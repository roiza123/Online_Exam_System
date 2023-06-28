package com.example.system.mapper;

import com.example.system.model.StudentExamNotChoiceModel;
import com.example.system.pojo.StudentExamDetail;
import com.example.system.pojo.Title;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

@Mapper
public interface StudentExamDetailMapper {
    Collection<Title> findAll(@Param("eId") String eId);


    boolean addStudentExamDetail(@Param("seId") String seId, @Param("teId") String teId, @Param("sedAnswer") String sedAnswer,@Param("sedScore")Integer sedScore);

    Collection<StudentExamDetail> getChoiceScore(@Param("seId") String seId);

    Collection<StudentExamNotChoiceModel> getTitles(@Param("seId") String seId);

    void updateScore(@Param("seId") String seId, @Param("teId") String teId, @Param("score") String score,@Param("tId")String tId);
}