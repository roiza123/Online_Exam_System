package com.example.system.controller;

import com.example.system.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

@Controller
public class ExamController {

    @Autowired
    private ExamService examService;

    @RequestMapping(value = "postId", method = RequestMethod.POST)
    public String postId(HttpServletRequest request) {
        String eId = request.getParameter("e_id");
        String tId = (String) request.getSession().getAttribute("tId");
        examService.addTitle1(eId,tId);
        HttpSession session = request.getSession();
        session.setAttribute("eId", eId);
        return "proposition_teacher_index";
    }

    @RequestMapping(value = "turntofinish1",method = RequestMethod.GET)
    public String turnToFinish1(){
        return "exam_finish1";
    }

    @RequestMapping(value = "turntofinish2",method = RequestMethod.POST)
    public String turnToFinish(HttpServletRequest request){
        String eSubject = request.getParameter("eSubject");
        String eBegin = request.getParameter("eBegin");
        String eEnd=request.getParameter("eEnd");
        String eId= (String) request.getSession().getAttribute("eId");
        examService.addTitle2(eSubject,eBegin,eEnd,eId);
        //直接以字符串插入
        HttpSession session = request.getSession();
        session.removeAttribute("eId");
        return "exam_finish2";
    }
}