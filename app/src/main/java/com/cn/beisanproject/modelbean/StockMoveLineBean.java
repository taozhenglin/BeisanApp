package com.cn.beisanproject.modelbean;

import java.util.List;

public class StockMoveLineBean {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"DESCRIPTION":"刹车冷却油滤芯","FROMBIN":"TEMP","FROMLOT":"B3CT27692-7-20180315","INVUSENUM":"1294","ITEMNUM":"435770009","LINETYPE":"项目","QUANTITY":"4.00","SITEID":"1000","TOBIN":"","TOLOT":"B3CT27692-7-20180315","TOSTORELOC":"LJ","USETYPE":"转移"}],"showcount":20,"totalpage":1,"totalresult":1}
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
         * resultlist : [{"DESCRIPTION":"刹车冷却油滤芯","FROMBIN":"TEMP","FROMLOT":"B3CT27692-7-20180315","INVUSENUM":"1294","ITEMNUM":"435770009","LINETYPE":"项目","QUANTITY":"4.00","SITEID":"1000","TOBIN":"","TOLOT":"B3CT27692-7-20180315","TOSTORELOC":"LJ","USETYPE":"转移"}]
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
             * DESCRIPTION : 刹车冷却油滤芯
             * FROMBIN : TEMP
             * FROMLOT : B3CT27692-7-20180315
             * INVUSENUM : 1294
             * ITEMNUM : 435770009
             * LINETYPE : 项目
             * QUANTITY : 4.00
             * SITEID : 1000
             * TOBIN :
             * TOLOT : B3CT27692-7-20180315
             * TOSTORELOC : LJ
             * USETYPE : 转移
             */

            private String DESCRIPTION;
            private String FROMBIN;
            private String FROMLOT;
            private String INVUSENUM;
            private String ITEMNUM;
            private String LINETYPE;
            private String QUANTITY;
            private String SITEID;
            private String TOBIN;
            private String TOLOT;
            private String TOSTORELOC;
            private String USETYPE;

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getFROMBIN() {
                return FROMBIN;
            }

            public void setFROMBIN(String FROMBIN) {
                this.FROMBIN = FROMBIN;
            }

            public String getFROMLOT() {
                return FROMLOT;
            }

            public void setFROMLOT(String FROMLOT) {
                this.FROMLOT = FROMLOT;
            }

            public String getINVUSENUM() {
                return INVUSENUM;
            }

            public void setINVUSENUM(String INVUSENUM) {
                this.INVUSENUM = INVUSENUM;
            }

            public String getITEMNUM() {
                return ITEMNUM;
            }

            public void setITEMNUM(String ITEMNUM) {
                this.ITEMNUM = ITEMNUM;
            }

            public String getLINETYPE() {
                return LINETYPE;
            }

            public void setLINETYPE(String LINETYPE) {
                this.LINETYPE = LINETYPE;
            }

            public String getQUANTITY() {
                return QUANTITY;
            }

            public void setQUANTITY(String QUANTITY) {
                this.QUANTITY = QUANTITY;
            }

            public String getSITEID() {
                return SITEID;
            }

            public void setSITEID(String SITEID) {
                this.SITEID = SITEID;
            }

            public String getTOBIN() {
                return TOBIN;
            }

            public void setTOBIN(String TOBIN) {
                this.TOBIN = TOBIN;
            }

            public String getTOLOT() {
                return TOLOT;
            }

            public void setTOLOT(String TOLOT) {
                this.TOLOT = TOLOT;
            }

            public String getTOSTORELOC() {
                return TOSTORELOC;
            }

            public void setTOSTORELOC(String TOSTORELOC) {
                this.TOSTORELOC = TOSTORELOC;
            }

            public String getUSETYPE() {
                return USETYPE;
            }

            public void setUSETYPE(String USETYPE) {
                this.USETYPE = USETYPE;
            }
        }
    }
}
