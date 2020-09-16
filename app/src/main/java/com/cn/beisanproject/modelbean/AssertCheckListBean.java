package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class AssertCheckListBean implements Serializable {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ENDDATE":"2020-05-22 12:16:00","FIXPDNUM":"1027","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-05-22 12:16:00","STARTDATE":"2020-05-22 12:16:00"},{"ENDDATE":"2020-05-24 12:16:00","FIXPDNUM":"1029","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-05-24 12:16:00","STARTDATE":"2020-05-24 12:16:00"},{"ENDDATE":"2020-06-01 12:16:00","FIXPDNUM":"1037","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-01 12:16:00","STARTDATE":"2020-06-01 12:16:00"},{"ENDDATE":"2020-06-02 12:16:00","FIXPDNUM":"1038","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-02 12:16:00","STARTDATE":"2020-06-02 12:16:00"},{"ENDDATE":"2020-06-04 15:26:07","FIXPDNUM":"1040","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-04 15:26:07","STARTDATE":"2020-06-04 15:26:07"},{"ENDDATE":"2020-06-07 12:16:00","FIXPDNUM":"1043","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-07 12:16:00","STARTDATE":"2020-06-07 12:16:00"},{"ENDDATE":"2020-06-09 12:16:00","FIXPDNUM":"1045","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-09 12:16:00","STARTDATE":"2020-06-09 12:16:00"},{"ENDDATE":"2020-06-18 12:16:00","FIXPDNUM":"1054","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-18 12:16:00","STARTDATE":"2020-06-18 12:16:00"},{"ENDDATE":"2020-06-24 12:16:00","FIXPDNUM":"1060","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-24 12:16:00","STARTDATE":"2020-06-24 12:16:00"},{"ENDDATE":"2020-07-02 12:16:00","FIXPDNUM":"1068","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-07-02 12:16:00","STARTDATE":"2020-07-02 12:16:00"},{"ENDDATE":"2020-07-03 12:16:00","FIXPDNUM":"1069","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-07-03 12:16:00","STARTDATE":"2020-07-03 12:16:00"},{"ENDDATE":"2020-07-04 12:16:00","FIXPDNUM":"1070","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-07-04 12:16:00","STARTDATE":"2020-07-04 12:16:00"},{"ENDDATE":"2020-07-06 12:16:00","FIXPDNUM":"1072","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-07-06 12:16:00","STARTDATE":"2020-07-06 12:16:00"},{"ENDDATE":"2020-05-07 12:16:00","FIXPDNUM":"1020","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-05-07 12:16:00","STARTDATE":"2020-05-07 12:16:00"},{"ENDDATE":"2020-05-23 12:16:00","FIXPDNUM":"1028","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-05-23 12:16:00","STARTDATE":"2020-05-23 12:16:00"}]}
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

    public static class ResultBean implements Serializable{
        /**
         * curpage : 1
         * resultlist : [{"ENDDATE":"2020-05-22 12:16:00","FIXPDNUM":"1027","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-05-22 12:16:00","STARTDATE":"2020-05-22 12:16:00"},{"ENDDATE":"2020-05-24 12:16:00","FIXPDNUM":"1029","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-05-24 12:16:00","STARTDATE":"2020-05-24 12:16:00"},{"ENDDATE":"2020-06-01 12:16:00","FIXPDNUM":"1037","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-01 12:16:00","STARTDATE":"2020-06-01 12:16:00"},{"ENDDATE":"2020-06-02 12:16:00","FIXPDNUM":"1038","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-02 12:16:00","STARTDATE":"2020-06-02 12:16:00"},{"ENDDATE":"2020-06-04 15:26:07","FIXPDNUM":"1040","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-04 15:26:07","STARTDATE":"2020-06-04 15:26:07"},{"ENDDATE":"2020-06-07 12:16:00","FIXPDNUM":"1043","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-07 12:16:00","STARTDATE":"2020-06-07 12:16:00"},{"ENDDATE":"2020-06-09 12:16:00","FIXPDNUM":"1045","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-09 12:16:00","STARTDATE":"2020-06-09 12:16:00"},{"ENDDATE":"2020-06-18 12:16:00","FIXPDNUM":"1054","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-18 12:16:00","STARTDATE":"2020-06-18 12:16:00"},{"ENDDATE":"2020-06-24 12:16:00","FIXPDNUM":"1060","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-06-24 12:16:00","STARTDATE":"2020-06-24 12:16:00"},{"ENDDATE":"2020-07-02 12:16:00","FIXPDNUM":"1068","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-07-02 12:16:00","STARTDATE":"2020-07-02 12:16:00"},{"ENDDATE":"2020-07-03 12:16:00","FIXPDNUM":"1069","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-07-03 12:16:00","STARTDATE":"2020-07-03 12:16:00"},{"ENDDATE":"2020-07-04 12:16:00","FIXPDNUM":"1070","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-07-04 12:16:00","STARTDATE":"2020-07-04 12:16:00"},{"ENDDATE":"2020-07-06 12:16:00","FIXPDNUM":"1072","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-07-06 12:16:00","STARTDATE":"2020-07-06 12:16:00"},{"ENDDATE":"2020-05-07 12:16:00","FIXPDNUM":"1020","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-05-07 12:16:00","STARTDATE":"2020-05-07 12:16:00"},{"ENDDATE":"2020-05-23 12:16:00","FIXPDNUM":"1028","MEMO":"此次盘点由系统自动进行,请仔细核对.","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"等待核准","PDZTDATE":"2020-05-23 12:16:00","STARTDATE":"2020-05-23 12:16:00"}]
         */

        private int curpage;
        private List<ResultlistBean> resultlist;

        public int getCurpage() {
            return curpage;
        }

        public void setCurpage(int curpage) {
            this.curpage = curpage;
        }

        public List<ResultlistBean> getResultlist() {
            return resultlist;
        }

        public void setResultlist(List<ResultlistBean> resultlist) {
            this.resultlist = resultlist;
        }

        public static class ResultlistBean implements Serializable{
            /**
             * ENDDATE : 2020-05-22 12:16:00
             * FIXPDNUM : 1027
             * MEMO : 此次盘点由系统自动进行,请仔细核对.
             * PDUSER : MAXADMIN
             * PDUSERDESC : 系统管理员
             * PDZT : 等待核准
             * PDZTDATE : 2020-05-22 12:16:00
             * STARTDATE : 2020-05-22 12:16:00
             */

            private String ENDDATE;
            private String FIXPDNUM;
            private String MEMO;
            private String PDUSER;
            private String PDUSERDESC;
            private String PDZT;
            private String PDZTDATE;
            private String STARTDATE;

            public String getENDDATE() {
                return ENDDATE;
            }

            public void setENDDATE(String ENDDATE) {
                this.ENDDATE = ENDDATE;
            }

            public String getFIXPDNUM() {
                return FIXPDNUM;
            }

            public void setFIXPDNUM(String FIXPDNUM) {
                this.FIXPDNUM = FIXPDNUM;
            }

            public String getMEMO() {
                return MEMO;
            }

            public void setMEMO(String MEMO) {
                this.MEMO = MEMO;
            }

            public String getPDUSER() {
                return PDUSER;
            }

            public void setPDUSER(String PDUSER) {
                this.PDUSER = PDUSER;
            }

            public String getPDUSERDESC() {
                return PDUSERDESC;
            }

            public void setPDUSERDESC(String PDUSERDESC) {
                this.PDUSERDESC = PDUSERDESC;
            }

            public String getPDZT() {
                return PDZT;
            }

            public void setPDZT(String PDZT) {
                this.PDZT = PDZT;
            }

            public String getPDZTDATE() {
                return PDZTDATE;
            }

            public void setPDZTDATE(String PDZTDATE) {
                this.PDZTDATE = PDZTDATE;
            }

            public String getSTARTDATE() {
                return STARTDATE;
            }

            public void setSTARTDATE(String STARTDATE) {
                this.STARTDATE = STARTDATE;
            }
        }
    }
}
