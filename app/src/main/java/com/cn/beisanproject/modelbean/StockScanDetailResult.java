package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class StockScanDetailResult {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : [{"DESCRIPTION":"防静电工作服（夏）","INSPECTEDQTY":"0.00","INVBLANCE":"4.0000","ITEMNUM":"282000010","PONUM":"33217","PONUMDESC":"","TOLOT":"YD33217-1-20200915","TOSTORELOC":"YD","TOSTORELOCDESC":"远东","UDTOLOT":"W100000000051","VENDOR":"GK11021","VENDORNAME":"上海宝钢商贸有限公司"}]
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

    public static class ResultBean implements Serializable {
        /**
         * DESCRIPTION : 防静电工作服（夏）
         * INSPECTEDQTY : 0.00
         * INVBLANCE : 4.0000
         * ITEMNUM : 282000010
         * PONUM : 33217
         * PONUMDESC :
         * TOLOT : YD33217-1-20200915
         * TOSTORELOC : YD
         * TOSTORELOCDESC : 远东
         * UDTOLOT : W100000000051
         * VENDOR : GK11021
         * VENDORNAME : 上海宝钢商贸有限公司
         */

        private String DESCRIPTION;
        private String INSPECTEDQTY;
        private String INVBLANCE;
        private String ITEMNUM;
        private String PONUM;
        private String PONUMDESC;
        private String TOLOT;
        private String TOSTORELOC;
        private String TOSTORELOCDESC;
        private String UDTOLOT;
        private String VENDOR;
        private String VENDORNAME;

        public String getDESCRIPTION() {
            return DESCRIPTION;
        }

        public void setDESCRIPTION(String DESCRIPTION) {
            this.DESCRIPTION = DESCRIPTION;
        }

        public String getINSPECTEDQTY() {
            return INSPECTEDQTY;
        }

        public void setINSPECTEDQTY(String INSPECTEDQTY) {
            this.INSPECTEDQTY = INSPECTEDQTY;
        }

        public String getINVBLANCE() {
            return INVBLANCE;
        }

        public void setINVBLANCE(String INVBLANCE) {
            this.INVBLANCE = INVBLANCE;
        }

        public String getITEMNUM() {
            return ITEMNUM;
        }

        public void setITEMNUM(String ITEMNUM) {
            this.ITEMNUM = ITEMNUM;
        }

        public String getPONUM() {
            return PONUM;
        }

        public void setPONUM(String PONUM) {
            this.PONUM = PONUM;
        }

        public String getPONUMDESC() {
            return PONUMDESC;
        }

        public void setPONUMDESC(String PONUMDESC) {
            this.PONUMDESC = PONUMDESC;
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

        public String getTOSTORELOCDESC() {
            return TOSTORELOCDESC;
        }

        public void setTOSTORELOCDESC(String TOSTORELOCDESC) {
            this.TOSTORELOCDESC = TOSTORELOCDESC;
        }

        public String getUDTOLOT() {
            return UDTOLOT;
        }

        public void setUDTOLOT(String UDTOLOT) {
            this.UDTOLOT = UDTOLOT;
        }

        public String getVENDOR() {
            return VENDOR;
        }

        public void setVENDOR(String VENDOR) {
            this.VENDOR = VENDOR;
        }

        public String getVENDORNAME() {
            return VENDORNAME;
        }

        public void setVENDORNAME(String VENDORNAME) {
            this.VENDORNAME = VENDORNAME;
        }
    }
}
