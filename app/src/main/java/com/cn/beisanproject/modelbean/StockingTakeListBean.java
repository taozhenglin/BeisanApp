package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class StockingTakeListBean implements Serializable {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_1CLASS":"CL","A_1CLASSDESC":"材料","A_2CLASS":"CLRHY","A_2CLASSDESC":"润滑油","A_3CLASS":"","A_3CLASSDESC":"","CREATEBY":"MAXADMIN","CREATEDATE":"2020-06-04 17:31:48","CREATENAME":"系统管理员","DESCRIPTION":"06盘点","LOCATION":"CFS","LOCATIONDESC":"CFS","PDDATE":"2020-06-04","STOCKNUM":"1005"},{"A_1CLASS":"CL","A_1CLASSDESC":"材料","A_2CLASS":"CLDGJ","A_2CLASSDESC":"堆高机","A_3CLASS":"","A_3CLASSDESC":"","CREATEBY":"MAXADMIN","CREATEDATE":"2020-03-18 12:10:08","CREATENAME":"系统管理员","DESCRIPTION":"测试盘点","LOCATION":"BSJS","LOCATIONDESC":"北三集司","PDDATE":"2020-03-18","STOCKNUM":"1002"},{"A_1CLASS":"CL","A_1CLASSDESC":"材料","A_2CLASS":"CLCC","A_2CLASSDESC":"叉车","A_3CLASS":"","A_3CLASSDESC":"","CREATEBY":"MAXADMIN","CREATEDATE":"2020-03-18 10:39:17","CREATENAME":"系统管理员","DESCRIPTION":"测试盘点","LOCATION":"BSJS","LOCATIONDESC":"北三集司","PDDATE":"2020-03-18","STOCKNUM":"1001"}],"showcount":20,"totalpage":1,"totalresult":3}
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

    public static class ResultBean implements Serializable{
        /**
         * curpage : 1
         * resultlist : [{"A_1CLASS":"CL","A_1CLASSDESC":"材料","A_2CLASS":"CLRHY","A_2CLASSDESC":"润滑油","A_3CLASS":"","A_3CLASSDESC":"","CREATEBY":"MAXADMIN","CREATEDATE":"2020-06-04 17:31:48","CREATENAME":"系统管理员","DESCRIPTION":"06盘点","LOCATION":"CFS","LOCATIONDESC":"CFS","PDDATE":"2020-06-04","STOCKNUM":"1005"},{"A_1CLASS":"CL","A_1CLASSDESC":"材料","A_2CLASS":"CLDGJ","A_2CLASSDESC":"堆高机","A_3CLASS":"","A_3CLASSDESC":"","CREATEBY":"MAXADMIN","CREATEDATE":"2020-03-18 12:10:08","CREATENAME":"系统管理员","DESCRIPTION":"测试盘点","LOCATION":"BSJS","LOCATIONDESC":"北三集司","PDDATE":"2020-03-18","STOCKNUM":"1002"},{"A_1CLASS":"CL","A_1CLASSDESC":"材料","A_2CLASS":"CLCC","A_2CLASSDESC":"叉车","A_3CLASS":"","A_3CLASSDESC":"","CREATEBY":"MAXADMIN","CREATEDATE":"2020-03-18 10:39:17","CREATENAME":"系统管理员","DESCRIPTION":"测试盘点","LOCATION":"BSJS","LOCATIONDESC":"北三集司","PDDATE":"2020-03-18","STOCKNUM":"1001"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 3
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
             * A_1CLASS : CL
             * A_1CLASSDESC : 材料
             * A_2CLASS : CLRHY
             * A_2CLASSDESC : 润滑油
             * A_3CLASS :
             * A_3CLASSDESC :
             * CREATEBY : MAXADMIN
             * CREATEDATE : 2020-06-04 17:31:48
             * CREATENAME : 系统管理员
             * DESCRIPTION : 06盘点
             * LOCATION : CFS
             * LOCATIONDESC : CFS
             * PDDATE : 2020-06-04
             * STOCKNUM : 1005
             */

            private String A_1CLASS;
            private String A_1CLASSDESC;
            private String A_2CLASS;
            private String A_2CLASSDESC;
            private String A_3CLASS;
            private String A_3CLASSDESC;
            private String CREATEBY;
            private String CREATEDATE;
            private String CREATENAME;
            private String DESCRIPTION;
            private String LOCATION;
            private String LOCATIONDESC;
            private String PDDATE;
            private String STOCKNUM;

//            public String getHaschecked() {
//                return haschenked;
//            }
//
//            public void setHaschecked(String haschenked) {
//                this.haschenked = haschenked;
//            }
//
//            private String haschenked;

            public String getA_1CLASS() {
                return A_1CLASS;
            }

            public void setA_1CLASS(String A_1CLASS) {
                this.A_1CLASS = A_1CLASS;
            }

            public String getA_1CLASSDESC() {
                return A_1CLASSDESC;
            }

            public void setA_1CLASSDESC(String A_1CLASSDESC) {
                this.A_1CLASSDESC = A_1CLASSDESC;
            }

            public String getA_2CLASS() {
                return A_2CLASS;
            }

            public void setA_2CLASS(String A_2CLASS) {
                this.A_2CLASS = A_2CLASS;
            }

            public String getA_2CLASSDESC() {
                return A_2CLASSDESC;
            }

            public void setA_2CLASSDESC(String A_2CLASSDESC) {
                this.A_2CLASSDESC = A_2CLASSDESC;
            }

            public String getA_3CLASS() {
                return A_3CLASS;
            }

            public void setA_3CLASS(String A_3CLASS) {
                this.A_3CLASS = A_3CLASS;
            }

            public String getA_3CLASSDESC() {
                return A_3CLASSDESC;
            }

            public void setA_3CLASSDESC(String A_3CLASSDESC) {
                this.A_3CLASSDESC = A_3CLASSDESC;
            }

            public String getCREATEBY() {
                return CREATEBY;
            }

            public void setCREATEBY(String CREATEBY) {
                this.CREATEBY = CREATEBY;
            }

            public String getCREATEDATE() {
                return CREATEDATE;
            }

            public void setCREATEDATE(String CREATEDATE) {
                this.CREATEDATE = CREATEDATE;
            }

            public String getCREATENAME() {
                return CREATENAME;
            }

            public void setCREATENAME(String CREATENAME) {
                this.CREATENAME = CREATENAME;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getLOCATION() {
                return LOCATION;
            }

            public void setLOCATION(String LOCATION) {
                this.LOCATION = LOCATION;
            }

            public String getLOCATIONDESC() {
                return LOCATIONDESC;
            }

            public void setLOCATIONDESC(String LOCATIONDESC) {
                this.LOCATIONDESC = LOCATIONDESC;
            }

            public String getPDDATE() {
                return PDDATE;
            }

            public void setPDDATE(String PDDATE) {
                this.PDDATE = PDDATE;
            }

            public String getSTOCKNUM() {
                return STOCKNUM;
            }

            public void setSTOCKNUM(String STOCKNUM) {
                this.STOCKNUM = STOCKNUM;
            }
        }
    }
}
