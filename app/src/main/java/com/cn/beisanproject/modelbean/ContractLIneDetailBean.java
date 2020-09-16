package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class ContractLIneDetailBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"CONTRACTLINENUM":"1","CONTRACTNUM":"3011","ITEMDESC":"夏分体工作服","ITEMNUM":"282000001","ITEMPP":"","ITEMXH":"淡蓝带反光条","LINECOST":"99.00","ORDERQTY":"1.00","ORDERUNIT":"套","ORGID":"10","REVISIONNUM":"0","UNITCOST":"99.00"}],"showcount":20,"totalpage":1,"totalresult":1}
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

    public static class ResultBean  implements Serializable{
        /**
         * curpage : 1
         * resultlist : [{"CONTRACTLINENUM":"1","CONTRACTNUM":"3011","ITEMDESC":"夏分体工作服","ITEMNUM":"282000001","ITEMPP":"","ITEMXH":"淡蓝带反光条","LINECOST":"99.00","ORDERQTY":"1.00","ORDERUNIT":"套","ORGID":"10","REVISIONNUM":"0","UNITCOST":"99.00"}]
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
             * CONTRACTLINENUM : 1
             * CONTRACTNUM : 3011
             * ITEMDESC : 夏分体工作服
             * ITEMNUM : 282000001
             * ITEMPP :
             * ITEMXH : 淡蓝带反光条
             * LINECOST : 99.00
             * ORDERQTY : 1.00
             * ORDERUNIT : 套
             * ORGID : 10
             * REVISIONNUM : 0
             * UNITCOST : 99.00
             */

            private String CONTRACTLINENUM;
            private String CONTRACTNUM;
            private String ITEMDESC;
            private String ITEMNUM;
            private String ITEMPP;
            private String ITEMXH;
            private String LINECOST;
            private String ORDERQTY;
            private String ORDERUNIT;
            private String ORGID;
            private String REVISIONNUM;
            private String UNITCOST;

            public String getCONTRACTLINENUM() {
                return CONTRACTLINENUM;
            }

            public void setCONTRACTLINENUM(String CONTRACTLINENUM) {
                this.CONTRACTLINENUM = CONTRACTLINENUM;
            }

            public String getCONTRACTNUM() {
                return CONTRACTNUM;
            }

            public void setCONTRACTNUM(String CONTRACTNUM) {
                this.CONTRACTNUM = CONTRACTNUM;
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

            public String getITEMPP() {
                return ITEMPP;
            }

            public void setITEMPP(String ITEMPP) {
                this.ITEMPP = ITEMPP;
            }

            public String getITEMXH() {
                return ITEMXH;
            }

            public void setITEMXH(String ITEMXH) {
                this.ITEMXH = ITEMXH;
            }

            public String getLINECOST() {
                return LINECOST;
            }

            public void setLINECOST(String LINECOST) {
                this.LINECOST = LINECOST;
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

            public String getORGID() {
                return ORGID;
            }

            public void setORGID(String ORGID) {
                this.ORGID = ORGID;
            }

            public String getREVISIONNUM() {
                return REVISIONNUM;
            }

            public void setREVISIONNUM(String REVISIONNUM) {
                this.REVISIONNUM = REVISIONNUM;
            }

            public String getUNITCOST() {
                return UNITCOST;
            }

            public void setUNITCOST(String UNITCOST) {
                this.UNITCOST = UNITCOST;
            }
        }
    }
}
