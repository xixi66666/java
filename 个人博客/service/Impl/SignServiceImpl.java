package com.example.demo.service.Impl;

import com.example.demo.bean.User;
import com.example.demo.mapper.SignMapper;
import com.example.demo.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;

public class SignServiceImpl implements SignService
{
    @Autowired
    private SignMapper signMapper;
    @Override
    public int sign(User user)
    {
        return signMapper.sign(user);
    }
}
