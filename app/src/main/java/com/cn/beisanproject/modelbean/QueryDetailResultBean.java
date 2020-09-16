package com.cn.beisanproject.modelbean;

/**
 * 查询详情的数据
 * @param <T>
 */
public class QueryDetailResultBean<T> {
    private  String code;
    private T data;
    private  String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
