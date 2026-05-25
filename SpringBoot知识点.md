# Spring Boot 知识点完整手册

> 本文件是 Spring Boot 入门学习的核心知识点参考，按学习路线组织。
> 每个章节都附有**跳转链接**，可以直接跳到对应的实操 Demo 去练习。
> 遇到不懂的 Java 语法？👉 [点击跳转到 Java 知识点](Java知识点.md)
> 内容基于 [Spring Boot 官方文档](https://docs.spring.io/spring-boot/docs/current/reference/html/) 整理。
> 最后更新：2026-05-17

---

## 目录

- [第一部分：Spring Boot 项目基础](#第一部分spring-boot-项目基础)
  - [1. 创建项目](#1-创建项目) → [跳转实操 Demo 1](SpringBoot实操Demo.md#demo-1创建第一个-spring-boot-项目)
  - [2. 项目结构](#2-项目结构) → [跳转实操 Demo 2](SpringBoot实操Demo.md#demo-2项目结构与分层)
- [第二部分：REST API](#第二部分rest-api)
  - [3. 接口开发](#3-接口开发) → [跳转实操 Demo 3](SpringBoot实操Demo.md#demo-3rest-api--get-请求)
  - [4. 参数接收](#4-参数接收) → [跳转实操 Demo 6](SpringBoot实操Demo.md#demo-6参数接收全解)
  - [5. 返回 JSON 数据](#5-返回-json-数据) → [跳转实操 Demo 7](SpringBoot实操Demo.md#demo-7result-统一返回封装)
- [第三部分：数据库整合](#第三部分数据库整合)
  - [6. 连接 MySQL](#6-连接-mysql) → [跳转实操 Demo 8](SpringBoot实操Demo.md#demo-8连接-mysql-数据库)
  - [7. MyBatis](#7-mybatis) → [跳转实操 Demo 9](SpringBoot实操Demo.md#demo-9mybatis-注解方式-crud)
  - [8. CRUD 操作](#8-crud-操作) → [跳转实操 Demo 12](SpringBoot实操Demo.md#demo-12完整项目--用户管理系统)
- [第四部分：前后端交互](#第四部分前后端交互)
  - [9. 前端调用接口](#9-前端调用接口) → [跳转实操 Demo 13](SpringBoot实操Demo.md#demo-13前端调用接口示例)
  - [10. JSON 交互](#10-json-交互)
- [第五部分：核心能力](#第五部分核心能力)
- [附录：关键词速查表](#附录关键词速查表)

---

# 第一部分：Spring Boot 项目基础

---

## 1. 创建项目

> ⬇ [下一章：2. 项目结构](#2-项目结构核心) | [返回目录](#目录)
> 📖 官方文档：[Spring Boot Overview](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started.introducing-spring-boot)
>
> 👉 [点击跳转到实操 Demo 1：创建第一个 Spring Boot 项目](SpringBoot实操Demo.md#demo-1创建第一个-spring-boot-项目)

### 1.1 什么是 Spring Boot？

**用大白话说：** 你想做一个网站或者后端接口服务，如果用原生 Java，需要自己配置服务器、处理请求、连接数据库……一大堆事情。Spring Boot 帮你把这些都做好了，你只需要写"业务逻辑"（比如用户注册、查询商品这些具体功能）就行。

**打个比方：** 你要开一家餐厅，Spring Boot 就像一个"加盟品牌"——装修风格、厨房设备、员工培训流程都给你准备好了，你只需要研究菜品（业务代码）就行。

**关键词解释：**

| 关键词 | 通俗解释 |
|--------|---------|
| **框架（Framework）** | 别人写好的一套代码骨架，你往里面填自己的逻辑。就像盖房子，框架是钢筋结构，你负责装修 |
| **Java Web 项目** | 用 Java 写的、能通过浏览器访问的网站或接口服务 |
| **自动配置** | Spring Boot 根据你引入的依赖，自动帮你配好环境。比如你引入了 MySQL 依赖，它就自动帮你配好数据库连接 |
| **"约定优于配置"** | 框架提前定好了一套默认规则（比如代码放哪个目录、配置文件叫什么名字），你按规矩来就不用额外配置。只有想"打破规矩"时才需要写配置 |

**Spring Boot vs Spring 的区别：**

| 对比项 | Spring（老框架） | Spring Boot（新工具） |
|--------|-----------------|---------------------|
| 配置方式 | 需要写大量 XML 配置文件 | 几乎零配置，约定优于配置 |
| 启动方式 | 需要把项目部署到 Tomcat 服务器 | 内嵌了 Tomcat，直接运行 main 方法就能启动 |
| 依赖管理 | 手动管理每个库的版本，容易冲突 | Starter 套餐自动管理版本 |
| 上手难度 | 较高，需要学很多配置 | 较低，关注业务逻辑就行 |

### 1.2 Spring Initializr —— 项目生成器

> 📖 官方文档：[Creating a Project](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started.installing)

**是什么：** Spring 官方提供的在线工具（https://start.spring.io），你在网页上选好配置，点一下"生成"，它就帮你创建好一个可以运行的 Spring Boot 项目。

**每个配置项的含义：**

| 配置项 | 含义 | 推荐选择 | 为什么 |
|--------|------|----------|--------|
| **Project** | 构建工具 | Maven | 初学者推荐，教程多，生态大 |
| **Language** | 编程语言 | Java | Spring Boot 主要支持 Java |
| **Spring Boot** | 版本 | 选最新稳定版 | 不带 SNAPSHOT 的就是稳定版 |
| **Group** | 组织标识 | `com.example` | 通常是公司域名倒写，个人项目随便填 |
| **Artifact** | 项目名称 | `demo` | 你的项目叫什么名字 |
| **Packaging** | 打包方式 | Jar | Web 项目一般用 Jar |
| **Java** | Java 版本 | 17 或 21 | 长期支持版本，稳定 |
| **Dependencies** | 依赖 | Spring Web | 做 Web 开发必须加这个 |

> **Group 和 Artifact 的关系：** Group 是"你是谁"（比如 `com.example`），Artifact 是"项目叫什么"（比如 `demo`）。合起来就是项目的唯一标识，也会成为你的包名 `com.example.demo`。

### 1.3 Maven —— Java 的包管理器

**是什么：** Maven 是 Java 世界的"包管理器 + 构建工具"。如果你用过前端的 npm、Python 的 pip，Maven 就是 Java 里类似的东西。

**它的两个核心功能：**
1. **管理依赖** —— 你需要什么库，告诉 Maven，它帮你下载
2. **构建项目** —— 把你的代码编译、打包成可以运行的文件

**关键词解释：**

| 关键词 | 通俗解释 | 类比 |
|--------|---------|------|
| **pom.xml** | Maven 的配置文件，声明"我需要哪些依赖" | 类似前端的 `package.json` |
| **依赖（Dependency）** | 你的项目需要用到的第三方库 | 类似 npm 的 package |
| **坐标（Coordinates）** | 依赖的唯一标识，由 groupId + artifactId + version 组成 | 类似 npm 的"包名 + 版本号" |
| **仓库（Repository）** | 存放依赖的地方，Maven 从这里下载 | 类似 npm 的 registry |
| **本地仓库** | 你电脑上的 `.m2` 目录，下载的依赖存在这里 | 类似 `node_modules` |
| **Starter** | Spring Boot 提供的"依赖套餐"，一个 starter 包含了一组相关依赖 | 像点外卖套餐，一份包含多个菜 |

**pom.xml 核心结构（逐行解释）：**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0">
    <modelVersion>4.0.0</modelVersion>   <!-- 固定值，不用管 -->

    <!-- 父项目：Spring Boot 的版本管理器 -->
    <!-- 加了这个，所有 starter 都不用写版本号，Spring Boot 帮你管 -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.5</version>
    </parent>

    <!-- 本项目的信息 -->
    <groupId>com.example</groupId>        <!-- 你的组织标识 -->
    <artifactId>myapp</artifactId>        <!-- 项目名称 -->
    <version>0.0.1-SNAPSHOT</version>     <!-- 版本号，SNAPSHOT 表示开发中 -->

    <!-- 依赖列表：你需要的"工具包" -->
    <dependencies>
        <!-- spring-boot-starter-web：Web 开发套餐 -->
        <!-- 包含了 Tomcat（服务器）、Spring MVC（请求处理）、Jackson（JSON处理）等 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
</project>
```

> **为什么 starter 不用写 version？** 因为 `<parent>` 里的 `spring-boot-starter-parent` 已经帮你管理了所有 starter 的版本。你只管用，不用担心版本冲突。

**Starter 是什么？**

Starter 就是"依赖套餐"。一个 Starter 里面打包好了多个相关的依赖，你只需要引入一个 Starter，相关的所有依赖就都有了。

**你其实已经用过 Starter 了！** 回忆一下，你用 Spring Initializr 创建项目时，添加了一个依赖叫 **Spring Web**——那就是 `spring-boot-starter-web`！它帮你打包好了：
- Tomcat（Web 服务器，让你能通过浏览器访问）
- Spring MVC（处理 HTTP 请求的框架）
- Jackson（把 Java 对象转成 JSON 的库）

**Starter 在哪里体现？** 就在你项目的 `pom.xml` 文件里：

```xml
<dependencies>
    <!-- 这就是一个 Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

**怎么添加新的 Starter？** 两种方式：
1. **创建项目时添加** —— 在 Spring Initializr 页面的 Dependencies 里勾选
2. **项目创建后添加** —— 在 `pom.xml` 的 `<dependencies>` 里加一段 `<dependency>...</dependency>`，然后点 Maven 的 Reload

**常用 Starter 详解：**

| Starter | 通俗解释 | 什么时候用 | 你什么时候会遇到 |
|---------|---------|-----------|----------------|
| `spring-boot-starter-web` | Web 开发套餐：包含服务器、请求处理、JSON 转换 | 做任何 Web 项目都要 | ✅ **你已经在用了！** 创建项目时选的 Spring Web 就是它 |
| `spring-boot-starter-jdbc` | 数据库连接套餐：帮你管理数据库连接池 | 需要连数据库时 | 做 Demo 8（连接 MySQL）时会用到 |
| `spring-boot-starter-test` | 测试套餐：包含 JUnit、Mockito 等测试工具 | 写单元测试时 | 项目后期需要测试时会用到 |
| `mybatis-spring-boot-starter` | MyBatis 套餐：帮你整合 MyBatis 框架 | 用 MyBatis 操作数据库时 | 做 Demo 9（MyBatis CRUD）时会用到 |
| `mysql-connector-j` | MySQL 驱动：让你的 Java 代码能和 MySQL 数据库"对话" | 连 MySQL 数据库时 | 做 Demo 8（连接 MySQL）时会用到 |

> **简单记：** Starter = 你要做什么事情，就引入什么套餐。做 Web 开发用 web starter，连数据库用 jdbc starter，用 MyBatis 用 mybatis starter。不用记，用到的时候查就行。

### 1.4 项目启动 —— 启动类

> 📖 官方文档：[Developing Your First Spring Boot Application](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.structuring-your-code)

**启动类是什么：** 每个 Spring Boot 项目都有一个带 `main` 方法的类，它是整个程序的入口。就像你开门的钥匙，没有它程序跑不起来。

📁 **写在 `src/main/java/com/example/demo/DemoApplication.java`**

```java
@SpringBootApplication  // 这个注解是核心，下面详细解释
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        // 这行代码做了什么？
        // 1. 启动 Spring 容器（创建一个"工厂"，管理所有对象）
        // 2. 自动配置（根据依赖自动配好环境）
        // 3. 启动内嵌的 Tomcat 服务器（让你能通过浏览器访问）
    }
}
```

**`@SpringBootApplication` 注解拆解：**

这个注解其实是三个注解的"组合包"：

| 注解 | 作用 | 通俗解释 |
|------|------|---------|
| `@SpringBootConfiguration` | 标记这是一个配置类 | 告诉 Spring "这是配置中心" |
| `@EnableAutoConfiguration` | 开启自动配置 | 让 Spring Boot 根据依赖自动配好环境 |
| `@ComponentScan` | 扫描当前包及子包下的组件 | 让 Spring 去"发现"你写的 Controller、Service 等类 |

> **重要！** `@ComponentScan` 默认只扫描启动类所在的包及其子包。所以你的代码必须放在启动类所在包或其子包下。比如启动类在 `com.example.demo`，那你的 Controller 就要放在 `com.example.demo.controller` 下，不能放在 `com.other` 下，否则 Spring 找不到它。

> **注解（Annotation）是什么？** Java 里以 `@` 开头的东西，比如 `@SpringBootApplication`。它的作用是给代码"贴标签"，告诉框架"这段代码有什么特点、该怎样处理"。就像你给文件贴分类标签一样。

---

## 2. 项目结构（核心）

> ⬆ [上一章：1. 创建项目](#1-创建项目) | ⬇ [下一章：3. 接口开发](#3-接口开发重点中的重点) | [返回目录](#目录)
> 📖 官方文档：[Structuring Your Code](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.structuring-your-code)
>
> 👉 [点击跳转到实操 Demo 2：项目结构与分层](SpringBoot实操Demo.md#demo-2项目结构与分层)

### 2.1 标准目录结构

```
myapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/myapp/
│   │   │       ├── MyappApplication.java    ← 启动类（入口）
│   │   │       ├── controller/              ← 控制器层（接请求）
│   │   │       │   └── UserController.java
│   │   │       ├── service/                 ← 服务层（写业务）
│   │   │       │   ├── UserService.java     ← 接口
│   │   │       │   └── impl/
│   │   │       │       └── UserServiceImpl.java  ← 实现类
│   │   │       ├── mapper/                  ← 数据访问层（操作数据库）
│   │   │       │   └── UserMapper.java
│   │   │       └── entity/                  ← 实体类（对应数据库表）
│   │   │           └── User.java
│   │   └── resources/
│   │       ├── application.yml              ← 配置文件
│   │       ├── static/                      ← 静态资源（JS/CSS/图片）
│   │       └── templates/                   ← 模板页面
│   └── test/                                ← 测试代码
└── pom.xml                                  ← Maven 配置
```

### 2.2 各层职责详解

**请求处理的完整流程（必须记住）：**

```
浏览器/前端
    ↓ 发送 HTTP 请求
Controller（控制器层）    ← 接收请求，调用 Service，返回结果
    ↓ 调用
Service（服务层）         ← 写业务逻辑，调用 Mapper
    ↓ 调用
Mapper / DAO（数据访问层） ← 写 SQL，操作数据库
    ↓ 读写
MySQL 数据库
```

> **为什么要分层？** 每层只管自己的事，互不干扰。就像餐厅：服务员（Controller）接单，厨师（Service）做菜，采购员（Mapper）买食材。各司其职，效率高，好维护。

### 2.3 Controller 层（控制器）

**职责：** 接收前端发来的请求，调用 Service 处理，把结果返回给前端。

**关键词：**

| 关键词 | 解释 | 是否需要记住 |
|--------|------|-------------|
| ⭐ `@RestController` | 标记这是一个控制器类，且所有方法返回值直接作为 JSON 数据（不用再加 `@ResponseBody`） | **必须记** |
| `@Controller` | 标记这是一个控制器类，但返回值默认是页面名称（需要配合模板引擎用） | 了解就行 |
| ⭐ `@RequestMapping` | 指定这个控制器处理哪个 URL 路径下的请求 | **必须记** |
| `@ResponseBody` | 标记方法的返回值直接作为 HTTP 响应体（返回数据而不是页面） | 了解就行 |

> **`@RestController` = `@Controller` + `@ResponseBody`**，做 REST API 开发直接用 `@RestController` 就行。

📁 **写在 `controller/UserController.java`**

```java
@RestController                    // ⭐ 标记为控制器，返回 JSON
@RequestMapping("/user")           // ⭐ 这个控制器处理 /user 开头的请求
public class UserController {

    @Autowired                     // ⭐ 自动注入 Service（不用自己 new）
    private UserService userService;

    @GetMapping("/list")           // ⭐ 处理 GET /user/list 请求
    public List<User> list() {
        return userService.findAll();
    }
}
```

> ⭐ **`@Autowired` 解释：** Spring 的依赖注入机制。你不用自己 `new UserService()`，Spring 会自动帮你创建好对象并赋值给这个变量。这叫"控制反转（IoC）"——对象的创建权从你手里转交给了 Spring 容器。

> **Spring 容器解释：** Spring 在启动时会创建一个"容器"，里面装了所有它管理的对象（Bean）。当你用 `@Autowired` 时，Spring 就从容器里把对应的对象拿出来给你。这个概念了解就行，不用深究。

### 2.4 Service 层（服务层）

**职责：** 写业务逻辑，是整个项目的"大脑"。

**关键词：**

| 关键词 | 解释 | 是否需要记住 |
|--------|------|-------------|
| ⭐ `@Service` | 标记这是一个 Service 类，Spring 会把它放入容器管理 | **必须记** |
| ⭐ **接口 + 实现类模式** | 先写接口定义"要做什么"，再写实现类定义"怎么做"。方便以后替换实现 | **必须记**（写法固定，照着写就行） |

**固定结构：接口 + 实现类（每次写 Service 都是这个套路）**

**第一步：写接口（告诉别人"我能做什么"）**

📁 **写在 `service/UserService.java`**

```java
public interface UserService {
    List<User> findAll();        // 我能查所有用户
    User findById(Integer id);   // 我能根据 ID 查用户
    void save(User user);        // 我能保存用户
    void update(User user);      // 我能修改用户
    void delete(Integer id);     // 我能删除用户
}
```

这就像一份"菜单"，告诉你有哪些功能可以用，但不告诉你怎么做。

**第二步：写实现类（告诉别人"我怎么做"）**

📁 **写在 `service/impl/UserServiceImpl.java`**

```java
@Service                                    // ⭐ 固定写法：加 @Service
public class UserServiceImpl implements UserService {  // ⭐ 固定写法：implements 接口名

    @Autowired                              // ⭐ 固定写法：注入 Mapper
    private UserMapper userMapper;

    @Override                               // ⭐ 固定写法：每个方法上面加 @Override
    public List<User> findAll() {
        return userMapper.findAll();        // 调用 Mapper 的方法
    }

    @Override
    public void save(User user) {
        // 这里写业务逻辑，比如检查用户名是否重复
        userMapper.insert(user);            // 最后调用 Mapper 保存到数据库
    }
}
```

**固定套路总结：**

| 步骤 | 固定写法 | 你每次都要写的 |
|------|---------|---------------|
| 1 | 接口文件 | `public interface XxxService { ... }` |
| 2 | 实现类文件 | `@Service` + `implements XxxService` |
| 3 | 注入 Mapper | `@Autowired private XxxMapper xxxMapper;` |
| 4 | 实现每个方法 | 加 `@Override`，里面调用 Mapper 的方法 |

> **为什么要用接口 + 实现类？** 假设你以后要把 `findAll` 的逻辑从查 MySQL 改成查 Redis，只需要写一个新的实现类，不用改 Controller 的代码。这就是"面向接口编程"的好处。

### 2.5 Mapper / DAO 层（数据访问层）

**职责：** 直接操作数据库，写 SQL 语句。

**关键词：**

| 关键词 | 解释 | 是否需要记住 |
|--------|------|-------------|
| ⭐ `@Mapper` | 标记这是一个 MyBatis 的 Mapper 接口，MyBatis 会自动生成实现类 | **必须记** |
| `@Repository` | 标记这是一个数据访问组件（用 `@Mapper` 时可以不加这个） | 了解就行 |
| **DAO** | Data Access Object，数据访问对象，和 Mapper 是同一个概念 | 了解就行 |

**固定结构：只写接口，不用写实现类（MyBatis 自动生成）**

📁 **写在 `mapper/UserMapper.java`**

```java
@Mapper  // ⭐ 固定写法：加 @Mapper，MyBatis 会自动为这个接口生成实现类
public interface UserMapper {

    // ⭐ 查询所有用户
    // "SELECT * FROM user" 就是 SQL 语句，和你在 MySQL 里写的一样
    @Select("SELECT * FROM user")
    List<User> findAll();

    // ⭐ 根据 ID 查询用户
    // #{id} 是占位符，意思是"把参数 id 的值填到这里"
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Integer id);

    // ⭐ 新增用户
    // #{name}、#{age}、#{email} 会从传入的 User 对象中取对应的值
    @Insert("INSERT INTO user(name, age, email) VALUES(#{name}, #{age}, #{email})")
    void insert(User user);

    // 修改用户
    @Update("UPDATE user SET name=#{name}, age=#{age}, email=#{email} WHERE id=#{id}")
    void update(User user);

    // 删除用户
    @Delete("DELETE FROM user WHERE id = #{id}")
    void delete(Integer id);
}
```

**固定套路总结：**

| 步骤 | 固定写法 | 说明 |
|------|---------|------|
| 1 | 加 `@Mapper` 注解 | 告诉 MyBatis "这是我的数据库操作接口" |
| 2 | 写方法，上面加 SQL 注解 | `@Select` 查、`@Insert` 增、`@Update` 改、`@Delete` 删 |
| 3 | SQL 里用 `#{}` 填参数 | `#{属性名}` 会从传入的对象中取值 |

> **`#{}` 解释：** 这是 MyBatis 的参数占位符，类似 JDBC 的 `?`。`#{name}` 会从传入的 User 对象中取 `name` 属性的值，然后安全地填入 SQL。它会自动防 SQL 注入。

> **`@Mapper` 接口没有实现类为什么能用？** MyBatis 在运行时会通过"动态代理"技术自动生成实现类。你只需要写接口和 SQL，实现类由框架生成。

### 2.6 Entity 层（实体类）

**职责：** 定义 Java 对象，和数据库表一一对应。

**关键词：**

| 关键词 | 解释 | 是否需要记住 |
|--------|------|-------------|
| **JavaBean** | 一种 Java 类的规范：有私有属性、getter/setter 方法、无参构造函数 | 了解就行 |
| **POJO** | Plain Old Java Object，普通 Java 对象，不继承任何特殊类 | 了解就行 |
| **属性（Field）** | 类中的变量，比如 `private String name` | 了解就行 |
| ⭐ **getter/setter** | 获取/设置属性值的方法，比如 `getName()` / `setName()` | **必须记**（实体类必须写） |

**固定结构：私有属性 + 无参构造 + getter/setter**

📁 **写在 `entity/User.java`**

```java
public class User {
    // ⭐ 第一部分：私有属性（和数据库表的字段一一对应）
    private Integer id;
    private String name;
    private Integer age;
    private String email;

    // ⭐ 第二部分：无参构造（必须有！MyBatis 创建对象时需要）
    public User() {}

    // 第三部分：全参构造（可选，方便快速创建对象）
    public User(Integer id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // ⭐ 第四部分：getter 方法（获取属性值）
    // 格式：public 属性类型 get属性名() { return 属性名; }
    public Integer getId() { return id; }
    public String getName() { return name; }
    public Integer getAge() { return age; }
    public String getEmail() { return email; }

    // ⭐ 第五部分：setter 方法（设置属性值）
    // 格式：public void set属性名(属性类型 属性名) { this.属性名 = 属性名; }
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(Integer age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
}
```

**固定套路总结：**

| 部分 | 作用 | 是否必须 |
|------|------|---------|
| 私有属性 | 对应数据库表的字段 | ✅ 必须 |
| 无参构造 | MyBatis 创建对象时需要 | ✅ 必须 |
| 全参构造 | 方便快速创建对象 | 可选 |
| getter 方法 | Spring 返回 JSON 时读取属性值 | ✅ 必须 |
| setter 方法 | Spring 接收 JSON 时设置属性值 | ✅ 必须 |

> **小技巧：** 在 IDEA 里写完私有属性后，右键 → Generate → Getter and Setter，可以自动生成，不用手写。

> **为什么必须有 getter/setter？** Spring MVC 在接收 JSON 参数时（`@RequestBody`），通过 setter 把 JSON 字段值设置到对象属性中。返回 JSON 时，通过 getter 读取属性值。没有 getter/setter，JSON 序列化/反序列化会失败。

> **实体类属性和数据库字段的映射：** 如果数据库字段是 `user_name`，Java 属性是 `userName`，MyBatis 默认不会自动映射。解决方法见后面"MyBatis 结果映射"部分。

### 2.7 配置文件 application.yml

**是什么：** Spring Boot 的主配置文件，用来配置端口号、数据库连接等。就像你手机的"设置页面"。

**文件位置：** `src/main/resources/application.yml`（或 `application.properties`）

**两种格式（功能一样，选一种就行）：**

```properties
# 格式一：application.properties（键值对，每行一个配置）
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
```

```yaml
# 格式二：application.yml（推荐，层次更清晰）
server:
  port: 8080          # 端口号，默认就是 8080
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb   # 数据库地址
```

> **yml vs properties 选哪个？** 推荐 yml，层次更清晰，可读性更好。两者功能一样，Spring Boot 都能识别。

> **初学阶段你只需要知道：** 如果不写任何配置，Spring Boot 会用默认值（比如默认端口是 8080）。等你需要连数据库时，再在这里加配置就行。

---

# 第二部分：REST API

---

## 3. 接口开发（重点中的重点）

> ⬆ [上一章：2. 项目结构](#2-项目结构核心) | ⬇ [下一章：4. 参数接收](#4-参数接收重点) | [返回目录](#目录)
> 📖 官方文档：[Building a RESTful Web Service](https://spring.io/guides/gs/rest-service)
>
> 👉 [点击跳转到实操 Demo 3：GET 请求](SpringBoot实操Demo.md#demo-3rest-api--get-请求)
> 👉 [点击跳转到实操 Demo 4：POST 请求](SpringBoot实操Demo.md#demo-4rest-api--post-请求)
> 👉 [点击跳转到实操 Demo 5：PUT 和 DELETE 请求](SpringBoot实操Demo.md#demo-5rest-api--put-和-delete-请求)

### 3.1 什么是 REST API？

**用大白话说：** 你在手机上打开淘宝，看到商品列表——这些数据就是后端通过"接口"发给手机 App 的。REST API 就是前端（网页/App）和后端（服务器）之间的"通信方式"。

**一个请求的完整过程：**

```
你在浏览器输入 http://localhost:8080/user/list
        ↓
浏览器发一个 HTTP 请求（就像寄一封信）
        ↓
服务器收到请求，找到对应的 Controller 方法
        ↓
Controller 调用 Service → Service 调用 Mapper → 查数据库
        ↓
数据库返回数据 → Mapper → Service → Controller
        ↓
Controller 把数据返回给浏览器（就像回信）
        ↓
浏览器显示数据（比如 JSON 或页面）
```

**关键词：**

| 关键词 | 通俗解释 | 是否需要记住 |
|--------|---------|-------------|
| **HTTP** | 浏览器和服务器之间的通信规则，就像两个人打电话要遵守的"通话规则" | 了解就行 |
| **请求（Request）** | 浏览器发给服务器的消息，里面包含"你要什么" | 了解就行 |
| **响应（Response）** | 服务器返回给浏览器的消息，里面包含"你要的东西" | 了解就行 |
| **URL** | 接口的地址，比如 `http://localhost:8080/user/list`，就像门牌号 | 了解就行 |
| ⭐ **HTTP 方法** | 请求的类型：GET（查）、POST（增）、PUT（改）、DELETE（删） | **必须记**（4 个方法对应 4 种操作） |
| **RESTful** | 一种接口设计风格，用"URL + HTTP 方法"来表示对资源的操作 | 了解就行 |
| ⭐ **JSON** | 前后端数据交换的格式，类似键值对，比如 `{"name":"张三","age":20}` | **必须记** |

**RESTful 风格 URL 设计规范：**

| 操作 | HTTP 方法 | URL 示例 | 含义 | 类比 |
|------|----------|----------|------|------|
| 查询所有 | GET | `/user/list` | 获取用户列表 | 去超市"看看所有商品" |
| 查询单个 | GET | `/user/1` | 获取 id=1 的用户 | 去超市"拿编号 1 的商品看看" |
| 添加 | POST | `/user` | 新增一个用户 | 往超市"上架一个新商品" |
| 修改 | PUT | `/user` | 修改用户信息 | 把超市里"某个商品的信息改一下" |
| 删除 | DELETE | `/user/1` | 删除 id=1 的用户 | 从超市"下架编号 1 的商品" |

### 3.2 四种 HTTP 方法详解

#### ⭐ GET 请求 —— 查询（最常用）

📁 **以下代码写在 `controller/UserController.java` 里（在类的大括号 `{}` 内部）**

```java
@GetMapping("/list")  // ⭐ 处理 GET 请求，访问 /user/list 时执行这个方法
public List<User> list() {
    return userList;  // 直接返回内存中的用户列表
}
```

**特点：**
- 参数暴露在 URL 中（`/user/list?page=1&size=10`）
- 不会修改服务器数据
- 可以被浏览器缓存
- 有 URL 长度限制

#### ⭐ POST 请求 —— 添加（常用）

📁 **以下代码写在 `controller/UserController.java` 里**

```java
@PostMapping  // ⭐ 处理 POST 请求，用于新增数据
public User save(@RequestBody User user) {
    // @RequestBody 把前端发来的 JSON 自动转成 User 对象
    userList.add(user);  // 添加到列表
    return user;
}
```

**特点：**
- 数据放在请求体（Body）中，不会暴露在 URL
- 没有数据大小限制
- 每次请求都会执行，不会缓存

#### PUT 请求 —— 修改

📁 **以下代码写在 `controller/UserController.java` 里**

```java
@PutMapping  // 处理 PUT 请求，用于修改数据
public User update(@RequestBody User user) {
    // @RequestBody 把前端发来的 JSON 自动转成 User 对象
    for (int i = 0; i < userList.size(); i++) {
        if (userList.get(i).getId().equals(user.getId())) {
            userList.set(i, user);  // 找到对应用户，替换掉
            break;
        }
    }
    return user;  // 返回修改后的用户
}
```

**特点：**
- 数据放在请求体中
- 用于更新已存在的资源

#### DELETE 请求 —— 删除

📁 **以下代码写在 `controller/UserController.java` 里**

```java
@DeleteMapping("/{id}")  // 处理 DELETE 请求，{id} 是路径参数
public String delete(@PathVariable Integer id) {
    // @PathVariable 从 URL 路径中取出 id 的值
    // 比如访问 /user/3，那 id 就是 3
    userList.removeIf(u -> u.getId().equals(id));  // 从列表中删除
    return "删除成功，id=" + id;   // 返回提示信息
}
```

**特点：**
- 用于删除资源
- 参数通常放在 URL 路径中

### 3.3 `@RequestMapping` vs `@GetMapping` 等

| 注解 | 等价于 | 用途 | 是否需要记住 |
|------|--------|------|-------------|
| ⭐ `@GetMapping("/list")` | `@RequestMapping(value="/list", method=GET)` | 处理 GET 请求（查数据） | **必须记** |
| ⭐ `@PostMapping` | `@RequestMapping(method=POST)` | 处理 POST 请求（新增数据） | **必须记** |
| `@PutMapping` | `@RequestMapping(method=PUT)` | 处理 PUT 请求（修改数据） | 用到再查 |
| `@DeleteMapping("/{id}")` | `@RequestMapping(value="/{id}", method=DELETE)` | 处理 DELETE 请求（删除数据） | 用到再查 |

> **类上的 `@RequestMapping` + 方法上的 `@GetMapping` = URL 拼接。** 比如类上 `@RequestMapping("/user")`，方法上 `@GetMapping("/list")`，那完整路径就是 `/user/list`。

---

## 4. 参数接收（重点）

> ⬆ [上一章：3. 接口开发](#3-接口开发重点中的重点) | ⬇ [下一章：5. 返回 JSON 数据](#5-返回-json-数据) | [返回目录](#目录)
> 📖 官方文档：[Spring MVC Request Mapping](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html#web.servlet.spring-mvc)
>
> 👉 [点击跳转到实操 Demo 6：参数接收全解](SpringBoot实操Demo.md#demo-6参数接收全解)

### 4.1 ⭐ `@RequestParam` —— 接收 URL 查询参数

📁 **以下代码写在 `controller/UserController.java` 里**

**适用场景：** 接收 `?key=value` 形式的参数。

**URL 示例：** `GET /user/list?page=1&size=10&name=张三`

**URL 参数拆解：**

```
http://localhost:8080/user/list?page=1&size=10&name=张三
                              └──────────────────────────┘
                                    这部分就是参数
```

| 符号 | 含义 |
|------|------|
| `?` | 参数开始的标志 |
| `page=1` | 参数 page，值是 1 |
| `&` | 连接多个参数 |
| `size=10` | 参数 size，值是 10 |
| `name=张三` | 参数 name，值是"张三" |

> **生活类比：** 你去餐厅点菜，`?page=1&size=10` 就是告诉服务员"我要第 1 页菜单，每页 10 道菜"。

**`@GetMapping` 括号里填什么：**

```java
@GetMapping("/你想起的名字")  // 路径名随便起，有意义就行
```

| 写法 | 最终访问地址 | 说明 |
|------|-------------|------|
| `@GetMapping("/list")` | `/user/list` | 类上 `/user` + 方法上 `/list` |
| `@GetMapping("/all")` | `/user/all` | 路径名随便起 |
| `@GetMapping("/search")` | `/user/search` | 见名知意就好 |

```java
@GetMapping("/list")
public List<User> list(
        @RequestParam Integer page,                    // ⭐ 必传参数：page
        @RequestParam Integer size,                    // ⭐ 必传参数：size
        @RequestParam(required = false) String name    // 可选参数：name（可以不传）
) {
    // 前端访问 /user/list?page=1&size=10 时
    // page = 1, size = 10, name = null（因为没传）
    return userList;  // 此处简化处理，实际项目中会调用 Service 分页查询
}
```

**参数说明：**

| 属性 | 含义 | 默认值 |
|------|------|--------|
| `value` / `name` | 参数名 | 方法参数名 |
| `required` | 是否必传 | `true`（必传） |
| `defaultValue` | 默认值 | 无 |

```java
// 设置默认值：不传时用默认值，不会报错
@RequestParam(defaultValue = "1") Integer page,    // 不传 page 时，默认是 1
@RequestParam(defaultValue = "10") Integer size    // 不传 size 时，默认是 10
```

> **`@RequestParam` 的 `required=false` 和 `defaultValue` 的区别：** `required=false` 表示参数可以不传，不传时值为 `null`。`defaultValue="1"` 表示不传时用默认值 `1`，不会是 `null`。设了 `defaultValue` 就自动 `required=false`。

### 4.2 ⭐ `@PathVariable` —— 接收 URL 路径中的参数

📁 **以下代码写在 `controller/UserController.java` 里**

**适用场景：** 参数是 URL 路径的一部分，RESTful 风格。

**URL 示例：** `GET /user/5`（5 就是用户 id）

```java
@GetMapping("/{id}")    // {id} 是占位符，表示这里有个变量
public User findById(@PathVariable Integer id) {
    // ⭐ @PathVariable 从 URL 路径中取出 {id} 的值
    // 比如访问 /user/5，那 id 就是 5
    for (User user : userList) {
        if (user.getId().equals(id)) {
            return user;
        }
    }
    return null;
}
```

**多个路径参数：**

```java
@GetMapping("/{userId}/orders/{orderId}")    // URL 里有两个变量
public Order getOrder(
        @PathVariable Integer userId,        // 取出第一个 {userId} 的值
        @PathVariable Integer orderId        // 取出第二个 {orderId} 的值
) {
    // 比如访问 /user/5/orders/100
    // userId = 5, orderId = 100
    return orderService.findByUserAndOrder(userId, orderId);
}
```

### Spring 怎么知道 id 是 5，而不是 user 是 id？

**关键：URL 路径是分段匹配的，用 `/` 分隔，Spring 一段一段地匹配！**

当请求 `GET /user/5` 进来时：

```
类上的注解：       @RequestMapping("/user")      ← 固定的！必须匹配 "/user"
方法上的注解：     @GetMapping("/{id}")           ← 占位符！匹配剩下的部分

拼在一起 = /user/{id}
           ↑↑↑↑  ↑↑↑
        固定匹配   变量匹配
```

**匹配过程：**

```
  GET /user/5
      ↓
  👀 "前面是 /user 吗？"       → 是的！（跟类上的 @RequestMapping("/user") 匹配）
      ↓
  👀 "那 /user 后面跟着啥？"   → 是 5！
      ↓
  👀 "方法的路径是 /{id}"     → 好，那 5 就填到 {id} 这个坑里
      ↓
  🎉 id = 5
```

**那如果访问的是 `/user/user` 呢？**

```
GET /user/user
     ↓
id = user  ← {id} 这个坑里填的就是 "user" 这个字符串
```

`{id}` 就是一个**坑位**，管你填进来的是 `5` 还是 `user`，它都老老实实接住！

> **生活类比 🍪：** 快递地址 `/中国/北京市/{门牌号}`，快递员看到 `/中国/北京市/888号`，他不会把"中国"当成门牌号，因为地址格式本身就是**先匹配固定的词，剩下的才填到占位符里**。

> **`@RequestParam` vs `@PathVariable` 选择指南：**
> - 参数在 `?` 后面 → 用 `@RequestParam`：`/user/list?page=1`
> - 参数在 URL 路径中 → 用 `@PathVariable`：`/user/1`
> - 简单规则：**查询条件用 `@RequestParam`，资源标识用 `@PathVariable`**

### 4.3 `@RequestBody` —— 接收 JSON 请求体（重点）

📁 **以下代码写在 `controller/UserController.java` 里**

**适用场景：** 前端发送 JSON 数据，后端接收并自动转为 Java 对象。

**前端发送的请求示例：**
```
POST /user
Content-Type: application/json

{
    "name": "张三",
    "age": 20,
    "email": "zhangsan@example.com"
}
```

**后端接收：**

```java
@PostMapping
public User save(@RequestBody User user) {
    // Spring Boot 自动把 JSON 转成 User 对象
    // user.getName() = "张三"
    // user.getAge() = 20
    userList.add(user);
    return user;
}
```

> **`@RequestBody` 工作原理：** Spring Boot 内置了 Jackson 库，它会自动把 JSON 字符串转成 Java 对象。JSON 的 key 要和 Java 对象的属性名一致（或者用注解映射）。

> **`@RequestBody` vs `@RequestParam` 选择指南：**
> - 提交表单数据（`application/x-www-form-urlencoded`）→ 用 `@RequestParam`
> - 提交 JSON 数据（`application/json`）→ 用 `@RequestBody`
> - 简单规则：**GET 请求参数用 `@RequestParam`，POST/PUT 的 JSON 数据用 `@RequestBody`**

### 4.4 完整参数接收对照表

| 注解 | 数据来源 | Content-Type | 适用场景 | 是否需要记住 |
|------|---------|-------------|---------|-------------|
| ⭐ `@RequestParam` | URL 查询参数 `?key=value` | 任意 | GET 请求的筛选条件 | **必须记** |
| ⭐ `@PathVariable` | URL 路径 `/user/{id}` | 任意 | RESTful 资源标识 | **必须记** |
| ⭐ `@RequestBody` | 请求体 JSON | `application/json` | POST/PUT 提交复杂数据 | **必须记** |

---

## 5. 返回 JSON 数据

> ⬆ [上一章：4. 参数接收](#4-参数接收重点) | ⬇ [下一章：6. 连接 MySQL](#6-连接-mysql) | [返回目录](#目录)
> 👉 [点击跳转到实操 Demo 7：Result 统一返回封装](SpringBoot实操Demo.md#demo-7result-统一返回封装)

### 5.1 自动 JSON 转换

📁 **以下代码写在 `controller/UserController.java` 里**

**核心机制：** 当你用 `@RestController` 时，方法返回的 Java 对象会自动被 Spring Boot 转成 JSON。

```java
@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
        // 返回的 User 对象会自动转成 JSON：
        // {"id":1,"name":"张三","age":20,"email":"zhangsan@example.com"}
    }
}
```

> **为什么能自动转？** `@RestController` 包含了 `@ResponseBody`，加上项目引入了 `spring-boot-starter-web`（内置 Jackson 库），Spring Boot 会自动用 Jackson 把返回对象序列化为 JSON。

> **序列化（Serialization）解释：** 把 Java 对象转成 JSON 字符串的过程叫序列化。反过来，把 JSON 字符串转成 Java 对象叫反序列化。

### 5.2 返回类型

📁 **以下代码写在 `controller/UserController.java` 里**

```java
// 返回单个对象
@GetMapping("/user/{id}")
public User findById(@PathVariable Integer id) {
    return userService.findById(id);
}
// 响应：{"id":1,"name":"张三","age":20}

// 返回列表
@GetMapping("/user/list")
public List<User> list() {
    return userService.findAll();
}
// 响应：[{"id":1,"name":"张三","age":20},{"id":2,"name":"李四","age":25}]

// 返回封装结果（推荐）
@GetMapping("/user/{id}")
public Result findById(@PathVariable Integer id) {
    User user = userService.findById(id);
    return Result.success(user);
}
// 响应：{"code":200,"msg":"success","data":{"id":1,"name":"张三","age":20}}
```

### 5.3 Result 统一返回封装类（必须掌握）

📁 **以下代码写在 `entity/Result.java`（新建这个文件）**

**为什么需要？** 前端需要一个统一的响应格式，方便处理成功和失败。

**固定结构：三个属性 + 两个静态方法 + getter/setter**

```java
public class Result<T> {
    // ⭐ 第一部分：三个属性（固定写法）
    private Integer code;    // 状态码：200 表示成功，500 表示失败
    private String msg;      // 提示信息：比如 "success" 或 "用户不存在"
    private T data;          // 返回数据：可以是任何类型（User、List、String 等）

    // ⭐ 第二部分：两个静态方法（固定写法，直接调用就行）

    // 成功（带数据）：调用 Result.success(数据)
    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(200);         // 设置状态码为 200
        r.setMsg("success");    // 设置提示信息
        r.setData(data);        // 设置返回数据
        return r;
    }

    // 成功（不带数据）：调用 Result.success()
    public static Result success() {
        return success(null);   // data 为 null
    }

    // 失败：调用 Result.error("错误信息")
    public static Result error(String msg) {
        Result r = new Result();
        r.setCode(500);         // 设置状态码为 500
        r.setMsg(msg);          // 设置错误信息
        return r;
    }

    // ⭐ 第三部分：getter 和 setter（固定写法）
    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
```

> **`success` 为什么能直接用 `Result.success(user)` 调用？** 因为它是 `static` 静态方法——不用 `new`，直接用类名就能调用。`success` 方法内部自己会 `new Result()` 并设置好数据，你只需要传值进去就行。👉 [详情看 Java 知识点：static 静态方法](Java知识点.md#24--static-静态方法不用-new-就能调用)

### ⭐ `<T> Result<T>` 逐个拆解

这段代码初学时最容易看晕，拆开来看就清楚了：

```java
//            声明T       返回类型用了T
//            ↓              ↓
public static <T> Result<T> success(T data)
│             │      │       │       │
│             │      │       │       └── 参数：你传进来的数据（User、List 等）
│             │      │       └── 方法名
│             │      └── 返回值类型：Result<T>（装了 T 类型数据的 Result）
│             └── 声明："我要用一个类型占位符，叫它 T"
└── static：不用 new，直接调用
```

**T 到底是什么？由你传的参数决定！**

```java
// 你传了一个 User → T 就是 User → 返回 Result<User>
User user = new User(1, "张三", 20, "zhangsan@example.com");
Result<User> r = Result.success(user);
// 前端收到：{"code":200,"msg":"success","data":{"id":1,"name":"张三",...}}

// 你传了一个 List<User> → T 就是 List<User> → 返回 Result<List<User>>
List<User> list = userList;
Result<List<User>> r = Result.success(list);
// 前端收到：{"code":200,"msg":"success","data":[{"id":1,...},{"id":2,...}]}

// 你没传数据 → T 就是 Void → 返回 Result<Void>
Result r = Result.success();
// 前端收到：{"code":200,"msg":"success","data":null}
```

**一句话：`<T>` 声明"我有一个万能类型叫 T"，`Result<T>` 表示"返回的 Result 里面装的东西就是 T"，T 具体是什么看你传了什么参数** 📦

**固定套路总结：**

| 部分 | 作用 | 说明 |
|------|------|------|
| 三个属性 | code、msg、data | 固定写法，不用改 |
| `Result.success(data)` | 返回成功结果（带数据） | 操作成功时调用 |
| `Result.success()` | 返回成功结果（不带数据） | 操作成功但不需要返回数据时调用 |
| `Result.error(msg)` | 返回失败结果 | 操作失败时调用，传入错误信息 |
| getter/setter | 读写属性值 | 固定写法，IDEA 可以自动生成 |

> **这个类你只需要写一次，以后每个项目都可以复用。** 直接复制粘贴就行，不用每次重新写。

**使用示例（以下代码写在 `controller/UserController.java` 里）：**

```java
// 查询成功
@GetMapping("/{id}")
public Result findById(@PathVariable Integer id) {
    User user = userService.findById(id);
    if (user == null) {
        return Result.error("用户不存在");
    }
    return Result.success(user);
}

// 添加成功
@PostMapping
public Result save(@RequestBody User user) {
    userService.save(user);
    return Result.success();
}
```

> **为什么 `Result<T>` 用泛型？** 泛型 `<T>` 让 `data` 字段可以是任何类型：`Result<User>`、`Result<List<User>>` 等，不用为每种数据写一个 Result 类。

---

# 第三部分：数据库整合

---

## 6. 连接 MySQL

> ⬆ [上一章：5. 返回 JSON 数据](#5-返回-json-数据) | ⬇ [下一章：7. MyBatis](#7-mybatis重点) | [返回目录](#目录)
> 📖 官方文档：[Data Access - SQL Databases](https://docs.spring.io/spring-boot/docs/current/reference/html/data.html#data.sql)
>
> 👉 [点击跳转到实操 Demo 8：连接 MySQL 数据库](SpringBoot实操Demo.md#demo-8连接-mysql-数据库)

### 6.1 配置数据源

在 `application.yml` 中配置数据库连接信息：

📁 **写在 `src/main/resources/application.yml`**

```yaml
spring:
  datasource:
    # ⭐ 数据库连接地址（改成你自己的数据库名）
    url: jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8
    username: root        # ⭐ 数据库用户名（改成你自己的）
    password: 123456      # ⭐ 数据库密码（改成你自己的）
    driver-class-name: com.mysql.cj.jdbc.Driver  # MySQL 驱动（不用改）
```

**关键词解释：**

| 关键词 | 通俗解释 |
|--------|---------|
| **JDBC** | Java 连接数据库的"万能插头"，不管什么数据库都能通过 JDBC 连接 |
| **数据源（DataSource）** | 管理数据库连接的"池子"，预先创建好一批连接，用的时候从池子里取，用完还回去 |
| **url** | 数据库的地址，格式是 `jdbc:mysql://IP:端口/数据库名` |
| **username** | 数据库的用户名，一般是 `root` |
| **password** | 数据库的密码，你自己设置的 |
| **driver-class-name** | MySQL 驱动的类名，固定写法，不用改 |

> **JDBC URL 拆解：** `jdbc:mysql://localhost:3306/mydb`
> - `jdbc:mysql://` — 协议（通过 JDBC 连接 MySQL）
> - `localhost` — 数据库服务器地址（本机）
> - `3306` — MySQL 默认端口
> - `mydb` — 数据库名（改成你自己的数据库名）

> **你需要改的地方：** 只有 `url`（数据库名）、`username`（用户名）、`password`（密码）这三个，其他不用动。

### 6.2 依赖配置

在 `pom.xml` 的 `<dependencies>` 里加两个依赖：

📁 **写在项目根目录的 `pom.xml` 里**

```xml
<!-- ⭐ MySQL 驱动：让 Java 能和 MySQL 数据库"对话" -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- ⭐ JDBC：数据库连接的基础工具 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

> **怎么加？** 打开 `pom.xml`，找到 `<dependencies>` 标签，在里面粘贴这两段代码，然后点 Maven 的 Reload 按钮。

> **`<scope>runtime</scope>` 解释：** 表示这个依赖只在运行时需要，编译时不需要。MySQL 驱动在代码里不会直接 import，只在运行时通过 JDBC URL 自动加载，所以用 runtime。

---

## 7. MyBatis（重点）

> ⬆ [上一章：6. 连接 MySQL](#6-连接-mysql) | ⬇ [下一章：8. CRUD 操作](#8-crud-操作最重要) | [返回目录](#目录)
> 📖 MyBatis 官方文档：[MyBatis 3](https://mybatis.org/mybatis-3/zh/index.html)
> 📖 MyBatis-Spring-Boot 官方仓库：[mybatis-spring-boot](https://github.com/mybatis/spring-boot-starter)
>
> 👉 [点击跳转到实操 Demo 9：MyBatis 注解方式 CRUD](SpringBoot实操Demo.md#demo-9mybatis-注解方式-crud)
> 👉 [点击跳转到实操 Demo 10：MyBatis XML 方式 CRUD](SpringBoot实操Demo.md#demo-10mybatis-xml-方式-crud)

### 7.1 什么是 MyBatis？

**一句话解释：** MyBatis 是一个持久层框架，帮你把 Java 方法和 SQL 语句关联起来，省去手写 JDBC 代码的麻烦。

**关键词：**

| 关键词 | 解释 | 类比 |
|--------|------|------|
| **持久层** | 负责把数据"持久化"（保存）到数据库的代码层 | Mapper/DAO 层就是持久层 |
| **ORM** | Object-Relational Mapping，对象关系映射。把数据库表映射为 Java 对象 | 数据库的行 → Java 的对象 |
| **SQL 映射** | 把一个 Java 方法对应到一条 SQL 语句 | 调用 `findAll()` 就执行 `SELECT * FROM user` |

> **MyBatis vs JDBC 的区别：**
> - JDBC：需要手动写 `Connection`、`PreparedStatement`、`ResultSet`，代码繁琐
> - MyBatis：你只需要写接口 + SQL，框架自动处理连接、参数设置、结果映射

### 7.2 MyBatis 两种写 SQL 的方式

**方式一：注解方式（适合简单 SQL）**

📁 **写在 `mapper/UserMapper.java`**

MyBatis 提供了 4 个注解，分别对应增删改查 4 种 SQL 操作：

| 注解 | 对应的 SQL | 是否需要记住 |
|------|-----------|-------------|
| ⭐ `@Select` | SELECT 查询 | **必须记** |
| ⭐ `@Insert` | INSERT 新增 | **必须记** |
| `@Update` | UPDATE 修改 | 用到再查 |
| `@Delete` | DELETE 删除 | 用到再查 |

```java
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")     // ⭐ 查询
    User findById(Integer id);

    @Insert("INSERT INTO user(name, age, email) VALUES(#{name}, #{age}, #{email})")  // ⭐ 新增
    void insert(User user);

    @Update("UPDATE user SET name=#{name}, age=#{age} WHERE id=#{id}")  // 修改
    void update(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")        // 删除
    void delete(Integer id);
}
```

**方式二：XML 方式（适合复杂 SQL）**

📁 **Mapper 接口写在 `mapper/UserMapper.java`，SQL 写在 `resources/mapper/UserMapper.xml`**

```java
@Mapper
public interface UserMapper {
    List<User> findAll();
    User findById(Integer id);
    void insert(User user);
}
```

```xml
<!-- resources/mapper/UserMapper.xml -->
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.myapp.mapper.UserMapper">

    <!-- 查询所有 -->
    <select id="findAll" resultType="com.example.myapp.entity.User">
        SELECT * FROM user
    </select>

    <!-- 根据 ID 查询 -->
    <select id="findById" resultType="com.example.myapp.entity.User">
        SELECT * FROM user WHERE id = #{id}
    </select>

    <!-- 插入 -->
    <insert id="insert" parameterType="com.example.myapp.entity.User">
        INSERT INTO user(name, age, email)
        VALUES(#{name}, #{age}, #{email})
    </insert>
</mapper>
```

> **两种方式怎么选？**
> - 简单的单表 CRUD → 注解方式，方便快捷
> - 复杂的多表联查、动态 SQL → XML 方式，更灵活

> **XML 方式的 namespace 必须和 Mapper 接口的全限定名一致！** 比如接口是 `com.example.myapp.mapper.UserMapper`，那 XML 的 `namespace` 也要写 `com.example.myapp.mapper.UserMapper`。

> **XML 方式需要配置扫描路径！** 在 `application.yml` 中加：
> ```yaml
> mybatis:
>   mapper-locations: classpath:mapper/*.xml
> ```

### 7.3 `#{}` 和 `${}` 的区别（重要）

| 语法 | 作用 | 安全性 | 使用场景 | 是否需要记住 |
|------|------|--------|---------|-------------|
| ⭐ `#{}` | 参数占位符，会被转成 `?`，然后用 PreparedStatement 设置值 | **安全，防 SQL 注入** | 99% 的场景都用这个 | **必须记**（写 SQL 就用它） |
| `${}` | 字符串替换，直接把值拼接到 SQL 中 | **不安全，有 SQL 注入风险** | 只用于动态表名、列名等 | 了解就行（知道它不安全） |

```java
// ✅ 安全：使用 #{}
@Select("SELECT * FROM user WHERE name = #{name}")

// ❌ 危险：使用 ${}（仅在动态列名时使用）
@Select("SELECT * FROM user ORDER BY ${columnName}")
```

> **SQL 注入解释：** 假设用户输入 `name = "张三 OR 1=1"`，如果用 `${}` 拼接，SQL 变成 `SELECT * FROM user WHERE name = 张三 OR 1=1`，会查出所有数据！用 `#{}` 就不会有这个问题，因为它会把参数当作纯字符串处理。

### 7.4 结果映射（数据库字段名 vs Java 属性名）

**问题：** 数据库字段 `user_name` 和 Java 属性 `userName` 名字不一样，MyBatis 默认不会自动映射。

**解决方法一：SQL 别名**

```sql
SELECT id, user_name AS userName, age, email FROM user
```

**解决方法二：开启驼峰命名转换（推荐）**

```yaml
mybatis:
  configuration:
    map-underscore-to-camel-case: true
```

> **驼峰命名（Camel Case）解释：** `user_name`（下划线命名）→ `userName`（驼峰命名）。开启这个配置后，MyBatis 会自动把 `user_name` 映射到 `userName`。

**解决方法三：`@Results` 注解手动映射**

```java
@Select("SELECT * FROM user WHERE id = #{id}")
@Results({
    @Result(property = "userName", column = "user_name"),
    @Result(property = "createTime", column = "create_time")
})
User findById(Integer id);
```

### 7.5 MyBatis 动态 SQL（进阶但实用）

**`<if>` 标签：** 条件判断

```xml
<select id="findByName" resultType="User">
    SELECT * FROM user WHERE 1=1
    <if test="name != null and name != ''">
        AND name LIKE CONCAT('%', #{name}, '%')
    </if>
    <if test="age != null">
        AND age = #{age}
    </if>
</select>
```

> **`WHERE 1=1` 的作用：** 这是一个技巧，因为后面的 `<if>` 条件可能不成立，`1=1` 保证 SQL 语法正确。后面可以统一用 `AND` 连接条件。

**`<where>` 标签（更优雅的写法）：**

```xml
<select id="findByName" resultType="User">
    SELECT * FROM user
    <where>
        <if test="name != null and name != ''">
            AND name LIKE CONCAT('%', #{name}, '%')
        </if>
        <if test="age != null">
            AND age = #{age}
        </if>
    </where>
</select>
```

> **`<where>` 的好处：** 它会自动去掉多余的 `AND` / `OR`，不用写 `WHERE 1=1`。

---

## 8. CRUD 操作（最重要）

> ⬆ [上一章：7. MyBatis](#7-mybatis重点) | ⬇ [下一章：9. 前端调用接口](#9-前端调用接口) | [返回目录](#目录)
> 👉 [点击跳转到实操 Demo 12：完整项目——用户管理系统](SpringBoot实操Demo.md#demo-12完整项目--用户管理系统)

### 8.1 完整 CRUD 示例结构

以"用户管理"为例，一个完整的 CRUD 涉及以下文件：

```
entity/User.java              ← 实体类
mapper/UserMapper.java        ← Mapper 接口（写 SQL）
service/UserService.java      ← Service 接口
service/impl/UserServiceImpl.java  ← Service 实现（写业务逻辑）
controller/UserController.java     ← Controller（写接口）
```

### 8.2 查询操作

📁 **以下代码写在 `mapper/UserMapper.java` 里**

```java
// Mapper
@Select("SELECT * FROM user")
List<User> findAll();

@Select("SELECT * FROM user WHERE id = #{id}")
User findById(Integer id);

@Select("SELECT * FROM user WHERE name LIKE CONCAT('%', #{name}, '%')")
List<User> findByName(String name);
```

> **模糊查询：** 用 `LIKE` + `CONCAT` 拼接 `%`。`%张三%` 表示包含"张三"的都匹配。

### 8.3 添加操作

📁 **以下代码写在 `mapper/UserMapper.java` 里**

```java
// Mapper
@Insert("INSERT INTO user(name, age, email) VALUES(#{name}, #{age}, #{email})")
@Options(useGeneratedKeys = true, keyProperty = "id")  // 插入后自动回填 id
void insert(User user);
```

> **`@Options(useGeneratedKeys = true)` 解释：** 数据库插入数据时会自动生成主键 id，这个配置让 MyBatis 把生成的 id 自动设置到 User 对象的 `id` 属性中。插入后你就可以通过 `user.getId()` 拿到新记录的 id。

### 8.4 修改操作

📁 **以下代码写在 `mapper/UserMapper.java` 里**

```java
// Mapper
@Update("UPDATE user SET name=#{name}, age=#{age}, email=#{email} WHERE id=#{id}")
void update(User user);
```

### 8.5 删除操作

📁 **以下代码写在 `mapper/UserMapper.java` 里**

```java
// Mapper
@Delete("DELETE FROM user WHERE id = #{id}")
void delete(Integer id);
```

---

# 第四部分：前后端交互

---

## 9. 前端调用接口

> ⬆ [上一章：8. CRUD 操作](#8-crud-操作最重要) | ⬇ [下一章：10. JSON 交互](#10-json-交互) | [返回目录](#目录)
> 👉 [点击跳转到实操 Demo 13：前端调用接口示例](SpringBoot实操Demo.md#demo-13前端调用接口示例)

### 9.1 fetch（原生 API）

```javascript
// GET 请求
fetch('/user/list')
    .then(response => response.json())  // 把响应转成 JSON
    .then(data => {
        console.log(data);  // 拿到数据
    });

// POST 请求
fetch('/user', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'  // 告诉后端发送的是 JSON
    },
    body: JSON.stringify({          // 把 JS 对象转成 JSON 字符串
        name: '张三',
        age: 20,
        email: 'zhangsan@example.com'
    })
})
.then(response => response.json())
.then(data => {
    console.log(data);
});
```

### 9.2 axios（推荐，更简洁）

```javascript
// GET 请求
axios.get('/user/list').then(response => {
    console.log(response.data);
});

// POST 请求
axios.post('/user', {
    name: '张三',
    age: 20,
    email: 'zhangsan@example.com'
}).then(response => {
    console.log(response.data);
});

// PUT 请求
axios.put('/user', {
    id: 1,
    name: '张三改名了',
    age: 21
}).then(response => {
    console.log(response.data);
});

// DELETE 请求
axios.delete('/user/1').then(response => {
    console.log(response.data);
});
```

> **fetch vs axios 选择：** axios 更常用，因为它自动处理 JSON 转换、错误处理更友好、支持请求拦截等。fetch 是浏览器原生的，需要手动 `.json()` 转换。

---

## 10. JSON 交互

> ⬆ [上一章：9. 前端调用接口](#9-前端调用接口) | [返回目录](#目录)

### 10.1 JSON 基础格式

```json
{
    "name": "张三",
    "age": 20,
    "hobbies": ["编程", "游戏"],
    "address": {
        "city": "北京",
        "street": "中关村"
    }
}
```

**JSON 规则：**
- 键（key）必须用双引号
- 字符串用双引号
- 数字不用引号
- 数组用 `[]`
- 对象用 `{}`
- `null` 表示空值

### 10.2 前后端完整 JSON 交互流程

```
前端：构造 JS 对象 → JSON.stringify() → 发送到后端
                                              ↓
后端：@RequestBody 接收 → Jackson 反序列化 → Java 对象
                                              ↓
后端处理业务逻辑
                                              ↓
后端：Java 对象 → Jackson 序列化 → JSON 字符串 → 返回前端
                                              ↓
前端：response.json() 解析 → JS 对象 → 渲染页面
```

### 10.3 常见 JSON 相关注解

```java
public class User {
    @JsonIgnore           // 序列化时忽略这个字段（不返回给前端）
    private String password;

    @JsonProperty("user_name")  // JSON 中用 "user_name" 而不是 "userName"
    private String userName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 日期格式化
    private Date createTime;
}
```

---

# 第五部分：核心能力

---

## 能力1：接口开发能力

**检验标准：** 不看教程，能独立写出以下完整接口：

```
GET    /user/list       查询用户列表
GET    /user/{id}       根据 ID 查询
POST   /user            添加用户
PUT    /user            修改用户
DELETE /user/{id}       删除用户
```

## 能力2：数据库操作能力

**检验标准：**
- 能根据业务需求设计数据库表
- 能写基本的 CRUD SQL
- 能用 MyBatis 注解或 XML 方式操作数据库

## 能力3：分层调用能力

**检验标准：** 能清晰说出每一层的职责，并正确编写各层代码：
- Controller 只负责接收请求和返回结果
- Service 负责业务逻辑
- Mapper 负责数据库操作

## 能力4：调试能力

**常见错误排查：**

| 错误类型 | 可能原因 | 排查方法 |
|---------|---------|---------|
| 404 | URL 路径写错、Controller 没被扫描到 | 检查路径、检查包位置 |
| 405 | HTTP 方法不对（该用 POST 用了 GET） | 检查 `@GetMapping` / `@PostMapping` |
| 500 | 后端代码报错（SQL 错误、空指针等） | 看控制台报错信息 |
| JSON 解析错误 | 前端发送的 JSON 格式不对 | 检查 JSON 格式、`Content-Type` |
| 参数接收不到 | 注解用错、参数名不匹配 | 检查注解和参数名 |

---

# 附录：关键词速查表

| 关键词 | 含义 |
|--------|------|
| **Spring** | Java 最流行的框架，提供 IoC、AOP 等功能 |
| **Spring Boot** | Spring 的快速开发工具，约定优于配置 |
| **IoC（控制反转）** | 对象的创建权交给 Spring 容器管理，不用自己 new |
| **DI（依赖注入）** | Spring 自动把需要的对象注入到你的类中（通过 `@Autowired`） |
| **Bean** | Spring 容器管理的对象，就是被 Spring 创建和管理的 Java 对象 |
| **注解（Annotation）** | 以 `@` 开头的标记，给代码贴标签，告诉框架如何处理 |
| **RESTful** | 一种 API 设计风格，用 URL + HTTP 方法表示对资源的操作 |
| **JSON** | 前后端数据交换的文本格式 |
| **序列化** | Java 对象 → JSON 字符串 |
| **反序列化** | JSON 字符串 → Java 对象 |
| **ORM** | 对象关系映射，把数据库表映射为 Java 对象 |
| **JDBC** | Java 连接数据库的标准接口 |
| **Maven** | Java 的包管理和构建工具 |
| **Starter** | Spring Boot 提供的依赖套餐 |
| **YAML / YML** | 一种配置文件格式，比 properties 更清晰 |
| **getter/setter** | 获取/设置实体类属性值的方法，Spring MVC 和 MyBatis 都依赖它们进行数据绑定 |
| **持久层** | 负责数据持久化（保存到数据库）的代码层 |
| **CRUD** | 增（Create）删（Delete）改（Update）查（Read） |
| **HTTP 方法** | GET（查）、POST（增）、PUT（改）、DELETE（删） |
| **Controller** | 控制器层，接收请求、返回结果 |
| **Service** | 服务层，写业务逻辑 |
| **Mapper / DAO** | 数据访问层，操作数据库 |
| **Entity / POJO** | 实体类，对应数据库表 |
| **动态代理** | 框架在运行时自动生成接口的实现类 |
| **驼峰命名** | `userName` 这种命名方式（首单词小写，后续单词首字母大写） |
| **SQL 注入** | 通过恶意输入篡改 SQL 语句的安全漏洞 |
| **Jackson** | Spring Boot 内置的 JSON 处理库 |
| **泛型（Generics）** | Java 中用 `<T>` 表示类型参数，让代码更通用 |
| **接口（Interface）** | Java 中定义"要做什么"的抽象类型，用 `interface` 关键字 |
