package com.cn.beisanproject.modelbean;

import java.util.List;

public class PurchaseListDetailBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"DESCRIPTION":"","ORDERDATE":"2020-07-16 10:17:43","POID":31021,"PONUM":"31928","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"保管员通知","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"","VENDORDESC":""}],"showcount":1,"totalpage":1,"totalresult":1}
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

    public static class ResultBean {
        /**
         * curpage : 1
         * resultlist : [{"DESCRIPTION":"","ORDERDATE":"2020-07-16 10:17:43","POID":31021,"PONUM":"31928","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"保管员通知","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"","VENDORDESC":""}]
         * showcount : 1
         * totalpage : 1
         * totalresult : 1
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

        public static class ResultlistBean {
            /**
             * DESCRIPTION :
             * ORDERDATE : 2020-07-16 10:17:43
             * POID : 31021
             * PONUM : 31928
             * RECEIPTS : 无
             * REQUIREDDATE :
             * SHIPTOATTN : 系统管理员
             * STATUS : 保管员通知
             * TOTALCOST : 0.00
             * TOTJINE :
             * TOTSHUIE :
             * VENDOR :
             * VENDORDESC :
             */

            private String DESCRIPTION;
            private String ORDERDATE;
            private int POID;
            private String PONUM;
            private String RECEIPTS;
            private String REQUIREDDATE;
            private String SHIPTOATTN;
            private String STATUS;
            private String TOTALCOST;
            private String TOTJINE;
            private String TOTSHUIE;
            private String VENDOR;
            private String VENDORDESC;
            public String getSITEID() {
                return SITEID;
            }

            public void setSITEID(String SITEID) {
                this.SITEID = SITEID;
            }

            private String SITEID;

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getORDERDATE() {
                return ORDERDATE;
            }

            public void setORDERDATE(String ORDERDATE) {
                this.ORDERDATE = ORDERDATE;
            }

            public int getPOID() {
                return POID;
            }

            public void setPOID(int POID) {
                this.POID = POID;
            }

            public String getPONUM() {
                return PONUM;
            }

            public void setPONUM(String PONUM) {
                this.PONUM = PONUM;
            }

            public String getRECEIPTS() {
                return RECEIPTS;
            }

            public void setRECEIPTS(String RECEIPTS) {
                this.RECEIPTS = RECEIPTS;
            }

            public String getREQUIREDDATE() {
                return REQUIREDDATE;
            }

            public void setREQUIREDDATE(String REQUIREDDATE) {
                this.REQUIREDDATE = REQUIREDDATE;
            }

            public String getSHIPTOATTN() {
                return SHIPTOATTN;
            }

            public void setSHIPTOATTN(String SHIPTOATTN) {
                this.SHIPTOATTN = SHIPTOATTN;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getTOTALCOST() {
                return TOTALCOST;
            }

            public void setTOTALCOST(String TOTALCOST) {
                this.TOTALCOST = TOTALCOST;
            }

            public String getTOTJINE() {
                return TOTJINE;
            }

            public void setTOTJINE(String TOTJINE) {
                this.TOTJINE = TOTJINE;
            }

            public String getTOTSHUIE() {
                return TOTSHUIE;
            }

            public void setTOTSHUIE(String TOTSHUIE) {
                this.TOTSHUIE = TOTSHUIE;
            }

            public String getVENDOR() {
                return VENDOR;
            }

            public void setVENDOR(String VENDOR) {
                this.VENDOR = VENDOR;
            }

            public String getVENDORDESC() {
                return VENDORDESC;
            }

            public void setVENDORDESC(String VENDORDESC) {
                this.VENDORDESC = VENDORDESC;
            }
        }
    }
}
