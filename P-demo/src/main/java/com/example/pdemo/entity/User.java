package com.example.pdemo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

// entity/User.java — 属性名要和数据库字段对应
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private LocalDateTime createTime;

    //无参构造
    public User() {
    }

    //有参构造
    public User(Integer id, String name, Integer age, String email, LocalDateTime createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.createTime = createTime;
    }

    //getter,setter方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}

