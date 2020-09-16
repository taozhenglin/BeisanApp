package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class PurchaseMonthPlanDetailBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PR","A_PURCATALOG":"安全卫环部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-11 09:16:40","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"XX月物资计划申请单","ISSUEDATE":"2020-06-11 09:16:30","LXLX":"","MEMO":"","ORGID":"10","PRID":3013,"PRNUM":"WZ00527","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"等待批准","STATUSDESC":"等待批准","TOTALCOST":"0.0000","UDYS":"N","VENDOR":"","XMLB":""}],"showcount":1,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PR","A_PURCATALOG":"安全卫环部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-11 09:16:40","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"XX月物资计划申请单","ISSUEDATE":"2020-06-11 09:16:30","LXLX":"","MEMO":"","ORGID":"10","PRID":3013,"PRNUM":"WZ00527","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"等待批准","STATUSDESC":"等待批准","TOTALCOST":"0.0000","UDYS":"N","VENDOR":"","XMLB":""}]
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
             * A_BUDGETDESC :
             * A_BUDGETNUM :
             * A_COMPANY : 北三
             * A_CREWID :
             * A_DEPT : 信息中心
             * A_PRKEY : 202007
             * A_PRSUMTYPE :
             * A_PRTYPE : PR
             * A_PURCATALOG : 安全卫环部
             * A_PURTYPE : 月度
             * A_SUMNUM :
             * A_TOSUM : N
             * CHANGEDATE : 2020-06-11 09:16:40
             * CONTRACTREFNUM :
             * CONTRACTREFREV :
             * DESCRIPTION : XX月物资计划申请单
             * ISSUEDATE : 2020-06-11 09:16:30
             * LXLX :
             * MEMO :
             * ORGID : 10
             * PRID : 3013
             * PRNUM : WZ00527
             * REQUESTEDBY : MAXADMIN
             * REQUIREDDATE :
             * R_DEPTDESC : 系统管理员
             * R_PRSTATUS :
             * SITEID : 1000
             * STATUS : 等待批准
             * STATUSDESC : 等待批准
             * TOTALCOST : 0.0000
             * UDYS : N
             * VENDOR :
             * XMLB :
             */

            private String A_BUDGETDESC;
            private String A_BUDGETNUM;
            private String A_COMPANY;
            private String A_CREWID;
            private String A_DEPT;
            private String A_PRKEY;
            private String A_PRSUMTYPE;
            private String A_PRTYPE;
            private String A_PURCATALOG;
            private String A_PURTYPE;
            private String A_SUMNUM;
            private String A_TOSUM;
            private String CHANGEDATE;
            private String CONTRACTREFNUM;
            private String CONTRACTREFREV;
            private String DESCRIPTION;
            private String ISSUEDATE;
            private String LXLX;
            private String MEMO;
            private String ORGID;
            private int PRID;
            private String PRNUM;
            private String REQUESTEDBY;
            private String REQUIREDDATE;
            private String R_DEPTDESC;
            private String R_PRSTATUS;
            private String SITEID;
            private String STATUS;
            private String STATUSDESC;
            private String TOTALCOST;
            private String UDYS;
            private String VENDOR;
            private String XMLB;

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

            public String getA_COMPANY() {
                return A_COMPANY;
            }

            public void setA_COMPANY(String A_COMPANY) {
                this.A_COMPANY = A_COMPANY;
            }

            public String getA_CREWID() {
                return A_CREWID;
            }

            public void setA_CREWID(String A_CREWID) {
                this.A_CREWID = A_CREWID;
            }

            public String getA_DEPT() {
                return A_DEPT;
            }

            public void setA_DEPT(String A_DEPT) {
                this.A_DEPT = A_DEPT;
            }

            public String getA_PRKEY() {
                return A_PRKEY;
            }

            public void setA_PRKEY(String A_PRKEY) {
                this.A_PRKEY = A_PRKEY;
            }

            public String getA_PRSUMTYPE() {
                return A_PRSUMTYPE;
            }

            public void setA_PRSUMTYPE(String A_PRSUMTYPE) {
                this.A_PRSUMTYPE = A_PRSUMTYPE;
            }

            public String getA_PRTYPE() {
                return A_PRTYPE;
            }

            public void setA_PRTYPE(String A_PRTYPE) {
                this.A_PRTYPE = A_PRTYPE;
            }

            public String getA_PURCATALOG() {
                return A_PURCATALOG;
            }

            public void setA_PURCATALOG(String A_PURCATALOG) {
                this.A_PURCATALOG = A_PURCATALOG;
            }

            public String getA_PURTYPE() {
                return A_PURTYPE;
            }

            public void setA_PURTYPE(String A_PURTYPE) {
                this.A_PURTYPE = A_PURTYPE;
            }

            public String getA_SUMNUM() {
                return A_SUMNUM;
            }

            public void setA_SUMNUM(String A_SUMNUM) {
                this.A_SUMNUM = A_SUMNUM;
            }

            public String getA_TOSUM() {
                return A_TOSUM;
            }

            public void setA_TOSUM(String A_TOSUM) {
                this.A_TOSUM = A_TOSUM;
            }

            public String getCHANGEDATE() {
                return CHANGEDATE;
            }

            public void setCHANGEDATE(String CHANGEDATE) {
                this.CHANGEDATE = CHANGEDATE;
            }

            public String getCONTRACTREFNUM() {
                return CONTRACTREFNUM;
            }

            public void setCONTRACTREFNUM(String CONTRACTREFNUM) {
                this.CONTRACTREFNUM = CONTRACTREFNUM;
            }

            public String getCONTRACTREFREV() {
                return CONTRACTREFREV;
            }

            public void setCONTRACTREFREV(String CONTRACTREFREV) {
                this.CONTRACTREFREV = CONTRACTREFREV;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getISSUEDATE() {
                return ISSUEDATE;
            }

            public void setISSUEDATE(String ISSUEDATE) {
                this.ISSUEDATE = ISSUEDATE;
            }

            public String getLXLX() {
                return LXLX;
            }

            public void setLXLX(String LXLX) {
                this.LXLX = LXLX;
            }

            public String getMEMO() {
                return MEMO;
            }

            public void setMEMO(String MEMO) {
                this.MEMO = MEMO;
            }

            public String getORGID() {
                return ORGID;
            }

            public void setORGID(String ORGID) {
                this.ORGID = ORGID;
            }

            public int getPRID() {
                return PRID;
            }

            public void setPRID(int PRID) {
                this.PRID = PRID;
            }

            public String getPRNUM() {
                return PRNUM;
            }

            public void setPRNUM(String PRNUM) {
                this.PRNUM = PRNUM;
            }

            public String getREQUESTEDBY() {
                return REQUESTEDBY;
            }

            public void setREQUESTEDBY(String REQUESTEDBY) {
                this.REQUESTEDBY = REQUESTEDBY;
            }

            public String getREQUIREDDATE() {
                return REQUIREDDATE;
            }

            public void setREQUIREDDATE(String REQUIREDDATE) {
                this.REQUIREDDATE = REQUIREDDATE;
            }

            public String getR_DEPTDESC() {
                return R_DEPTDESC;
            }

            public void setR_DEPTDESC(String R_DEPTDESC) {
                this.R_DEPTDESC = R_DEPTDESC;
            }

            public String getR_PRSTATUS() {
                return R_PRSTATUS;
            }

            public void setR_PRSTATUS(String R_PRSTATUS) {
                this.R_PRSTATUS = R_PRSTATUS;
            }

            public String getSITEID() {
                return SITEID;
            }

            public void setSITEID(String SITEID) {
                this.SITEID = SITEID;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getSTATUSDESC() {
                return STATUSDESC;
            }

            public void setSTATUSDESC(String STATUSDESC) {
                this.STATUSDESC = STATUSDESC;
            }

            public String getTOTALCOST() {
                return TOTALCOST;
            }

            public void setTOTALCOST(String TOTALCOST) {
                this.TOTALCOST = TOTALCOST;
            }

            public String getUDYS() {
                return UDYS;
            }

            public void setUDYS(String UDYS) {
                this.UDYS = UDYS;
            }

            public String getVENDOR() {
                return VENDOR;
            }

            public void setVENDOR(String VENDOR) {
                this.VENDOR = VENDOR;
            }

            public String getXMLB() {
                return XMLB;
            }

            public void setXMLB(String XMLB) {
                this.XMLB = XMLB;
            }
        }
    }
}
