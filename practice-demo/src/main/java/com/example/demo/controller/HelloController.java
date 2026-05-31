package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ⭐ 控制器：接收请求，返回数据
@RestController
@RequestMapping("/hello")
public class HelloController {

    // GET http://localhost:8080/hello
    @GetMapping
    public String sayHello() {
        return "Hello Spring Boot!";
    }
}
