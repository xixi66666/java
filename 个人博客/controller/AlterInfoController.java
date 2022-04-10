package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.Impl.AlterInfoServiceImpl;
import com.example.demo.service.Impl.SelectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class AlterInfoController {
    @Autowired
    private AlterInfoServiceImpl alterInfoServiceImpl;
    @Autowired
    private SelectServiceImpl selectServiceImpl;


    String email = "1234";
    @RequestMapping("/editingOut")
    public String editingOut()
    {
        return "/profile-account-setting.html";
    }

    @RequestMapping("/editingIn")
    @ResponseBody
    public void editing(@RequestBody String msg)
    {
//        User user = selectServiceImpl.select(email);
//        ArrayList<String> arrayList = split_editing(msg);
//        user.setBirthday(arrayList.get(0));
//        user.setUser_name(arrayList.get(1));
//        user.setSex(Integer.parseInt(arrayList.get(2)));
//        user.setFirstname(arrayList.get(3));
//        user.setLastname(arrayList.get(4));
//        user.setPhone(arrayList.get(5));
//        alterInfoServiceImpl.AlterInfo(user);
    }
    public static ArrayList<String> split_editing(String msg)
    {
        int k;
        int j = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strings = new String[6];
        for (int i = 0; i < 6; i++)
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
        arrayList.add(strings[5] + msg.charAt(msg.length()-1));
        arrayList.addAll(Arrays.asList(strings).subList(0, 6));
        return arrayList;
    }
}
