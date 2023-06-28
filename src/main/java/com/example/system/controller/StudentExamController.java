package com.example.system.controller;

import com.example.system.model.StudentExamAllDetailModel;
import com.example.system.model.StudentScoreListModel;
import com.example.system.pojo.Exam;
import com.example.system.pojo.StudentExam;
import com.example.system.pojo.Title;
import com.example.system.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class StudentExamController {

    @Autowired
    private StudentExamService studentExamService;

    @RequestMapping(value = "/turnToExam1", method = RequestMethod.GET)
    public String turnToExam1(HttpServletRequest request) {
        Collection<Exam> exams = studentExamService.searchExam();
        HttpSession session = request.getSession();
        session.setAttribute("exam", exams);
        return "exam1";
    }

    @RequestMapping(value = "/turnToExam2/{eId}", method = RequestMethod.GET)
    public String turnToExam2(@PathVariable("eId") String eId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("examEid", eId);
        Collection<Title> titles = studentExamService.getTitles(eId);
        session.setAttribute("examTitles", titles);
        String l = String.valueOf(System.currentTimeMillis());
        String seId = l.substring(l.length() - 8);
        session.setAttribute("studentSeId", seId);
        String sId = (String) session.getAttribute("sId");
        StudentExam studentExam = new StudentExam(seId, sId, eId, 0, 0);
        studentExamService.addStudentExam(studentExam);
        return "exam2";
    }

    @RequestMapping(value = "/searchScore", method = RequestMethod.GET)
    public String turnToSearchScore(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sId = (String) session.getAttribute("sId");
        Collection<StudentScoreListModel> studentScoreLists = studentExamService.findAllExamResult(sId);
        for (StudentScoreListModel studentScoreList : studentScoreLists) {
            Collection<StudentScoreListModel> allStudentScore = studentExamService.getAllStudentScore(studentScoreList.getESubject());
            int rank = 0;
            for (StudentScoreListModel studentScoreListModel : allStudentScore) {
                rank ++;
                if (studentScoreListModel.getSId().equals(studentScoreList.getSId())) {
                    break;
                }
            }
            studentScoreList.setERank(rank);
        }
        System.out.println(studentScoreLists);
        session.setAttribute("ssl",studentScoreLists);
        return "search_score";
    }

    @RequestMapping(value = "/showDetail/{seId}", method = RequestMethod.GET)
    public String showDetail(HttpServletRequest request,@PathVariable("seId")String seId){
        HttpSession session= request.getSession();
        Collection<StudentExamAllDetailModel> studentExamAllDetailModels=studentExamService.getOneExamTitlesDetail(seId);
        session.setAttribute("seam",studentExamAllDetailModels);
        return "search_score";
    }

}