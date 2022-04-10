package com.example.demo.service;


import com.example.demo.bean.Student;
import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentService {

    @Autowired
    StudentMapper studentMapper;

    public Student getbyid(int id){
        return studentMapper.getStudent(id);
    }

    public void insertStudent(Student student){
        studentMapper.insertStudent(student);
    }

}
