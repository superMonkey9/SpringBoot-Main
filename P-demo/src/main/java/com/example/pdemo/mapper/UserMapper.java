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
