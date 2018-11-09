package com.kekemei.kekemei.fragment;

/**
 * QDAS打点Fragment需要实现的接口
 * 提供进入页面、离开页面的接口
 * Created by renkuo on 2016/5/5.
 */
public interface SearchIPage {
    void onEnter(String keyWord);
    void onLeave();
}
