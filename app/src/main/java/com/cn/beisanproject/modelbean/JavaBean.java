package com.cn.beisanproject.modelbean;

public class JavaBean {

    /**
     * msg : 固定资产卡片已存在
     * number : 030199-000001
     * success : false
     */

    private String msg;
    private String number;
    private boolean success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
