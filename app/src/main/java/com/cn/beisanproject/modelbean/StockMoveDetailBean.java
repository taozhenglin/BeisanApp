package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class StockMoveDetailBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_DEPT":"工程技术部","A_TODEPT":"工程技术部","A_USEFOR":"堆高机（柴油）","CREWID":"物资","DESCRIPTION":"北三集司库存转移测试","DISPLAYNAME":"贾伟峰","FROMSTORELOC":"BSJS","INVUSEID":481,"INVUSENUM":"1033","REPORTDATE":"2020-09-09 14:40:53","REPORTEDBY":"JIAWF","SITEID":"1000","STATUS":"等待批准"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"A_DEPT":"工程技术部","A_TODEPT":"工程技术部","A_USEFOR":"堆高机（柴油）","CREWID":"物资","DESCRIPTION":"北三集司库存转移测试","DISPLAYNAME":"贾伟峰","FROMSTORELOC":"BSJS","INVUSEID":481,"INVUSENUM":"1033","REPORTDATE":"2020-09-09 14:40:53","REPORTEDBY":"JIAWF","SITEID":"1000","STATUS":"等待批准"}]
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
             * A_DEPT : 工程技术部
             * A_TODEPT : 工程技术部
             * A_USEFOR : 堆高机（柴油）
             * CREWID : 物资
             * DESCRIPTION : 北三集司库存转移测试
             * DISPLAYNAME : 贾伟峰
             * FROMSTORELOC : BSJS
             * INVUSEID : 481
             * INVUSENUM : 1033
             * REPORTDATE : 2020-09-09 14:40:53
             * REPORTEDBY : JIAWF
             * SITEID : 1000
             * STATUS : 等待批准
             */

            private String A_DEPT;
            private String A_TODEPT;
            private String A_USEFOR;
            private String CREWID;
            private String DESCRIPTION;
            private String DISPLAYNAME;
            private String FROMSTORELOC;
            private int INVUSEID;
            private String INVUSENUM;
            private String REPORTDATE;
            private String REPORTEDBY;
            private String SITEID;
            private String STATUS;

            public String getA_DEPT() {
                return A_DEPT;
            }

            public void setA_DEPT(String A_DEPT) {
                this.A_DEPT = A_DEPT;
            }

            public String getA_TODEPT() {
                return A_TODEPT;
            }

            public void setA_TODEPT(String A_TODEPT) {
                this.A_TODEPT = A_TODEPT;
            }

            public String getA_USEFOR() {
                return A_USEFOR;
            }

            public void setA_USEFOR(String A_USEFOR) {
                this.A_USEFOR = A_USEFOR;
            }

            public String getCREWID() {
                return CREWID;
            }

            public void setCREWID(String CREWID) {
                this.CREWID = CREWID;
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

            public String getFROMSTORELOC() {
                return FROMSTORELOC;
            }

            public void setFROMSTORELOC(String FROMSTORELOC) {
                this.FROMSTORELOC = FROMSTORELOC;
            }

            public int getINVUSEID() {
                return INVUSEID;
            }

            public void setINVUSEID(int INVUSEID) {
                this.INVUSEID = INVUSEID;
            }

            public String getINVUSENUM() {
                return INVUSENUM;
            }

            public void setINVUSENUM(String INVUSENUM) {
                this.INVUSENUM = INVUSENUM;
            }

            public String getREPORTDATE() {
                return REPORTDATE;
            }

            public void setREPORTDATE(String REPORTDATE) {
                this.REPORTDATE = REPORTDATE;
            }

            public String getREPORTEDBY() {
                return REPORTEDBY;
            }

            public void setREPORTEDBY(String REPORTEDBY) {
                this.REPORTEDBY = REPORTEDBY;
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
