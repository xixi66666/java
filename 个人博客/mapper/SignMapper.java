package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SignMapper
{
    @Update("update client set level = #{client.level},experience = #{client.experience} where email = #{client.email}")
    int sign(@Param("client") User user);
}
