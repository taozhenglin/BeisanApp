package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class PuarchaseEnquirySupportBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_AWARDCOST":"","A_REPORTCOST":"","CONTACT":"","CYVENDORTOTALCOST":"","PHONE":"","SITEID":"1000","VENDOR":"C574002","VENDORDESC":"中国联合网络通信有限公司宁波分公司","VENDORTOTALCOST":""},{"A_AWARDCOST":"","A_REPORTCOST":"","CONTACT":"张志显","CYVENDORTOTALCOST":"","PHONE":"18688863605","SITEID":"1000","VENDOR":"GK17630","VENDORDESC":"广东交科检测有限公司","VENDORTOTALCOST":""},{"A_AWARDCOST":"0","A_REPORTCOST":"","CONTACT":"","CYVENDORTOTALCOST":"-666.00","PHONE":"","SITEID":"1000","VENDOR":"W574C050","VENDORDESC":"宁波市鸿达木材有限责任公司","VENDORTOTALCOST":"0.00"}],"showcount":20,"totalpage":1,"totalresult":3}
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
         * resultlist : [{"A_AWARDCOST":"","A_REPORTCOST":"","CONTACT":"","CYVENDORTOTALCOST":"","PHONE":"","SITEID":"1000","VENDOR":"C574002","VENDORDESC":"中国联合网络通信有限公司宁波分公司","VENDORTOTALCOST":""},{"A_AWARDCOST":"","A_REPORTCOST":"","CONTACT":"张志显","CYVENDORTOTALCOST":"","PHONE":"18688863605","SITEID":"1000","VENDOR":"GK17630","VENDORDESC":"广东交科检测有限公司","VENDORTOTALCOST":""},{"A_AWARDCOST":"0","A_REPORTCOST":"","CONTACT":"","CYVENDORTOTALCOST":"-666.00","PHONE":"","SITEID":"1000","VENDOR":"W574C050","VENDORDESC":"宁波市鸿达木材有限责任公司","VENDORTOTALCOST":"0.00"}]
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

        public static class ResultlistBean {
            /**
             * A_AWARDCOST :
             * A_REPORTCOST :
             * CONTACT :
             * CYVENDORTOTALCOST :
             * PHONE :
             * SITEID : 1000
             * VENDOR : C574002
             * VENDORDESC : 中国联合网络通信有限公司宁波分公司
             * VENDORTOTALCOST :
             */

            private String A_AWARDCOST;
            private String A_REPORTCOST;
            private String CONTACT;
            private String CYVENDORTOTALCOST;
            private String PHONE;
            private String SITEID;
            private String VENDOR;
            private String VENDORDESC;
            private String VENDORTOTALCOST;

            public String getA_AWARDCOST() {
                return A_AWARDCOST;
            }

            public void setA_AWARDCOST(String A_AWARDCOST) {
                this.A_AWARDCOST = A_AWARDCOST;
            }

            public String getA_REPORTCOST() {
                return A_REPORTCOST;
            }

            public void setA_REPORTCOST(String A_REPORTCOST) {
                this.A_REPORTCOST = A_REPORTCOST;
            }

            public String getCONTACT() {
                return CONTACT;
            }

            public void setCONTACT(String CONTACT) {
                this.CONTACT = CONTACT;
            }

            public String getCYVENDORTOTALCOST() {
                return CYVENDORTOTALCOST;
            }

            public void setCYVENDORTOTALCOST(String CYVENDORTOTALCOST) {
                this.CYVENDORTOTALCOST = CYVENDORTOTALCOST;
            }

            public String getPHONE() {
                return PHONE;
            }

            public void setPHONE(String PHONE) {
                this.PHONE = PHONE;
            }

            public String getSITEID() {
                return SITEID;
            }

            public void setSITEID(String SITEID) {
                this.SITEID = SITEID;
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

            public String getVENDORTOTALCOST() {
                return VENDORTOTALCOST;
            }

            public void setVENDORTOTALCOST(String VENDORTOTALCOST) {
                this.VENDORTOTALCOST = VENDORTOTALCOST;
            }
        }
    }
}
