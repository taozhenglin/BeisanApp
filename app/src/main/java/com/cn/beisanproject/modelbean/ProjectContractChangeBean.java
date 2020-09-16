package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class ProjectContractChangeBean  implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"CONTRACTDESC":"龙门吊电缆槽盖板安装和重新固定","CONTRACTNUM":"4953","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:11:42","DESCRIPTION":"APPLIUCHEGNCESHI","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"38,965.60","UDBGNUM":"1012","UDPURCHBGID":49,"UNITCOST":""},{"CONTRACTDESC":"桥吊倾转减速箱排装维修","CONTRACTNUM":"4954","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:10:20","DESCRIPTION":"appliuchengceshi","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"18,508.62","UDBGNUM":"1011","UDPURCHBGID":48,"UNITCOST":""},{"CONTRACTDESC":"视频监控维护服务","CONTRACTNUM":"4966","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:08:07","DESCRIPTION":"appliuchengceshi","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"1,375,240.00","UDBGNUM":"1010","UDPURCHBGID":47,"UNITCOST":""},{"CONTRACTDESC":"宁波舟山港穿山港区卡口改造工程招标代理及造价咨询合同","CONTRACTNUM":"4963","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:07:13","DESCRIPTION":"app流程测试","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"48,000.00","UDBGNUM":"1009","UDPURCHBGID":46,"UNITCOST":""},{"CONTRACTDESC":"龙门吊小车轨道螺栓更换","CONTRACTNUM":"4960","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:05:10","DESCRIPTION":"app流程测试","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"2,532.76","UDBGNUM":"1008","UDPURCHBGID":45,"UNITCOST":""},{"CONTRACTDESC":"龙门吊电缆槽盖板安装和重新固定","CONTRACTNUM":"4953","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:00:07","DESCRIPTION":"app流程测试","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"38,965.60","UDBGNUM":"1007","UDPURCHBGID":44,"UNITCOST":""},{"CONTRACTDESC":"龙门吊回转轴承更换","CONTRACTNUM":"4951","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-10 15:11:23","DESCRIPTION":"app流程测试","ENDDATE":"2020-10-28","ENDDATEDESC":"2020-10-28","REMARK":"阿士大夫撒法师法师法士大夫撒旦发送到发送到石荻发所发生的访问法撒旦哥哥sad爱上氛围格格我也只是独特我也","STARTDATE":"2020-06-01","STATUS":"已批准","TOTALCOST":"35,068.95","UDBGNUM":"1006","UDPURCHBGID":43,"UNITCOST":""},{"CONTRACTDESC":"龙门吊电缆槽盖板安装和重新固定","CONTRACTNUM":"4953","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-10 11:58:29","DESCRIPTION":"流程测试","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"38,965.60","UDBGNUM":"1005","UDPURCHBGID":42,"UNITCOST":""},{"CONTRACTDESC":"龙门吊回转轴承更换","CONTRACTNUM":"4951","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-10 11:26:49","DESCRIPTION":"APP流程测试","ENDDATE":"","ENDDATEDESC":"2020-10-28","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"35,068.95","UDBGNUM":"1004","UDPURCHBGID":41,"UNITCOST":""},{"CONTRACTDESC":"宁波-舟山港北仑港区四期3#~6#泊位靠泊能力论证技术咨询合同","CONTRACTNUM":"4898","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-04-20 18:49:15","DESCRIPTION":"测试","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"2020-04-20","STATUS":"已批准","TOTALCOST":"20,000.00","UDBGNUM":"1003","UDPURCHBGID":22,"UNITCOST":"20,000.00"},{"CONTRACTDESC":"宁波-舟山港北仑港区四期3#~6#泊位靠泊能力论证技术咨询合同","CONTRACTNUM":"4898","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-04-03 11:51:27","DESCRIPTION":"test","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"20,000.00","UDBGNUM":"1001","UDPURCHBGID":1,"UNITCOST":"10,000.00"}],"showcount":20,"totalpage":1,"totalresult":11}
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

    public static class ResultBean implements Serializable {
        /**
         * curpage : 1
         * resultlist : [{"CONTRACTDESC":"龙门吊电缆槽盖板安装和重新固定","CONTRACTNUM":"4953","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:11:42","DESCRIPTION":"APPLIUCHEGNCESHI","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"38,965.60","UDBGNUM":"1012","UDPURCHBGID":49,"UNITCOST":""},{"CONTRACTDESC":"桥吊倾转减速箱排装维修","CONTRACTNUM":"4954","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:10:20","DESCRIPTION":"appliuchengceshi","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"18,508.62","UDBGNUM":"1011","UDPURCHBGID":48,"UNITCOST":""},{"CONTRACTDESC":"视频监控维护服务","CONTRACTNUM":"4966","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:08:07","DESCRIPTION":"appliuchengceshi","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"1,375,240.00","UDBGNUM":"1010","UDPURCHBGID":47,"UNITCOST":""},{"CONTRACTDESC":"宁波舟山港穿山港区卡口改造工程招标代理及造价咨询合同","CONTRACTNUM":"4963","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:07:13","DESCRIPTION":"app流程测试","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"48,000.00","UDBGNUM":"1009","UDPURCHBGID":46,"UNITCOST":""},{"CONTRACTDESC":"龙门吊小车轨道螺栓更换","CONTRACTNUM":"4960","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:05:10","DESCRIPTION":"app流程测试","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"2,532.76","UDBGNUM":"1008","UDPURCHBGID":45,"UNITCOST":""},{"CONTRACTDESC":"龙门吊电缆槽盖板安装和重新固定","CONTRACTNUM":"4953","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-11 16:00:07","DESCRIPTION":"app流程测试","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"38,965.60","UDBGNUM":"1007","UDPURCHBGID":44,"UNITCOST":""},{"CONTRACTDESC":"龙门吊回转轴承更换","CONTRACTNUM":"4951","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-10 15:11:23","DESCRIPTION":"app流程测试","ENDDATE":"2020-10-28","ENDDATEDESC":"2020-10-28","REMARK":"阿士大夫撒法师法师法士大夫撒旦发送到发送到石荻发所发生的访问法撒旦哥哥sad爱上氛围格格我也只是独特我也","STARTDATE":"2020-06-01","STATUS":"已批准","TOTALCOST":"35,068.95","UDBGNUM":"1006","UDPURCHBGID":43,"UNITCOST":""},{"CONTRACTDESC":"龙门吊电缆槽盖板安装和重新固定","CONTRACTNUM":"4953","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-10 11:58:29","DESCRIPTION":"流程测试","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"38,965.60","UDBGNUM":"1005","UDPURCHBGID":42,"UNITCOST":""},{"CONTRACTDESC":"龙门吊回转轴承更换","CONTRACTNUM":"4951","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-06-10 11:26:49","DESCRIPTION":"APP流程测试","ENDDATE":"","ENDDATEDESC":"2020-10-28","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"35,068.95","UDBGNUM":"1004","UDPURCHBGID":41,"UNITCOST":""},{"CONTRACTDESC":"宁波-舟山港北仑港区四期3#~6#泊位靠泊能力论证技术咨询合同","CONTRACTNUM":"4898","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-04-20 18:49:15","DESCRIPTION":"测试","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"2020-04-20","STATUS":"已批准","TOTALCOST":"20,000.00","UDBGNUM":"1003","UDPURCHBGID":22,"UNITCOST":"20,000.00"},{"CONTRACTDESC":"宁波-舟山港北仑港区四期3#~6#泊位靠泊能力论证技术咨询合同","CONTRACTNUM":"4898","CREATEBY":"MAXADMIN","CREATEBYDESC":"系统管理员","CREATEDATE":"2020-04-03 11:51:27","DESCRIPTION":"test","ENDDATE":"","ENDDATEDESC":"","REMARK":"","STARTDATE":"","STATUS":"已批准","TOTALCOST":"20,000.00","UDBGNUM":"1001","UDPURCHBGID":1,"UNITCOST":"10,000.00"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 11
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
             * CONTRACTDESC : 龙门吊电缆槽盖板安装和重新固定
             * CONTRACTNUM : 4953
             * CREATEBY : MAXADMIN
             * CREATEBYDESC : 系统管理员
             * CREATEDATE : 2020-06-11 16:11:42
             * DESCRIPTION : APPLIUCHEGNCESHI
             * ENDDATE :
             * ENDDATEDESC :
             * REMARK :
             * STARTDATE :
             * STATUS : 已批准
             * TOTALCOST : 38,965.60
             * UDBGNUM : 1012
             * UDPURCHBGID : 49
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
