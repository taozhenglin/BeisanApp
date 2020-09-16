package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class EqumentRequestListBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ASSETNUM":"1040","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 08:36:26","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":222,"JJZB":"","JSZB":"2222","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"正常使用","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"222","YHTSXQZB":"","YZ":"2.00"},{"ASSETNUM":"1041","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 08:37:35","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":223,"JJZB":"","JSZB":"223","PHONE":"18090908080","SBDL":"散货专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"223","YHTSXQZB":"","YZ":"2.00"},{"ASSETNUM":"1044","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 08:53:06","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":226,"JJZB":"","JSZB":"32","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"23","YHTSXQZB":"","YZ":"10.00"},{"ASSETNUM":"1045","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 08:54:39","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":227,"JJZB":"","JSZB":"227","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"驳回","SYDW":"北三集司","VENDOR":"","XH":"227","YHTSXQZB":"","YZ":"12.00"},{"ASSETNUM":"1046","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 08:56:25","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":228,"JJZB":"","JSZB":"228","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"待领导审核","SYDW":"北三集司","VENDOR":"","XH":"228","YHTSXQZB":"","YZ":"23.00"},{"ASSETNUM":"1029","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 14:37:19","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":204,"JJZB":"","JSZB":"oooo","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"推扒机","SBZT":"正常使用","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"ooo","YHTSXQZB":"","YZ":"20.00"},{"ASSETNUM":"SB1001","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-02-25 21:06:45","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"2020-03-04 13:40:43","ISZDSB":"Y","JD_SBTZID":2,"JJZB":"","JSZB":"测试","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"正常使用","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"BHNHJU-YYUJ","YHTSXQZB":"","YZ":"9,080.00"},{"ASSETNUM":"SB1002","ATTR1":"","BZ":"","CREATEBY":"FANGJB","CREATEBYDESC":"方剑波","CREATETIME":"2020-03-04 17:50:27","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":43,"JJZB":"","JSZB":"11111111111","PHONE":"13967826988","SBDL":"散货专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"GK11586","XH":"111","YHTSXQZB":"","YZ":"111.00"},{"ASSETNUM":"SB1003","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-02-25 21:09:42","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":3,"JJZB":"","JSZB":"测试","PHONE":"18090908080","SBDL":"散货专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"推扒机","SBZT":"租赁","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"GK11581","XH":"AAAAAAAAAA","YHTSXQZB":"","YZ":"8,080.00"},{"ASSETNUM":"SB1004","ATTR1":"","BZ":"","CREATEBY":"FANGJB","CREATEBYDESC":"方剑波","CREATETIME":"2020-03-04 13:40:43","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":42,"JJZB":"","JSZB":"XXXXXXXXXXXXXXX","PHONE":"13967826988","SBDL":"散货专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"推扒机","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"GK11568","XH":"XXXXXXXXXXx","YHTSXQZB":"","YZ":"100.00"},{"ASSETNUM":"1026","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 13:50:04","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":202,"JJZB":"","JSZB":"sdad","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"2dastest","YHTSXQZB":"","YZ":"100.00"},{"ASSETNUM":"1028","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 14:35:45","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":203,"JJZB":"","JSZB":"oooo","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"kkk","YHTSXQZB":"","YZ":"10.00"},{"ASSETNUM":"1030","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 14:40:23","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":205,"JJZB":"","JSZB":"rr","PHONE":"18090908080","SBDL":"散货专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"推扒机","SBZT":"正常使用","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"dd","YHTSXQZB":"","YZ":"4.00"},{"ASSETNUM":"1039","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 08:33:15","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":221,"JJZB":"","JSZB":"111","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"待领导审核","SYDW":"北三集司","VENDOR":"","XH":"11","YHTSXQZB":"","YZ":"1.00"},{"ASSETNUM":"1023","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 09:36:25","DKPP":"","EQCODE":"23","EQUNUM":"","GRDATE":"2020-06-16 09:37:02","ISZDSB":"N","JD_SBTZID":201,"JJZB":"","JSZB":"232","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"正常使用","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"23","YHTSXQZB":"","YZ":"23.00"}],"showcount":20,"totalpage":1,"totalresult":15}
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
         * resultlist : [{"ASSETNUM":"1040","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 08:36:26","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":222,"JJZB":"","JSZB":"2222","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"正常使用","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"222","YHTSXQZB":"","YZ":"2.00"},{"ASSETNUM":"1041","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 08:37:35","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":223,"JJZB":"","JSZB":"223","PHONE":"18090908080","SBDL":"散货专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"223","YHTSXQZB":"","YZ":"2.00"},{"ASSETNUM":"1044","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 08:53:06","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":226,"JJZB":"","JSZB":"32","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"23","YHTSXQZB":"","YZ":"10.00"},{"ASSETNUM":"1045","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 08:54:39","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":227,"JJZB":"","JSZB":"227","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"驳回","SYDW":"北三集司","VENDOR":"","XH":"227","YHTSXQZB":"","YZ":"12.00"},{"ASSETNUM":"1046","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 08:56:25","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":228,"JJZB":"","JSZB":"228","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"待领导审核","SYDW":"北三集司","VENDOR":"","XH":"228","YHTSXQZB":"","YZ":"23.00"},{"ASSETNUM":"1029","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 14:37:19","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":204,"JJZB":"","JSZB":"oooo","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"推扒机","SBZT":"正常使用","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"ooo","YHTSXQZB":"","YZ":"20.00"},{"ASSETNUM":"SB1001","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-02-25 21:06:45","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"2020-03-04 13:40:43","ISZDSB":"Y","JD_SBTZID":2,"JJZB":"","JSZB":"测试","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"正常使用","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"BHNHJU-YYUJ","YHTSXQZB":"","YZ":"9,080.00"},{"ASSETNUM":"SB1002","ATTR1":"","BZ":"","CREATEBY":"FANGJB","CREATEBYDESC":"方剑波","CREATETIME":"2020-03-04 17:50:27","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":43,"JJZB":"","JSZB":"11111111111","PHONE":"13967826988","SBDL":"散货专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"GK11586","XH":"111","YHTSXQZB":"","YZ":"111.00"},{"ASSETNUM":"SB1003","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-02-25 21:09:42","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":3,"JJZB":"","JSZB":"测试","PHONE":"18090908080","SBDL":"散货专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"推扒机","SBZT":"租赁","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"GK11581","XH":"AAAAAAAAAA","YHTSXQZB":"","YZ":"8,080.00"},{"ASSETNUM":"SB1004","ATTR1":"","BZ":"","CREATEBY":"FANGJB","CREATEBYDESC":"方剑波","CREATETIME":"2020-03-04 13:40:43","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":42,"JJZB":"","JSZB":"XXXXXXXXXXXXXXX","PHONE":"13967826988","SBDL":"散货专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"推扒机","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"GK11568","XH":"XXXXXXXXXXx","YHTSXQZB":"","YZ":"100.00"},{"ASSETNUM":"1026","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 13:50:04","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":202,"JJZB":"","JSZB":"sdad","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"2dastest","YHTSXQZB":"","YZ":"100.00"},{"ASSETNUM":"1028","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 14:35:45","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":203,"JJZB":"","JSZB":"oooo","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"kkk","YHTSXQZB":"","YZ":"10.00"},{"ASSETNUM":"1030","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 14:40:23","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":205,"JJZB":"","JSZB":"rr","PHONE":"18090908080","SBDL":"散货专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"推扒机","SBZT":"正常使用","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"dd","YHTSXQZB":"","YZ":"4.00"},{"ASSETNUM":"1039","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-07-20 08:33:15","DKPP":"","EQCODE":"","EQUNUM":"","GRDATE":"","ISZDSB":"N","JD_SBTZID":221,"JJZB":"","JSZB":"111","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"报废","SCCJ":"","SSDW":"北三集司","STATUS":"待领导审核","SYDW":"北三集司","VENDOR":"","XH":"11","YHTSXQZB":"","YZ":"1.00"},{"ASSETNUM":"1023","ATTR1":"","BZ":"","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATETIME":"2020-06-03 09:36:25","DKPP":"","EQCODE":"23","EQUNUM":"","GRDATE":"2020-06-16 09:37:02","ISZDSB":"N","JD_SBTZID":201,"JJZB":"","JSZB":"232","PHONE":"18090908080","SBDL":"集装箱专用机械类","SBWZ":"","SBXL":"自卸车","SBZL":"叉车","SBZT":"正常使用","SCCJ":"","SSDW":"北三集司","STATUS":"已确认","SYDW":"北三集司","VENDOR":"","XH":"23","YHTSXQZB":"","YZ":"23.00"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 15
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
             * ASSETNUM : 1040
             * ATTR1 :
             * BZ :
             * CREATEBY : MAXADMIN
             * CREATEBYDESC : 系统管理员
             * CREATETIME : 2020-07-20 08:36:26
             * DKPP :
             * EQCODE :
             * EQUNUM :
             * GRDATE :
             * ISZDSB : N
             * JD_SBTZID : 222
             * JJZB :
             * JSZB : 2222
             * PHONE : 18090908080
             * SBDL : 集装箱专用机械类
             * SBWZ :
             * SBXL : 自卸车
             * SBZL : 叉车
             * SBZT : 正常使用
             * SCCJ :
             * SSDW : 北三集司
             * STATUS : 已确认
             * SYDW : 北三集司
             * VENDOR :
             * XH : 222
             * YHTSXQZB :
             * YZ : 2.00
             */

            private String ASSETNUM;
            private String ATTR1;
            private String BZ;
            private String CREATEBY;
            private String CREATEBYDESC;
            private String CREATETIME;
            private String DKPP;
            private String EQCODE;
            private String EQUNUM;
            private String GRDATE;
            private String ISZDSB;
            private int JD_SBTZID;
            private String JJZB;
            private String JSZB;
            private String PHONE;
            private String SBDL;
            private String SBWZ;
            private String SBXL;
            private String SBZL;
            private String SBZT;
            private String SCCJ;
            private String SSDW;
            private String STATUS;
            private String SYDW;
            private String VENDOR;
            private String XH;
            private String YHTSXQZB;
            private String YZ;

            public String getASSETNUM() {
                return ASSETNUM;
            }

            public void setASSETNUM(String ASSETNUM) {
                this.ASSETNUM = ASSETNUM;
            }

            public String getATTR1() {
                return ATTR1;
            }

            public void setATTR1(String ATTR1) {
                this.ATTR1 = ATTR1;
            }

            public String getBZ() {
                return BZ;
            }

            public void setBZ(String BZ) {
                this.BZ = BZ;
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

            public String getDKPP() {
                return DKPP;
            }

            public void setDKPP(String DKPP) {
                this.DKPP = DKPP;
            }

            public String getEQCODE() {
                return EQCODE;
            }

            public void setEQCODE(String EQCODE) {
                this.EQCODE = EQCODE;
            }

            public String getEQUNUM() {
                return EQUNUM;
            }

            public void setEQUNUM(String EQUNUM) {
                this.EQUNUM = EQUNUM;
            }

            public String getGRDATE() {
                return GRDATE;
            }

            public void setGRDATE(String GRDATE) {
                this.GRDATE = GRDATE;
            }

            public String getISZDSB() {
                return ISZDSB;
            }

            public void setISZDSB(String ISZDSB) {
                this.ISZDSB = ISZDSB;
            }

            public int getJD_SBTZID() {
                return JD_SBTZID;
            }

            public void setJD_SBTZID(int JD_SBTZID) {
                this.JD_SBTZID = JD_SBTZID;
            }

            public String getJJZB() {
                return JJZB;
            }

            public void setJJZB(String JJZB) {
                this.JJZB = JJZB;
            }

            public String getJSZB() {
                return JSZB;
            }

            public void setJSZB(String JSZB) {
                this.JSZB = JSZB;
            }

            public String getPHONE() {
                return PHONE;
            }

            public void setPHONE(String PHONE) {
                this.PHONE = PHONE;
            }

            public String getSBDL() {
                return SBDL;
            }

            public void setSBDL(String SBDL) {
                this.SBDL = SBDL;
            }

            public String getSBWZ() {
                return SBWZ;
            }

            public void setSBWZ(String SBWZ) {
                this.SBWZ = SBWZ;
            }

            public String getSBXL() {
                return SBXL;
            }

            public void setSBXL(String SBXL) {
                this.SBXL = SBXL;
            }

            public String getSBZL() {
                return SBZL;
            }

            public void setSBZL(String SBZL) {
                this.SBZL = SBZL;
            }

            public String getSBZT() {
                return SBZT;
            }

            public void setSBZT(String SBZT) {
                this.SBZT = SBZT;
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

            public String getVENDOR() {
                return VENDOR;
            }

            public void setVENDOR(String VENDOR) {
                this.VENDOR = VENDOR;
            }

            public String getXH() {
                return XH;
            }

            public void setXH(String XH) {
                this.XH = XH;
            }

            public String getYHTSXQZB() {
                return YHTSXQZB;
            }

            public void setYHTSXQZB(String YHTSXQZB) {
                this.YHTSXQZB = YHTSXQZB;
            }

            public String getYZ() {
                return YZ;
            }

            public void setYZ(String YZ) {
                this.YZ = YZ;
            }
        }
    }
}
