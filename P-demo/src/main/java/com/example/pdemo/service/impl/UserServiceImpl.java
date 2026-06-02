package com.example.pdemo.service.impl;

import com.example.pdemo.entity.User;
import com.example.pdemo.mapper.UserMapper;
import com.example.pdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public void save(User user) {
        // 这里可以加业务逻辑，比如检查用户名是否重复
        List<User> existing = userMapper.findByName(user.getName());
        if (!existing.isEmpty()) {
            // 实际项目中应该抛出自定义异常
            throw new RuntimeException("用户名已存在");
        }
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        // 检查用户是否存在
        User existing = userMapper.findById(user.getId());
        if (existing == null) {
            throw new RuntimeException("用户不存在");
        }
        userMapper.update(user);
    }

    @Override
    public void delete(Integer id) {
        User existing = userMapper.findById(id);
        if (existing == null) {
            throw new RuntimeException("用户不存在");
        }
        userMapper.delete(id);
    }
}
