package com.example.demo.entity;

// ⭐ 实体类：和数据库表一一对应
public class User {
    // 第一部分：私有属性（对应数据库字段）
    private Integer id;
    private String name;
    private Integer age;
    private String email;

    // 第二部分：无参构造（必须有）
    public User() {}

    // 第三部分：全参构造（方便快速创建对象）
    public User(Integer id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // 第四部分：getter 方法
    public Integer getId() { return id; }
    public String getName() { return name; }
    public Integer getAge() { return age; }
    public String getEmail() { return email; }

    // 第五部分：setter 方法
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(Integer age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
}
