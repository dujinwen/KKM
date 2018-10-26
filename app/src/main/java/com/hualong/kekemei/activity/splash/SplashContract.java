package com.hualong.kekemei.activity.splash;


import com.hualong.kekemei.activity.BasePresenter;
import com.hualong.kekemei.activity.BaseView;

/**
 * Created by zhangshaoming on 2017/12/12.
 */

public interface SplashContract {

    interface View extends BaseView<Presenter> {

        void setTitle(String title);

        void finishSP();

    }

    interface Presenter extends BasePresenter {

    }
}
