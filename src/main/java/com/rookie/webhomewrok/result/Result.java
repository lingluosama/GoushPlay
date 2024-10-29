package com.rookie.webhomewrok.result;

public class Result<T> {
    private Boolean success;
    private T data;

    // Constructor to initialize Result
    public Result(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, data);
    }

    public static <T> Result<T> failure() {
        return new Result<>(false, null);
    }
}
