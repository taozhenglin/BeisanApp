package com.cn.beisanproject.modelbean;

import java.util.List;

public class StockScanDetailResult {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : [{"BINNUM":"TEMP","CURBAL":"0.0000","ITEMDESC":"灯泡","ITEMNUM":"435620185","LOCATION":"LJ","LOTNUM":"LJ33219-3-20200827","UDLOTNUM":"W10000000013"}]
     */

    private String errcode;
    private String errmsg;
    private Object personid;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * BINNUM : TEMP
         * CURBAL : 0.0000
         * ITEMDESC : 灯泡
         * ITEMNUM : 435620185
         * LOCATION : LJ
         * LOTNUM : LJ33219-3-20200827
         * UDLOTNUM : W10000000013
         */

        private String BINNUM;
        private String CURBAL;
        private String ITEMDESC;
        private String ITEMNUM;
        private String LOCATION;
        private String LOTNUM;
        private String UDLOTNUM;

        public String getBINNUM() {
            return BINNUM;
        }

        public void setBINNUM(String BINNUM) {
            this.BINNUM = BINNUM;
        }

        public String getCURBAL() {
            return CURBAL;
        }

        public void setCURBAL(String CURBAL) {
            this.CURBAL = CURBAL;
        }

        public String getITEMDESC() {
            return ITEMDESC;
        }

        public void setITEMDESC(String ITEMDESC) {
            this.ITEMDESC = ITEMDESC;
        }

        public String getITEMNUM() {
            return ITEMNUM;
        }

        public void setITEMNUM(String ITEMNUM) {
            this.ITEMNUM = ITEMNUM;
        }

        public String getLOCATION() {
            return LOCATION;
        }

        public void setLOCATION(String LOCATION) {
            this.LOCATION = LOCATION;
        }

        public String getLOTNUM() {
            return LOTNUM;
        }

        public void setLOTNUM(String LOTNUM) {
            this.LOTNUM = LOTNUM;
        }

        public String getUDLOTNUM() {
            return UDLOTNUM;
        }

        public void setUDLOTNUM(String UDLOTNUM) {
            this.UDLOTNUM = UDLOTNUM;
        }
    }
}
