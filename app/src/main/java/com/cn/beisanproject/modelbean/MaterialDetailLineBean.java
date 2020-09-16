package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class MaterialDetailLineBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"AVBLBALANCE":"0.00","A_BRAND":"","A_MODEL":"923726.0382","CLASS":"底盘和驾驶室","ITEMNUM":"435610002","ITEMQTY":"7.00","LASTCOST":"5.31","LINECOST":"17.92","LOCATION":"YD","ORDERUNIT":"套","UNITCOST":"2.56","WPMATERIALDESC":"轮边减速器固定螺丝"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"AVBLBALANCE":"0.00","A_BRAND":"","A_MODEL":"923726.0382","CLASS":"底盘和驾驶室","ITEMNUM":"435610002","ITEMQTY":"7.00","LASTCOST":"5.31","LINECOST":"17.92","LOCATION":"YD","ORDERUNIT":"套","UNITCOST":"2.56","WPMATERIALDESC":"轮边减速器固定螺丝"}]
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

        public static class ResultlistBean implements Serializable{
            /**
             * AVBLBALANCE : 0.00
             * A_BRAND :
             * A_MODEL : 923726.0382
             * CLASS : 底盘和驾驶室
             * ITEMNUM : 435610002
             * ITEMQTY : 7.00
             * LASTCOST : 5.31
             * LINECOST : 17.92
             * LOCATION : YD
             * ORDERUNIT : 套
             * UNITCOST : 2.56
             * WPMATERIALDESC : 轮边减速器固定螺丝
             */

            private String AVBLBALANCE;
            private String A_BRAND;
            private String A_MODEL;
            private String CLASS;
            private String ITEMNUM;
            private String ITEMQTY;
            private String LASTCOST;
            private String LINECOST;
            private String LOCATION;
            private String ORDERUNIT;
            private String UNITCOST;
            private String WPMATERIALDESC;

            public String getAVBLBALANCE() {
                return AVBLBALANCE;
            }

            public void setAVBLBALANCE(String AVBLBALANCE) {
                this.AVBLBALANCE = AVBLBALANCE;
            }

            public String getA_BRAND() {
                return A_BRAND;
            }

            public void setA_BRAND(String A_BRAND) {
                this.A_BRAND = A_BRAND;
            }

            public String getA_MODEL() {
                return A_MODEL;
            }

            public void setA_MODEL(String A_MODEL) {
                this.A_MODEL = A_MODEL;
            }

            public String getCLASS() {
                return CLASS;
            }

            public void setCLASS(String CLASS) {
                this.CLASS = CLASS;
            }

            public String getITEMNUM() {
                return ITEMNUM;
            }

            public void setITEMNUM(String ITEMNUM) {
                this.ITEMNUM = ITEMNUM;
            }

            public String getITEMQTY() {
                return ITEMQTY;
            }

            public void setITEMQTY(String ITEMQTY) {
                this.ITEMQTY = ITEMQTY;
            }

            public String getLASTCOST() {
                return LASTCOST;
            }

            public void setLASTCOST(String LASTCOST) {
                this.LASTCOST = LASTCOST;
            }

            public String getLINECOST() {
                return LINECOST;
            }

            public void setLINECOST(String LINECOST) {
                this.LINECOST = LINECOST;
            }

            public String getLOCATION() {
                return LOCATION;
            }

            public void setLOCATION(String LOCATION) {
                this.LOCATION = LOCATION;
            }

            public String getORDERUNIT() {
                return ORDERUNIT;
            }

            public void setORDERUNIT(String ORDERUNIT) {
                this.ORDERUNIT = ORDERUNIT;
            }

            public String getUNITCOST() {
                return UNITCOST;
            }

            public void setUNITCOST(String UNITCOST) {
                this.UNITCOST = UNITCOST;
            }

            public String getWPMATERIALDESC() {
                return WPMATERIALDESC;
            }

            public void setWPMATERIALDESC(String WPMATERIALDESC) {
                this.WPMATERIALDESC = WPMATERIALDESC;
            }
        }
    }
}
