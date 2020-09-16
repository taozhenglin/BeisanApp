package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

import javax.net.ssl.SSLEngineResult;

public class PurchaseEnquiryListBean implements Serializable {


    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"信息中心","CYHJJE":"-666.0000","DESCRIPTION":"7-13","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":16050,"RFQNUM":"2567","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"安全卫环部","CYHJJE":"0.0000","DESCRIPTION":"app流程测试多已发送","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15970,"RFQNUM":"2520","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"安全卫环部","CYHJJE":"0.0000","DESCRIPTION":"app流程测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15969,"RFQNUM":"2519","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"党群工作部","CYHJJE":"0.0000","DESCRIPTION":"app流程测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15968,"RFQNUM":"2518","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"党群工作部","CYHJJE":"0.0000","DESCRIPTION":"app流程测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15958,"RFQNUM":"2517","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"信息中心","CYHJJE":"0.0000","DESCRIPTION":"测试选择的物资行状态为\u201c汇总已批准\u201d","ENTERBY":"XIAXF","ENTERBYDESC":"夏晓峰","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15848,"RFQNUM":"2503","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"进行中"},{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"工程技术部","CYHJJE":"0.0000","DESCRIPTION":"杨鑫测试询价单0225","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15790,"RFQNUM":"2499","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"经比价，宁波东方电缆股份有限公司报价最低，\n授予价9540元。\n妥否？请领导批示。","A_PURCATALOG":"工程技术部","CYHJJE":"9,540.0000","DESCRIPTION":"1月份电缆采购","ENTERBY":"MAOYN","ENTERBYDESC":"茅妍娜","HJJE":"31,900.0000","JHCOST":"8,442.4700","RFQ3":"","RFQ3DESC":"","RFQID":15769,"RFQNUM":"2493","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"一共9项经过比价其中南港1项，祺衫7项，富耀1项报价最低，建议授予报价最低的公司\n                                        妥否？\n                                                    请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"56,273.0000","DESCRIPTION":"1月份CFS正面吊机械配件采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"185,291.0000","JHCOST":"49,799.1300","RFQ3":"","RFQ3DESC":"","RFQID":15765,"RFQNUM":"2489","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"1月份CFS正面吊机械配件采购","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"共两项，经比价富耀1项，祺衫1项分别价格最低建议授予。\n                                                         妥否？\n                                                               请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"80,975.0000","DESCRIPTION":"1月份港吉正面吊液压阀采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"248,196.0000","JHCOST":"71,659.2900","RFQ3":"","RFQ3DESC":"","RFQID":15764,"RFQNUM":"2488","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"进行中"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"共5项，经比价南港1项，祺衫4项价格最低，建议授予。\n                                                        妥否？\n                                                             请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"45,728.0000","DESCRIPTION":"1月份港吉正面吊液压泵采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"140,221.0000","JHCOST":"40,467.2500","RFQ3":"","RFQ3DESC":"","RFQID":15763,"RFQNUM":"2487","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"共10项，经比价其中南港2项，祺衫5项，富耀3项价格最低，建议授予。\n                                妥否？\n                                               请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"52,370.0000","DESCRIPTION":"1月份港吉正面吊机械配件采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"161,618.0000","JHCOST":"46,345.1400","RFQ3":"","RFQ3DESC":"","RFQID":15762,"RFQNUM":"2486","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"进行中"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"共7项其中南港2项，祺衫5项报价最低建议授予。\n                                                       妥否？\n                                                           请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"43,655.0000","DESCRIPTION":"1月份港吉正面吊电器配件采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"136,330.0000","JHCOST":"38,632.7500","RFQ3":"","RFQ3DESC":"","RFQID":15761,"RFQNUM":"2485","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"","A_PURCATALOG":"工程技术部","CYHJJE":"0.0000","DESCRIPTION":"1月份港吉正面吊电脑版采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15760,"RFQNUM":"2484","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"经比价南港价格最低建议授予\n                                            妥否？\n                                                         请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"50,000.0000","DESCRIPTION":"1月份远东堆高机旋锁油缸采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"174,600.0000","JHCOST":"44,247.7900","RFQ3":"","RFQ3DESC":"","RFQID":15759,"RFQNUM":"2483","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"三家公司，远精公司报价最低建议授予\n                                                          妥否？\n                                                                   请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"6,000.0000","DESCRIPTION":"1月份远东堆高机链条喷雾剂采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"23,000.0000","JHCOST":"5,309.7300","RFQ3":"","RFQ3DESC":"","RFQID":15758,"RFQNUM":"2482","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"共15项，创天地报价9项，经比价南港有8项，祺衫7项报价最低，建议授予\n                             妥否？\n                                                 请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"49,639.0000","DESCRIPTION":"远东堆高机机械配件采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"167,317.0000","JHCOST":"43,928.3100","RFQ3":"","RFQ3DESC":"","RFQID":15757,"RFQNUM":"2481","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"共7项，经比价南港5项，创天地1项，祺衫1项价格最低建议授予。\n                                妥否？\n                                               请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"34,435.0000","DESCRIPTION":"1月份远东堆高机电器配件采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"114,914.0000","JHCOST":"30,473.4500","RFQ3":"","RFQ3DESC":"","RFQID":15756,"RFQNUM":"2480","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"宁波市日卓机电有限公司报价最低，\n授予价11520元\n妥否？请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"11,520.0000","DESCRIPTION":"1月份螺丝防腐胶","ENTERBY":"MAOYN","ENTERBYDESC":"茅妍娜","HJJE":"36,720.0000","JHCOST":"10,194.6900","RFQ3":"","RFQ3DESC":"","RFQID":15755,"RFQNUM":"2479","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"1月份螺丝防腐胶采购","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"","A_PURCATALOG":"工程技术部","CYHJJE":"0.0000","DESCRIPTION":"1月份港吉堆高机液压阀配件采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15754,"RFQNUM":"2478","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"}],"showcount":20,"totalpage":51,"totalresult":1005}
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
         * resultlist : [{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"信息中心","CYHJJE":"-666.0000","DESCRIPTION":"7-13","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":16050,"RFQNUM":"2567","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"安全卫环部","CYHJJE":"0.0000","DESCRIPTION":"app流程测试多已发送","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15970,"RFQNUM":"2520","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"安全卫环部","CYHJJE":"0.0000","DESCRIPTION":"app流程测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15969,"RFQNUM":"2519","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"党群工作部","CYHJJE":"0.0000","DESCRIPTION":"app流程测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15968,"RFQNUM":"2518","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"党群工作部","CYHJJE":"0.0000","DESCRIPTION":"app流程测试","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15958,"RFQNUM":"2517","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"信息中心","CYHJJE":"0.0000","DESCRIPTION":"测试选择的物资行状态为\u201c汇总已批准\u201d","ENTERBY":"XIAXF","ENTERBYDESC":"夏晓峰","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15848,"RFQNUM":"2503","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"进行中"},{"A_CONNUM":"","A_DEPT":"信息中心","A_MEMO":"","A_PURCATALOG":"工程技术部","CYHJJE":"0.0000","DESCRIPTION":"杨鑫测试询价单0225","ENTERBY":"MAXADMIN","ENTERBYDESC":"系统管理员","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15790,"RFQNUM":"2499","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"经比价，宁波东方电缆股份有限公司报价最低，\n授予价9540元。\n妥否？请领导批示。","A_PURCATALOG":"工程技术部","CYHJJE":"9,540.0000","DESCRIPTION":"1月份电缆采购","ENTERBY":"MAOYN","ENTERBYDESC":"茅妍娜","HJJE":"31,900.0000","JHCOST":"8,442.4700","RFQ3":"","RFQ3DESC":"","RFQID":15769,"RFQNUM":"2493","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"一共9项经过比价其中南港1项，祺衫7项，富耀1项报价最低，建议授予报价最低的公司\n                                        妥否？\n                                                    请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"56,273.0000","DESCRIPTION":"1月份CFS正面吊机械配件采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"185,291.0000","JHCOST":"49,799.1300","RFQ3":"","RFQ3DESC":"","RFQID":15765,"RFQNUM":"2489","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"1月份CFS正面吊机械配件采购","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"共两项，经比价富耀1项，祺衫1项分别价格最低建议授予。\n                                                         妥否？\n                                                               请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"80,975.0000","DESCRIPTION":"1月份港吉正面吊液压阀采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"248,196.0000","JHCOST":"71,659.2900","RFQ3":"","RFQ3DESC":"","RFQID":15764,"RFQNUM":"2488","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"进行中"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"共5项，经比价南港1项，祺衫4项价格最低，建议授予。\n                                                        妥否？\n                                                             请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"45,728.0000","DESCRIPTION":"1月份港吉正面吊液压泵采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"140,221.0000","JHCOST":"40,467.2500","RFQ3":"","RFQ3DESC":"","RFQID":15763,"RFQNUM":"2487","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"共10项，经比价其中南港2项，祺衫5项，富耀3项价格最低，建议授予。\n                                妥否？\n                                               请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"52,370.0000","DESCRIPTION":"1月份港吉正面吊机械配件采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"161,618.0000","JHCOST":"46,345.1400","RFQ3":"","RFQ3DESC":"","RFQID":15762,"RFQNUM":"2486","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"进行中"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"共7项其中南港2项，祺衫5项报价最低建议授予。\n                                                       妥否？\n                                                           请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"43,655.0000","DESCRIPTION":"1月份港吉正面吊电器配件采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"136,330.0000","JHCOST":"38,632.7500","RFQ3":"","RFQ3DESC":"","RFQID":15761,"RFQNUM":"2485","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"","A_PURCATALOG":"工程技术部","CYHJJE":"0.0000","DESCRIPTION":"1月份港吉正面吊电脑版采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15760,"RFQNUM":"2484","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"经比价南港价格最低建议授予\n                                            妥否？\n                                                         请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"50,000.0000","DESCRIPTION":"1月份远东堆高机旋锁油缸采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"174,600.0000","JHCOST":"44,247.7900","RFQ3":"","RFQ3DESC":"","RFQID":15759,"RFQNUM":"2483","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"三家公司，远精公司报价最低建议授予\n                                                          妥否？\n                                                                   请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"6,000.0000","DESCRIPTION":"1月份远东堆高机链条喷雾剂采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"23,000.0000","JHCOST":"5,309.7300","RFQ3":"","RFQ3DESC":"","RFQID":15758,"RFQNUM":"2482","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"共15项，创天地报价9项，经比价南港有8项，祺衫7项报价最低，建议授予\n                             妥否？\n                                                 请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"49,639.0000","DESCRIPTION":"远东堆高机机械配件采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"167,317.0000","JHCOST":"43,928.3100","RFQ3":"","RFQ3DESC":"","RFQID":15757,"RFQNUM":"2481","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"共7项，经比价南港5项，创天地1项，祺衫1项价格最低建议授予。\n                                妥否？\n                                               请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"34,435.0000","DESCRIPTION":"1月份远东堆高机电器配件采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"114,914.0000","JHCOST":"30,473.4500","RFQ3":"","RFQ3DESC":"","RFQID":15756,"RFQNUM":"2480","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"宁波市日卓机电有限公司报价最低，\n授予价11520元\n妥否？请领导批示","A_PURCATALOG":"工程技术部","CYHJJE":"11,520.0000","DESCRIPTION":"1月份螺丝防腐胶","ENTERBY":"MAOYN","ENTERBYDESC":"茅妍娜","HJJE":"36,720.0000","JHCOST":"10,194.6900","RFQ3":"","RFQ3DESC":"","RFQID":15755,"RFQNUM":"2479","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"1月份螺丝防腐胶采购","SITEID":"1000","STATUS":"完成"},{"A_CONNUM":"","A_DEPT":"工程技术部","A_MEMO":"","A_PURCATALOG":"工程技术部","CYHJJE":"0.0000","DESCRIPTION":"1月份港吉堆高机液压阀配件采购","ENTERBY":"ZHOUDB","ENTERBYDESC":"周东波","HJJE":"0.0000","JHCOST":"0.0000","RFQ3":"","RFQ3DESC":"","RFQID":15754,"RFQNUM":"2478","RFQTYPE":"比价采购","RFQTYPEDESC":"比价采购","R_MASTERDESC":"","SITEID":"1000","STATUS":"已发送"}]
         * showcount : 20
         * totalpage : 51
         * totalresult : 1005
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

        public static class ResultlistBean implements Serializable {
            /**
             * A_CONNUM :
             * A_DEPT : 信息中心
             * A_MEMO :
             * A_PURCATALOG : 信息中心
             * CYHJJE : -666.0000
             * DESCRIPTION : 7-13
             * ENTERBY : MAXADMIN
             * ENTERBYDESC : 系统管理员
             * HJJE : 0.0000
             * JHCOST : 0.0000
             * RFQ3 :
             * RFQ3DESC :
             * RFQID : 16050
             * RFQNUM : 2567
             * RFQTYPE : 比价采购
             * RFQTYPEDESC : 比价采购
             * R_MASTERDESC :
             * SITEID : 1000
             * STATUS : 已发送
             */

            private String A_CONNUM;
            private String A_DEPT;
            private String A_MEMO;
            private String A_PURCATALOG;
            private String CYHJJE;
            private String DESCRIPTION;
            private String ENTERBY;
            private String ENTERBYDESC;
            private String HJJE;
            private String JHCOST;
            private String RFQ3;
            private String RFQ3DESC;
            private int RFQID;
            private String RFQNUM;
            private String RFQTYPE;
            private String RFQTYPEDESC;
            private String R_MASTERDESC;
            private String SITEID;
            private String STATUS;

            public String getA_CONNUM() {
                return A_CONNUM;
            }

            public void setA_CONNUM(String A_CONNUM) {
                this.A_CONNUM = A_CONNUM;
            }

            public String getA_DEPT() {
                return A_DEPT;
            }

            public void setA_DEPT(String A_DEPT) {
                this.A_DEPT = A_DEPT;
            }

            public String getA_MEMO() {
                return A_MEMO;
            }

            public void setA_MEMO(String A_MEMO) {
                this.A_MEMO = A_MEMO;
            }

            public String getA_PURCATALOG() {
                return A_PURCATALOG;
            }

            public void setA_PURCATALOG(String A_PURCATALOG) {
                this.A_PURCATALOG = A_PURCATALOG;
            }

            public String getCYHJJE() {
                return CYHJJE;
            }

            public void setCYHJJE(String CYHJJE) {
                this.CYHJJE = CYHJJE;
            }

            public String getDESCRIPTION() {
                return DESCRIPTION;
            }

            public void setDESCRIPTION(String DESCRIPTION) {
                this.DESCRIPTION = DESCRIPTION;
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

            public String getHJJE() {
                return HJJE;
            }

            public void setHJJE(String HJJE) {
                this.HJJE = HJJE;
            }

            public String getJHCOST() {
                return JHCOST;
            }

            public void setJHCOST(String JHCOST) {
                this.JHCOST = JHCOST;
            }

            public String getRFQ3() {
                return RFQ3;
            }

            public void setRFQ3(String RFQ3) {
                this.RFQ3 = RFQ3;
            }

            public String getRFQ3DESC() {
                return RFQ3DESC;
            }

            public void setRFQ3DESC(String RFQ3DESC) {
                this.RFQ3DESC = RFQ3DESC;
            }

            public int getRFQID() {
                return RFQID;
            }

            public void setRFQID(int RFQID) {
                this.RFQID = RFQID;
            }

            public String getRFQNUM() {
                return RFQNUM;
            }

            public void setRFQNUM(String RFQNUM) {
                this.RFQNUM = RFQNUM;
            }

            public String getRFQTYPE() {
                return RFQTYPE;
            }

            public void setRFQTYPE(String RFQTYPE) {
                this.RFQTYPE = RFQTYPE;
            }

            public String getRFQTYPEDESC() {
                return RFQTYPEDESC;
            }

            public void setRFQTYPEDESC(String RFQTYPEDESC) {
                this.RFQTYPEDESC = RFQTYPEDESC;
            }

            public String getR_MASTERDESC() {
                return R_MASTERDESC;
            }

            public void setR_MASTERDESC(String R_MASTERDESC) {
                this.R_MASTERDESC = R_MASTERDESC;
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
        }
    }
}
