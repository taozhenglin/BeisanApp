package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class CommmonForMaterialDetailBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"DESCRIPTION":"安全卫环部","VALUE":"安全卫环部"},{"DESCRIPTION":"党群工作部","VALUE":"党群工作部"},{"DESCRIPTION":"工程技术部","VALUE":"工程技术部"},{"DESCRIPTION":"信息中心","VALUE":"信息中心"},{"DESCRIPTION":"行政人事部","VALUE":"行政人事部"}],"showcount":20,"totalpage":1,"totalresult":5}
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
         * resultlist : [{"DESCRIPTION":"安全卫环部","VALUE":"安全卫环部"},{"DESCRIPTION":"党群工作部","VALUE":"党群工作部"},{"DESCRIPTION":"工程技术部","VALUE":"工程技术部"},{"DESCRIPTION":"信息中心","VALUE":"信息中心"},{"DESCRIPTION":"行政人事部","VALUE":"行政人事部"}]
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

        public static class ResultlistBean implements Serializable{
            /**
             * DESCRIPTION : 安全卫环部
             * VALUE : 安全卫环部
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
