package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class WaitDoListBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"APP":"RFQ","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,585","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"app流程测试 询价单号：2519","NODEID":"4","OWNERID":15969,"OWNERTABLE":"RFQ","PROCESSNAME":"RFQ","ROLEID":"ORIGINATOR","STARTDATE":"2020-06-15 13:25:49","WFASSIGNMENTID":"9,876,965","WFID":"227,364"},{"APP":"RFQ","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,583","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"app流程测试 询价单号：2517","NODEID":"4","OWNERID":15958,"OWNERTABLE":"RFQ","PROCESSNAME":"RFQ","ROLEID":"ORIGINATOR","STARTDATE":"2020-06-15 12:09:55","WFASSIGNMENTID":"9,876,963","WFID":"227,363"},{"APP":"RFQ","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,577","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"app流程测试 询价单号：2518","NODEID":"4","OWNERID":15968,"OWNERTABLE":"RFQ","PROCESSNAME":"RFQ","ROLEID":"ORIGINATOR","STARTDATE":"2020-06-15 09:49:07","WFASSIGNMENTID":"9,876,955","WFID":"227,359"},{"APP":"UDXMHTBG","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,486","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"项目合同变更审批","NODEID":"5","OWNERID":47,"OWNERTABLE":"UDPURCHBG","PROCESSNAME":"UDXMHTBG","ROLEID":"MAXADMIN","STARTDATE":"2020-06-11 16:08:27","WFASSIGNMENTID":"9,876,857","WFID":"227,322"},{"APP":"UDXMHTBG","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,485","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"项目合同变更审批","NODEID":"5","OWNERID":46,"OWNERTABLE":"UDPURCHBG","PROCESSNAME":"UDXMHTBG","ROLEID":"MAXADMIN","STARTDATE":"2020-06-11 16:07:41","WFASSIGNMENTID":"9,876,856","WFID":"227,321"},{"APP":"UDXMHTBG","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,484","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"项目合同变更审批","NODEID":"5","OWNERID":45,"OWNERTABLE":"UDPURCHBG","PROCESSNAME":"UDXMHTBG","ROLEID":"MAXADMIN","STARTDATE":"2020-06-11 16:05:58","WFASSIGNMENTID":"9,876,855","WFID":"227,320"},{"APP":"UDXMHTBG","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,483","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"项目合同变更审批","NODEID":"5","OWNERID":44,"OWNERTABLE":"UDPURCHBG","PROCESSNAME":"UDXMHTBG","ROLEID":"MAXADMIN","STARTDATE":"2020-06-11 16:01:23","WFASSIGNMENTID":"9,876,854","WFID":"227,319"},{"APP":"RFQ","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,379","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"杨鑫测试询价单0225 询价单号：2499","NODEID":"4","OWNERID":15790,"OWNERTABLE":"RFQ","PROCESSNAME":"RFQ","ROLEID":"ORIGINATOR","STARTDATE":"2020-06-04 17:19:39","WFASSIGNMENTID":"9,876,277","WFID":"227,240"}],"showcount":20,"totalpage":1,"totalresult":8}
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
         * resultlist : [{"APP":"RFQ","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,585","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"app流程测试 询价单号：2519","NODEID":"4","OWNERID":15969,"OWNERTABLE":"RFQ","PROCESSNAME":"RFQ","ROLEID":"ORIGINATOR","STARTDATE":"2020-06-15 13:25:49","WFASSIGNMENTID":"9,876,965","WFID":"227,364"},{"APP":"RFQ","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,583","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"app流程测试 询价单号：2517","NODEID":"4","OWNERID":15958,"OWNERTABLE":"RFQ","PROCESSNAME":"RFQ","ROLEID":"ORIGINATOR","STARTDATE":"2020-06-15 12:09:55","WFASSIGNMENTID":"9,876,963","WFID":"227,363"},{"APP":"RFQ","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,577","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"app流程测试 询价单号：2518","NODEID":"4","OWNERID":15968,"OWNERTABLE":"RFQ","PROCESSNAME":"RFQ","ROLEID":"ORIGINATOR","STARTDATE":"2020-06-15 09:49:07","WFASSIGNMENTID":"9,876,955","WFID":"227,359"},{"APP":"UDXMHTBG","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,486","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"项目合同变更审批","NODEID":"5","OWNERID":47,"OWNERTABLE":"UDPURCHBG","PROCESSNAME":"UDXMHTBG","ROLEID":"MAXADMIN","STARTDATE":"2020-06-11 16:08:27","WFASSIGNMENTID":"9,876,857","WFID":"227,322"},{"APP":"UDXMHTBG","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,485","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"项目合同变更审批","NODEID":"5","OWNERID":46,"OWNERTABLE":"UDPURCHBG","PROCESSNAME":"UDXMHTBG","ROLEID":"MAXADMIN","STARTDATE":"2020-06-11 16:07:41","WFASSIGNMENTID":"9,876,856","WFID":"227,321"},{"APP":"UDXMHTBG","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,484","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"项目合同变更审批","NODEID":"5","OWNERID":45,"OWNERTABLE":"UDPURCHBG","PROCESSNAME":"UDXMHTBG","ROLEID":"MAXADMIN","STARTDATE":"2020-06-11 16:05:58","WFASSIGNMENTID":"9,876,855","WFID":"227,320"},{"APP":"UDXMHTBG","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,483","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"项目合同变更审批","NODEID":"5","OWNERID":44,"OWNERTABLE":"UDPURCHBG","PROCESSNAME":"UDXMHTBG","ROLEID":"MAXADMIN","STARTDATE":"2020-06-11 16:01:23","WFASSIGNMENTID":"9,876,854","WFID":"227,319"},{"APP":"RFQ","ASSIGNCODE":"MAXADMIN","ASSIGNDESC":"系统管理员","ASSIGNID":"9,874,379","ASSIGNSTATUS":"活动","ASSIGNTITLE":"","DESCRIPTION":"杨鑫测试询价单0225 询价单号：2499","NODEID":"4","OWNERID":15790,"OWNERTABLE":"RFQ","PROCESSNAME":"RFQ","ROLEID":"ORIGINATOR","STARTDATE":"2020-06-04 17:19:39","WFASSIGNMENTID":"9,876,277","WFID":"227,240"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 8
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
             * APP : RFQ
             * ASSIGNCODE : MAXADMIN
             * ASSIGNDESC : 系统管理员
             * ASSIGNID : 9,874,585
             * ASSIGNSTATUS : 活动
             * ASSIGNTITLE :
             * DESCRIPTION : app流程测试 询价单号：2519
             * NODEID : 4
             * OWNERID : 15969
             * OWNERTABLE : RFQ
             * PROCESSNAME : RFQ
             * ROLEID : ORIGINATOR
             * STARTDATE : 2020-06-15 13:25:49
             * WFASSIGNMENTID : 9,876,965
             * WFID : 227,364
             */

            private String APP;
            private String ASSIGNCODE;
            private String ASSIGNDESC;
            private String ASSIGNID;
            private String ASSIGNSTATUS;
            private String ASSIGNTITLE;
            private String DESCRIPTION;
            private String NODEID;
            private int OWNERID;
            private String OWNERTABLE;
            private String PROCESSNAME;
            private String ROLEID;
            private String STARTDATE;
            private String WFASSIGNMENTID;
            private String WFID;

            public Boolean getChecked() {
                return isChecked;
            }

            public void setChecked(Boolean checked) {
                isChecked = checked;
            }

            private Boolean isChecked;

            public String getAPP() {
                return APP;
            }

            public void setAPP(String APP) {
                this.APP = APP;
            }

            public String getASSIGNCODE() {
                return ASSIGNCODE;
            }

            public void setASSIGNCODE(String ASSIGNCODE) {
                this.ASSIGNCODE = ASSIGNCODE;
            }

            public String getASSIGNDESC() {
                return ASSIGNDESC;
            }

            public void setASSIGNDESC(String ASSIGNDESC) {
                this.ASSIGNDESC = ASSIGNDESC;
            }

            public String getASSIGNID() {
                return ASSIGNID;
            }

            public void setASSIGNID(String ASSIGNID) {
                this.ASSIGNID = ASSIGNID;
            }

            public String getASSIGNSTATUS() {
                return ASSIGNSTATUS;
            }

            public void setASSIGNSTATUS(String ASSIGNSTATUS) {
                this.ASSIGNSTATUS = ASSIGNSTATUS;
            }

            public String getASSIGNTITLE() {
                return ASSIGNTITLE;
            }

            public void setASSIGNTITLE(String ASSIGNTITLE) {
                this.ASSIGNTITLE = ASSIGNTITLE;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getNODEID() {
                return NODEID;
            }

            public void setNODEID(String NODEID) {
                this.NODEID = NODEID;
            }

            public int getOWNERID() {
                return OWNERID;
            }

            public void setOWNERID(int OWNERID) {
                this.OWNERID = OWNERID;
            }

            public String getOWNERTABLE() {
                return OWNERTABLE;
            }

            public void setOWNERTABLE(String OWNERTABLE) {
                this.OWNERTABLE = OWNERTABLE;
            }

            public String getPROCESSNAME() {
                return PROCESSNAME;
            }

            public void setPROCESSNAME(String PROCESSNAME) {
                this.PROCESSNAME = PROCESSNAME;
            }

            public String getROLEID() {
                return ROLEID;
            }

            public void setROLEID(String ROLEID) {
                this.ROLEID = ROLEID;
            }

            public String getSTARTDATE() {
                return STARTDATE;
            }

            public void setSTARTDATE(String STARTDATE) {
                this.STARTDATE = STARTDATE;
            }

            public String getWFASSIGNMENTID() {
                return WFASSIGNMENTID;
            }

            public void setWFASSIGNMENTID(String WFASSIGNMENTID) {
                this.WFASSIGNMENTID = WFASSIGNMENTID;
            }

            public String getWFID() {
                return WFID;
            }

            public void setWFID(String WFID) {
                this.WFID = WFID;
            }
        }
    }
}
