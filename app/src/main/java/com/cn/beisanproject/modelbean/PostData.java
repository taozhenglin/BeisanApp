package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class PostData implements Serializable {
    int id;
    String data;
     List<StockingLineListBean.ResultBean.ResultlistBean> list;
     List<String> stringList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    private String nextStatus;

    int count;

    public int getId() {
        return id;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNextStatus() {
        return nextStatus;
    }

    public void setNextStatus(String nextStatus) {
        this.nextStatus = nextStatus;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    String tag;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



    public List<StockingLineListBean.ResultBean.ResultlistBean> getList() {
        return list;
    }

    public void setList(List<StockingLineListBean.ResultBean.ResultlistBean> list) {
        this.list = list;
    }

//    public List<String> getList() {
//        return stringList;
//    }
//
//    public void setList(List<String> list) {
//        this.stringList = list;
//    }

}
