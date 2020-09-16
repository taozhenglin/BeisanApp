package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class ChossenStoreListBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"DESCRIPTION":"北三集司","LOCATION":"BSJS","SITEID":"1000","TYPE":"库房"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"DESCRIPTION":"北三集司","LOCATION":"BSJS","SITEID":"1000","TYPE":"库房"}]
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

        public static class ResultlistBean implements Serializable {
            /**
             * DESCRIPTION : 北三集司
             * LOCATION : BSJS
             * SITEID : 1000
             * TYPE : 库房
             */

            private String DESCRIPTION;
            private String LOCATION;
            private String SITEID;
            private String TYPE;

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getLOCATION() {
                return LOCATION;
            }

            public void setLOCATION(String LOCATION) {
                this.LOCATION = LOCATION;
            }

            public String getSITEID() {
                return SITEID;
            }

            public void setSITEID(String SITEID) {
                this.SITEID = SITEID;
            }

            public String getTYPE() {
                return TYPE;
            }

            public void setTYPE(String TYPE) {
                this.TYPE = TYPE;
            }
        }
    }
}
