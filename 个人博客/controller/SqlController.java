package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.service.studentService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SqlController {
    @Autowired
    studentService studentService;

    @ResponseBody
    @GetMapping("/sql")
    public Student sql(@RequestParam("id") int id) {
        return studentService.getbyid(id);
    }


    @ResponseBody
    @GetMapping("/getstudent")
    public Student getstudent(@RequestParam("id") int id) {
        return studentService.getbyid(id);
    }

    @ResponseBody
    @GetMapping("/insert")
    public void insert(Student student) {
        studentService.insertStudent(student);
    }
}


