package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class ProjectChangeBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"CONTRACTDESC":"宁波舟山港穿山港区卡口改造工程招标代理及造价咨询合同","CONTRACTNUM":"4963","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:07:13","DESCRIPTION":"app流程测试","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"项目合同变更审批","TOTALCOST":"48,000.00","UDBGNUM":"1009","UDPURCHBGID":46,"UNITCOST":""}],"showcount":1,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"CONTRACTDESC":"宁波舟山港穿山港区卡口改造工程招标代理及造价咨询合同","CONTRACTNUM":"4963","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:07:13","DESCRIPTION":"app流程测试","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"项目合同变更审批","TOTALCOST":"48,000.00","UDBGNUM":"1009","UDPURCHBGID":46,"UNITCOST":""}]
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
             * CONTRACTDESC : 宁波舟山港穿山港区卡口改造工程招标代理及造价咨询合同
             * CONTRACTNUM : 4963
             * CREATEBY : MAXADMIN
             * CREATEBYDESC : 系统管理员
             * CREATEDATE : 2020-06-11 16:07:13
             * DESCRIPTION : app流程测试
             * ENDDATE :
             * ENDDATEDESC :
             * REMARK :
             * STARTDATE :
             * STATUS : 项目合同变更审批
             * TOTALCOST : 48,000.00
             * UDBGNUM : 1009
             * UDPURCHBGID : 46
             * UNITCOST :
             */

            private String CONTRACTDESC;
            private String CONTRACTNUM;
            private String CREATEBY;
            private String CREATEBYDESC;
            private String CREATEDATE;
            private String DESCRIPTION;
            private String ENDDATE;
            private String ENDDATEDESC;
            private String REMARK;
            private String STARTDATE;
            private String STATUS;
            private String TOTALCOST;
            private String UDBGNUM;
            private int UDPURCHBGID;
            private String UNITCOST;

            public String getCONTRACTDESC() {
                return CONTRACTDESC;
            }

            public void setCONTRACTDESC(String CONTRACTDESC) {
                this.CONTRACTDESC = CONTRACTDESC;
            }

            public String getCONTRACTNUM() {
                return CONTRACTNUM;
            }

            public void setCONTRACTNUM(String CONTRACTNUM) {
                this.CONTRACTNUM = CONTRACTNUM;
            }

            public String getCREATEBY() {
                return CREATEBY;
            }

            public void setCREATEBY(String CREATEBY) {
                this.CREATEBY = CREATEBY;
            }

            public String getCREATEBYDESC() {
                return CREATEBYDESC;
            }

            public void setCREATEBYDESC(String CREATEBYDESC) {
                this.CREATEBYDESC = CREATEBYDESC;
            }

            public String getCREATEDATE() {
                return CREATEDATE;
            }

            public void setCREATEDATE(String CREATEDATE) {
                this.CREATEDATE = CREATEDATE;
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

            public String getENDDATEDESC() {
                return ENDDATEDESC;
            }

            public void setENDDATEDESC(String ENDDATEDESC) {
                this.ENDDATEDESC = ENDDATEDESC;
            }

            public String getREMARK() {
                return REMARK;
            }

            public void setREMARK(String REMARK) {
                this.REMARK = REMARK;
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

            public String getTOTALCOST() {
                return TOTALCOST;
            }

            public void setTOTALCOST(String TOTALCOST) {
                this.TOTALCOST = TOTALCOST;
            }

            public String getUDBGNUM() {
                return UDBGNUM;
            }

            public void setUDBGNUM(String UDBGNUM) {
                this.UDBGNUM = UDBGNUM;
            }

            public int getUDPURCHBGID() {
                return UDPURCHBGID;
            }

            public void setUDPURCHBGID(int UDPURCHBGID) {
                this.UDPURCHBGID = UDPURCHBGID;
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
