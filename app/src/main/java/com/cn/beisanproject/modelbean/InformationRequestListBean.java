package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class InformationRequestListBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ASSETNUM":"1035","ASSETSTATUS":"","ATTR1":"1","ATTR2":"","AZDZ":"guide","BB":"","BFJZ":"","CCDW":"guidesoft","CGSJ":"2020-06-01 12:23:28","CWZJNX":"","DW":"","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-06-05 12:22:45","FL":"硬件信息","HARDWAREDL":"基站","HARDWAREXL":"边缘交换机","HD":"","JD_INFORMANAGEID":"122","JD_INFORMANAGENUM":"guide001","JSDW":"","JSFS":"","NAME":"app测试","NDYWF":"0.00","PHONE":"18090908080","PP":"guide","SCGLLY":"","SJKLX":"","SM":"","SOFTWAREDL":"","SSDW":"宁波外理","STATUS":"已确认","SXSH":"","SYDW":"","SYHJ":"","TZJE":"0.00","WHDW":"guide","XH":"app","ZRR":"soft"},{"ASSETNUM":"1011","ASSETSTATUS":"","ATTR1":"1","ATTR2":"","AZDZ":"cccccccc","BB":"","BFJZ":"","CCDW":"xxxx","CGSJ":"2020-04-01 15:02:09","CWZJNX":"12","DW":"1","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-02 15:00:47","FL":"硬件信息","HARDWAREDL":"网络设备","HARDWAREXL":"调制解调机","HD":"","JD_INFORMANAGEID":"10","JD_INFORMANAGENUM":"YJ-DFSF","JSDW":"","JSFS":"","NAME":"硬件台账","NDYWF":"0.00","PHONE":"18090908080","PP":"测试","SCGLLY":"","SJKLX":"","SM":"xxxxx","SOFTWAREDL":"","SSDW":"铁司","STATUS":"待领导审核","SXSH":"","SYDW":"CES","SYHJ":"","TZJE":"100,000.00","WHDW":"CES","XH":"xxxxx","ZRR":"测试人"},{"ASSETNUM":"1010","ASSETSTATUS":"封存","ATTR1":"6","ATTR2":"客户端操作","AZDZ":"","BB":"12","BFJZ":"232323","CCDW":"测试","CGSJ":"","CWZJNX":"","DW":"台","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-02 14:58:57","FL":"软件信息","HARDWAREDL":"","HARDWAREXL":"","HD":"1","JD_INFORMANAGEID":"9","JD_INFORMANAGENUM":"","JSDW":"xxxxx","JSFS":"无","NAME":"软件台账信息","NDYWF":"50,000.00","PHONE":"18090908080","PP":"","SCGLLY":"fgggg","SJKLX":"vvvvvv","SM":"无","SOFTWAREDL":"应用软件","SSDW":"北三集司","STATUS":"等待批准","SXSH":"2020-04-02 15:00:03","SYDW":"测试","SYHJ":"内部","TZJE":"300.00","WHDW":"cccccc","XH":"","ZRR":"系统管理员"},{"ASSETNUM":"1008","ASSETSTATUS":"活动","ATTR1":"2","ATTR2":"客户端操作","AZDZ":"","BB":"10","BFJZ":"liunx","CCDW":"宁波北仑","CGSJ":"","CWZJNX":"","DW":"台","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-02 14:30:08","FL":"软件信息","HARDWAREDL":"","HARDWAREXL":"","HD":"购买","JD_INFORMANAGEID":"7","JD_INFORMANAGENUM":"","JSDW":"宁波","JSFS":"建设","NAME":"软件台账","NDYWF":"1,000.00","PHONE":"18090908080","PP":"","SCGLLY":"xxxxx","SJKLX":"oracle","SM":"无","SOFTWAREDL":"应用软件","SSDW":"北三集司","STATUS":"等待批准","SXSH":"2020-04-02 14:30:58","SYDW":"北仑第三集装箱","SYHJ":"windows","TZJE":"100.00","WHDW":"北仑","XH":"","ZRR":"系统管理员"},{"ASSETNUM":"1009","ASSETSTATUS":"","ATTR1":"1","ATTR2":"","AZDZ":"宁波第三集装箱北仑","BB":"","BFJZ":"","CCDW":"CCC","CGSJ":"2020-04-01 14:33:54","CWZJNX":"1","DW":"台","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-02 14:31:48","FL":"硬件信息","HARDWAREDL":"机房相关设备","HARDWAREXL":"调制解调机","HD":"","JD_INFORMANAGEID":"8","JD_INFORMANAGENUM":"XXTZ-GB001","JSDW":"","JSFS":"","NAME":"硬件台账","NDYWF":"0.00","PHONE":"18090908080","PP":"CCLDWEX1001","SCGLLY":"","SJKLX":"","SM":"无","SOFTWAREDL":"","SSDW":"铁司","STATUS":"等待批准","SXSH":"","SYDW":"北仑第三集装箱","SYHJ":"","TZJE":"200.00","WHDW":"宁波北仑","XH":"","ZRR":"系统管理员"},{"ASSETNUM":"1034","ASSETSTATUS":"停止使用","ATTR1":"1","ATTR2":"客户端操作","AZDZ":"","BB":"","BFJZ":"","CCDW":"1","CGSJ":"","CWZJNX":"","DW":"","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-06-05 09:38:23","FL":"软件信息","HARDWAREDL":"","HARDWAREXL":"","HD":"","JD_INFORMANAGEID":"121","JD_INFORMANAGENUM":"","JSDW":"1","JSFS":"1","NAME":"1","NDYWF":"0.00","PHONE":"18090908080","PP":"","SCGLLY":"","SJKLX":"","SM":"","SOFTWAREDL":"应用软件","SSDW":"轮司","STATUS":"已确认","SXSH":"2020-06-04 09:38:59","SYDW":"","SYHJ":"","TZJE":"1.00","WHDW":"1","XH":"","ZRR":"1"},{"ASSETNUM":"1036","ASSETSTATUS":"活动","ATTR1":"1","ATTR2":"客户端操作","AZDZ":"","BB":"","BFJZ":"","CCDW":"丙方","CGSJ":"","CWZJNX":"","DW":"","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-06-05 12:23:50","FL":"软件信息","HARDWAREDL":"","HARDWAREXL":"","HD":"","JD_INFORMANAGEID":"123","JD_INFORMANAGENUM":"","JSDW":"甲方","JSFS":"anzhuang","NAME":"linux","NDYWF":"0.00","PHONE":"18090908080","PP":"","SCGLLY":"","SJKLX":"","SM":"","SOFTWAREDL":"应用软件","SSDW":"港强公司","STATUS":"等待批准","SXSH":"2020-06-02 12:24:54","SYDW":"","SYHJ":"","TZJE":"0.00","WHDW":"乙方","XH":"","ZRR":"guide"}],"showcount":20,"totalpage":1,"totalresult":7}
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
         * resultlist : [{"ASSETNUM":"1035","ASSETSTATUS":"","ATTR1":"1","ATTR2":"","AZDZ":"guide","BB":"","BFJZ":"","CCDW":"guidesoft","CGSJ":"2020-06-01 12:23:28","CWZJNX":"","DW":"","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-06-05 12:22:45","FL":"硬件信息","HARDWAREDL":"基站","HARDWAREXL":"边缘交换机","HD":"","JD_INFORMANAGEID":"122","JD_INFORMANAGENUM":"guide001","JSDW":"","JSFS":"","NAME":"app测试","NDYWF":"0.00","PHONE":"18090908080","PP":"guide","SCGLLY":"","SJKLX":"","SM":"","SOFTWAREDL":"","SSDW":"宁波外理","STATUS":"已确认","SXSH":"","SYDW":"","SYHJ":"","TZJE":"0.00","WHDW":"guide","XH":"app","ZRR":"soft"},{"ASSETNUM":"1011","ASSETSTATUS":"","ATTR1":"1","ATTR2":"","AZDZ":"cccccccc","BB":"","BFJZ":"","CCDW":"xxxx","CGSJ":"2020-04-01 15:02:09","CWZJNX":"12","DW":"1","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-02 15:00:47","FL":"硬件信息","HARDWAREDL":"网络设备","HARDWAREXL":"调制解调机","HD":"","JD_INFORMANAGEID":"10","JD_INFORMANAGENUM":"YJ-DFSF","JSDW":"","JSFS":"","NAME":"硬件台账","NDYWF":"0.00","PHONE":"18090908080","PP":"测试","SCGLLY":"","SJKLX":"","SM":"xxxxx","SOFTWAREDL":"","SSDW":"铁司","STATUS":"待领导审核","SXSH":"","SYDW":"CES","SYHJ":"","TZJE":"100,000.00","WHDW":"CES","XH":"xxxxx","ZRR":"测试人"},{"ASSETNUM":"1010","ASSETSTATUS":"封存","ATTR1":"6","ATTR2":"客户端操作","AZDZ":"","BB":"12","BFJZ":"232323","CCDW":"测试","CGSJ":"","CWZJNX":"","DW":"台","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-02 14:58:57","FL":"软件信息","HARDWAREDL":"","HARDWAREXL":"","HD":"1","JD_INFORMANAGEID":"9","JD_INFORMANAGENUM":"","JSDW":"xxxxx","JSFS":"无","NAME":"软件台账信息","NDYWF":"50,000.00","PHONE":"18090908080","PP":"","SCGLLY":"fgggg","SJKLX":"vvvvvv","SM":"无","SOFTWAREDL":"应用软件","SSDW":"北三集司","STATUS":"等待批准","SXSH":"2020-04-02 15:00:03","SYDW":"测试","SYHJ":"内部","TZJE":"300.00","WHDW":"cccccc","XH":"","ZRR":"系统管理员"},{"ASSETNUM":"1008","ASSETSTATUS":"活动","ATTR1":"2","ATTR2":"客户端操作","AZDZ":"","BB":"10","BFJZ":"liunx","CCDW":"宁波北仑","CGSJ":"","CWZJNX":"","DW":"台","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-02 14:30:08","FL":"软件信息","HARDWAREDL":"","HARDWAREXL":"","HD":"购买","JD_INFORMANAGEID":"7","JD_INFORMANAGENUM":"","JSDW":"宁波","JSFS":"建设","NAME":"软件台账","NDYWF":"1,000.00","PHONE":"18090908080","PP":"","SCGLLY":"xxxxx","SJKLX":"oracle","SM":"无","SOFTWAREDL":"应用软件","SSDW":"北三集司","STATUS":"等待批准","SXSH":"2020-04-02 14:30:58","SYDW":"北仑第三集装箱","SYHJ":"windows","TZJE":"100.00","WHDW":"北仑","XH":"","ZRR":"系统管理员"},{"ASSETNUM":"1009","ASSETSTATUS":"","ATTR1":"1","ATTR2":"","AZDZ":"宁波第三集装箱北仑","BB":"","BFJZ":"","CCDW":"CCC","CGSJ":"2020-04-01 14:33:54","CWZJNX":"1","DW":"台","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-04-02 14:31:48","FL":"硬件信息","HARDWAREDL":"机房相关设备","HARDWAREXL":"调制解调机","HD":"","JD_INFORMANAGEID":"8","JD_INFORMANAGENUM":"XXTZ-GB001","JSDW":"","JSFS":"","NAME":"硬件台账","NDYWF":"0.00","PHONE":"18090908080","PP":"CCLDWEX1001","SCGLLY":"","SJKLX":"","SM":"无","SOFTWAREDL":"","SSDW":"铁司","STATUS":"等待批准","SXSH":"","SYDW":"北仑第三集装箱","SYHJ":"","TZJE":"200.00","WHDW":"宁波北仑","XH":"","ZRR":"系统管理员"},{"ASSETNUM":"1034","ASSETSTATUS":"停止使用","ATTR1":"1","ATTR2":"客户端操作","AZDZ":"","BB":"","BFJZ":"","CCDW":"1","CGSJ":"","CWZJNX":"","DW":"","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-06-05 09:38:23","FL":"软件信息","HARDWAREDL":"","HARDWAREXL":"","HD":"","JD_INFORMANAGEID":"121","JD_INFORMANAGENUM":"","JSDW":"1","JSFS":"1","NAME":"1","NDYWF":"0.00","PHONE":"18090908080","PP":"","SCGLLY":"","SJKLX":"","SM":"","SOFTWAREDL":"应用软件","SSDW":"轮司","STATUS":"已确认","SXSH":"2020-06-04 09:38:59","SYDW":"","SYHJ":"","TZJE":"1.00","WHDW":"1","XH":"","ZRR":"1"},{"ASSETNUM":"1036","ASSETSTATUS":"活动","ATTR1":"1","ATTR2":"客户端操作","AZDZ":"","BB":"","BFJZ":"","CCDW":"丙方","CGSJ":"","CWZJNX":"","DW":"","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","ENTERDATE":"2020-06-05 12:23:50","FL":"软件信息","HARDWAREDL":"","HARDWAREXL":"","HD":"","JD_INFORMANAGEID":"123","JD_INFORMANAGENUM":"","JSDW":"甲方","JSFS":"anzhuang","NAME":"linux","NDYWF":"0.00","PHONE":"18090908080","PP":"","SCGLLY":"","SJKLX":"","SM":"","SOFTWAREDL":"应用软件","SSDW":"港强公司","STATUS":"等待批准","SXSH":"2020-06-02 12:24:54","SYDW":"","SYHJ":"","TZJE":"0.00","WHDW":"乙方","XH":"","ZRR":"guide"}]
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

        public static class ResultlistBean implements Serializable{
            /**
             * ASSETNUM : 1035
             * ASSETSTATUS :
             * ATTR1 : 1
             * ATTR2 :
             * AZDZ : guide
             * BB :
             * BFJZ :
             * CCDW : guidesoft
             * CGSJ : 2020-06-01 12:23:28
             * CWZJNX :
             * DW :
             * ENTERBY : MAXADMIN
             * ENTERBYDESC : 系统管理员
             * ENTERDATE : 2020-06-05 12:22:45
             * FL : 硬件信息
             * HARDWAREDL : 基站
             * HARDWAREXL : 边缘交换机
             * HD :
             * JD_INFORMANAGEID : 122
             * JD_INFORMANAGENUM : guide001
             * JSDW :
             * JSFS :
             * NAME : app测试
             * NDYWF : 0.00
             * PHONE : 18090908080
             * PP : guide
             * SCGLLY :
             * SJKLX :
             * SM :
             * SOFTWAREDL :
             * SSDW : 宁波外理
             * STATUS : 已确认
             * SXSH :
             * SYDW :
             * SYHJ :
             * TZJE : 0.00
             * WHDW : guide
             * XH : app
             * ZRR : soft
             */

            private String ASSETNUM;
            private String ASSETSTATUS;
            private String ATTR1;
            private String ATTR2;
            private String AZDZ;
            private String BB;
            private String BFJZ;
            private String CCDW;
            private String CGSJ;
            private String CWZJNX;
            private String DW;
            private String ENTERBY;
            private String ENTERBYDESC;
            private String ENTERDATE;
            private String FL;
            private String HARDWAREDL;
            private String HARDWAREXL;
            private String HD;
            private String JD_INFORMANAGEID;
            private String JD_INFORMANAGENUM;
            private String JSDW;
            private String JSFS;
            private String NAME;
            private String NDYWF;
            private String PHONE;
            private String PP;
            private String SCGLLY;
            private String SJKLX;
            private String SM;
            private String SOFTWAREDL;
            private String SSDW;
            private String STATUS;
            private String SXSH;
            private String SYDW;
            private String SYHJ;
            private String TZJE;
            private String WHDW;
            private String XH;
            private String ZRR;

            public String getASSETNUM() {
                return ASSETNUM;
            }

            public void setASSETNUM(String ASSETNUM) {
                this.ASSETNUM = ASSETNUM;
            }

            public String getASSETSTATUS() {
                return ASSETSTATUS;
            }

            public void setASSETSTATUS(String ASSETSTATUS) {
                this.ASSETSTATUS = ASSETSTATUS;
            }

            public String getATTR1() {
                return ATTR1;
            }

            public void setATTR1(String ATTR1) {
                this.ATTR1 = ATTR1;
            }

            public String getATTR2() {
                return ATTR2;
            }

            public void setATTR2(String ATTR2) {
                this.ATTR2 = ATTR2;
            }

            public String getAZDZ() {
                return AZDZ;
            }

            public void setAZDZ(String AZDZ) {
                this.AZDZ = AZDZ;
            }

            public String getBB() {
                return BB;
            }

            public void setBB(String BB) {
                this.BB = BB;
            }

            public String getBFJZ() {
                return BFJZ;
            }

            public void setBFJZ(String BFJZ) {
                this.BFJZ = BFJZ;
            }

            public String getCCDW() {
                return CCDW;
            }

            public void setCCDW(String CCDW) {
                this.CCDW = CCDW;
            }

            public String getCGSJ() {
                return CGSJ;
            }

            public void setCGSJ(String CGSJ) {
                this.CGSJ = CGSJ;
            }

            public String getCWZJNX() {
                return CWZJNX;
            }

            public void setCWZJNX(String CWZJNX) {
                this.CWZJNX = CWZJNX;
            }

            public String getDW() {
                return DW;
            }

            public void setDW(String DW) {
                this.DW = DW;
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

            public String getENTERDATE() {
                return ENTERDATE;
            }

            public void setENTERDATE(String ENTERDATE) {
                this.ENTERDATE = ENTERDATE;
            }

            public String getFL() {
                return FL;
            }

            public void setFL(String FL) {
                this.FL = FL;
            }

            public String getHARDWAREDL() {
                return HARDWAREDL;
            }

            public void setHARDWAREDL(String HARDWAREDL) {
                this.HARDWAREDL = HARDWAREDL;
            }

            public String getHARDWAREXL() {
                return HARDWAREXL;
            }

            public void setHARDWAREXL(String HARDWAREXL) {
                this.HARDWAREXL = HARDWAREXL;
            }

            public String getHD() {
                return HD;
            }

            public void setHD(String HD) {
                this.HD = HD;
            }

            public String getJD_INFORMANAGEID() {
                return JD_INFORMANAGEID;
            }

            public void setJD_INFORMANAGEID(String JD_INFORMANAGEID) {
                this.JD_INFORMANAGEID = JD_INFORMANAGEID;
            }

            public String getJD_INFORMANAGENUM() {
                return JD_INFORMANAGENUM;
            }

            public void setJD_INFORMANAGENUM(String JD_INFORMANAGENUM) {
                this.JD_INFORMANAGENUM = JD_INFORMANAGENUM;
            }

            public String getJSDW() {
                return JSDW;
            }

            public void setJSDW(String JSDW) {
                this.JSDW = JSDW;
            }

            public String getJSFS() {
                return JSFS;
            }

            public void setJSFS(String JSFS) {
                this.JSFS = JSFS;
            }

            public String getNAME() {
                return NAME;
            }

            public void setNAME(String NAME) {
                this.NAME = NAME;
            }

            public String getNDYWF() {
                return NDYWF;
            }

            public void setNDYWF(String NDYWF) {
                this.NDYWF = NDYWF;
            }

            public String getPHONE() {
                return PHONE;
            }

            public void setPHONE(String PHONE) {
                this.PHONE = PHONE;
            }

            public String getPP() {
                return PP;
            }

            public void setPP(String PP) {
                this.PP = PP;
            }

            public String getSCGLLY() {
                return SCGLLY;
            }

            public void setSCGLLY(String SCGLLY) {
                this.SCGLLY = SCGLLY;
            }

            public String getSJKLX() {
                return SJKLX;
            }

            public void setSJKLX(String SJKLX) {
                this.SJKLX = SJKLX;
            }

            public String getSM() {
                return SM;
            }

            public void setSM(String SM) {
                this.SM = SM;
            }

            public String getSOFTWAREDL() {
                return SOFTWAREDL;
            }

            public void setSOFTWAREDL(String SOFTWAREDL) {
                this.SOFTWAREDL = SOFTWAREDL;
            }

            public String getSSDW() {
                return SSDW;
            }

            public void setSSDW(String SSDW) {
                this.SSDW = SSDW;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getSXSH() {
                return SXSH;
            }

            public void setSXSH(String SXSH) {
                this.SXSH = SXSH;
            }

            public String getSYDW() {
                return SYDW;
            }

            public void setSYDW(String SYDW) {
                this.SYDW = SYDW;
            }

            public String getSYHJ() {
                return SYHJ;
            }

            public void setSYHJ(String SYHJ) {
                this.SYHJ = SYHJ;
            }

            public String getTZJE() {
                return TZJE;
            }

            public void setTZJE(String TZJE) {
                this.TZJE = TZJE;
            }

            public String getWHDW() {
                return WHDW;
            }

            public void setWHDW(String WHDW) {
                this.WHDW = WHDW;
            }

            public String getXH() {
                return XH;
            }

            public void setXH(String XH) {
                this.XH = XH;
            }

            public String getZRR() {
                return ZRR;
            }

            public void setZRR(String ZRR) {
                this.ZRR = ZRR;
            }
        }
    }
}
