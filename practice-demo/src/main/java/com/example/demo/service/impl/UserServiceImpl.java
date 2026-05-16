package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

// ⭐ Service 实现类：定义"怎么做"
@Service
public class UserServiceImpl implements UserService {

    // 用 ArrayList 模拟数据库（后面学了数据库可以换成真正的查询）
    private List<User> userList = new ArrayList<>() {{
        add(new User(1, "张三", 20, "zhangsan@example.com"));
        add(new User(2, "李四", 25, "lisi@example.com"));
        add(new User(3, "王五", 30, "wangwu@example.com"));
    }};

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public User findById(Integer id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null; // 没找到返回 null
    }

    @Override
    public void save(User user) {
        // 设置新 ID（当前最大 ID + 1）
        int maxId = userList.stream()
                .mapToInt(User::getId)
                .max()
                .orElse(0);
        user.setId(maxId + 1);
        userList.add(user);
    }

    @Override
    public void update(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(user.getId())) {
                userList.set(i, user); // 替换旧数据
                return;
            }
        }
    }

    @Override
    public void delete(Integer id) {
        userList.removeIf(user -> user.getId().equals(id));
    }
}
