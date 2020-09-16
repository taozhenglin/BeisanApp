package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class FacilityRequestListBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ASSETNUM":"1024","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 09:50:15","DJJC":"21","DYTDZH":"12","EQUNUM":"","JCTCRQ":"2020-06-02","JD_SSTZID":241,"JGYSZLDJ":"12","JZMJ":"12.00","MCJG":"12","MQJSDJ":"四类","NAME":"12","QZH":"21","SGDW":"21","SJDW":"12","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"已确认","SYDW":"","SZDZ":"21","YT":"21","YXMJ":"1.00","ZCYZ":""},{"ASSETNUM":"1048","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 09:40:32","DJJC":"地基基础","DYTDZH":"12324241111土地证号","EQUNUM":"","JCTCRQ":"2020-07-08","JD_SSTZID":262,"JGYSZLDJ":"竣工验收质量等级","JZMJ":"122.00","MCJG":"结构形式","MQJSDJ":"二类","NAME":"121","QZH":"43253443房产证号","SGDW":"施工单位","SJDW":"设计单位","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"待领导审核","SYDW":"","SZDZ":"所在地址","YT":"用途","YXMJ":"320.00","ZCYZ":""},{"ASSETNUM":"1049","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 09:42:25","DJJC":"4234244","DYTDZH":"3425432535","EQUNUM":"","JCTCRQ":"2020-07-10","JD_SSTZID":263,"JGYSZLDJ":"2343","JZMJ":"423.00","MCJG":"214","MQJSDJ":"三类","NAME":"12331","QZH":"3454325345","SGDW":"234342","SJDW":"23324","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"取消","SYDW":"","SZDZ":"14242","YT":"423412","YXMJ":"4,534.00","ZCYZ":""},{"ASSETNUM":"1050","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 09:43:39","DJJC":"63452","DYTDZH":"43255466","EQUNUM":"","JCTCRQ":"2020-07-07","JD_SSTZID":264,"JGYSZLDJ":"534","JZMJ":"123,424.00","MCJG":"654","MQJSDJ":"三类","NAME":"452","QZH":"64374654","SGDW":"65364","SJDW":"4356","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"已确认","SYDW":"","SZDZ":"64365","YT":"643667","YXMJ":"134,134.00","ZCYZ":""},{"ASSETNUM":"1051","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 09:44:58","DJJC":"13425","DYTDZH":"52354534","EQUNUM":"","JCTCRQ":"2020-07-03","JD_SSTZID":265,"JGYSZLDJ":"13524","JZMJ":"345,345,636.00","MCJG":"534345","MQJSDJ":"三类","NAME":"56444","QZH":"3425454","SGDW":"54352","SJDW":"34543","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"取消","SYDW":"","SZDZ":"2345","YT":"5432534","YXMJ":"5,435,435.00","ZCYZ":""},{"ASSETNUM":"1055","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-23 17:16:41","DJJC":"3465","DYTDZH":"342356","EQUNUM":"","JCTCRQ":"2020-07-15","JD_SSTZID":281,"JGYSZLDJ":"1","JZMJ":"32.00","MCJG":"12","MQJSDJ":"三类","NAME":"sdgfh","QZH":"25367","SGDW":"34","SJDW":"3245","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"待领导审核","SYDW":"","SZDZ":"24654","YT":"3263","YXMJ":"143.00","ZCYZ":""},{"ASSETNUM":"1056","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-23 17:18:09","DJJC":"qert","DYTDZH":"324","EQUNUM":"","JCTCRQ":"2020-07-01","JD_SSTZID":282,"JGYSZLDJ":"ew","JZMJ":"23.00","MCJG":"ewr","MQJSDJ":"三类","NAME":"234","QZH":"453","SGDW":"wer","SJDW":"wer","SSDL":"堆场","SSDW":"北三集司","SSZL":"房屋","STATUS":"取消","SYDW":"","SZDZ":"trqet","YT":"eqwr","YXMJ":"324.00","ZCYZ":""},{"ASSETNUM":"SS1001","CREATEBY":"FANGJB","CREATEBYDESC":"方剑波","CREATETIME":"2020-03-06 15:51:37","DJJC":"1","DYTDZH":"22222","EQUNUM":"","JCTCRQ":"2020-03-03","JD_SSTZID":2,"JGYSZLDJ":"1","JZMJ":"222.00","MCJG":"1","MQJSDJ":"二类","NAME":"测试","QZH":"222","SGDW":"1","SJDW":"1","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"已确认","SYDW":"","SZDZ":"1","YT":"1","YXMJ":"2,222.00","ZCYZ":""},{"ASSETNUM":"1019","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-04-13 01:01:30","DJJC":"1","DYTDZH":"1","EQUNUM":"","JCTCRQ":"2020-04-13","JD_SSTZID":142,"JGYSZLDJ":"1","JZMJ":"1.00","MCJG":"1","MQJSDJ":"二类","NAME":"堤坝及防波堤","QZH":"1","SGDW":"1","SJDW":"1","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"转运站","STATUS":"已确认","SYDW":"","SZDZ":"1","YT":"1","YXMJ":"1.00","ZCYZ":""},{"ASSETNUM":"1025","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 13:28:48","DJJC":"好","DYTDZH":"dsdf","EQUNUM":"","JCTCRQ":"2020-06-02","JD_SSTZID":242,"JGYSZLDJ":"一级","JZMJ":"20.00","MCJG":"有","MQJSDJ":"二类","NAME":"测试","QZH":"asfsdf","SGDW":"施工","SJDW":"设计","SSDL":"堆场","SSDW":"北三集司","SSZL":"房屋","STATUS":"已确认","SYDW":"","SZDZ":"武汉","YT":"施工","YXMJ":"20.00","ZCYZ":""},{"ASSETNUM":"1031","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 14:41:58","DJJC":"ppp","DYTDZH":"ii","EQUNUM":"","JCTCRQ":"2020-06-02","JD_SSTZID":244,"JGYSZLDJ":"0","JZMJ":"20.00","MCJG":"p","MQJSDJ":"三类","NAME":"oo","QZH":"pp","SGDW":"ooo","SJDW":"oo","SSDL":"建(构)筑物","SSDW":"北三集司","SSZL":"卡口","STATUS":"待领导审核","SYDW":"","SZDZ":"ppppp","YT":"ooo","YXMJ":"20.00","ZCYZ":""},{"ASSETNUM":"1032","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 14:48:42","DJJC":"pl","DYTDZH":"ooo","EQUNUM":"","JCTCRQ":"2020-06-01","JD_SSTZID":245,"JGYSZLDJ":"0","JZMJ":"300.00","MCJG":"pp","MQJSDJ":"三类","NAME":"pp","QZH":"kkkk","SGDW":"pp","SJDW":"lll","SSDL":"海域","SSDW":"北三集司","SSZL":"转运站","STATUS":"已确认","SYDW":"","SZDZ":"kk","YT":"po","YXMJ":"300.00","ZCYZ":""}],"showcount":20,"totalpage":1,"totalresult":12}
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
         * resultlist : [{"ASSETNUM":"1024","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 09:50:15","DJJC":"21","DYTDZH":"12","EQUNUM":"","JCTCRQ":"2020-06-02","JD_SSTZID":241,"JGYSZLDJ":"12","JZMJ":"12.00","MCJG":"12","MQJSDJ":"四类","NAME":"12","QZH":"21","SGDW":"21","SJDW":"12","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"已确认","SYDW":"","SZDZ":"21","YT":"21","YXMJ":"1.00","ZCYZ":""},{"ASSETNUM":"1048","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 09:40:32","DJJC":"地基基础","DYTDZH":"12324241111土地证号","EQUNUM":"","JCTCRQ":"2020-07-08","JD_SSTZID":262,"JGYSZLDJ":"竣工验收质量等级","JZMJ":"122.00","MCJG":"结构形式","MQJSDJ":"二类","NAME":"121","QZH":"43253443房产证号","SGDW":"施工单位","SJDW":"设计单位","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"待领导审核","SYDW":"","SZDZ":"所在地址","YT":"用途","YXMJ":"320.00","ZCYZ":""},{"ASSETNUM":"1049","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 09:42:25","DJJC":"4234244","DYTDZH":"3425432535","EQUNUM":"","JCTCRQ":"2020-07-10","JD_SSTZID":263,"JGYSZLDJ":"2343","JZMJ":"423.00","MCJG":"214","MQJSDJ":"三类","NAME":"12331","QZH":"3454325345","SGDW":"234342","SJDW":"23324","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"取消","SYDW":"","SZDZ":"14242","YT":"423412","YXMJ":"4,534.00","ZCYZ":""},{"ASSETNUM":"1050","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 09:43:39","DJJC":"63452","DYTDZH":"43255466","EQUNUM":"","JCTCRQ":"2020-07-07","JD_SSTZID":264,"JGYSZLDJ":"534","JZMJ":"123,424.00","MCJG":"654","MQJSDJ":"三类","NAME":"452","QZH":"64374654","SGDW":"65364","SJDW":"4356","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"已确认","SYDW":"","SZDZ":"64365","YT":"643667","YXMJ":"134,134.00","ZCYZ":""},{"ASSETNUM":"1051","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 09:44:58","DJJC":"13425","DYTDZH":"52354534","EQUNUM":"","JCTCRQ":"2020-07-03","JD_SSTZID":265,"JGYSZLDJ":"13524","JZMJ":"345,345,636.00","MCJG":"534345","MQJSDJ":"三类","NAME":"56444","QZH":"3425454","SGDW":"54352","SJDW":"34543","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"取消","SYDW":"","SZDZ":"2345","YT":"5432534","YXMJ":"5,435,435.00","ZCYZ":""},{"ASSETNUM":"1055","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-23 17:16:41","DJJC":"3465","DYTDZH":"342356","EQUNUM":"","JCTCRQ":"2020-07-15","JD_SSTZID":281,"JGYSZLDJ":"1","JZMJ":"32.00","MCJG":"12","MQJSDJ":"三类","NAME":"sdgfh","QZH":"25367","SGDW":"34","SJDW":"3245","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"待领导审核","SYDW":"","SZDZ":"24654","YT":"3263","YXMJ":"143.00","ZCYZ":""},{"ASSETNUM":"1056","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-23 17:18:09","DJJC":"qert","DYTDZH":"324","EQUNUM":"","JCTCRQ":"2020-07-01","JD_SSTZID":282,"JGYSZLDJ":"ew","JZMJ":"23.00","MCJG":"ewr","MQJSDJ":"三类","NAME":"234","QZH":"453","SGDW":"wer","SJDW":"wer","SSDL":"堆场","SSDW":"北三集司","SSZL":"房屋","STATUS":"取消","SYDW":"","SZDZ":"trqet","YT":"eqwr","YXMJ":"324.00","ZCYZ":""},{"ASSETNUM":"SS1001","CREATEBY":"FANGJB","CREATEBYDESC":"方剑波","CREATETIME":"2020-03-06 15:51:37","DJJC":"1","DYTDZH":"22222","EQUNUM":"","JCTCRQ":"2020-03-03","JD_SSTZID":2,"JGYSZLDJ":"1","JZMJ":"222.00","MCJG":"1","MQJSDJ":"二类","NAME":"测试","QZH":"222","SGDW":"1","SJDW":"1","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"仓库","STATUS":"已确认","SYDW":"","SZDZ":"1","YT":"1","YXMJ":"2,222.00","ZCYZ":""},{"ASSETNUM":"1019","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-04-13 01:01:30","DJJC":"1","DYTDZH":"1","EQUNUM":"","JCTCRQ":"2020-04-13","JD_SSTZID":142,"JGYSZLDJ":"1","JZMJ":"1.00","MCJG":"1","MQJSDJ":"二类","NAME":"堤坝及防波堤","QZH":"1","SGDW":"1","SJDW":"1","SSDL":"堤坝及防波堤","SSDW":"北三集司","SSZL":"转运站","STATUS":"已确认","SYDW":"","SZDZ":"1","YT":"1","YXMJ":"1.00","ZCYZ":""},{"ASSETNUM":"1025","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 13:28:48","DJJC":"好","DYTDZH":"dsdf","EQUNUM":"","JCTCRQ":"2020-06-02","JD_SSTZID":242,"JGYSZLDJ":"一级","JZMJ":"20.00","MCJG":"有","MQJSDJ":"二类","NAME":"测试","QZH":"asfsdf","SGDW":"施工","SJDW":"设计","SSDL":"堆场","SSDW":"北三集司","SSZL":"房屋","STATUS":"已确认","SYDW":"","SZDZ":"武汉","YT":"施工","YXMJ":"20.00","ZCYZ":""},{"ASSETNUM":"1031","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 14:41:58","DJJC":"ppp","DYTDZH":"ii","EQUNUM":"","JCTCRQ":"2020-06-02","JD_SSTZID":244,"JGYSZLDJ":"0","JZMJ":"20.00","MCJG":"p","MQJSDJ":"三类","NAME":"oo","QZH":"pp","SGDW":"ooo","SJDW":"oo","SSDL":"建(构)筑物","SSDW":"北三集司","SSZL":"卡口","STATUS":"待领导审核","SYDW":"","SZDZ":"ppppp","YT":"ooo","YXMJ":"20.00","ZCYZ":""},{"ASSETNUM":"1032","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 14:48:42","DJJC":"pl","DYTDZH":"ooo","EQUNUM":"","JCTCRQ":"2020-06-01","JD_SSTZID":245,"JGYSZLDJ":"0","JZMJ":"300.00","MCJG":"pp","MQJSDJ":"三类","NAME":"pp","QZH":"kkkk","SGDW":"pp","SJDW":"lll","SSDL":"海域","SSDW":"北三集司","SSZL":"转运站","STATUS":"已确认","SYDW":"","SZDZ":"kk","YT":"po","YXMJ":"300.00","ZCYZ":""}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 12
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

        public static class ResultlistBean implements Serializable{
            /**
             * ASSETNUM : 1024
             * CREATEBY : MAXADMIN
             * CREATEBYDESC : 系统管理员
             * CREATETIME : 2020-06-03 09:50:15
             * DJJC : 21
             * DYTDZH : 12
             * EQUNUM :
             * JCTCRQ : 2020-06-02
             * JD_SSTZID : 241
             * JGYSZLDJ : 12
             * JZMJ : 12.00
             * MCJG : 12
             * MQJSDJ : 四类
             * NAME : 12
             * QZH : 21
             * SGDW : 21
             * SJDW : 12
             * SSDL : 堤坝及防波堤
             * SSDW : 北三集司
             * SSZL : 仓库
             * STATUS : 已确认
             * SYDW :
             * SZDZ : 21
             * YT : 21
             * YXMJ : 1.00
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
