package com.example.demo.service;

import com.example.demo.bean.User;
import org.springframework.data.relational.core.sql.In;

public interface LoginService {
    Integer LoginCheck(User user);
}
