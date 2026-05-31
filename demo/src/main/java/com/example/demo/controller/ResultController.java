package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {
    private List<User> userList=new ArrayList<>(){{
        add(new User(1, "张三", 20, "zhangsan@example.com"));
        add(new User(2, "李四", 25, "lisi@example.com"));
        }};


    // 查询成功，返回数据
    // GET http://localhost:8080/result/user/list
    @GetMapping("/user/list")
    public Result<List<User>> list() {
        return Result.success(userList);
    }


    // 查询成功，返回单个
    // GET http://localhost:8080/result/user/1
    @GetMapping("/user/{id}")
    public Result<User> findById(@PathVariable Integer id) {
        for(User user:userList){
            if(user.getId().equals(id)){
                return Result.success(user);
            }
        }
        return Result.error("用户不存在");
    }


    // 添加成功
    // POST http://localhost:8080/result/user
    @PostMapping("/user")
    public Result save(@RequestBody User user) {
        user.setId(userList.size()+1);
        userList.add(user);
        return Result.sucess();
    }


    // 业务失败示例
    // GET http://localhost:8080/result/user/check/1
    @GetMapping("/user/check/{id}")
    public Result checkUser(@PathVariable Integer id){
        if(id<0){
            return Result.error("ID不能小于0");
        }
        if(id>100){
            return Result.error("ID不能大于100");
        }
        return Result.success("ID有效");
    }
}
