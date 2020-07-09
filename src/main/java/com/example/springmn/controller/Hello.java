package com.example.springmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/hello")
public class Hello {
    @Autowired
    HttpServletRequest request;

    @RequestMapping
    public String hello() {
        BufferedWriter iptxt = null;
        String str1 = "你的ip是： ";
        String str2 = request.getRequestURL().toString();
        try {

            iptxt = new BufferedWriter(new FileWriter("iptxt.txt",true));
            iptxt.write(str1 + str2);
            iptxt.newLine();
            iptxt.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("出错了");
        }finally {
            try {
                iptxt.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str1 + str2;
    }
}
