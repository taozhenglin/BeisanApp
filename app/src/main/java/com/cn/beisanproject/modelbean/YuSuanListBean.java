package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class YuSuanListBean implements Serializable {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"BUDGETCOST":"200,100.00","DEPARTMENT":"","DESCRIPTION":"桥吊委外维修费用-桥吊清洗","FCSTATUS":"已批准","FINCNTRLID":7477,"PROJECTID":"2019CB-XL-Q-036","REMAININGCOST":"200,100.00","UDCREATER":"","UDSSND":"2021","UDYSLX":"成本性"},{"BUDGETCOST":"10,000.00","DEPARTMENT":"","DESCRIPTION":"桥吊委外维修费用-安川变频器功率单元修理","FCSTATUS":"已批准","FINCNTRLID":7478,"PROJECTID":"2019CB-XL-Q-037","REMAININGCOST":"9,980.00","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"桥吊委外维修费用-拖令电缆改造","FCSTATUS":"已批准","FINCNTRLID":7479,"PROJECTID":"2019CB-XL-Q-038","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"桥吊委外维修费用-吊具钢结构修理","FCSTATUS":"已批准","FINCNTRLID":7480,"PROJECTID":"2019CB-XL-Q-039","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"桥吊委外维修费用-17#桥吊高压电缆卷盘改造","FCSTATUS":"已批准","FINCNTRLID":7481,"PROJECTID":"2019CB-XL-Q-043","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"2,000.00","DEPARTMENT":"","DESCRIPTION":"桥吊委外维修费用-其它","FCSTATUS":"已批准","FINCNTRLID":7482,"PROJECTID":"2019CB-XL-Q-QT","REMAININGCOST":"2,000.00","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-钢丝绳更换","FCSTATUS":"已批准","FINCNTRLID":7484,"PROJECTID":"2019CB-XL-R-001","REMAININGCOST":"-1,101,110.00","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-其他零星委外维修","FCSTATUS":"已批准","FINCNTRLID":7485,"PROJECTID":"2019CB-XL-R-002","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用- 整机润滑","FCSTATUS":"已批准","FINCNTRLID":7486,"PROJECTID":"2019CB-XL-R-003","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用- 液压油更换","FCSTATUS":"已批准","FINCNTRLID":7487,"PROJECTID":"2019CB-XL-R-004","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-齿轮油更换","FCSTATUS":"已批准","FINCNTRLID":7488,"PROJECTID":"2019CB-XL-R-005","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-小车电机更换","FCSTATUS":"已批准","FINCNTRLID":7489,"PROJECTID":"2019CB-XL-R-007","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-起升滑轮更换及翻新","FCSTATUS":"已批准","FINCNTRLID":7490,"PROJECTID":"2019CB-XL-R-008","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-小车减速箱更换","FCSTATUS":"已批准","FINCNTRLID":7491,"PROJECTID":"2019CB-XL-R-009","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-发电机保养","FCSTATUS":"已批准","FINCNTRLID":7492,"PROJECTID":"2019CB-XL-R-010","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"5台龙门吊委外维修费用-发动机大修","FCSTATUS":"已批准","FINCNTRLID":7493,"PROJECTID":"2019CB-XL-R-011","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-防摇油缸修理","FCSTATUS":"已批准","FINCNTRLID":7494,"PROJECTID":"2019CB-XL-R-012","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-吊具电机维修","FCSTATUS":"已批准","FINCNTRLID":7495,"PROJECTID":"2019CB-XL-R-013","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-龙门吊油箱清洗","FCSTATUS":"已批准","FINCNTRLID":7496,"PROJECTID":"2019CB-XL-R-014","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-龙门吊吊具大修","FCSTATUS":"已批准","FINCNTRLID":7497,"PROJECTID":"2019CB-XL-R-015","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""}],"showcount":20,"totalpage":64,"totalresult":1264}
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
         * resultlist : [{"BUDGETCOST":"200,100.00","DEPARTMENT":"","DESCRIPTION":"桥吊委外维修费用-桥吊清洗","FCSTATUS":"已批准","FINCNTRLID":7477,"PROJECTID":"2019CB-XL-Q-036","REMAININGCOST":"200,100.00","UDCREATER":"","UDSSND":"2021","UDYSLX":"成本性"},{"BUDGETCOST":"10,000.00","DEPARTMENT":"","DESCRIPTION":"桥吊委外维修费用-安川变频器功率单元修理","FCSTATUS":"已批准","FINCNTRLID":7478,"PROJECTID":"2019CB-XL-Q-037","REMAININGCOST":"9,980.00","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"桥吊委外维修费用-拖令电缆改造","FCSTATUS":"已批准","FINCNTRLID":7479,"PROJECTID":"2019CB-XL-Q-038","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"桥吊委外维修费用-吊具钢结构修理","FCSTATUS":"已批准","FINCNTRLID":7480,"PROJECTID":"2019CB-XL-Q-039","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"桥吊委外维修费用-17#桥吊高压电缆卷盘改造","FCSTATUS":"已批准","FINCNTRLID":7481,"PROJECTID":"2019CB-XL-Q-043","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"2,000.00","DEPARTMENT":"","DESCRIPTION":"桥吊委外维修费用-其它","FCSTATUS":"已批准","FINCNTRLID":7482,"PROJECTID":"2019CB-XL-Q-QT","REMAININGCOST":"2,000.00","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-钢丝绳更换","FCSTATUS":"已批准","FINCNTRLID":7484,"PROJECTID":"2019CB-XL-R-001","REMAININGCOST":"-1,101,110.00","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-其他零星委外维修","FCSTATUS":"已批准","FINCNTRLID":7485,"PROJECTID":"2019CB-XL-R-002","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用- 整机润滑","FCSTATUS":"已批准","FINCNTRLID":7486,"PROJECTID":"2019CB-XL-R-003","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用- 液压油更换","FCSTATUS":"已批准","FINCNTRLID":7487,"PROJECTID":"2019CB-XL-R-004","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-齿轮油更换","FCSTATUS":"已批准","FINCNTRLID":7488,"PROJECTID":"2019CB-XL-R-005","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-小车电机更换","FCSTATUS":"已批准","FINCNTRLID":7489,"PROJECTID":"2019CB-XL-R-007","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-起升滑轮更换及翻新","FCSTATUS":"已批准","FINCNTRLID":7490,"PROJECTID":"2019CB-XL-R-008","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-小车减速箱更换","FCSTATUS":"已批准","FINCNTRLID":7491,"PROJECTID":"2019CB-XL-R-009","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-发电机保养","FCSTATUS":"已批准","FINCNTRLID":7492,"PROJECTID":"2019CB-XL-R-010","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"5台龙门吊委外维修费用-发动机大修","FCSTATUS":"已批准","FINCNTRLID":7493,"PROJECTID":"2019CB-XL-R-011","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-防摇油缸修理","FCSTATUS":"已批准","FINCNTRLID":7494,"PROJECTID":"2019CB-XL-R-012","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-吊具电机维修","FCSTATUS":"已批准","FINCNTRLID":7495,"PROJECTID":"2019CB-XL-R-013","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-龙门吊油箱清洗","FCSTATUS":"已批准","FINCNTRLID":7496,"PROJECTID":"2019CB-XL-R-014","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""},{"BUDGETCOST":"","DEPARTMENT":"","DESCRIPTION":"龙门吊委外维修费用-龙门吊吊具大修","FCSTATUS":"已批准","FINCNTRLID":7497,"PROJECTID":"2019CB-XL-R-015","REMAININGCOST":"","UDCREATER":"","UDSSND":"","UDYSLX":""}]
         * showcount : 20
         * totalpage : 64
         * totalresult : 1264
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
             * BUDGETCOST : 200,100.00
             * DEPARTMENT :
             * DESCRIPTION : 桥吊委外维修费用-桥吊清洗
             * FCSTATUS : 已批准
             * FINCNTRLID : 7477
             * PROJECTID : 2019CB-XL-Q-036
             * REMAININGCOST : 200,100.00
             * UDCREATER :
             * UDSSND : 2021
             * UDYSLX : 成本性
             */

            private String BUDGETCOST;
            private String DEPARTMENT;
            private String DESCRIPTION;
            private String FCSTATUS;
            private int FINCNTRLID;
            private String PROJECTID;
            private String REMAININGCOST;
            private String UDCREATER;
            private String UDSSND;
            private String UDYSLX;

            public String getBUDGETCOST() {
                return BUDGETCOST;
            }

            public void setBUDGETCOST(String BUDGETCOST) {
                this.BUDGETCOST = BUDGETCOST;
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

            public String getFCSTATUS() {
                return FCSTATUS;
            }

            public void setFCSTATUS(String FCSTATUS) {
                this.FCSTATUS = FCSTATUS;
            }

            public int getFINCNTRLID() {
                return FINCNTRLID;
            }

            public void setFINCNTRLID(int FINCNTRLID) {
                this.FINCNTRLID = FINCNTRLID;
            }

            public String getPROJECTID() {
                return PROJECTID;
            }

            public void setPROJECTID(String PROJECTID) {
                this.PROJECTID = PROJECTID;
            }

            public String getREMAININGCOST() {
                return REMAININGCOST;
            }

            public void setREMAININGCOST(String REMAININGCOST) {
                this.REMAININGCOST = REMAININGCOST;
            }

            public String getUDCREATER() {
                return UDCREATER;
            }

            public void setUDCREATER(String UDCREATER) {
                this.UDCREATER = UDCREATER;
            }

            public String getUDSSND() {
                return UDSSND;
            }

            public void setUDSSND(String UDSSND) {
                this.UDSSND = UDSSND;
            }

            public String getUDYSLX() {
                return UDYSLX;
            }

            public void setUDYSLX(String UDYSLX) {
                this.UDYSLX = UDYSLX;
            }
        }
    }
}
