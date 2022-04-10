package com.example.demo.controller;


/*
文件上传测试
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FormController {


    @GetMapping("/form_layouts.html")
    private String form_layouts(){
        return "form/form_layouts";
    }


    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("name") String name,
                         @RequestPart("headimage") MultipartFile multipartFile,
                         @RequestPart("headimages") MultipartFile[] photos) throws IOException {


        if (!multipartFile.isEmpty()) {
            //保存到文件服务器，OSS服务器
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D:\\cache\\" + originalFilename));
        }
        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\cache\\" + originalFilename));
                }
            }
        }
        return "main";
    }
}
