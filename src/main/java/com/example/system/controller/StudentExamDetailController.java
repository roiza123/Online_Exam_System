package com.example.system.controller;

import com.example.system.model.StudentExamNotChoiceModel;
import com.example.system.pojo.StudentExam;
import com.example.system.pojo.StudentExamDetail;
import com.example.system.pojo.Title;
import com.example.system.service.StudentExamDetailService;
import com.example.system.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class StudentExamDetailController {

    @Autowired
    private StudentExamDetailService studentExamDetailService;
    @Autowired
    private StudentExamService studentExamService;

    @RequestMapping(value = "postAnswer", method = RequestMethod.POST)
    public String postAnswer(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String seId = (String) session.getAttribute("studentSeId");
        String eId = (String) session.getAttribute("examEid");
        Collection<Title> titles = studentExamDetailService.findAllTitles(eId);
        boolean add = false;
        for (Title title : titles) {
            String answer = request.getParameter(title.getTeId());
            int score = 0;
//            选择题自动给分
            if ("0".equals(title.getTeType())) {
                if (title.getTeAnswer().equalsIgnoreCase(answer)) {
                    score = title.getTeScore();
                }
            }
            StudentExamDetail studentExamDetail = new StudentExamDetail(seId, title.getTeId(), answer, score, null);
            add = studentExamDetailService.addStudentExamDatil(studentExamDetail);
        }
//        更新选择题总分
        Collection<StudentExamDetail> studentExamDetails = studentExamDetailService.getChoiceScore(seId);
        int choiceScore = 0;
        for (StudentExamDetail studentExamDetail : studentExamDetails) {
            choiceScore += studentExamDetail.getSedScore();
        }
        studentExamService.updateExamScore(seId, choiceScore);
        return add ? "exam_success" : "exam_fail";
    }

    @RequestMapping(value = "/student_index", method = RequestMethod.GET)
    public String returnToIndex() {
        return "student_index";
    }

    @RequestMapping(value = "correct_exams1/{eId}", method = RequestMethod.GET)
    public String correctExam1(HttpServletRequest request, @PathVariable("eId") String eId) {
        HttpSession session = request.getSession();
        session.setAttribute("studentOneEid",eId);
        ArrayList<StudentExam> list = getList(eId);
        session.setAttribute("students", list);
        return "correct_exam1";
    }

    @RequestMapping(value = "correct_exams2/{seId}", method = RequestMethod.GET)
    public String correctExams2(HttpServletRequest request, @PathVariable("seId") String seId) {
        Collection<StudentExamNotChoiceModel> titles = studentExamDetailService.findTitles(seId);
        ArrayList<StudentExamNotChoiceModel> titles1 = new ArrayList<>();
        for (StudentExamNotChoiceModel title : titles) {
            if (!"0".equals(title.getTeType())) {
                titles1.add(title);
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("studentNotChoiceTitles", titles1);
        return "correct_exams2";
    }

    @RequestMapping(value = "/addStudentScore", method = RequestMethod.POST)
    public String getScore(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String  tId = (String) session.getAttribute("tId");
        ArrayList<StudentExamNotChoiceModel> studentNotChoiceTitles = (ArrayList<StudentExamNotChoiceModel>) session.getAttribute("studentNotChoiceTitles");
        for (StudentExamNotChoiceModel studentNotChoiceTitle : studentNotChoiceTitles) {
            String seId = studentNotChoiceTitle.getSeId();
            String teId = studentNotChoiceTitle.getTeId();
            String score = request.getParameter(seId +"/"+ teId);
            studentExamDetailService.updateScore(seId, teId, score,tId);
        }
//        更新总成绩
        int score = 0;
        for (StudentExamNotChoiceModel studentNotChoiceTitle : studentNotChoiceTitles) {
            String seId = studentNotChoiceTitle.getSeId();
            score = studentExamService.getStudentScore(seId);
            studentExamService.updateStudentCorrentScore(seId, score);
        }
        ArrayList<StudentExam> studentOneEid = getList((String) session.getAttribute("studentOneEid"));
        session.setAttribute("students",studentOneEid);
        return "correct_exam1";
    }


    private ArrayList<StudentExam> getList(String eId){
        Collection<StudentExam> studentExams = studentExamService.getAllStudent(eId);
        ArrayList<StudentExam> studentExams1 = new ArrayList<>();
        for (StudentExam studentExam : studentExams) {
            if (studentExam.getCorrectScore() == null) {
                studentExams1.add(studentExam);
            }
        }
        return studentExams1;
    }
}