package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tzl
 * on 2020/11/2
 */
public class AssertCheckJsListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"信息中心","DESCRIPTION":"测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-18 11:41:18","FIXEDASSETJSNUM":"1047","PRDESC":"","PRNUM":"","TYPE":"转固","status":"已批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"信息中心","DESCRIPTION":"测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-17 10:14:12","FIXEDASSETJSNUM":"1041","PRDESC":"","PRNUM":"","TYPE":"转固","status":"待总经理审核"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"工程技术部","DESCRIPTION":"测试","ENTERBY":"YANGY","ENTERBYDESC":"杨云","ENTERDATE":"2020-09-10 13:55:42","FIXEDASSETJSNUM":"1039","PRDESC":"","PRNUM":"","TYPE":"转固","status":"已批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"工程技术部","DESCRIPTION":"22","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-06 19:01:52","FIXEDASSETJSNUM":"1038","PRDESC":"","PRNUM":"","TYPE":"转固","status":"等待批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"工程技术部","DESCRIPTION":"11","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-04 09:20:13","FIXEDASSETJSNUM":"1037","PRDESC":"","PRNUM":"","TYPE":"转固","status":"计划财务部主管审批"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"信息中心","DESCRIPTION":"增值测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-03 10:34:31","FIXEDASSETJSNUM":"1034","PRDESC":"","PRNUM":"","TYPE":"增值","status":"已批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"安全卫环部","DESCRIPTION":"测试1","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-02 20:14:51","FIXEDASSETJSNUM":"1033","PRDESC":"","PRNUM":"","TYPE":"转固","status":"已批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"信息中心","DESCRIPTION":"cs20200902","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-02 14:15:14","FIXEDASSETJSNUM":"1030","PRDESC":"","PRNUM":"","TYPE":"增值","status":"已批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"信息中心","DESCRIPTION":"测试20200901","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-01 20:53:11","FIXEDASSETJSNUM":"1028","PRDESC":"","PRNUM":"","TYPE":"转固","status":"已批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"信息中心","DESCRIPTION":"测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-08-27 21:56:05","FIXEDASSETJSNUM":"1026","PRDESC":"","PRNUM":"","TYPE":"转固","status":"待总经理审核"}],"showcount":20,"totalpage":1,"totalresult":10}
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
         * resultlist : [{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"信息中心","DESCRIPTION":"测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-18 11:41:18","FIXEDASSETJSNUM":"1047","PRDESC":"","PRNUM":"","TYPE":"转固","status":"已批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"信息中心","DESCRIPTION":"测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-17 10:14:12","FIXEDASSETJSNUM":"1041","PRDESC":"","PRNUM":"","TYPE":"转固","status":"待总经理审核"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"工程技术部","DESCRIPTION":"测试","ENTERBY":"YANGY","ENTERBYDESC":"杨云","ENTERDATE":"2020-09-10 13:55:42","FIXEDASSETJSNUM":"1039","PRDESC":"","PRNUM":"","TYPE":"转固","status":"已批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"工程技术部","DESCRIPTION":"22","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-06 19:01:52","FIXEDASSETJSNUM":"1038","PRDESC":"","PRNUM":"","TYPE":"转固","status":"等待批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"工程技术部","DESCRIPTION":"11","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-04 09:20:13","FIXEDASSETJSNUM":"1037","PRDESC":"","PRNUM":"","TYPE":"转固","status":"计划财务部主管审批"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"信息中心","DESCRIPTION":"增值测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-03 10:34:31","FIXEDASSETJSNUM":"1034","PRDESC":"","PRNUM":"","TYPE":"增值","status":"已批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"安全卫环部","DESCRIPTION":"测试1","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-02 20:14:51","FIXEDASSETJSNUM":"1033","PRDESC":"","PRNUM":"","TYPE":"转固","status":"已批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"信息中心","DESCRIPTION":"cs20200902","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-02 14:15:14","FIXEDASSETJSNUM":"1030","PRDESC":"","PRNUM":"","TYPE":"增值","status":"已批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"信息中心","DESCRIPTION":"测试20200901","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-09-01 20:53:11","FIXEDASSETJSNUM":"1028","PRDESC":"","PRNUM":"","TYPE":"转固","status":"已批准"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","DEPT":"信息中心","DESCRIPTION":"测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-08-27 21:56:05","FIXEDASSETJSNUM":"1026","PRDESC":"","PRNUM":"","TYPE":"转固","status":"待总经理审核"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 10
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

        public static class ResultlistBean implements Serializable {
            /**
             * A_BUDGETDESC :
             * A_BUDGETNUM :
             * DEPT : 信息中心
             * DESCRIPTION : 测试
             * ENTERBY : MAXADMIN
             * ENTERBYDESC : 系统管理员
             * ENTERDATE : 2020-09-18 11:41:18
             * FIXEDASSETJSNUM : 1047
             * PRDESC :
             * PRNUM :
             * TYPE : 转固
             * status : 已批准
             */

            private String A_BUDGETDESC;
            private String A_BUDGETNUM;
            private String DEPT;
            private String DESCRIPTION;
            private String ENTERBY;
            private String ENTERBYDESC;
            private String ENTERDATE;
            private String FIXEDASSETJSNUM;
            private String PRDESC;
            private String PRNUM;
            private String TYPE;
            private String STATUS;

            public String getFIXEDASSETJSID() {
                return FIXEDASSETJSID;
            }

            public void setFIXEDASSETJSID(String FIXEDASSETJSID) {
                this.FIXEDASSETJSID = FIXEDASSETJSID;
            }

            String FIXEDASSETJSID;


            public String getUDCOMPANYDESC() {
                return UDCOMPANYDESC;
            }

            public void setUDCOMPANYDESC(String UDCOMPANYDESC) {
                this.UDCOMPANYDESC = UDCOMPANYDESC;
            }

            String UDCOMPANYDESC;

            public String getA_BUDGETDESC() {
                return A_BUDGETDESC;
            }

            public void setA_BUDGETDESC(String A_BUDGETDESC) {
                this.A_BUDGETDESC = A_BUDGETDESC;
            }

            public String getA_BUDGETNUM() {
                return A_BUDGETNUM;
            }

            public void setA_BUDGETNUM(String A_BUDGETNUM) {
                this.A_BUDGETNUM = A_BUDGETNUM;
            }

            public String getDEPT() {
                return DEPT;
            }

            public void setDEPT(String DEPT) {
                this.DEPT = DEPT;
            }

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

            public String getFIXEDASSETJSNUM() {
                return FIXEDASSETJSNUM;
            }

            public void setFIXEDASSETJSNUM(String FIXEDASSETJSNUM) {
                this.FIXEDASSETJSNUM = FIXEDASSETJSNUM;
            }

            public String getPRDESC() {
                return PRDESC;
            }

            public void setPRDESC(String PRDESC) {
                this.PRDESC = PRDESC;
            }

            public String getPRNUM() {
                return PRNUM;
            }

            public void setPRNUM(String PRNUM) {
                this.PRNUM = PRNUM;
            }

            public String getTYPE() {
                return TYPE;
            }

            public void setTYPE(String TYPE) {
                this.TYPE = TYPE;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }
        }
    }
}
