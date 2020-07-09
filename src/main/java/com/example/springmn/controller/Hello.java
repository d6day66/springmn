package com.example.springmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hello")
public class Hello {
    @Autowired
    HttpServletRequest request;
    @RequestMapping
    public String hello() {
        String str = "你的ip是： ";
       return str + request.getRequestURL().toString();

    }
}
