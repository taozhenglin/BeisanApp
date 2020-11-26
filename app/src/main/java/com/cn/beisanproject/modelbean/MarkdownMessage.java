package com.cn.beisanproject.modelbean;

/**
 * Created by tzl
 * on 2020/11/23
 */
public class MarkdownMessage extends BaseDingMessage {
    public MarkdownBean markdown;

    public static class MarkdownBean {

        public String title;
        public String text;
    }
}
