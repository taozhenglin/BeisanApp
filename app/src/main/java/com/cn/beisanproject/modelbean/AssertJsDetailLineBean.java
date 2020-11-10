package com.cn.beisanproject.modelbean;

import java.util.List;

/**
 * Created by tzl
 * on 2020/11/2
 */
public class AssertJsDetailLineBean {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ADMINISTRATORDESC":"","AMOUNT":"1.00","ASSETNUM":"","ASSETTYPE":"","ASSETTYPEDESC":"","BGCOST":"0.00","CFDD":"本公司","CFWZ":"","CWBM":"","CWBMDESC":"","CWBMTYPE":"","DATEOFPURCHASE":"2020-11-10 08:51:50","DATEPLACEDINSERVICE":"","DEPARTMENT":"1.205.001-001","DEPRECIATIONPERIOD":"","DESCRIPTION":"垃圾桶运输四轮电动车","EMPLOYEENUMBERDESC":"","FACTORYDATE":"","FIXASSETDATE":"","GXUNITS":"","JJYT":"非生产经营用","LYFSDESC":"购入","MANAGEMENT":"1.205.001-005","PRODUCTMODEL":"JX1000Y12","REMARKS":"","SYQK":"正常使用","UDCOMPANYDESC":"远东","UDTYPE1DEC":"其他设备","UNITS":"辆","VENDORNAME":"南京洁鑫新能源科技有限公司","ZCCOST":"81,858.41","ZZADMINISTRATOR":"","ZZAMOUNT":"","ZZCOST":"","ZZDATEOFPURCHASE":"","ZZDATEPLACEDINSERVICE":"","ZZDEPARTMENT":"","ZZDEPRECIATIONPERIOD":"","ZZEMPLOYEENUMBER":"","ZZFACTORYDATE":"","ZZFIXASSETDATE":"","ZZJJYT":"","ZZLYFS":"","ZZMANAGEMENT":"","ZZPRODUCTMODEL":"","ZZS":"","ZZSYQK":"","ZZUDCOMPANY":"","ZZUDTYPE1DEC":"","ZZUNITS":"","ZZVENDOR":"","ZZZZS":""}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"ADMINISTRATORDESC":"","AMOUNT":"1.00","ASSETNUM":"","ASSETTYPE":"","ASSETTYPEDESC":"","BGCOST":"0.00","CFDD":"本公司","CFWZ":"","CWBM":"","CWBMDESC":"","CWBMTYPE":"","DATEOFPURCHASE":"2020-11-10 08:51:50","DATEPLACEDINSERVICE":"","DEPARTMENT":"1.205.001-001","DEPRECIATIONPERIOD":"","DESCRIPTION":"垃圾桶运输四轮电动车","EMPLOYEENUMBERDESC":"","FACTORYDATE":"","FIXASSETDATE":"","GXUNITS":"","JJYT":"非生产经营用","LYFSDESC":"购入","MANAGEMENT":"1.205.001-005","PRODUCTMODEL":"JX1000Y12","REMARKS":"","SYQK":"正常使用","UDCOMPANYDESC":"远东","UDTYPE1DEC":"其他设备","UNITS":"辆","VENDORNAME":"南京洁鑫新能源科技有限公司","ZCCOST":"81,858.41","ZZADMINISTRATOR":"","ZZAMOUNT":"","ZZCOST":"","ZZDATEOFPURCHASE":"","ZZDATEPLACEDINSERVICE":"","ZZDEPARTMENT":"","ZZDEPRECIATIONPERIOD":"","ZZEMPLOYEENUMBER":"","ZZFACTORYDATE":"","ZZFIXASSETDATE":"","ZZJJYT":"","ZZLYFS":"","ZZMANAGEMENT":"","ZZPRODUCTMODEL":"","ZZS":"","ZZSYQK":"","ZZUDCOMPANY":"","ZZUDTYPE1DEC":"","ZZUNITS":"","ZZVENDOR":"","ZZZZS":""}]
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
             * ADMINISTRATORDESC :
             * AMOUNT : 1.00
             * ASSETNUM :
             * ASSETTYPE :
             * ASSETTYPEDESC :
             * BGCOST : 0.00
             * CFDD : 本公司
             * CFWZ :
             * CWBM :
             * CWBMDESC :
             * CWBMTYPE :
             * DATEOFPURCHASE : 2020-11-10 08:51:50
             * DATEPLACEDINSERVICE :
             * DEPARTMENT : 1.205.001-001
             * DEPRECIATIONPERIOD :
             * DESCRIPTION : 垃圾桶运输四轮电动车
             * EMPLOYEENUMBERDESC :
             * FACTORYDATE :
             * FIXASSETDATE :
             * GXUNITS :
             * JJYT : 非生产经营用
             * LYFSDESC : 购入
             * MANAGEMENT : 1.205.001-005
             * PRODUCTMODEL : JX1000Y12
             * REMARKS :
             * SYQK : 正常使用
             * UDCOMPANYDESC : 远东
             * UDTYPE1DEC : 其他设备
             * UNITS : 辆
             * VENDORNAME : 南京洁鑫新能源科技有限公司
             * ZCCOST : 81,858.41
             * ZZADMINISTRATOR :
             * ZZAMOUNT :
             * ZZCOST :
             * ZZDATEOFPURCHASE :
             * ZZDATEPLACEDINSERVICE :
             * ZZDEPARTMENT :
             * ZZDEPRECIATIONPERIOD :
             * ZZEMPLOYEENUMBER :
             * ZZFACTORYDATE :
             * ZZFIXASSETDATE :
             * ZZJJYT :
             * ZZLYFS :
             * ZZMANAGEMENT :
             * ZZPRODUCTMODEL :
             * ZZS :
             * ZZSYQK :
             * ZZUDCOMPANY :
             * ZZUDTYPE1DEC :
             * ZZUNITS :
             * ZZVENDOR :
             * ZZZZS :
             */

            private String ADMINISTRATORDESC;
            private String AMOUNT;
            private String ASSETNUM;
            private String ASSETTYPE;
            private String ASSETTYPEDESC;
            private String BGCOST;
            private String CFDD;
            private String CFWZ;
            private String CWBM;
            private String CWBMDESC;
            private String CWBMTYPE;
            private String DATEOFPURCHASE;
            private String DATEPLACEDINSERVICE;
            private String DEPARTMENT;
            private String DEPRECIATIONPERIOD;
            private String DESCRIPTION;
            private String EMPLOYEENUMBERDESC;
            private String FACTORYDATE;
            private String FIXASSETDATE;
            private String GXUNITS;
            private String JJYT;
            private String LYFSDESC;
            private String MANAGEMENT;
            private String PRODUCTMODEL;
            private String REMARKS;
            private String SYQK;
            private String UDCOMPANYDESC;
            private String UDTYPE1DEC;
            private String UNITS;
            private String VENDORNAME;
            private String ZCCOST;
            private String ZZADMINISTRATOR;
            private String ZZAMOUNT;
            private String ZZCOST;
            private String ZZDATEOFPURCHASE;
            private String ZZDATEPLACEDINSERVICE;
            private String ZZDEPARTMENT;
            private String ZZDEPRECIATIONPERIOD;
            private String ZZEMPLOYEENUMBER;
            private String ZZFACTORYDATE;
            private String ZZFIXASSETDATE;
            private String ZZJJYT;
            private String ZZLYFS;
            private String ZZMANAGEMENT;
            private String ZZPRODUCTMODEL;
            private String ZZS;
            private String ZZSYQK;
            private String ZZUDCOMPANY;
            private String ZZUDTYPE1DEC;
            private String ZZUNITS;
            private String ZZVENDOR;
            private String ZZZZS;

            public String getZZCWBM() {
                return ZZCWBM;
            }

            public void setZZCWBM(String ZZCWBM) {
                this.ZZCWBM = ZZCWBM;
            }

            String ZZCWBM;
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

            public String getASSETNUM() {
                return ASSETNUM;
            }

            public void setASSETNUM(String ASSETNUM) {
                this.ASSETNUM = ASSETNUM;
            }

            public String getASSETTYPE() {
                return ASSETTYPE;
            }

            public void setASSETTYPE(String ASSETTYPE) {
                this.ASSETTYPE = ASSETTYPE;
            }

            public String getASSETTYPEDESC() {
                return ASSETTYPEDESC;
            }

            public void setASSETTYPEDESC(String ASSETTYPEDESC) {
                this.ASSETTYPEDESC = ASSETTYPEDESC;
            }

            public String getBGCOST() {
                return BGCOST;
            }

            public void setBGCOST(String BGCOST) {
                this.BGCOST = BGCOST;
            }

            public String getCFDD() {
                return CFDD;
            }

            public void setCFDD(String CFDD) {
                this.CFDD = CFDD;
            }

            public String getCFWZ() {
                return CFWZ;
            }

            public void setCFWZ(String CFWZ) {
                this.CFWZ = CFWZ;
            }

            public String getCWBM() {
                return CWBM;
            }

            public void setCWBM(String CWBM) {
                this.CWBM = CWBM;
            }

            public String getCWBMDESC() {
                return CWBMDESC;
            }

            public void setCWBMDESC(String CWBMDESC) {
                this.CWBMDESC = CWBMDESC;
            }

            public String getCWBMTYPE() {
                return CWBMTYPE;
            }

            public void setCWBMTYPE(String CWBMTYPE) {
                this.CWBMTYPE = CWBMTYPE;
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

            public String getEMPLOYEENUMBERDESC() {
                return EMPLOYEENUMBERDESC;
            }

            public void setEMPLOYEENUMBERDESC(String EMPLOYEENUMBERDESC) {
                this.EMPLOYEENUMBERDESC = EMPLOYEENUMBERDESC;
            }

            public String getFACTORYDATE() {
                return FACTORYDATE;
            }

            public void setFACTORYDATE(String FACTORYDATE) {
                this.FACTORYDATE = FACTORYDATE;
            }

            public String getFIXASSETDATE() {
                return FIXASSETDATE;
            }

            public void setFIXASSETDATE(String FIXASSETDATE) {
                this.FIXASSETDATE = FIXASSETDATE;
            }

            public String getGXUNITS() {
                return GXUNITS;
            }

            public void setGXUNITS(String GXUNITS) {
                this.GXUNITS = GXUNITS;
            }

            public String getJJYT() {
                return JJYT;
            }

            public void setJJYT(String JJYT) {
                this.JJYT = JJYT;
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

            public String getPRODUCTMODEL() {
                return PRODUCTMODEL;
            }

            public void setPRODUCTMODEL(String PRODUCTMODEL) {
                this.PRODUCTMODEL = PRODUCTMODEL;
            }

            public String getREMARKS() {
                return REMARKS;
            }

            public void setREMARKS(String REMARKS) {
                this.REMARKS = REMARKS;
            }

            public String getSYQK() {
                return SYQK;
            }

            public void setSYQK(String SYQK) {
                this.SYQK = SYQK;
            }

            public String getUDCOMPANYDESC() {
                return UDCOMPANYDESC;
            }

            public void setUDCOMPANYDESC(String UDCOMPANYDESC) {
                this.UDCOMPANYDESC = UDCOMPANYDESC;
            }

            public String getUDTYPE1DEC() {
                return UDTYPE1DEC;
            }

            public void setUDTYPE1DEC(String UDTYPE1DEC) {
                this.UDTYPE1DEC = UDTYPE1DEC;
            }

            public String getUNITS() {
                return UNITS;
            }

            public void setUNITS(String UNITS) {
                this.UNITS = UNITS;
            }

            public String getVENDORNAME() {
                return VENDORNAME;
            }

            public void setVENDORNAME(String VENDORNAME) {
                this.VENDORNAME = VENDORNAME;
            }

            public String getZCCOST() {
                return ZCCOST;
            }

            public void setZCCOST(String ZCCOST) {
                this.ZCCOST = ZCCOST;
            }

            public String getZZADMINISTRATOR() {
                return ZZADMINISTRATOR;
            }

            public void setZZADMINISTRATOR(String ZZADMINISTRATOR) {
                this.ZZADMINISTRATOR = ZZADMINISTRATOR;
            }

            public String getZZAMOUNT() {
                return ZZAMOUNT;
            }

            public void setZZAMOUNT(String ZZAMOUNT) {
                this.ZZAMOUNT = ZZAMOUNT;
            }

            public String getZZCOST() {
                return ZZCOST;
            }

            public void setZZCOST(String ZZCOST) {
                this.ZZCOST = ZZCOST;
            }

            public String getZZDATEOFPURCHASE() {
                return ZZDATEOFPURCHASE;
            }

            public void setZZDATEOFPURCHASE(String ZZDATEOFPURCHASE) {
                this.ZZDATEOFPURCHASE = ZZDATEOFPURCHASE;
            }

            public String getZZDATEPLACEDINSERVICE() {
                return ZZDATEPLACEDINSERVICE;
            }

            public void setZZDATEPLACEDINSERVICE(String ZZDATEPLACEDINSERVICE) {
                this.ZZDATEPLACEDINSERVICE = ZZDATEPLACEDINSERVICE;
            }

            public String getZZDEPARTMENT() {
                return ZZDEPARTMENT;
            }

            public void setZZDEPARTMENT(String ZZDEPARTMENT) {
                this.ZZDEPARTMENT = ZZDEPARTMENT;
            }

            public String getZZDEPRECIATIONPERIOD() {
                return ZZDEPRECIATIONPERIOD;
            }

            public void setZZDEPRECIATIONPERIOD(String ZZDEPRECIATIONPERIOD) {
                this.ZZDEPRECIATIONPERIOD = ZZDEPRECIATIONPERIOD;
            }

            public String getZZEMPLOYEENUMBER() {
                return ZZEMPLOYEENUMBER;
            }

            public void setZZEMPLOYEENUMBER(String ZZEMPLOYEENUMBER) {
                this.ZZEMPLOYEENUMBER = ZZEMPLOYEENUMBER;
            }

            public String getZZFACTORYDATE() {
                return ZZFACTORYDATE;
            }

            public void setZZFACTORYDATE(String ZZFACTORYDATE) {
                this.ZZFACTORYDATE = ZZFACTORYDATE;
            }

            public String getZZFIXASSETDATE() {
                return ZZFIXASSETDATE;
            }

            public void setZZFIXASSETDATE(String ZZFIXASSETDATE) {
                this.ZZFIXASSETDATE = ZZFIXASSETDATE;
            }

            public String getZZJJYT() {
                return ZZJJYT;
            }

            public void setZZJJYT(String ZZJJYT) {
                this.ZZJJYT = ZZJJYT;
            }

            public String getZZLYFS() {
                return ZZLYFS;
            }

            public void setZZLYFS(String ZZLYFS) {
                this.ZZLYFS = ZZLYFS;
            }

            public String getZZMANAGEMENT() {
                return ZZMANAGEMENT;
            }

            public void setZZMANAGEMENT(String ZZMANAGEMENT) {
                this.ZZMANAGEMENT = ZZMANAGEMENT;
            }

            public String getZZPRODUCTMODEL() {
                return ZZPRODUCTMODEL;
            }

            public void setZZPRODUCTMODEL(String ZZPRODUCTMODEL) {
                this.ZZPRODUCTMODEL = ZZPRODUCTMODEL;
            }

            public String getZZS() {
                return ZZS;
            }

            public void setZZS(String ZZS) {
                this.ZZS = ZZS;
            }

            public String getZZSYQK() {
                return ZZSYQK;
            }

            public void setZZSYQK(String ZZSYQK) {
                this.ZZSYQK = ZZSYQK;
            }

            public String getZZUDCOMPANY() {
                return ZZUDCOMPANY;
            }

            public void setZZUDCOMPANY(String ZZUDCOMPANY) {
                this.ZZUDCOMPANY = ZZUDCOMPANY;
            }

            public String getZZUDTYPE1DEC() {
                return ZZUDTYPE1DEC;
            }

            public void setZZUDTYPE1DEC(String ZZUDTYPE1DEC) {
                this.ZZUDTYPE1DEC = ZZUDTYPE1DEC;
            }

            public String getZZUNITS() {
                return ZZUNITS;
            }

            public void setZZUNITS(String ZZUNITS) {
                this.ZZUNITS = ZZUNITS;
            }

            public String getZZVENDOR() {
                return ZZVENDOR;
            }

            public void setZZVENDOR(String ZZVENDOR) {
                this.ZZVENDOR = ZZVENDOR;
            }

            public String getZZZZS() {
                return ZZZZS;
            }

            public void setZZZZS(String ZZZZS) {
                this.ZZZZS = ZZZZS;
            }
        }
    }
}
