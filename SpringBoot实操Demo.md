# Spring Boot 实操 Demo 手册

> 本文件包含所有知识点的完整可运行代码示例，按学习路线组织，每个 Demo 都可以直接复制使用。
> 遇到不懂的 Java 语法？👉 [点击跳转到 Java 知识点](Java知识点.md)
> 最后更新：2026-05-17

---

## 目录

- [新手必读：开始之前你需要知道的](#新手必读开始之前你需要知道的)
- [Demo 1：创建第一个 Spring Boot 项目](#demo-1创建第一个-spring-boot-项目)
- [Demo 2：项目结构与分层](#demo-2项目结构与分层)
- [Demo 3：REST API —— GET 请求](#demo-3rest-api--get-请求)
- [Demo 4：REST API —— POST 请求](#demo-4rest-api--post-请求)
- [Demo 5：REST API —— PUT 和 DELETE 请求](#demo-5rest-api--put-和-delete-请求)
- [Demo 6：参数接收全解](#demo-6参数接收全解)
- [Demo 7：Result 统一返回封装](#demo-7result-统一返回封装)
- [Demo 8：连接 MySQL 数据库](#demo-8连接-mysql-数据库)
- [Demo 9：MyBatis 注解方式 CRUD](#demo-9mybatis-注解方式-crud)
- [Demo 10：MyBatis XML 方式 CRUD](#demo-10mybatis-xml-方式-crud)
- [Demo 11：MyBatis 动态 SQL](#demo-11mybatis-动态-sql)
- [Demo 11.5：Service 层详解](#demo-115service-层详解)
- [Demo 12：完整项目 —— 用户管理系统](#demo-12完整项目--用户管理系统)
- [Demo 13：前端调用接口示例](#demo-13前端调用接口示例)
- [练习题](#练习题)

---

# 新手必读：开始之前你需要知道的

在动手写代码之前，先认识一下项目里这些"奇怪的文件和文件夹"都是干什么的。

### pom.xml —— 项目的"购物清单"

**是什么：** 这是 Maven 的配置文件，告诉项目"我需要哪些工具（依赖）"。

**通俗理解：** 你要做菜，pom.xml 就是你的购物清单——"我需要鸡蛋、面粉、油"。Maven 会根据这个清单帮你去"超市"（远程仓库）把东西下载回来。

**你不需要手动创建它**，用 Spring Initializr 生成项目时它就自动有了。

**你需要关心的内容：** 只有 `<dependencies>` 部分，里面列出了项目用到的所有依赖。需要新功能时，在这里加一行依赖就行。

### src 文件夹 —— 你的代码放这里

```
src/
├── main/
│   ├── java/           ← 你的 Java 代码全部放这里
│   │   └── com/example/demo/
│   │       └── DemoApplication.java   ← 启动类（程序入口）
│   └── resources/      ← 配置文件和静态资源
│       └── application.properties  ← 配置文件（端口号、数据库等）
└── test/               ← 测试代码放这里（暂时不用管）
```

**简单记：**
- `src/main/java/` —— 写 Java 代码的地方
- `src/main/resources/` —— 放配置文件的地方
- `src/test/` —— 放测试代码的地方（先不管）

### application.properties / application.yml —— 项目的"设置页面"

**是什么：** Spring Boot 的配置文件，用来设置端口号、数据库连接等。

**两种格式（功能一样，选一种就行）：**

```properties
# 格式一：application.properties（键值对）
server.port=8080
```

```yaml
# 格式二：application.yml（推荐，层次更清晰）
server:
  port: 8080
```

**初学阶段你只需要知道：** 如果不写任何配置，Spring Boot 会用默认值（比如默认端口是 8080）。

### target 文件夹 —— 编译后的文件（不用管）

这是 Maven 编译后自动生成的文件夹，**你不需要动它**。如果遇到奇怪的问题，可以删除这个文件夹然后重新编译。

### .idea 文件夹 / .iml 文件 —— IDEA 的配置（不用管）

这是 IDEA 自动生成的项目配置文件，**你不需要动它**，也不需要提交到 git。

### 你需要记住的文件夹

| 文件夹 | 作用 | 你需要做什么 |
|--------|------|-------------|
| `pom.xml` | 依赖清单 | 需要新功能时在这里加依赖 |
| `src/main/java/` | 写代码的地方 | 你的 Java 代码都在这里写 |
| `src/main/resources/` | 配置文件 | 数据库连接、端口号等配置写这里 |
| `target/` | 编译输出 | 不用管，自动生成 |
| `.idea/` | IDEA 配置 | 不用管，自动生成 |

---

# Demo 1：创建第一个 Spring Boot 项目

> ⬆ [返回目录](#目录) | ⬇ [下一章：Demo 2](#demo-2项目结构与分层)
> 📖 [点击跳转到对应知识点：创建项目](SpringBoot知识点.md#1-创建项目)

## 步骤一：用 Spring Initializr 创建项目

1. 打开 https://start.spring.io
2. 选择配置：
   - Project: **Maven**
   - Language: **Java**
   - Spring Boot: **3.x.x**（选最新稳定版）
   - Group: `com.example`
   - Artifact: `demo`
   - Packaging: **Jar**
   - Java: **17**
3. 添加依赖（点击 ADD DEPENDENCIES）：
   - **Spring Web**（Web 开发必备）
4. 点击 **GENERATE** 下载项目
5. 解压，用 IDEA 打开

## 步骤二：运行项目

**启动类就是 `DemoApplication.java`**，它在 `src/main/java/com/example/demo/` 目录下。

在 IDEA 左侧项目栏找到它，打开后点击 `main` 方法左边的 **绿色三角 ▶**，选 **Run 'DemoApplication'**。

启动类的代码长这样（你不需要改它，只要知道怎么运行就行）：

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

运行成功后控制台会显示：
```
Tomcat started on port(s): 8080 (http)
Started DemoApplication in 1.5 seconds
```

## 步骤三：验证项目运行

打开浏览器访问 http://localhost:8080

> 虽然会显示 404（因为还没写接口），但说明项目已经成功启动了！404 只是没有对应的处理方法。

---

# Demo 2：项目结构与分层

> ⬆ [上一章：Demo 1](#demo-1创建第一个-spring-boot-项目) | ⬇ [下一章：Demo 3](#demo-3rest-api--get-请求) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：项目结构](SpringBoot知识点.md#2-项目结构)

## 创建完整的分层目录结构

在 `src/main/java/com/example/demo/` 下创建以下包：

```
com.example.demo/
├── DemoApplication.java          ← 启动类（已存在）
├── controller/                   ← 新建
│   └── UserController.java
├── service/                      ← 新建
│   ├── UserService.java
│   └── impl/
│       └── UserServiceImpl.java
├── mapper/                       ← 新建
│   └── UserMapper.java
└── entity/                       ← 新建
    └── User.java
```

> **创建包的方法：** 在 IDEA 中右键 `com.example.demo` → New → Package，输入名称即可。

---

# Demo 3：REST API —— GET 请求

> ⬆ [上一章：Demo 2](#demo-2项目结构与分层) | ⬇ [下一章：Demo 4](#demo-4rest-api--post-请求) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：接口开发](SpringBoot知识点.md#3-接口开发)

## Demo 3.1：最简单的 GET 接口

```java
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    // GET http://localhost:8080/hello
    @GetMapping
    public String sayHello() {
        return "Hello Spring Boot!";
    }
}
```

### 知识点：你需要记住的

**import 部分：** 就是"我要用 Spring 提供的工具"，不用手写，IDEA 打 `@GetM` 按 Tab 会自动补全。

**三个核心注解（必须记住）：**

| 注解 | 作用 | 生活类比 |
|------|------|---------|
| `@RestController` | 声明这是一个控制器，返回数据（不是页面） | 门上挂牌子："我是服务员，专门给数据" |
| `@RequestMapping("/hello")` | 定义访问地址 | 地址写在牌子上："找我就来 /hello" |
| `@GetMapping` | 处理 GET 请求，执行下面的方法 | "只接待 GET 请求" |

**核心逻辑就一行：** `return "Hello Spring Boot!";`
浏览器访问 `/hello` → Spring 找到这个方法 → 把返回内容发给浏览器。

> **注解就是"贴标签"**，用多了自然记住，先跑起来看效果最重要。

**运行：** 在 IDEA 中打开 `DemoApplication.java`，点击 `main` 方法左边的绿色三角运行。

**测试：** 浏览器访问 [http://localhost:8080/hello](http://localhost:8080/hello)，页面显示 `Hello Spring Boot!`

## Demo 3.2：返回对象（自动转 JSON）

```java
package com.example.demo.entity;

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;

    // 无参构造
    public User() {}

    // 全参构造
    public User(Integer id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // getter 和 setter（每个都要写）
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

```java
package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    // ⭐ 把列表定义为类的属性（放在方法外面），这样数据才能保存住
    private List<User> userList = new ArrayList<>() {{
        add(new User(1, "张三", 20, "zhangsan@example.com"));
        add(new User(2, "李四", 25, "lisi@example.com"));
        add(new User(3, "王五", 30, "wangwu@example.com"));
    }};

    // GET http://localhost:8080/user/one
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
}
```

> ⭐ **重要区别：** 列表 `userList` 定义在方法外面（类的属性），数据才能保存住。如果写在方法里面，每次调用都会重新创建，数据就丢了。

**测试：** 浏览器访问 http://localhost:8080/user/list，会看到：

```json
[
    {"id":1,"name":"张三","age":20,"email":"zhangsan@example.com"},
    {"id":2,"name":"李四","age":25,"email":"lisi@example.com"},
    {"id":3,"name":"王五","age":30,"email":"wangwu@example.com"}
]
```

> **观察：** 你只写了 `return list;`，Spring Boot 自动帮你转成了 JSON。这就是 `@RestController` + Jackson 的威力。

### 知识点：你需要记住的

- **`@GetMapping("/one")`** —— 括号里写路径，最终访问地址是 `/user/one`（类上的 `/user` + 方法上的 `/one`）
- **直接 return 对象** —— Spring Boot 自动把 Java 对象转成 JSON 返回，不用你手动转
- **`return list`** —— 返回 List 也一样，自动变成 JSON 数组

---

# Demo 4：REST API —— POST 请求

> ⬆ [上一章：Demo 3](#demo-3rest-api--get-请求) | ⬇ [下一章：Demo 5](#demo-5rest-api--put-和-delete-请求) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：接口开发](SpringBoot知识点.md#3-接口开发)

## Demo 4.1：接收 JSON 数据

```java
// 在 UserController 中添加

// POST http://localhost:8080/user
// 请求体：{"name":"赵六","age":28,"email":"zhaoliu@example.com"}
@PostMapping
public User save(@RequestBody User user) {
    // Spring Boot 自动把 JSON 转成 User 对象
    System.out.println("收到用户：" + user.getName());
    // ⭐ 给新用户设置 ID（当前最大 ID + 1）
    int maxId = userList.stream().mapToInt(User::getId).max().orElse(0);
    user.setId(maxId + 1);
    // ⭐ 把用户添加到列表里（这样才能保存住）
    userList.add(user);
    return user;
}
```

> ⭐ **注意：** 这里用的是 Demo 3.2 里的 `userList`，必须先按 Demo 3.2 的写法把列表定义为类的属性，POST 添加的数据才会保存住。

### 知识点：你需要记住的

| 注解 | 作用 |
|------|------|
| `@PostMapping` | 处理 POST 请求（用于"新增/提交数据"） |
| `@RequestBody` | 把请求体中的 JSON 自动转成 Java 对象 |

> **一句话：** `@PostMapping` 接收请求，`@RequestBody` 把 JSON 转成对象，Spring 全自动。

### ⭐ 浏览器 vs POST 请求

**浏览器地址栏输入网址 = 发 GET 请求。** 所以浏览器只能访问 `@GetMapping` 的接口，不能访问 `@PostMapping` 的接口。

| 访问方式 | 能发 GET | 能发 POST |
|---------|---------|----------|
| 浏览器地址栏 | ✅ 能 | ❌ 不能 |
| IDEA 的 HTTP Client | ✅ 能 | ✅ 能 |
| Postman | ✅ 能 | ✅ 能 |
| curl 命令 | ✅ 能 | ✅ 能 |

> **简单记：** 浏览器只能"看"（GET），不能"提交"（POST）。想测 POST 接口，用 IDEA 的 HTTP Client 或 Postman。

**测试方式：** 浏览器无法直接发 POST 请求，需要使用工具。

### 测试工具一：curl（命令行）

```bash
curl -X POST http://localhost:8080/user \
  -H "Content-Type: application/json" \
  -d '{"name":"赵六","age":28,"email":"zhaoliu@example.com"}'
```

### 测试工具二：IDEA 的 HTTP Client

在项目中创建 `test.http` 文件：

```http
### GET 请求 - 查询用户列表
GET http://localhost:8080/user/list

### POST 请求 - 添加用户
POST http://localhost:8080/user
Content-Type: application/json

{
    "name": "赵六",
    "age": 28,
    "email": "zhaoliu@example.com"
}
```
    
点击请求左边的绿色运行按钮即可发送请求。

### 测试工具三：Postman

1. 下载安装 Postman
2. 新建请求，选择 POST
3. 输入 URL: `http://localhost:8080/user`
4. 选择 Body → raw → JSON
5. 输入 JSON 数据
6. 点击 Send

---

# Demo 5：REST API —— PUT 和 DELETE 请求

> ⬆ [上一章：Demo 4](#demo-4rest-api--post-请求) | ⬇ [下一章：Demo 6](#demo-6参数接收全解) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：接口开发](SpringBoot知识点.md#3-接口开发)

```java
// 在 UserController 中添加

// PUT http://localhost:8080/user
// 请求体：{"id":1,"name":"张三改名","age":21}
@PutMapping
public User update(@RequestBody User user) {
    // ⭐ 遍历列表，找到对应 ID 的用户，替换掉
    for (int i = 0; i < userList.size(); i++) {
        if (userList.get(i).getId().equals(user.getId())) {
            userList.set(i, user);  // 用新数据替换旧数据
            break;
        }
    }
    return user;
}

// DELETE http://localhost:8080/user/3
@DeleteMapping("/{id}")
public String delete(@PathVariable Integer id) {
    // ⭐ 从列表里删除对应 ID 的用户
    userList.removeIf(u -> u.getId().equals(id));
    return "删除成功，id=" + id;
}
```

> ⭐ **注意：** PUT 和 DELETE 都是操作 Demo 3.2 里的 `userList`，修改和删除后用 GET 查询就能看到变化。

**test.http 补充：**

```http
### PUT 请求 - 修改用户
PUT http://localhost:8080/user
Content-Type: application/json

{
    "id": 1,
    "name": "张三改名",
    "age": 21,
    "email": "zhangsan@example.com"
}

### DELETE 请求 - 删除用户
DELETE http://localhost:8080/user/3
```

### 验证 PUT 和 DELETE 是否生效

修改或删除后，用 GET 查询就能看到结果：

```http
### 验证：查询用户列表
GET http://localhost:8080/user/list
```

| 操作 | 验证方式 | 预期结果 |
|------|---------|---------|
| PUT 修改了 id=1 的用户 | GET /user/list | 张三变成"张三改名" |
| DELETE 删除了 id=3 的用户 | GET /user/list | 王五消失了，只剩 2 个用户 |

---

# Demo 6：参数接收全解

> ⬆ [上一章：Demo 5](#demo-5rest-api--put-和-delete-请求) | ⬇ [下一章：Demo 7](#demo-7result-统一返回封装) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：参数接收](SpringBoot知识点.md#4-参数接收)

## Demo 6.1：@RequestParam

```java
package com.example.demo.controller;

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
        return "姓名：" + name + "，年龄：" + age;
    }

    // GET http://localhost:8080/param/test2?name=张三
    // age 不传也没关系，有默认值
    @GetMapping("/test2")
    public String testDefaultValue(
            @RequestParam String name,
            @RequestParam(defaultValue = "18") Integer age
    ) {
        return "姓名：" + name + "，年龄：" + age;
    }

    // GET http://localhost:8080/param/test3?name=张三
    // age 可选，不传为 null
    @GetMapping("/test3")
    public String testOptional(
            @RequestParam String name,
            @RequestParam(required = false) Integer age
    ) {
        return "姓名：" + name + "，年龄：" + (age != null ? age : "未知");
    }

    // GET http://localhost:8080/param/test4?keyword=Spring&page=1&size=10
    // 模拟搜索分页
    @GetMapping("/test4")
    public Map<String, Object> testSearch(
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
}
```

## Demo 6.2：@PathVariable

```java
// 在 ParamController 中添加

// GET http://localhost:8080/param/user/5
@GetMapping("/user/{id}")
public String testPathVariable(@PathVariable Integer id) {
    return "查询用户 id=" + id;
}

// GET http://localhost:8080/param/user/5/order/100
@GetMapping("/user/{userId}/order/{orderId}")
public String testMultiPathVariable(
        @PathVariable Integer userId,
        @PathVariable Integer orderId
) {
    return "用户 " + userId + " 的订单 " + orderId;
}
```

## Demo 6.3：@RequestBody

```java
// 在 ParamController 中添加

// POST http://localhost:8080/param/user
// Body: {"name":"张三","age":20}
@PostMapping("/user")
public Map<String, Object> testRequestBody(@RequestBody Map<String, Object> userMap) {
    Map<String, Object> result = new HashMap<>();
    result.put("msg", "收到数据");
    result.put("data", userMap);
    return result;
}

// 更推荐：直接转成对象
// POST http://localhost:8080/param/user2
// Body: {"name":"张三","age":20,"email":"test@example.com"}
@PostMapping("/user2")
public User testRequestBodyObject(@RequestBody User user) {
    System.out.println("收到：" + user.getName());
    return user;
}
```

## Demo 6.4：混合参数接收

```java
// 在 ParamController 中添加

// POST http://localhost:8080/param/mix/5
// Body: {"name":"张三","age":20}
// 路径参数 + 请求体参数 混合使用
@PostMapping("/mix/{id}")
public Map<String, Object> testMix(
        @PathVariable Integer id,
        @RequestBody User user
) {
    Map<String, Object> result = new HashMap<>();
    result.put("id_from_path", id);
    result.put("user_from_body", user);
    return result;
}
```

### 验证

在 `test.http` 文件中添加以下内容，点击绿色三角即可测试：

```http
### 测试 @RequestParam（基本用法）
GET http://localhost:8080/param/test1?name=张三&age=20

### 测试 @RequestParam（默认值）
GET http://localhost:8080/param/test2?name=张三
### 只传 name 不传 age，age 会用默认值 18

### 测试 @RequestParam（可选参数）
GET http://localhost:8080/param/test3?name=张三
### 不传 age，返回"未知"

### 测试 @RequestParam（模拟搜索分页）
GET http://localhost:8080/param/test4?keyword=Spring&page=2&size=20

### 测试 @PathVariable（单个）
GET http://localhost:8080/param/user/5

### 测试 @PathVariable（多个）
GET http://localhost:8080/param/user/5/order/100

### 测试 @RequestBody（用 Map 接收）
POST http://localhost:8080/param/user
Content-Type: application/json

{
    "name": "赵六",
    "age": 28
}

### 测试 @RequestBody（用对象接收）
POST http://localhost:8080/param/user2
Content-Type: application/json

{
    "name": "赵六",
    "age": 28,
    "email": "zhaoliu@example.com"
}

### 测试混合参数（路径参数 + 请求体）
POST http://localhost:8080/param/mix/5
Content-Type: application/json

{
    "name": "张三",
    "age": 20
}
```

| 接口 | 测试方式 | 预期结果 |
|------|---------|---------|
| `test1` | 传 `?name=张三&age=20` | 返回"姓名：张三，年龄：20" |
| `test2` | 只传 `?name=张三`，不传 age | 返回"姓名：张三，年龄：18"（默认值） |
| `test3` | 只传 `?name=张三`，不传 age | 返回"姓名：张三，年龄：未知"（null） |
| `test4` | 传 `?keyword=Spring&page=2` | 返回 JSON，含 page=2、size=10（默认） |
| `/user/5` | 直接访问 | 返回"查询用户 id=5" |
| `/user/5/order/100` | 直接访问 | 返回"用户 5 的订单 100" |
| POST `/param/user` | 发 JSON | 返回 `{msg:"收到数据", data:{...}}` |
| POST `/mix/5` | 发 JSON | 返回路径 id=5 和 user 对象 |

---

# Demo 7：Result 统一返回封装

> ⬆ [上一章：Demo 6](#demo-6参数接收全解) | ⬇ [下一章：Demo 8](#demo-8连接-mysql-数据库) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：返回 JSON 数据](SpringBoot知识点.md#5-返回-json-数据)

## 创建 Result 类

```java
package com.example.demo.entity;

public class Result<T> {
    private Integer code;    // 状态码
    private String msg;      // 提示信息
    private T data;          // 返回数据

    public Result() {}

    // 成功（带数据）
    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    // 成功（不带数据）
    public static Result success() {
        return success(null);
    }

    // 失败
    public static Result error(String msg) {
        Result r = new Result();
        r.setCode(500);
        r.setMsg(msg);
        return r;
    }

    // getter 和 setter
    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
```

## 使用 Result 封装返回值

```java
package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/result")
public class ResultController {

    private List<User> userList = new ArrayList<>() {{
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
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return Result.success(user);
            }
        }
        return Result.error("用户不存在");
    }

    // 添加成功
    // POST http://localhost:8080/result/user
    @PostMapping("/user")
    public Result save(@RequestBody User user) {
        user.setId(userList.size() + 1);
        userList.add(user);
        return Result.success();
    }

    // 业务失败示例
    // GET http://localhost:8080/result/user/check/1
    @GetMapping("/user/check/{id}")
    public Result checkUser(@PathVariable Integer id) {
        if (id <= 0) {
            return Result.error("ID 不能小于 0");
        }
        if (id > 100) {
            return Result.error("ID 不能大于 100");
        }
        return Result.success("ID 有效");
    }
}
```

**返回效果：**

```json
// 成功
{
    "code": 200,
    "msg": "success",
    "data": [
        {"id":1,"name":"张三","age":20,"email":"zhangsan@example.com"},
        {"id":2,"name":"李四","age":25,"email":"lisi@example.com"}
    ]
}

// 失败
{
    "code": 500,
    "msg": "用户不存在",
    "data": null
}
```

## 验证：test.http 参考代码

```http
### 7.1 查询用户列表（成功 - 返回列表）
GET http://localhost:8080/result/user/list

### 7.2 查询单个用户（成功 - 返回单个）
GET http://localhost:8080/result/user/1

### 7.3 查询单个用户（失败 - 用户不存在）
GET http://localhost:8080/result/user/999

### 7.4 添加用户（成功 - 不带数据）
POST http://localhost:8080/result/user
Content-Type: application/json

{
  "name": "王五",
  "age": 30,
  "email": "wangwu@example.com"
}

### 7.5 校验 ID（成功 - ID 有效）
GET http://localhost:8080/result/user/check/1

### 7.6 校验 ID（失败 - ID 小于 0）
GET http://localhost:8080/result/user/check/-1

### 7.7 校验 ID（失败 - ID 大于 100）
GET http://localhost:8080/result/user/check/200
```

**预期结果：**

| 请求 | code | msg | data |
|------|------|-----|------|
| 7.1 GET /result/user/list | 200 | "success" | [张三, 李四] |
| 7.2 GET /result/user/1 | 200 | "success" | {张三} |
| 7.3 GET /result/user/999 | 500 | "用户不存在" | null |
| 7.4 POST /result/user | 200 | "success" | null |
| 7.5 GET /result/user/check/1 | 200 | "success" | "ID 有效" |
| 7.6 GET /result/user/check/-1 | 500 | "ID 不能小于 0" | null |
| 7.7 GET /result/user/check/200 | 500 | "ID 不能大于 100" | null |

> **重点观察：** code = 200 时 data 有数据，code = 500 时 data 为 null。7.4 调用的是 `Result.success()` 不带参版本，所以 data 也是 null。

---

# Demo 8：连接 MySQL 数据库

> ⬆ [上一章：Demo 7](#demo-7result-统一返回封装) | ⬇ [下一章：Demo 9](#demo-9mybatis-注解方式-crud) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：连接 MySQL](SpringBoot知识点.md#6-连接-mysql)

## 步骤一：创建数据库和表

```sql
-- 创建数据库
CREATE DATABASE IF NOT EXISTS mydb DEFAULT CHARSET utf8mb4;

-- 使用数据库
USE mydb;

-- 创建用户表
CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
    name VARCHAR(50) NOT NULL COMMENT '用户名',
    age INT COMMENT '年龄',
    email VARCHAR(100) COMMENT '邮箱',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 插入测试数据
INSERT INTO user(name, age, email) VALUES
('张三', 20, 'zhangsan@example.com'),
('李四', 25, 'lisi@example.com'),
('王五', 30, 'wangwu@example.com');
```

## 步骤二：添加依赖（pom.xml）

```xml
<!-- 在 <dependencies> 中添加 -->

<!-- MySQL 驱动 -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- JDBC -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>

<!-- MyBatis -->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>3.0.3</version>
</dependency>

```

## 步骤三：配置数据库连接（application.yml）

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8
    username: root
    password: 123456   # 改成你自己的密码
    driver-class-name: com.mysql.cj.jdbc.Driver

mybatis:
  configuration:
    map-underscore-to-camel-case: true  # 开启驼峰命名映射
  mapper-locations: classpath:mapper/*.xml  # XML 方式的 SQL 文件位置（如果用注解方式可以不配）
```

## 步骤四：User 实体类

```java
package com.example.demo.entity;

import java.time.LocalDateTime;

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private LocalDateTime createTime;

    // 无参构造
    public User() {}

    // 全参构造
    public User(Integer id, String name, Integer age, String email, LocalDateTime createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.createTime = createTime;
    }

    // getter
    public Integer getId() { return id; }
    public String getName() { return name; }
    public Integer getAge() { return age; }
    public String getEmail() { return email; }
    public LocalDateTime getCreateTime() { return createTime; }

    // setter
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(Integer age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
```

---

# Demo 9：MyBatis 注解方式 CRUD

> ⬆ [上一章：Demo 8](#demo-8连接-mysql-数据库) | ⬇ [下一章：Demo 10](#demo-10mybatis-xml-方式-crud) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：MyBatis](SpringBoot知识点.md#7-mybatis)

## 完整的 UserMapper（注解方式）

```java
package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {

    // 查询所有
    @Select("SELECT * FROM user")
    List<User> findAll();

    // 根据 ID 查询
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Integer id);

    // 根据名字模糊查询
    @Select("SELECT * FROM user WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<User> findByName(String name);

    // 插入（自动回填 id）
    @Insert("INSERT INTO user(name, age, email) VALUES(#{name}, #{age}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    // 修改
    @Update("UPDATE user SET name=#{name}, age=#{age}, email=#{email} WHERE id=#{id}")
    void update(User user);

    // 删除
    @Delete("DELETE FROM user WHERE id = #{id}")
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
```

> **`<script>` 标签解释：** 在注解方式中使用动态 SQL 时，需要用 `<script>` 包裹 XML 标签。这就像是在注解里嵌入了一小段 XML。

---

# Demo 10：MyBatis XML 方式 CRUD

> ⬆ [上一章：Demo 9](#demo-9mybatis-注解方式-crud) | ⬇ [下一章：Demo 11](#demo-11mybatis-动态-sql) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：MyBatis](SpringBoot知识点.md#7-mybatis)

## 步骤一：创建 Mapper 接口

```java
package com.example.demo.mapper;

import com.example.demo.entity.User;
import java.util.List;

public interface UserXmlMapper {
    List<User> findAll();
    User findById(Integer id);
    List<User> findByName(String name);
    void insert(User user);
    void update(User user);
    void delete(Integer id);
}
```

## 步骤二：创建 XML 文件

在 `src/main/resources/mapper/` 目录下创建 `UserXmlMapper.xml`：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.example.demo.mapper.UserXmlMapper">

    <!-- 查询所有 -->
    <select id="findAll" resultType="com.example.demo.entity.User">
        SELECT * FROM user
    </select>

    <!-- 根据 ID 查询 -->
    <select id="findById" resultType="com.example.demo.entity.User">
        SELECT * FROM user WHERE id = #{id}
    </select>

    <!-- 根据名字模糊查询 -->
    <select id="findByName" resultType="com.example.demo.entity.User">
        SELECT * FROM user WHERE name LIKE CONCAT('%', #{name}, '%')
    </select>

    <!-- 插入 -->
    <insert id="insert" parameterType="com.example.demo.entity.User"
            useGeneratedKeys="true" keyProperty="id">
        INSERT INTO user(name, age, email)
        VALUES(#{name}, #{age}, #{email})
    </insert>

    <!-- 修改 -->
    <update id="update" parameterType="com.example.demo.entity.User">
        UPDATE user
        SET name = #{name}, age = #{age}, email = #{email}
        WHERE id = #{id}
    </update>

    <!-- 删除 -->
    <delete id="delete">
        DELETE FROM user WHERE id = #{id}
    </delete>

</mapper>
```

> **注意：** 使用 XML 方式需要在 `application.yml` 中配置 `mybatis.mapper-locations`。

---

# Demo 11：MyBatis 动态 SQL

> ⬆ [上一章：Demo 10](#demo-10mybatis-xml-方式-crud) | ⬇ [下一章：Demo 11.5](#demo-115service-层详解) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：MyBatis 动态 SQL](SpringBoot知识点.md#75-mybatis-动态sql进阶但实用)

## `<where>` + `<if>` 条件查询

```xml
<!-- 在 UserMapper.xml 中添加 -->

<!-- 动态条件查询 -->
<select id="findByCondition" resultType="com.example.demo.entity.User">
    SELECT * FROM user
    <where>
        <if test="name != null and name != ''">
            AND name LIKE CONCAT('%', #{name}, '%')
        </if>
        <if test="age != null">
            AND age = #{age}
        </if>
        <if test="email != null and email != ''">
            AND email = #{email}
        </if>
    </where>
</select>
```

**对应的 Mapper 接口：**

```java
List<User> findByCondition(@Param("name") String name,
                           @Param("age") Integer age,
                           @Param("email") String email);
```

## `<set>` 动态更新

```xml
<!-- 动态更新：只更新传了值的字段 -->
<update id="dynamicUpdate" parameterType="com.example.demo.entity.User">
    UPDATE user
    <set>
        <if test="name != null">name = #{name},</if>
        <if test="age != null">age = #{age},</if>
        <if test="email != null">email = #{email},</if>
    </set>
    WHERE id = #{id}
</update>
```

> **`<set>` 的作用：** 自动去掉最后一个多余的逗号，确保 SQL 语法正确。

## `<foreach>` 批量操作

```xml
<!-- 批量删除 -->
<delete id="batchDelete">
    DELETE FROM user WHERE id IN
    <foreach collection="ids" item="id" open="(" separator="," close=")">
        #{id}
    </foreach>
</delete>

<!-- 批量插入 -->
<insert id="batchInsert">
    INSERT INTO user(name, age, email) VALUES
    <foreach collection="users" item="user" separator=",">
        (#{user.name}, #{user.age}, #{user.email})
    </foreach>
</insert>
```

> **`<foreach>` 参数解释：**
> - `collection` — 要遍历的集合
> - `item` — 每个元素的变量名
> - `open` — 开始符号
> - `separator` — 分隔符
> - `close` — 结束符号

---

# Demo 11.5：Service 层详解

> ⬆ [上一章：Demo 11](#demo-11mybatis-动态-sql) | ⬇ [下一章：Demo 12](#demo-12完整项目--用户管理系统) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：Service 层](SpringBoot知识点.md#24-service-层服务层)

> Service 层是 Controller 和 Mapper 之间的"中间人"。Controller 不直接调 Mapper，而是通过 Service 来调。以后业务逻辑（比如检查用户名重复）也写在 Service 里。

## 步骤一：创建 Service 接口

**Service 接口 = "菜单"，声明能做什么，但不写怎么做。**

📁 **写在 `service/UserService.java`（新建这个文件）**

```java
package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();          // 查询所有用户
    User findById(Integer id);     // 根据 ID 查询
    List<User> findByName(String name);  // 根据名字搜索
    void save(User user);          // 保存（添加）用户
    void update(User user);        // 修改用户
    void delete(Integer id);       // 删除用户
}
```

**和 Mapper 接口对比：**

```
Mapper 接口（mapper/UserMapper.java）    Service 接口（service/UserService.java）
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
直接操作数据库，写 SQL                   调用 Mapper，写业务逻辑
@Mapper                                不需要注解（接口本身不用注解）
findByName → SQL 查询                  findByName → 调用 mapper.findByName()
insert → SQL 插入                      save → 调用 mapper.insert()（名字可以不同！）
```

> **注意：** Mapper 的 `insert` 对应 Service 的 `save`，名字可以不一样！因为 Service 可以自己决定方法叫什么。

## 步骤二：创建 Service 实现类

**Service 实现类 = "厨房"，真正写怎么做。**

📁 **写在 `service/impl/UserServiceImpl.java`（新建这个文件）**

```java
package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service                                        // ⭐ 必须加！告诉 Spring"这是 Service"
public class UserServiceImpl implements UserService {  // ⭐ 实现 UserService 接口

    @Autowired                                  // ⭐ 自动注入 Mapper
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();            // ← 直接调 Mapper
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);         // ← 直接调 Mapper
    }

    @Override
    public List<User> findByName(String name) {
        return userMapper.findByName(name);     // ← 直接调 Mapper
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);                // ← Mapper 叫 insert，Service 叫 save
    }

    @Override
    public void update(User user) {
        userMapper.update(user);                // ← 直接调 Mapper
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);                  // ← 直接调 Mapper
    }
}
```

**逐行拆解关键注解：**

```java
@Service  // ← 告诉 Spring："我是 Service 类，把我放进容器管理"
public class UserServiceImpl implements UserService {
//              │                │
//              │                └── implements UserService：实现接口
//              │                    必须实现接口里声明的所有方法
//              └── 类名：接口名 + Impl（命名规范）

    @Autowired    // ← 告诉 Spring："帮我自动创建 UserMapper 对象"
    private UserMapper userMapper;
}
```

## 步骤三：创建 Controller 调用 Service

📁 **写在 `controller/UserServiceController.java`（新建这个文件）**

```java
package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/service")
public class UserServiceController {

    @Autowired
    private UserService userService;    // ← 注入 Service（不是 Mapper！）

    // 查询所有
    // GET http://localhost:8080/service/user/list
    @GetMapping("/user/list")
    public List<User> list() {
        return userService.findAll();   // ← 调用 Service
    }

    // 根据 ID 查询
    // GET http://localhost:8080/service/user/1
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    // 添加用户
    // POST http://localhost:8080/service/user
    @PostMapping("/user")
    public String save(@RequestBody User user) {
        userService.save(user);
        return "添加成功";
    }

    // 修改用户
    // PUT http://localhost:8080/service/user
    @PutMapping("/user")
    public String update(@RequestBody User user) {
        userService.update(user);
        return "修改成功";
    }

    // 删除用户
    // DELETE http://localhost:8080/service/user/1
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Integer id) {
        userService.delete(id);
        return "删除成功";
    }
}
```

## 三层调用关系图

```
浏览器请求 GET /service/user/list
    │
    ▼
UserServiceController.list()          ← Controller 层
    │   return userService.findAll();
    ▼
UserServiceImpl.findAll()             ← Service 层
    │   return userMapper.findAll();
    ▼
UserMapper.findAll()                  ← Mapper 层
    │   @Select("SELECT * FROM user")
    ▼
MySQL 数据库                          ← 数据库层
    │
    ▼
数据逐层返回给浏览器
```

## 你创建的文件清单

```
📁 src/main/java/com/example/demo/
├── entity/
│   ├── User.java                         ← 之前创建的
│   └── Result.java                       ← 之前创建的
├── mapper/
│   └── UserMapper.java                   ← Demo 9 创建的
├── service/                              ← ⭐ 新建文件夹
│   ├── UserService.java                  ← ⭐ 步骤一：接口
│   └── impl/                             ← ⭐ 新建文件夹
│       └── UserServiceImpl.java          ← ⭐ 步骤二：实现类
└── controller/
    ├── UserController.java               ← 之前的
    ├── ResultController.java             ← Demo 7 创建的
    └── UserServiceController.java        ← ⭐ 步骤三：Controller
```

## 验证：test.http 参考代码

```http
### 11.5.1 查询所有用户
GET http://localhost:8080/service/user/list

### 11.5.2 根据 ID 查询
GET http://localhost:8080/service/user/1

### 11.5.3 添加用户
POST http://localhost:8080/service/user
Content-Type: application/json

{
    "name": "赵六",
    "age": 28,
    "email": "zhaoliu@example.com"
}

### 11.5.4 修改用户
PUT http://localhost:8080/service/user
Content-Type: application/json

{
    "id": 1,
    "name": "张三改名",
    "age": 21,
    "email": "updated@example.com"
}

### 11.5.5 删除用户
DELETE http://localhost:8080/service/user/3
```

**预期结果：**

| 请求 | 返回结果 |
|------|----------|
| 11.5.1 GET /service/user/list | `[{"id":1,"name":"张三",...},{"id":2,...}]` |
| 11.5.2 GET /service/user/1 | `{"id":1,"name":"张三",...}` |
| 11.5.3 POST /service/user | `"添加成功"` |
| 11.5.4 PUT /service/user | `"修改成功"` |
| 11.5.5 DELETE /service/user/3 | `"删除成功"` |

> **重点观察：** Controller → Service → Mapper 三层调用，每层只做自己的事。Controller 接请求，Service 写逻辑，Mapper 查数据库。

---

# Demo 12：完整项目 —— 用户管理系统

> ⬆ [上一章：Demo 11.5](#demo-115service-层详解) | ⬇ [下一章：Demo 13](#demo-13前端调用接口示例) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：CRUD 操作](SpringBoot知识点.md#8-crud-操作)

> 这是一个完整的 CRUD 项目，包含所有层的代码，可以直接运行。

## 12.1 Entity —— User.java

```java
package com.example.demo.entity;

import java.time.LocalDateTime;

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private LocalDateTime createTime;

    public User() {}

    public User(Integer id, String name, Integer age, String email, LocalDateTime createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.createTime = createTime;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
```

## 12.2 Result.java

```java
package com.example.demo.entity;

public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result() {}

    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(String msg) {
        Result r = new Result();
        r.setCode(500);
        r.setMsg(msg);
        return r;
    }

    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
```

## 12.3 Mapper —— UserMapper.java

```java
package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user ORDER BY id DESC")
    List<User> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Integer id);

    @Select("SELECT * FROM user WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<User> findByName(String name);

    @Insert("INSERT INTO user(name, age, email) VALUES(#{name}, #{age}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Update("UPDATE user SET name=#{name}, age=#{age}, email=#{email} WHERE id=#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void delete(Integer id);
}
```

## 12.4 Service —— UserService.java

```java
package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    List<User> findByName(String name);
    void save(User user);
    void update(User user);
    void delete(Integer id);
}
```

## 12.5 Service 实现 —— UserServiceImpl.java

```java
package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public void save(User user) {
        // 这里可以加业务逻辑，比如检查用户名是否重复
        User existing = userMapper.findByName(user.getName());
        if (!existing.isEmpty()) {
            // 实际项目中应该抛出自定义异常
            throw new RuntimeException("用户名已存在");
        }
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        // 检查用户是否存在
        User existing = userMapper.findById(user.getId());
        if (existing == null) {
            throw new RuntimeException("用户不存在");
        }
        userMapper.update(user);
    }

    @Override
    public void delete(Integer id) {
        User existing = userMapper.findById(id);
        if (existing == null) {
            throw new RuntimeException("用户不存在");
        }
        userMapper.delete(id);
    }
}
```

## 12.6 Controller —— UserController.java

```java
package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
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
            return Result.success();
        } catch (RuntimeException e) {
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
            return Result.success();
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    // 删除用户
    // DELETE http://localhost:8080/user/1
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        try {
            userService.delete(id);
            return Result.success();
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }
}
```

## 12.7 配置文件 —— application.yml

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver

mybatis:
  configuration:
    map-underscore-to-camel-case: true
```

## 12.8 验证：test.http 参考代码

```http
### 12.1 查询所有用户（成功）
GET http://localhost:8080/user/list

### 12.2 根据 ID 查询（成功 - 用户存在）
GET http://localhost:8080/user/1

### 12.3 根据 ID 查询（失败 - 用户不存在）
GET http://localhost:8080/user/999

### 12.4 搜索用户（成功 - 模糊匹配）
GET http://localhost:8080/user/search?name=张

### 12.5 搜索用户（成功 - 无结果）
GET http://localhost:8080/user/search?name=不存在的名字

### 12.6 添加用户（成功）
POST http://localhost:8080/user
Content-Type: application/json

{
    "name": "新来的",
    "age": 22,
    "email": "new@example.com"
}

### 12.7 修改用户（成功）
PUT http://localhost:8080/user
Content-Type: application/json

{
    "id": 1,
    "name": "张三改名",
    "age": 21,
    "email": "updated@example.com"
}

### 12.8 修改用户（失败 - 用户不存在）
PUT http://localhost:8080/user
Content-Type: application/json

{
    "id": 999,
    "name": "不存在",
    "age": 20,
    "email": "no@example.com"
}

### 12.9 删除用户（成功）
DELETE http://localhost:8080/user/3

### 12.10 删除用户（失败 - 用户不存在）
DELETE http://localhost:8080/user/999
```

**预期结果：**

| 请求 | code | msg | data |
|------|------|-----|------|
| 12.1 GET /user/list | 200 | "success" | [用户列表] |
| 12.2 GET /user/1 | 200 | "success" | {张三} |
| 12.3 GET /user/999 | 500 | "用户不存在" | null |
| 12.4 GET /user/search?name=张 | 200 | "success" | [姓张的用户] |
| 12.5 GET /user/search?name=不存在的名字 | 200 | "success" | []（空列表） |
| 12.6 POST /user（添加） | 200 | "success" | null |
| 12.7 PUT /user（修改） | 200 | "success" | null |
| 12.8 PUT /user（修改不存在的） | 500 | "用户不存在" | null |
| 12.9 DELETE /user/3（删除） | 200 | "success" | null |
| 12.10 DELETE /user/999（删除不存在的） | 500 | "用户不存在" | null |

> **重点观察：**
> - 成功操作（增删改）返回 `code=200, data=null`，因为调的是 `Result.success()` 不带参版本
> - 查询成功返回 `code=200, data=数据`，因为调的是 `Result.success(数据)` 带参版本
> - 操作失败（用户不存在等）返回 `code=500, msg=错误信息, data=null`

---

# Demo 13：前端调用接口示例

> ⬆ [上一章：Demo 12](#demo-12完整项目--用户管理系统) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：前端调用接口](SpringBoot知识点.md#9-前端调用接口)

## 13.1 使用 fetch

```html
<!DOCTYPE html>
<html>
<head>
    <title>用户管理</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>用户管理系统</h1>

    <button onclick="loadUsers()">加载用户列表</button>
    <button onclick="addUser()">添加用户</button>

    <div id="userList"></div>

    <script>
        // GET 请求 - 查询用户列表
        function loadUsers() {
            fetch('/user/list')
                .then(response => response.json())
                .then(result => {
                    if (result.code === 200) {
                        let html = '<ul>';
                        result.data.forEach(user => {
                            html += `<li>${user.name} - ${user.age}岁 - ${user.email}</li>`;
                        });
                        html += '</ul>';
                        document.getElementById('userList').innerHTML = html;
                    } else {
                        alert('查询失败：' + result.msg);
                    }
                })
                .catch(error => {
                    console.error('请求失败：', error);
                });
        }

        // POST 请求 - 添加用户
        function addUser() {
            fetch('/user', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    name: '前端添加的用户',
                    age: 18,
                    email: 'frontend@example.com'
                })
            })
            .then(response => response.json())
            .then(result => {
                if (result.code === 200) {
                    alert('添加成功！');
                    loadUsers();  // 刷新列表
                } else {
                    alert('添加失败：' + result.msg);
                }
            });
        }
    </script>
</body>
</html>
```

## 13.2 使用 axios

```html
<!DOCTYPE html>
<html>
<head>
    <title>用户管理 - axios</title>
    <meta charset="UTF-8">
    <!-- 引入 axios -->
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
    <h1>用户管理系统（axios 版）</h1>

    <button onclick="loadUsers()">加载用户</button>
    <button onclick="addUser()">添加用户</button>
    <button onclick="updateUser()">修改用户</button>
    <button onclick="deleteUser()">删除用户</button>

    <div id="result"></div>

    <script>
        // GET - 查询列表
        function loadUsers() {
            axios.get('/user/list')
                .then(response => {
                    const result = response.data;
                    document.getElementById('result').innerHTML =
                        JSON.stringify(result, null, 2);
                })
                .catch(error => {
                    console.error(error);
                });
        }

        // POST - 添加
        function addUser() {
            axios.post('/user', {
                name: 'axios添加的',
                age: 30,
                email: 'axios@example.com'
            })
            .then(response => {
                alert(response.data.msg);
                loadUsers();
            });
        }

        // PUT - 修改
        function updateUser() {
            axios.put('/user', {
                id: 1,
                name: 'axios修改的',
                age: 31,
                email: 'updated@example.com'
            })
            .then(response => {
                alert(response.data.msg);
                loadUsers();
            });
        }

        // DELETE - 删除
        function deleteUser() {
            axios.delete('/user/2')
            .then(response => {
                alert(response.data.msg);
                loadUsers();
            });
        }
    </script>
</body>
</html>
```

> **注意：** 前端 HTML 文件放在 `src/main/resources/static/` 目录下，Spring Boot 会自动提供静态资源服务。访问 http://localhost:8080/xxx.html 即可。

---

# 练习题

## 练习 1：基础 CRUD（必做）

创建一个"商品管理"模块，包含：
- 商品表：id、商品名、价格、库存、创建时间
- 完成 5 个接口：查询列表、根据 ID 查询、添加、修改、删除
- 使用 Result 统一返回

**要求：**
1. 自己创建数据库和表
2. 写 Entity、Mapper、Service（接口+实现）、Controller
3. 用 IDEA HTTP Client 或 Postman 测试所有接口

## 练习 2：条件查询（推荐做）

在练习 1 基础上增加：
- 按商品名模糊搜索
- 按价格区间查询（最低价、最高价）
- 使用 MyBatis 动态 SQL

## 练习 3：分页查询（进阶）

在练习 1 基础上增加分页功能：
- 接收参数：page（第几页）、size（每页几条）
- 返回：当前页数据、总条数、总页数

**提示：** SQL 用 `LIMIT #{offset}, #{size}`，offset = (page - 1) * size

```java
// Mapper
@Select("SELECT * FROM user LIMIT #{offset}, #{size}")
List<User> findByPage(@Param("offset") Integer offset, @Param("size") Integer size);

@Select("SELECT COUNT(*) FROM user")
int count();
```

## 练习 4：多表查询（进阶）

创建订单表和用户表，实现：
- 一个用户有多个订单（一对多关系）
- 查询用户时同时返回该用户的所有订单

```sql
-- 订单表
CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    product_name VARCHAR(100),
    amount DECIMAL(10, 2),
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id)
);
```

---

> **学习建议：** 练习 1 是必须做的，做完你就能理解整个分层调用流程。练习 2、3 逐步增加难度。遇到问题随时问我，我会在知识点文件中补充相关内容。
