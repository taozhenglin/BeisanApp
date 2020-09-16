package com.cn.beisanproject.modelbean;

/**
 * 查询结果
 */
public class QueryResultBean<T> {

    private String code;
    private String message;
    private QueryResultDataBean<T> data;

    public QueryResultDataBean<T> getData() {
        return data;
    }

    public void setData(QueryResultDataBean<T> data) {
        this.data = data;
    }

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
}
