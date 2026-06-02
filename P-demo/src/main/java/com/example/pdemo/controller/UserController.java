package com.example.pdemo.controller;


import com.example.pdemo.entity.Result;
import com.example.pdemo.entity.User;
import com.example.pdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 查询所有用户
    // GET http://localhost:8080/user/list
    @GetMapping("/list")
    public Result<List<User>> list() {
        List<User> list = userService.findAll();
        return Result.success(list);
    }

    // 根据 ID 查询
    // GET http://localhost:8080/user/1
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return Result.error("用户不存在");
        }
        return Result.success(user);
    }

    // 根据名字搜索
    // GET http://localhost:8080/user/search?name=张
    @GetMapping("/search")
    public Result<List<User>> search(@RequestParam String name) {
        List<User> list = userService.findByName(name);
        return Result.success(list);
    }

    // 添加用户
    // POST http://localhost:8080/user
    // Body: {"name":"新用户","age":25,"email":"new@example.com"}
    @PostMapping
    public Result save(@RequestBody User user) {
        try {
        userService.save(user);
        return Result.sucess();}
        catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    // 修改用户
    // PUT http://localhost:8080/user
    // Body: {"id":1,"name":"改名了","age":26,"email":"updated@example.com"}
    @PutMapping
    public Result update(@RequestBody User user) {
        try {
            userService.update(user);
            return Result.sucess();
        }
        catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    // 删除用户
    // DELETE http://localhost:8080/user/1
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            userService.delete(id);
            return Result.sucess();
        }
        catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}

