package com.cn.beisanproject.modelbean;

import java.util.List;

/**
 * Created by tzl
 * on 2020/11/6
 */
public class AssertCzDetailLineBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"COST":"1,029.00","CWBM":"","DATEOFPURCHASE":"2009-06-30 00:00:00","DATEPLACEDINSERVICE":"2009-06-30 00:00:00","DEPARTMENT":"","DESCRIPTION":"","FIXASSETDATE":"2009-06-30 00:00:00","LOCATION":"","PRODUCTMODEL":"海尔BC-117FC","SCRAPYPE":"出售","UDCOMPANY":"远东"},{"COST":"1,980.00","CWBM":"","DATEOFPURCHASE":"2006-11-30 00:00:00","DATEPLACEDINSERVICE":"2006-11-30 00:00:00","DEPARTMENT":"","DESCRIPTION":"","FIXASSETDATE":"2006-11-30 00:00:00","LOCATION":"","PRODUCTMODEL":"永发牌T68BC3C","SCRAPYPE":"捐赠","UDCOMPANY":"远东"}],"showcount":20,"totalpage":1,"totalresult":2}
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
         * resultlist : [{"COST":"1,029.00","CWBM":"","DATEOFPURCHASE":"2009-06-30 00:00:00","DATEPLACEDINSERVICE":"2009-06-30 00:00:00","DEPARTMENT":"","DESCRIPTION":"","FIXASSETDATE":"2009-06-30 00:00:00","LOCATION":"","PRODUCTMODEL":"海尔BC-117FC","SCRAPYPE":"出售","UDCOMPANY":"远东"},{"COST":"1,980.00","CWBM":"","DATEOFPURCHASE":"2006-11-30 00:00:00","DATEPLACEDINSERVICE":"2006-11-30 00:00:00","DEPARTMENT":"","DESCRIPTION":"","FIXASSETDATE":"2006-11-30 00:00:00","LOCATION":"","PRODUCTMODEL":"永发牌T68BC3C","SCRAPYPE":"捐赠","UDCOMPANY":"远东"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 2
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
             * COST : 1,029.00
             * CWBM :
             * DATEOFPURCHASE : 2009-06-30 00:00:00
             * DATEPLACEDINSERVICE : 2009-06-30 00:00:00
             * DEPARTMENT :
             * DESCRIPTION :
             * FIXASSETDATE : 2009-06-30 00:00:00
             * LOCATION :
             * PRODUCTMODEL : 海尔BC-117FC
             * SCRAPYPE : 出售
             * UDCOMPANY : 远东
             */

            private String COST;
            private String CWBM;
            private String DATEOFPURCHASE;
            private String DATEPLACEDINSERVICE;
            private String DEPARTMENT;
            private String DESCRIPTION;
            private String FIXASSETDATE;
            private String LOCATION;
            private String PRODUCTMODEL;
            private String SCRAPYPE;
            private String UDCOMPANY;

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

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getFIXASSETDATE() {
                return FIXASSETDATE;
            }

            public void setFIXASSETDATE(String FIXASSETDATE) {
                this.FIXASSETDATE = FIXASSETDATE;
            }

            public String getLOCATION() {
                return LOCATION;
            }

            public void setLOCATION(String LOCATION) {
                this.LOCATION = LOCATION;
            }

            public String getPRODUCTMODEL() {
                return PRODUCTMODEL;
            }

            public void setPRODUCTMODEL(String PRODUCTMODEL) {
                this.PRODUCTMODEL = PRODUCTMODEL;
            }

            public String getSCRAPYPE() {
                return SCRAPYPE;
            }

            public void setSCRAPYPE(String SCRAPYPE) {
                this.SCRAPYPE = SCRAPYPE;
            }

            public String getUDCOMPANY() {
                return UDCOMPANY;
            }

            public void setUDCOMPANY(String UDCOMPANY) {
                this.UDCOMPANY = UDCOMPANY;
            }
        }
    }
}
