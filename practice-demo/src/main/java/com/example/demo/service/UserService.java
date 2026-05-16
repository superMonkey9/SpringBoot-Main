package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

// ⭐ Service 接口：定义"能做什么"
public interface UserService {
    List<User> findAll();           // 查询所有用户
    User findById(Integer id);      // 根据 ID 查询用户
    void save(User user);           // 保存用户
    void update(User user);         // 修改用户
    void delete(Integer id);        // 删除用户
}
