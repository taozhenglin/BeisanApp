package com.cn.beisanproject.modelbean;

import java.util.ArrayList;

/**
 * 数据
 */
public class QueryResultDataBean<T> {
    private ArrayList<T> rows;
    private String total;


    public ArrayList<T> getRows() {
        return rows;
    }

    public void setRows(ArrayList<T> rows) {
        this.rows = rows;
    }


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
//
//    public  LoginBean loginBean;
//
//    public LoginBean getLoginBean() {
//        return loginBean;
//    }
//
//    public void setLoginBean(LoginBean loginBean) {
//        this.loginBean = loginBean;
//    }
}
