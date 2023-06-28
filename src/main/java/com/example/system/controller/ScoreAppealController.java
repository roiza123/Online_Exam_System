package com.example.system.controller;

import com.example.system.model.ScoreExamTeacherDetailModel;
import com.example.system.pojo.ScoreAppeal;
import com.example.system.service.ScoreAppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Collections;

@Controller
public class ScoreAppealController {

    @Autowired
    private ScoreAppealService scoreAppealService;

    @RequestMapping(value = "/score_appeal", method = RequestMethod.GET)
    public String turnToScoreAppeal(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sId = (String) session.getAttribute("sId");
        Collection<ScoreAppeal> scoreAppeals = scoreAppealService.findAllAppeal(sId);
        session.setAttribute("sas", scoreAppeals);
        return "score_appeal";
    }

    @RequestMapping(value = "/score_appeal/{teId}", method = RequestMethod.GET)
    public String returnDetail(HttpServletRequest request, @PathVariable("teId") String teId) {
        HttpSession session = request.getSession();
        String sId = (String) session.getAttribute("sId");
        Collection<ScoreAppeal> scoreAppealss = scoreAppealService.findAllAppealDetails(teId, sId);
        session.setAttribute("sasd", scoreAppealss);
        return "score_appeal";
    }

    @RequestMapping(value = "/addAppeal", method = RequestMethod.POST)
    public String addAppeal(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sId = (String) session.getAttribute("sId");
        String teId = request.getParameter("teId");
        String saContent = request.getParameter("sa_content");
        scoreAppealService.addAppeal(sId, teId, saContent);
        Collection<ScoreAppeal> allAppeal = scoreAppealService.findAllAppeal(sId);
        session.setAttribute("sas", allAppeal);
        return "score_appeal";
    }

    @RequestMapping(value = "/turnToaddAppeal", method = RequestMethod.GET)
    public String turnToAppeal(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("sasd");
        return "add_appeal";
    }

    @RequestMapping(value = "/turnToReview", method = RequestMethod.GET)
    public String turnToReview(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Collection<ScoreAppeal> scoreAppeal = scoreAppealService.getAllNoReviewAppeal();
        session.setAttribute("scoreAppeal", scoreAppeal);
        return "review_complaint";
    }

    @RequestMapping(value = "/review_complaint2/{sId}/{teId}", method = RequestMethod.GET)
    public String turnToReviewComplaint2(HttpServletRequest request, @PathVariable("sId") String sId, @PathVariable("teId") String teId) {
        ScoreExamTeacherDetailModel scoreExamTeacherDetailModel = scoreAppealService.findAllAppealDetailsTeacher(sId, teId);
        HttpSession session = request.getSession();
        session.setAttribute("saca", scoreExamTeacherDetailModel);
        session.setAttribute("sId", sId);
        session.setAttribute("teId", teId);
        return "review_complaint2";
    }

    @RequestMapping(value = "/reviewStudent1", method = RequestMethod.POST)
    public String reviewStudent1(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ScoreExamTeacherDetailModel saca = (ScoreExamTeacherDetailModel) session.getAttribute("saca");
        String seId = saca.getSeId();
        String sId = (String) session.getAttribute("sId");
        String teId = (String) session.getAttribute("teId");
        String saResult = request.getParameter("saResult");
        String saBackContent = request.getParameter("saBackContent");
        String sedScore = request.getParameter("sedScore");
        scoreAppealService.addTeacherAppeal(sId, teId, saResult, saBackContent, sedScore,seId);
        Collection<ScoreAppeal> scoreAppeal = scoreAppealService.getAllNoReviewAppeal();
        session.setAttribute("scoreAppeal", scoreAppeal);
        return "review_complaint";
    }

}