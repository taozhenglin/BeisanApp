package com.cn.beisanproject.modelbean;

import java.util.List;

public class AssaginListBean  {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"DESCRIPTION":"请陈勇宁代签合同，方剑波","VALUE":"请陈勇宁代签合同，方剑波"},{"DESCRIPTION":"请董升代签合同，方剑波","VALUE":"请董升代签合同，方剑波"},{"DESCRIPTION":"请傅国成代签合同，方剑波","VALUE":"请傅国成代签合同，方剑波"},{"DESCRIPTION":"请韩辉代签合同，方剑波","VALUE":"请韩辉代签合同，方剑波"},{"DESCRIPTION":"请蒋建清代签合同，方剑波","VALUE":"请蒋建清代签合同，方剑波"},{"DESCRIPTION":"请夏晓峰代签合同,方剑波","VALUE":"请夏晓峰代签合同,方剑波"},{"DESCRIPTION":"请张哲代签合同，方剑波","VALUE":"请张哲代签合同，方剑波"}],"showcount":20,"totalpage":1,"totalresult":7}
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
         * resultlist : [{"DESCRIPTION":"请陈勇宁代签合同，方剑波","VALUE":"请陈勇宁代签合同，方剑波"},{"DESCRIPTION":"请董升代签合同，方剑波","VALUE":"请董升代签合同，方剑波"},{"DESCRIPTION":"请傅国成代签合同，方剑波","VALUE":"请傅国成代签合同，方剑波"},{"DESCRIPTION":"请韩辉代签合同，方剑波","VALUE":"请韩辉代签合同，方剑波"},{"DESCRIPTION":"请蒋建清代签合同，方剑波","VALUE":"请蒋建清代签合同，方剑波"},{"DESCRIPTION":"请夏晓峰代签合同,方剑波","VALUE":"请夏晓峰代签合同,方剑波"},{"DESCRIPTION":"请张哲代签合同，方剑波","VALUE":"请张哲代签合同，方剑波"}]
         * showcount : 20
         * totalpage : 1
         * totalresult : 7
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
             * DESCRIPTION : 请陈勇宁代签合同，方剑波
             * VALUE : 请陈勇宁代签合同，方剑波
             */

            private String DESCRIPTION;
            private String VALUE;

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getVALUE() {
                return VALUE;
            }

            public void setVALUE(String VALUE) {
                this.VALUE = VALUE;
            }
        }
    }
}
