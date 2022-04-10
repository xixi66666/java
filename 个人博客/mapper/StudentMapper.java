package com.example.demo.mapper;

import com.example.demo.bean.Student;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StudentMapper {
    public Student getStudent(int id);

    public void insertStudent(Student student);
}
