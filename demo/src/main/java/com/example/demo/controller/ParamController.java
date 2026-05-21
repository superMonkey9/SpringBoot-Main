package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/param")
public class ParamController {

    // GET http://localhost:8080/param/test1?name=张三&age=20
    @GetMapping("/test1")
    public String testRequestParam(
            @RequestParam String name,
            @RequestParam Integer age
    ) {
        return "姓名；" + name + ",年龄：" + age;
    }


    // GET http://localhost:8080/param/test2?name=张三
    // age 不传也没关系，有默认值
    @GetMapping("/test2")
    public String testRequestParam2(
            @RequestParam String name,
            @RequestParam(defaultValue = "18") Integer age
    ) {
        return "姓名；" + name + ",年龄：" + age;
    }


    // GET http://localhost:8080/param/test3?name=张三
    // age 可选，不传为 null
    @GetMapping("/test3")
    public String testRequestParam3(
            @RequestParam String name,
            @RequestParam(required = false) Integer age
    ) {
        return "姓名：" + name + "，年龄：" + (age != null ? age : "未知");
    }


    // GET http://localhost:8080/param/test4?keyword=Spring&page=1&size=10
    // 模拟搜索分页
    @GetMapping("/test4")
    public Map<String, Object> testRequestParam4(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        Map<String, Object> result = new HashMap<>();
        result.put("keyword", keyword);
        result.put("page", page);
        result.put("size", size);
        result.put("total", 100);  // 模拟总数
        return result;
    }


    // GET http://localhost:8080/param/user/5
    @GetMapping("/user/{id}")
    public String testPathVariable(@PathVariable Integer id
    ) {
        return "查询用户 id=" + id;
    }


    // GET http://localhost:8080/param/user/5/order/100
    @GetMapping("/user/{userId}/order/{orderId}")
    public String testPathVariable(
            @PathVariable Integer userId,
            @PathVariable Integer orderId
    ) {
        return "用户 " + userId + " 的订单 " + orderId;
    }


    // POST http://localhost:8080/param/user
    // Body: {"name":"张三","age":20}
    @PostMapping("/user")
    public Map<String, Object> testPathVariable(@RequestBody Map<String, Object> usermap
    ) {
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "收到数据");
        result.put("data", usermap);
        return result;
    }


    // 更推荐：直接转成对象
    // POST http://localhost:8080/param/user2
    // Body: {"name":"张三","age":20,"email":"test@example.com"}
    @PostMapping("/user2")
    public User testPathVariable2(@RequestBody User user) {
        System.out.println("收到；"+user);
        return user;
    }


    // POST http://localhost:8080/param/mix/5
    // Body: {"name":"张三","age":20}
    // 路径参数 + 请求体参数 混合使用
    @PostMapping("/mix/{id}")
    public Map<String, Object> testmix(
            @PathVariable Integer id,
            @RequestBody User user
    ) {
        Map<String, Object> result = new HashMap<>();
        result.put("id_from_path",id);
        result.put("user_from_body",user);
        return result;
    }

}










