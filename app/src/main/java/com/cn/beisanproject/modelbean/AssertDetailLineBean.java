package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class AssertDetailLineBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ADMINISTRATOR":"ZHANGQN","AMOUNT":"1.00","ASSETTYPE":"","CFDD":"仓库","COST":"23,434.00","DATEOFPURCHASE":"2019-05-14 17:52:23","DATEPLACEDINSERVICE":"2020-05-11 17:52:34","DEPARTMENT":"信息中心","DEPRECIATIONPERIOD":"2.00","DESCRIPTION":"打印机","DISPLAYNAME":"张乾能","EMPLOYEENUMBER":"ZHANGXL","FIXASSETDATE":"2019-05-14 17:52:28","FIXASSETNUM":"1500-C0337","MANAGEMENT":"信息中心","OWNERSITE":"","PRODUCTMODEL":"TEMN0634","SGCOM":"","SYQK":"使用","YPD":"Y"},{"ADMINISTRATOR":"ZHANGXL","AMOUNT":"2.00","ASSETTYPE":"","CFDD":"仓库","COST":"132,132.00","DATEOFPURCHASE":"2020-05-04 18:53:00","DATEPLACEDINSERVICE":"2020-05-07 18:53:05","DEPARTMENT":"信息中心","DEPRECIATIONPERIOD":"2.00","DESCRIPTION":"设备转固","DISPLAYNAME":"张晓璐","EMPLOYEENUMBER":"HUYUE","FIXASSETDATE":"2020-05-12 18:53:02","FIXASSETNUM":"CS00012","MANAGEMENT":"信息中心","OWNERSITE":"","PRODUCTMODEL":"WQEWQ324","SGCOM":"","SYQK":"使用","YPD":"Y"},{"ADMINISTRATOR":"BAOSY","AMOUNT":"1.00","ASSETTYPE":"有形资产","CFDD":"码头","COST":"10,000.00","DATEOFPURCHASE":"","DATEPLACEDINSERVICE":"","DEPARTMENT":"工程技术部","DEPRECIATIONPERIOD":"1.00","DESCRIPTION":"固定资产A","DISPLAYNAME":"包世云","EMPLOYEENUMBER":"BAOSY","FIXASSETDATE":"2020-03-11 00:00:00","FIXASSETNUM":"GDZC002","MANAGEMENT":"工程技术部","OWNERSITE":"BS","PRODUCTMODEL":"A-01","SGCOM":"A单位","SYQK":"使用","YPD":"Y"},{"ADMINISTRATOR":"BAOSY","AMOUNT":"1.00","ASSETTYPE":"有形资产","CFDD":"码头","COST":"10,000.00","DATEOFPURCHASE":"2020-03-11 00:00:00","DATEPLACEDINSERVICE":"2020-03-11 00:00:00","DEPARTMENT":"工程技术部","DEPRECIATIONPERIOD":"1.00","DESCRIPTION":"固定资产A","DISPLAYNAME":"包世云","EMPLOYEENUMBER":"ZHANGH","FIXASSETDATE":"2020-03-11 00:00:00","FIXASSETNUM":"GDZC001","MANAGEMENT":"工程技术部","OWNERSITE":"BS","PRODUCTMODEL":"A-01","SGCOM":"A单位","SYQK":"使用","YPD":"Y"},{"ADMINISTRATOR":"BAOSY","AMOUNT":"1.00","ASSETTYPE":"有形资产","CFDD":"码头","COST":"10,000.00","DATEOFPURCHASE":"2020-03-11 00:00:00","DATEPLACEDINSERVICE":"2020-03-11 00:00:00","DEPARTMENT":"工程技术部","DEPRECIATIONPERIOD":"1.00","DESCRIPTION":"固定资产A","DISPLAYNAME":"包世云","EMPLOYEENUMBER":"ZHANGH","FIXASSETDATE":"2020-03-11 00:00:00","FIXASSETNUM":"GDZC001","MANAGEMENT":"工程技术部","OWNERSITE":"BS","PRODUCTMODEL":"A-01","SGCOM":"A单位","SYQK":"使用","YPD":"Y"}],"showcount":20,"totalpage":1,"totalresult":5}
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
         * resultlist : [{"ADMINISTRATOR":"ZHANGQN","AMOUNT":"1.00","ASSETTYPE":"","CFDD":"仓库","COST":"23,434.00","DATEOFPURCHASE":"2019-05-14 17:52:23","DATEPLACEDINSERVICE":"2020-05-11 17:52:34","DEPARTMENT":"信息中心","DEPRECIATIONPERIOD":"2.00","DESCRIPTION":"打印机","DISPLAYNAME":"张乾能","EMPLOYEENUMBER":"ZHANGXL","FIXASSETDATE":"2019-05-14 17:52:28","FIXASSETNUM":"1500-C0337","MANAGEMENT":"信息中心","OWNERSITE":"","PRODUCTMODEL":"TEMN0634","SGCOM":"","SYQK":"使用","YPD":"Y"},{"ADMINISTRATOR":"ZHANGXL","AMOUNT":"2.00","ASSETTYPE":"","CFDD":"仓库","COST":"132,132.00","DATEOFPURCHASE":"2020-05-04 18:53:00","DATEPLACEDINSERVICE":"2020-05-07 18:53:05","DEPARTMENT":"信息中心","DEPRECIATIONPERIOD":"2.00","DESCRIPTION":"设备转固","DISPLAYNAME":"张晓璐","EMPLOYEENUMBER":"HUYUE","FIXASSETDATE":"2020-05-12 18:53:02","FIXASSETNUM":"CS00012","MANAGEMENT":"信息中心","OWNERSITE":"","PRODUCTMODEL":"WQEWQ324","SGCOM":"","SYQK":"使用","YPD":"Y"},{"ADMINISTRATOR":"BAOSY","AMOUNT":"1.00","ASSETTYPE":"有形资产","CFDD":"码头","COST":"10,000.00","DATEOFPURCHASE":"","DATEPLACEDINSERVICE":"","DEPARTMENT":"工程技术部","DEPRECIATIONPERIOD":"1.00","DESCRIPTION":"固定资产A","DISPLAYNAME":"包世云","EMPLOYEENUMBER":"BAOSY","FIXASSETDATE":"2020-03-11 00:00:00","FIXASSETNUM":"GDZC002","MANAGEMENT":"工程技术部","OWNERSITE":"BS","PRODUCTMODEL":"A-01","SGCOM":"A单位","SYQK":"使用","YPD":"Y"},{"ADMINISTRATOR":"BAOSY","AMOUNT":"1.00","ASSETTYPE":"有形资产","CFDD":"码头","COST":"10,000.00","DATEOFPURCHASE":"2020-03-11 00:00:00","DATEPLACEDINSERVICE":"2020-03-11 00:00:00","DEPARTMENT":"工程技术部","DEPRECIATIONPERIOD":"1.00","DESCRIPTION":"固定资产A","DISPLAYNAME":"包世云","EMPLOYEENUMBER":"ZHANGH","FIXASSETDATE":"2020-03-11 00:00:00","FIXASSETNUM":"GDZC001","MANAGEMENT":"工程技术部","OWNERSITE":"BS","PRODUCTMODEL":"A-01","SGCOM":"A单位","SYQK":"使用","YPD":"Y"},{"ADMINISTRATOR":"BAOSY","AMOUNT":"1.00","ASSETTYPE":"有形资产","CFDD":"码头","COST":"10,000.00","DATEOFPURCHASE":"2020-03-11 00:00:00","DATEPLACEDINSERVICE":"2020-03-11 00:00:00","DEPARTMENT":"工程技术部","DEPRECIATIONPERIOD":"1.00","DESCRIPTION":"固定资产A","DISPLAYNAME":"包世云","EMPLOYEENUMBER":"ZHANGH","FIXASSETDATE":"2020-03-11 00:00:00","FIXASSETNUM":"GDZC001","MANAGEMENT":"工程技术部","OWNERSITE":"BS","PRODUCTMODEL":"A-01","SGCOM":"A单位","SYQK":"使用","YPD":"Y"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 5
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
             * ADMINISTRATOR : ZHANGQN
             * AMOUNT : 1.00
             * ASSETTYPE :
             * CFDD : 仓库
             * COST : 23,434.00
             * DATEOFPURCHASE : 2019-05-14 17:52:23
             * DATEPLACEDINSERVICE : 2020-05-11 17:52:34
             * DEPARTMENT : 信息中心
             * DEPRECIATIONPERIOD : 2.00
             * DESCRIPTION : 打印机
             * DISPLAYNAME : 张乾能
             * EMPLOYEENUMBER : ZHANGXL
             * FIXASSETDATE : 2019-05-14 17:52:28
             * FIXASSETNUM : 1500-C0337
             * MANAGEMENT : 信息中心
             * OWNERSITE :
             * PRODUCTMODEL : TEMN0634
             * SGCOM :
             * SYQK : 使用
             * YPD : Y
             */

            private String ADMINISTRATOR;
            private String AMOUNT;
            private String ASSETTYPE;
            private String CFDD;
            private String COST;
            private String DATEOFPURCHASE;
            private String DATEPLACEDINSERVICE;
            private String DEPARTMENT;
            private String DEPRECIATIONPERIOD;
            private String DESCRIPTION;
            private String DISPLAYNAME;
            private String EMPLOYEENUMBER;
            private String FIXASSETDATE;
            private String FIXASSETNUM;
            private int FIXPDLINEID;
            private String MANAGEMENT;
            private String OWNERSITE;

            String PDJGCFWZ;
            String  PDHSYBM;
            public String getPDJGCFWZ() {
                return PDJGCFWZ;
            }

            public void setPDJGCFWZ(String PDJGCFWZ) {
                this.PDJGCFWZ = PDJGCFWZ;
            }

            public String getPDHSYBM() {
                return PDHSYBM;
            }

            public void setPDHSYBM(String PDHSYBM) {
                this.PDHSYBM = PDHSYBM;
            }

            private String PRODUCTMODEL;
            private String RFIDNUM;
            private String SGCOM;
            private String SYQK;
            private String YPD;

            public String getADMINISTRATOR() {
                return ADMINISTRATOR;
            }

            public void setADMINISTRATOR(String ADMINISTRATOR) {
                this.ADMINISTRATOR = ADMINISTRATOR;
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

            public String getDISPLAYNAME() {
                return DISPLAYNAME;
            }

            public void setDISPLAYNAME(String DISPLAYNAME) {
                this.DISPLAYNAME = DISPLAYNAME;
            }

            public String getEMPLOYEENUMBER() {
                return EMPLOYEENUMBER;
            }

            public void setEMPLOYEENUMBER(String EMPLOYEENUMBER) {
                this.EMPLOYEENUMBER = EMPLOYEENUMBER;
            }

            public String getFIXASSETDATE() {
                return FIXASSETDATE;
            }

            public void setFIXASSETDATE(String FIXASSETDATE) {
                this.FIXASSETDATE = FIXASSETDATE;
            }

            public String getFIXASSETNUM() {
                return FIXASSETNUM;
            }

            public void setFIXASSETNUM(String FIXASSETNUM) {
                this.FIXASSETNUM = FIXASSETNUM;
            }

            public int getFIXPDLINEID() {
                return FIXPDLINEID;
            }

            public void setFIXPDLINEID(int FIXPDLINEID) {
                this.FIXPDLINEID = FIXPDLINEID;
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

            public String getPRODUCTMODEL() {
                return PRODUCTMODEL;
            }

            public void setPRODUCTMODEL(String PRODUCTMODEL) {
                this.PRODUCTMODEL = PRODUCTMODEL;
            }
            public String getRFIDNUM() {
                return RFIDNUM;
            }

            public void setRFIDNUM(String RFIDNUM) {
                this.RFIDNUM = RFIDNUM;
            }

            public String getSGCOM() {
                return SGCOM;
            }

            public void setSGCOM(String SGCOM) {
                this.SGCOM = SGCOM;
            }

            public String getSYQK() {
                return SYQK;
            }

            public void setSYQK(String SYQK) {
                this.SYQK = SYQK;
            }

            public String getYPD() {
                return YPD;
            }

            public void setYPD(String YPD) {
                this.YPD = YPD;
            }
        }
    }
}
