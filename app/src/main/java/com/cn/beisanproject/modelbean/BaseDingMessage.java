package com.cn.beisanproject.modelbean;

import java.util.List;

/**
 * Created by tzl
 * on 2020/11/23
 */
public class BaseDingMessage {
    public static final String TYPE_LINK = "link";

    public static final String TYPE_MARKDOWN = "markdown";

    public static final String TYPE_TEXT = "text";

    public static final String TYPE_ACTIONCARD = "actionCard";

    public static final String TYPE_FEEDCARD = "feedCard";

    public String msgtype;

    public AtBean at;

    public static class AtBean {
        public boolean isAtAll;
        public List<String> atMobiles;
    }
}
