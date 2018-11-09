package com.kekemei.kekemei.bean;

import java.io.Serializable;

/**
 * 搜索历史对象
 */
public class SearchHistoryBean implements Serializable {
    private String content;
    private String key;

    public SearchHistoryBean(String key, String content) {
        this.content = content;
        this.key = key;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
