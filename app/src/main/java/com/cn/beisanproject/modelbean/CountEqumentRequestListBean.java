package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class CountEqumentRequestListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ASSETNUM":"1065","ASSETSTATUS":"不活动","AZDZ":"安装使用地点及用途","CLFW":"测量范围","DJ":"3","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-07-24 17:16:47","JD_MEASUREMENTID":125,"JD_MEASUREMENTNUM":"出厂编号","NAME":"设备名称","REMARKS":"","SCCJ":"生产厂家","SSDW":"集运公司","STATUS":"驳回","SYDW":"","XH":"型号规格","XZDATE":"","XZSTATUS":"检定\\校准状态","YNDWGL":""}],"showcount":1,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"ASSETNUM":"1065","ASSETSTATUS":"不活动","AZDZ":"安装使用地点及用途","CLFW":"测量范围","DJ":"3","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-07-24 17:16:47","JD_MEASUREMENTID":125,"JD_MEASUREMENTNUM":"出厂编号","NAME":"设备名称","REMARKS":"","SCCJ":"生产厂家","SSDW":"集运公司","STATUS":"驳回","SYDW":"","XH":"型号规格","XZDATE":"","XZSTATUS":"检定\\校准状态","YNDWGL":""}]
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

        public static class ResultlistBean implements Serializable {
            /**
             * ASSETNUM : 1065
             * ASSETSTATUS : 不活动
             * AZDZ : 安装使用地点及用途
             * CLFW : 测量范围
             * DJ : 3
             * ENTERBY : MAXADMIN
             * ENTERBYDESC : 系统管理员
             * ENTERDATE : 2020-07-24 17:16:47
             * JD_MEASUREMENTID : 125
             * JD_MEASUREMENTNUM : 出厂编号
             * NAME : 设备名称
             * REMARKS :
             * SCCJ : 生产厂家
             * SSDW : 集运公司
             * STATUS : 驳回
             * SYDW :
             * XH : 型号规格
             * XZDATE :
             * XZSTATUS : 检定\校准状态
             * YNDWGL :
             */

            private String ASSETNUM;
            private String ASSETSTATUS;
            private String AZDZ;
            private String CLFW;
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

            public String getCLFW() {
                return CLFW;
            }

            public void setCLFW(String CLFW) {
                this.CLFW = CLFW;
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
