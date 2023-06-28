package com.example.system.mapper;

import com.example.system.model.ScoreExamTeacherDetailModel;
import com.example.system.pojo.ScoreAppeal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

@Mapper
public interface ScoreAppealMapper {

    Collection<ScoreAppeal> findAllAppeal(@Param("sId") String sId);

    Collection<ScoreAppeal> findAllAppeals(@Param("sId") String sId, @Param("teId") String teId);

    void addApeal(@Param("sId") String sId, @Param("teId") String teId, @Param("saContent") String saContent);

    Collection<ScoreAppeal> getAllNoReviewAppeal();

    Collection<ScoreAppeal> getDetailAppeal(@Param("sId") String sId,@Param("teId") String teId);

    ScoreExamTeacherDetailModel findAllApealDetailsTeacher(@Param("sId") String sId, @Param("teId") String teId);

    void addTeacherAppeal(@Param("sId") String sId, @Param("teId") String teId, @Param("saResult") String saResult, @Param("saBackContent") String saBackContent);

    void updateStudentScore(@Param("teId") String teId, @Param("seId") String seId, @Param("sedScore") String sedScore);
}