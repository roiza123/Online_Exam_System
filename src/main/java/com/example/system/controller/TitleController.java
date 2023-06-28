package com.example.system.controller;

import com.example.system.pojo.Title;
import com.example.system.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class TitleController {

    @Autowired
    private TitleService titleService;

    @RequestMapping(value = "addTitles", method = RequestMethod.POST)
    public String addTitles(HttpServletRequest request) {
        String teId = request.getParameter("te_id");
        String tId = (String) request.getSession().getAttribute("tId");
        String teContent = request.getParameter("te_content");
        String tePicture = request.getParameter("te_picture");
        String teType = request.getParameter("te_type");
        String teAnswer = request.getParameter("te_answer");
        Integer teScore = Integer.valueOf(request.getParameter("te_score"));
        Title title = new Title(teId, tId, teContent, tePicture, teType, teAnswer, teScore, "0");
        boolean addTitles = titleService.addTitles(title);
        String result = addTitles ? "success" : "false";
        return result;
    }
/*
    @RequestMapping(value = "Titles", method = RequestMethod.GET)
    public String getAllTitles(Model model) {
        //获取所有的员工信息
        Collection<Title> allTitles = titleService.getAll();
        //将所有的员工信息在请求域中共享
        model.addAttribute("allTitles", allTitles);
        //跳转列表页面
        return "proposition_teacher_index";
    }*/

    @RequestMapping(value = "/Titles/find", method = RequestMethod.GET)
    public String find(HttpServletRequest request) {
        String teContent=request.getParameter("te_content");
        //根据内容查询试题信息
        Collection<Title> Titles = titleService.find(teContent);
        HttpSession session = request.getSession();
        //将题目信息共享到请求域中
        session.setAttribute("allTitles", Titles);
        //跳转到update_title.html
        return "proposition_teacher_index";
    }

    @RequestMapping(value = "/Titles/delete/{teId}", method = RequestMethod.GET)
    public String delete(@PathVariable("teId") String teId) {
        //删除题目信息
        titleService.deleteTitle(teId);
        //重定向
        return "redirect:/proposition_teacher_index";
    }

    @RequestMapping(value = "/Title/{teId}",method = RequestMethod.GET)
    public String getTitle(@PathVariable("teId")String teId ,Model model){
        //查找单个题目的具体信息
        Title title=titleService.getOne(teId);
        model.addAttribute("title",title);
        //去新html
        return "title_show";
    }

    @RequestMapping(value = "/Titles/update" ,method = RequestMethod.POST)
    public String updateTitle(HttpServletRequest request){
        String teId = request.getParameter("te_id");
        String tId = (String) request.getSession().getAttribute("tId");
        String teContent = request.getParameter("te_content");
        String tePicture = request.getParameter("te_picture");
        String teType = request.getParameter("te_type");
        String teAnswer = request.getParameter("te_answer");
        Integer teScore = Integer.valueOf(request.getParameter("te_score"));
        Title title = new Title(teId, tId, teContent, tePicture, teType, teAnswer, teScore, "0");
        //更新
        titleService.updateOne(title);
        return "success";
    }
}