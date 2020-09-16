package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class ProjectMonthListBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_BUDGETDESC":"桥吊委外维修费用-桥吊清洗","A_BUDGETNUM":"2019CB-XL-Q-036","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202008","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"信息中心","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-07-13 11:30:55","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"7-13","ISSUEDATE":"2020-07-13 11:28:42","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":3103,"PRNUM":"PROJ00186","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"已批准","STATUSDESC":"已批准","TOTALCOST":"111.0000","UDYS":"N","VENDOR":"","XMLB":"其他"},{"A_BUDGETDESC":"龙门吊委外维修费用- 液压油更换","A_BUDGETNUM":"2019CB-XL-R-004","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"信息中心","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-07-06 13:36:07","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"测试","ISSUEDATE":"2020-07-03 13:48:06","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":3081,"PRNUM":"PROJ00185","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"应用系统管理主管审批","STATUSDESC":"应用系统管理主管审批","TOTALCOST":"100,000.0000","UDYS":"N","VENDOR":"","XMLB":"技改"},{"A_BUDGETDESC":"龙门吊委外维修费用- 液压油更换","A_BUDGETNUM":"2019CB-XL-R-004","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"信息中心","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-24 16:22:50","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"测试","ISSUEDATE":"2020-06-12 09:08:32","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":3029,"PRNUM":"PROJ00184","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"应用系统管理主管审批","STATUSDESC":"应用系统管理主管审批","TOTALCOST":"100,000.0000","UDYS":"N","VENDOR":"","XMLB":"技改"},{"A_BUDGETDESC":"桥吊委外维修费用-17#桥吊高压电缆卷盘改造","A_BUDGETNUM":"2019CB-XL-Q-043","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"信息中心","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-07-01 09:38:33","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"父子级中预算保持一致测试","ISSUEDATE":"2020-06-12 08:42:31","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":3027,"PRNUM":"PROJ00183","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"应用系统管理主管审批","STATUSDESC":"应用系统管理主管审批","TOTALCOST":"1,333,333.0000","UDYS":"N","VENDOR":"","XMLB":"技改"},{"A_BUDGETDESC":"龙门吊委外维修费用-钢丝绳更换","A_BUDGETNUM":"2019CB-XL-R-001","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"信息中心","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-11 16:29:07","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"cehsi","ISSUEDATE":"2020-06-11 14:11:30","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":3017,"PRNUM":"PROJ00182","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"总经理审批","STATUSDESC":"总经理审批","TOTALCOST":"1,101,110.0000","UDYS":"N","VENDOR":"","XMLB":"技改"},{"A_BUDGETDESC":"桥吊委外维修费用-安川变频器功率单元修理","A_BUDGETNUM":"2019CB-XL-Q-037","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"党群工作部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-09 10:26:27","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"app月度计划流程测试","ISSUEDATE":"2020-06-09 10:08:21","LXLX":"项目月度计划","MEMO":"","ORGID":"10","PRID":3007,"PRNUM":"XM00266","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"部门领导已批准","STATUSDESC":"部门领导已批准","TOTALCOST":"20.0000","UDYS":"N","VENDOR":"","XMLB":"技改"},{"A_BUDGETDESC":"龙门吊委外维修费用-龙门吊油箱清洗","A_BUDGETNUM":"2019CB-XL-R-014","A_COMPANY":"CFS","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"信息中心","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-11 13:16:52","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"APP月度计划流程测试","ISSUEDATE":"2020-06-09 10:05:49","LXLX":"项目月度计划","MEMO":"","ORGID":"10","PRID":3006,"PRNUM":"XM00265","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"等待批准","STATUSDESC":"等待批准","TOTALCOST":"111,111.0000","UDYS":"N","VENDOR":"","XMLB":"技改"},{"A_BUDGETDESC":"桥吊委外维修费用-桥吊清洗","A_BUDGETNUM":"2019CB-XL-Q-036","A_COMPANY":"CFS","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"安全卫环部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-09 10:05:27","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"app流程测试","ISSUEDATE":"2020-06-08 17:18:09","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":3004,"PRNUM":"PROJ00181","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"已批准","STATUSDESC":"已批准","TOTALCOST":"100,000.0000","UDYS":"N","VENDOR":"","XMLB":"车辆购置"},{"A_BUDGETDESC":"设施委外维修费用-港区测速设备维保","A_BUDGETNUM":"2020CB-XL-S-046","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202005","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"安全卫环部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-05-25 10:18:41","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"测试","ISSUEDATE":"2020-04-20 18:40:42","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":2903,"PRNUM":"PROJ00178","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"申请部门经理审批","STATUSDESC":"申请部门经理审批","TOTALCOST":"20,000.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"流机委外维修费用-堆高机-转向油缸整修","A_BUDGETNUM":"2019CB-XL-L-DG-005-2","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202004","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"安全卫环部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-04-20 17:06:50","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"测试","ISSUEDATE":"2020-03-07 14:41:23","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":2642,"PRNUM":"PROJ00177","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"部门领导已批准","STATUSDESC":"部门领导已批准","TOTALCOST":"2,000.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"无线终端更新（北三32台）","A_BUDGETNUM":"2020ITZB-BSZD","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202003","A_PRSUMTYPE":"","A_PRTYPE":"PROJECT","A_PURCATALOG":"信息中心","A_PURTYPE":"年度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-02-13 12:21:22","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"无线终端更新采购立项（北三32台）","ISSUEDATE":"2020-02-13 11:58:54","LXLX":"项目立项审批","MEMO":"预计年度更新160台无线终端（北三32台，港吉80台，远东48台），本次立项拟采购32台，详情见附件","ORGID":"10","PRID":2570,"PRNUM":"PROJ00176","REQUESTEDBY":"FENGZHH","REQUIREDDATE":"","R_DEPTDESC":"冯洲豪","R_PRSTATUS":"","SITEID":"1000","STATUS":"项目主管审批","STATUSDESC":"项目主管审批","TOTALCOST":"1,600,000.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"无线终端新增（穿山48台）","A_BUDGETNUM":"2020ITZB-CSZD","A_COMPANY":"穿山","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202003","A_PRSUMTYPE":"","A_PRTYPE":"PROJECT","A_PURCATALOG":"信息中心","A_PURTYPE":"年度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-02-13 12:21:37","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"无线终端新增采购立项（穿山48台）","ISSUEDATE":"2020-02-13 11:55:14","LXLX":"项目立项审批","MEMO":"为配合1号泊位投用，拟采购48台无线终端，详情见附件","ORGID":"10","PRID":2569,"PRNUM":"PROJ00175","REQUESTEDBY":"FENGZHH","REQUIREDDATE":"","R_DEPTDESC":"冯洲豪","R_PRSTATUS":"","SITEID":"1000","STATUS":"项目主管审批","STATUSDESC":"项目主管审批","TOTALCOST":"2,500,000.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"设施委外维修费用","A_BUDGETNUM":"2020CB-XL-S","A_COMPANY":"港吉,意宁","A_CREWID":"设施","A_DEPT":"工程技术部","A_PRKEY":"202003","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-05-25 11:49:52","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"2020年3月设施委外计划（港吉意宁）","ISSUEDATE":"2020-02-03 08:59:08","LXLX":"项目月度计划","MEMO":"","ORGID":"10","PRID":2562,"PRNUM":"XM00263","REQUESTEDBY":"XUP","REQUIREDDATE":"","R_DEPTDESC":"徐鹏","R_PRSTATUS":"","SITEID":"1000","STATUS":"已取消","STATUSDESC":"已取消","TOTALCOST":"12,000.0000","UDYS":"N","VENDOR":"","XMLB":"修理"},{"A_BUDGETDESC":"设施委外维修费用","A_BUDGETNUM":"2020CB-XL-S","A_COMPANY":"北三,远东","A_CREWID":"设施","A_DEPT":"工程技术部","A_PRKEY":"202003","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-08 14:52:32","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"2020年3月设施委外计划（远东北三）","ISSUEDATE":"2020-02-03 08:57:02","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":2561,"PRNUM":"PROJ00180","REQUESTEDBY":"XUP","REQUIREDDATE":"","R_DEPTDESC":"徐鹏","R_PRSTATUS":"","SITEID":"1000","STATUS":"项目主管审批","STATUSDESC":"项目主管审批","TOTALCOST":"1,026,000.0000","UDYS":"N","VENDOR":"","XMLB":"修理"},{"A_BUDGETDESC":"流机委外维修费用-堆高机","A_BUDGETNUM":"2019CB-XL-L-DG","A_COMPANY":"CFS,港吉,远东","A_CREWID":"流机","A_DEPT":"工程技术部","A_PRKEY":"202002","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-01-25 16:11:23","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"2020年2月流机委外计划","ISSUEDATE":"2020-01-22 09:19:09","LXLX":"项目月度计划","MEMO":"","ORGID":"10","PRID":2549,"PRNUM":"XM00261","REQUESTEDBY":"SHAOJ","REQUIREDDATE":"","R_DEPTDESC":"邵军","R_PRSTATUS":"","SITEID":"1000","STATUS":"项目主管审批","STATUSDESC":"项目主管审批","TOTALCOST":"261,509.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"资本性项目","A_BUDGETNUM":"2020CB-ZB","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"营运操作部","A_PRKEY":"202002","A_PRSUMTYPE":"","A_PRTYPE":"PROJECT","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-02-10 15:17:11","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"操作部特种箱班空调申报","ISSUEDATE":"2020-01-21 13:53:09","LXLX":"项目立项审批","MEMO":"西片区放射查验点金蛇公司管理房内空调故障，经工程部检修，已无法修复，需采购更换","ORGID":"10","PRID":2546,"PRNUM":"PROJ00174","REQUESTEDBY":"LIUJ","REQUIREDDATE":"","R_DEPTDESC":"刘君","R_PRSTATUS":"","SITEID":"1000","STATUS":"已批准","STATUSDESC":"已批准","TOTALCOST":"2,800.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"物流分部移动终端项目","A_BUDGETNUM":"2020ITZB-CFS","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202002","A_PRSUMTYPE":"","A_PRTYPE":"PROJECT","A_PURCATALOG":"信息中心","A_PURTYPE":"年度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-11 16:23:32","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"物流分部（CFS）生产系统建设三阶段","ISSUEDATE":"2020-01-20 12:23:10","LXLX":"项目立项审批","MEMO":"主要内容：\n1.硬件采购（手机及平板）\n2.配套APP开发及优化，包括手机端和平板端\n3.CFS生产管理系统三阶段开发","ORGID":"10","PRID":2542,"PRNUM":"PROJ00173","REQUESTEDBY":"WANGNY","REQUIREDDATE":"","R_DEPTDESC":"王宁怡","R_PRSTATUS":"","SITEID":"1000","STATUS":"部门领导已批准","STATUSDESC":"部门领导已批准","TOTALCOST":"150,000.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"资本性项目","A_BUDGETNUM":"2020CB-ZB","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"营运操作部","A_PRKEY":"202002","A_PRSUMTYPE":"","A_PRTYPE":"PROJECT","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-01-20 15:49:20","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"操作部特种箱班防爆手机申报","ISSUEDATE":"2020-01-17 14:54:59","LXLX":"项目立项审批","MEMO":"因工作需要，特种箱班需购买2只防爆手机","ORGID":"10","PRID":2536,"PRNUM":"PROJ00172","REQUESTEDBY":"LIUJ","REQUIREDDATE":"","R_DEPTDESC":"刘君","R_PRSTATUS":"","SITEID":"1000","STATUS":"已批准","STATUSDESC":"已批准","TOTALCOST":"14,000.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2020CB-XL-R","A_COMPANY":"北三,远东","A_CREWID":"龙门吊","A_DEPT":"工程技术部","A_PRKEY":"202002","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-01-23 08:30:10","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"2020年02月龙门吊委外计划（东区）","ISSUEDATE":"2020-01-16 15:22:53","LXLX":"项目月度计划","MEMO":"","ORGID":"10","PRID":2531,"PRNUM":"XM00260","REQUESTEDBY":"YANGXG","REQUIREDDATE":"","R_DEPTDESC":"杨晓刚","R_PRSTATUS":"","SITEID":"1000","STATUS":"项目主管审批","STATUSDESC":"项目主管审批","TOTALCOST":"128,842.8000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2020CB-XL-R","A_COMPANY":"港吉,意宁","A_CREWID":"龙门吊","A_DEPT":"工程技术部","A_PRKEY":"202002","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-01-23 08:30:21","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"2020年2月龙门吊委外计划（西区）","ISSUEDATE":"2020-01-16 15:10:20","LXLX":"项目月度计划","MEMO":"","ORGID":"10","PRID":2529,"PRNUM":"XM00259","REQUESTEDBY":"YANGXG","REQUIREDDATE":"","R_DEPTDESC":"杨晓刚","R_PRSTATUS":"","SITEID":"1000","STATUS":"项目主管审批","STATUSDESC":"项目主管审批","TOTALCOST":"140,820.5000","UDYS":"N","VENDOR":"","XMLB":""}],"showcount":20,"totalpage":31,"totalresult":611}
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
         * resultlist : [{"A_BUDGETDESC":"桥吊委外维修费用-桥吊清洗","A_BUDGETNUM":"2019CB-XL-Q-036","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202008","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"信息中心","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-07-13 11:30:55","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"7-13","ISSUEDATE":"2020-07-13 11:28:42","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":3103,"PRNUM":"PROJ00186","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"已批准","STATUSDESC":"已批准","TOTALCOST":"111.0000","UDYS":"N","VENDOR":"","XMLB":"其他"},{"A_BUDGETDESC":"龙门吊委外维修费用- 液压油更换","A_BUDGETNUM":"2019CB-XL-R-004","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"信息中心","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-07-06 13:36:07","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"测试","ISSUEDATE":"2020-07-03 13:48:06","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":3081,"PRNUM":"PROJ00185","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"应用系统管理主管审批","STATUSDESC":"应用系统管理主管审批","TOTALCOST":"100,000.0000","UDYS":"N","VENDOR":"","XMLB":"技改"},{"A_BUDGETDESC":"龙门吊委外维修费用- 液压油更换","A_BUDGETNUM":"2019CB-XL-R-004","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"信息中心","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-24 16:22:50","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"测试","ISSUEDATE":"2020-06-12 09:08:32","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":3029,"PRNUM":"PROJ00184","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"应用系统管理主管审批","STATUSDESC":"应用系统管理主管审批","TOTALCOST":"100,000.0000","UDYS":"N","VENDOR":"","XMLB":"技改"},{"A_BUDGETDESC":"桥吊委外维修费用-17#桥吊高压电缆卷盘改造","A_BUDGETNUM":"2019CB-XL-Q-043","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"信息中心","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-07-01 09:38:33","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"父子级中预算保持一致测试","ISSUEDATE":"2020-06-12 08:42:31","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":3027,"PRNUM":"PROJ00183","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"应用系统管理主管审批","STATUSDESC":"应用系统管理主管审批","TOTALCOST":"1,333,333.0000","UDYS":"N","VENDOR":"","XMLB":"技改"},{"A_BUDGETDESC":"龙门吊委外维修费用-钢丝绳更换","A_BUDGETNUM":"2019CB-XL-R-001","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"信息中心","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-11 16:29:07","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"cehsi","ISSUEDATE":"2020-06-11 14:11:30","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":3017,"PRNUM":"PROJ00182","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"总经理审批","STATUSDESC":"总经理审批","TOTALCOST":"1,101,110.0000","UDYS":"N","VENDOR":"","XMLB":"技改"},{"A_BUDGETDESC":"桥吊委外维修费用-安川变频器功率单元修理","A_BUDGETNUM":"2019CB-XL-Q-037","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"党群工作部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-09 10:26:27","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"app月度计划流程测试","ISSUEDATE":"2020-06-09 10:08:21","LXLX":"项目月度计划","MEMO":"","ORGID":"10","PRID":3007,"PRNUM":"XM00266","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"部门领导已批准","STATUSDESC":"部门领导已批准","TOTALCOST":"20.0000","UDYS":"N","VENDOR":"","XMLB":"技改"},{"A_BUDGETDESC":"龙门吊委外维修费用-龙门吊油箱清洗","A_BUDGETNUM":"2019CB-XL-R-014","A_COMPANY":"CFS","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"信息中心","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-11 13:16:52","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"APP月度计划流程测试","ISSUEDATE":"2020-06-09 10:05:49","LXLX":"项目月度计划","MEMO":"","ORGID":"10","PRID":3006,"PRNUM":"XM00265","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"等待批准","STATUSDESC":"等待批准","TOTALCOST":"111,111.0000","UDYS":"N","VENDOR":"","XMLB":"技改"},{"A_BUDGETDESC":"桥吊委外维修费用-桥吊清洗","A_BUDGETNUM":"2019CB-XL-Q-036","A_COMPANY":"CFS","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202007","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"安全卫环部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-09 10:05:27","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"app流程测试","ISSUEDATE":"2020-06-08 17:18:09","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":3004,"PRNUM":"PROJ00181","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"已批准","STATUSDESC":"已批准","TOTALCOST":"100,000.0000","UDYS":"N","VENDOR":"","XMLB":"车辆购置"},{"A_BUDGETDESC":"设施委外维修费用-港区测速设备维保","A_BUDGETNUM":"2020CB-XL-S-046","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202005","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"安全卫环部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-05-25 10:18:41","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"测试","ISSUEDATE":"2020-04-20 18:40:42","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":2903,"PRNUM":"PROJ00178","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"申请部门经理审批","STATUSDESC":"申请部门经理审批","TOTALCOST":"20,000.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"流机委外维修费用-堆高机-转向油缸整修","A_BUDGETNUM":"2019CB-XL-L-DG-005-2","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202004","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"安全卫环部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-04-20 17:06:50","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"测试","ISSUEDATE":"2020-03-07 14:41:23","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":2642,"PRNUM":"PROJ00177","REQUESTEDBY":"MAXADMIN","REQUIREDDATE":"","R_DEPTDESC":"系统管理员","R_PRSTATUS":"","SITEID":"1000","STATUS":"部门领导已批准","STATUSDESC":"部门领导已批准","TOTALCOST":"2,000.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"无线终端更新（北三32台）","A_BUDGETNUM":"2020ITZB-BSZD","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202003","A_PRSUMTYPE":"","A_PRTYPE":"PROJECT","A_PURCATALOG":"信息中心","A_PURTYPE":"年度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-02-13 12:21:22","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"无线终端更新采购立项（北三32台）","ISSUEDATE":"2020-02-13 11:58:54","LXLX":"项目立项审批","MEMO":"预计年度更新160台无线终端（北三32台，港吉80台，远东48台），本次立项拟采购32台，详情见附件","ORGID":"10","PRID":2570,"PRNUM":"PROJ00176","REQUESTEDBY":"FENGZHH","REQUIREDDATE":"","R_DEPTDESC":"冯洲豪","R_PRSTATUS":"","SITEID":"1000","STATUS":"项目主管审批","STATUSDESC":"项目主管审批","TOTALCOST":"1,600,000.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"无线终端新增（穿山48台）","A_BUDGETNUM":"2020ITZB-CSZD","A_COMPANY":"穿山","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202003","A_PRSUMTYPE":"","A_PRTYPE":"PROJECT","A_PURCATALOG":"信息中心","A_PURTYPE":"年度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-02-13 12:21:37","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"无线终端新增采购立项（穿山48台）","ISSUEDATE":"2020-02-13 11:55:14","LXLX":"项目立项审批","MEMO":"为配合1号泊位投用，拟采购48台无线终端，详情见附件","ORGID":"10","PRID":2569,"PRNUM":"PROJ00175","REQUESTEDBY":"FENGZHH","REQUIREDDATE":"","R_DEPTDESC":"冯洲豪","R_PRSTATUS":"","SITEID":"1000","STATUS":"项目主管审批","STATUSDESC":"项目主管审批","TOTALCOST":"2,500,000.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"设施委外维修费用","A_BUDGETNUM":"2020CB-XL-S","A_COMPANY":"港吉,意宁","A_CREWID":"设施","A_DEPT":"工程技术部","A_PRKEY":"202003","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-05-25 11:49:52","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"2020年3月设施委外计划（港吉意宁）","ISSUEDATE":"2020-02-03 08:59:08","LXLX":"项目月度计划","MEMO":"","ORGID":"10","PRID":2562,"PRNUM":"XM00263","REQUESTEDBY":"XUP","REQUIREDDATE":"","R_DEPTDESC":"徐鹏","R_PRSTATUS":"","SITEID":"1000","STATUS":"已取消","STATUSDESC":"已取消","TOTALCOST":"12,000.0000","UDYS":"N","VENDOR":"","XMLB":"修理"},{"A_BUDGETDESC":"设施委外维修费用","A_BUDGETNUM":"2020CB-XL-S","A_COMPANY":"北三,远东","A_CREWID":"设施","A_DEPT":"工程技术部","A_PRKEY":"202003","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-08 14:52:32","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"2020年3月设施委外计划（远东北三）","ISSUEDATE":"2020-02-03 08:57:02","LXLX":"项目立项审批","MEMO":"","ORGID":"10","PRID":2561,"PRNUM":"PROJ00180","REQUESTEDBY":"XUP","REQUIREDDATE":"","R_DEPTDESC":"徐鹏","R_PRSTATUS":"","SITEID":"1000","STATUS":"项目主管审批","STATUSDESC":"项目主管审批","TOTALCOST":"1,026,000.0000","UDYS":"N","VENDOR":"","XMLB":"修理"},{"A_BUDGETDESC":"流机委外维修费用-堆高机","A_BUDGETNUM":"2019CB-XL-L-DG","A_COMPANY":"CFS,港吉,远东","A_CREWID":"流机","A_DEPT":"工程技术部","A_PRKEY":"202002","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-01-25 16:11:23","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"2020年2月流机委外计划","ISSUEDATE":"2020-01-22 09:19:09","LXLX":"项目月度计划","MEMO":"","ORGID":"10","PRID":2549,"PRNUM":"XM00261","REQUESTEDBY":"SHAOJ","REQUIREDDATE":"","R_DEPTDESC":"邵军","R_PRSTATUS":"","SITEID":"1000","STATUS":"项目主管审批","STATUSDESC":"项目主管审批","TOTALCOST":"261,509.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"资本性项目","A_BUDGETNUM":"2020CB-ZB","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"营运操作部","A_PRKEY":"202002","A_PRSUMTYPE":"","A_PRTYPE":"PROJECT","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-02-10 15:17:11","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"操作部特种箱班空调申报","ISSUEDATE":"2020-01-21 13:53:09","LXLX":"项目立项审批","MEMO":"西片区放射查验点金蛇公司管理房内空调故障，经工程部检修，已无法修复，需采购更换","ORGID":"10","PRID":2546,"PRNUM":"PROJ00174","REQUESTEDBY":"LIUJ","REQUIREDDATE":"","R_DEPTDESC":"刘君","R_PRSTATUS":"","SITEID":"1000","STATUS":"已批准","STATUSDESC":"已批准","TOTALCOST":"2,800.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"物流分部移动终端项目","A_BUDGETNUM":"2020ITZB-CFS","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"信息中心","A_PRKEY":"202002","A_PRSUMTYPE":"","A_PRTYPE":"PROJECT","A_PURCATALOG":"信息中心","A_PURTYPE":"年度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-06-11 16:23:32","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"物流分部（CFS）生产系统建设三阶段","ISSUEDATE":"2020-01-20 12:23:10","LXLX":"项目立项审批","MEMO":"主要内容：\n1.硬件采购（手机及平板）\n2.配套APP开发及优化，包括手机端和平板端\n3.CFS生产管理系统三阶段开发","ORGID":"10","PRID":2542,"PRNUM":"PROJ00173","REQUESTEDBY":"WANGNY","REQUIREDDATE":"","R_DEPTDESC":"王宁怡","R_PRSTATUS":"","SITEID":"1000","STATUS":"部门领导已批准","STATUSDESC":"部门领导已批准","TOTALCOST":"150,000.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"资本性项目","A_BUDGETNUM":"2020CB-ZB","A_COMPANY":"北三","A_CREWID":"","A_DEPT":"营运操作部","A_PRKEY":"202002","A_PRSUMTYPE":"","A_PRTYPE":"PROJECT","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-01-20 15:49:20","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"操作部特种箱班防爆手机申报","ISSUEDATE":"2020-01-17 14:54:59","LXLX":"项目立项审批","MEMO":"因工作需要，特种箱班需购买2只防爆手机","ORGID":"10","PRID":2536,"PRNUM":"PROJ00172","REQUESTEDBY":"LIUJ","REQUIREDDATE":"","R_DEPTDESC":"刘君","R_PRSTATUS":"","SITEID":"1000","STATUS":"已批准","STATUSDESC":"已批准","TOTALCOST":"14,000.0000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2020CB-XL-R","A_COMPANY":"北三,远东","A_CREWID":"龙门吊","A_DEPT":"工程技术部","A_PRKEY":"202002","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-01-23 08:30:10","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"2020年02月龙门吊委外计划（东区）","ISSUEDATE":"2020-01-16 15:22:53","LXLX":"项目月度计划","MEMO":"","ORGID":"10","PRID":2531,"PRNUM":"XM00260","REQUESTEDBY":"YANGXG","REQUIREDDATE":"","R_DEPTDESC":"杨晓刚","R_PRSTATUS":"","SITEID":"1000","STATUS":"项目主管审批","STATUSDESC":"项目主管审批","TOTALCOST":"128,842.8000","UDYS":"N","VENDOR":"","XMLB":""},{"A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2020CB-XL-R","A_COMPANY":"港吉,意宁","A_CREWID":"龙门吊","A_DEPT":"工程技术部","A_PRKEY":"202002","A_PRSUMTYPE":"","A_PRTYPE":"PROJ","A_PURCATALOG":"工程技术部","A_PURTYPE":"月度","A_SUMNUM":"","A_TOSUM":"N","CHANGEDATE":"2020-01-23 08:30:21","CONTRACTREFNUM":"","CONTRACTREFREV":"","DESCRIPTION":"2020年2月龙门吊委外计划（西区）","ISSUEDATE":"2020-01-16 15:10:20","LXLX":"项目月度计划","MEMO":"","ORGID":"10","PRID":2529,"PRNUM":"XM00259","REQUESTEDBY":"YANGXG","REQUIREDDATE":"","R_DEPTDESC":"杨晓刚","R_PRSTATUS":"","SITEID":"1000","STATUS":"项目主管审批","STATUSDESC":"项目主管审批","TOTALCOST":"140,820.5000","UDYS":"N","VENDOR":"","XMLB":""}]
         * showcount : 20
         * totalpage : 31
         * totalresult : 611
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
             * A_BUDGETDESC : 桥吊委外维修费用-桥吊清洗
             * A_BUDGETNUM : 2019CB-XL-Q-036
             * A_COMPANY : 北三
             * A_CREWID :
             * A_DEPT : 信息中心
             * A_PRKEY : 202008
             * A_PRSUMTYPE :
             * A_PRTYPE : PROJ
             * A_PURCATALOG : 信息中心
             * A_PURTYPE : 月度
             * A_SUMNUM :
             * A_TOSUM : N
             * CHANGEDATE : 2020-07-13 11:30:55
             * CONTRACTREFNUM :
             * CONTRACTREFREV :
             * DESCRIPTION : 7-13
             * ISSUEDATE : 2020-07-13 11:28:42
             * LXLX : 项目立项审批
             * MEMO :
             * ORGID : 10
             * PRID : 3103
             * PRNUM : PROJ00186
             * REQUESTEDBY : MAXADMIN
             * REQUIREDDATE :
             * R_DEPTDESC : 系统管理员
             * R_PRSTATUS :
             * SITEID : 1000
             * STATUS : 已批准
             * STATUSDESC : 已批准
             * TOTALCOST : 111.0000
             * UDYS : N
             * VENDOR :
             * XMLB : 其他
             */

            private String A_BUDGETDESC;
            private String A_BUDGETNUM;
            private String A_COMPANY;
            private String A_CREWID;
            private String A_DEPT;
            private String A_PRKEY;
            private String A_PRSUMTYPE;
            private String A_PRTYPE;
            private String A_PURCATALOG;
            private String A_PURTYPE;
            private String A_SUMNUM;
            private String A_TOSUM;
            private String CHANGEDATE;
            private String CONTRACTREFNUM;
            private String CONTRACTREFREV;
            private String DESCRIPTION;
            private String ISSUEDATE;
            private String LXLX;
            private String MEMO;
            private String ORGID;
            private int PRID;
            private String PRNUM;
            private String REQUESTEDBY;
            private String REQUIREDDATE;
            private String R_DEPTDESC;
            private String R_PRSTATUS;
            private String SITEID;
            private String STATUS;
            private String STATUSDESC;
            private String TOTALCOST;
            private String UDYS;
            private String VENDOR;
            private String XMLB;

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

            public String getA_COMPANY() {
                return A_COMPANY;
            }

            public void setA_COMPANY(String A_COMPANY) {
                this.A_COMPANY = A_COMPANY;
            }

            public String getA_CREWID() {
                return A_CREWID;
            }

            public void setA_CREWID(String A_CREWID) {
                this.A_CREWID = A_CREWID;
            }

            public String getA_DEPT() {
                return A_DEPT;
            }

            public void setA_DEPT(String A_DEPT) {
                this.A_DEPT = A_DEPT;
            }

            public String getA_PRKEY() {
                return A_PRKEY;
            }

            public void setA_PRKEY(String A_PRKEY) {
                this.A_PRKEY = A_PRKEY;
            }

            public String getA_PRSUMTYPE() {
                return A_PRSUMTYPE;
            }

            public void setA_PRSUMTYPE(String A_PRSUMTYPE) {
                this.A_PRSUMTYPE = A_PRSUMTYPE;
            }

            public String getA_PRTYPE() {
                return A_PRTYPE;
            }

            public void setA_PRTYPE(String A_PRTYPE) {
                this.A_PRTYPE = A_PRTYPE;
            }

            public String getA_PURCATALOG() {
                return A_PURCATALOG;
            }

            public void setA_PURCATALOG(String A_PURCATALOG) {
                this.A_PURCATALOG = A_PURCATALOG;
            }

            public String getA_PURTYPE() {
                return A_PURTYPE;
            }

            public void setA_PURTYPE(String A_PURTYPE) {
                this.A_PURTYPE = A_PURTYPE;
            }

            public String getA_SUMNUM() {
                return A_SUMNUM;
            }

            public void setA_SUMNUM(String A_SUMNUM) {
                this.A_SUMNUM = A_SUMNUM;
            }

            public String getA_TOSUM() {
                return A_TOSUM;
            }

            public void setA_TOSUM(String A_TOSUM) {
                this.A_TOSUM = A_TOSUM;
            }

            public String getCHANGEDATE() {
                return CHANGEDATE;
            }

            public void setCHANGEDATE(String CHANGEDATE) {
                this.CHANGEDATE = CHANGEDATE;
            }

            public String getCONTRACTREFNUM() {
                return CONTRACTREFNUM;
            }

            public void setCONTRACTREFNUM(String CONTRACTREFNUM) {
                this.CONTRACTREFNUM = CONTRACTREFNUM;
            }

            public String getCONTRACTREFREV() {
                return CONTRACTREFREV;
            }

            public void setCONTRACTREFREV(String CONTRACTREFREV) {
                this.CONTRACTREFREV = CONTRACTREFREV;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
            }

            public String getISSUEDATE() {
                return ISSUEDATE;
            }

            public void setISSUEDATE(String ISSUEDATE) {
                this.ISSUEDATE = ISSUEDATE;
            }

            public String getLXLX() {
                return LXLX;
            }

            public void setLXLX(String LXLX) {
                this.LXLX = LXLX;
            }

            public String getMEMO() {
                return MEMO;
            }

            public void setMEMO(String MEMO) {
                this.MEMO = MEMO;
            }

            public String getORGID() {
                return ORGID;
            }

            public void setORGID(String ORGID) {
                this.ORGID = ORGID;
            }

            public int getPRID() {
                return PRID;
            }

            public void setPRID(int PRID) {
                this.PRID = PRID;
            }

            public String getPRNUM() {
                return PRNUM;
            }

            public void setPRNUM(String PRNUM) {
                this.PRNUM = PRNUM;
            }

            public String getREQUESTEDBY() {
                return REQUESTEDBY;
            }

            public void setREQUESTEDBY(String REQUESTEDBY) {
                this.REQUESTEDBY = REQUESTEDBY;
            }

            public String getREQUIREDDATE() {
                return REQUIREDDATE;
            }

            public void setREQUIREDDATE(String REQUIREDDATE) {
                this.REQUIREDDATE = REQUIREDDATE;
            }

            public String getR_DEPTDESC() {
                return R_DEPTDESC;
            }

            public void setR_DEPTDESC(String R_DEPTDESC) {
                this.R_DEPTDESC = R_DEPTDESC;
            }

            public String getR_PRSTATUS() {
                return R_PRSTATUS;
            }

            public void setR_PRSTATUS(String R_PRSTATUS) {
                this.R_PRSTATUS = R_PRSTATUS;
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

            public String getSTATUSDESC() {
                return STATUSDESC;
            }

            public void setSTATUSDESC(String STATUSDESC) {
                this.STATUSDESC = STATUSDESC;
            }

            public String getTOTALCOST() {
                return TOTALCOST;
            }

            public void setTOTALCOST(String TOTALCOST) {
                this.TOTALCOST = TOTALCOST;
            }

            public String getUDYS() {
                return UDYS;
            }

            public void setUDYS(String UDYS) {
                this.UDYS = UDYS;
            }

            public String getVENDOR() {
                return VENDOR;
            }

            public void setVENDOR(String VENDOR) {
                this.VENDOR = VENDOR;
            }

            public String getXMLB() {
                return XMLB;
            }

            public void setXMLB(String XMLB) {
                this.XMLB = XMLB;
            }
        }
    }
}
