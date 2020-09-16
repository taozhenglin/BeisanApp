package com.cn.beisanproject.modelbean;

import java.util.List;

public class PurchaseMonthColletLineBean {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_BRAND":"","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"污水处理","A_PURTYPE":"月度","DESCRIPTION":"氯化铝","ITEMDESC":"氯化铝","ITEMNUM":"429080602","LINECOST":"0.0000","LINETYPE":"项目","LOADEDCOST":"0.0000","ORDERQTY":"300.00000","ORDERUNIT":"斤","PRLINENUM":"16","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"0"},{"A_BRAND":"","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"https://item.taobao.com/item.htm?id=620659411401&spm=2014.21600712.0.0","A_PURTYPE":"月度","DESCRIPTION":"户外配电箱锁MS307","ITEMDESC":"户外配电箱锁MS307","ITEMNUM":"429080604","LINECOST":"0.0000","LINETYPE":"项目","LOADEDCOST":"0.0000","ORDERQTY":"20.00000","ORDERUNIT":"把","PRLINENUM":"18","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"0"},{"A_BRAND":"","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"https://item.taobao.com/item.htm?id=17550892206&scm=20140619.rec.364322186.17550892206&scm=20140619.rec.364322186.17550892206","A_PURTYPE":"月度","DESCRIPTION":"埃美柯DN20电动二通阀706","ITEMDESC":"埃美柯DN20电动二通阀706","ITEMNUM":"429080307","LINECOST":"10,530.9700","LINETYPE":"项目","LOADEDCOST":"10,530.9700","ORDERQTY":"100.00000","ORDERUNIT":"只","PRLINENUM":"10","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"105.31"},{"A_BRAND":"","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"5gs 4L中央空调  太阳牌","A_PURTYPE":"月度","DESCRIPTION":"中央空调冷冻油","ITEMDESC":"中央空调冷冻油","ITEMNUM":"429080382","LINECOST":"6,653.1000","LINETYPE":"项目","LOADEDCOST":"6,653.1000","ORDERQTY":"21.00000","ORDERUNIT":"听","PRLINENUM":"21","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"316.81"},{"A_BRAND":"","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"YJV-0.6/1KV-5*10东方电缆","A_PURTYPE":"月度","DESCRIPTION":"电力电缆","ITEMDESC":"电力电缆","ITEMNUM":"462110011","LINECOST":"5,079.6500","LINETYPE":"项目","LOADEDCOST":"5,079.6500","ORDERQTY":"200.00000","ORDERUNIT":"米","PRLINENUM":"11","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"25.4"},{"A_BRAND":"","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"YJV-0.6/1KV5*6东方电缆","A_PURTYPE":"月度","DESCRIPTION":"塑料铜芯电力电缆","ITEMDESC":"塑料铜芯电力电缆","ITEMNUM":"462110029","LINECOST":"3,401.7100","LINETYPE":"项目","LOADEDCOST":"3,401.7100","ORDERQTY":"200.00000","ORDERUNIT":"米","PRLINENUM":"12","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"17.01"},{"A_BRAND":"无锡锡宏泵业机械有限公司 13814228601","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"工作压力0.6MPA  流量5m3/h   转速960r/min","A_PURTYPE":"月度","DESCRIPTION":"单螺杆泵G42-1","ITEMDESC":"单螺杆泵G42-1","ITEMNUM":"429020217","LINECOST":"2,546.9000","LINETYPE":"项目","LOADEDCOST":"2,546.9000","ORDERQTY":"1.00000","ORDERUNIT":"台","PRLINENUM":"5","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"2,546.9"}]}
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
         * resultlist : [{"A_BRAND":"","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"污水处理","A_PURTYPE":"月度","DESCRIPTION":"氯化铝","ITEMDESC":"氯化铝","ITEMNUM":"429080602","LINECOST":"0.0000","LINETYPE":"项目","LOADEDCOST":"0.0000","ORDERQTY":"300.00000","ORDERUNIT":"斤","PRLINENUM":"16","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"0"},{"A_BRAND":"","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"https://item.taobao.com/item.htm?id=620659411401&spm=2014.21600712.0.0","A_PURTYPE":"月度","DESCRIPTION":"户外配电箱锁MS307","ITEMDESC":"户外配电箱锁MS307","ITEMNUM":"429080604","LINECOST":"0.0000","LINETYPE":"项目","LOADEDCOST":"0.0000","ORDERQTY":"20.00000","ORDERUNIT":"把","PRLINENUM":"18","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"0"},{"A_BRAND":"","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"https://item.taobao.com/item.htm?id=17550892206&scm=20140619.rec.364322186.17550892206&scm=20140619.rec.364322186.17550892206","A_PURTYPE":"月度","DESCRIPTION":"埃美柯DN20电动二通阀706","ITEMDESC":"埃美柯DN20电动二通阀706","ITEMNUM":"429080307","LINECOST":"10,530.9700","LINETYPE":"项目","LOADEDCOST":"10,530.9700","ORDERQTY":"100.00000","ORDERUNIT":"只","PRLINENUM":"10","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"105.31"},{"A_BRAND":"","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"5gs 4L中央空调  太阳牌","A_PURTYPE":"月度","DESCRIPTION":"中央空调冷冻油","ITEMDESC":"中央空调冷冻油","ITEMNUM":"429080382","LINECOST":"6,653.1000","LINETYPE":"项目","LOADEDCOST":"6,653.1000","ORDERQTY":"21.00000","ORDERUNIT":"听","PRLINENUM":"21","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"316.81"},{"A_BRAND":"","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"YJV-0.6/1KV-5*10东方电缆","A_PURTYPE":"月度","DESCRIPTION":"电力电缆","ITEMDESC":"电力电缆","ITEMNUM":"462110011","LINECOST":"5,079.6500","LINETYPE":"项目","LOADEDCOST":"5,079.6500","ORDERQTY":"200.00000","ORDERUNIT":"米","PRLINENUM":"11","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"25.4"},{"A_BRAND":"","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"YJV-0.6/1KV5*6东方电缆","A_PURTYPE":"月度","DESCRIPTION":"塑料铜芯电力电缆","ITEMDESC":"塑料铜芯电力电缆","ITEMNUM":"462110029","LINECOST":"3,401.7100","LINETYPE":"项目","LOADEDCOST":"3,401.7100","ORDERQTY":"200.00000","ORDERUNIT":"米","PRLINENUM":"12","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"17.01"},{"A_BRAND":"无锡锡宏泵业机械有限公司 13814228601","A_BUDGETDESC":"","A_BUDGETNUM":"","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"工作压力0.6MPA  流量5m3/h   转速960r/min","A_PURTYPE":"月度","DESCRIPTION":"单螺杆泵G42-1","ITEMDESC":"单螺杆泵G42-1","ITEMNUM":"429020217","LINECOST":"2,546.9000","LINETYPE":"项目","LOADEDCOST":"2,546.9000","ORDERQTY":"1.00000","ORDERUNIT":"台","PRLINENUM":"5","PRNUM":"WZ00797","REMARK":"","REQUESTEDBY":"LIUZ","REQUESTEDBYDESC":"柳铮","RFQNUM":"","UNITCOST":"2,546.9"}]
         */

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

        public static class ResultlistBean {
            /**
             * A_BRAND :
             * A_BUDGETDESC :
             * A_BUDGETNUM :
             * A_CREWIDDESC : 设施
             * A_DEPTDESC : 工程技术部
             * A_MODEL : 污水处理
             * A_PURTYPE : 月度
             * DESCRIPTION : 氯化铝
             * ITEMDESC : 氯化铝
             * ITEMNUM : 429080602
             * LINECOST : 0.0000
             * LINETYPE : 项目
             * LOADEDCOST : 0.0000
             * ORDERQTY : 300.00000
             * ORDERUNIT : 斤
             * PRLINENUM : 16
             * PRNUM : WZ00797
             * REMARK :
             * REQUESTEDBY : LIUZ
             * REQUESTEDBYDESC : 柳铮
             * RFQNUM :
             * UNITCOST : 0
             */

            private String A_BRAND;
            private String A_BUDGETDESC;
            private String A_BUDGETNUM;
            private String A_CREWIDDESC;
            private String A_DEPTDESC;
            private String A_MODEL;
            private String A_PURTYPE;
            private String DESCRIPTION;
            private String ITEMDESC;
            private String ITEMNUM;
            private String LINECOST;
            private String LINETYPE;
            private String LOADEDCOST;
            private String ORDERQTY;
            private String ORDERUNIT;
            private String PRLINENUM;
            private String PRNUM;
            private String REMARK;
            private String REQUESTEDBY;
            private String REQUESTEDBYDESC;
            private String RFQNUM;
            private String UNITCOST;

            public String getA_BRAND() {
                return A_BRAND;
            }

            public void setA_BRAND(String A_BRAND) {
                this.A_BRAND = A_BRAND;
            }

            public String getA_BUDGETDESC() {
                return A_BUDGETDESC;
            }

            public void setA_BUDGETDESC(String A_BUDGETDESC) {
                this.A_BUDGETDESC = A_BUDGETDESC;
            }

            public String getA_BUDGETNUM() {
                return A_BUDGETNUM;
            }

            public void setA_BUDGETNUM(String A_BUDGETNUM) {
                this.A_BUDGETNUM = A_BUDGETNUM;
            }

            public String getA_CREWIDDESC() {
                return A_CREWIDDESC;
            }

            public void setA_CREWIDDESC(String A_CREWIDDESC) {
                this.A_CREWIDDESC = A_CREWIDDESC;
            }

            public String getA_DEPTDESC() {
                return A_DEPTDESC;
            }

            public void setA_DEPTDESC(String A_DEPTDESC) {
                this.A_DEPTDESC = A_DEPTDESC;
            }

            public String getA_MODEL() {
                return A_MODEL;
            }

            public void setA_MODEL(String A_MODEL) {
                this.A_MODEL = A_MODEL;
            }

            public String getA_PURTYPE() {
                return A_PURTYPE;
            }

            public void setA_PURTYPE(String A_PURTYPE) {
                this.A_PURTYPE = A_PURTYPE;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
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

            public String getLINECOST() {
                return LINECOST;
            }

            public void setLINECOST(String LINECOST) {
                this.LINECOST = LINECOST;
            }

            public String getLINETYPE() {
                return LINETYPE;
            }

            public void setLINETYPE(String LINETYPE) {
                this.LINETYPE = LINETYPE;
            }

            public String getLOADEDCOST() {
                return LOADEDCOST;
            }

            public void setLOADEDCOST(String LOADEDCOST) {
                this.LOADEDCOST = LOADEDCOST;
            }

            public String getORDERQTY() {
                return ORDERQTY;
            }

            public void setORDERQTY(String ORDERQTY) {
                this.ORDERQTY = ORDERQTY;
            }

            public String getORDERUNIT() {
                return ORDERUNIT;
            }

            public void setORDERUNIT(String ORDERUNIT) {
                this.ORDERUNIT = ORDERUNIT;
            }

            public String getPRLINENUM() {
                return PRLINENUM;
            }

            public void setPRLINENUM(String PRLINENUM) {
                this.PRLINENUM = PRLINENUM;
            }

            public String getPRNUM() {
                return PRNUM;
            }

            public void setPRNUM(String PRNUM) {
                this.PRNUM = PRNUM;
            }

            public String getREMARK() {
                return REMARK;
            }

            public void setREMARK(String REMARK) {
                this.REMARK = REMARK;
            }

            public String getREQUESTEDBY() {
                return REQUESTEDBY;
            }

            public void setREQUESTEDBY(String REQUESTEDBY) {
                this.REQUESTEDBY = REQUESTEDBY;
            }

            public String getREQUESTEDBYDESC() {
                return REQUESTEDBYDESC;
            }

            public void setREQUESTEDBYDESC(String REQUESTEDBYDESC) {
                this.REQUESTEDBYDESC = REQUESTEDBYDESC;
            }

            public String getRFQNUM() {
                return RFQNUM;
            }

            public void setRFQNUM(String RFQNUM) {
                this.RFQNUM = RFQNUM;
            }

            public String getUNITCOST() {
                return UNITCOST;
            }

            public void setUNITCOST(String UNITCOST) {
                this.UNITCOST = UNITCOST;
            }
        }
    }
}
