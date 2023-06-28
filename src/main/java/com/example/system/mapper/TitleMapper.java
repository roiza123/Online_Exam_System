package com.example.system.mapper;

import com.example.system.pojo.Title;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface TitleMapper {
    //是否存在题目编号
    Title getTitle(@Param("teId") String teId);

    //添加题目
    boolean insertTitles(@Param("teId") String teId,
                         @Param("tId") String tId,
                         @Param("teContent") String teContent,
                         @Param("tePicture") String tePicture,
                         @Param("teType") String teType,
                         @Param("teAnswer") String teAnswer,
                         @Param("teScore") Integer teScore,
                         @Param("ifDelete") String ifDelete);

    //查询所有题
    List<Title> getAllTitles();

    //查询题目
    Collection<Title> getTitles(@Param("teContent") String teContent);

    //删除题目
    void deleteTitle(@Param("teId") String teId);

    //获得题目具体信息
    Title getOneTitle(@Param("teId") String teId);

    //更新题目
    void updateOne(@Param("teId") String teId,
                   @Param("teContent") String teContent,
                   @Param("tePicture") String tePicture,
                   @Param("teType") String teType,
                   @Param("teAnswer") String teAnswer,
                   @Param("teScore") Integer teScore);
}