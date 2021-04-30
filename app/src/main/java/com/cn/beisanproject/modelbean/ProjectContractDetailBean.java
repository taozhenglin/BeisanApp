package com.cn.beisanproject.modelbean;

import java.util.List;

public class ProjectContractDetailBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_BUDGETDESC":"桥吊委外维修费用-其它","A_BUDGETNUM":"2019CB-XL-Q-QT","A_COMP":"11","A_DEPT":"安全卫环部","A_RFQDESC":"杨鑫测试0303002","A_RFQNUM":"2502","CONTNUM":"1001","CONTRACTID":8767,"CONTRACTNUM":"3039","DESCRIPTION":"杨鑫测试0303002","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"11","HTYF":"","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"项目合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-03","STATUS":"总经理事务部法务审批","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"购销合同","UDZBDQR":"","VENDOR":"GK13447","VENDORDESC":"上海船舶运输科学研究所","ZBJ":"13.00"}],"showcount":1,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"A_BUDGETDESC":"桥吊委外维修费用-其它","A_BUDGETNUM":"2019CB-XL-Q-QT","A_COMP":"11","A_DEPT":"安全卫环部","A_RFQDESC":"杨鑫测试0303002","A_RFQNUM":"2502","CONTNUM":"1001","CONTRACTID":8767,"CONTRACTNUM":"3039","DESCRIPTION":"杨鑫测试0303002","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"11","HTYF":"","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"项目合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-03","STATUS":"总经理事务部法务审批","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"购销合同","UDZBDQR":"","VENDOR":"GK13447","VENDORDESC":"上海船舶运输科学研究所","ZBJ":"13.00"}]
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
             * A_BUDGETDESC : 桥吊委外维修费用-其它
             * A_BUDGETNUM : 2019CB-XL-Q-QT
             * A_COMP : 11
             * A_DEPT : 安全卫环部
             * A_RFQDESC : 杨鑫测试0303002
             * A_RFQNUM : 2502
             * CONTNUM : 1001
             * CONTRACTID : 8767
             * CONTRACTNUM : 3039
             * DESCRIPTION : 杨鑫测试0303002
             * ENDDATE :
             * ENTERBY :
             * ENTERBYDESC :
             * HASINSURANCE : N
             * HTJF : 11
             * HTYF :
             * JFQZDB : 安全卫环部
             * J_CONTRACTDATE :
             * LB : 项目合同
             * ORGID : 10
             * REVISIONNUM : 0
             * STARTDATE : 2020-06-03
             * STATUS : 总经理事务部法务审批
             * TOTALBASECOST : 0.00
             * TOTALCOST : 0.00
             * UDHTFL :
             * UDHTLX : 购销合同
             * UDZBDQR :
             * VENDOR : GK13447
             * VENDORDESC : 上海船舶运输科学研究所
             * ZBJ : 13.00
             * QIANMING ：
             */

            private String A_BUDGETDESC;
            private String A_BUDGETNUM;
            private String A_COMP;
            private String A_DEPT;
            private String A_RFQDESC;
            private String A_RFQNUM;
            private String CONTNUM;
            private int CONTRACTID;
            private String CONTRACTNUM;
            private String DESCRIPTION;
            private String ENDDATE;
            private String ENTERBY;
            private String ENTERBYDESC;
            private String HASINSURANCE;
            private String HTJF;
            private String HTYF;
            private String JFQZDB;
            private String J_CONTRACTDATE;
            private String LB;
            private String ORGID;
            private String REVISIONNUM;
            private String STARTDATE;
            private String STATUS;
            private String TOTALBASECOST;
            private String TOTALCOST;
            private String UDHTFL;
            private String UDHTLX;
            private String UDZBDQR;
            private String VENDOR;
            private String VENDORDESC;
            private String ZBJ;
            String UDHTLY;

            public String getUDHTLY() {
                return UDHTLY;
            }

            public void setUDHTLY(String UDHTLY) {
                this.UDHTLY = UDHTLY;
            }


            public String getQIANMING() {
                return QIANMING;
            }

            public void setQIANMING(String QIANMING) {
                this.QIANMING = QIANMING;
            }

            private String QIANMING;

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

            public String getA_COMP() {
                return A_COMP;
            }

            public void setA_COMP(String A_COMP) {
                this.A_COMP = A_COMP;
            }

            public String getA_DEPT() {
                return A_DEPT;
            }

            public void setA_DEPT(String A_DEPT) {
                this.A_DEPT = A_DEPT;
            }

            public String getA_RFQDESC() {
                return A_RFQDESC;
            }

            public void setA_RFQDESC(String A_RFQDESC) {
                this.A_RFQDESC = A_RFQDESC;
            }

            public String getA_RFQNUM() {
                return A_RFQNUM;
            }

            public void setA_RFQNUM(String A_RFQNUM) {
                this.A_RFQNUM = A_RFQNUM;
            }

            public String getCONTNUM() {
                return CONTNUM;
            }

            public void setCONTNUM(String CONTNUM) {
                this.CONTNUM = CONTNUM;
            }

            public int getCONTRACTID() {
                return CONTRACTID;
            }

            public void setCONTRACTID(int CONTRACTID) {
                this.CONTRACTID = CONTRACTID;
            }

            public String getCONTRACTNUM() {
                return CONTRACTNUM;
            }

            public void setCONTRACTNUM(String CONTRACTNUM) {
                this.CONTRACTNUM = CONTRACTNUM;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getENDDATE() {
                return ENDDATE;
            }

            public void setENDDATE(String ENDDATE) {
                this.ENDDATE = ENDDATE;
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

            public String getHASINSURANCE() {
                return HASINSURANCE;
            }

            public void setHASINSURANCE(String HASINSURANCE) {
                this.HASINSURANCE = HASINSURANCE;
            }

            public String getHTJF() {
                return HTJF;
            }

            public void setHTJF(String HTJF) {
                this.HTJF = HTJF;
            }

            public String getHTYF() {
                return HTYF;
            }

            public void setHTYF(String HTYF) {
                this.HTYF = HTYF;
            }

            public String getJFQZDB() {
                return JFQZDB;
            }

            public void setJFQZDB(String JFQZDB) {
                this.JFQZDB = JFQZDB;
            }

            public String getJ_CONTRACTDATE() {
                return J_CONTRACTDATE;
            }

            public void setJ_CONTRACTDATE(String J_CONTRACTDATE) {
                this.J_CONTRACTDATE = J_CONTRACTDATE;
            }

            public String getLB() {
                return LB;
            }

            public void setLB(String LB) {
                this.LB = LB;
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

            public String getSTARTDATE() {
                return STARTDATE;
            }

            public void setSTARTDATE(String STARTDATE) {
                this.STARTDATE = STARTDATE;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getTOTALBASECOST() {
                return TOTALBASECOST;
            }

            public void setTOTALBASECOST(String TOTALBASECOST) {
                this.TOTALBASECOST = TOTALBASECOST;
            }

            public String getTOTALCOST() {
                return TOTALCOST;
            }

            public void setTOTALCOST(String TOTALCOST) {
                this.TOTALCOST = TOTALCOST;
            }

            public String getUDHTFL() {
                return UDHTFL;
            }

            public void setUDHTFL(String UDHTFL) {
                this.UDHTFL = UDHTFL;
            }

            public String getUDHTLX() {
                return UDHTLX;
            }

            public void setUDHTLX(String UDHTLX) {
                this.UDHTLX = UDHTLX;
            }

            public String getUDZBDQR() {
                return UDZBDQR;
            }

            public void setUDZBDQR(String UDZBDQR) {
                this.UDZBDQR = UDZBDQR;
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

            public String getZBJ() {
                return ZBJ;
            }

            public void setZBJ(String ZBJ) {
                this.ZBJ = ZBJ;
            }
        }
    }
}
