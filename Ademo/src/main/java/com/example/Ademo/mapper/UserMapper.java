package com.example.Ademo.mapper;

import com.example.Ademo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //根据id查询
    @Select("select * from user where id=#{id} ")
    User findById (Integer id);

    @Select("select * from user where name=#{username} ")
    List<User> findByUsername (String username);

    @Select("select * from user order by desc")
    List<User> findAll();

    @Insert("insert into user(id,username,price,inventory) values(#{id},#{username},#{price},#{inventory})")
    void insert(User user);

    @Update("update user set id=#{id},username=#{username},price=#{price},inventory=#{inventory}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    void delete(Integer id);

    // 条件查询（多个可选条件）
    @Select("<script>" +
            "SELECT * FROM user WHERE 1=1" +
            "<if test='username != null and username != \"\"'>" +
            "  AND username LIKE CONCAT('%', #{name}, '%')" +
            "</if>" +
            "<if test='price != null'>" +
            "  AND price = #{price}" +
            "</if>" +
            "</script>")
    List<User> findByCondition(@Param("username") String username, @Param("price") Integer price);
}
