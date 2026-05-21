# Java 知识点速查手册

> 本文件记录学习 Spring Boot 过程中遇到的 Java 基础知识点。
> 遇到不懂的 Java 语法或概念，随时来这里查～
> 最后更新：2026-05-17

---

## 目录

- [1. 基础语法](#1-基础语法)
- [2. 面向对象](#2-面向对象)
- [3. 集合框架](#3-集合框架)
- [4. 常用语法](#4-常用语法)
- [5. 速查表](#5-速查表)

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

> **学习建议：** 不用一次全看完，遇到不懂的来这里查就行。用多了自然就记住了～
