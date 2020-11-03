package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class AssertCheckListBean implements Serializable {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ENDDATE":"2020-09-26 19:15:10","FIXPDNUM":"1395","MEMO":"","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"","PDZTDATE":"","STARTDATE":"2020-09-20 19:15:09"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"ENDDATE":"2020-09-26 19:15:10","FIXPDNUM":"1395","MEMO":"","PDUSER":"MAXADMIN","PDUSERDESC":"系统管理员","PDZT":"","PDZTDATE":"","STARTDATE":"2020-09-20 19:15:09"}]
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

        public static class ResultlistBean implements Serializable{
            /**
             * ENDDATE : 2020-09-26 19:15:10
             * FIXPDNUM : 1395
             * MEMO :
             * PDUSER : MAXADMIN
             * PDUSERDESC : 系统管理员
             * PDZT :
             * PDZTDATE :
             * STARTDATE : 2020-09-20 19:15:09
             */

            private String ENDDATE;
            private String FIXPDNUM;
            private String MEMO;
            private String PDUSER;
            private String PDUSERDESC;
            private String PDZT;
            private String PDZTDATE;
            private String STARTDATE;

            public String getENDDATE() {
                return ENDDATE;
            }

            public void setENDDATE(String ENDDATE) {
                this.ENDDATE = ENDDATE;
            }

            public String getFIXPDNUM() {
                return FIXPDNUM;
            }

            public void setFIXPDNUM(String FIXPDNUM) {
                this.FIXPDNUM = FIXPDNUM;
            }

            public String getMEMO() {
                return MEMO;
            }

            public void setMEMO(String MEMO) {
                this.MEMO = MEMO;
            }

            public String getPDUSER() {
                return PDUSER;
            }

            public void setPDUSER(String PDUSER) {
                this.PDUSER = PDUSER;
            }

            public String getPDUSERDESC() {
                return PDUSERDESC;
            }

            public void setPDUSERDESC(String PDUSERDESC) {
                this.PDUSERDESC = PDUSERDESC;
            }

            public String getPDZT() {
                return PDZT;
            }

            public void setPDZT(String PDZT) {
                this.PDZT = PDZT;
            }

            public String getPDZTDATE() {
                return PDZTDATE;
            }

            public void setPDZTDATE(String PDZTDATE) {
                this.PDZTDATE = PDZTDATE;
            }

            public String getSTARTDATE() {
                return STARTDATE;
            }

            public void setSTARTDATE(String STARTDATE) {
                this.STARTDATE = STARTDATE;
            }
        }
    }
}
