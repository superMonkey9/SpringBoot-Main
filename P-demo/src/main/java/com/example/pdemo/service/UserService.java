package com.example.pdemo.service;

import com.example.pdemo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    List<User> findByName(String name);
    void insert(User user);
    void update(User user);
    void delete(Integer id);
}
