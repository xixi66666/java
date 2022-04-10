package com.example.demo.service.Impl;

import com.example.demo.bean.User;
import com.example.demo.mapper.RegisterMapper;
import com.example.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService
{
    @Autowired
    private RegisterMapper register_Mapper;

    @Override
    public int insertNewClient(User user) {
        return register_Mapper.insertNewClient(user);
    }
}
