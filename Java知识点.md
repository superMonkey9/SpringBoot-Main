# Java 知识点速查手册

> 本文件记录学习 Spring Boot 过程中遇到的 Java 基础知识点。
> 遇到不懂的 Java 语法或概念，随时来这里查～
> 最后更新：2026-05-18

---

## 目录

- [1. 基础语法](#1-基础语法)
- [2. 面向对象](#2-面向对象)
- [3. 集合框架](#3-集合框架)
- [4. 常用语法](#4-常用语法)
- [5. 速查表](#5-速查表)
- [6. Java 程序运行入门](#6-java-程序运行入门从零理解程序怎么跑起来)

---

# 1. 基础语法

---

## 1.1 数据类型

Java 里的数据类型分两种：**基本类型**和**引用类型**。

**基本类型（8 个，记住常用的就行）：**

| 类型 | 含义 | 示例 | 什么时候用 |
|------|------|------|-----------|
| `int` | 整数 | `int age = 20;` | 最常用 |
| `long` | 大整数 | `long id = 12345L;` | 数字很大时用 |
| `double` | 小数 | `double price = 9.9;` | 价格等 |
| `boolean` | 布尔值 | `boolean ok = true;` | 判断对错 |
| `char` | 单个字符 | `char c = 'A';` | 很少用 |

**引用类型（你经常用的）：**

| 类型 | 含义 | 示例 |
|------|------|------|
| `String` | 字符串 | `String name = "张三";` |
| `Integer` | 整数的包装类 | `Integer id = 1;` |
| `List` | 列表 | `List<User> list = new ArrayList<>();` |
| `User` | 你自己定义的类 | `User user = new User();` |

> **`int` 和 `Integer` 的区别：** `int` 是基本类型，不能为 null。`Integer` 是包装类，可以为 null。数据库字段可能为空时，用 `Integer` 更安全。

---

## 1.2 变量

```java
// 声明变量：类型 变量名 = 值;
String name = "张三";
int age = 20;
boolean ok = true;
```

**命名规则：**
- 用字母、数字、`_`、`$`，不能以数字开头
- 大小写敏感：`name` 和 `Name` 是两个不同的变量
- 建议用有意义的名字：`userName` 比 `a` 好

---

## 1.3 方法（函数）

```java
// 格式：返回类型 方法名(参数列表) { 方法体 }

// 无返回值
public void sayHello() {
    System.out.println("Hello!");
}

// 有返回值
public String getName() {
    return "张三";
}

// 有参数
public int add(int a, int b) {
    return a + b;
}
```

**关键词解释：**

| 关键词 | 含义 |
|--------|------|
| `public` | 公开的，其他类可以调用 |
| `private` | 私有的，只有自己类里能用 |
| `void` | 没有返回值 |
| `return` | 返回一个结果 |

---

# 2. 面向对象

---

## 2.1 类和对象

**类是"模板"，对象是"用模板做出来的东西"。**

```java
// 类：定义"人"长什么样
public class User {
    private String name;  // 属性
    private int age;

    public String getName() { return name; }  // 方法
}

// 对象：用模板创建一个具体的人
User user = new User();  // user 就是一个对象
user.getName();          // 调用对象的方法
```

**打个比方：** 类 = 饼干模具，对象 = 用模具做出来的饼干。一个模具可以做很多饼干。

---

## 2.2 构造方法

```java
public class User {
    private String name;
    private int age;

    // 无参构造（创建一个空对象）
    public User() {}

    // 全参构造（创建对象时直接传值）
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// 使用
User user1 = new User();              // 空对象
User user2 = new User("张三", 20);    // 带值的对象
```

> **`this` 是什么？** `this.name = name` 意思是"把参数 name 的值赋给当前对象的 name 属性"。`this` 代表"我自己"。

---

## 2.3 接口

**接口 = 定义"能做什么"，但不告诉你"怎么做"。**

```java
// 接口：定义"能做什么"
public interface UserService {
    List<User> findAll();
    void save(User user);
}

// 实现类：定义"怎么做"
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }
}
```

> **为什么要用接口？** 方便以后换实现。比如现在数据存在内存里，以后可以换成存在数据库里，只需要写一个新的实现类，不用改其他代码。

### ⭐ "接口"的两种含义

中文里"接口"有两个意思，别搞混了：

| 类型 | 英文 | 含义 | 示例 |
|------|------|------|------|
| Java 接口 | `interface` | 定义"能做什么"的抽象类型 | `public interface UserService { ... }` |
| API 接口 | API endpoint | 前端能访问的 URL 地址 | `GET /user/list` |

```java
// ⭐ Java 接口（interface）：定义"能做什么"
public interface UserService {
    List<User> findAll();
}

// ⭐ API 接口（endpoint）：前端能访问的 URL
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/list")          // 这就是一个 API 接口
    public List<User> list() {    // 前端访问 /user/list 就会执行这个方法
        return userService.findAll();
    }
}
```

> **简单记：** 说到 `interface` 关键字 → Java 接口。说到 URL、前端调用 → API 接口。

## 2.4 ⭐ static 静态方法 —— 不用 new 就能调用

**普通方法：必须先 new 对象，才能调用方法。**

```java
// 普通方法：先 new，再调用
Result r = new Result();    // 创建对象
r.getCode();                // 通过对象调用方法
```

**static 方法：直接用类名调用，不用 new。**

```java
// static 方法：直接用类名调用
Result.success(user);       // 不用 new！直接调用
```

**为什么 `Result.success()` 能在 Controller 里直接用？** 因为 `success` 是 static 方法，写在 Result 类里面：

```java
public class Result<T> {
    private Integer code;
    private T data;

    // ⭐ static 方法：属于"类"，不属于"对象"
    public static Result success(T data) {
        Result r = new Result();     // 在方法内部自己 new
        r.setCode(200);
        r.setData(data);
        return r;
    }
}

// 在 Controller 里调用：
return Result.success(user);
// 等价于下面 5 行代码：
Result r = new Result();
r.setCode(200);
r.setMsg("success");
r.setData(user);
return r;
```

**生活类比 🏪：**
- 普通方法 = "问服务员" → 先有服务员（new），才能问问题（调方法）
- static 方法 = "看告示牌" → 不需要服务员，直接看牌（用类名调用）就行

**什么时候用 static？** 当一个方法不需要用到对象的属性时，就可以写成 static。比如工具方法 `Math.random()`、`Arrays.sort()` 都是 static。

---

## 3.1 List 列表

**List 是一个"可变长度的数组"，可以随时添加和删除元素。**

```java
// 创建
List<String> list = new ArrayList<>();

// 添加
list.add("张三");
list.add("李四");

// 获取
list.get(0);    // "张三"（索引从 0 开始）
list.get(1);    // "李四"

// 大小
list.size();    // 2

// 删除
list.remove(0); // 删除第一个元素

// 遍历
for (String name : list) {
    System.out.println(name);
}
```

**List 常用方法速查：**

| 方法 | 作用 | 示例 |
|------|------|------|
| `add(e)` | 添加元素 | `list.add("张三")` |
| `get(i)` | 获取第 i 个元素 | `list.get(0)` |
| `set(i, e)` | 替换第 i 个元素 | `list.set(0, "李四")` |
| `remove(i)` | 删除第 i 个元素 | `list.remove(0)` |
| `removeIf(条件)` | 按条件删除 | `list.removeIf(u -> u.equals("张三"))` |
| `size()` | 获取大小 | `list.size()` |
| `contains(e)` | 是否包含 | `list.contains("张三")` |

---

## 3.3 Lambda 表达式（Java 8）

**Lambda 是一种"简写"，让代码更短更简洁。**

```java
// 格式：参数 -> 表达式

// 普通写法
for (String name : list) {
    System.out.println(name);
}

// Lambda 写法
list.forEach(name -> System.out.println(name));
```

**常见 Lambda 用法：**

```java
// 1. removeIf：按条件删除
userList.removeIf(u -> u.getId().equals(id));
// 翻译：删除 ID 等于 id 的用户

// 2. forEach：遍历
userList.forEach(u -> System.out.println(u.getName()));
// 翻译：打印每个用户的名字

// 3. stream + filter：筛选
List<User> result = userList.stream()
    .filter(u -> u.getAge() > 20)
    .collect(Collectors.toList());
// 翻译：找出年龄大于 20 的用户
```

> **看不懂 Lambda 没关系！** 它只是普通 for 循环的简写形式，用多了自然就懂了。初学者先用普通 for 循环，等熟悉了再尝试 Lambda。

**Lambda 参数名可以随便起：**

```java
// 这些写法效果完全一样，参数名你自己定
userList.removeIf(u -> u.getId().equals(id));
userList.removeIf(user -> user.getId().equals(id));
userList.removeIf(item -> item.getId().equals(id));
```

> **建议：** 起个有意义的名字，比如 `user` 或 `u`，别起 `abc` 这种，不然过几天自己都看不懂了。

---

## 3.4 Map 键值对

**Map 是一个"字典"，通过 key 找 value。**

```java
// 创建
Map<String, Object> map = new HashMap<>();

// 添加
map.put("name", "张三");
map.put("age", 20);

// 获取
map.get("name");  // "张三"
map.get("age");   // 20

// 判断是否存在
map.containsKey("name");  // true
```

### ⭐ 什么时候用哪个集合？（选择指南）

**选集合只看一个事：你的数据长什么样？**

```
你要存什么？              用哪个？
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
一堆东西，排成一排      → ArrayList
一对一对的（名字→值）    → HashMap
不重复的集合            → HashSet
```

**实例对比：**

```java
// ArrayList：排成一排，通过下标取 → 适合存用户列表、订单列表
List<String> names = new ArrayList<>();
names.add("张三");
names.add("李四");
String first = names.get(0);      // "张三" ← 按位置（下标）取

// HashMap：通过名字（key）找值 → 适合存返回结果、配对数据
Map<String, Object> result = new HashMap<>();
result.put("code", 200);
result.put("message", "成功");
Integer code = result.get("code"); // 200 ← 按 key 取

// HashSet：不重复 → 适合去重、判断存不存在
Set<String> tags = new HashSet<>();
tags.add("Java");
tags.add("Java");   // 加不进去！重复了
// tags = ["Java"]
```

**`Map<String, Object>` 为什么用 `Object`？** 因为 `Object` 是万能类型，能装任何东西（String、Integer、Boolean 都行）。这也是 `Map` 和 `Result<T>` 的区别——`Map` 不检查类型，`Result` 更严格、更安全。

| 你想要… | 用这个 | Spring Boot 里的典型用途 |
|---------|--------|------------------------|
| 存一堆数据，有顺序 | `List<T>` / `ArrayList<T>` | 用户列表、订单列表 |
| 通过名字找值 | `Map<String, Object>` / `HashMap` | 存返回结果（临时用，推荐用 `Result<T>` 替代） |
| 去重 | `Set<T>` / `HashSet<T>` | 已处理的ID、不重复的标签 |

### 3.5 ⭐ 泛型 `<T>` —— 万能快递盒

**泛型就是"先不决定装什么类型，用的时候再告诉你"。**

T 就是一个占位符，代表"任意类型"：

```java
// <T> 是"我在类里声明了一个类型占位符，叫它 T"
public class Result<T> {
    private Integer code;
    private String message;
    private T data;    // T 装什么类型，由使用者决定
}
```

**使用时把 T 换成具体类型：**

```java
Result<User>       // T = User → data 装的是 User 对象
Result<List<User>> // T = List<User> → data 装的是用户列表
Result<String>     // T = String → data 装的是字符串
Result<Void>       // T = Void → data 里啥都没装（只关心成不成功）
```

**生活类比 📦：** `Result<T>` 就像一个快递盒，盒子上写"里面装的东西类型是 T"。你下单时才决定装什么。

**`<T>` 写在两个地方的区别：**

```java
// 写在类上：整个类里的方法都共用这个 T
public class Result<T> { ... }

// 写在方法上：方法自己声明一个 T
//     声明  返回类型
//      ↓      ↓
public <T> Result<T> findById(Integer id) {
    return Result.success(user);  // ← 这里 T 自动变成 User
}
```

**前一个 `<T>` = 声明（我宣布这个类型叫 T）**
**后一个 `<T>` = 使用（Result 里装的就是 T）**

**为什么需要泛型？** 没有泛型的话，data 类型是 Object，取出来还要手动强转，容易出错：

```java
// 没有泛型：要强转
User user = (User) result.getData();  // 要手动转类型！

// 有泛型：直接用
Result<User> result = Result.success(user);
User user = result.getData();  // 直接就是 User，不用转！
```

### ⭐ `public class Result` vs `public class Result<T>` 的区别

**没有 `<T>` 的 Result：**

```java
public class Result {
    private Integer code;
    private String msg;
    private Object data;  // ⚠️ data 只能是 Object 类型
}
```

**问题：** `data` 是 `Object`，取出来要手动强转，而且编译器不检查类型：

```java
Result r = new Result();
r.setData("你好");

// 要强转！很麻烦，还容易出错 💥
String s = (String) r.getData();

// 编译不报错，运行时才炸！
Integer num = (Integer) r.getData();  // 💥 ClassCastException
```

**有 `<T>` 的 Result：**

```java
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;  // ⭐ T 是占位符，用的时候才决定装什么类型
}
```

**好处：** 编译器帮你检查类型，不用强转：

```java
Result<String> r = new Result<>();
r.setData("你好");

// 直接取，不用强转 ✅
String s = r.getData();

// 编译直接报错，运行前就拦住了 ✅
r.setData(123);  // ❌ 编译错误：类型不匹配
```

**对比表：**

| | 没有 `<T>` | 有 `<T>` |
|---|---|---|
| data 的类型 | Object（万能盒） | T（指定类型盒） |
| 取出来要强转吗 | 要！`(String) getData()` | 不要！直接 `getData()` |
| 编译时能查错吗 | ❌ 不能 | ✅ 能 |
| 类型安全吗 | ❌ 不安全 | ✅ 安全 |

**生活类比 📦：**
- 没有 `<T>` = 快递盒上只写"里面是东西"，打开才知道是什么，可能拿错 😵
- 有 `<T>` = 快递盒上写"里面是 String"，一看就知道拿的是啥，绝对不拿错 😎

---

# 4. 常用语法

---

## 4.1 for 循环

```java
// 普通 for 循环
for (int i = 0; i < 5; i++) {
    System.out.println(i);  // 0, 1, 2, 3, 4
}

// 增强 for 循环（遍历列表）
List<String> list = new ArrayList<>();
list.add("张三");
list.add("李四");
for (String name : list) {
    System.out.println(name);
}
```

---

## 4.2 if 判断

```java
if (age >= 18) {
    System.out.println("成年了");
} else {
    System.out.println("未成年");
}

// 判断 null
if (user != null) {
    System.out.println(user.getName());
}
```

---

## 4.3 字符串操作

```java
String name = "张三";

name.length();                    // 2（长度）
name.equals("张三");              // true（比较内容）
name.contains("张");              // true（包含）
name.toUpperCase();               // "张三"（转大写，中文没效果）
name + "你好";                    // "张三你好"（拼接）
String.format("名字是%s", name);  // "名字是张三"（格式化）
```

> **比较字符串用 `equals()`，不用 `==`！** `==` 比较的是内存地址，`equals()` 比较的是内容。

---

## 4.4 异常处理

```java
try {
    // 可能出错的代码
    int result = 10 / 0;
} catch (Exception e) {
    // 出错了怎么办
    System.out.println("出错了：" + e.getMessage());
}
```

---

# 5. 速查表

---

## 常用快捷操作

| 操作 | 代码 |
|------|------|
| 创建列表 | `List<User> list = new ArrayList<>();` |
| 添加元素 | `list.add(user);` |
| 获取元素 | `list.get(0);` |
| 删除元素 | `list.remove(0);` |
| 列表大小 | `list.size();` |
| 遍历列表 | `for (User u : list) { ... }` |
| 判断 null | `if (user != null) { ... }` |
| 比较字符串 | `str.equals("xxx")` |
| 打印输出 | `System.out.println("xxx");` |
| 字符串拼接 | `"a" + "b"` |

---

---

# 6. Java 程序运行入门（从零理解程序怎么跑起来）

---

学 Spring Boot 时你经常看到 `main`、`static` 这些东西，但不知道它们到底是什么、什么时候该写、什么时候不用写。这一章帮你彻底搞清楚！

## 6.1 main 方法 —— 程序的入口

### main 是什么？

**main 方法 = 程序的"启动按钮"。** Java 程序必须有一个 main 方法，JVM（Java 虚拟机）从这里开始执行代码。

```java
public static void main(String[] args) {
    // 程序从这里开始执行
    System.out.println("程序启动了！");
}
```

### 逐词拆解

```java
public static void main(String[] args)
│       │      │    │    │
│       │      │    │    └── 参数：String[] args（命令行参数，一般不用管）
│       │      │    └── 方法名：main（固定名字，不能改！）
│       │      └── 返回类型：void（不需要返回值）
│       └── static：不用 new，JVM 直接调用
└── public：公开的，JVM 能访问到
```

**为什么是 `static`？** 因为程序刚启动时还没有任何对象，JVM 需要直接通过类名调用 main 方法，不需要先 new 对象。

### 什么时候要写 main？

| 场景 | 要不要写 main |
|------|-------------|
| 自己写一个 Java 小程序测试 | ✅ 要写 |
| 写一个工具类想直接运行测试 | ✅ 要写 |
| 写 Spring Boot 项目 | ⚠️ 启动类里有一个 main，其他类不用写 |
| 写 Controller / Service / Mapper | ❌ 不用写（Spring 帮你管理） |

### 在 Spring Boot 里

你项目里的 `DemoApplication.java` 就是唯一的 main 方法：

```java
// ⭐ 这是整个 Spring Boot 项目唯一需要 main 的地方
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        // 启动 Spring Boot → 启动 Tomcat → 准备好接收请求
    }
}
```

**你写的 Controller、Service、Mapper 里都不需要写 main！** 因为 Spring Boot 启动后，会自动扫描这些类并管理它们。

## 6.2 ⭐ static 详解 —— 到底属于什么？

### static 是什么？

**static = "属于类的，不属于某个对象的"。**

```java
public class Math {
    // ⭐ static 方法：属于 Math 这个类
    public static double random() { ... }

    // ⭐ static 变量：属于 Math 这个类
    public static final double PI = 3.14159;
}
```

### 有 static vs 没 static

```java
public class User {
    // 普通属性（没 static）：每个对象各有一份
    private String name;
    private Integer age;

    // static 变量：所有对象共享一份
    public static int totalCount = 0;

    // 普通方法（没 static）：必须通过对象调用
    public String getName() {
        return this.name;
    }

    // static 方法：通过类名直接调用
    public static User create(String name) {
        User u = new User();
        u.name = name;
        totalCount++;  // 每创建一个用户，总数 +1
        return u;
    }
}
```

**使用对比：**

```java
// 普通方法：必须先 new
User user = new User("张三", 20);
String name = user.getName();     // 通过对象调用

// static 方法：直接用类名调用
User user = User.create("张三");  // 不用 new，直接调用
int total = User.totalCount;      // 直接用类名访问
```

### 你已经见过的 static

| 写法 | 哪里的 | 为什么是 static |
|------|---------|---------------|
| `public static void main(...)` | 启动类 | JVM 需要直接调用 |
| `Result.success(user)` | Result 类 | 不用 new，直接调用方便 |
| `Math.random()` | Java 自带 | 工具方法，跟具体对象无关 |
| `System.out.println()` | Java 自带 | out 是 static 变量，println 是普通方法 |

### 生活类比 🏠

```
普通属性/方法 = 你家里的电视机
  - 每个家庭（对象）各有一台
  - 你家的电视你用，别人家用不了
  - 必须先有家（new 对象），才能用电视（调方法）

static 属性/方法 = 小区的公告栏
  - 所有住户共享一个
  - 不用先有家，直接去看公告栏（用类名调用）
  - 谁都能看，写的内容所有人看到的都一样
```

### 什么时候用 static？

| 场景 | 用不用 static | 例子 |
|------|-------------|------|
| 方法不需要用到对象的属性 | ✅ 用 static | `Result.success()`、`Math.random()` |
| 工具类的方法 | ✅ 用 static | `Arrays.sort()`、`Collections.sort()` |
| 所有对象共享一个值 | ✅ 用 static 变量 | `User.totalCount` |
| 方法要用到 this（当前对象的属性） | ❌ 不能用 static | `user.getName()`、`user.setName()` |
| Controller / Service 的方法 | ❌ 不能用 static | Spring 要管理这些对象 |

## 6.3 调用关系 —— 谁调谁？

### Spring Boot 里的完整调用链

```
浏览器输入 localhost:8080/user/1
        │
        ▼
┌─────────────────────────────────┐
│  DemoApplication.main()         │ ← 启动项目（唯一一个 main）
│  Spring Boot 启动，扫描所有类     │
└─────────────────────────────────┘
        │
        ▼
┌─────────────────────────────────┐
│  UserController.findById(1)     │ ← 接收请求，拿到参数 id=1
│  {                              │
│      User user = userService    │
│          .findById(1);          │ ← 调用 Service
│      return Result.success(user)│
│  }                              │
└─────────────────────────────────┘
        │
        ▼
┌─────────────────────────────────┐
│  UserServiceImpl.findById(1)    │ ← 写业务逻辑
│  {                              │
│      return userMapper          │
│          .findById(1);          │ ← 调用 Mapper
│  }                              │
└─────────────────────────────────┘
        │
        ▼
┌─────────────────────────────────┐
│  UserMapper.findById(1)         │ ← 执行 SQL
│  @Select("SELECT * FROM user    │
│      WHERE id = #{id}")         │
└─────────────────────────────────┘
        │
        ▼
    数据库返回结果
        │
        ▼
    逐层返回给浏览器
```

### 简化版（你现在阶段记住这个就行）

```
main 启动项目 → Spring 自动管理一切

浏览器请求 → Controller（接请求）
                   ↓ 调用
              Service（写逻辑）
                   ↓ 调用
              Mapper（查数据库）
                   ↓
              数据库
```

**你写代码时只需要关心：**
- Controller 方法：接收参数，调 Service，返回结果
- Service 方法：写业务逻辑，调 Mapper
- Mapper 方法：写 SQL

**不需要写 main！** 因为 Spring Boot 的 `DemoApplication.main()` 已经帮你启动了一切。

## 6.4 什么时候用什么集合？（强化版）

**你在写 Spring Boot 代码时，90% 的场景用这两个就够了：**

### 场景一：存一堆数据 → 用 `List`

```java
// 返回用户列表、订单列表、商品列表……
@GetMapping("/user/list")
public List<User> list() {
    return userList;  // List<User>
}
```

```java
// 声明
List<User> userList = new ArrayList<>();

// 常用操作
userList.add(user);              // 添加
userList.get(0);                 // 获取第 0 个
userList.set(0, user);           // 替换第 0 个
userList.remove(0);              // 删除第 0 个
userList.removeIf(u -> ...);     // 按条件删除
userList.size();                 // 大小
for (User u : userList) { ... }  // 遍历
```

### 场景二：通过名字找值 → 用 `Map`

```java
// 临时组装返回数据（正式项目用 Result 替代）
Map<String, Object> result = new HashMap<>();
result.put("code", 200);
result.put("msg", "成功");
result.get("code");  // 200
```

### 场景三：去重 → 用 `Set`（偶尔用）

```java
// 已处理的 ID、不重复的标签
Set<Integer> processedIds = new HashSet<>();
processedIds.add(1);
processedIds.add(1);  // 加不进去，重复了
processedIds.contains(1);  // true
```

### 快速选择表

```
你的数据长什么样？          用哪个？
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
排成一排，按顺序取       →  List / ArrayList
名字→值，按键查找        →  Map / HashMap
不重复                   →  Set / HashSet
键值对，保持插入顺序     →  LinkedHashMap
键值对，按 key 排序      →  TreeMap
```

### Spring Boot 里的典型用法

| 场景 | 用什么 | 示例 |
|------|--------|------|
| Controller 返回列表 | `List<User>` | 用户列表、商品列表 |
| Mapper 查询多条数据 | `List<User>` | `SELECT * FROM user` |
| Result 封装返回 | `Result<T>` | 实际上是包装了 List/单个对象 |
| 临时组装数据 | `Map<String, Object>` | 学习阶段用，正式项目用 Result |

---

> **学习建议：** 这一章不用一次全记住，遇到不懂的概念来查就行。main、static、调用关系这些在写 Spring Boot 时会反复用到，用多了自然就懂了～
