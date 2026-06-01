package com.example.pdemo.mapper;

import com.example.pdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user ORDER BY id DESC")
    List<User> findAll();

    @Select("SELECT * FROM user WHERE id=#{id}")
    User findById(Integer id);

    @Select("SELECT * FROM user WHERE name LIKE COUNT('%', #{name}, '%')")
    List<User> findByName(String name);

    @Insert("INSERT INTO user(name,age,email) VALUES (#{name}, #{age}, #{email}) ")
    void insert(User user);

    @Update("UPDATE user SET name=#{name}, age=#{age}, email=#{email} WHERE id=#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    void delete(Integer id);
}
