package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    // ⭐ 把列表定义为类的属性（放在方法外面），这样数据才能保存住,如果写在方法里面，每次调用都会重新创建，数据就丢了。
    private List<User> userList = new ArrayList<>() {{
        add(new User(1, "张三", 20, "zhangsan@example.com"));
        add(new User(2, "李四", 25, "lisi@example.com"));
        add(new User(3, "王五", 30, "wangwu@example.com"));
    }};


    // GET http://localhost:8080/user/1
    // 返回单个对象
    @GetMapping("/one")
    public User getOne() {
        return new User(1, "张三", 20, "zhangsan@example.com");
    }


    // GET http://localhost:8080/user/list
    // 返回列表
    @GetMapping("/list")
    public List<User> list() {
        return userList;  // ⭐ 直接返回 userList，不要在方法里重新创建
    }


    // POST http://localhost:8080/user
    // 请求体：{"name":"赵六","age":28,"email":"zhaoliu@example.com"}
    @PostMapping
    public User save(@RequestBody User user) {
        // Spring Boot 自动把 JSON 转成 User 对象
        System.out.println("收到用户：" + user.getName());
        // ⭐ 给新用户设置 ID（当前最大 ID + 1）
        //int maxId = userList.stream().mapToInt(User::getId).max().orElse(0);(高级写法)
        int maxId = 0;
        for (User u : userList) {
            if (u.getId() > maxId) {
                maxId = u.getId();
            }
        }
        user.setId(maxId + 1);
        // ⭐ 把用户添加到列表里（这样才能保存住）
        userList.add(user);
        return user;
    }

    // PUT http://localhost:8080/user
    // 请求体：{"id":1,"name":"张三改名","age":21}
    @PutMapping
    public User update(@RequestBody User user) {
        // 实际项目中调用 service.update(user)
        System.out.println("修改用户：" + user.getId());
        return user;
    }

    // DELETE http://localhost:8080/user/3
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        // 实际项目中调用 service.delete(id)
        System.out.println("删除用户：" + id);
        return "删除成功，id=" + id;
    }
}
