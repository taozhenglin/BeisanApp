package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class PurchaseListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"DESCRIPTION":"讽德诵功","ORDERDATE":"2020-07-16 10:20:11","POID":31023,"PONUM":"31930","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"保管员通知","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"","VENDORDESC":""},{"DESCRIPTION":"","ORDERDATE":"2020-07-16 10:17:43","POID":31021,"PONUM":"31928","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"保管员通知","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"","VENDORDESC":""},{"DESCRIPTION":"测试","ORDERDATE":"2020-07-06 15:13:38","POID":31001,"PONUM":"31927","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"333.00","TOTJINE":"376.29","TOTSHUIE":"43.29","VENDOR":"GK13073","VENDORDESC":"GK13073"},{"DESCRIPTION":"app逆向流程测试","ORDERDATE":"2020-06-17 11:08:35","POID":30991,"PONUM":"31926","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"保管员通知","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"GK13074","VENDORDESC":"GK13074"},{"DESCRIPTION":"app正向流程测试","ORDERDATE":"2020-06-17 11:07:05","POID":30990,"PONUM":"31925","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"GK13073","VENDORDESC":"GK13073"},{"DESCRIPTION":"app流程信息提示测试","ORDERDATE":"2020-06-17 10:29:07","POID":30989,"PONUM":"31924","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"GK13073","VENDORDESC":"GK13073"},{"DESCRIPTION":"app流程测试","ORDERDATE":"2020-06-17 10:13:26","POID":30988,"PONUM":"31923","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"保管员通知","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"","VENDORDESC":""},{"DESCRIPTION":"1月柴油采购GJ4501","ORDERDATE":"2020-06-17 09:59:30","POID":30987,"PONUM":"31922","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"龚永胜","STATUS":"已批准","TOTALCOST":"510,409.91","TOTJINE":"576,763.20","TOTSHUIE":"66,353.29","VENDOR":"GK12361","VENDORDESC":"GK12361"},{"DESCRIPTION":"1月柴油采购GJ4501","ORDERDATE":"2020-06-17 08:56:17","POID":30986,"PONUM":"31921","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"龚永胜","STATUS":"已批准","TOTALCOST":"510,409.91","TOTJINE":"576,763.20","TOTSHUIE":"66,353.29","VENDOR":"GK12361","VENDORDESC":"GK12361"},{"DESCRIPTION":"1月柴油采购GJ4501","ORDERDATE":"2020-06-15 15:40:05","POID":30985,"PONUM":"31920","RECEIPTS":"部分","REQUIREDDATE":"","SHIPTOATTN":"龚永胜","STATUS":"已批准","TOTALCOST":"510,409.91","TOTJINE":"576,763.20","TOTSHUIE":"66,353.29","VENDOR":"GK12361","VENDORDESC":"GK12361"},{"DESCRIPTION":"测试","ORDERDATE":"2020-06-15 15:34:10","POID":30984,"PONUM":"31919","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"241.08","TOTJINE":"272.42","TOTSHUIE":"31.34","VENDOR":"GK13072","VENDORDESC":"GK13072"},{"DESCRIPTION":"ss","ORDERDATE":"2020-06-15 15:32:08","POID":30983,"PONUM":"31918","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"1,054.88","TOTJINE":"1,192.01","TOTSHUIE":"137.13","VENDOR":"GK13073","VENDORDESC":"GK13073"},{"DESCRIPTION":"ss","ORDERDATE":"2020-06-15 15:26:44","POID":30982,"PONUM":"31917","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"1,054.88","TOTJINE":"1,192.01","TOTSHUIE":"137.13","VENDOR":"GK13073","VENDORDESC":"GK13073"},{"DESCRIPTION":"测试","ORDERDATE":"2020-06-15 15:15:32","POID":30981,"PONUM":"31916","RECEIPTS":"部分","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"241.08","TOTJINE":"272.42","TOTSHUIE":"31.34","VENDOR":"GK13072","VENDORDESC":"GK13072"},{"DESCRIPTION":"","ORDERDATE":"2020-06-12 16:01:01","POID":30961,"PONUM":"31915","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"等待批准","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"","VENDORDESC":""},{"DESCRIPTION":"","ORDERDATE":"2020-05-13 14:47:36","POID":30941,"PONUM":"31914","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"12.00","TOTJINE":"13.56","TOTSHUIE":"1.56","VENDOR":"C574008016","VENDORDESC":"C574008016"},{"DESCRIPTION":"测试接收","ORDERDATE":"2020-03-13 19:54:42","POID":30901,"PONUM":"31912","RECEIPTS":"完成","REQUIREDDATE":"","SHIPTOATTN":"贾伟峰","STATUS":"已批准","TOTALCOST":"2,400.00","TOTJINE":"2,712.00","TOTSHUIE":"312.00","VENDOR":"GK11060","VENDORDESC":"GK11060"},{"DESCRIPTION":"测试接收","ORDERDATE":"2020-03-12 10:34:35","POID":30883,"PONUM":"31911","RECEIPTS":"完成","REQUIREDDATE":"","SHIPTOATTN":"贾伟峰","STATUS":"已批准","TOTALCOST":"472.00","TOTJINE":"533.36","TOTSHUIE":"61.36","VENDOR":"GK11059","VENDORDESC":"GK11059"},{"DESCRIPTION":"测试接收","ORDERDATE":"2020-03-12 10:25:59","POID":30882,"PONUM":"31910","RECEIPTS":"部分","REQUIREDDATE":"","SHIPTOATTN":"夏晓峰","STATUS":"已批准","TOTALCOST":"118,885.00","TOTJINE":"134,340.05","TOTSHUIE":"15,455.05","VENDOR":"GK11060","VENDORDESC":"GK11060"},{"DESCRIPTION":"测试选择的物资行状态为\u201c汇总已批准\u201d","ORDERDATE":"2020-03-10 17:44:24","POID":30861,"PONUM":"31909","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"夏晓峰","STATUS":"已批准","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"GK13072","VENDORDESC":"GK13072"}],"showcount":20,"totalpage":118,"totalresult":2345}
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
         * resultlist : [{"DESCRIPTION":"讽德诵功","ORDERDATE":"2020-07-16 10:20:11","POID":31023,"PONUM":"31930","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"保管员通知","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"","VENDORDESC":""},{"DESCRIPTION":"","ORDERDATE":"2020-07-16 10:17:43","POID":31021,"PONUM":"31928","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"保管员通知","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"","VENDORDESC":""},{"DESCRIPTION":"测试","ORDERDATE":"2020-07-06 15:13:38","POID":31001,"PONUM":"31927","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"333.00","TOTJINE":"376.29","TOTSHUIE":"43.29","VENDOR":"GK13073","VENDORDESC":"GK13073"},{"DESCRIPTION":"app逆向流程测试","ORDERDATE":"2020-06-17 11:08:35","POID":30991,"PONUM":"31926","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"保管员通知","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"GK13074","VENDORDESC":"GK13074"},{"DESCRIPTION":"app正向流程测试","ORDERDATE":"2020-06-17 11:07:05","POID":30990,"PONUM":"31925","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"GK13073","VENDORDESC":"GK13073"},{"DESCRIPTION":"app流程信息提示测试","ORDERDATE":"2020-06-17 10:29:07","POID":30989,"PONUM":"31924","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"GK13073","VENDORDESC":"GK13073"},{"DESCRIPTION":"app流程测试","ORDERDATE":"2020-06-17 10:13:26","POID":30988,"PONUM":"31923","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"保管员通知","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"","VENDORDESC":""},{"DESCRIPTION":"1月柴油采购GJ4501","ORDERDATE":"2020-06-17 09:59:30","POID":30987,"PONUM":"31922","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"龚永胜","STATUS":"已批准","TOTALCOST":"510,409.91","TOTJINE":"576,763.20","TOTSHUIE":"66,353.29","VENDOR":"GK12361","VENDORDESC":"GK12361"},{"DESCRIPTION":"1月柴油采购GJ4501","ORDERDATE":"2020-06-17 08:56:17","POID":30986,"PONUM":"31921","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"龚永胜","STATUS":"已批准","TOTALCOST":"510,409.91","TOTJINE":"576,763.20","TOTSHUIE":"66,353.29","VENDOR":"GK12361","VENDORDESC":"GK12361"},{"DESCRIPTION":"1月柴油采购GJ4501","ORDERDATE":"2020-06-15 15:40:05","POID":30985,"PONUM":"31920","RECEIPTS":"部分","REQUIREDDATE":"","SHIPTOATTN":"龚永胜","STATUS":"已批准","TOTALCOST":"510,409.91","TOTJINE":"576,763.20","TOTSHUIE":"66,353.29","VENDOR":"GK12361","VENDORDESC":"GK12361"},{"DESCRIPTION":"测试","ORDERDATE":"2020-06-15 15:34:10","POID":30984,"PONUM":"31919","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"241.08","TOTJINE":"272.42","TOTSHUIE":"31.34","VENDOR":"GK13072","VENDORDESC":"GK13072"},{"DESCRIPTION":"ss","ORDERDATE":"2020-06-15 15:32:08","POID":30983,"PONUM":"31918","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"1,054.88","TOTJINE":"1,192.01","TOTSHUIE":"137.13","VENDOR":"GK13073","VENDORDESC":"GK13073"},{"DESCRIPTION":"ss","ORDERDATE":"2020-06-15 15:26:44","POID":30982,"PONUM":"31917","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"1,054.88","TOTJINE":"1,192.01","TOTSHUIE":"137.13","VENDOR":"GK13073","VENDORDESC":"GK13073"},{"DESCRIPTION":"测试","ORDERDATE":"2020-06-15 15:15:32","POID":30981,"PONUM":"31916","RECEIPTS":"部分","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"241.08","TOTJINE":"272.42","TOTSHUIE":"31.34","VENDOR":"GK13072","VENDORDESC":"GK13072"},{"DESCRIPTION":"","ORDERDATE":"2020-06-12 16:01:01","POID":30961,"PONUM":"31915","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"等待批准","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"","VENDORDESC":""},{"DESCRIPTION":"","ORDERDATE":"2020-05-13 14:47:36","POID":30941,"PONUM":"31914","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"系统管理员","STATUS":"已批准","TOTALCOST":"12.00","TOTJINE":"13.56","TOTSHUIE":"1.56","VENDOR":"C574008016","VENDORDESC":"C574008016"},{"DESCRIPTION":"测试接收","ORDERDATE":"2020-03-13 19:54:42","POID":30901,"PONUM":"31912","RECEIPTS":"完成","REQUIREDDATE":"","SHIPTOATTN":"贾伟峰","STATUS":"已批准","TOTALCOST":"2,400.00","TOTJINE":"2,712.00","TOTSHUIE":"312.00","VENDOR":"GK11060","VENDORDESC":"GK11060"},{"DESCRIPTION":"测试接收","ORDERDATE":"2020-03-12 10:34:35","POID":30883,"PONUM":"31911","RECEIPTS":"完成","REQUIREDDATE":"","SHIPTOATTN":"贾伟峰","STATUS":"已批准","TOTALCOST":"472.00","TOTJINE":"533.36","TOTSHUIE":"61.36","VENDOR":"GK11059","VENDORDESC":"GK11059"},{"DESCRIPTION":"测试接收","ORDERDATE":"2020-03-12 10:25:59","POID":30882,"PONUM":"31910","RECEIPTS":"部分","REQUIREDDATE":"","SHIPTOATTN":"夏晓峰","STATUS":"已批准","TOTALCOST":"118,885.00","TOTJINE":"134,340.05","TOTSHUIE":"15,455.05","VENDOR":"GK11060","VENDORDESC":"GK11060"},{"DESCRIPTION":"测试选择的物资行状态为\u201c汇总已批准\u201d","ORDERDATE":"2020-03-10 17:44:24","POID":30861,"PONUM":"31909","RECEIPTS":"无","REQUIREDDATE":"","SHIPTOATTN":"夏晓峰","STATUS":"已批准","TOTALCOST":"0.00","TOTJINE":"","TOTSHUIE":"","VENDOR":"GK13072","VENDORDESC":"GK13072"}]
         * showcount : 20
         * totalpage : 118
         * totalresult : 2345
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

        public static class ResultlistBean  implements Serializable {
            /**
             * DESCRIPTION : 讽德诵功
             * ORDERDATE : 2020-07-16 10:20:11
             * POID : 31023
             * PONUM : 31930
             * RECEIPTS : 无
             * REQUIREDDATE :
             * SHIPTOATTN : 系统管理员
             * STATUS : 保管员通知
             * TOTALCOST : 0.00
             * TOTJINE :
             * TOTSHUIE :
             * VENDOR :
             * VENDORDESC :
             */

            private String DESCRIPTION;
            private String ORDERDATE;
            private int POID;
            private String PONUM;
            private String RECEIPTS;
            private String REQUIREDDATE;
            private String SHIPTOATTN;
            private String STATUS;
            private String TOTALCOST;
            private String TOTJINE;
            private String TOTSHUIE;
            private String VENDOR;
            private String VENDORDESC;

            public String getSITEID() {
                return SITEID;
            }

            public void setSITEID(String SITEID) {
                this.SITEID = SITEID;
            }

            private String SITEID;

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getORDERDATE() {
                return ORDERDATE;
            }

            public void setORDERDATE(String ORDERDATE) {
                this.ORDERDATE = ORDERDATE;
            }

            public int getPOID() {
                return POID;
            }

            public void setPOID(int POID) {
                this.POID = POID;
            }

            public String getPONUM() {
                return PONUM;
            }

            public void setPONUM(String PONUM) {
                this.PONUM = PONUM;
            }

            public String getRECEIPTS() {
                return RECEIPTS;
            }

            public void setRECEIPTS(String RECEIPTS) {
                this.RECEIPTS = RECEIPTS;
            }

            public String getREQUIREDDATE() {
                return REQUIREDDATE;
            }

            public void setREQUIREDDATE(String REQUIREDDATE) {
                this.REQUIREDDATE = REQUIREDDATE;
            }

            public String getSHIPTOATTN() {
                return SHIPTOATTN;
            }

            public void setSHIPTOATTN(String SHIPTOATTN) {
                this.SHIPTOATTN = SHIPTOATTN;
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

            public String getTOTJINE() {
                return TOTJINE;
            }

            public void setTOTJINE(String TOTJINE) {
                this.TOTJINE = TOTJINE;
            }

            public String getTOTSHUIE() {
                return TOTSHUIE;
            }

            public void setTOTSHUIE(String TOTSHUIE) {
                this.TOTSHUIE = TOTSHUIE;
            }

            public String getVENDOR() {
                return VENDOR;
            }

            public void setVENDOR(String VENDOR) {
                this.VENDOR = VENDOR;
            }

            public String getVENDORDESC() {
                return VENDORDESC;
            }

            public void setVENDORDESC(String VENDORDESC) {
                this.VENDORDESC = VENDORDESC;
            }
        }
    }
}
