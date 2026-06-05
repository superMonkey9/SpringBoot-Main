# 前端实操 Demo 手册

> 本文件包含所有前端知识点的完整实操示例，按学习路线组织，每个 Demo 都可以动手练习。
> 遇到不懂的知识点？👉 [点击跳转到前端知识点](前端知识点.md)
> 后端项目对应 Spring Boot 知识点？👉 [点击跳转到 SpringBoot 知识点](SpringBoot知识点.md)
> 最后更新：2026-06-04

---

## 目录

- [Demo 1：第一个 HTML 页面](#demo-1第一个-html-页面)
- [Demo 2：常用标签示范](#demo-2常用标签示范)
- [Demo 3：登录页面](#demo-3登录页面)
- [Demo 4：注册页面](#demo-4注册页面)
- [Demo 5：用户表格](#demo-5用户表格)
- [Demo 6：CSS 选择器练习](#demo-6css-选择器练习)
- [Demo 7：盒模型练习](#demo-7盒模型练习)
- [Demo 8：Flex 布局实战](#demo-flex-布局实战)
- [Demo 9：定位练习](#demo-9定位练习)
- [Demo 10：JS 基础语法练习](#demo-10js-基础语法练习)
- [Demo 11：数组和对象练习](#demo-11数组和对象练习)
- [Demo 12：ES6 语法练习](#demo-12es6-语法练习)
- [Demo 13：DOM 操作实战](#demo-13dom-操作实战)
- [Demo 14：事件处理实战](#demo-14事件处理实战)
- [Demo 15：fetch 请求实战](#demo-15fetch-请求实战)
- [Demo 16：完整联调实战](#demo-16完整联调实战)
- [Demo 17：综合实战——用户管理系统前端](#demo-17综合实战用户管理系统前端)
- [练习题](#练习题)
- [踩坑记录](#踩坑记录)

---

# Demo 1：第一个 HTML 页面

> ⬆ [返回目录](#目录) | ⬇ [下一章：Demo 2](#demo-2常用标签示范)
> 📖 [点击跳转到对应知识点：HTML 基本结构](前端知识点.md#1-html-基本结构)

📁 **文件位置：`my-project/src/main/resources/static/week1-html/01-basic.html`**

## 步骤一：创建文件

在 IntelliJ IDEA 中，右键 `static/week1-html/` → New → HTML File → 输入 `01-basic.html`

## 步骤二：写代码

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>我的第一个页面</title>
</head>
<body>
    <h1>Hello World!</h1>
    <p>这是我写的第一个 HTML 页面！</p>
</body>
</html>
```

## 步骤三：运行查看

1. 启动 my-project 项目
2. 浏览器访问：`http://localhost:8081/week1-html/01-basic.html`

## 知识点回顾

- `<!DOCTYPE html>` 声明 HTML5
- `<meta charset="UTF-8">` 防止中文乱码
- `<head>` 放配置，`<body>` 放内容

---

# Demo 2：常用标签示范

> ⬆ [上一章：Demo 1](#demo-1第一个-html-页面) | ⬇ [下一章：Demo 3](#demo-3登录页面) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：常用标签](前端知识点.md#2-常用标签)

📁 **文件位置：`my-project/src/main/resources/static/week1-html/02-tags.html`**

## 练习目标

把所有常用标签都用一遍，建立肌肉记忆。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>常用标签示范</title>
</head>
<body>
    <!-- 标题 -->
    <h1>一级标题</h1>
    <h2>二级标题</h2>
    <h3>三级标题</h3>

    <!-- 段落 -->
    <p>这是一个段落。</p>
    <p>这是另一个段落，中间会自动有间距。</p>

    <!-- div 容器 -->
    <div style="border: 1px solid #ccc; padding: 10px;">
        <p>div 里面的段落</p>
        <p>div 可以包裹多个元素</p>
    </div>

    <!-- span 行内容器 -->
    <p>这是一段话，<span style="color: red;">这部分是红色的</span>。</p>

    <!-- 链接 -->
    <a href="https://www.baidu.com" target="_blank">点击打开百度</a>

    <!-- 图片 -->
    <!-- <img src="photo.jpg" alt="照片" width="200"> -->

    <!-- 按钮 -->
    <button onclick="alert('你点击了按钮！')">点击我</button>

    <!-- 列表 -->
    <h3>无序列表</h3>
    <ul>
        <li>Java</li>
        <li>MySQL</li>
        <li>Spring Boot</li>
    </ul>

    <h3>有序列表</h3>
    <ol>
        <li>第一步：学习 HTML</li>
        <li>第二步：学习 CSS</li>
        <li>第三步：学习 JavaScript</li>
    </ol>
</body>
</html>
```

## 验证

访问 `http://localhost:8081/week1-html/02-tags.html`，确认：
- 标题有大有小（h1 最大，h3 较小）
- 段落之间有间距
- div 有边框，里面包裹了段落
- span 里的文字是红色的
- 点击链接会打开新标签页
- 点击按钮会弹出提示框
- 列表显示正确

---

# Demo 3：登录页面

> ⬆ [上一章：Demo 2](#demo-2常用标签示范) | ⬇ [下一章：Demo 4](#demo-4注册页面) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：表单标签](前端知识点.md#3-表单标签重点)

📁 **文件位置：`my-project/src/main/resources/static/week1-html/login.html`**

## 练习目标

写出一个完整的登录页面，用到 form、input、button、a 标签。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
    <h1>用户登录</h1>

    <form action="/user/login" method="post">
        <div>
            <label for="username">用户名：</label>
            <input type="text" id="username" name="username" placeholder="请输入用户名">
        </div>

        <div>
            <label for="password">密码：</label>
            <input type="password" id="password" name="password" placeholder="请输入密码">
        </div>

        <div>
            <button type="submit">登录</button>
            <a href="register.html">没有账号？去注册</a>
        </div>
    </form>

</body>
</html>
```

## 知识点回顾

- `<form>` 是表单容器
- `type="password"` 输入内容显示为圆点
- `name` 属性决定提交时的字段名，没有 name 数据提交不了 ⭐
- `<label for="xxx">` 和 `<input id="xxx">` 关联，点击文字也能聚焦输入框

## 验证

访问 `http://localhost:8081/week1-html/login.html`，确认：
- 页面显示"用户登录"标题
- 有用户名和密码输入框
- 密码框输入时显示圆点
- 点击"去注册"能跳转到 register.html

---

# Demo 4：注册页面

> ⬆ [上一章：Demo 3](#demo-3登录页面) | ⬇ [下一章：Demo 5](#demo-5用户表格) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：表单标签](前端知识点.md#3-表单标签重点)

📁 **文件位置：`my-project/src/main/resources/static/week1-html/register.html`**

## 练习目标

写出一个完整的注册页面，用到更多表单元素：input、radio、email。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
</head>
<body>
    <h1>用户注册</h1>

    <form action="/user/register" method="post">
        <div>
            <label for="username">用户名：</label>
            <input type="text" id="username" name="username" placeholder="请输入用户名" required>
        </div>

        <div>
            <label for="password">密码：</label>
            <input type="password" id="password" name="password" placeholder="请输入密码" required>
        </div>

        <div>
            <label for="confirmPassword">确认密码：</label>
            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="请再次输入密码" required>
        </div>

        <div>
            <label for="nickname">昵称：</label>
            <input type="text" id="nickname" name="nickname" placeholder="请输入昵称">
        </div>

        <div>
            <label for="email">邮箱：</label>
            <input type="email" id="email" name="email" placeholder="请输入邮箱">
        </div>

        <div>
            <label>性别：</label>
            <input type="radio" name="gender" value="male" id="male">
            <label for="male">男</label>
            <input type="radio" name="gender" value="female" id="female">
            <label for="female">女</label>
        </div>

        <div>
            <button type="submit">注册</button>
            <a href="login.html">已有账号？去登录</a>
        </div>
    </form>

</body>
</html>
```

## 知识点回顾

- `required` 属性让输入框变成必填
- `type="email"` 自带邮箱格式校验
- `type="radio"` 单选按钮，`name` 相同才能互斥 ⭐

## 验证

访问 `http://localhost:8081/week1-html/register.html`，确认：
- 所有表单元素都显示正确
- 不填用户名直接点"注册"，浏览器会提示必填
- 邮箱框输入"abc"会提示格式错误
- 单选按钮只能选一个

---

# Demo 5：用户表格

> ⬆ [上一章：Demo 4](#demo-4注册页面) | ⬇ [下一章：Demo 6](#demo-6css-选择器练习) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：表格标签](前端知识点.md#4-表格标签)

📁 **文件位置：`my-project/src/main/resources/static/week1-html/user-table.html`**

## 练习目标

用表格展示用户列表数据，练习 table、thead、tbody、tr、th、td 标签。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
</head>
<body>
    <h1>用户列表</h1>

    <table border="1" cellpadding="10" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>昵称</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>zhangsan</td>
                <td>张三</td>
                <td>zhangsan@example.com</td>
                <td>
                    <button>编辑</button>
                    <button>删除</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>lisi</td>
                <td>李四</td>
                <td>lisi@example.com</td>
                <td>
                    <button>编辑</button>
                    <button>删除</button>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>wangwu</td>
                <td>王五</td>
                <td>wangwu@example.com</td>
                <td>
                    <button>编辑</button>
                    <button>删除</button>
                </td>
            </tr>
        </tbody>
    </table>

</body>
</html>
```

## 知识点回顾

- `<table>` 表格容器
- `<thead>` 表头，`<tbody>` 表体
- `<th>` 表头单元格（加粗居中），`<td>` 普通单元格
- `border="1"` 给表格加边框（后续用 CSS 美化）

## 验证

访问 `http://localhost:8081/week1-html/user-table.html`，确认：
- 表格有 4 列（ID、用户名、邮箱、操作）
- 表头加粗居中
- 每行都有"编辑"和"删除"按钮

---

# Demo 6：CSS 选择器练习

> ⬆ [上一章：Demo 5](#demo-5用户表格) | ⬇ [下一章：Demo 7](#demo-7盒模型练习) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：选择器](前端知识点.md#7-选择器)

📁 **文件位置：`my-project/src/main/resources/static/week2-css/01-selector.html`**

## 练习目标

练习 class 选择器、id 选择器、后代选择器。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>选择器练习</title>
    <style>
        /* 元素选择器 */
        p {
            color: #666;
        }

        /* class 选择器 */
        .highlight {
            color: red;
            font-weight: bold;
        }

        /* id 选择器 */
        #main-title {
            color: #333;
            font-size: 24px;
        }

        /* 后代选择器 */
        .card p {
            color: blue;
        }
    </style>
</head>
<body>
    <h1 id="main-title">选择器练习</h1>

    <p>普通段落（元素选择器，灰色）</p>
    <p class="highlight">高亮段落（class 选择器，红色加粗）</p>

    <div class="card">
        <p>卡片里的段落（后代选择器，蓝色）</p>
    </div>
</body>
</html>
```

## 验证

访问 `http://localhost:8081/week2-css/01-selector.html`，确认：
- 标题是深灰色 24px
- 普通段落是灰色
- 高亮段落是红色加粗
- 卡片里的段落是蓝色

---

# Demo 7：盒模型练习

> ⬆ [上一章：Demo 6](#demo-6css-选择器练习) | ⬇ [下一章：Demo 8](#demo-flex-布局实战) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：盒模型](前端知识点.md#8-盒模型核心)

📁 **文件位置：`my-project/src/main/resources/static/week2-css/02-box-model.html`**

## 练习目标

理解 margin、padding、border 的区别，理解 box-sizing 的作用。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>盒模型练习</title>
    <style>
        * {
            box-sizing: border-box;  /* ⭐ 推荐！让 width 包含 padding 和 border */
        }

        .box {
            width: 200px;
            height: 100px;
            padding: 20px;           /* 内边距 */
            border: 2px solid #333;  /* 边框 */
            margin: 20px;            /* 外边距 */
            background-color: #f0f0f0;
        }

        .box-1 {
            margin-bottom: 40px;     /* 下方外边距更大 */
        }

        .box-2 {
            padding: 10px 30px;      /* 上下10px，左右30px */
        }
    </style>
</head>
<body>
    <h1>盒模型练习</h1>

    <div class="box box-1">
        Box 1：margin-bottom: 40px
    </div>
    <div class="box box-2">
        Box 2：padding: 10px 30px
    </div>
</body>
</html>
```

## 验证

访问 `http://localhost:8081/week2-css/02-box-model.html`，确认：
- 两个盒子之间有间距（margin）
- 盒子内部文字和边框之间有间距（padding）
- Box 1 和 Box 2 之间的间距比 Box 2 下方的间距更大

---

# Demo 8：Flex 布局实战

> ⬆ [上一章：Demo 7](#demo-7盒模型练习) | ⬇ [下一章：Demo 9](#demo-9定位练习) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：Flex 布局](前端知识点.md#9-flex-布局核心)
> 📖 阮一峰教程：[Flex 布局教程](https://ruanyifeng.com/blog/2015/07/flex-grammar.html)

📁 **文件位置：`my-project/src/main/resources/static/week2-css/03-flex.html`**

## 练习目标

掌握 Flex 布局的 6 个核心属性，做出水平居中、两端对齐等效果。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Flex 布局练习</title>
    <style>
        .demo {
            margin: 20px 0;
            padding: 10px;
            border: 1px solid #ccc;
        }

        .flex-container {
            display: flex;
            height: 80px;
            background-color: #f5f5f5;
        }

        .flex-item {
            width: 80px;
            height: 40px;
            background-color: #4CAF50;
            color: white;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 5px;
            border-radius: 4px;
        }

        /* 水平垂直居中 */
        .center {
            justify-content: center;
            align-items: center;
        }

        /* 两端对齐 */
        .space-between {
            justify-content: space-between;
            align-items: center;
        }

        /* 垂直排列 */
        .column {
            flex-direction: column;
            align-items: center;
        }
    </style>
</head>
<body>
    <h1>Flex 布局练习</h1>

    <h3>1. 默认排列（flex-start）</h3>
    <div class="demo flex-container">
        <div class="flex-item">1</div>
        <div class="flex-item">2</div>
        <div class="flex-item">3</div>
    </div>

    <h3>2. 水平垂直居中</h3>
    <div class="demo flex-container center">
        <div class="flex-item">居中</div>
    </div>

    <h3>3. 两端对齐（space-between）</h3>
    <div class="demo flex-container space-between">
        <div class="flex-item">左</div>
        <div class="flex-item">中</div>
        <div class="flex-item">右</div>
    </div>

    <h3>4. 垂直排列（column）</h3>
    <div class="demo flex-container column">
        <div class="flex-item">A</div>
        <div class="flex-item">B</div>
        <div class="flex-item">C</div>
    </div>
</body>
</html>
```

## 验证

访问 `http://localhost:8081/week2-css/03-flex.html`，确认：
- 默认排列：元素靠左排列
- 居中：元素在容器正中间
- 两端对齐：第一个元素靠左，最后一个靠右，中间均匀分布
- 垂直排列：元素从上到下排列

---

# Demo 9：定位练习

> ⬆ [上一章：Demo 8](#demo-flex-布局实战) | ⬇ [下一章：Demo 10](#demo-10js-基础语法练习) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：定位](前端知识点.md#10-定位)

📁 **文件位置：`my-project/src/main/resources/static/week2-css/04-position.html`**

## 练习目标

练习 relative、absolute、fixed 定位，做出右上角关闭按钮和固定导航栏。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>定位练习</title>
    <style>
        /* 固定导航栏 */
        .navbar {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 50px;
            background-color: #333;
            color: white;
            display: flex;
            align-items: center;
            padding: 0 20px;
            z-index: 999;
        }

        body {
            padding-top: 60px;  /* 给导航栏留空间 */
        }

        /* 弹窗示例 */
        .card {
            position: relative;  /* ⭐ 给子元素 absolute 定位做参考 */
            width: 300px;
            height: 150px;
            border: 1px solid #ccc;
            margin: 20px;
            padding: 10px;
        }

        .close-btn {
            position: absolute;  /* ⭐ 相对于 .card 定位 */
            top: 5px;
            right: 10px;
            cursor: pointer;
            background: red;
            color: white;
            border: none;
            width: 24px;
            height: 24px;
            border-radius: 50%;
        }
    </style>
</head>
<body>
    <div class="navbar">固定导航栏</div>

    <h1>定位练习</h1>

    <div class="card">
        <span>这是一个卡片</span>
        <button class="close-btn">X</button>
    </div>

    <p>滚动页面试试，导航栏会固定在顶部！</p>
</body>
</html>
```

## 验证

访问 `http://localhost:8081/week2-css/04-position.html`，确认：
- 导航栏固定在页面顶部，滚动时不消失
- 关闭按钮在卡片的右上角
- 按钮放在卡片上方时能看到红色圆形按钮

---

# Demo 10：JS 基础语法练习

> ⬆ [上一章：Demo 9](#demo-9定位练习) | ⬇ [下一章：Demo 11](#demo-11数组和对象练习) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：基础语法](前端知识点.md#11-基础语法)

📁 **文件位置：`my-project/src/main/resources/static/week3-js/01-basic.html`**

## 练习目标

练习变量、数据类型、条件判断、循环、函数。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>JS 基础语法练习</title>
</head>
<body>
    <h1>JS 基础语法练习</h1>
    <button onclick="testVariables()">测试变量</button>
    <button onclick="testCondition()">测试条件判断</button>
    <button onclick="testLoop()">测试循环</button>
    <button onclick="testFunction()">测试函数</button>
    <p id="output"></p>

    <script>
        // 变量
        const testVariables = () => {
            let name = '张三';
            const age = 18;
            let msg = `我叫${name}，今年${age}岁`;
            document.getElementById('output').textContent = msg;
        };

        // 条件判断
        const testCondition = () => {
            let score = 85;
            let result;
            if (score >= 90) {
                result = '优秀';
            } else if (score >= 60) {
                result = '及格';
            } else {
                result = '不及格';
            }
            document.getElementById('output').textContent = `分数${score}，评价：${result}`;
        };

        // 循环
        const testLoop = () => {
            let fruits = ['苹果', '香蕉', '橘子', '葡萄'];
            let msg = '';
            for (let fruit of fruits) {
                msg += fruit + '、';
            }
            document.getElementById('output').textContent = '水果：' + msg.slice(0, -1);
        };

        // 函数
        const testFunction = () => {
            const add = (a, b) => a + b;
            const result = add(10, 20);
            document.getElementById('output').textContent = `10 + 20 = ${result}`;
        };
    </script>
</body>
</html>
```

## 验证

访问 `http://localhost:8081/week3-js/01-basic.html`，点击每个按钮：
- "测试变量" → 显示"我叫张三，今年18岁"
- "测试条件判断" → 显示"分数85，评价：及格"
- "测试循环" → 显示水果列表
- "测试函数" → 显示"10 + 20 = 30"

---

# Demo 11：数组和对象练习

> ⬆ [上一章：Demo 10](#demo-10js-基础语法练习) | ⬇ [下一章：Demo 12](#demo-12es6-语法练习) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：数组和对象](前端知识点.md#12-数组和对象)

📁 **文件位置：`my-project/src/main/resources/static/week3-js/02-array-object.html`**

## 练习目标

练习数组的增删改查、遍历、映射、过滤。练习对象的创建、访问、修改。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>数组和对象练习</title>
</head>
<body>
    <h1>数组和对象练习</h1>
    <button onclick="testArray()">测试数组</button>
    <button onclick="testObject()">测试对象</button>
    <pre id="output"></pre>

    <script>
        const output = document.getElementById('output');

        const testArray = () => {
            let arr = [1, 2, 3, 4, 5];

            // push 末尾添加
            arr.push(6);

            // map 映射
            let doubled = arr.map(item => item * 2);

            // filter 过滤
            let big = arr.filter(item => item > 3);

            // forEach 遍历
            let msg = '';
            arr.forEach((item, index) => {
                msg += `[${index}] = ${item}\n`;
            });

            output.textContent =
                `原数组: ${arr}\n` +
                `翻倍: ${doubled}\n` +
                `大于3: ${big}\n` +
                `遍历:\n${msg}`;
        };

        const testObject = () => {
            let user = {
                name: '张三',
                age: 18,
                email: 'zhangsan@example.com'
            };

            // 访问
            let msg = `姓名: ${user.name}\n`;
            msg += `年龄: ${user.age}\n`;

            // 修改
            user.age = 20;
            msg += `修改后年龄: ${user.age}\n`;

            // 添加属性
            user.phone = '13800138000';
            msg += `电话: ${user.phone}\n`;

            // 解构
            let { name, email } = user;
            msg += `解构: name=${name}, email=${email}`;

            output.textContent = msg;
        };
    </script>
</body>
</html>
```

## 验证

访问 `http://localhost:8081/week3-js/02-array-object.html`，点击按钮：
- "测试数组" → 显示原数组、翻倍后、过滤后、遍历结果
- "测试对象" → 显示对象属性访问、修改、添加、解构结果

---

# Demo 12：ES6 语法练习

> ⬆ [上一章：Demo 11](#demo-11数组和对象练习) | ⬇ [下一章：Demo 13](#demo-13dom-操作实战) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：ES6 重点语法](前端知识点.md#13-es6-重点语法)
> 📖 阮一峰：[ES6 入门教程](https://es6.ruanyifeng.com/)

📁 **文件位置：`my-project/src/main/resources/static/week3-js/03-es6.html`**

## 练习目标

练习模板字符串、箭头函数、解构赋值、展开运算符。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>ES6 语法练习</title>
</head>
<body>
    <h1>ES6 语法练习</h1>
    <button onclick="testTemplate()">模板字符串</button>
    <button onclick="testArrow()">箭头函数</button>
    <button onclick="testDestructuring()">解构赋值</button>
    <button onclick="testSpread()">展开运算符</button>
    <pre id="output"></pre>

    <script>
        const output = document.getElementById('output');

        // 模板字符串
        const testTemplate = () => {
            let name = '张三';
            let age = 18;
            let msg = `我叫${name}，今年${age}岁，明年${age + 1}岁`;
            output.textContent = msg;
        };

        // 箭头函数
        const testArrow = () => {
            const double = x => x * 2;
            const add = (a, b) => a + b;
            output.textContent =
                `double(5) = ${double(5)}\n` +
                `add(3, 7) = ${add(3, 7)}`;
        };

        // 解构赋值
        const testDestructuring = () => {
            let user = { name: '李四', age: 25, email: 'lisi@example.com' };
            let { name, age, email } = user;
            output.textContent = `name: ${name}\nage: ${age}\nemail: ${email}`;
        };

        // 展开运算符
        const testSpread = () => {
            let arr1 = [1, 2, 3];
            let arr2 = [...arr1, 4, 5];
            let user = { name: '王五', age: 30 };
            let newUser = { ...user, id: 1 };
            output.textContent =
                `展开数组: [${arr2}]\n` +
                `展开对象: ${JSON.stringify(newUser)}`;
        };
    </script>
</body>
</html>
```

## 验证

访问 `http://localhost:8081/week3-js/03-es6.html`，点击每个按钮确认输出正确。

---

# Demo 13：DOM 操作实战

> ⬆ [上一章：Demo 12](#demo-12es6-语法练习) | ⬇ [下一章：Demo 14](#demo-14事件处理实战) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：DOM 操作](前端知识点.md#14-dom-操作核心)

📁 **文件位置：`my-project/src/main/resources/static/week3-js/04-dom.html`**

## 练习目标

练习获取元素、修改内容、创建元素、删除元素。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>DOM 操作练习</title>
</head>
<body>
    <h1 id="title">DOM 操作练习</h1>

    <button onclick="changeTitle()">修改标题</button>
    <button onclick="addItem()">添加列表项</button>
    <button onclick="clearList()">清空列表</button>

    <ul id="myList">
        <li>原始项目 1</li>
        <li>原始项目 2</li>
    </ul>

    <script>
        // 修改标题文字
        const changeTitle = () => {
            let title = document.querySelector('#title');
            title.textContent = '标题已被修改！';
            title.style.color = 'red';
        };

        // 动态添加列表项
        let count = 3;
        const addItem = () => {
            let ul = document.querySelector('#myList');
            let li = document.createElement('li');
            li.textContent = `动态添加的项目 ${count}`;
            ul.appendChild(li);
            count++;
        };

        // 清空列表
        const clearList = () => {
            let ul = document.querySelector('#myList');
            ul.innerHTML = '';
        };
    </script>
</body>
</html>
```

## 验证

访问 `http://localhost:8081/week3-js/04-dom.html`：
- 点击"修改标题" → 标题变成红色"标题已被修改！"
- 点击"添加列表项" → 列表末尾新增一项
- 点击"清空列表" → 列表内容全部消失

---

# Demo 14：事件处理实战

> ⬆ [上一章：Demo 13](#demo-13dom-操作实战) | ⬇ [下一章：Demo 15](#demo-15fetch-请求实战) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：事件机制](前端知识点.md#15-事件机制)

📁 **文件位置：`my-project/src/main/resources/static/week3-js/05-event.html`**

## 练习目标

练习 addEventListener、表单提交事件、e.preventDefault()。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>事件处理练习</title>
</head>
<body>
    <h1>事件处理练习</h1>

    <!-- 练习1：点击事件 -->
    <button id="myBtn">点击我</button>
    <p id="clickResult"></p>

    <!-- 练习2：表单提交（阻止默认行为） -->
    <h3>表单提交练习</h3>
    <form id="myForm">
        <input type="text" id="inputName" placeholder="输入你的名字">
        <button type="submit">提交</button>
    </form>
    <p id="formResult"></p>

    <script>
        // 练习1：addEventListener
        document.querySelector('#myBtn').addEventListener('click', () => {
            document.querySelector('#clickResult').textContent = '你点击了按钮！时间：' + new Date().toLocaleTimeString();
        });

        // 练习2：表单提交
        document.querySelector('#myForm').addEventListener('submit', (e) => {
            e.preventDefault();  // ⭐ 阻止表单默认提交（不加会刷新页面！）
            let name = document.querySelector('#inputName').value;
            document.querySelector('#formResult').textContent = `你输入了：${name}`;
        });
    </script>
</body>
</html>
```

## 验证

访问 `http://localhost:8081/week3-js/05-event.html`：
- 点击按钮 → 显示点击时间和提示文字
- 输入名字点提交 → 页面不刷新，显示"你输入了：xxx"
- ⭐ 如果去掉 `e.preventDefault()`，页面会刷新，输入的内容就没了

---

# Demo 15：fetch 请求实战

> ⬆ [上一章：Demo 14](#demo-14事件处理实战) | ⬇ [下一章：Demo 16](#demo-16完整联调实战) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：fetch 发送请求](前端知识点.md#17-fetch-发送请求核心)
> 📖 [点击跳转到 SpringBoot 知识点：前端调用接口](SpringBoot知识点.md#9-前端调用接口)

📁 **文件位置：`my-project/src/main/resources/static/week3-js/06-fetch.html`**

> ⚠️ 前提：需要先启动 my-project 后端项目！

## 练习目标

练习 fetch 的 GET 和 POST 请求，连通后端 API。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>fetch 请求练习</title>
</head>
<body>
    <h1>fetch 请求练习</h1>

    <button onclick="loadUsers()">GET - 加载用户列表</button>
    <button onclick="addUser()">POST - 添加用户</button>
    <pre id="output"></pre>

    <script>
        const output = document.getElementById('output');

        // GET 请求
        const loadUsers = async () => {
            try {
                const response = await fetch('/user/list');
                const result = await response.json();
                output.textContent = JSON.stringify(result, null, 2);
            } catch (err) {
                output.textContent = '请求失败：' + err.message;
            }
        };

        // POST 请求
        const addUser = async () => {
            try {
                const response = await fetch('/user/register', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'  // ⭐ 必须设置！
                    },
                    body: JSON.stringify({                   // ⭐ 必须转 JSON 字符串！
                        username: 'fetchuser',
                        password: '123456',
                        nickname: 'fetch添加的用户',
                        email: 'fetch@example.com'
                    })
                });
                const result = await response.json();
                output.textContent = JSON.stringify(result, null, 2);
                loadUsers();  // 添加后刷新列表
            } catch (err) {
                output.textContent = '请求失败：' + err.message;
            }
        };
    </script>
</body>
</html>
```

## 验证

1. 启动 my-project 后端项目
2. 访问 `http://localhost:8081/week3-js/06-fetch.html`
3. 点击"加载用户列表" → 页面显示 JSON 格式的用户数据
4. 点击"添加用户" → 显示注册成功，列表自动刷新

## ⭐ 注意事项

- `Content-Type: application/json` 必须设置，否则后端收不到数据
- `body` 必须用 `JSON.stringify()` 转成字符串
- `await` 只能在 `async` 函数里用
- fetch 的第一个参数是 URL，第二个参数是配置对象

---

# Demo 16：完整联调实战

> ⬆ [上一章：Demo 15](#demo-15fetch-请求实战) | ⬇ [下一章：Demo 17](#demo-17综合实战用户管理系统前端) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：联调流程](前端知识点.md#19-联调流程)
> 📖 [点击跳转到 SpringBoot 知识点：前端调用接口](SpringBoot知识点.md#9-前端调用接口)

📁 **文件位置：`my-project/src/main/resources/static/week4-final/01-integration.html`**

> ⚠️ 前提：需要先启动 my-project 后端项目！

## 练习目标

完成一个完整的前后端联调：前端页面 → fetch → Spring Boot → MySQL → 返回 JSON → 渲染页面。

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>前后端联调实战</title>
</head>
<body>
    <h1>用户管理系统（联调版）</h1>

    <button onclick="loadUsers()">加载用户列表</button>
    <button onclick="addUser()">添加用户</button>

    <table border="1" cellpadding="10" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>昵称</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody id="userTableBody">
            <!-- JS 动态填充 -->
        </tbody>
    </table>

    <script>
        // 加载用户列表
        const loadUsers = async () => {
            try {
                const response = await fetch('/user/list');
                const result = await response.json();

                if (result.code === 200) {
                    renderTable(result.data);
                } else {
                    alert('加载失败：' + result.msg);
                }
            } catch (err) {
                console.error('请求失败：', err);
            }
        };

        // 渲染表格
        const renderTable = (users) => {
            const tbody = document.querySelector('#userTableBody');
            tbody.innerHTML = '';

            users.forEach(user => {
                const tr = document.createElement('tr');
                tr.innerHTML = `
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.nickname}</td>
                    <td>${user.email}</td>
                    <td>
                        <button onclick="deleteUser(${user.id})">删除</button>
                    </td>
                `;
                tbody.appendChild(tr);
            });
        };

        // 添加用户
        const addUser = async () => {
            try {
                const response = await fetch('/user/register', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({
                        username: 'newuser_' + Date.now(),
                        password: '123456',
                        nickname: '新用户',
                        email: 'new@example.com'
                    })
                });
                const result = await response.json();
                if (result.code === 200) {
                    loadUsers();  // 刷新列表
                } else {
                    alert(result.msg);
                }
            } catch (err) {
                console.error('请求失败：', err);
            }
        };

        // 删除用户
        const deleteUser = async (id) => {
            if (!confirm('确定要删除吗？')) return;
            try {
                const response = await fetch(`/user/${id}`, {
                    method: 'DELETE'
                });
                const result = await response.json();
                if (result.code === 200) {
                    loadUsers();  // 刷新列表
                } else {
                    alert(result.msg);
                }
            } catch (err) {
                console.error('请求失败：', err);
            }
        };
    </script>
</body>
</html>
```

## 验证

1. 启动 my-project 后端项目
2. 访问 `http://localhost:8081/week4-final/01-integration.html`
3. 点击"加载用户列表" → 表格显示数据库中的用户
4. 点击"添加用户" → 表格自动刷新，新增一行
5. 点击"删除" → 弹出确认框，确认后删除并刷新

---

# Demo 17：综合实战——用户管理系统前端

> ⬆ [上一章：Demo 16](#demo-16完整联调实战) | [返回目录](#目录)
> 📖 [点击跳转到对应知识点：综合实战](前端知识点.md#-综合实战用户管理系统前端)

📁 **文件位置：`my-project/src/main/resources/static/week4-final/user-manager.html`**

> 这是最终目标！独立完成一个包含登录、注册、用户管理的完整前端页面。
>
> 建议：先自己尝试写，写不出来再参考提示。

## 功能清单

| 功能 | 用到的技术 | 对应的后端接口 |
|------|-----------|---------------|
| 用户列表 | HTML 表格 + fetch GET | `GET /user/list` |
| 添加用户 | HTML 表单 + fetch POST | `POST /user/register` |
| 删除用户 | JS 事件 + fetch DELETE | `DELETE /user/{id}` |
| 修改用户 | DOM 操作 + fetch PUT | `PUT /user` |

## 提示：页面结构

```html
<!-- 你需要自己写的部分 -->
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>用户管理系统</title>
    <style>
        /* 自己写 CSS：Flex 布局 + 盒模型 */
    </style>
</head>
<body>
    <!-- 1. 页面标题 -->
    <!-- 2. 添加用户的表单 -->
    <!-- 3. 用户列表表格 -->
    <!-- 4. JS 代码（fetch + DOM 操作） -->
</body>
</html>
```

## 提示：需要用到的知识点

1. **HTML**：form、input、table、button
2. **CSS**：Flex 居中、盒模型间距、美化按钮和表格
3. **JS**：addEventListener、fetch、async/await、DOM 操作
4. **联调**：Content-Type、JSON.stringify、response.json()

---

# 练习题

## 练习 1：美化登录页面（CSS 阶段）

用 Flex 布局把登录框居中，加上背景色、圆角、阴影。

**提示：**
```css
body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f5f5f5;
}
.login-box {
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    background: white;
}
```

## 练习 2：动态表格（JS 阶段）

不用后端接口，用 JS 数组模拟数据，动态渲染表格。

**提示：**
```javascript
let users = [
    { id: 1, name: '张三', age: 20 },
    { id: 2, name: '李四', age: 25 }
];

// 用 forEach 遍历 users，用 createElement 创建 tr/td
```

## 练习 3：搜索功能（联调阶段）

给用户列表加一个搜索框，输入名字后点"搜索"，调用后端接口查询。

**提示：**
```javascript
// 后端接口：GET /user/search?name=xxx
const searchUsers = async (name) => {
    const response = await fetch(`/user/search?name=${name}`);
    const result = await response.json();
    // 渲染结果...
};
```

---

# 踩坑记录

> 学习过程中遇到的问题记录在这里，方便以后查阅。

| 问题 | 原因 | 解决方案 |
|------|------|----------|
| fetch 请求后端收不到数据 | 忘记设置 `Content-Type: application/json` | headers 里加 `'Content-Type': 'application/json' |
| 表单提交后页面刷新了 | 没有 `e.preventDefault()` | 在 submit 事件里加 `e.preventDefault()` |
| JS 报错 `xxx is not defined` | 函数写在 `<script>` 外面，或者变量名拼错 | 检查函数定义位置和变量名 |
| CSS 样式不生效 | 选择器优先级不够，或者选择器写错 | 用浏览器 F12 检查元素，看哪些样式被覆盖了 |
| 后端返回 404 | URL 路径写错 | 检查 Controller 的 @RequestMapping 路径 |
| 后端返回 415 | Content-Type 不对 | 检查请求头是否设置了 `application/json` |
| （待补充） | | |
