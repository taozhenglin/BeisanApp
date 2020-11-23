package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tzl
 * on 2020/11/11
 */
public class ProjectYsListBean {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"COMPANY":"远东","CONTCOST":"0.00","CONTNUM":"XM0000","CONTRACTDESC":"无","CONTRACTNUM":"XM00495","CREWID":"无","DESCRIPTION":"劳保系统优化","JSJE":"8,000.00","PRODESC":"劳保系统优化","PROJECTNUM":"PROJ00321","REMARK1":"","REMARK2":"","REMARK3":"","SBBM":"信息中心","STATUS":"等待核准","TOTALCOST":"0.00","UDKGTIME":"2020-06-01","UDPRYSID":465,"UDPRYSNUM":"1035","UDRFQNUM":"3417","UDWGTIME":"2020-10-20","XMJBDEPT":"","XMSSDEPT":"信息中心","XMSYDEPT":"安全卫环部","XMZGDEPT":"信息中心"},{"COMPANY":"港吉","CONTCOST":"","CONTNUM":"","CONTRACTDESC":"","CONTRACTNUM":"","CREWID":"","DESCRIPTION":"热水器采购安装","JSJE":"","PRODESC":"行政人事部食堂班热水器购买申请","PROJECTNUM":"PROJ00333","REMARK1":"采购安装一台150升阿里斯顿热水，现已实施完毕，目前使用正常，达到验收标准。","REMARK2":"","REMARK3":"","SBBM":"行政人事部","STATUS":"等待核准","TOTALCOST":"","UDKGTIME":"2020-11-12","UDPRYSID":362,"UDPRYSNUM":"1025","UDRFQNUM":"3651","UDWGTIME":"","XMJBDEPT":"","XMSSDEPT":"","XMSYDEPT":"行政人事部","XMZGDEPT":""},{"COMPANY":"","CONTCOST":"","CONTNUM":"","CONTRACTDESC":"","CONTRACTNUM":"","CREWID":"","DESCRIPTION":"APP测试","JSJE":"","PRODESC":"","PROJECTNUM":"","REMARK1":"","REMARK2":"","REMARK3":"","SBBM":"","STATUS":"等待核准","TOTALCOST":"","UDKGTIME":"2020-11-04","UDPRYSID":321,"UDPRYSNUM":"1022","UDRFQNUM":"","UDWGTIME":"","XMJBDEPT":"","XMSSDEPT":"","XMSYDEPT":"","XMZGDEPT":""},{"COMPANY":"北三","CONTCOST":"1,369,500.00","CONTNUM":"BSIT/2020-08","CONTRACTDESC":"北三集司生产系统n-TOS升级服务器集成采购合同","CONTRACTNUM":"XM00341","CREWID":"无","DESCRIPTION":"n-TOS升级服务器集成采购(BSIT/2020-08)验收单","JSJE":"1,232,550.00","PRODESC":"北三集司生产系统n-TOS升级服务器集成采购","PROJECTNUM":"PROJ00161","REMARK1":"为满足公司生产系统升级需要，本项目采购高性能PC服务器、虚拟化操作系统、备份一体机及PC客户机用于码头生产作业系统运行环境，以云技术构建应用虚拟资源池。现已实施完毕，达到验收标准。本次支付验收款1232550元，质保期一年，质保款136950元。","REMARK2":"","REMARK3":"本项目为2020固投计划，经请示上级主管部门，批准该项目由我公司自行验收。","SBBM":"信息中心","STATUS":"已批准","TOTALCOST":"1,369,500.00","UDKGTIME":"2020-05-22","UDPRYSID":282,"UDPRYSNUM":"1020","UDRFQNUM":"","UDWGTIME":"2020-10-15","XMJBDEPT":"","XMSSDEPT":"信息中心","XMSYDEPT":"信息中心","XMZGDEPT":"信息中心"},{"COMPANY":"北三","CONTCOST":"845,800.00","CONTNUM":"BSIT/2020-18","CONTRACTDESC":"北三集司智能理货专用无线网络系统购销合同","CONTRACTNUM":"XM00357","CREWID":"无","DESCRIPTION":"智能理货专用无线网络系统(BSIT/2020-18)验收报告","JSJE":"761,220.00","PRODESC":"北三集司智能理货专用无线网络系统","PROJECTNUM":"PROJ00190","REMARK1":"采购6台中心基站作为扩充，以实现1台中心基站接入2台远端基站。24台远端站license升级，从现有25Mbps升级到50Mbps。本项目已实施完毕，且经过试运行一个月，达到验收标准。本次支付验收款761220元，质保期一年，质保款84580元。","REMARK2":"","REMARK3":"本项目为2020固投计划，经请示上级主管部门，批准该项目由我公司自行验收。","SBBM":"信息中心","STATUS":"已批准","TOTALCOST":"845,800.00","UDKGTIME":"2020-06-15","UDPRYSID":261,"UDPRYSNUM":"1017","UDRFQNUM":"","UDWGTIME":"2020-10-15","XMJBDEPT":"","XMSSDEPT":"信息中心","XMSYDEPT":"信息中心 ","XMZGDEPT":"信息中心"}]}
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

        /**
         * curpage : 1
         * resultlist : [{"COMPANY":"远东","CONTCOST":"0.00","CONTNUM":"XM0000","CONTRACTDESC":"无","CONTRACTNUM":"XM00495","CREWID":"无","DESCRIPTION":"劳保系统优化","JSJE":"8,000.00","PRODESC":"劳保系统优化","PROJECTNUM":"PROJ00321","REMARK1":"","REMARK2":"","REMARK3":"","SBBM":"信息中心","STATUS":"等待核准","TOTALCOST":"0.00","UDKGTIME":"2020-06-01","UDPRYSID":465,"UDPRYSNUM":"1035","UDRFQNUM":"3417","UDWGTIME":"2020-10-20","XMJBDEPT":"","XMSSDEPT":"信息中心","XMSYDEPT":"安全卫环部","XMZGDEPT":"信息中心"},{"COMPANY":"港吉","CONTCOST":"","CONTNUM":"","CONTRACTDESC":"","CONTRACTNUM":"","CREWID":"","DESCRIPTION":"热水器采购安装","JSJE":"","PRODESC":"行政人事部食堂班热水器购买申请","PROJECTNUM":"PROJ00333","REMARK1":"采购安装一台150升阿里斯顿热水，现已实施完毕，目前使用正常，达到验收标准。","REMARK2":"","REMARK3":"","SBBM":"行政人事部","STATUS":"等待核准","TOTALCOST":"","UDKGTIME":"2020-11-12","UDPRYSID":362,"UDPRYSNUM":"1025","UDRFQNUM":"3651","UDWGTIME":"","XMJBDEPT":"","XMSSDEPT":"","XMSYDEPT":"行政人事部","XMZGDEPT":""},{"COMPANY":"","CONTCOST":"","CONTNUM":"","CONTRACTDESC":"","CONTRACTNUM":"","CREWID":"","DESCRIPTION":"APP测试","JSJE":"","PRODESC":"","PROJECTNUM":"","REMARK1":"","REMARK2":"","REMARK3":"","SBBM":"","STATUS":"等待核准","TOTALCOST":"","UDKGTIME":"2020-11-04","UDPRYSID":321,"UDPRYSNUM":"1022","UDRFQNUM":"","UDWGTIME":"","XMJBDEPT":"","XMSSDEPT":"","XMSYDEPT":"","XMZGDEPT":""},{"COMPANY":"北三","CONTCOST":"1,369,500.00","CONTNUM":"BSIT/2020-08","CONTRACTDESC":"北三集司生产系统n-TOS升级服务器集成采购合同","CONTRACTNUM":"XM00341","CREWID":"无","DESCRIPTION":"n-TOS升级服务器集成采购(BSIT/2020-08)验收单","JSJE":"1,232,550.00","PRODESC":"北三集司生产系统n-TOS升级服务器集成采购","PROJECTNUM":"PROJ00161","REMARK1":"为满足公司生产系统升级需要，本项目采购高性能PC服务器、虚拟化操作系统、备份一体机及PC客户机用于码头生产作业系统运行环境，以云技术构建应用虚拟资源池。现已实施完毕，达到验收标准。本次支付验收款1232550元，质保期一年，质保款136950元。","REMARK2":"","REMARK3":"本项目为2020固投计划，经请示上级主管部门，批准该项目由我公司自行验收。","SBBM":"信息中心","STATUS":"已批准","TOTALCOST":"1,369,500.00","UDKGTIME":"2020-05-22","UDPRYSID":282,"UDPRYSNUM":"1020","UDRFQNUM":"","UDWGTIME":"2020-10-15","XMJBDEPT":"","XMSSDEPT":"信息中心","XMSYDEPT":"信息中心","XMZGDEPT":"信息中心"},{"COMPANY":"北三","CONTCOST":"845,800.00","CONTNUM":"BSIT/2020-18","CONTRACTDESC":"北三集司智能理货专用无线网络系统购销合同","CONTRACTNUM":"XM00357","CREWID":"无","DESCRIPTION":"智能理货专用无线网络系统(BSIT/2020-18)验收报告","JSJE":"761,220.00","PRODESC":"北三集司智能理货专用无线网络系统","PROJECTNUM":"PROJ00190","REMARK1":"采购6台中心基站作为扩充，以实现1台中心基站接入2台远端基站。24台远端站license升级，从现有25Mbps升级到50Mbps。本项目已实施完毕，且经过试运行一个月，达到验收标准。本次支付验收款761220元，质保期一年，质保款84580元。","REMARK2":"","REMARK3":"本项目为2020固投计划，经请示上级主管部门，批准该项目由我公司自行验收。","SBBM":"信息中心","STATUS":"已批准","TOTALCOST":"845,800.00","UDKGTIME":"2020-06-15","UDPRYSID":261,"UDPRYSNUM":"1017","UDRFQNUM":"","UDWGTIME":"2020-10-15","XMJBDEPT":"","XMSSDEPT":"信息中心","XMSYDEPT":"信息中心 ","XMZGDEPT":"信息中心"}]
         */
        private int totalpage;
        private int totalresult;
        private int curpage;
        private List<ResultlistBean> resultlist;

        public int getCurpage() {
            return curpage;
        }

        public void setCurpage(int curpage) {
            this.curpage = curpage;
        }

        public List<ResultlistBean> getResultlist() {
            return resultlist;
        }

        public void setResultlist(List<ResultlistBean> resultlist) {
            this.resultlist = resultlist;
        }

        public static class ResultlistBean implements Serializable {
            /**
             * COMPANY : 远东
             * CONTCOST : 0.00
             * CONTNUM : XM0000
             * CONTRACTDESC : 无
             * CONTRACTNUM : XM00495
             * CREWID : 无
             * DESCRIPTION : 劳保系统优化
             * JSJE : 8,000.00
             * PRODESC : 劳保系统优化
             * PROJECTNUM : PROJ00321
             * REMARK1 :
             * REMARK2 :
             * REMARK3 :
             * SBBM : 信息中心
             * STATUS : 等待核准
             * TOTALCOST : 0.00
             * UDKGTIME : 2020-06-01
             * UDPRYSID : 465
             * UDPRYSNUM : 1035
             * UDRFQNUM : 3417
             * UDWGTIME : 2020-10-20
             * XMJBDEPT :
             * XMSSDEPT : 信息中心
             * XMSYDEPT : 安全卫环部
             * XMZGDEPT : 信息中心
             */

            private String COMPANY;
            private String CONTCOST;
            private String CONTNUM;
            private String CONTRACTDESC;
            private String CONTRACTNUM;
            private String CREWID;
            private String DESCRIPTION;
            private String JSJE;
            private String PRODESC;
            private String PROJECTNUM;
            private String REMARK1;
            private String REMARK2;
            private String REMARK3;
            private String SBBM;
            private String STATUS;
            private String TOTALCOST;
            private String UDKGTIME;
            private int UDPRYSID;
            private String UDPRYSNUM;
            private String UDRFQNUM;
            private String UDWGTIME;
            private String XMJBDEPT;
            private String XMSSDEPT;
            private String XMSYDEPT;
            private String XMZGDEPT;

            public String getCOMPANY() {
                return COMPANY;
            }

            public void setCOMPANY(String COMPANY) {
                this.COMPANY = COMPANY;
            }

            public String getCONTCOST() {
                return CONTCOST;
            }

            public void setCONTCOST(String CONTCOST) {
                this.CONTCOST = CONTCOST;
            }

            public String getCONTNUM() {
                return CONTNUM;
            }

            public void setCONTNUM(String CONTNUM) {
                this.CONTNUM = CONTNUM;
            }

            public String getCONTRACTDESC() {
                return CONTRACTDESC;
            }

            public void setCONTRACTDESC(String CONTRACTDESC) {
                this.CONTRACTDESC = CONTRACTDESC;
            }

            public String getCONTRACTNUM() {
                return CONTRACTNUM;
            }

            public void setCONTRACTNUM(String CONTRACTNUM) {
                this.CONTRACTNUM = CONTRACTNUM;
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

            public String getJSJE() {
                return JSJE;
            }

            public void setJSJE(String JSJE) {
                this.JSJE = JSJE;
            }

            public String getPRODESC() {
                return PRODESC;
            }

            public void setPRODESC(String PRODESC) {
                this.PRODESC = PRODESC;
            }

            public String getPROJECTNUM() {
                return PROJECTNUM;
            }

            public void setPROJECTNUM(String PROJECTNUM) {
                this.PROJECTNUM = PROJECTNUM;
            }

            public String getREMARK1() {
                return REMARK1;
            }

            public void setREMARK1(String REMARK1) {
                this.REMARK1 = REMARK1;
            }

            public String getREMARK2() {
                return REMARK2;
            }

            public void setREMARK2(String REMARK2) {
                this.REMARK2 = REMARK2;
            }

            public String getREMARK3() {
                return REMARK3;
            }

            public void setREMARK3(String REMARK3) {
                this.REMARK3 = REMARK3;
            }

            public String getSBBM() {
                return SBBM;
            }

            public void setSBBM(String SBBM) {
                this.SBBM = SBBM;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getTOTALCOST() {
                return TOTALCOST;
            }

            public void setTOTALCOST(String TOTALCOST) {
                this.TOTALCOST = TOTALCOST;
            }

            public String getUDKGTIME() {
                return UDKGTIME;
            }

            public void setUDKGTIME(String UDKGTIME) {
                this.UDKGTIME = UDKGTIME;
            }

            public int getUDPRYSID() {
                return UDPRYSID;
            }

            public void setUDPRYSID(int UDPRYSID) {
                this.UDPRYSID = UDPRYSID;
            }

            public String getUDPRYSNUM() {
                return UDPRYSNUM;
            }

            public void setUDPRYSNUM(String UDPRYSNUM) {
                this.UDPRYSNUM = UDPRYSNUM;
            }

            public String getUDRFQNUM() {
                return UDRFQNUM;
            }

            public void setUDRFQNUM(String UDRFQNUM) {
                this.UDRFQNUM = UDRFQNUM;
            }

            public String getUDWGTIME() {
                return UDWGTIME;
            }

            public void setUDWGTIME(String UDWGTIME) {
                this.UDWGTIME = UDWGTIME;
            }

            public String getXMJBDEPT() {
                return XMJBDEPT;
            }

            public void setXMJBDEPT(String XMJBDEPT) {
                this.XMJBDEPT = XMJBDEPT;
            }

            public String getXMSSDEPT() {
                return XMSSDEPT;
            }

            public void setXMSSDEPT(String XMSSDEPT) {
                this.XMSSDEPT = XMSSDEPT;
            }

            public String getXMSYDEPT() {
                return XMSYDEPT;
            }

            public void setXMSYDEPT(String XMSYDEPT) {
                this.XMSYDEPT = XMSYDEPT;
            }

            public String getXMZGDEPT() {
                return XMZGDEPT;
            }

            public void setXMZGDEPT(String XMZGDEPT) {
                this.XMZGDEPT = XMZGDEPT;
            }
        }
    }
}
