package com.graduation.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String login(){
        return "login";
    }


    @RequestMapping("/student")
    public String toStudent(){
        return "student/student";
    }

    @RequestMapping("/toStudentLeft")
    public String toStudentLeft(){
        return "student/studentleft";
    }

    @RequestMapping("/studenttop")
    public String toStudentTop(){
        return "student/studenttop";
    }

    @RequestMapping("/studentright")
    public String toStudentRight(){
        return "student/studentright";
    }

    @RequestMapping("/admin")
    public String toAdmin(){
        return "admin/admin";
    }

    @RequestMapping("/toAdminLeft")
    public String toAdminLeft(){
        return "admin/adminleft";
    }

    @RequestMapping("/toAdminRight")
    public String toAdminRight(){
        return "admin/adminright";
    }

    @RequestMapping("/toAdminTop")
    public String toAdminTop(){
        return "admin/admintop";
    }

    @RequestMapping("/teacher")
    public String toTeacher(){
        return "teacher/teacher";
    }
}
