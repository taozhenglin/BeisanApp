package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class CountEqmentRequestListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ASSETNUM":"1037","ASSETSTATUS":"停止使用","AZDZ":"g","DJ":"1","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-06-05 12:24:51","JD_MEASUREMENTID":102,"JD_MEASUREMENTNUM":"3","NAME":"pc","REMARKS":"","SCCJ":"212","SSDW":"梅山公司","STATUS":"待领导审核","SYDW":"","XH":"pc001","XZDATE":"","XZSTATUS":"dd","YNDWGL":""},{"ASSETNUM":"1013","ASSETSTATUS":"活动","AZDZ":"灵昆2#水泵房","DJ":"2","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-03 14:19:59","JD_MEASUREMENTID":4,"JD_MEASUREMENTNUM":"1309055505","NAME":"三相电子式电能表","REMARKS":"无","SCCJ":"瑞安三能仪表有限公司","SSDW":"宁波外理","STATUS":"待领导审核","SYDW":"宁波外理集团龙湾公司","XH":"dts938","XZDATE":"2021-04-07 14:23:26","XZSTATUS":"合格","YNDWGL":""},{"ASSETNUM":"1014","ASSETSTATUS":"活动","AZDZ":"东卡口3#道集卡称重","DJ":"3","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-03 14:40:31","JD_MEASUREMENTID":5,"JD_MEASUREMENTNUM":"B7438596","NAME":"全电子汽车衡","REMARKS":"无","SCCJ":"梅特勒-托利多称重设备有限公司","SSDW":"北二集司","STATUS":"等待批准","SYDW":"北二集司","XH":"SCS-80","XZDATE":"2020-04-08 14:44:19","XZSTATUS":"3级合格","YNDWGL":""},{"ASSETNUM":"1033","ASSETSTATUS":"中断","AZDZ":"1","DJ":"1","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-06-05 09:15:29","JD_MEASUREMENTID":101,"JD_MEASUREMENTNUM":"1","NAME":"1","REMARKS":"","SCCJ":"1","SSDW":"宁波远洋","STATUS":"已确认","SYDW":"","XH":"1","XZDATE":"","XZSTATUS":"1","YNDWGL":""}],"showcount":20,"totalpage":1,"totalresult":4}
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
         * resultlist : [{"ASSETNUM":"1037","ASSETSTATUS":"停止使用","AZDZ":"g","DJ":"1","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-06-05 12:24:51","JD_MEASUREMENTID":102,"JD_MEASUREMENTNUM":"3","NAME":"pc","REMARKS":"","SCCJ":"212","SSDW":"梅山公司","STATUS":"待领导审核","SYDW":"","XH":"pc001","XZDATE":"","XZSTATUS":"dd","YNDWGL":""},{"ASSETNUM":"1013","ASSETSTATUS":"活动","AZDZ":"灵昆2#水泵房","DJ":"2","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-03 14:19:59","JD_MEASUREMENTID":4,"JD_MEASUREMENTNUM":"1309055505","NAME":"三相电子式电能表","REMARKS":"无","SCCJ":"瑞安三能仪表有限公司","SSDW":"宁波外理","STATUS":"待领导审核","SYDW":"宁波外理集团龙湾公司","XH":"dts938","XZDATE":"2021-04-07 14:23:26","XZSTATUS":"合格","YNDWGL":""},{"ASSETNUM":"1014","ASSETSTATUS":"活动","AZDZ":"东卡口3#道集卡称重","DJ":"3","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-03 14:40:31","JD_MEASUREMENTID":5,"JD_MEASUREMENTNUM":"B7438596","NAME":"全电子汽车衡","REMARKS":"无","SCCJ":"梅特勒-托利多称重设备有限公司","SSDW":"北二集司","STATUS":"等待批准","SYDW":"北二集司","XH":"SCS-80","XZDATE":"2020-04-08 14:44:19","XZSTATUS":"3级合格","YNDWGL":""},{"ASSETNUM":"1033","ASSETSTATUS":"中断","AZDZ":"1","DJ":"1","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-06-05 09:15:29","JD_MEASUREMENTID":101,"JD_MEASUREMENTNUM":"1","NAME":"1","REMARKS":"","SCCJ":"1","SSDW":"宁波远洋","STATUS":"已确认","SYDW":"","XH":"1","XZDATE":"","XZSTATUS":"1","YNDWGL":""}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 4
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
             * ASSETNUM : 1037
             * ASSETSTATUS : 停止使用
             * AZDZ : g
             * DJ : 1
             * ENTERBY : MAXADMIN
             * ENTERBYDESC : 系统管理员
             * ENTERDATE : 2020-06-05 12:24:51
             * JD_MEASUREMENTID : 102
             * JD_MEASUREMENTNUM : 3
             * NAME : pc
             * REMARKS :
             * SCCJ : 212
             * SSDW : 梅山公司
             * STATUS : 待领导审核
             * SYDW :
             * XH : pc001
             * XZDATE :
             * XZSTATUS : dd
             * YNDWGL :
             */

            private String ASSETNUM;
            private String ASSETSTATUS;
            private String AZDZ;
            private String DJ;
            private String ENTERBY;
            private String ENTERBYDESC;
            private String ENTERDATE;
            private int JD_MEASUREMENTID;
            private String JD_MEASUREMENTNUM;
            private String NAME;
            private String REMARKS;
            private String SCCJ;
            private String SSDW;
            private String STATUS;
            private String SYDW;
            private String XH;
            private String XZDATE;
            private String XZSTATUS;
            private String YNDWGL;

            public String getASSETNUM() {
                return ASSETNUM;
            }

            public void setASSETNUM(String ASSETNUM) {
                this.ASSETNUM = ASSETNUM;
            }

            public String getASSETSTATUS() {
                return ASSETSTATUS;
            }

            public void setASSETSTATUS(String ASSETSTATUS) {
                this.ASSETSTATUS = ASSETSTATUS;
            }

            public String getAZDZ() {
                return AZDZ;
            }

            public void setAZDZ(String AZDZ) {
                this.AZDZ = AZDZ;
            }

            public String getDJ() {
                return DJ;
            }

            public void setDJ(String DJ) {
                this.DJ = DJ;
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

            public String getENTERDATE() {
                return ENTERDATE;
            }

            public void setENTERDATE(String ENTERDATE) {
                this.ENTERDATE = ENTERDATE;
            }

            public int getJD_MEASUREMENTID() {
                return JD_MEASUREMENTID;
            }

            public void setJD_MEASUREMENTID(int JD_MEASUREMENTID) {
                this.JD_MEASUREMENTID = JD_MEASUREMENTID;
            }

            public String getJD_MEASUREMENTNUM() {
                return JD_MEASUREMENTNUM;
            }

            public void setJD_MEASUREMENTNUM(String JD_MEASUREMENTNUM) {
                this.JD_MEASUREMENTNUM = JD_MEASUREMENTNUM;
            }

            public String getNAME() {
                return NAME;
            }

            public void setNAME(String NAME) {
                this.NAME = NAME;
            }

            public String getREMARKS() {
                return REMARKS;
            }

            public void setREMARKS(String REMARKS) {
                this.REMARKS = REMARKS;
            }

            public String getSCCJ() {
                return SCCJ;
            }

            public void setSCCJ(String SCCJ) {
                this.SCCJ = SCCJ;
            }

            public String getSSDW() {
                return SSDW;
            }

            public void setSSDW(String SSDW) {
                this.SSDW = SSDW;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getSYDW() {
                return SYDW;
            }

            public void setSYDW(String SYDW) {
                this.SYDW = SYDW;
            }

            public String getXH() {
                return XH;
            }

            public void setXH(String XH) {
                this.XH = XH;
            }

            public String getXZDATE() {
                return XZDATE;
            }

            public void setXZDATE(String XZDATE) {
                this.XZDATE = XZDATE;
            }

            public String getXZSTATUS() {
                return XZSTATUS;
            }

            public void setXZSTATUS(String XZSTATUS) {
                this.XZSTATUS = XZSTATUS;
            }

            public String getYNDWGL() {
                return YNDWGL;
            }

            public void setYNDWGL(String YNDWGL) {
                this.YNDWGL = YNDWGL;
            }
        }
    }
}
