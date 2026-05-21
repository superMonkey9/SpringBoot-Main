package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ⭐ 用户管理控制器：包含完整的增删改查接口
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired  // 注入 Service
    private UserService userService;

    // ========== 查询接口 ==========

    // GET http://localhost:8080/user/list —— 查询所有用户
    @GetMapping("/list")
    public Result<List<User>> list() {
        List<User> list = userService.findAll();
        return Result.success(list);
    }

    // GET http://localhost:8080/user/1 —— 根据 ID 查询用户
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return Result.error("用户不存在");
        }
        return Result.success(user);
    }

    // GET http://localhost:8080/user/search?name=张 —— 按名字搜索
    @GetMapping("/search")
    public Result<List<User>> search(@RequestParam String name) {
        List<User> list = userService.findAll();
        // 简单的模糊搜索
        list.removeIf(user -> !user.getName().contains(name));
        return Result.success(list);
    }

    // ========== 增删改接口 ==========

    // POST http://localhost:8080/user —— 添加用户
    @PostMapping
    public Result<Void> save(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    // PUT http://localhost:8080/user —— 修改用户
    @PutMapping
    public Result<Void> update(@RequestBody User user) {
        User existing = userService.findById(user.getId());
        if (existing == null) {
            return Result.error("用户不存在");
        }
        userService.update(user);
        return Result.success();
    }

    // DELETE http://localhost:8080/user/1 —— 删除用户
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Integer id) {
        User existing = userService.findById(id);
        if (existing == null) {
            return Result.error("用户不存在");
        }
        userService.delete(id);
        return Result.success();
    }
}
