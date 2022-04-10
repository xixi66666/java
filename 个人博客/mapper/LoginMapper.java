package com.example.demo.mapper;


import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    Integer checklogin(User user);
}
