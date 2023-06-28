package com.example.system.service;

import com.example.system.pojo.Title;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface TitleService {
    //添加题目
    boolean addTitles(@Param("title") Title title);

    //获取所有信息
    List<Title> getAll();

    //搜索信息
    Collection<Title> find(@Param("teContent") String teContent);

    //删除题目
    void deleteTitle(@Param("teId") String teId);

    //找到题目具体信息
    Title getOne(@Param("teId") String teId);

    //更新题目
    void updateOne(@Param("title") Title title);
}