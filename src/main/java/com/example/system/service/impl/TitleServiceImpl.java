package com.example.system.service.impl;

import com.example.system.mapper.TitleMapper;
import com.example.system.pojo.Title;
import com.example.system.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleMapper titleMapper;

    @Override
    public boolean addTitles(Title title) {
        //查找题目编号是否已经存在
        String teId = title.getTeId();
        Title title1 = titleMapper.getTitle(teId);
        if (title1 == null) {
            //添加题目
            System.out.println(title);
            boolean insertTitles = titleMapper.insertTitles(
                    title.getTeId(),
                    title.getTId(),
                    title.getTeContent(),
                    title.getTePicture(),
                    title.getTeType(),
                    title.getTeAnswer(),
                    title.getTeScore(),
                    title.getIfDelete());
            return insertTitles;
        }
        return false;
    }

    @Override
    public List<Title> getAll() {
        List<Title> titles = titleMapper.getAllTitles();
        return titles;
    }

    @Override
    public Collection<Title> find(String teContent) {
        Collection<Title> titles = titleMapper.getTitles(teContent);
        return titles;
    }

    @Override
    public void deleteTitle(String teId) {
        titleMapper.deleteTitle(teId);
    }

    @Override
    public Title getOne(String teId) {
        Title title = titleMapper.getOneTitle(teId);
        return title;
    }

    @Override
    public void updateOne(Title title) {
        titleMapper.updateOne(title.getTeId(),
                title.getTeContent(),
                title.getTePicture(),
                title.getTeType(),
                title.getTeAnswer(),
                title.getTeScore());
    }

}