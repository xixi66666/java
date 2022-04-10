package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegisterMapper
{

    //表结构 UserID（唯一,自增） email（唯一） password  都是字符串
    int insertNewClient(User user);
}
