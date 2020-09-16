package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class AssertScanDetailResult  implements Serializable {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ADMINISTRATOR":"","ADMINISTRATORDESC":"","AMOUNT":"2.00","ASSETTYPE":"有形资产","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","CFDD":"DC009","COST":"2.00","CWBM":"AA","DATEOFPURCHASE":"2020-08-03 15:01:25","DATEPLACEDINSERVICE":"","DEPARTMENT":"食堂","DEPRECIATIONPERIOD":"","DESCRIPTION":"AAA","EMPLOYEENUMBER":"","EMPLOYEENUMBERDESC":"","FIXASSETDATE":"","FIXEDASSETJSNUM":"","FIXEDASSETJSNUMDESC":"","FIXENDDATE":"","JJYT":"非生产经营","LYFS":"00106","LYFSDESC":"在建工程转入","MANAGEMENT":"信息中心","OWNERSITE":"","OWNERSITEDESC":"","PRDESC":"2#固定吊动力电缆更换","PRNUM":"XM00011","PRODUCTMODEL":"AA","SGCOM":"","STATUS":"等待批准","SYQK":"变卖","UNITS":"1","VENDOR":"GK11024","VENDORDESC":"浙江双羊集团有限公司"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"ADMINISTRATOR":"","ADMINISTRATORDESC":"","AMOUNT":"2.00","ASSETTYPE":"有形资产","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","CFDD":"DC009","COST":"2.00","CWBM":"AA","DATEOFPURCHASE":"2020-08-03 15:01:25","DATEPLACEDINSERVICE":"","DEPARTMENT":"食堂","DEPRECIATIONPERIOD":"","DESCRIPTION":"AAA","EMPLOYEENUMBER":"","EMPLOYEENUMBERDESC":"","FIXASSETDATE":"","FIXEDASSETJSNUM":"","FIXEDASSETJSNUMDESC":"","FIXENDDATE":"","JJYT":"非生产经营","LYFS":"00106","LYFSDESC":"在建工程转入","MANAGEMENT":"信息中心","OWNERSITE":"","OWNERSITEDESC":"","PRDESC":"2#固定吊动力电缆更换","PRNUM":"XM00011","PRODUCTMODEL":"AA","SGCOM":"","STATUS":"等待批准","SYQK":"变卖","UNITS":"1","VENDOR":"GK11024","VENDORDESC":"浙江双羊集团有限公司"}]
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
             * ADMINISTRATOR :
             * ADMINISTRATORDESC :
             * AMOUNT : 2.00
             * ASSETTYPE : 有形资产
             * A_BUDGETDESC : 龙门吊委外维修费用
             * A_BUDGETNUM : 2019CB-XL-R
             * CFDD : DC009
             * COST : 2.00
             * CWBM : AA
             * DATEOFPURCHASE : 2020-08-03 15:01:25
             * DATEPLACEDINSERVICE :
             * DEPARTMENT : 食堂
             * DEPRECIATIONPERIOD :
             * DESCRIPTION : AAA
             * EMPLOYEENUMBER :
             * EMPLOYEENUMBERDESC :
             * FIXASSETDATE :
             * FIXEDASSETJSNUM :
             * FIXEDASSETJSNUMDESC :
             * FIXENDDATE :
             * JJYT : 非生产经营
             * LYFS : 00106
             * LYFSDESC : 在建工程转入
             * MANAGEMENT : 信息中心
             * OWNERSITE :
             * OWNERSITEDESC :
             * PRDESC : 2#固定吊动力电缆更换
             * PRNUM : XM00011
             * PRODUCTMODEL : AA
             * SGCOM :
             * STATUS : 等待批准
             * SYQK : 变卖
             * UNITS : 1
             * VENDOR : GK11024
             * VENDORDESC : 浙江双羊集团有限公司
             */

            private String ADMINISTRATOR;
            private String ADMINISTRATORDESC;
            private String AMOUNT;
            private String ASSETTYPE;
            private String A_BUDGETDESC;
            private String A_BUDGETNUM;
            private String CFDD;
            private String COST;
            private String CWBM;
            private String DATEOFPURCHASE;
            private String DATEPLACEDINSERVICE;
            private String DEPARTMENT;
            private String DEPRECIATIONPERIOD;
            private String DESCRIPTION;
            private String EMPLOYEENUMBER;
            private String EMPLOYEENUMBERDESC;
            private String FIXASSETDATE;
            private String FIXEDASSETJSNUM;
            private String FIXEDASSETJSNUMDESC;
            private String FIXENDDATE;
            private String JJYT;
            private String LYFS;
            private String LYFSDESC;
            private String MANAGEMENT;
            private String OWNERSITE;
            private String OWNERSITEDESC;
            private String PRDESC;
            private String PRNUM;
            private String PRODUCTMODEL;
            private String SGCOM;
            private String STATUS;
            private String SYQK;
            private String UNITS;
            private String VENDOR;
            private String VENDORDESC;

            public String getADMINISTRATOR() {
                return ADMINISTRATOR;
            }

            public void setADMINISTRATOR(String ADMINISTRATOR) {
                this.ADMINISTRATOR = ADMINISTRATOR;
            }

            public String getADMINISTRATORDESC() {
                return ADMINISTRATORDESC;
            }

            public void setADMINISTRATORDESC(String ADMINISTRATORDESC) {
                this.ADMINISTRATORDESC = ADMINISTRATORDESC;
            }

            public String getAMOUNT() {
                return AMOUNT;
            }

            public void setAMOUNT(String AMOUNT) {
                this.AMOUNT = AMOUNT;
            }

            public String getASSETTYPE() {
                return ASSETTYPE;
            }

            public void setASSETTYPE(String ASSETTYPE) {
                this.ASSETTYPE = ASSETTYPE;
            }

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

            public String getCFDD() {
                return CFDD;
            }

            public void setCFDD(String CFDD) {
                this.CFDD = CFDD;
            }

            public String getCOST() {
                return COST;
            }

            public void setCOST(String COST) {
                this.COST = COST;
            }

            public String getCWBM() {
                return CWBM;
            }

            public void setCWBM(String CWBM) {
                this.CWBM = CWBM;
            }

            public String getDATEOFPURCHASE() {
                return DATEOFPURCHASE;
            }

            public void setDATEOFPURCHASE(String DATEOFPURCHASE) {
                this.DATEOFPURCHASE = DATEOFPURCHASE;
            }

            public String getDATEPLACEDINSERVICE() {
                return DATEPLACEDINSERVICE;
            }

            public void setDATEPLACEDINSERVICE(String DATEPLACEDINSERVICE) {
                this.DATEPLACEDINSERVICE = DATEPLACEDINSERVICE;
            }

            public String getDEPARTMENT() {
                return DEPARTMENT;
            }

            public void setDEPARTMENT(String DEPARTMENT) {
                this.DEPARTMENT = DEPARTMENT;
            }

            public String getDEPRECIATIONPERIOD() {
                return DEPRECIATIONPERIOD;
            }

            public void setDEPRECIATIONPERIOD(String DEPRECIATIONPERIOD) {
                this.DEPRECIATIONPERIOD = DEPRECIATIONPERIOD;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getEMPLOYEENUMBER() {
                return EMPLOYEENUMBER;
            }

            public void setEMPLOYEENUMBER(String EMPLOYEENUMBER) {
                this.EMPLOYEENUMBER = EMPLOYEENUMBER;
            }

            public String getEMPLOYEENUMBERDESC() {
                return EMPLOYEENUMBERDESC;
            }

            public void setEMPLOYEENUMBERDESC(String EMPLOYEENUMBERDESC) {
                this.EMPLOYEENUMBERDESC = EMPLOYEENUMBERDESC;
            }

            public String getFIXASSETDATE() {
                return FIXASSETDATE;
            }

            public void setFIXASSETDATE(String FIXASSETDATE) {
                this.FIXASSETDATE = FIXASSETDATE;
            }

            public String getFIXEDASSETJSNUM() {
                return FIXEDASSETJSNUM;
            }

            public void setFIXEDASSETJSNUM(String FIXEDASSETJSNUM) {
                this.FIXEDASSETJSNUM = FIXEDASSETJSNUM;
            }

            public String getFIXEDASSETJSNUMDESC() {
                return FIXEDASSETJSNUMDESC;
            }

            public void setFIXEDASSETJSNUMDESC(String FIXEDASSETJSNUMDESC) {
                this.FIXEDASSETJSNUMDESC = FIXEDASSETJSNUMDESC;
            }

            public String getFIXENDDATE() {
                return FIXENDDATE;
            }

            public void setFIXENDDATE(String FIXENDDATE) {
                this.FIXENDDATE = FIXENDDATE;
            }

            public String getJJYT() {
                return JJYT;
            }

            public void setJJYT(String JJYT) {
                this.JJYT = JJYT;
            }

            public String getLYFS() {
                return LYFS;
            }

            public void setLYFS(String LYFS) {
                this.LYFS = LYFS;
            }

            public String getLYFSDESC() {
                return LYFSDESC;
            }

            public void setLYFSDESC(String LYFSDESC) {
                this.LYFSDESC = LYFSDESC;
            }

            public String getMANAGEMENT() {
                return MANAGEMENT;
            }

            public void setMANAGEMENT(String MANAGEMENT) {
                this.MANAGEMENT = MANAGEMENT;
            }

            public String getOWNERSITE() {
                return OWNERSITE;
            }

            public void setOWNERSITE(String OWNERSITE) {
                this.OWNERSITE = OWNERSITE;
            }

            public String getOWNERSITEDESC() {
                return OWNERSITEDESC;
            }

            public void setOWNERSITEDESC(String OWNERSITEDESC) {
                this.OWNERSITEDESC = OWNERSITEDESC;
            }

            public String getPRDESC() {
                return PRDESC;
            }

            public void setPRDESC(String PRDESC) {
                this.PRDESC = PRDESC;
            }

            public String getPRNUM() {
                return PRNUM;
            }

            public void setPRNUM(String PRNUM) {
                this.PRNUM = PRNUM;
            }

            public String getPRODUCTMODEL() {
                return PRODUCTMODEL;
            }

            public void setPRODUCTMODEL(String PRODUCTMODEL) {
                this.PRODUCTMODEL = PRODUCTMODEL;
            }

            public String getSGCOM() {
                return SGCOM;
            }

            public void setSGCOM(String SGCOM) {
                this.SGCOM = SGCOM;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getSYQK() {
                return SYQK;
            }

            public void setSYQK(String SYQK) {
                this.SYQK = SYQK;
            }

            public String getUNITS() {
                return UNITS;
            }

            public void setUNITS(String UNITS) {
                this.UNITS = UNITS;
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
