package com.example.demo.service.Impl;

import com.example.demo.bean.User;
import com.example.demo.mapper.AlterInfoMapper;
import com.example.demo.service.AlterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlterInfoServiceImpl implements AlterInfoService
{
    @Autowired
    private AlterInfoMapper alterInfoMapper;
    @Override
    public int AlterInfo(User user)
    {
        return alterInfoMapper.AlterInfo(user);
    }
}
