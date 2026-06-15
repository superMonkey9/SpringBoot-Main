package com.example.Ademo.entity;


public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result() {}

    // 成功（带数据）
    public static <T>Result<T> success(T data) {
        Result<T> r = new Result<T>();
        r.setCode(200);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    // 成功（不带数据）
    public static Result sucess(){
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


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
