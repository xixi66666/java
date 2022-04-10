package com.example.demo.service.Impl;

import com.example.demo.bean.User;
import com.example.demo.mapper.SelectMapper;
import com.example.demo.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectServiceImpl implements SelectService
{
    @Autowired
    private SelectMapper selectMapper;

    @Override
    public User select(String email)
    {
        return selectMapper.select(email);
    }
}
