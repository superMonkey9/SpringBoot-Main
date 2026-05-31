package com.example.demo.entity;

import java.time.LocalDateTime;

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private LocalDateTime createTime;
    public User(){}
    public User(Integer id, String name, Integer age, String email, LocalDateTime createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.createTime = createTime;
    }

    public User(Integer id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

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

//package com.example.demo.entity;
//
//public class User {
//    private Integer id;
//    private String name;
//    private Integer age;
//    private String email;
//
//    // 无参构造
//    public User() {}
//
//    // 全参构造
//    public User(Integer id, String name, Integer age, String email) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.email = email;
//    }
//
//    // getter 和 setter（每个都要写）
//    public Integer getId() { return id; }
//    public void setId(Integer id) { this.id = id; }
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//    public Integer getAge() { return age; }
//    public void setAge(Integer age) { this.age = age; }
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//}