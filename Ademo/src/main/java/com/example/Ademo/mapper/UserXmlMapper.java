package com.example.Ademo.mapper;

import com.example.Ademo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserXmlMapper {

    List<User> findByCondition(@Param("username") String username,
                               @Param("price") Integer price);

    List<User> findById(Integer id);

    User findByUsername(String username);

    void insert(User user);
    void update(User user);
    void delete(Integer id);
}
