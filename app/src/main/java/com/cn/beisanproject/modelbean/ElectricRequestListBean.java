package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class ElectricRequestListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ASSETNUM":"1017","ASSETSTATUS":"操作中","CCDW":"无","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-03 15:43:04","JD_POSUDIAPPLYID":5,"JD_POSUDIAPPLYNUM":"xxx-2024","NAME":"测试","REMARKS":"无","SM":"180（26）","SSDW":"集运公司","STATUS":"待领导审核","SXSH":"2020-04-13 15:44:13","SYDD":"集运公司","SYDW":"无","TYPEDL":"变电所","TYPEXL":"110千伏","TZJE":"0.00","XH":"XXX00023","ZZC":"测试"},{"ASSETNUM":"1016","ASSETSTATUS":"活动","CCDW":"测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-03 15:16:44","JD_POSUDIAPPLYID":4,"JD_POSUDIAPPLYNUM":"测试","NAME":"35kv变电所","REMARKS":"无","SM":"35kv","SSDW":"港强公司","STATUS":"已确认","SXSH":"2020-04-01 15:21:07","SYDD":"北三集司","SYDW":"测试","TYPEDL":"变电所","TYPEXL":"35千伏","TZJE":"0.00","XH":"0","ZZC":"测试"},{"ASSETNUM":"1038","ASSETSTATUS":"有限制的使用","CCDW":"","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-06-05 12:25:31","JD_POSUDIAPPLYID":101,"JD_POSUDIAPPLYNUM":"tt6","NAME":"sd","REMARKS":"","SM":"asdf","SSDW":"北一集司","STATUS":"待领导审核","SXSH":"","SYDD":"g","SYDW":"","TYPEDL":"高压开关柜","TYPEXL":"20千伏","TZJE":"0.00","XH":"ed","ZZC":"ggg"}],"showcount":20,"totalpage":1,"totalresult":3}
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
         * resultlist : [{"ASSETNUM":"1017","ASSETSTATUS":"操作中","CCDW":"无","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-03 15:43:04","JD_POSUDIAPPLYID":5,"JD_POSUDIAPPLYNUM":"xxx-2024","NAME":"测试","REMARKS":"无","SM":"180（26）","SSDW":"集运公司","STATUS":"待领导审核","SXSH":"2020-04-13 15:44:13","SYDD":"集运公司","SYDW":"无","TYPEDL":"变电所","TYPEXL":"110千伏","TZJE":"0.00","XH":"XXX00023","ZZC":"测试"},{"ASSETNUM":"1016","ASSETSTATUS":"活动","CCDW":"测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-03 15:16:44","JD_POSUDIAPPLYID":4,"JD_POSUDIAPPLYNUM":"测试","NAME":"35kv变电所","REMARKS":"无","SM":"35kv","SSDW":"港强公司","STATUS":"已确认","SXSH":"2020-04-01 15:21:07","SYDD":"北三集司","SYDW":"测试","TYPEDL":"变电所","TYPEXL":"35千伏","TZJE":"0.00","XH":"0","ZZC":"测试"},{"ASSETNUM":"1038","ASSETSTATUS":"有限制的使用","CCDW":"","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-06-05 12:25:31","JD_POSUDIAPPLYID":101,"JD_POSUDIAPPLYNUM":"tt6","NAME":"sd","REMARKS":"","SM":"asdf","SSDW":"北一集司","STATUS":"待领导审核","SXSH":"","SYDD":"g","SYDW":"","TYPEDL":"高压开关柜","TYPEXL":"20千伏","TZJE":"0.00","XH":"ed","ZZC":"ggg"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 3
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
             * ASSETNUM : 1017
             * ASSETSTATUS : 操作中
             * CCDW : 无
             * ENTERBY : MAXADMIN
             * ENTERBYDESC : 系统管理员
             * ENTERDATE : 2020-04-03 15:43:04
             * JD_POSUDIAPPLYID : 5
             * JD_POSUDIAPPLYNUM : xxx-2024
             * NAME : 测试
             * REMARKS : 无
             * SM : 180（26）
             * SSDW : 集运公司
             * STATUS : 待领导审核
             * SXSH : 2020-04-13 15:44:13
             * SYDD : 集运公司
             * SYDW : 无
             * TYPEDL : 变电所
             * TYPEXL : 110千伏
             * TZJE : 0.00
             * XH : XXX00023
             * ZZC : 测试
             */

            private String ASSETNUM;
            private String ASSETSTATUS;
            private String CCDW;
            private String ENTERBY;
            private String ENTERBYDESC;
            private String ENTERDATE;
            private int JD_POSUDIAPPLYID;
            private String JD_POSUDIAPPLYNUM;
            private String NAME;
            private String REMARKS;
            private String SM;
            private String SSDW;
            private String STATUS;
            private String SXSH;
            private String SYDD;
            private String SYDW;
            private String TYPEDL;
            private String TYPEXL;
            private String TZJE;
            private String XH;
            private String ZZC;

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

            public String getCCDW() {
                return CCDW;
            }

            public void setCCDW(String CCDW) {
                this.CCDW = CCDW;
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

            public int getJD_POSUDIAPPLYID() {
                return JD_POSUDIAPPLYID;
            }

            public void setJD_POSUDIAPPLYID(int JD_POSUDIAPPLYID) {
                this.JD_POSUDIAPPLYID = JD_POSUDIAPPLYID;
            }

            public String getJD_POSUDIAPPLYNUM() {
                return JD_POSUDIAPPLYNUM;
            }

            public void setJD_POSUDIAPPLYNUM(String JD_POSUDIAPPLYNUM) {
                this.JD_POSUDIAPPLYNUM = JD_POSUDIAPPLYNUM;
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

            public String getSM() {
                return SM;
            }

            public void setSM(String SM) {
                this.SM = SM;
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

            public String getSXSH() {
                return SXSH;
            }

            public void setSXSH(String SXSH) {
                this.SXSH = SXSH;
            }

            public String getSYDD() {
                return SYDD;
            }

            public void setSYDD(String SYDD) {
                this.SYDD = SYDD;
            }

            public String getSYDW() {
                return SYDW;
            }

            public void setSYDW(String SYDW) {
                this.SYDW = SYDW;
            }

            public String getTYPEDL() {
                return TYPEDL;
            }

            public void setTYPEDL(String TYPEDL) {
                this.TYPEDL = TYPEDL;
            }

            public String getTYPEXL() {
                return TYPEXL;
            }

            public void setTYPEXL(String TYPEXL) {
                this.TYPEXL = TYPEXL;
            }

            public String getTZJE() {
                return TZJE;
            }

            public void setTZJE(String TZJE) {
                this.TZJE = TZJE;
            }

            public String getXH() {
                return XH;
            }

            public void setXH(String XH) {
                this.XH = XH;
            }

            public String getZZC() {
                return ZZC;
            }

            public void setZZC(String ZZC) {
                this.ZZC = ZZC;
            }
        }
    }
}
