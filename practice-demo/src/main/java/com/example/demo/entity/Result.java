package com.example.demo.entity;

// ⭐ 统一返回封装类：所有接口都用这个格式返回
public class Result<T> {
    // 三个属性（固定写法）
    private Integer code;    // 状态码：200成功，500失败
    private String msg;      // 提示信息
    private T data;          // 返回数据

    // 成功（带数据）
    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    // 成功（不带数据）
    public static Result<Void> success() {
        return success(null);
    }

    // 失败
    @SuppressWarnings("unchecked")
    public static <T> Result<T> error(String msg) {
        Result<T> r = new Result<>();
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
