package com.example.system.controller;

import com.example.system.pojo.Student;
import com.example.system.pojo.Teacher;
import com.example.system.service.StudentService;
import com.example.system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/toIndex", method = RequestMethod.GET)
    public String turntoIndex() {
        return "index";
    }

    //注册,方法名小驼峰
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String TurnToRegister() {
        return "register_1";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String TurntoIndex() {
        return "index";
    }

    @RequestMapping(value = "/register_s", method = RequestMethod.GET)
    public String TurnToStudentRegister() {
        return "register_s";
    }

    @RequestMapping(value = "/register_t", method = RequestMethod.GET)
    public String TurnToTeacherRegister() {
        return "register_t";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCheck(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("user");
        String password = request.getParameter("password");
        String radio = request.getParameter("role");
        String ifCookie = request.getParameter("ifCookie");
        HttpSession session = request.getSession();
        if ("student".equals(radio)) {
            Student student = studentService.ifRight(userName, password);
            if (student != null) {
                session.setAttribute("sName", student.getSName());
                session.setAttribute("sId", student.getSId());
                if ("yes".equals(ifCookie)) {
                    Cookie cookie = new Cookie("userName", userName);
                    Cookie cookie1 = new Cookie("password", password);
                    Cookie cookie2 = new Cookie("radio", radio);
                    cookie.setMaxAge(5 * 60);
                    response.addCookie(cookie);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }
                return "student_index";
            }
        } else {
            Teacher teacher = teacherService.ifRight(userName, password);
            if (teacher != null) {
                session.setAttribute("tName", teacher.getTName());
                session.setAttribute("tId", teacher.getTId());
                if ("yes".equals(ifCookie)) {
                    Cookie cookie = new Cookie("userName", userName);
                    Cookie cookie1 = new Cookie("password", password);
                    Cookie cookie2 = new Cookie("radio", radio);
                    cookie.setMaxAge(5 * 60);
                    response.addCookie(cookie);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }
                return "teacher_index";
            }
        }
        return "index_fail";
    }


    /*学生注册*/
    @RequestMapping(value = "registerStudent", method = RequestMethod.POST)
    public String registerStudent(HttpServletRequest request) {
        // 获取表单数据
        String sId = request.getParameter("s_id");
        String sName = request.getParameter("s_name");
        String sPassword = request.getParameter("s_password");
        Integer sGrade = Integer.valueOf(request.getParameter("s_grade"));
        String sMajor = request.getParameter("s_major");
        Integer sClass = Integer.valueOf(request.getParameter("s_class"));
        String sSex = request.getParameter("s_sex");
        String sCollege = request.getParameter("s_college");
        Student student = new Student(sId, sName, sPassword, sGrade, sMajor, sClass, sSex, sCollege);
        boolean registerResult = studentService.registerStudent(student);
        HttpSession session = request.getSession();
        session.setAttribute("sId", sId);
        session.setAttribute("sName", sName);
        String result = registerResult ? "student_index" : "register_s";
        return result;
    }



}