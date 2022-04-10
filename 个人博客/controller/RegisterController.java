package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class RegisterController
{
    @Autowired
    private RegisterServiceImpl registerServiceImpl;
    @Autowired
    private AlterInfoServiceImpl alterInfoService;

    @RequestMapping("/registerOut")
    public String registerOut(){
        return "/sign-in.html";
    }
    @RequestMapping("/registerIn")
    @ResponseBody
    public String register(@RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String repeat_password,
                           @RequestParam String User_name,
                           @RequestParam String phone
    )
    {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setUser_name(User_name);
        user.setPhone(phone);
        String msg = "";
        if(password.equals(repeat_password)){
            System.out.println(registerServiceImpl.insertNewClient(user));
            user.setLevel(1);
            user.setExperience(0);
            alterInfoService.AlterInfo(user);
            msg = "注册成功";
        }else{
            msg = "两次密码不一致";
        }
        return msg;
//        String string;
//        String email = split_editing(msg).get(1);
//        String password = split_editing(msg).get(2);
//        String repeat_password = split_editing(msg).get(3);
//        User user = new User(email,password);
//        user.setPhone(split_editing(msg).get(4));
//        String code = split_editing(msg).get(0);
//        if(password.equals(repeat_password))
//        {
//            System.out.println("if");
//            try {
//                registerServiceImpl.insertNewClient(user);
//                user.setLevel(1);
//                user.setExperience(0);
//                alterInfoService.AlterInfo(user);
//                string = "注册成功";
//            }
//            catch (Exception e)
//            {
//                string = "邮箱已存在";
//            }
//        }
//        else {
//            System.out.println("else");
//            string = "两次输入的密码不一致";
//        }
//        System.out.println(string + "!!!");
//        return string;
    }

    public static ArrayList<String> split_editing(String msg)
    {
        int k;
        int j = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strings = new String[6];
        for (int i = 0; i < 5; i++)
            strings[i] = "";
        for(int i = 0;i<msg.length();i++)
        {
            if(msg.charAt(i) == '=')
            {
                k = i+1;
                while(msg.charAt(k) != '&' && k < msg.length()-1)
                {
                    strings[j] += msg.charAt(k);
                    k++;
                }
                j++;
            }
        }
        arrayList.add(strings[4] + msg.charAt(msg.length()-1));
        arrayList.addAll(Arrays.asList(strings).subList(0, 5));
        return arrayList;
    }
//    @RequestMapping
//    public String test()
//    {
//        return "/register.html";
//    }
}
