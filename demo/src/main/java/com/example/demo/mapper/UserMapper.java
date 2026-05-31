package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface UserMapper {

    // 查询所有
    @Select("SELECT * FROM user")
    List<User> findAll();

    // 根据 ID 查询
    @Select("SELECT *FROM user WHERE id=#{id}")
    User findById(Integer id);

    // 根据名字模糊查询
    @Select("SELECT * FROM user WHERE name LIKE COUNT('%',#{name},'%')")
    List<User> findByName(String name);

    // 插入（自动回填 id）
    @Select("INSERT INTO user(name,age,email) VALUES (#{name},#{age},#{email})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(User user);

    // 修改
    @Update("UPDATE user SET name=#{name}, age=#{age}, email=#{email} WHERE id=#{id}")
    void update(User user);

    //删除
    @Delete("DELETE FROM user WHERE id=#{id}")
    void delete(Integer id);

    // 条件查询（多个可选条件）
    @Select("<script>" +
            "SELECT * FROM user WHERE 1=1" +
            "<if test='name != null and name != \"\"'>" +
            "  AND name LIKE CONCAT('%', #{name}, '%')" +
            "</if>" +
            "<if test='age != null'>" +
            "  AND age = #{age}" +
            "</if>" +
            "</script>")
    List<User> findByCondition(@Param("name") String name, @Param("age") Integer age);
}

