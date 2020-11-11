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
     * result : {"curpage":1,"resultlist":[{"COMPANY":"北三","CONTCOST":"1,369,500.00","CONTNUM":"BSIT/2020-08","CONTRACTDESC":"北三集司生产系统n-TOS升级服务器集成采购合同","CONTRACTNUM":"XM00341","DESCRIPTION":"n-TOS升级服务器集成采购(BSIT/2020-08)验收单","JBBM":"信息中心","PROCOST":"1,450,000.0000","PRODESC":"北三集司生产系统n-TOS升级服务器集成采购","PROJECTNUM":"PROJ00161","REMARK1":"为满足公司生产系统升级需要，本项目采购高性能PC服务器、虚拟化操作系统、备份一体机及PC客户机用于码头生产作业系统运行环境，以云技术构建应用虚拟资源池。现已实施完毕，达到验收标准。本次支付验收款1232550元，质保期一年，质保款136950元。","REMARK2":"","REMARK3":"本项目为2020固投计划，经请示上级主管部门，批准该项目由我公司自行验收。","SBBM":"信息中心","UDKGTIME":"2020-05-22","UDPRYSID":282,"UDPRYSNUM":"1020","UDRFQNUM":"","XMSYDEPT":"信息中心","ZGBM":"信息中心"},{"COMPANY":"北三","CONTCOST":"845,800.00","CONTNUM":"BSIT/2020-18","CONTRACTDESC":"北三集司智能理货专用无线网络系统购销合同","CONTRACTNUM":"XM00357","DESCRIPTION":"智能理货专用无线网络系统(BSIT/2020-18)验收报告","JBBM":"信息中心","PROCOST":"900,000.0000","PRODESC":"北三集司智能理货专用无线网络系统","PROJECTNUM":"PROJ00190","REMARK1":"采购6台中心基站作为扩充，以实现1台中心基站接入2台远端基站。24台远端站license升级，从现有25Mbps升级到50Mbps。本项目已实施完毕，且经过试运行一个月，达到验收标准。本次支付验收款761220元，质保期一年，质保款84580元。","REMARK2":"","REMARK3":"本项目为2020固投计划，经请示上级主管部门，批准该项目由我公司自行验收。","SBBM":"信息中心","UDKGTIME":"2020-06-15","UDPRYSID":261,"UDPRYSNUM":"1017","UDRFQNUM":"","XMSYDEPT":"信息中心 ","ZGBM":"信息中心"},{"COMPANY":"北三","CONTCOST":"284,000.00","CONTNUM":"BSIT/2020-24","CONTRACTDESC":"考勤管理系统(第二阶段)","CONTRACTNUM":"XM00330","DESCRIPTION":"考勤管理系统(第二阶段)(BSIT/2020-24)验收单","JBBM":"信息中心","PROCOST":"290,000.0000","PRODESC":"考勤管理系统(第二阶段)项目立项","PROJECTNUM":"PROJ00228","REMARK1":"本项目在考勤一阶段基础上，扩大考勤员工范围，新增网站数据定制化内容，移动端接入企业微信接口，班车打卡等功能。于2020年10月完工，现达到验收标准，根据合同约定拟支付验收款154000元。\n项目质保金30000元，待2023年6月经甲方确认质保服务合格后支付。","REMARK2":"","REMARK3":"","SBBM":"信息中心","UDKGTIME":"2020-05-12","UDPRYSID":241,"UDPRYSNUM":"1013","UDRFQNUM":"","XMSYDEPT":"行政人事部","ZGBM":"信息中心"},{"COMPANY":"远东","CONTCOST":"90,000.00","CONTNUM":"BSIT/2020-35","CONTRACTDESC":"网络设备更新采购","CONTRACTNUM":"XM00435","DESCRIPTION":"网络设备更新采购 (BSIT/2020-35)验收单","JBBM":"信息中心","PROCOST":"99,000.0000","PRODESC":"网络设备更新采购","PROJECTNUM":"PROJ00318","REMARK1":"公司部分网络设备使用年限较长，为保证运行稳定，根据计划更新3台交换机设备和1套华为防火墙。现已接收完毕，且满足信息安全、网络接入等需要。本次付款金额90000元。","REMARK2":"","REMARK3":"","SBBM":"信息中心","UDKGTIME":"2020-09-17","UDPRYSID":201,"UDPRYSNUM":"1011","UDRFQNUM":"","XMSYDEPT":"信息中心","ZGBM":"信息中心"}]}
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
         * resultlist : [{"COMPANY":"北三","CONTCOST":"1,369,500.00","CONTNUM":"BSIT/2020-08","CONTRACTDESC":"北三集司生产系统n-TOS升级服务器集成采购合同","CONTRACTNUM":"XM00341","DESCRIPTION":"n-TOS升级服务器集成采购(BSIT/2020-08)验收单","JBBM":"信息中心","PROCOST":"1,450,000.0000","PRODESC":"北三集司生产系统n-TOS升级服务器集成采购","PROJECTNUM":"PROJ00161","REMARK1":"为满足公司生产系统升级需要，本项目采购高性能PC服务器、虚拟化操作系统、备份一体机及PC客户机用于码头生产作业系统运行环境，以云技术构建应用虚拟资源池。现已实施完毕，达到验收标准。本次支付验收款1232550元，质保期一年，质保款136950元。","REMARK2":"","REMARK3":"本项目为2020固投计划，经请示上级主管部门，批准该项目由我公司自行验收。","SBBM":"信息中心","UDKGTIME":"2020-05-22","UDPRYSID":282,"UDPRYSNUM":"1020","UDRFQNUM":"","XMSYDEPT":"信息中心","ZGBM":"信息中心"},{"COMPANY":"北三","CONTCOST":"845,800.00","CONTNUM":"BSIT/2020-18","CONTRACTDESC":"北三集司智能理货专用无线网络系统购销合同","CONTRACTNUM":"XM00357","DESCRIPTION":"智能理货专用无线网络系统(BSIT/2020-18)验收报告","JBBM":"信息中心","PROCOST":"900,000.0000","PRODESC":"北三集司智能理货专用无线网络系统","PROJECTNUM":"PROJ00190","REMARK1":"采购6台中心基站作为扩充，以实现1台中心基站接入2台远端基站。24台远端站license升级，从现有25Mbps升级到50Mbps。本项目已实施完毕，且经过试运行一个月，达到验收标准。本次支付验收款761220元，质保期一年，质保款84580元。","REMARK2":"","REMARK3":"本项目为2020固投计划，经请示上级主管部门，批准该项目由我公司自行验收。","SBBM":"信息中心","UDKGTIME":"2020-06-15","UDPRYSID":261,"UDPRYSNUM":"1017","UDRFQNUM":"","XMSYDEPT":"信息中心 ","ZGBM":"信息中心"},{"COMPANY":"北三","CONTCOST":"284,000.00","CONTNUM":"BSIT/2020-24","CONTRACTDESC":"考勤管理系统(第二阶段)","CONTRACTNUM":"XM00330","DESCRIPTION":"考勤管理系统(第二阶段)(BSIT/2020-24)验收单","JBBM":"信息中心","PROCOST":"290,000.0000","PRODESC":"考勤管理系统(第二阶段)项目立项","PROJECTNUM":"PROJ00228","REMARK1":"本项目在考勤一阶段基础上，扩大考勤员工范围，新增网站数据定制化内容，移动端接入企业微信接口，班车打卡等功能。于2020年10月完工，现达到验收标准，根据合同约定拟支付验收款154000元。\n项目质保金30000元，待2023年6月经甲方确认质保服务合格后支付。","REMARK2":"","REMARK3":"","SBBM":"信息中心","UDKGTIME":"2020-05-12","UDPRYSID":241,"UDPRYSNUM":"1013","UDRFQNUM":"","XMSYDEPT":"行政人事部","ZGBM":"信息中心"},{"COMPANY":"远东","CONTCOST":"90,000.00","CONTNUM":"BSIT/2020-35","CONTRACTDESC":"网络设备更新采购","CONTRACTNUM":"XM00435","DESCRIPTION":"网络设备更新采购 (BSIT/2020-35)验收单","JBBM":"信息中心","PROCOST":"99,000.0000","PRODESC":"网络设备更新采购","PROJECTNUM":"PROJ00318","REMARK1":"公司部分网络设备使用年限较长，为保证运行稳定，根据计划更新3台交换机设备和1套华为防火墙。现已接收完毕，且满足信息安全、网络接入等需要。本次付款金额90000元。","REMARK2":"","REMARK3":"","SBBM":"信息中心","UDKGTIME":"2020-09-17","UDPRYSID":201,"UDPRYSNUM":"1011","UDRFQNUM":"","XMSYDEPT":"信息中心","ZGBM":"信息中心"}]
         */

        private int curpage;

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

        private int totalpage;
        private int totalresult;
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
             * COMPANY : 北三
             * CONTCOST : 1,369,500.00
             * CONTNUM : BSIT/2020-08
             * CONTRACTDESC : 北三集司生产系统n-TOS升级服务器集成采购合同
             * CONTRACTNUM : XM00341
             * DESCRIPTION : n-TOS升级服务器集成采购(BSIT/2020-08)验收单
             * JBBM : 信息中心
             * PROCOST : 1,450,000.0000
             * PRODESC : 北三集司生产系统n-TOS升级服务器集成采购
             * PROJECTNUM : PROJ00161
             * REMARK1 : 为满足公司生产系统升级需要，本项目采购高性能PC服务器、虚拟化操作系统、备份一体机及PC客户机用于码头生产作业系统运行环境，以云技术构建应用虚拟资源池。现已实施完毕，达到验收标准。本次支付验收款1232550元，质保期一年，质保款136950元。
             * REMARK2 :
             * REMARK3 : 本项目为2020固投计划，经请示上级主管部门，批准该项目由我公司自行验收。
             * SBBM : 信息中心
             * UDKGTIME : 2020-05-22
             * UDPRYSID : 282
             * UDPRYSNUM : 1020
             * UDRFQNUM :
             * XMSYDEPT : 信息中心
             * ZGBM : 信息中心
             */

            private String COMPANY;
            private String CONTCOST;
            private String CONTNUM;
            private String CONTRACTDESC;
            private String CONTRACTNUM;
            private String DESCRIPTION;
            private String JBBM;
            private String PROCOST;
            private String PRODESC;
            private String PROJECTNUM;
            private String REMARK1;
            private String REMARK2;
            private String REMARK3;
            private String SBBM;
            private String UDKGTIME;
            private int UDPRYSID;
            private String UDPRYSNUM;
            private String UDRFQNUM;
            private String XMSYDEPT;
            private String ZGBM;

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            String STATUS;

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

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getJBBM() {
                return JBBM;
            }

            public void setJBBM(String JBBM) {
                this.JBBM = JBBM;
            }

            public String getPROCOST() {
                return PROCOST;
            }

            public void setPROCOST(String PROCOST) {
                this.PROCOST = PROCOST;
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

            public String getXMSYDEPT() {
                return XMSYDEPT;
            }

            public void setXMSYDEPT(String XMSYDEPT) {
                this.XMSYDEPT = XMSYDEPT;
            }

            public String getZGBM() {
                return ZGBM;
            }

            public void setZGBM(String ZGBM) {
                this.ZGBM = ZGBM;
            }
        }
    }
}
