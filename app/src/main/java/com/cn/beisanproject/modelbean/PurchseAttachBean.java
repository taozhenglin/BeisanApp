package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class PurchseAttachBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"CREATEDATE":"2020-01-21 08:03:18","DOCDESC":"01月询价-五金2452采购订单（繁润）.xls","DOCINFOID":"11,949","DOCUMENT":"5901"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"CREATEDATE":"2020-01-21 08:03:18","DOCDESC":"01月询价-五金2452采购订单（繁润）.xls","DOCINFOID":"11,949","DOCUMENT":"5901"}]
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
             * CREATEDATE : 2020-01-21 08:03:18
             * DOCDESC : 01月询价-五金2452采购订单（繁润）.xls
             * DOCINFOID : 11,949
             * DOCUMENT : 5901
             */

            private String CREATEDATE;
            private String DOCDESC;
            private String DOCINFOID;
            private String DOCUMENT;
            String DOCLINKSID;

            public String getDOCLINKSID() {
                return DOCLINKSID;
            }

            public void setDOCLINKSID(String DOCLINKSID) {
                this.DOCLINKSID = DOCLINKSID;
            }


            public String getCREATEDATE() {
                return CREATEDATE;
            }

            public void setCREATEDATE(String CREATEDATE) {
                this.CREATEDATE = CREATEDATE;
            }

            public String getDOCDESC() {
                return DOCDESC;
            }

            public void setDOCDESC(String DOCDESC) {
                this.DOCDESC = DOCDESC;
            }

            public String getDOCINFOID() {
                return DOCINFOID;
            }

            public void setDOCINFOID(String DOCINFOID) {
                this.DOCINFOID = DOCINFOID;
            }

            public String getDOCUMENT() {
                return DOCUMENT;
            }

            public void setDOCUMENT(String DOCUMENT) {
                this.DOCUMENT = DOCUMENT;
            }
        }
    }
}
