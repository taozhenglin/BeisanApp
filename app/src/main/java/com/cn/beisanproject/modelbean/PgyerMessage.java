package com.cn.beisanproject.modelbean;

/**
 * Created by tzl
 * on 2020/11/23
 */
public class PgyerMessage {

    /**
     * action : 应用更新
     * title : OooPlay
     * link : https://www.pgyer.com/oooplay_test
     * message : 您的应用OooPlay有了新的版本(2.4)更新。
     * type : updateVersion
     * os_version : 2.4
     * build_version : 139
     * created : 2015-10-09 11:25:16
     * updated : 2015-10-09 11:25:16
     * timestamp : 1444361118
     * appsize : 2238036
     * device_type : iOS
     * notes : 修复了一些小弱智的小bug
     */

    private String action;
    private String title;
    private String link;
    private String message;
    private String type;
    private String os_version;
    private String build_version;
    private String created;
    private String updated;
    private int timestamp;
    private String appsize;
    private String device_type;
    private String notes;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getBuild_version() {
        return build_version;
    }

    public void setBuild_version(String build_version) {
        this.build_version = build_version;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getAppsize() {
        return appsize;
    }

    public void setAppsize(String appsize) {
        this.appsize = appsize;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "PgyerMessage{" +
                "action='" + action + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", os_version='" + os_version + '\'' +
                ", build_version='" + build_version + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", timestamp=" + timestamp +
                ", appsize='" + appsize + '\'' +
                ", device_type='" + device_type + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
