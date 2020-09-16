package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class ProjectMonthLineBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_BRAND":"","A_BUDGETDESC":"桥吊委外维修费用-桥吊清洗","A_BUDGETNUM":"2019CB-XL-Q-036","A_CREWIDDESC":"","A_DEPTDESC":"信息中心","A_MODEL":"HP LaserJet 1020 plus","A_PURTYPE":"月度","DESCRIPTION":"打印机","ITEMDESC":"打印机","ITEMNUM":"452300001","LINECOST":"2,051.2800","LINETYPE":"项目","LOADEDCOST":"2,051.2800","ORDERQTY":"2.00000","ORDERUNIT":"台","PRLINENUM":"1","PRNUM":"PROJ00187","REMARK":"","REQUESTEDBY":"MAXADMIN","REQUESTEDBYDESC":"系统管理员","RFQNUM":"2569","UNITCOST":"1,025.64"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"A_BRAND":"","A_BUDGETDESC":"桥吊委外维修费用-桥吊清洗","A_BUDGETNUM":"2019CB-XL-Q-036","A_CREWIDDESC":"","A_DEPTDESC":"信息中心","A_MODEL":"HP LaserJet 1020 plus","A_PURTYPE":"月度","DESCRIPTION":"打印机","ITEMDESC":"打印机","ITEMNUM":"452300001","LINECOST":"2,051.2800","LINETYPE":"项目","LOADEDCOST":"2,051.2800","ORDERQTY":"2.00000","ORDERUNIT":"台","PRLINENUM":"1","PRNUM":"PROJ00187","REMARK":"","REQUESTEDBY":"MAXADMIN","REQUESTEDBYDESC":"系统管理员","RFQNUM":"2569","UNITCOST":"1,025.64"}]
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
             * A_BRAND :
             * A_BUDGETDESC : 桥吊委外维修费用-桥吊清洗
             * A_BUDGETNUM : 2019CB-XL-Q-036
             * A_CREWIDDESC :
             * A_DEPTDESC : 信息中心
             * A_MODEL : HP LaserJet 1020 plus
             * A_PURTYPE : 月度
             * DESCRIPTION : 打印机
             * ITEMDESC : 打印机
             * ITEMNUM : 452300001
             * LINECOST : 2,051.2800
             * LINETYPE : 项目
             * LOADEDCOST : 2,051.2800
             * ORDERQTY : 2.00000
             * ORDERUNIT : 台
             * PRLINENUM : 1
             * PRNUM : PROJ00187
             * REMARK :
             * REQUESTEDBY : MAXADMIN
             * REQUESTEDBYDESC : 系统管理员
             * RFQNUM : 2569
             * UNITCOST : 1,025.64
             */

            private String A_BRAND;
            private String A_BUDGETDESC;
            private String A_BUDGETNUM;
            private String A_CREWIDDESC;
            private String A_DEPTDESC;
            private String A_MODEL;
            private String A_PURTYPE;
            private String DESCRIPTION;
            private String ITEMDESC;
            private String ITEMNUM;
            private String LINECOST;
            private String LINETYPE;
            private String LOADEDCOST;
            private String ORDERQTY;
            private String ORDERUNIT;
            private String PRLINENUM;
            private String PRNUM;
            private String REMARK;
            private String REQUESTEDBY;
            private String REQUESTEDBYDESC;
            private String RFQNUM;
            private String UNITCOST;

            public String getA_BRAND() {
                return A_BRAND;
            }

            public void setA_BRAND(String A_BRAND) {
                this.A_BRAND = A_BRAND;
            }

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

            public String getA_CREWIDDESC() {
                return A_CREWIDDESC;
            }

            public void setA_CREWIDDESC(String A_CREWIDDESC) {
                this.A_CREWIDDESC = A_CREWIDDESC;
            }

            public String getA_DEPTDESC() {
                return A_DEPTDESC;
            }

            public void setA_DEPTDESC(String A_DEPTDESC) {
                this.A_DEPTDESC = A_DEPTDESC;
            }

            public String getA_MODEL() {
                return A_MODEL;
            }

            public void setA_MODEL(String A_MODEL) {
                this.A_MODEL = A_MODEL;
            }

            public String getA_PURTYPE() {
                return A_PURTYPE;
            }

            public void setA_PURTYPE(String A_PURTYPE) {
                this.A_PURTYPE = A_PURTYPE;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
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

            public String getLINETYPE() {
                return LINETYPE;
            }

            public void setLINETYPE(String LINETYPE) {
                this.LINETYPE = LINETYPE;
            }

            public String getLOADEDCOST() {
                return LOADEDCOST;
            }

            public void setLOADEDCOST(String LOADEDCOST) {
                this.LOADEDCOST = LOADEDCOST;
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

            public String getPRLINENUM() {
                return PRLINENUM;
            }

            public void setPRLINENUM(String PRLINENUM) {
                this.PRLINENUM = PRLINENUM;
            }

            public String getPRNUM() {
                return PRNUM;
            }

            public void setPRNUM(String PRNUM) {
                this.PRNUM = PRNUM;
            }

            public String getREMARK() {
                return REMARK;
            }

            public void setREMARK(String REMARK) {
                this.REMARK = REMARK;
            }

            public String getREQUESTEDBY() {
                return REQUESTEDBY;
            }

            public void setREQUESTEDBY(String REQUESTEDBY) {
                this.REQUESTEDBY = REQUESTEDBY;
            }

            public String getREQUESTEDBYDESC() {
                return REQUESTEDBYDESC;
            }

            public void setREQUESTEDBYDESC(String REQUESTEDBYDESC) {
                this.REQUESTEDBYDESC = REQUESTEDBYDESC;
            }

            public String getRFQNUM() {
                return RFQNUM;
            }

            public void setRFQNUM(String RFQNUM) {
                this.RFQNUM = RFQNUM;
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
