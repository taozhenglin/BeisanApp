package com.cn.beisanproject.modelbean;

import java.util.List;

public class PurchaseListLineBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_MODEL":"0#","ITEMDESC":"柴油","ITEMNUM":"333600001","JINE":"125.43","LINECOST":"111.0000","ORDERQTY":"1.00000","ORDERUNIT":"吨","PL4":"13","SHUIE":"14.4300","SITEID":"1000","STORELOC":"BSJS","UNITCOST":"111"},{"A_MODEL":"0#","ITEMDESC":"柴油","ITEMNUM":"333600001","JINE":"250.86","LINECOST":"222.0000","ORDERQTY":"1.00000","ORDERUNIT":"吨","PL4":"13","SHUIE":"28.8600","SITEID":"1000","STORELOC":"BSJS","UNITCOST":"222"}],"showcount":20,"totalpage":1,"totalresult":2}
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
         * resultlist : [{"A_MODEL":"0#","ITEMDESC":"柴油","ITEMNUM":"333600001","JINE":"125.43","LINECOST":"111.0000","ORDERQTY":"1.00000","ORDERUNIT":"吨","PL4":"13","SHUIE":"14.4300","SITEID":"1000","STORELOC":"BSJS","UNITCOST":"111"},{"A_MODEL":"0#","ITEMDESC":"柴油","ITEMNUM":"333600001","JINE":"250.86","LINECOST":"222.0000","ORDERQTY":"1.00000","ORDERUNIT":"吨","PL4":"13","SHUIE":"28.8600","SITEID":"1000","STORELOC":"BSJS","UNITCOST":"222"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 2
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
             * A_MODEL : 0#
             * ITEMDESC : 柴油
             * ITEMNUM : 333600001
             * JINE : 125.43
             * LINECOST : 111.0000
             * ORDERQTY : 1.00000
             * ORDERUNIT : 吨
             * PL4 : 13
             * SHUIE : 14.4300
             * SITEID : 1000
             * STORELOC : BSJS
             * UNITCOST : 111
             */

            private String A_MODEL;
            private String ITEMDESC;
            private String ITEMNUM;
            private String JINE;
            private String LINECOST;
            private String ORDERQTY;
            private String ORDERUNIT;
            private String PL4;
            private String SHUIE;
            private String SITEID;
            private String STORELOC;
            private String UNITCOST;

            public String getA_MODEL() {
                return A_MODEL;
            }

            public void setA_MODEL(String A_MODEL) {
                this.A_MODEL = A_MODEL;
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

            public String getJINE() {
                return JINE;
            }

            public void setJINE(String JINE) {
                this.JINE = JINE;
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

            public String getPL4() {
                return PL4;
            }

            public void setPL4(String PL4) {
                this.PL4 = PL4;
            }

            public String getSHUIE() {
                return SHUIE;
            }

            public void setSHUIE(String SHUIE) {
                this.SHUIE = SHUIE;
            }

            public String getSITEID() {
                return SITEID;
            }

            public void setSITEID(String SITEID) {
                this.SITEID = SITEID;
            }

            public String getSTORELOC() {
                return STORELOC;
            }

            public void setSTORELOC(String STORELOC) {
                this.STORELOC = STORELOC;
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
