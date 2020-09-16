package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class DetailForStoreBean implements Serializable {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"AVBLBALANCE":"0.00","ISSUEUNIT":"只","ITEMNUM":"429040216","LASTCOST":"325.00","LOCATION":"CS"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"AVBLBALANCE":"0.00","ISSUEUNIT":"只","ITEMNUM":"429040216","LASTCOST":"325.00","LOCATION":"CS"}]
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
             * AVBLBALANCE : 0.00
             * ISSUEUNIT : 只
             * ITEMNUM : 429040216
             * LASTCOST : 325.00
             * LOCATION : CS
             */

            private String AVBLBALANCE;
            private String ISSUEUNIT;
            private String ITEMNUM;
            private String LASTCOST;
            private String LOCATION;

            public String getAVBLBALANCE() {
                return AVBLBALANCE;
            }

            public void setAVBLBALANCE(String AVBLBALANCE) {
                this.AVBLBALANCE = AVBLBALANCE;
            }

            public String getISSUEUNIT() {
                return ISSUEUNIT;
            }

            public void setISSUEUNIT(String ISSUEUNIT) {
                this.ISSUEUNIT = ISSUEUNIT;
            }

            public String getITEMNUM() {
                return ITEMNUM;
            }

            public void setITEMNUM(String ITEMNUM) {
                this.ITEMNUM = ITEMNUM;
            }

            public String getLASTCOST() {
                return LASTCOST;
            }

            public void setLASTCOST(String LASTCOST) {
                this.LASTCOST = LASTCOST;
            }

            public String getLOCATION() {
                return LOCATION;
            }

            public void setLOCATION(String LOCATION) {
                this.LOCATION = LOCATION;
            }
        }
    }
}
