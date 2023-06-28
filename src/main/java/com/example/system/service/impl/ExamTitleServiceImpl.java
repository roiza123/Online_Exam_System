package com.example.system.service.impl;

import com.example.system.mapper.ExamTitleMapper;
import com.example.system.pojo.Title;
import com.example.system.service.ExamTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExamTitleServiceImpl implements ExamTitleService {

    @Autowired
    private ExamTitleMapper examTitleMapper;

    @Override
    public void addTitles(String eId, String teId) {
//        这里是搜索这张卷里面有没有这道题，要在这张卷里面找，一个参数狗？
        if(examTitleMapper.searchone(eId,teId).isEmpty()){
            examTitleMapper.addTitles(eId,teId);
        }
    }

    @Override
    public Collection<Title> searchTitles(String eId) {
        Collection<Title> examTitles=examTitleMapper.search(eId);
        return examTitles;
    }

//    @Override
//    public void postId(String eId) {
//        examTitleMapper.postId(eId);
//    }
}