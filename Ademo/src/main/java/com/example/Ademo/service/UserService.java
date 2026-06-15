package com.example.Ademo.service;

import com.example.Ademo.entity.User;
import com.example.Ademo.mapper.UserXmlMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService{
    List<User> findByCondition(@Param("username") String username,
                               @Param("price") Integer price);

    List<User> findById(Integer id);

    User findByUsername(String username);

    void save(User user);
    void update(User user);
    void delete(Integer id);
}
