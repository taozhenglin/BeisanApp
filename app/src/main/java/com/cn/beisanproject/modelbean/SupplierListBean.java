package com.cn.beisanproject.modelbean;

import java.io.Serializable;
import java.util.List;

public class SupplierListBean implements Serializable {

    /**
     * errcode : GLOBAL-S-0
     * errmsg : 请求成功
     * personid : null
     * result : {"curpage":1,"resultlist":[{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-06 13:45:43","BANKACCOUNT":"12121221","BANKNAME":"北三","BANKNUM":"","CAPITAL":"","CONTACT":"12","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"88888","LICENCE":"","NAME":"7-6-AAA","OPERATION":"88888","PERCOUNT":"999","PHONE":"","REGISTRATION":"12D42343","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"986","VENDORSAPPLYID":986,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-06 13:36:32","BANKACCOUNT":"222","BANKNAME":"等待批准","BANKNUM":"","CAPITAL":"","CONTACT":"1003","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"","LICENCE":"","NAME":"7-6-E","OPERATION":"","PERCOUNT":"","PHONE":"","REGISTRATION":"23R12122121","SCOPE":"","SENDFLAG":"N","STATUS":"新增","TAX1CODE":"","USEFLAG":"Y","VENDORS":"985","VENDORSAPPLYID":985,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-06 11:53:12","BANKACCOUNT":"33333","BANKNAME":"北三","BANKNUM":"","CAPITAL":"","CONTACT":"DDDD","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"DDDDD","LICENCE":"","NAME":"7-6-D","OPERATION":"QQQ","PERCOUNT":"23","PHONE":"","REGISTRATION":"1D3333","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"984","VENDORSAPPLYID":984,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-06 11:49:57","BANKACCOUNT":"666666","BANKNAME":"66","BANKNUM":"","CAPITAL":"","CONTACT":"2222","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"JJJJJJJJJJJJ","LICENCE":"","NAME":"7-6-C","OPERATION":"","PERCOUNT":"56","PHONE":"","REGISTRATION":"1C3333","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"983","VENDORSAPPLYID":983,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-06 11:43:37","BANKACCOUNT":"222222","BANKNAME":"北三","BANKNUM":"","CAPITAL":"","CONTACT":"12","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"222","LICENCE":"","NAME":"7-6-B","OPERATION":"","PERCOUNT":"22","PHONE":"","REGISTRATION":"1B234","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"982","VENDORSAPPLYID":982,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-06 11:39:34","BANKACCOUNT":"222222","BANKNAME":"等待批准","BANKNUM":"","CAPITAL":"","CONTACT":"1003","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"666666","LICENCE":"","NAME":"7-6-A","OPERATION":"","PERCOUNT":"66","PHONE":"","REGISTRATION":"1A234","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"981","VENDORSAPPLYID":981,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 17:51:26","BANKACCOUNT":"121221","BANKNAME":"北三","BANKNUM":"","CAPITAL":"","CONTACT":"1212","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"","LICENCE":"","NAME":"7-3-UUU11","OPERATION":"","PERCOUNT":"12","PHONE":"","REGISTRATION":"121221","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"975","VENDORSAPPLYID":975,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 17:47:31","BANKACCOUNT":"2121","BANKNAME":"北三","BANKNUM":"","CAPITAL":"","CONTACT":"李","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"444444","LICENCE":"","NAME":"7-3-UUUU","OPERATION":"","PERCOUNT":"44","PHONE":"","REGISTRATION":"I9O0","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"974","VENDORSAPPLYID":974,"VENDORSCODE":""},{"ADDRESS1":"22","ADDRESS4":"222","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 17:44:38","BANKACCOUNT":"北三","BANKNAME":"北三","BANKNUM":"999999999999","CAPITAL":"88","CONTACT":"李","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"2222","FIXEDASSETS":"固定资产固定资产","LICENCE":"888","NAME":"7-3-FINALY","OPERATION":"KKKKKKKKKKKKKKKKKKKKK","PERCOUNT":"99","PHONE":"121212","REGISTRATION":"9O9999999","SCOPE":"6767767","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"8888","USEFLAG":"Y","VENDORS":"973","VENDORSAPPLYID":973,"VENDORSCODE":""},{"ADDRESS1":"22","ADDRESS4":"222","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 17:36:11","BANKACCOUNT":"89898989","BANKNAME":"北三","BANKNUM":"8888","CAPITAL":"66","CONTACT":"张","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"2222","FIXEDASSETS":"固定资产固定资产","LICENCE":"666","NAME":"7-3-ssss","OPERATION":"6666666","PERCOUNT":"5","PHONE":"22222","REGISTRATION":"SSSS111","SCOPE":"6","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"66666","USEFLAG":"Y","VENDORS":"971","VENDORSAPPLYID":971,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 17:28:21","BANKACCOUNT":"66","BANKNAME":"66","BANKNUM":"","CAPITAL":"","CONTACT":"1212","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"5555","LICENCE":"","NAME":"7-3-09","OPERATION":"","PERCOUNT":"22","PHONE":"","REGISTRATION":"12897","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"970","VENDORSAPPLYID":970,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 16:55:25","BANKACCOUNT":"222","BANKNAME":"333","BANKNUM":"","CAPITAL":"","CONTACT":"11111","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"5555","LICENCE":"","NAME":"7-3-000","OPERATION":"6666","PERCOUNT":"99","PHONE":"","REGISTRATION":"000999","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"969","VENDORSAPPLYID":969,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 16:45:59","BANKACCOUNT":"88","BANKNAME":"88","BANKNUM":"","CAPITAL":"","CONTACT":"4","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"7777","LICENCE":"","NAME":"7-3-777","OPERATION":"","PERCOUNT":"","PHONE":"","REGISTRATION":"4444","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"968","VENDORSAPPLYID":968,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 16:30:18","BANKACCOUNT":"33333","BANKNAME":"33","BANKNUM":"","CAPITAL":"","CONTACT":"2323232","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"2323","LICENCE":"","NAME":"7-3-PPP","OPERATION":"2323","PERCOUNT":"","PHONE":"","REGISTRATION":"80980123","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"967","VENDORSAPPLYID":967,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 16:17:02","BANKACCOUNT":"5555","BANKNAME":"55","BANKNUM":"","CAPITAL":"","CONTACT":"3333","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"77777","LICENCE":"","NAME":"7-3-D","OPERATION":"77","PERCOUNT":"5,555","PHONE":"","REGISTRATION":"5454","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"965","VENDORSAPPLYID":965,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 16:00:05","BANKACCOUNT":"6","BANKNAME":"66","BANKNUM":"","CAPITAL":"","CONTACT":"1212","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"444","LICENCE":"","NAME":"7-3-c","OPERATION":"","PERCOUNT":"","PHONE":"","REGISTRATION":"4896","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"964","VENDORSAPPLYID":964,"VENDORSCODE":""},{"ADDRESS1":"3","ADDRESS4":"33","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 15:45:27","BANKACCOUNT":"99","BANKNAME":"999","BANKNUM":"9","CAPITAL":"44","CONTACT":"222","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"2","FIXEDASSETS":"5555","LICENCE":"444","NAME":"7-3-B-供应商","OPERATION":"555","PERCOUNT":"9","PHONE":"22","REGISTRATION":"111111","SCOPE":"4","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"4444","USEFLAG":"Y","VENDORS":"963","VENDORSAPPLYID":963,"VENDORSCODE":""},{"ADDRESS1":"5","ADDRESS4":"55","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 15:31:50","BANKACCOUNT":"8888","BANKNAME":"北三","BANKNUM":"888","CAPITAL":"88","CONTACT":"李","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"555","FIXEDASSETS":"9999","LICENCE":"888","NAME":"7-3-A-供应商","OPERATION":"999","PERCOUNT":"8","PHONE":"5555","REGISTRATION":"333333","SCOPE":"8","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"8888","USEFLAG":"Y","VENDORS":"962","VENDORSAPPLYID":962,"VENDORSCODE":""},{"ADDRESS1":"111","ADDRESS4":"11","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 14:37:45","BANKACCOUNT":"11111111","BANKNAME":"张","BANKNUM":"111","CAPITAL":"2222","CONTACT":"张","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"111","FIXEDASSETS":"2222","LICENCE":"2222","NAME":"7-3供应商","OPERATION":"222","PERCOUNT":"2","PHONE":"111","REGISTRATION":"12344321","SCOPE":"222","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"2222","USEFLAG":"Y","VENDORS":"961","VENDORSAPPLYID":961,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-06-18 15:20:20","BANKACCOUNT":"BANK","BANKNAME":"guide","BANKNUM":"","CAPITAL":"","CONTACT":"15112345678","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"","LICENCE":"","NAME":"guide","OPERATION":"","PERCOUNT":"","PHONE":"","REGISTRATION":"guidegongshang","SCOPE":"","SENDFLAG":"N","STATUS":"已审批","TAX1CODE":"","USEFLAG":"Y","VENDORS":"942","VENDORSAPPLYID":942,"VENDORSCODE":""}],"showcount":20,"totalpage":5,"totalresult":91}
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
         * resultlist : [{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-06 13:45:43","BANKACCOUNT":"12121221","BANKNAME":"北三","BANKNUM":"","CAPITAL":"","CONTACT":"12","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"88888","LICENCE":"","NAME":"7-6-AAA","OPERATION":"88888","PERCOUNT":"999","PHONE":"","REGISTRATION":"12D42343","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"986","VENDORSAPPLYID":986,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-06 13:36:32","BANKACCOUNT":"222","BANKNAME":"等待批准","BANKNUM":"","CAPITAL":"","CONTACT":"1003","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"","LICENCE":"","NAME":"7-6-E","OPERATION":"","PERCOUNT":"","PHONE":"","REGISTRATION":"23R12122121","SCOPE":"","SENDFLAG":"N","STATUS":"新增","TAX1CODE":"","USEFLAG":"Y","VENDORS":"985","VENDORSAPPLYID":985,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-06 11:53:12","BANKACCOUNT":"33333","BANKNAME":"北三","BANKNUM":"","CAPITAL":"","CONTACT":"DDDD","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"DDDDD","LICENCE":"","NAME":"7-6-D","OPERATION":"QQQ","PERCOUNT":"23","PHONE":"","REGISTRATION":"1D3333","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"984","VENDORSAPPLYID":984,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-06 11:49:57","BANKACCOUNT":"666666","BANKNAME":"66","BANKNUM":"","CAPITAL":"","CONTACT":"2222","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"JJJJJJJJJJJJ","LICENCE":"","NAME":"7-6-C","OPERATION":"","PERCOUNT":"56","PHONE":"","REGISTRATION":"1C3333","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"983","VENDORSAPPLYID":983,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-06 11:43:37","BANKACCOUNT":"222222","BANKNAME":"北三","BANKNUM":"","CAPITAL":"","CONTACT":"12","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"222","LICENCE":"","NAME":"7-6-B","OPERATION":"","PERCOUNT":"22","PHONE":"","REGISTRATION":"1B234","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"982","VENDORSAPPLYID":982,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-06 11:39:34","BANKACCOUNT":"222222","BANKNAME":"等待批准","BANKNUM":"","CAPITAL":"","CONTACT":"1003","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"666666","LICENCE":"","NAME":"7-6-A","OPERATION":"","PERCOUNT":"66","PHONE":"","REGISTRATION":"1A234","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"981","VENDORSAPPLYID":981,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 17:51:26","BANKACCOUNT":"121221","BANKNAME":"北三","BANKNUM":"","CAPITAL":"","CONTACT":"1212","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"","LICENCE":"","NAME":"7-3-UUU11","OPERATION":"","PERCOUNT":"12","PHONE":"","REGISTRATION":"121221","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"975","VENDORSAPPLYID":975,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 17:47:31","BANKACCOUNT":"2121","BANKNAME":"北三","BANKNUM":"","CAPITAL":"","CONTACT":"李","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"444444","LICENCE":"","NAME":"7-3-UUUU","OPERATION":"","PERCOUNT":"44","PHONE":"","REGISTRATION":"I9O0","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"974","VENDORSAPPLYID":974,"VENDORSCODE":""},{"ADDRESS1":"22","ADDRESS4":"222","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 17:44:38","BANKACCOUNT":"北三","BANKNAME":"北三","BANKNUM":"999999999999","CAPITAL":"88","CONTACT":"李","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"2222","FIXEDASSETS":"固定资产固定资产","LICENCE":"888","NAME":"7-3-FINALY","OPERATION":"KKKKKKKKKKKKKKKKKKKKK","PERCOUNT":"99","PHONE":"121212","REGISTRATION":"9O9999999","SCOPE":"6767767","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"8888","USEFLAG":"Y","VENDORS":"973","VENDORSAPPLYID":973,"VENDORSCODE":""},{"ADDRESS1":"22","ADDRESS4":"222","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 17:36:11","BANKACCOUNT":"89898989","BANKNAME":"北三","BANKNUM":"8888","CAPITAL":"66","CONTACT":"张","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"2222","FIXEDASSETS":"固定资产固定资产","LICENCE":"666","NAME":"7-3-ssss","OPERATION":"6666666","PERCOUNT":"5","PHONE":"22222","REGISTRATION":"SSSS111","SCOPE":"6","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"66666","USEFLAG":"Y","VENDORS":"971","VENDORSAPPLYID":971,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 17:28:21","BANKACCOUNT":"66","BANKNAME":"66","BANKNUM":"","CAPITAL":"","CONTACT":"1212","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"5555","LICENCE":"","NAME":"7-3-09","OPERATION":"","PERCOUNT":"22","PHONE":"","REGISTRATION":"12897","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"970","VENDORSAPPLYID":970,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 16:55:25","BANKACCOUNT":"222","BANKNAME":"333","BANKNUM":"","CAPITAL":"","CONTACT":"11111","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"5555","LICENCE":"","NAME":"7-3-000","OPERATION":"6666","PERCOUNT":"99","PHONE":"","REGISTRATION":"000999","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"969","VENDORSAPPLYID":969,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 16:45:59","BANKACCOUNT":"88","BANKNAME":"88","BANKNUM":"","CAPITAL":"","CONTACT":"4","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"7777","LICENCE":"","NAME":"7-3-777","OPERATION":"","PERCOUNT":"","PHONE":"","REGISTRATION":"4444","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"968","VENDORSAPPLYID":968,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 16:30:18","BANKACCOUNT":"33333","BANKNAME":"33","BANKNUM":"","CAPITAL":"","CONTACT":"2323232","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"2323","LICENCE":"","NAME":"7-3-PPP","OPERATION":"2323","PERCOUNT":"","PHONE":"","REGISTRATION":"80980123","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"967","VENDORSAPPLYID":967,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 16:17:02","BANKACCOUNT":"5555","BANKNAME":"55","BANKNUM":"","CAPITAL":"","CONTACT":"3333","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"77777","LICENCE":"","NAME":"7-3-D","OPERATION":"77","PERCOUNT":"5,555","PHONE":"","REGISTRATION":"5454","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"965","VENDORSAPPLYID":965,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 16:00:05","BANKACCOUNT":"6","BANKNAME":"66","BANKNUM":"","CAPITAL":"","CONTACT":"1212","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"444","LICENCE":"","NAME":"7-3-c","OPERATION":"","PERCOUNT":"","PHONE":"","REGISTRATION":"4896","SCOPE":"","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"","USEFLAG":"Y","VENDORS":"964","VENDORSAPPLYID":964,"VENDORSCODE":""},{"ADDRESS1":"3","ADDRESS4":"33","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 15:45:27","BANKACCOUNT":"99","BANKNAME":"999","BANKNUM":"9","CAPITAL":"44","CONTACT":"222","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"2","FIXEDASSETS":"5555","LICENCE":"444","NAME":"7-3-B-供应商","OPERATION":"555","PERCOUNT":"9","PHONE":"22","REGISTRATION":"111111","SCOPE":"4","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"4444","USEFLAG":"Y","VENDORS":"963","VENDORSAPPLYID":963,"VENDORSCODE":""},{"ADDRESS1":"5","ADDRESS4":"55","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 15:31:50","BANKACCOUNT":"8888","BANKNAME":"北三","BANKNUM":"888","CAPITAL":"88","CONTACT":"李","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"555","FIXEDASSETS":"9999","LICENCE":"888","NAME":"7-3-A-供应商","OPERATION":"999","PERCOUNT":"8","PHONE":"5555","REGISTRATION":"333333","SCOPE":"8","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"8888","USEFLAG":"Y","VENDORS":"962","VENDORSAPPLYID":962,"VENDORSCODE":""},{"ADDRESS1":"111","ADDRESS4":"11","APPLICANT":"系统管理员","APPLYDATE":"2020-07-03 14:37:45","BANKACCOUNT":"11111111","BANKNAME":"张","BANKNUM":"111","CAPITAL":"2222","CONTACT":"张","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"111","FIXEDASSETS":"2222","LICENCE":"2222","NAME":"7-3供应商","OPERATION":"222","PERCOUNT":"2","PHONE":"111","REGISTRATION":"12344321","SCOPE":"222","SENDFLAG":"N","STATUS":"等待审核","TAX1CODE":"2222","USEFLAG":"Y","VENDORS":"961","VENDORSAPPLYID":961,"VENDORSCODE":""},{"ADDRESS1":"","ADDRESS4":"","APPLICANT":"系统管理员","APPLYDATE":"2020-06-18 15:20:20","BANKACCOUNT":"BANK","BANKNAME":"guide","BANKNUM":"","CAPITAL":"","CONTACT":"15112345678","CONTRACTPHONE":"18090908080","CURRENCYCODE":"CNY","FAX":"","FIXEDASSETS":"","LICENCE":"","NAME":"guide","OPERATION":"","PERCOUNT":"","PHONE":"","REGISTRATION":"guidegongshang","SCOPE":"","SENDFLAG":"N","STATUS":"已审批","TAX1CODE":"","USEFLAG":"Y","VENDORS":"942","VENDORSAPPLYID":942,"VENDORSCODE":""}]
         * showcount : 20
         * totalpage : 5
         * totalresult : 91
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
             * ADDRESS1 :
             * ADDRESS4 :
             * APPLICANT : 系统管理员
             * APPLYDATE : 2020-07-06 13:45:43
             * BANKACCOUNT : 12121221
             * BANKNAME : 北三
             * BANKNUM :
             * CAPITAL :
             * CONTACT : 12
             * CONTRACTPHONE : 18090908080
             * CURRENCYCODE : CNY
             * FAX :
             * FIXEDASSETS : 88888
             * LICENCE :
             * NAME : 7-6-AAA
             * OPERATION : 88888
             * PERCOUNT : 999
             * PHONE :
             * REGISTRATION : 12D42343
             * SCOPE :
             * SENDFLAG : N
             * STATUS : 等待审核
             * TAX1CODE :
             * USEFLAG : Y
             * VENDORS : 986
             * VENDORSAPPLYID : 986
             * VENDORSCODE :
             */

            private String ADDRESS1;
            private String ADDRESS4;
            private String APPLICANT;
            private String APPLYDATE;
            private String BANKACCOUNT;
            private String BANKNAME;
            private String BANKNUM;
            private String CAPITAL;
            private String CONTACT;
            private String CONTRACTPHONE;
            private String CURRENCYCODE;
            private String FAX;
            private String FIXEDASSETS;
            private String LICENCE;
            private String NAME;
            private String OPERATION;
            private String PERCOUNT;
            private String PHONE;
            private String REGISTRATION;
            private String SCOPE;
            private String SENDFLAG;
            private String STATUS;
            private String TAX1CODE;
            private String USEFLAG;
            private String VENDORS;
            private int VENDORSAPPLYID;
            private String VENDORSCODE;

            public String getADDRESS1() {
                return ADDRESS1;
            }

            public void setADDRESS1(String ADDRESS1) {
                this.ADDRESS1 = ADDRESS1;
            }

            public String getADDRESS4() {
                return ADDRESS4;
            }

            public void setADDRESS4(String ADDRESS4) {
                this.ADDRESS4 = ADDRESS4;
            }

            public String getAPPLICANT() {
                return APPLICANT;
            }

            public void setAPPLICANT(String APPLICANT) {
                this.APPLICANT = APPLICANT;
            }

            public String getAPPLYDATE() {
                return APPLYDATE;
            }

            public void setAPPLYDATE(String APPLYDATE) {
                this.APPLYDATE = APPLYDATE;
            }

            public String getBANKACCOUNT() {
                return BANKACCOUNT;
            }

            public void setBANKACCOUNT(String BANKACCOUNT) {
                this.BANKACCOUNT = BANKACCOUNT;
            }

            public String getBANKNAME() {
                return BANKNAME;
            }

            public void setBANKNAME(String BANKNAME) {
                this.BANKNAME = BANKNAME;
            }

            public String getBANKNUM() {
                return BANKNUM;
            }

            public void setBANKNUM(String BANKNUM) {
                this.BANKNUM = BANKNUM;
            }

            public String getCAPITAL() {
                return CAPITAL;
            }

            public void setCAPITAL(String CAPITAL) {
                this.CAPITAL = CAPITAL;
            }

            public String getCONTACT() {
                return CONTACT;
            }

            public void setCONTACT(String CONTACT) {
                this.CONTACT = CONTACT;
            }

            public String getCONTRACTPHONE() {
                return CONTRACTPHONE;
            }

            public void setCONTRACTPHONE(String CONTRACTPHONE) {
                this.CONTRACTPHONE = CONTRACTPHONE;
            }

            public String getCURRENCYCODE() {
                return CURRENCYCODE;
            }

            public void setCURRENCYCODE(String CURRENCYCODE) {
                this.CURRENCYCODE = CURRENCYCODE;
            }

            public String getFAX() {
                return FAX;
            }

            public void setFAX(String FAX) {
                this.FAX = FAX;
            }

            public String getFIXEDASSETS() {
                return FIXEDASSETS;
            }

            public void setFIXEDASSETS(String FIXEDASSETS) {
                this.FIXEDASSETS = FIXEDASSETS;
            }

            public String getLICENCE() {
                return LICENCE;
            }

            public void setLICENCE(String LICENCE) {
                this.LICENCE = LICENCE;
            }

            public String getNAME() {
                return NAME;
            }

            public void setNAME(String NAME) {
                this.NAME = NAME;
            }

            public String getOPERATION() {
                return OPERATION;
            }

            public void setOPERATION(String OPERATION) {
                this.OPERATION = OPERATION;
            }

            public String getPERCOUNT() {
                return PERCOUNT;
            }

            public void setPERCOUNT(String PERCOUNT) {
                this.PERCOUNT = PERCOUNT;
            }

            public String getPHONE() {
                return PHONE;
            }

            public void setPHONE(String PHONE) {
                this.PHONE = PHONE;
            }

            public String getREGISTRATION() {
                return REGISTRATION;
            }

            public void setREGISTRATION(String REGISTRATION) {
                this.REGISTRATION = REGISTRATION;
            }

            public String getSCOPE() {
                return SCOPE;
            }

            public void setSCOPE(String SCOPE) {
                this.SCOPE = SCOPE;
            }

            public String getSENDFLAG() {
                return SENDFLAG;
            }

            public void setSENDFLAG(String SENDFLAG) {
                this.SENDFLAG = SENDFLAG;
            }

            public String getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(String STATUS) {
                this.STATUS = STATUS;
            }

            public String getTAX1CODE() {
                return TAX1CODE;
            }

            public void setTAX1CODE(String TAX1CODE) {
                this.TAX1CODE = TAX1CODE;
            }

            public String getUSEFLAG() {
                return USEFLAG;
            }

            public void setUSEFLAG(String USEFLAG) {
                this.USEFLAG = USEFLAG;
            }

            public String getVENDORS() {
                return VENDORS;
            }

            public void setVENDORS(String VENDORS) {
                this.VENDORS = VENDORS;
            }

            public int getVENDORSAPPLYID() {
                return VENDORSAPPLYID;
            }

            public void setVENDORSAPPLYID(int VENDORSAPPLYID) {
                this.VENDORSAPPLYID = VENDORSAPPLYID;
            }

            public String getVENDORSCODE() {
                return VENDORSCODE;
            }

            public void setVENDORSCODE(String VENDORSCODE) {
                this.VENDORSCODE = VENDORSCODE;
            }
        }
    }
}
