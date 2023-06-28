package com.example.system.controller;

import com.example.system.pojo.Exam;
import com.example.system.pojo.Teacher;
import com.example.system.pojo.Title;
import com.example.system.service.ExamService;
import com.example.system.service.TeacherService;
import com.example.system.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TitleService titleService;


    /*教师注册*/
    @RequestMapping(value = "registerTeacher",method = RequestMethod.POST)
    public String registerTeacher(HttpServletRequest request){
        //获取表单数据
        String tId =request.getParameter("t_id");
        String tName=request.getParameter("t_name");
        String tPassword=request.getParameter("t_password");
        String tPhone=request.getParameter("t_phone");
        String tRole= request.getParameter("t_role");
        Teacher teacher=new Teacher(tId,tName,tPassword,tPhone,tRole,"1");
        boolean registerResult = teacherService.registerTeacher(teacher);
        HttpSession session = request.getSession();
        session.setAttribute("tId",tId);
        String result = registerResult ? "teacher_index":"regisyer_t";
        return result;
    }

    @RequestMapping(value = "addTitles",method = RequestMethod.GET)
    public String addTitles(HttpServletRequest request){
        return "add_titles";
    }

    @RequestMapping(value = "proposition_teacher_index",method = RequestMethod.GET)
    public String TurnToProposition_teacher_index(HttpServletRequest request){
        List<Title> all = titleService.getAll();
        HttpSession session = request.getSession();
        session.setAttribute("allTitles",all);
        return "proposition_teacher_index";
    }

    @RequestMapping(value = "/correction_teacher_index",method = RequestMethod.GET)
    public String turnToCorrect(){
        return "correction_teacher_index";
    }

    @RequestMapping(value = "turnToCorrect",method = RequestMethod.GET)
    public String turnToCorrect(HttpServletRequest request){
        HttpSession session=request.getSession();
        String tId = (String) session.getAttribute("tId");
        Collection<Exam> exams=teacherService.searchExam();
        session.setAttribute("exams",exams);
        return "correct_exams";
    }

}