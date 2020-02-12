package com.graduation.admin.controller;

import com.graduation.admin.service.GradeService;
import com.graduation.admin.service.IUsersService;
import com.graduation.entity.Grade;
import com.graduation.entity.Users;
import com.graduation.util.Constant;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @Autowired
    private GradeService gradeService;

    //查询学生和老师，翻页 班级查询
    @RequestMapping("/selectUsersList")
    public String selectUsersList(Users users,Integer currentPage,Model model){
        if (users.getPower().equals("student")){
        List<Grade> grades = gradeService.selectGrade();
        model.addAttribute("grade",grades);
        if (users.getGradeId() == null){
            Grade grade = grades.get(0);
            users.setGradeId(grade.getId());
        }}
        //获取总数
        List<Users> usersSize = usersService.selectUsersList(users,null,null);
        model.addAttribute("countnum",usersSize.size());
        //计算总页数
        Integer count = usersSize.size()/ Constant.PAGESIZE==0?usersSize.size()/Constant.PAGESIZE:usersSize.size()/Constant.PAGESIZE+1;
        //获取当前页数 判断当前参数是否为null
        Integer current = 1;
        if (currentPage != null && currentPage > 1){
            if (currentPage >= count){
                currentPage = count;
            }
            current = (currentPage-1)*Constant.PAGESIZE;
        }else{
            current=0;
            currentPage = 1;
        }

        //总页
        model.addAttribute("count",count);
        //当前页
        model.addAttribute("current",currentPage);
        //判断查询学生还是老师
        if (users.getPower().equals("student")){
            List<Users> usersList = usersService.selectUsersList(users,current,Constant.PAGESIZE);
            model.addAttribute("users",usersList);
            model.addAttribute("gradeId",users.getGradeId());
            return "admin/student";
        }else{
            List<Users> usersList = usersService.selectUsersList(users,current,Constant.PAGESIZE);
            model.addAttribute("users",usersList);
            return "admin/teacher";
        }

    }

    //登录
    @ResponseBody
    @PostMapping("/login")
    public String login(Users users, HttpSession session){
        List<Users> usersList = usersService.selectUsersList(users,null,null);
        if (usersList != null){
            if (usersList.size() == 1){
                Users user = usersList.get(0);
                //存入session
                session.setAttribute("user",user);
                return "success";
            }else{
                return "fail";
            }
        }else{
            return "fail";
        }
    }

    @PostMapping("/insertUsers")
    public String insertUsers(Users users){
        usersService.insertUsers(users);
        return null;
    }

    @PostMapping("/updateUsers")
    public String updateUsers(Users users){
        usersService.updateUsers(users);
        return null;
    }

    @PostMapping("/deleteUsers")
    public String deleteUsers(Users users){
        usersService.deleteUsers(users);
        return null;
    }
}
