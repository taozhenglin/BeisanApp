package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class ProjectInvoiceAttachBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_BUDGETDESC":"","A_BUDGETNUM":"","CFZBJ":"0.0000","CFZBJBL":"0.00","CONTRACTREFNUM":"","DESCRIPTION":"测试","ENTERBY":"MAXADMIN","ENTERDATE":"2020-06-30 15:57:40","FPTYPE":"CL","FYND":"DN","INVOICENUM":"4039","PONUM":"","PRETAXTOTAL":"0.00","REMITADDRESS1":"","SITEDESC":"宁波北仑第三集装箱码头有限公司","SITEID":"1000","STATUS":"已输入","TOTALCOST":"0.00","TOTALTAX1":"0.00","UDHTBH":"11111","UDXMBH":"XM00261","VENDOR":"GK13314","VENDORDESC":"湖北江南东风专用特种汽车有限公司","VENDORINVOICENUM":"1111"},{"A_BUDGETDESC":"龙门吊委外维修费用- 整机润滑","A_BUDGETNUM":"2019CB-XL-R-003","CFZBJ":"0.0000","CFZBJBL":"0.00","CONTRACTREFNUM":"","DESCRIPTION":"测试（修改）","ENTERBY":"MAXADMIN","ENTERDATE":"2020-06-30 16:10:31","FPTYPE":"CL","FYND":"DN","INVOICENUM":"4040","PONUM":"","PRETAXTOTAL":"38,243.28","REMITADDRESS1":"","SITEDESC":"宁波北仑第三集装箱码头有限公司","SITEID":"1000","STATUS":"已输入","TOTALCOST":"43,250.00","TOTALTAX1":"5,006.72","UDHTBH":"11111","UDXMBH":"XM00261","VENDOR":"GK13314","VENDORDESC":"湖北江南东风专用特种汽车有限公司","VENDORINVOICENUM":"1111"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","CFZBJ":"0.0000","CFZBJBL":"0.00","CONTRACTREFNUM":"","DESCRIPTION":"发票和合同关联","ENTERBY":"MAXADMIN","ENTERDATE":"2020-05-06 14:38:22","FPTYPE":"CL","FYND":"DN","INVOICENUM":"4026","PONUM":"29608","PRETAXTOTAL":"0.00","REMITADDRESS1":"","SITEDESC":"宁波北仑第三集装箱码头有限公司","SITEID":"1000","STATUS":"已输入","TOTALCOST":"0.00","TOTALTAX1":"0.00","UDHTBH":"11111","UDXMBH":"XM00261","VENDOR":"GK13314","VENDORDESC":"湖北江南东风专用特种汽车有限公司","VENDORINVOICENUM":"435435435"}],"showcount":20,"totalpage":1,"totalresult":3}
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
         * resultlist : [{"A_BUDGETDESC":"","A_BUDGETNUM":"","CFZBJ":"0.0000","CFZBJBL":"0.00","CONTRACTREFNUM":"","DESCRIPTION":"测试","ENTERBY":"MAXADMIN","ENTERDATE":"2020-06-30 15:57:40","FPTYPE":"CL","FYND":"DN","INVOICENUM":"4039","PONUM":"","PRETAXTOTAL":"0.00","REMITADDRESS1":"","SITEDESC":"宁波北仑第三集装箱码头有限公司","SITEID":"1000","STATUS":"已输入","TOTALCOST":"0.00","TOTALTAX1":"0.00","UDHTBH":"11111","UDXMBH":"XM00261","VENDOR":"GK13314","VENDORDESC":"湖北江南东风专用特种汽车有限公司","VENDORINVOICENUM":"1111"},{"A_BUDGETDESC":"龙门吊委外维修费用- 整机润滑","A_BUDGETNUM":"2019CB-XL-R-003","CFZBJ":"0.0000","CFZBJBL":"0.00","CONTRACTREFNUM":"","DESCRIPTION":"测试（修改）","ENTERBY":"MAXADMIN","ENTERDATE":"2020-06-30 16:10:31","FPTYPE":"CL","FYND":"DN","INVOICENUM":"4040","PONUM":"","PRETAXTOTAL":"38,243.28","REMITADDRESS1":"","SITEDESC":"宁波北仑第三集装箱码头有限公司","SITEID":"1000","STATUS":"已输入","TOTALCOST":"43,250.00","TOTALTAX1":"5,006.72","UDHTBH":"11111","UDXMBH":"XM00261","VENDOR":"GK13314","VENDORDESC":"湖北江南东风专用特种汽车有限公司","VENDORINVOICENUM":"1111"},{"A_BUDGETDESC":"","A_BUDGETNUM":"","CFZBJ":"0.0000","CFZBJBL":"0.00","CONTRACTREFNUM":"","DESCRIPTION":"发票和合同关联","ENTERBY":"MAXADMIN","ENTERDATE":"2020-05-06 14:38:22","FPTYPE":"CL","FYND":"DN","INVOICENUM":"4026","PONUM":"29608","PRETAXTOTAL":"0.00","REMITADDRESS1":"","SITEDESC":"宁波北仑第三集装箱码头有限公司","SITEID":"1000","STATUS":"已输入","TOTALCOST":"0.00","TOTALTAX1":"0.00","UDHTBH":"11111","UDXMBH":"XM00261","VENDOR":"GK13314","VENDORDESC":"湖北江南东风专用特种汽车有限公司","VENDORINVOICENUM":"435435435"}]
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
             * A_BUDGETDESC :
             * A_BUDGETNUM :
             * CFZBJ : 0.0000
             * CFZBJBL : 0.00
             * CONTRACTREFNUM :
             * DESCRIPTION : 测试
             * ENTERBY : MAXADMIN
             * ENTERDATE : 2020-06-30 15:57:40
             * FPTYPE : CL
             * FYND : DN
             * INVOICENUM : 4039
             * PONUM :
             * PRETAXTOTAL : 0.00
             * REMITADDRESS1 :
             * SITEDESC : 宁波北仑第三集装箱码头有限公司
             * SITEID : 1000
             * STATUS : 已输入
             * TOTALCOST : 0.00
             * TOTALTAX1 : 0.00
             * UDHTBH : 11111
             * UDXMBH : XM00261
             * VENDOR : GK13314
             * VENDORDESC : 湖北江南东风专用特种汽车有限公司
             * VENDORINVOICENUM : 1111
             */

            private String A_BUDGETDESC;
            private String A_BUDGETNUM;
            private String CFZBJ;
            private String CFZBJBL;
            private String CONTRACTREFNUM;
            private String DESCRIPTION;
            private String ENTERBY;
            private String ENTERDATE;
            private String FPTYPE;
            private String FYND;
            private String INVOICENUM;
            private String PONUM;
            private String PRETAXTOTAL;
            private String REMITADDRESS1;
            private String SITEDESC;
            private String SITEID;
            private String STATUS;
            private String TOTALCOST;
            private String TOTALTAX1;
            private String UDHTBH;
            private String UDXMBH;
            private String VENDOR;
            private String VENDORDESC;
            private String VENDORINVOICENUM;

            public String getA_BUDGETDESC() {
                return A_BUDGETDESC;
            }

            public void setA_BUDGETDESC(String A_BUDGETDESC) {
                this.A_BUDGETDESC = A_BUDGETDESC;
            }

            public String getA_BUDGETNUM() {
                return A_BUDGETNUM;
            }

            public void setA_BUDGETNUM(String A_BUDGETNUM) {
                this.A_BUDGETNUM = A_BUDGETNUM;
            }

            public String getCFZBJ() {
                return CFZBJ;
            }

            public void setCFZBJ(String CFZBJ) {
                this.CFZBJ = CFZBJ;
            }

            public String getCFZBJBL() {
                return CFZBJBL;
            }

            public void setCFZBJBL(String CFZBJBL) {
                this.CFZBJBL = CFZBJBL;
            }

            public String getCONTRACTREFNUM() {
                return CONTRACTREFNUM;
            }

            public void setCONTRACTREFNUM(String CONTRACTREFNUM) {
                this.CONTRACTREFNUM = CONTRACTREFNUM;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getENTERBY() {
                return ENTERBY;
            }

            public void setENTERBY(String ENTERBY) {
                this.ENTERBY = ENTERBY;
            }

            public String getENTERDATE() {
                return ENTERDATE;
            }

            public void setENTERDATE(String ENTERDATE) {
                this.ENTERDATE = ENTERDATE;
            }

            public String getFPTYPE() {
                return FPTYPE;
            }

            public void setFPTYPE(String FPTYPE) {
                this.FPTYPE = FPTYPE;
            }

            public String getFYND() {
                return FYND;
            }

            public void setFYND(String FYND) {
                this.FYND = FYND;
            }

            public String getINVOICENUM() {
                return INVOICENUM;
            }

            public void setINVOICENUM(String INVOICENUM) {
                this.INVOICENUM = INVOICENUM;
            }

            public String getPONUM() {
                return PONUM;
            }

            public void setPONUM(String PONUM) {
                this.PONUM = PONUM;
            }

            public String getPRETAXTOTAL() {
                return PRETAXTOTAL;
            }

            public void setPRETAXTOTAL(String PRETAXTOTAL) {
                this.PRETAXTOTAL = PRETAXTOTAL;
            }

            public String getREMITADDRESS1() {
                return REMITADDRESS1;
            }

            public void setREMITADDRESS1(String REMITADDRESS1) {
                this.REMITADDRESS1 = REMITADDRESS1;
            }

            public String getSITEDESC() {
                return SITEDESC;
            }

            public void setSITEDESC(String SITEDESC) {
                this.SITEDESC = SITEDESC;
            }

            public String getSITEID() {
                return SITEID;
            }

            public void setSITEID(String SITEID) {
                this.SITEID = SITEID;
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

            public String getTOTALTAX1() {
                return TOTALTAX1;
            }

            public void setTOTALTAX1(String TOTALTAX1) {
                this.TOTALTAX1 = TOTALTAX1;
            }

            public String getUDHTBH() {
                return UDHTBH;
            }

            public void setUDHTBH(String UDHTBH) {
                this.UDHTBH = UDHTBH;
            }

            public String getUDXMBH() {
                return UDXMBH;
            }

            public void setUDXMBH(String UDXMBH) {
                this.UDXMBH = UDXMBH;
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

            public String getVENDORINVOICENUM() {
                return VENDORINVOICENUM;
            }

            public void setVENDORINVOICENUM(String VENDORINVOICENUM) {
                this.VENDORINVOICENUM = VENDORINVOICENUM;
            }
        }
    }
}
