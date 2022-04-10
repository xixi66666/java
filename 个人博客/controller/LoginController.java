package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.Impl.LoginServiceImpl;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class LoginController {

    @GetMapping("hello")
    public String hellopage(){
        return "hello";
    }

    @GetMapping(value = {"/","/index.html"})
    public String loginPage(){
        return "index";
    }
    @GetMapping("companies.html")
    public String companies(){
        return "companies";
    }
    @GetMapping("projects.html")
    public String projects(){
        return "projects";
    }
    @GetMapping("user-profile.html")
    public String userprofile(){
        return "user-profile";
    }
    @GetMapping("profiles.html")
    public String profiles(){
        return "profiles";
    }
    @GetMapping("my-profile-feed.html")
    public String myprofile(){
        return "my-profile-feed";
    }
    @GetMapping("jobs.html")
    public String jobs(){
        return "jobs";
    }
    @GetMapping("sign-in.html")
    public String sign(){
        return "sign-in";
    }


//    @Autowired
//    LoginServiceImpl loginServiceImpl;
//    @PostMapping("/userLogin")
//    public String login(User user , HttpSession session, Model model) {
//        Integer flag = loginServiceImpl.LoginCheck(user);
//        if (flag != null) {
//            session.setAttribute("user", user);
//            return "redirect:/index.html";
//        } else {
//            model.addAttribute("msg", "账号或密码错误");
//            return "sign-in";
//        }
//    }

    @RequestMapping("/getSession")
    public void getSession(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(session == null){
            response.getWriter().write("用户未登录");
        }else{
            String  user_ID = (String) session.getAttribute("user");
            response.getWriter().write(user_ID);
        }
    }
    @Autowired
    LoginServiceImpl loginServiceImpl;
    @RequestMapping("/userLogin")
    @ResponseBody
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String login(@RequestParam String User_name, @RequestParam String password, HttpSession session,Model model){
        User user = new User();
        user.setUser_name(User_name);
        user.setPassword(password);
        Integer flag = loginServiceImpl.LoginCheck(user);
        if(flag != null){
            session.setAttribute("user",user);
            return flag.toString();
        }else{
            model.addAttribute("msg","账号或密码错误");
            return null;
        }
    }


//    版本1：用户管理界面的登录
//    @PostMapping("/login")
//    public String main(User user, HttpSession session, Model model){
//        if(StringUtils.hasLength(user.getName()) && StringUtils.hasLength(user.getPassword()) ){
//            session.setAttribute("loginUser",user);
//            return "redirect:/main.html";
//        }else{
//            model.addAttribute("msg","账号密码错误");
//            return "login";
//        }
//    }

//      用户管理界面的检查
//    @GetMapping("main.html")
//    public String mainPage(HttpSession session,Model model){
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser!=null){
//            return "main";
//        }else
//            model.addAttribute("msg","账号密码错误,请重新登录");
//        return "login";
//    }


}
