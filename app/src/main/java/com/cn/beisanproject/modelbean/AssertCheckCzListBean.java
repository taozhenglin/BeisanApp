package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tzl
 * on 2020/11/2
 */
public class AssertCheckCzListBean {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"DESCRIPTION":"测试20200918","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-18 13:59:08","FIXEASSETRETNUM":"1011","MANAGEMENT":"公司","REASON":"cs","STATUS":"完成","STATUSDATE":"2020-09-18 14:04:49"},{"DESCRIPTION":"测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-18 13:40:37","FIXEASSETRETNUM":"1009","MANAGEMENT":"公司","REASON":"测试","STATUS":"\n等待核准","STATUSDATE":"2020-09-18 13:48:34"},{"DESCRIPTION":"测试20200918","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-18 10:03:31","FIXEASSETRETNUM":"1008","MANAGEMENT":"公司","REASON":"测试20200918","STATUS":"完成","STATUSDATE":"2020-09-18 11:01:05"},{"DESCRIPTION":"cs","ENTERBY":"CHENYN","ENTERBYDESC":"陈勇宁","ENTERDATE":"2020-09-17 14:13:29","FIXEASSETRETNUM":"1005","MANAGEMENT":"安全卫环部","REASON":"cs","STATUS":"完成","STATUSDATE":"2020-09-17 15:07:37"},{"DESCRIPTION":"测试20200903","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-03 08:15:35","FIXEASSETRETNUM":"1003","MANAGEMENT":"信息中心","REASON":"测试","STATUS":"完成","STATUSDATE":"2020-09-17 14:10:16"}],"showcount":20,"totalpage":1,"totalresult":5}
     */

    private String errcode;
    private String errmsg;
    private Object personid;
    private ResultBean result;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getPersonid() {
        return personid;
    }

    public void setPersonid(Object personid) {
        this.personid = personid;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * curpage : 1
         * resultlist : [{"DESCRIPTION":"测试20200918","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-18 13:59:08","FIXEASSETRETNUM":"1011","MANAGEMENT":"公司","REASON":"cs","STATUS":"完成","STATUSDATE":"2020-09-18 14:04:49"},{"DESCRIPTION":"测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-18 13:40:37","FIXEASSETRETNUM":"1009","MANAGEMENT":"公司","REASON":"测试","STATUS":"\n等待核准","STATUSDATE":"2020-09-18 13:48:34"},{"DESCRIPTION":"测试20200918","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-18 10:03:31","FIXEASSETRETNUM":"1008","MANAGEMENT":"公司","REASON":"测试20200918","STATUS":"完成","STATUSDATE":"2020-09-18 11:01:05"},{"DESCRIPTION":"cs","ENTERBY":"CHENYN","ENTERBYDESC":"陈勇宁","ENTERDATE":"2020-09-17 14:13:29","FIXEASSETRETNUM":"1005","MANAGEMENT":"安全卫环部","REASON":"cs","STATUS":"完成","STATUSDATE":"2020-09-17 15:07:37"},{"DESCRIPTION":"测试20200903","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-03 08:15:35","FIXEASSETRETNUM":"1003","MANAGEMENT":"信息中心","REASON":"测试","STATUS":"完成","STATUSDATE":"2020-09-17 14:10:16"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 5
         */

        private int curpage;
        private int showcount;
        private int totalpage;
        private int totalresult;
        private List<ResultlistBean> resultlist;

        public int getCurpage() {
            return curpage;
        }

        public void setCurpage(int curpage) {
            this.curpage = curpage;
        }

        public int getShowcount() {
            return showcount;
        }

        public void setShowcount(int showcount) {
            this.showcount = showcount;
        }

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public int getTotalresult() {
            return totalresult;
        }

        public void setTotalresult(int totalresult) {
            this.totalresult = totalresult;
        }

        public List<ResultlistBean> getResultlist() {
            return resultlist;
        }

        public void setResultlist(List<ResultlistBean> resultlist) {
            this.resultlist = resultlist;
        }

        public static class ResultlistBean implements Serializable{
            /**
             * DESCRIPTION : 测试20200918
             * ENTERBY : MAXADMIN
             * ENTERBYDESC : 系统管理员
             * ENTERDATE : 2020-09-18 13:59:08
             * FIXEASSETRETNUM : 1011
             * MANAGEMENT : 公司
             * REASON : cs
             * STATUS : 完成
             * STATUSDATE : 2020-09-18 14:04:49
             */

            private String DESCRIPTION;
            private String ENTERBY;
            private String ENTERBYDESC;
            private String ENTERDATE;
            private String FIXEASSETRETNUM;
            private String MANAGEMENT;
            private String REASON;
            private String STATUS;
            private String STATUSDATE;

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getENTERBY() {
                return ENTERBY;
            }

            public void setENTERBY(String ENTERBY) {
                this.ENTERBY = ENTERBY;
            }

            public String getENTERBYDESC() {
                return ENTERBYDESC;
            }

            public void setENTERBYDESC(String ENTERBYDESC) {
                this.ENTERBYDESC = ENTERBYDESC;
            }

            public String getENTERDATE() {
                return ENTERDATE;
            }

            public void setENTERDATE(String ENTERDATE) {
                this.ENTERDATE = ENTERDATE;
            }

            public String getFIXEASSETRETNUM() {
                return FIXEASSETRETNUM;
            }

            public void setFIXEASSETRETNUM(String FIXEASSETRETNUM) {
                this.FIXEASSETRETNUM = FIXEASSETRETNUM;
            }

            public String getMANAGEMENT() {
                return MANAGEMENT;
            }

            public void setMANAGEMENT(String MANAGEMENT) {
                this.MANAGEMENT = MANAGEMENT;
            }

            public String getREASON() {
                return REASON;
            }

            public void setREASON(String REASON) {
                this.REASON = REASON;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getSTATUSDATE() {
                return STATUSDATE;
            }

            public void setSTATUSDATE(String STATUSDATE) {
                this.STATUSDATE = STATUSDATE;
            }
        }
    }
}
