package com.cn.beisanproject.modelbean;

import java.util.List;

public class PuarchaseSupportQuoteBean {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_FL":"13.00","A_MODEL":"","DELIVERYDATE":"","DESCRIPTION":"轨道吊大车啃轨修理","ENTERBY":"QIUW","ENTERDATE":"2020-01-22 09:26:07","ISAWARDED":"Y","ITEMDESC":"","ITEMNUM":"","LINECOST":"20,000.00","MEMO":"1#轨道吊大车啃轨，需调节大车轮距","ORDERQTY":"1.0000","ORDERUNIT":"","QUOTEENDDATE":"","QUOTESTARTDATE":"","RFQLINENUM":"1","RFQNUM":"2496","SITEID":"1000","UNITCOST":"20,000.0000","VENDOR":"GK11604"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"A_FL":"13.00","A_MODEL":"","DELIVERYDATE":"","DESCRIPTION":"轨道吊大车啃轨修理","ENTERBY":"QIUW","ENTERDATE":"2020-01-22 09:26:07","ISAWARDED":"Y","ITEMDESC":"","ITEMNUM":"","LINECOST":"20,000.00","MEMO":"1#轨道吊大车啃轨，需调节大车轮距","ORDERQTY":"1.0000","ORDERUNIT":"","QUOTEENDDATE":"","QUOTESTARTDATE":"","RFQLINENUM":"1","RFQNUM":"2496","SITEID":"1000","UNITCOST":"20,000.0000","VENDOR":"GK11604"}]
         * showcount : 20
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
             * A_FL : 13.00
             * A_MODEL :
             * DELIVERYDATE :
             * DESCRIPTION : 轨道吊大车啃轨修理
             * ENTERBY : QIUW
             * ENTERDATE : 2020-01-22 09:26:07
             * ISAWARDED : Y
             * ITEMDESC :
             * ITEMNUM :
             * LINECOST : 20,000.00
             * MEMO : 1#轨道吊大车啃轨，需调节大车轮距
             * ORDERQTY : 1.0000
             * ORDERUNIT :
             * QUOTEENDDATE :
             * QUOTESTARTDATE :
             * RFQLINENUM : 1
             * RFQNUM : 2496
             * SITEID : 1000
             * UNITCOST : 20,000.0000
             * VENDOR : GK11604
             */

            private String A_FL;
            private String A_MODEL;
            private String DELIVERYDATE;
            private String DESCRIPTION;
            private String ENTERBY;
            private String ENTERDATE;
            private String ISAWARDED;
            private String ITEMDESC;
            private String ITEMNUM;
            private String LINECOST;
            private String MEMO;
            private String ORDERQTY;
            private String ORDERUNIT;
            private String QUOTEENDDATE;
            private String QUOTESTARTDATE;
            private String RFQLINENUM;
            private String RFQNUM;
            private String SITEID;
            private String UNITCOST;
            private String VENDOR;

            public String getA_FL() {
                return A_FL;
            }

            public void setA_FL(String A_FL) {
                this.A_FL = A_FL;
            }

            public String getA_MODEL() {
                return A_MODEL;
            }

            public void setA_MODEL(String A_MODEL) {
                this.A_MODEL = A_MODEL;
            }

            public String getDELIVERYDATE() {
                return DELIVERYDATE;
            }

            public void setDELIVERYDATE(String DELIVERYDATE) {
                this.DELIVERYDATE = DELIVERYDATE;
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

            public String getENTERDATE() {
                return ENTERDATE;
            }

            public void setENTERDATE(String ENTERDATE) {
                this.ENTERDATE = ENTERDATE;
            }

            public String getISAWARDED() {
                return ISAWARDED;
            }

            public void setISAWARDED(String ISAWARDED) {
                this.ISAWARDED = ISAWARDED;
            }

            public String getITEMDESC() {
                return ITEMDESC;
            }

            public void setITEMDESC(String ITEMDESC) {
                this.ITEMDESC = ITEMDESC;
            }

            public String getITEMNUM() {
                return ITEMNUM;
            }

            public void setITEMNUM(String ITEMNUM) {
                this.ITEMNUM = ITEMNUM;
            }

            public String getLINECOST() {
                return LINECOST;
            }

            public void setLINECOST(String LINECOST) {
                this.LINECOST = LINECOST;
            }

            public String getMEMO() {
                return MEMO;
            }

            public void setMEMO(String MEMO) {
                this.MEMO = MEMO;
            }

            public String getORDERQTY() {
                return ORDERQTY;
            }

            public void setORDERQTY(String ORDERQTY) {
                this.ORDERQTY = ORDERQTY;
            }

            public String getORDERUNIT() {
                return ORDERUNIT;
            }

            public void setORDERUNIT(String ORDERUNIT) {
                this.ORDERUNIT = ORDERUNIT;
            }

            public String getQUOTEENDDATE() {
                return QUOTEENDDATE;
            }

            public void setQUOTEENDDATE(String QUOTEENDDATE) {
                this.QUOTEENDDATE = QUOTEENDDATE;
            }

            public String getQUOTESTARTDATE() {
                return QUOTESTARTDATE;
            }

            public void setQUOTESTARTDATE(String QUOTESTARTDATE) {
                this.QUOTESTARTDATE = QUOTESTARTDATE;
            }

            public String getRFQLINENUM() {
                return RFQLINENUM;
            }

            public void setRFQLINENUM(String RFQLINENUM) {
                this.RFQLINENUM = RFQLINENUM;
            }

            public String getRFQNUM() {
                return RFQNUM;
            }

            public void setRFQNUM(String RFQNUM) {
                this.RFQNUM = RFQNUM;
            }

            public String getSITEID() {
                return SITEID;
            }

            public void setSITEID(String SITEID) {
                this.SITEID = SITEID;
            }

            public String getUNITCOST() {
                return UNITCOST;
            }

            public void setUNITCOST(String UNITCOST) {
                this.UNITCOST = UNITCOST;
            }

            public String getVENDOR() {
                return VENDOR;
            }

            public void setVENDOR(String VENDOR) {
                this.VENDOR = VENDOR;
            }
        }
    }
}
