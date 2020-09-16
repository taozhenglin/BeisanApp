package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class MaterialRequestListBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_BUDGETNUM":"","A_DEPT":"信息中心","A_MARKA":"N","A_TODEPT":"党群工作部","A_USEFOR":"车辆用","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"app 修改测试","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-10 17:56:28","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"起草","TODEPT":"党群工作部","USEFOR":"港内牌照车辆","WONUM":"43197","WORKORDERID":62840,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":""},{"A_BUDGETNUM":"2019CB-XL-Q-038","A_DEPT":"信息中心","A_MARKA":"N","A_TODEPT":"党群工作部","A_USEFOR":"办公用品","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"appp","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-06 16:46:26","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"申请部门经理审批","TODEPT":"党群工作部","USEFOR":"办公用品","WONUM":"43191","WORKORDERID":62830,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":"桥吊委外维修费用-拖令电缆改造"},{"A_BUDGETNUM":"","A_DEPT":"信息中心","A_MARKA":"N","A_TODEPT":"党群工作部","A_USEFOR":"车辆用（柴油）","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"领料申请单修改测试","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-06 15:19:15","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"起草","TODEPT":"党群工作部","USEFOR":"车辆用（柴油）","WONUM":"43190","WORKORDERID":62829,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":""},{"A_BUDGETNUM":"","A_DEPT":"信息中心","A_MARKA":"N","A_TODEPT":"党群工作部","A_USEFOR":"车辆用柴油","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"领料申请单测试2","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-06 15:17:21","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"起草","TODEPT":"党群工作部","USEFOR":"","WONUM":"43189","WORKORDERID":62828,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":""},{"A_BUDGETNUM":"2019CB-XL-Q-038","A_DEPT":"信息中心","A_MARKA":"Y","A_TODEPT":"党群工作部","A_USEFOR":"办公设施公用","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"apptesttt","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-06 14:40:23","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"起草","TODEPT":"党群工作部","USEFOR":"办公设施公用","WONUM":"43187","WORKORDERID":62826,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":"桥吊委外维修费用-拖令电缆改造"},{"A_BUDGETNUM":"2019CB-XL-Q-039","A_DEPT":"信息中心","A_MARKA":"N","A_TODEPT":"安全卫环部","A_USEFOR":"IT材料","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"app test","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-06 14:35:00","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"起草","TODEPT":"安全卫环部","USEFOR":"IT材料","WONUM":"43186","WORKORDERID":62825,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":"桥吊委外维修费用-吊具钢结构修理"},{"A_BUDGETNUM":"2019CB-XL-Q-039","A_DEPT":"信息中心","A_MARKA":"N","A_TODEPT":"安全卫环部","A_USEFOR":"IT材料","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"app test","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-06 14:33:50","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"起草","TODEPT":"安全卫环部","USEFOR":"IT材料","WONUM":"43185","WORKORDERID":62824,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":"桥吊委外维修费用-吊具钢结构修理"}],"showcount":20,"totalpage":65,"totalresult":1283}
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
         * resultlist : [{"A_BUDGETNUM":"","A_DEPT":"信息中心","A_MARKA":"N","A_TODEPT":"党群工作部","A_USEFOR":"车辆用","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"app 修改测试","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-10 17:56:28","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"起草","TODEPT":"党群工作部","USEFOR":"港内牌照车辆","WONUM":"43197","WORKORDERID":62840,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":""},{"A_BUDGETNUM":"2019CB-XL-Q-038","A_DEPT":"信息中心","A_MARKA":"N","A_TODEPT":"党群工作部","A_USEFOR":"办公用品","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"appp","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-06 16:46:26","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"申请部门经理审批","TODEPT":"党群工作部","USEFOR":"办公用品","WONUM":"43191","WORKORDERID":62830,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":"桥吊委外维修费用-拖令电缆改造"},{"A_BUDGETNUM":"","A_DEPT":"信息中心","A_MARKA":"N","A_TODEPT":"党群工作部","A_USEFOR":"车辆用（柴油）","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"领料申请单修改测试","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-06 15:19:15","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"起草","TODEPT":"党群工作部","USEFOR":"车辆用（柴油）","WONUM":"43190","WORKORDERID":62829,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":""},{"A_BUDGETNUM":"","A_DEPT":"信息中心","A_MARKA":"N","A_TODEPT":"党群工作部","A_USEFOR":"车辆用柴油","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"领料申请单测试2","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-06 15:17:21","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"起草","TODEPT":"党群工作部","USEFOR":"","WONUM":"43189","WORKORDERID":62828,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":""},{"A_BUDGETNUM":"2019CB-XL-Q-038","A_DEPT":"信息中心","A_MARKA":"Y","A_TODEPT":"党群工作部","A_USEFOR":"办公设施公用","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"apptesttt","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-06 14:40:23","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"起草","TODEPT":"党群工作部","USEFOR":"办公设施公用","WONUM":"43187","WORKORDERID":62826,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":"桥吊委外维修费用-拖令电缆改造"},{"A_BUDGETNUM":"2019CB-XL-Q-039","A_DEPT":"信息中心","A_MARKA":"N","A_TODEPT":"安全卫环部","A_USEFOR":"IT材料","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"app test","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-06 14:35:00","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"起草","TODEPT":"安全卫环部","USEFOR":"IT材料","WONUM":"43186","WORKORDERID":62825,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":"桥吊委外维修费用-吊具钢结构修理"},{"A_BUDGETNUM":"2019CB-XL-Q-039","A_DEPT":"信息中心","A_MARKA":"N","A_TODEPT":"安全卫环部","A_USEFOR":"IT材料","A_WOTYPE":"MR","BZ":"","CREWID":"","DEPARTMENT":"信息中心","DESCRIPTION":"app test","ESTMATCOST":"0.00","PRIMARYPHONE":"18090908080","REPORTDATE":"2020-07-06 14:33:50","REPORTEDBY":"MAXADMIN","REPORTEDBYDESC":"系统管理员","SITEID":"1000","STATUS":"起草","TODEPT":"安全卫环部","USEFOR":"IT材料","WONUM":"43185","WORKORDERID":62824,"WOTYPEDESC":"通用领料单","YSDESCRIPTION":"桥吊委外维修费用-吊具钢结构修理"}]
         * showcount : 20
         * totalpage : 65
         * totalresult : 1283
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
             * A_BUDGETNUM :
             * A_DEPT : 信息中心
             * A_MARKA : N
             * A_TODEPT : 党群工作部
             * A_USEFOR : 车辆用
             * A_WOTYPE : MR
             * BZ :
             * CREWID :
             * DEPARTMENT : 信息中心
             * DESCRIPTION : app 修改测试
             * ESTMATCOST : 0.00
             * PRIMARYPHONE : 18090908080
             * REPORTDATE : 2020-07-10 17:56:28
             * REPORTEDBY : MAXADMIN
             * REPORTEDBYDESC : 系统管理员
             * SITEID : 1000
             * STATUS : 起草
             * TODEPT : 党群工作部
             * USEFOR : 港内牌照车辆
             * WONUM : 43197
             * WORKORDERID : 62840
             * WOTYPEDESC : 通用领料单
             * YSDESCRIPTION :
             */

            private String A_BUDGETNUM;
            private String A_DEPT;
            private String A_MARKA;
            private String A_TODEPT;
            private String A_USEFOR;
            private String A_WOTYPE;
            private String BZ;
            private String CREWID;
            private String DEPARTMENT;
            private String DESCRIPTION;
            private String ESTMATCOST;
            private String PRIMARYPHONE;
            private String REPORTDATE;
            private String REPORTEDBY;
            private String REPORTEDBYDESC;
            private String SITEID;
            private String STATUS;
            private String TODEPT;
            private String USEFOR;
            private String WONUM;
            private int WORKORDERID;
            private String WOTYPEDESC;
            private String YSDESCRIPTION;

            public String getA_BUDGETNUM() {
                return A_BUDGETNUM;
            }

            public void setA_BUDGETNUM(String A_BUDGETNUM) {
                this.A_BUDGETNUM = A_BUDGETNUM;
            }

            public String getA_DEPT() {
                return A_DEPT;
            }

            public void setA_DEPT(String A_DEPT) {
                this.A_DEPT = A_DEPT;
            }

            public String getA_MARKA() {
                return A_MARKA;
            }

            public void setA_MARKA(String A_MARKA) {
                this.A_MARKA = A_MARKA;
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

            public String getA_WOTYPE() {
                return A_WOTYPE;
            }

            public void setA_WOTYPE(String A_WOTYPE) {
                this.A_WOTYPE = A_WOTYPE;
            }

            public String getBZ() {
                return BZ;
            }

            public void setBZ(String BZ) {
                this.BZ = BZ;
            }

            public String getCREWID() {
                return CREWID;
            }

            public void setCREWID(String CREWID) {
                this.CREWID = CREWID;
            }

            public String getDEPARTMENT() {
                return DEPARTMENT;
            }

            public void setDEPARTMENT(String DEPARTMENT) {
                this.DEPARTMENT = DEPARTMENT;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getESTMATCOST() {
                return ESTMATCOST;
            }

            public void setESTMATCOST(String ESTMATCOST) {
                this.ESTMATCOST = ESTMATCOST;
            }

            public String getPRIMARYPHONE() {
                return PRIMARYPHONE;
            }

            public void setPRIMARYPHONE(String PRIMARYPHONE) {
                this.PRIMARYPHONE = PRIMARYPHONE;
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

            public String getREPORTEDBYDESC() {
                return REPORTEDBYDESC;
            }

            public void setREPORTEDBYDESC(String REPORTEDBYDESC) {
                this.REPORTEDBYDESC = REPORTEDBYDESC;
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

            public String getTODEPT() {
                return TODEPT;
            }

            public void setTODEPT(String TODEPT) {
                this.TODEPT = TODEPT;
            }

            public String getUSEFOR() {
                return USEFOR;
            }

            public void setUSEFOR(String USEFOR) {
                this.USEFOR = USEFOR;
            }

            public String getWONUM() {
                return WONUM;
            }

            public void setWONUM(String WONUM) {
                this.WONUM = WONUM;
            }

            public int getWORKORDERID() {
                return WORKORDERID;
            }

            public void setWORKORDERID(int WORKORDERID) {
                this.WORKORDERID = WORKORDERID;
            }

            public String getWOTYPEDESC() {
                return WOTYPEDESC;
            }

            public void setWOTYPEDESC(String WOTYPEDESC) {
                this.WOTYPEDESC = WOTYPEDESC;
            }

            public String getYSDESCRIPTION() {
                return YSDESCRIPTION;
            }

            public void setYSDESCRIPTION(String YSDESCRIPTION) {
                this.YSDESCRIPTION = YSDESCRIPTION;
            }
        }
    }
}
