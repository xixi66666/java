package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AlterInfoMapper
{
    @Update("update client set User_name = #{client.User_name},sex = #{client.sex}," +
            "firstname = #{client.firstname},lastname = #{client.lastname},phone = #{client.phone}" +
            ",birthday = #{client.birthday},level = #{client.level}, experience = #{client.experience} where email = #{client.email}")
    int AlterInfo(@Param("client") User user);
}
