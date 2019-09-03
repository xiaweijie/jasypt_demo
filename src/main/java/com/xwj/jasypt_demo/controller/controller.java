package com.xwj.jasypt_demo.controller;

import com.xwj.jasypt_demo.config.MyStringEncryptor;
import com.xwj.jasypt_demo.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class controller {
 /*   @Autowired
    MyStringEncryptor myStringEncryptor;*/

    @Autowired
    UserDao userDao;

    @RequestMapping("/w")
    public List<Map> gets(){
        List<Map> list = userDao.list();
        System.out.println(list);
        return list;
    }
    @RequestMapping("/getPwd")
    public String getPwd(){
        MyStringEncryptor myStringEncryptor=new MyStringEncryptor();
        String root = myStringEncryptor.encrypt("jdbc:mysql://localhost:3306/springsecurity?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        System.out.println(root);
        return root;
    }
}
