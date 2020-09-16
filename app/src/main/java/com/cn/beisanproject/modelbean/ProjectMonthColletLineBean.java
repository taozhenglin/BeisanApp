package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class ProjectMonthColletLineBean implements Serializable {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用-其他零星委外维修","A_BUDGETNUM":"2019CB-XL-R-002","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"玉柴发动机漏水修理","ITEMDESC":"","ITEMNUM":"","LINECOST":"9,200.0000","LINETYPE":"服务","LOADEDCOST":"9,200.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"WZ-14259","REMARK":"预计维修1台","REQUESTEDBY":"HUSJ","REQUESTEDBYDESC":"胡巳俊","RFQNUM":"","UNITCOST":"9,200"},{"A_BRAND":"","A_BUDGETDESC":"桥吊委外维修费用","A_BUDGETNUM":"2019CB-XL-Q","A_CREWIDDESC":"桥吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"高压保养","ITEMDESC":"","ITEMNUM":"","LINECOST":"11,000.0000","LINETYPE":"服务","LOADEDCOST":"11,000.0000","ORDERQTY":"22.00000","ORDERUNIT":"台","PRLINENUM":"1","PRNUM":"XM00058","REMARK":"","REQUESTEDBY":"CHENDP","REQUESTEDBYDESC":"陈东平","RFQNUM":"1381","UNITCOST":"500"},{"A_BRAND":"","A_BUDGETDESC":"行政人事部资本、修理","A_BUDGETNUM":"2019CB-ZB-XZ-001","A_CREWIDDESC":"综合管理","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"食堂消费机（5套龙联 IPC XF360）","ITEMDESC":"","ITEMNUM":"","LINECOST":"35,000.0000","LINETYPE":"服务","LOADEDCOST":"35,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"WZ-14266","REMARK":"XM-2584","REQUESTEDBY":"YANZUH","REQUESTEDBYDESC":"严祖红","RFQNUM":"14209","UNITCOST":"35,000"},{"A_BRAND":"","A_BUDGETDESC":"设施委外维修费用","A_BUDGETNUM":"2019CB-XL-S","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"控制楼辅楼大厅洗手处隔断制作","ITEMDESC":"","ITEMNUM":"","LINECOST":"2,000.0000","LINETYPE":"服务","LOADEDCOST":"2,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"WZ-14281","REMARK":"零星制作","REQUESTEDBY":"WENGW","REQUESTEDBYDESC":"翁蔚","RFQNUM":"","UNITCOST":"2,000"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊修理-其它零星（机械）（远东）","A_BUDGETNUM":"2019CB-XL-YD-R-007","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"远东57#电动吊具修复","ITEMDESC":"","ITEMNUM":"","LINECOST":"90,000.0000","LINETYPE":"服务","LOADEDCOST":"90,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"WZ-14284","REMARK":"液压站损坏，需要修复","REQUESTEDBY":"HUSJ","REQUESTEDBYDESC":"胡巳俊","RFQNUM":"1352","UNITCOST":"90,000"},{"A_BRAND":"","A_BUDGETDESC":"设施维修-房屋维修（北三）","A_BUDGETNUM":"2019CB-XL-BS-S-002","A_CREWIDDESC":"综合管理","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"消防楼污水检查井制作","ITEMDESC":"","ITEMNUM":"","LINECOST":"10,000.0000","LINETYPE":"服务","LOADEDCOST":"10,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"WZ-14297","REMARK":"经书面申报流程，领导已批准","REQUESTEDBY":"YANZUH","REQUESTEDBYDESC":"严祖红","RFQNUM":"14261","UNITCOST":"10,000"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"龙门吊整机润滑","ITEMDESC":"龙门吊整机润滑","ITEMNUM":"R18001","LINECOST":"12,938.3500","LINETYPE":"标准服务","LOADEDCOST":"12,938.3500","ORDERQTY":"29.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00004","REMARK":"本月预计润滑29台","REQUESTEDBY":"WUSJ","REQUESTEDBYDESC":"吴士杰","RFQNUM":"","UNITCOST":"446.15"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"2#固定吊动力电缆更换","ITEMDESC":"","ITEMNUM":"","LINECOST":"3,000.0000","LINETYPE":"服务","LOADEDCOST":"3,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00011","REMARK":"","REQUESTEDBY":"XIAOY","REQUESTEDBYDESC":"肖毅","RFQNUM":"","UNITCOST":"3,000"},{"A_BRAND":"","A_BUDGETDESC":"桥吊委外维修费用-桥吊吊具改造","A_BUDGETNUM":"2019CB-XL-Q-027","A_CREWIDDESC":"桥吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"桥吊更换起升钢丝绳（2根一起）","ITEMDESC":"桥吊更换起升钢丝绳（2根一起）","ITEMNUM":"Q18004","LINECOST":"16,000.0000","LINETYPE":"标准服务","LOADEDCOST":"16,000.0000","ORDERQTY":"2.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00012","REMARK":"CR8B19#","REQUESTEDBY":"CHENDP","REQUESTEDBYDESC":"陈东平","RFQNUM":"","UNITCOST":"8,000"},{"A_BRAND":"","A_BUDGETDESC":"设施委外维修费用","A_BUDGETNUM":"2019CB-XL-S","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"分体式空调维保","ITEMDESC":"","ITEMNUM":"","LINECOST":"10,000.0000","LINETYPE":"服务","LOADEDCOST":"10,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00017","REMARK":"根据上月维修情况及本月维修计划预估。","REQUESTEDBY":"XUP","REQUESTEDBYDESC":"徐鹏","RFQNUM":"","UNITCOST":"10,000"},{"A_BRAND":"","A_BUDGETDESC":"设施委外维修费用-房屋维修","A_BUDGETNUM":"2019CB-XL-S-027","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"外墙涂料修补（设施应急）","ITEMDESC":"","ITEMNUM":"","LINECOST":"16,500.0000","LINETYPE":"服务","LOADEDCOST":"16,500.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00022","REMARK":"外墙修补","REQUESTEDBY":"GAOJ","REQUESTEDBYDESC":"高健","RFQNUM":"1272","UNITCOST":"16,500"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"龙门吊起升减速箱维修","ITEMDESC":"","ITEMNUM":"","LINECOST":"99,900.0000","LINETYPE":"服务","LOADEDCOST":"99,900.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00030","REMARK":"","REQUESTEDBY":"HUSJ","REQUESTEDBYDESC":"胡巳俊","RFQNUM":"1273","UNITCOST":"99,900"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"龙门吊整机润滑","ITEMDESC":"龙门吊整机润滑","ITEMNUM":"R18001","LINECOST":"5,799.9500","LINETYPE":"标准服务","LOADEDCOST":"5,799.9500","ORDERQTY":"13.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00031","REMARK":"本月预计润滑13台","REQUESTEDBY":"HUSJ","REQUESTEDBYDESC":"胡巳俊","RFQNUM":"","UNITCOST":"446.15"},{"A_BRAND":"","A_BUDGETDESC":"设施委外维修费用","A_BUDGETNUM":"2019CB-XL-S","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"分体式空调维保（远东）","ITEMDESC":"","ITEMNUM":"","LINECOST":"10,000.0000","LINETYPE":"服务","LOADEDCOST":"10,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00039","REMARK":"根据上月维修情况及本月维修计划预估。","REQUESTEDBY":"XUP","REQUESTEDBYDESC":"徐鹏","RFQNUM":"","UNITCOST":"10,000"},{"A_BRAND":"","A_BUDGETDESC":"3T叉车（北三）","A_BUDGETNUM":"2019CB-ZB-BS-011","A_CREWIDDESC":"流机","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"2#25T叉车转向轮轮毂保养（港吉）","ITEMDESC":"","ITEMNUM":"","LINECOST":"1,900.0000","LINETYPE":"服务","LOADEDCOST":"1,900.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00040","REMARK":"","REQUESTEDBY":"ZHULJ","REQUESTEDBYDESC":"朱琳杰","RFQNUM":"","UNITCOST":"1,900"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"RT21RT22变压器维护保养","ITEMDESC":"","ITEMNUM":"","LINECOST":"8,600.0000","LINETYPE":"服务","LOADEDCOST":"8,600.0000","ORDERQTY":"2.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00041","REMARK":"","REQUESTEDBY":"ZHENGT","REQUESTEDBYDESC":"郑涛","RFQNUM":"1313","UNITCOST":"4,300"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"龙门吊大车海固孔补焊","ITEMDESC":"","ITEMNUM":"","LINECOST":"99,000.0000","LINETYPE":"服务","LOADEDCOST":"99,000.0000","ORDERQTY":"33.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"WZ-14262","REMARK":"技术要求见长描述","REQUESTEDBY":"HUSJ","REQUESTEDBYDESC":"胡巳俊","RFQNUM":"14211","UNITCOST":"3,000"},{"A_BRAND":"","A_BUDGETDESC":"行政人事部资本、修理","A_BUDGETNUM":"2019CB-ZB-XZ-001","A_CREWIDDESC":"综合管理","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"食堂脱皮机（恒联PP30）","ITEMDESC":"","ITEMNUM":"","LINECOST":"5,500.0000","LINETYPE":"服务","LOADEDCOST":"5,500.0000","ORDERQTY":"2.00000","ORDERUNIT":"","PRLINENUM":"2","PRNUM":"WZ-14266","REMARK":"XM-2596","REQUESTEDBY":"YANZUH","REQUESTEDBYDESC":"严祖红","RFQNUM":"14210","UNITCOST":"2,750"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"龙门吊起升钢丝绳更换","ITEMDESC":"龙门吊起升钢丝绳更换","ITEMNUM":"R18004","LINECOST":"30,933.2400","LINETYPE":"标准服务","LOADEDCOST":"30,933.2400","ORDERQTY":"52.00000","ORDERUNIT":"","PRLINENUM":"2","PRNUM":"XM00004","REMARK":"本月预计更换52根","REQUESTEDBY":"WUSJ","REQUESTEDBYDESC":"吴士杰","RFQNUM":"","UNITCOST":"594.87"},{"A_BRAND":"","A_BUDGETDESC":"桥吊委外维修费用-桥吊吊具改造","A_BUDGETNUM":"2019CB-XL-Q-027","A_CREWIDDESC":"桥吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"更换小车钢丝绳","ITEMDESC":"更换小车钢丝绳","ITEMNUM":"Q18005","LINECOST":"3,700.0000","LINETYPE":"标准服务","LOADEDCOST":"3,700.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"2","PRNUM":"XM00012","REMARK":"CR8A","REQUESTEDBY":"CHENDP","REQUESTEDBYDESC":"陈东平","RFQNUM":"","UNITCOST":"3,700"}],"showcount":20,"totalpage":8,"totalresult":146}
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
         * resultlist : [{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用-其他零星委外维修","A_BUDGETNUM":"2019CB-XL-R-002","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"玉柴发动机漏水修理","ITEMDESC":"","ITEMNUM":"","LINECOST":"9,200.0000","LINETYPE":"服务","LOADEDCOST":"9,200.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"WZ-14259","REMARK":"预计维修1台","REQUESTEDBY":"HUSJ","REQUESTEDBYDESC":"胡巳俊","RFQNUM":"","UNITCOST":"9,200"},{"A_BRAND":"","A_BUDGETDESC":"桥吊委外维修费用","A_BUDGETNUM":"2019CB-XL-Q","A_CREWIDDESC":"桥吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"高压保养","ITEMDESC":"","ITEMNUM":"","LINECOST":"11,000.0000","LINETYPE":"服务","LOADEDCOST":"11,000.0000","ORDERQTY":"22.00000","ORDERUNIT":"台","PRLINENUM":"1","PRNUM":"XM00058","REMARK":"","REQUESTEDBY":"CHENDP","REQUESTEDBYDESC":"陈东平","RFQNUM":"1381","UNITCOST":"500"},{"A_BRAND":"","A_BUDGETDESC":"行政人事部资本、修理","A_BUDGETNUM":"2019CB-ZB-XZ-001","A_CREWIDDESC":"综合管理","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"食堂消费机（5套龙联 IPC XF360）","ITEMDESC":"","ITEMNUM":"","LINECOST":"35,000.0000","LINETYPE":"服务","LOADEDCOST":"35,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"WZ-14266","REMARK":"XM-2584","REQUESTEDBY":"YANZUH","REQUESTEDBYDESC":"严祖红","RFQNUM":"14209","UNITCOST":"35,000"},{"A_BRAND":"","A_BUDGETDESC":"设施委外维修费用","A_BUDGETNUM":"2019CB-XL-S","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"控制楼辅楼大厅洗手处隔断制作","ITEMDESC":"","ITEMNUM":"","LINECOST":"2,000.0000","LINETYPE":"服务","LOADEDCOST":"2,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"WZ-14281","REMARK":"零星制作","REQUESTEDBY":"WENGW","REQUESTEDBYDESC":"翁蔚","RFQNUM":"","UNITCOST":"2,000"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊修理-其它零星（机械）（远东）","A_BUDGETNUM":"2019CB-XL-YD-R-007","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"远东57#电动吊具修复","ITEMDESC":"","ITEMNUM":"","LINECOST":"90,000.0000","LINETYPE":"服务","LOADEDCOST":"90,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"WZ-14284","REMARK":"液压站损坏，需要修复","REQUESTEDBY":"HUSJ","REQUESTEDBYDESC":"胡巳俊","RFQNUM":"1352","UNITCOST":"90,000"},{"A_BRAND":"","A_BUDGETDESC":"设施维修-房屋维修（北三）","A_BUDGETNUM":"2019CB-XL-BS-S-002","A_CREWIDDESC":"综合管理","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"消防楼污水检查井制作","ITEMDESC":"","ITEMNUM":"","LINECOST":"10,000.0000","LINETYPE":"服务","LOADEDCOST":"10,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"WZ-14297","REMARK":"经书面申报流程，领导已批准","REQUESTEDBY":"YANZUH","REQUESTEDBYDESC":"严祖红","RFQNUM":"14261","UNITCOST":"10,000"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"龙门吊整机润滑","ITEMDESC":"龙门吊整机润滑","ITEMNUM":"R18001","LINECOST":"12,938.3500","LINETYPE":"标准服务","LOADEDCOST":"12,938.3500","ORDERQTY":"29.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00004","REMARK":"本月预计润滑29台","REQUESTEDBY":"WUSJ","REQUESTEDBYDESC":"吴士杰","RFQNUM":"","UNITCOST":"446.15"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"2#固定吊动力电缆更换","ITEMDESC":"","ITEMNUM":"","LINECOST":"3,000.0000","LINETYPE":"服务","LOADEDCOST":"3,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00011","REMARK":"","REQUESTEDBY":"XIAOY","REQUESTEDBYDESC":"肖毅","RFQNUM":"","UNITCOST":"3,000"},{"A_BRAND":"","A_BUDGETDESC":"桥吊委外维修费用-桥吊吊具改造","A_BUDGETNUM":"2019CB-XL-Q-027","A_CREWIDDESC":"桥吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"桥吊更换起升钢丝绳（2根一起）","ITEMDESC":"桥吊更换起升钢丝绳（2根一起）","ITEMNUM":"Q18004","LINECOST":"16,000.0000","LINETYPE":"标准服务","LOADEDCOST":"16,000.0000","ORDERQTY":"2.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00012","REMARK":"CR8B19#","REQUESTEDBY":"CHENDP","REQUESTEDBYDESC":"陈东平","RFQNUM":"","UNITCOST":"8,000"},{"A_BRAND":"","A_BUDGETDESC":"设施委外维修费用","A_BUDGETNUM":"2019CB-XL-S","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"分体式空调维保","ITEMDESC":"","ITEMNUM":"","LINECOST":"10,000.0000","LINETYPE":"服务","LOADEDCOST":"10,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00017","REMARK":"根据上月维修情况及本月维修计划预估。","REQUESTEDBY":"XUP","REQUESTEDBYDESC":"徐鹏","RFQNUM":"","UNITCOST":"10,000"},{"A_BRAND":"","A_BUDGETDESC":"设施委外维修费用-房屋维修","A_BUDGETNUM":"2019CB-XL-S-027","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"外墙涂料修补（设施应急）","ITEMDESC":"","ITEMNUM":"","LINECOST":"16,500.0000","LINETYPE":"服务","LOADEDCOST":"16,500.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00022","REMARK":"外墙修补","REQUESTEDBY":"GAOJ","REQUESTEDBYDESC":"高健","RFQNUM":"1272","UNITCOST":"16,500"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"龙门吊起升减速箱维修","ITEMDESC":"","ITEMNUM":"","LINECOST":"99,900.0000","LINETYPE":"服务","LOADEDCOST":"99,900.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00030","REMARK":"","REQUESTEDBY":"HUSJ","REQUESTEDBYDESC":"胡巳俊","RFQNUM":"1273","UNITCOST":"99,900"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"龙门吊整机润滑","ITEMDESC":"龙门吊整机润滑","ITEMNUM":"R18001","LINECOST":"5,799.9500","LINETYPE":"标准服务","LOADEDCOST":"5,799.9500","ORDERQTY":"13.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00031","REMARK":"本月预计润滑13台","REQUESTEDBY":"HUSJ","REQUESTEDBYDESC":"胡巳俊","RFQNUM":"","UNITCOST":"446.15"},{"A_BRAND":"","A_BUDGETDESC":"设施委外维修费用","A_BUDGETNUM":"2019CB-XL-S","A_CREWIDDESC":"设施","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"分体式空调维保（远东）","ITEMDESC":"","ITEMNUM":"","LINECOST":"10,000.0000","LINETYPE":"服务","LOADEDCOST":"10,000.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00039","REMARK":"根据上月维修情况及本月维修计划预估。","REQUESTEDBY":"XUP","REQUESTEDBYDESC":"徐鹏","RFQNUM":"","UNITCOST":"10,000"},{"A_BRAND":"","A_BUDGETDESC":"3T叉车（北三）","A_BUDGETNUM":"2019CB-ZB-BS-011","A_CREWIDDESC":"流机","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"2#25T叉车转向轮轮毂保养（港吉）","ITEMDESC":"","ITEMNUM":"","LINECOST":"1,900.0000","LINETYPE":"服务","LOADEDCOST":"1,900.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00040","REMARK":"","REQUESTEDBY":"ZHULJ","REQUESTEDBYDESC":"朱琳杰","RFQNUM":"","UNITCOST":"1,900"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"RT21RT22变压器维护保养","ITEMDESC":"","ITEMNUM":"","LINECOST":"8,600.0000","LINETYPE":"服务","LOADEDCOST":"8,600.0000","ORDERQTY":"2.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"XM00041","REMARK":"","REQUESTEDBY":"ZHENGT","REQUESTEDBYDESC":"郑涛","RFQNUM":"1313","UNITCOST":"4,300"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"龙门吊大车海固孔补焊","ITEMDESC":"","ITEMNUM":"","LINECOST":"99,000.0000","LINETYPE":"服务","LOADEDCOST":"99,000.0000","ORDERQTY":"33.00000","ORDERUNIT":"","PRLINENUM":"1","PRNUM":"WZ-14262","REMARK":"技术要求见长描述","REQUESTEDBY":"HUSJ","REQUESTEDBYDESC":"胡巳俊","RFQNUM":"14211","UNITCOST":"3,000"},{"A_BRAND":"","A_BUDGETDESC":"行政人事部资本、修理","A_BUDGETNUM":"2019CB-ZB-XZ-001","A_CREWIDDESC":"综合管理","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"食堂脱皮机（恒联PP30）","ITEMDESC":"","ITEMNUM":"","LINECOST":"5,500.0000","LINETYPE":"服务","LOADEDCOST":"5,500.0000","ORDERQTY":"2.00000","ORDERUNIT":"","PRLINENUM":"2","PRNUM":"WZ-14266","REMARK":"XM-2596","REQUESTEDBY":"YANZUH","REQUESTEDBYDESC":"严祖红","RFQNUM":"14210","UNITCOST":"2,750"},{"A_BRAND":"","A_BUDGETDESC":"龙门吊委外维修费用","A_BUDGETNUM":"2019CB-XL-R","A_CREWIDDESC":"龙门吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"龙门吊起升钢丝绳更换","ITEMDESC":"龙门吊起升钢丝绳更换","ITEMNUM":"R18004","LINECOST":"30,933.2400","LINETYPE":"标准服务","LOADEDCOST":"30,933.2400","ORDERQTY":"52.00000","ORDERUNIT":"","PRLINENUM":"2","PRNUM":"XM00004","REMARK":"本月预计更换52根","REQUESTEDBY":"WUSJ","REQUESTEDBYDESC":"吴士杰","RFQNUM":"","UNITCOST":"594.87"},{"A_BRAND":"","A_BUDGETDESC":"桥吊委外维修费用-桥吊吊具改造","A_BUDGETNUM":"2019CB-XL-Q-027","A_CREWIDDESC":"桥吊","A_DEPTDESC":"工程技术部","A_MODEL":"","A_PURTYPE":"月度","DESCRIPTION":"更换小车钢丝绳","ITEMDESC":"更换小车钢丝绳","ITEMNUM":"Q18005","LINECOST":"3,700.0000","LINETYPE":"标准服务","LOADEDCOST":"3,700.0000","ORDERQTY":"1.00000","ORDERUNIT":"","PRLINENUM":"2","PRNUM":"XM00012","REMARK":"CR8A","REQUESTEDBY":"CHENDP","REQUESTEDBYDESC":"陈东平","RFQNUM":"","UNITCOST":"3,700"}]
         * showcount : 20
         * totalpage : 8
         * totalresult : 146
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
             * A_BRAND :
             * A_BUDGETDESC : 龙门吊委外维修费用-其他零星委外维修
             * A_BUDGETNUM : 2019CB-XL-R-002
             * A_CREWIDDESC : 龙门吊
             * A_DEPTDESC : 工程技术部
             * A_MODEL :
             * A_PURTYPE : 月度
             * DESCRIPTION : 玉柴发动机漏水修理
             * ITEMDESC :
             * ITEMNUM :
             * LINECOST : 9,200.0000
             * LINETYPE : 服务
             * LOADEDCOST : 9,200.0000
             * ORDERQTY : 1.00000
             * ORDERUNIT :
             * PRLINENUM : 1
             * PRNUM : WZ-14259
             * REMARK : 预计维修1台
             * REQUESTEDBY : HUSJ
             * REQUESTEDBYDESC : 胡巳俊
             * RFQNUM :
             * UNITCOST : 9,200
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
