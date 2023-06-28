package com.example.system.controller;

import com.example.system.pojo.ExamTitle;
import com.example.system.pojo.Title;
import com.example.system.service.ExamTitleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class ExamTitleController {

    @Autowired
    private ExamTitleService examTitleService;



    @RequestMapping(value = "/ExamTitle/{teId}",method = RequestMethod.GET)
    public String getTitle(HttpServletRequest request, @PathVariable("teId") String teId){
        String eId=(String)request.getSession().getAttribute("eId");
        examTitleService.addTitles(eId,teId);
        Collection<Title>examTitles =examTitleService.searchTitles(eId);
        HttpSession session=request.getSession();
        session.setAttribute("examTitles",examTitles);
        return "proposition_teacher_index";
    }
}