package com.bjtu.commons.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果
 *
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {
    /**
     错误码（0表示成功）
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    private Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS.value, null, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.value, null, data);
    }

    public static <T> Result<T> error(ResultCode code) {
        return new Result<>(code.value, code.defaultMsg, null);
    }

    public static <T> Result<T> error(ResultCode code, String msg) {
        return new Result<>(code.value, msg, null);
    }
}
