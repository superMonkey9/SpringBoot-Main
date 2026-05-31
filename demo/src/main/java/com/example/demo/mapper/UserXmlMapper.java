package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserXmlMapper {
    List<User> findAll();
    User findById(Integer id);
    List<User> findByName(String name);
    List<User> findByCondition(@Param("name") String name,
                               @Param("age") Integer age,
                               @Param("email") String email);
    void insert(User user);
    void update(User user);
    void delete(Integer id);
}
