package com.rookie.webhomewrok.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResult<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public static <T> BaseResult<T> success() {
        return new BaseResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), null);
    }

    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    public static <T> BaseResult<T> fail() {
        return new BaseResult<>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMsg(), null);
    }

    public static <T> BaseResult<T> fail(T data) {
        return new BaseResult<>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMsg(), data);
    }

    public static <T> BaseResult<T> fail(String msg) {
        return new BaseResult<>(ResultCode.FAIL.getCode(), msg, null);
    }

    public static <T> BaseResult<T> of(ResultCode resultCode, T data) {
        return new BaseResult<>(resultCode.getCode(), resultCode.getMsg(), data);
    }

    public static <T> BaseResult<T> of(ResultCode resultCode) {
        return new BaseResult<>(resultCode.getCode(), resultCode.getMsg(), null);
    }

    public Boolean ok() {
        return code == ResultCode.SUCCESS.getCode();
    }

}



