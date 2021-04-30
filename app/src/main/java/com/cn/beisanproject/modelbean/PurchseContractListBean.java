package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class PurchseContractListBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ10022","CONTRACTID":9018,"CONTRACTNUM":"3156","DESCRIPTION":"ceshi","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"Y","HTJF":"北三","HTYF":"千万人","JFQZDB":"信息中心","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-07-16","STATUS":"工程部物资主管审批","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"C574008016","VENDORDESC":"北仑区质检局","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"穿山","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ10023","CONTRACTID":9019,"CONTRACTNUM":"3157","DESCRIPTION":"ceshi","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"Y","HTJF":"穿山","HTYF":"人的共同","JFQZDB":"信息中心","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-07-16","STATUS":"工程部物资主管审批","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13076","VENDORDESC":"宁波高新区日明消防科技有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"通勤班吸烟区安装移门","A_RFQNUM":"1182","CONTNUM":"GCWZ","CONTRACTID":9000,"CONTRACTNUM":"3154","DESCRIPTION":"ceshi","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"gr","JFQZDB":"工程技术部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-07-14","STATUS":"草稿","TOTALBASECOST":"1,110.00","TOTALCOST":"1,110.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13073","VENDORDESC":"宁波巨神制泵实业有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ1001","CONTRACTID":9001,"CONTRACTNUM":"3155","DESCRIPTION":"采购合同待办测试","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"Y","HTJF":"北三","HTYF":"宁波","JFQZDB":"信息中心","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-07-14","STATUS":"工程部物资主管审批","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK11024","VENDORDESC":"浙江双羊集团有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ3117","CONTRACTID":8934,"CONTRACTNUM":"3145","DESCRIPTION":"明细","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"3117","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-30","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13072","VENDORDESC":"江山伟懋制泵有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"GCWZ111","CONTRACTID":8936,"CONTRACTNUM":"3147","DESCRIPTION":"测试","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"1","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-30","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13073","VENDORDESC":"宁波巨神制泵实业有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"GCWZ11131231","CONTRACTID":8921,"CONTRACTNUM":"3132","DESCRIPTION":"测试","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"1","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13073","VENDORDESC":"宁波巨神制泵实业有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"111111","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"11111","CONTRACTID":8923,"CONTRACTNUM":"3134","DESCRIPTION":"1111","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"1111","HTYF":"1111","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GC018042","VENDORDESC":"宁波市中瑞工程造价咨询有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ3117","CONTRACTID":8931,"CONTRACTNUM":"3142","DESCRIPTION":"3117","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"3117","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"已批准","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13072","VENDORDESC":"江山伟懋制泵有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ3117","CONTRACTID":8918,"CONTRACTNUM":"3129","DESCRIPTION":"3117","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"3117","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13072","VENDORDESC":"江山伟懋制泵有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"111111","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"11111","CONTRACTID":8925,"CONTRACTNUM":"3136","DESCRIPTION":"1111","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"1111","HTYF":"1111","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GC018042","VENDORDESC":"宁波市中瑞工程造价咨询有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"11111","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"1111111","CONTRACTID":8926,"CONTRACTNUM":"3137","DESCRIPTION":"测试","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"11111","HTYF":"11111","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK11023","VENDORDESC":"宁波俊诚管业有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"1122","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"1111111","CONTRACTID":8932,"CONTRACTNUM":"3143","DESCRIPTION":"1111111","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"1122","HTYF":"1111","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13076","VENDORDESC":"宁波高新区日明消防科技有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"1122","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"1111111","CONTRACTID":8933,"CONTRACTNUM":"3144","DESCRIPTION":"1111111","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"1122","HTYF":"1111","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13076","VENDORDESC":"宁波高新区日明消防科技有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"GCWZ1113","CONTRACTID":8915,"CONTRACTNUM":"3126","DESCRIPTION":"测试","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"1","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13073","VENDORDESC":"宁波巨神制泵实业有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ3117","CONTRACTID":8906,"CONTRACTNUM":"3117","DESCRIPTION":"3117","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"3117","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13072","VENDORDESC":"江山伟懋制泵有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"港吉","A_DEPT":"工程技术部","A_RFQDESC":"1月份龙门吊五金采购","A_RFQNUM":"2452","CONTNUM":"GCWZ20200121","CONTRACTID":8919,"CONTRACTNUM":"3130","DESCRIPTION":"1月份龙门吊五金采购","ENDDATE":"","ENTERBY":"MAOYN","ENTERBYDESC":"茅妍娜","HASINSURANCE":"N","HTJF":"港吉","HTYF":"宁波经济技术开发区繁润机电物资有限公司","JFQZDB":"工程技术部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"9,383.67","TOTALCOST":"10,603.52","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"W574A029","VENDORDESC":"宁波经济技术开发区繁润机电物资有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"1","A_DEPT":"工程技术部","A_RFQDESC":"1月份CFS正面吊机械配件采购","A_RFQNUM":"2489","CONTNUM":"GCWZ11111111","CONTRACTID":8769,"CONTRACTNUM":"3041","DESCRIPTION":"1月份CFS正面吊机械配件采购","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"1","HTYF":"1","JFQZDB":"党群工作部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-03","STATUS":"草稿","TOTALBASECOST":"12,224.78","TOTALCOST":"13,814.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK12971","VENDORDESC":"宁波富耀港口机械设备有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"GCWZ1212121","CONTRACTID":8640,"CONTRACTNUM":"3016","DESCRIPTION":"测试","ENDDATE":"2020-05-22","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"12121221","JFQZDB":"党群工作部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-05-06","STATUS":"财务经理审批","TOTALBASECOST":"10,000.00","TOTALCOST":"10,000.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK11020","VENDORDESC":"上海宝闽钢铁集团有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"GCWZ1111","CONTRACTID":8539,"CONTRACTNUM":"3011","DESCRIPTION":"4-2","ENDDATE":"2020-04-30","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"Y","HTJF":"北三","HTYF":"TEST","JFQZDB":"信息中心","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-04-02","STATUS":"已批准","TOTALBASECOST":"99.00","TOTALCOST":"99.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK11056","VENDORDESC":"建湖县鑫盛土工合成材料有限公司","ZBJ":""}],"showcount":20,"totalpage":54,"totalresult":1063}
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

    public static class ResultBean implements Serializable{
        /**
         * curpage : 1
         * resultlist : [{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ10022","CONTRACTID":9018,"CONTRACTNUM":"3156","DESCRIPTION":"ceshi","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"Y","HTJF":"北三","HTYF":"千万人","JFQZDB":"信息中心","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-07-16","STATUS":"工程部物资主管审批","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"C574008016","VENDORDESC":"北仑区质检局","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"穿山","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ10023","CONTRACTID":9019,"CONTRACTNUM":"3157","DESCRIPTION":"ceshi","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"Y","HTJF":"穿山","HTYF":"人的共同","JFQZDB":"信息中心","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-07-16","STATUS":"工程部物资主管审批","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13076","VENDORDESC":"宁波高新区日明消防科技有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"通勤班吸烟区安装移门","A_RFQNUM":"1182","CONTNUM":"GCWZ","CONTRACTID":9000,"CONTRACTNUM":"3154","DESCRIPTION":"ceshi","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"gr","JFQZDB":"工程技术部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-07-14","STATUS":"草稿","TOTALBASECOST":"1,110.00","TOTALCOST":"1,110.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13073","VENDORDESC":"宁波巨神制泵实业有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ1001","CONTRACTID":9001,"CONTRACTNUM":"3155","DESCRIPTION":"采购合同待办测试","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"Y","HTJF":"北三","HTYF":"宁波","JFQZDB":"信息中心","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-07-14","STATUS":"工程部物资主管审批","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK11024","VENDORDESC":"浙江双羊集团有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ3117","CONTRACTID":8934,"CONTRACTNUM":"3145","DESCRIPTION":"明细","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"3117","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-30","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13072","VENDORDESC":"江山伟懋制泵有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"GCWZ111","CONTRACTID":8936,"CONTRACTNUM":"3147","DESCRIPTION":"测试","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"1","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-30","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13073","VENDORDESC":"宁波巨神制泵实业有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"GCWZ11131231","CONTRACTID":8921,"CONTRACTNUM":"3132","DESCRIPTION":"测试","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"1","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13073","VENDORDESC":"宁波巨神制泵实业有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"111111","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"11111","CONTRACTID":8923,"CONTRACTNUM":"3134","DESCRIPTION":"1111","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"1111","HTYF":"1111","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GC018042","VENDORDESC":"宁波市中瑞工程造价咨询有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ3117","CONTRACTID":8931,"CONTRACTNUM":"3142","DESCRIPTION":"3117","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"3117","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"已批准","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13072","VENDORDESC":"江山伟懋制泵有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ3117","CONTRACTID":8918,"CONTRACTNUM":"3129","DESCRIPTION":"3117","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"3117","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13072","VENDORDESC":"江山伟懋制泵有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"111111","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"11111","CONTRACTID":8925,"CONTRACTNUM":"3136","DESCRIPTION":"1111","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"1111","HTYF":"1111","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GC018042","VENDORDESC":"宁波市中瑞工程造价咨询有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"11111","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"1111111","CONTRACTID":8926,"CONTRACTNUM":"3137","DESCRIPTION":"测试","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"11111","HTYF":"11111","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK11023","VENDORDESC":"宁波俊诚管业有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"1122","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"1111111","CONTRACTID":8932,"CONTRACTNUM":"3143","DESCRIPTION":"1111111","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"1122","HTYF":"1111","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13076","VENDORDESC":"宁波高新区日明消防科技有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"1122","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"1111111","CONTRACTID":8933,"CONTRACTNUM":"3144","DESCRIPTION":"1111111","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"1122","HTYF":"1111","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13076","VENDORDESC":"宁波高新区日明消防科技有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"GCWZ1113","CONTRACTID":8915,"CONTRACTNUM":"3126","DESCRIPTION":"测试","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"1","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13073","VENDORDESC":"宁波巨神制泵实业有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"ITWZ3117","CONTRACTID":8906,"CONTRACTNUM":"3117","DESCRIPTION":"3117","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"3117","JFQZDB":"安全卫环部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"0.00","TOTALCOST":"0.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK13072","VENDORDESC":"江山伟懋制泵有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"港吉","A_DEPT":"工程技术部","A_RFQDESC":"1月份龙门吊五金采购","A_RFQNUM":"2452","CONTNUM":"GCWZ20200121","CONTRACTID":8919,"CONTRACTNUM":"3130","DESCRIPTION":"1月份龙门吊五金采购","ENDDATE":"","ENTERBY":"MAOYN","ENTERBYDESC":"茅妍娜","HASINSURANCE":"N","HTJF":"港吉","HTYF":"宁波经济技术开发区繁润机电物资有限公司","JFQZDB":"工程技术部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-29","STATUS":"草稿","TOTALBASECOST":"9,383.67","TOTALCOST":"10,603.52","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"W574A029","VENDORDESC":"宁波经济技术开发区繁润机电物资有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"1","A_DEPT":"工程技术部","A_RFQDESC":"1月份CFS正面吊机械配件采购","A_RFQNUM":"2489","CONTNUM":"GCWZ11111111","CONTRACTID":8769,"CONTRACTNUM":"3041","DESCRIPTION":"1月份CFS正面吊机械配件采购","ENDDATE":"","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"1","HTYF":"1","JFQZDB":"党群工作部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-06-03","STATUS":"草稿","TOTALBASECOST":"12,224.78","TOTALCOST":"13,814.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK12971","VENDORDESC":"宁波富耀港口机械设备有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"GCWZ1212121","CONTRACTID":8640,"CONTRACTNUM":"3016","DESCRIPTION":"测试","ENDDATE":"2020-05-22","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"N","HTJF":"北三","HTYF":"12121221","JFQZDB":"党群工作部","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-05-06","STATUS":"财务经理审批","TOTALBASECOST":"10,000.00","TOTALCOST":"10,000.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK11020","VENDORDESC":"上海宝闽钢铁集团有限公司","ZBJ":""},{"A_BUDGETDESC":"","A_BUDGETNUM":"","A_COMP":"北三","A_DEPT":"信息中心","A_RFQDESC":"","A_RFQNUM":"","CONTNUM":"GCWZ1111","CONTRACTID":8539,"CONTRACTNUM":"3011","DESCRIPTION":"4-2","ENDDATE":"2020-04-30","ENTERBY":"","ENTERBYDESC":"","HASINSURANCE":"Y","HTJF":"北三","HTYF":"TEST","JFQZDB":"信息中心","J_CONTRACTDATE":"","LB":"采购合同","ORGID":"10","REVISIONNUM":"0","STARTDATE":"2020-04-02","STATUS":"已批准","TOTALBASECOST":"99.00","TOTALCOST":"99.00","UDHTFL":"","UDHTLX":"","UDZBDQR":"","VENDOR":"GK11056","VENDORDESC":"建湖县鑫盛土工合成材料有限公司","ZBJ":""}]
         * showcount : 20
         * totalpage : 54
         * totalresult : 1063
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
             * A_BUDGETDESC :
             * A_BUDGETNUM :
             * A_COMP : 北三
             * A_DEPT : 信息中心
             * A_RFQDESC :
             * A_RFQNUM :
             * CONTNUM : ITWZ10022
             * CONTRACTID : 9018
             * CONTRACTNUM : 3156
             * DESCRIPTION : ceshi
             * ENDDATE :
             * ENTERBY :
             * ENTERBYDESC :
             * HASINSURANCE : Y
             * HTJF : 北三
             * HTYF : 千万人
             * JFQZDB : 信息中心
             * J_CONTRACTDATE :
             * LB : 采购合同
             * ORGID : 10
             * REVISIONNUM : 0
             * STARTDATE : 2020-07-16
             * STATUS : 工程部物资主管审批
             * TOTALBASECOST : 0.00
             * TOTALCOST : 0.00
             * UDHTFL :
             * UDHTLX :
             * UDZBDQR :
             * VENDOR : C574008016
             * VENDORDESC : 北仑区质检局
             * ZBJ :
             */

            private String A_BUDGETDESC;
            private String A_BUDGETNUM;
            private String A_COMP;
            private String A_DEPT;
            private String A_RFQDESC;
            private String A_RFQNUM;
            private String CONTNUM;
            private int CONTRACTID;
            private String CONTRACTNUM;
            private String DESCRIPTION;
            private String ENDDATE;
            private String ENTERBY;
            private String ENTERBYDESC;
            private String HASINSURANCE;
            private String HTJF;
            private String HTYF;
            private String JFQZDB;
            private String J_CONTRACTDATE;
            private String LB;
            private String ORGID;
            private String REVISIONNUM;
            private String STARTDATE;
            private String STATUS;
            private String TOTALBASECOST;
            private String TOTALCOST;
            private String UDHTFL;
            private String UDHTLX;
            private String UDZBDQR;
            private String VENDOR;
            private String VENDORDESC;
            private String ZBJ;

            public String getUDHTLY() {
                return UDHTLY;
            }

            public void setUDHTLY(String UDHTLY) {
                this.UDHTLY = UDHTLY;
            }

            String UDHTLY;
            public String getQIANMING() {
                return QIANMING;
            }

            public void setQIANMING(String QIANMING) {
                this.QIANMING = QIANMING;
            }

            private String QIANMING;

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

            public String getA_COMP() {
                return A_COMP;
            }

            public void setA_COMP(String A_COMP) {
                this.A_COMP = A_COMP;
            }

            public String getA_DEPT() {
                return A_DEPT;
            }

            public void setA_DEPT(String A_DEPT) {
                this.A_DEPT = A_DEPT;
            }

            public String getA_RFQDESC() {
                return A_RFQDESC;
            }

            public void setA_RFQDESC(String A_RFQDESC) {
                this.A_RFQDESC = A_RFQDESC;
            }

            public String getA_RFQNUM() {
                return A_RFQNUM;
            }

            public void setA_RFQNUM(String A_RFQNUM) {
                this.A_RFQNUM = A_RFQNUM;
            }

            public String getCONTNUM() {
                return CONTNUM;
            }

            public void setCONTNUM(String CONTNUM) {
                this.CONTNUM = CONTNUM;
            }

            public int getCONTRACTID() {
                return CONTRACTID;
            }

            public void setCONTRACTID(int CONTRACTID) {
                this.CONTRACTID = CONTRACTID;
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

            public String getENDDATE() {
                return ENDDATE;
            }

            public void setENDDATE(String ENDDATE) {
                this.ENDDATE = ENDDATE;
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

            public String getHASINSURANCE() {
                return HASINSURANCE;
            }

            public void setHASINSURANCE(String HASINSURANCE) {
                this.HASINSURANCE = HASINSURANCE;
            }

            public String getHTJF() {
                return HTJF;
            }

            public void setHTJF(String HTJF) {
                this.HTJF = HTJF;
            }

            public String getHTYF() {
                return HTYF;
            }

            public void setHTYF(String HTYF) {
                this.HTYF = HTYF;
            }

            public String getJFQZDB() {
                return JFQZDB;
            }

            public void setJFQZDB(String JFQZDB) {
                this.JFQZDB = JFQZDB;
            }

            public String getJ_CONTRACTDATE() {
                return J_CONTRACTDATE;
            }

            public void setJ_CONTRACTDATE(String J_CONTRACTDATE) {
                this.J_CONTRACTDATE = J_CONTRACTDATE;
            }

            public String getLB() {
                return LB;
            }

            public void setLB(String LB) {
                this.LB = LB;
            }

            public String getORGID() {
                return ORGID;
            }

            public void setORGID(String ORGID) {
                this.ORGID = ORGID;
            }

            public String getREVISIONNUM() {
                return REVISIONNUM;
            }

            public void setREVISIONNUM(String REVISIONNUM) {
                this.REVISIONNUM = REVISIONNUM;
            }

            public String getSTARTDATE() {
                return STARTDATE;
            }

            public void setSTARTDATE(String STARTDATE) {
                this.STARTDATE = STARTDATE;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getTOTALBASECOST() {
                return TOTALBASECOST;
            }

            public void setTOTALBASECOST(String TOTALBASECOST) {
                this.TOTALBASECOST = TOTALBASECOST;
            }

            public String getTOTALCOST() {
                return TOTALCOST;
            }

            public void setTOTALCOST(String TOTALCOST) {
                this.TOTALCOST = TOTALCOST;
            }

            public String getUDHTFL() {
                return UDHTFL;
            }

            public void setUDHTFL(String UDHTFL) {
                this.UDHTFL = UDHTFL;
            }

            public String getUDHTLX() {
                return UDHTLX;
            }

            public void setUDHTLX(String UDHTLX) {
                this.UDHTLX = UDHTLX;
            }

            public String getUDZBDQR() {
                return UDZBDQR;
            }

            public void setUDZBDQR(String UDZBDQR) {
                this.UDZBDQR = UDZBDQR;
            }

            public String getVENDOR() {
                return VENDOR;
            }

            public void setVENDOR(String VENDOR) {
                this.VENDOR = VENDOR;
            }

            public String getVENDORDESC() {
                return VENDORDESC;
            }

            public void setVENDORDESC(String VENDORDESC) {
                this.VENDORDESC = VENDORDESC;
            }

            public String getZBJ() {
                return ZBJ;
            }

            public void setZBJ(String ZBJ) {
                this.ZBJ = ZBJ;
            }
        }
    }
}
