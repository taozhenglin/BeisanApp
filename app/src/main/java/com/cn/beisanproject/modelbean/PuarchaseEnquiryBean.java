package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class PuarchaseEnquiryBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"安全卫环部","CYHJJE":"0.0000","DESCRIPTION":"app流程测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15969,"RFQNUM":"2519","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"安全卫环部","CYHJJE":"0.0000","DESCRIPTION":"app流程测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15969,"RFQNUM":"2519","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"}]
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
             * A_CONNUM :
             * A_DEPT : 信息中心
             * A_MEMO :
             * A_PURCATALOG : 安全卫环部
             * CYHJJE : 0.0000
             * DESCRIPTION : app流程测试
             * ENTERBY : MAXADMIN
             * ENTERBYDESC : 系统管理员
             * HJJE : 0.0000
             * JHCOST : 0.0000
             * RFQ3 :
             * RFQ3DESC :
             * RFQID : 15969
             * RFQNUM : 2519
             * RFQTYPE : 比价采购
             * RFQTYPEDESC : 比价采购
             * R_MASTERDESC :
             * SITEID : 1000
             * STATUS : 已发送
             */

            private String A_CONNUM;
            private String A_DEPT;
            private String A_MEMO;
            private String A_PURCATALOG;
            private String CYHJJE;
            private String DESCRIPTION;
            private String ENTERBY;
            private String ENTERBYDESC;
            private String HJJE;
            private String JHCOST;
            private String RFQ3;
            private String RFQ3DESC;
            private int RFQID;
            private String RFQNUM;
            private String RFQTYPE;
            private String RFQTYPEDESC;
            private String R_MASTERDESC;
            private String SITEID;
            private String STATUS;

            public String getA_CONNUM() {
                return A_CONNUM;
            }

            public void setA_CONNUM(String A_CONNUM) {
                this.A_CONNUM = A_CONNUM;
            }

            public String getA_DEPT() {
                return A_DEPT;
            }

            public void setA_DEPT(String A_DEPT) {
                this.A_DEPT = A_DEPT;
            }

            public String getA_MEMO() {
                return A_MEMO;
            }

            public void setA_MEMO(String A_MEMO) {
                this.A_MEMO = A_MEMO;
            }

            public String getA_PURCATALOG() {
                return A_PURCATALOG;
            }

            public void setA_PURCATALOG(String A_PURCATALOG) {
                this.A_PURCATALOG = A_PURCATALOG;
            }

            public String getCYHJJE() {
                return CYHJJE;
            }

            public void setCYHJJE(String CYHJJE) {
                this.CYHJJE = CYHJJE;
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

            public String getENTERBYDESC() {
                return ENTERBYDESC;
            }

            public void setENTERBYDESC(String ENTERBYDESC) {
                this.ENTERBYDESC = ENTERBYDESC;
            }

            public String getHJJE() {
                return HJJE;
            }

            public void setHJJE(String HJJE) {
                this.HJJE = HJJE;
            }

            public String getJHCOST() {
                return JHCOST;
            }

            public void setJHCOST(String JHCOST) {
                this.JHCOST = JHCOST;
            }

            public String getRFQ3() {
                return RFQ3;
            }

            public void setRFQ3(String RFQ3) {
                this.RFQ3 = RFQ3;
            }

            public String getRFQ3DESC() {
                return RFQ3DESC;
            }

            public void setRFQ3DESC(String RFQ3DESC) {
                this.RFQ3DESC = RFQ3DESC;
            }

            public int getRFQID() {
                return RFQID;
            }

            public void setRFQID(int RFQID) {
                this.RFQID = RFQID;
            }

            public String getRFQNUM() {
                return RFQNUM;
            }

            public void setRFQNUM(String RFQNUM) {
                this.RFQNUM = RFQNUM;
            }

            public String getRFQTYPE() {
                return RFQTYPE;
            }

            public void setRFQTYPE(String RFQTYPE) {
                this.RFQTYPE = RFQTYPE;
            }

            public String getRFQTYPEDESC() {
                return RFQTYPEDESC;
            }

            public void setRFQTYPEDESC(String RFQTYPEDESC) {
                this.RFQTYPEDESC = RFQTYPEDESC;
            }

            public String getR_MASTERDESC() {
                return R_MASTERDESC;
            }

            public void setR_MASTERDESC(String R_MASTERDESC) {
                this.R_MASTERDESC = R_MASTERDESC;
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
        }
    }
}
