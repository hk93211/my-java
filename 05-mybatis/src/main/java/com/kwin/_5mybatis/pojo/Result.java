package com.kwin._5mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private Object data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result result = new Result();
        result.data = null;
        result.code = 0;
        result.msg = msg;
        return result;
    }

    public static <T> Result<T> unauthorized() {
        Result<T> result = new Result<T>();
        result.data = null;
        result.code = 0;
        result.msg = "未授权";
        return result;
    }
}
