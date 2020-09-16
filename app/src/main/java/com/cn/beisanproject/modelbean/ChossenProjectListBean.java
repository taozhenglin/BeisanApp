package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class ChossenProjectListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_1CLASS":"CL","A_2CLASS":"CLWJRZ","A_3CLASS":"CLWJRZ42904","A_BRAND":"","A_ITEMKEEPER":"PUX","A_MODEL":"三联 AMC","A_OLDITEMNUM":"4070740","A_PURCHASEAGENT":"LINJP","A_PURSORT":"工程技术部","A_REFCOST":"200","A_TOTALQTY":"0.00","DESCRIPTION":"淋浴水笼头","ISSUEUNIT":"只","ITEMNUM":"429040216","SENDERSYSID":"五金机电及工具","TGITEMNUM":""}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"A_1CLASS":"CL","A_2CLASS":"CLWJRZ","A_3CLASS":"CLWJRZ42904","A_BRAND":"","A_ITEMKEEPER":"PUX","A_MODEL":"三联 AMC","A_OLDITEMNUM":"4070740","A_PURCHASEAGENT":"LINJP","A_PURSORT":"工程技术部","A_REFCOST":"200","A_TOTALQTY":"0.00","DESCRIPTION":"淋浴水笼头","ISSUEUNIT":"只","ITEMNUM":"429040216","SENDERSYSID":"五金机电及工具","TGITEMNUM":""}]
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

        public static class ResultlistBean implements Serializable {
            /**
             * A_1CLASS : CL
             * A_2CLASS : CLWJRZ
             * A_3CLASS : CLWJRZ42904
             * A_BRAND :
             * A_ITEMKEEPER : PUX
             * A_MODEL : 三联 AMC
             * A_OLDITEMNUM : 4070740
             * A_PURCHASEAGENT : LINJP
             * A_PURSORT : 工程技术部
             * A_REFCOST : 200
             * A_TOTALQTY : 0.00
             * DESCRIPTION : 淋浴水笼头
             * ISSUEUNIT : 只
             * ITEMNUM : 429040216
             * SENDERSYSID : 五金机电及工具
             * TGITEMNUM :
             */

            private String A_1CLASS;
            private String A_2CLASS;
            private String A_3CLASS;
            private String A_BRAND;
            private String A_ITEMKEEPER;
            private String A_MODEL;
            private String A_OLDITEMNUM;
            private String A_PURCHASEAGENT;
            private String A_PURSORT;
            private String A_REFCOST;
            private String A_TOTALQTY;
            private String DESCRIPTION;
            private String ISSUEUNIT;
            private String ITEMNUM;
            private String SENDERSYSID;
            private String TGITEMNUM;

            public String getA_1CLASS() {
                return A_1CLASS;
            }

            public void setA_1CLASS(String A_1CLASS) {
                this.A_1CLASS = A_1CLASS;
            }

            public String getA_2CLASS() {
                return A_2CLASS;
            }

            public void setA_2CLASS(String A_2CLASS) {
                this.A_2CLASS = A_2CLASS;
            }

            public String getA_3CLASS() {
                return A_3CLASS;
            }

            public void setA_3CLASS(String A_3CLASS) {
                this.A_3CLASS = A_3CLASS;
            }

            public String getA_BRAND() {
                return A_BRAND;
            }

            public void setA_BRAND(String A_BRAND) {
                this.A_BRAND = A_BRAND;
            }

            public String getA_ITEMKEEPER() {
                return A_ITEMKEEPER;
            }

            public void setA_ITEMKEEPER(String A_ITEMKEEPER) {
                this.A_ITEMKEEPER = A_ITEMKEEPER;
            }

            public String getA_MODEL() {
                return A_MODEL;
            }

            public void setA_MODEL(String A_MODEL) {
                this.A_MODEL = A_MODEL;
            }

            public String getA_OLDITEMNUM() {
                return A_OLDITEMNUM;
            }

            public void setA_OLDITEMNUM(String A_OLDITEMNUM) {
                this.A_OLDITEMNUM = A_OLDITEMNUM;
            }

            public String getA_PURCHASEAGENT() {
                return A_PURCHASEAGENT;
            }

            public void setA_PURCHASEAGENT(String A_PURCHASEAGENT) {
                this.A_PURCHASEAGENT = A_PURCHASEAGENT;
            }

            public String getA_PURSORT() {
                return A_PURSORT;
            }

            public void setA_PURSORT(String A_PURSORT) {
                this.A_PURSORT = A_PURSORT;
            }

            public String getA_REFCOST() {
                return A_REFCOST;
            }

            public void setA_REFCOST(String A_REFCOST) {
                this.A_REFCOST = A_REFCOST;
            }

            public String getA_TOTALQTY() {
                return A_TOTALQTY;
            }

            public void setA_TOTALQTY(String A_TOTALQTY) {
                this.A_TOTALQTY = A_TOTALQTY;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
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

            public String getSENDERSYSID() {
                return SENDERSYSID;
            }

            public void setSENDERSYSID(String SENDERSYSID) {
                this.SENDERSYSID = SENDERSYSID;
            }

            public String getTGITEMNUM() {
                return TGITEMNUM;
            }

            public void setTGITEMNUM(String TGITEMNUM) {
                this.TGITEMNUM = TGITEMNUM;
            }
        }
    }
}
