package com.cn.beisanproject.modelbean;

import java.io.Serializable;

public class LoginBean implements Serializable {


    /**
     * errcode : USER-S-101
     * errmsg : 登录成功
     * personid : MAXADMIN
     * result : {"baseCaltype":"gregorian","baseCurrency":"CNY","caltype":"gregorian","connectionKey":{"inetAddress":"192.168.1.180","loginUserName":"MAXADMIN","preview":false,"secondID":0,"uID":{}},"defaultLang":"","defaultLocaleStr":"","defaultTZStr":"","displayName":"系统管理员","iCULocale":{"baseName":"zh_CN","country":"CN","displayCountry":"中国","displayLanguage":"中文","displayName":"中文 (中国, 日历=公历)","displayScript":"","displayVariant":"","fallback":{"baseName":"zh","country":"","displayCountry":"","displayLanguage":"中文","displayName":"中文 (日历=公历)","displayScript":"","displayVariant":"","fallback":{"baseName":"","country":"","displayCountry":"","displayLanguage":"","displayName":"日历=公历","displayScript":"","displayVariant":"","iSO3Country":"","iSO3Language":"","keywords":{},"language":"","name":"@calendar=gregorian","script":"","variant":""},"iSO3Country":"","iSO3Language":"zho","keywords":{},"language":"zh","name":"zh@calendar=gregorian","script":"","variant":""},"iSO3Country":"CHN","iSO3Language":"zho","keywords":{},"language":"zh","name":"zh_CN@calendar=gregorian","script":"","variant":""},"inactiveSites":true,"insertSite":"1000","interactive":false,"langCode":"ZH","localSession":false,"locale":"zh_CN","loginID":"MAXADMIN","loginUserName":"MAXADMIN","maxSessionID":0,"personId":"MAXADMIN","preview":false,"schemaOwner":"bltct","screenReader":false,"serverGuid":"f85c9cda-90fb-4dca-ac1c-07dfb8027810","startApp":"","timeZone":"Asia/Shanghai","userLoginDetails":{"baseCalendar":"gregorian","baseCurrency":"CNY","baseLang":"ZH","defaultLang":"","defaultLocaleStr":"","defaultOrg":"10","defaultSite":"1000","defaultStoreroom":"","defaultTZStr":"","displayName":"系统管理员","inactiveSites":true,"insertOrg":"10","insertSite":"1000","loginUserName":"MAXADMIN","maxSessionID":0,"personId":"MAXADMIN","queryWithSite":false,"schemaOwner":"bltct","screenReader":false,"userName":"MAXADMIN"},"userName":"MAXADMIN"}
     */

    private String errcode;

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

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    private String errmsg;
    private String personid;
    private ResultBean result;
}
