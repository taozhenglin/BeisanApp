package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class FacilityRequestDetailBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ASSETNUM":"1056","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-23 17:18:09","DJJC":"qert","DYTDZH":"324","EQUNUM":"","JCTCRQ":"2020-07-01","JD_SSTZID":282,"JGYSZLDJ":"ew","JZMJ":"23.00","MCJG":"ewr","MQJSDJ":"三类","NAME":"234","QZH":"453","SGDW":"wer","SJDW":"wer","SSDL":"堆场","SSDW":"北三集司","SSZL":"房屋","STATUS":"取消","SYDW":"","SZDZ":"trqet","YT":"eqwr","YXMJ":"324.00","ZCYZ":""}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"ASSETNUM":"1056","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-23 17:18:09","DJJC":"qert","DYTDZH":"324","EQUNUM":"","JCTCRQ":"2020-07-01","JD_SSTZID":282,"JGYSZLDJ":"ew","JZMJ":"23.00","MCJG":"ewr","MQJSDJ":"三类","NAME":"234","QZH":"453","SGDW":"wer","SJDW":"wer","SSDL":"堆场","SSDW":"北三集司","SSZL":"房屋","STATUS":"取消","SYDW":"","SZDZ":"trqet","YT":"eqwr","YXMJ":"324.00","ZCYZ":""}]
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
             * ASSETNUM : 1056
             * CREATEBY : MAXADMIN
             * CREATEBYDESC : 系统管理员
             * CREATETIME : 2020-07-23 17:18:09
             * DJJC : qert
             * DYTDZH : 324
             * EQUNUM :
             * JCTCRQ : 2020-07-01
             * JD_SSTZID : 282
             * JGYSZLDJ : ew
             * JZMJ : 23.00
             * MCJG : ewr
             * MQJSDJ : 三类
             * NAME : 234
             * QZH : 453
             * SGDW : wer
             * SJDW : wer
             * SSDL : 堆场
             * SSDW : 北三集司
             * SSZL : 房屋
             * STATUS : 取消
             * SYDW :
             * SZDZ : trqet
             * YT : eqwr
             * YXMJ : 324.00
             * ZCYZ :
             */

            private String ASSETNUM;
            private String CREATEBY;
            private String CREATEBYDESC;
            private String CREATETIME;
            private String DJJC;
            private String DYTDZH;
            private String EQUNUM;
            private String JCTCRQ;
            private int JD_SSTZID;
            private String JGYSZLDJ;
            private String JZMJ;
            private String MCJG;
            private String MQJSDJ;
            private String NAME;
            private String QZH;
            private String SGDW;
            private String SJDW;
            private String SSDL;
            private String SSDW;
            private String SSZL;
            private String STATUS;
            private String SYDW;
            private String SZDZ;
            private String YT;
            private String YXMJ;
            private String ZCYZ;

            public String getASSETNUM() {
                return ASSETNUM;
            }

            public void setASSETNUM(String ASSETNUM) {
                this.ASSETNUM = ASSETNUM;
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

            public String getCREATETIME() {
                return CREATETIME;
            }

            public void setCREATETIME(String CREATETIME) {
                this.CREATETIME = CREATETIME;
            }

            public String getDJJC() {
                return DJJC;
            }

            public void setDJJC(String DJJC) {
                this.DJJC = DJJC;
            }

            public String getDYTDZH() {
                return DYTDZH;
            }

            public void setDYTDZH(String DYTDZH) {
                this.DYTDZH = DYTDZH;
            }

            public String getEQUNUM() {
                return EQUNUM;
            }

            public void setEQUNUM(String EQUNUM) {
                this.EQUNUM = EQUNUM;
            }

            public String getJCTCRQ() {
                return JCTCRQ;
            }

            public void setJCTCRQ(String JCTCRQ) {
                this.JCTCRQ = JCTCRQ;
            }

            public int getJD_SSTZID() {
                return JD_SSTZID;
            }

            public void setJD_SSTZID(int JD_SSTZID) {
                this.JD_SSTZID = JD_SSTZID;
            }

            public String getJGYSZLDJ() {
                return JGYSZLDJ;
            }

            public void setJGYSZLDJ(String JGYSZLDJ) {
                this.JGYSZLDJ = JGYSZLDJ;
            }

            public String getJZMJ() {
                return JZMJ;
            }

            public void setJZMJ(String JZMJ) {
                this.JZMJ = JZMJ;
            }

            public String getMCJG() {
                return MCJG;
            }

            public void setMCJG(String MCJG) {
                this.MCJG = MCJG;
            }

            public String getMQJSDJ() {
                return MQJSDJ;
            }

            public void setMQJSDJ(String MQJSDJ) {
                this.MQJSDJ = MQJSDJ;
            }

            public String getNAME() {
                return NAME;
            }

            public void setNAME(String NAME) {
                this.NAME = NAME;
            }

            public String getQZH() {
                return QZH;
            }

            public void setQZH(String QZH) {
                this.QZH = QZH;
            }

            public String getSGDW() {
                return SGDW;
            }

            public void setSGDW(String SGDW) {
                this.SGDW = SGDW;
            }

            public String getSJDW() {
                return SJDW;
            }

            public void setSJDW(String SJDW) {
                this.SJDW = SJDW;
            }

            public String getSSDL() {
                return SSDL;
            }

            public void setSSDL(String SSDL) {
                this.SSDL = SSDL;
            }

            public String getSSDW() {
                return SSDW;
            }

            public void setSSDW(String SSDW) {
                this.SSDW = SSDW;
            }

            public String getSSZL() {
                return SSZL;
            }

            public void setSSZL(String SSZL) {
                this.SSZL = SSZL;
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

            public String getSZDZ() {
                return SZDZ;
            }

            public void setSZDZ(String SZDZ) {
                this.SZDZ = SZDZ;
            }

            public String getYT() {
                return YT;
            }

            public void setYT(String YT) {
                this.YT = YT;
            }

            public String getYXMJ() {
                return YXMJ;
            }

            public void setYXMJ(String YXMJ) {
                this.YXMJ = YXMJ;
            }

            public String getZCYZ() {
                return ZCYZ;
            }

            public void setZCYZ(String ZCYZ) {
                this.ZCYZ = ZCYZ;
            }
        }
    }
}
