package com.hualong.kekemei.Utills;

import com.hualong.kekemei.BuildConfig;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * Created by lenovo on 2017/2/8.
 */
public class LogUtil {
    static {
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    private static final String TAG = "LogUtil";

    public static void v(String message) {
        if (message != null && !message.isEmpty())
            Logger.t(TAG).t(TAG).v(message); // VERBOSE级别，可添加占位符
    }

    public static void d(String message) {
        if (message != null && !message.isEmpty())
            Logger.t(TAG).d(message); // DEBUG级别，可添加占位符
    }

    public static void d(Object object) {
        if (object != null)
            Logger.t(TAG).d(object); // DEBUG级别，打印对象
    }

    public static void i(String message) {
        if (message != null && !message.isEmpty())
            Logger.t(TAG).i(message); // INFO级别，可添加占位符
    }


    public static void w(String message) {
        if (message != null && !message.isEmpty())
            Logger.t(TAG).w(message);// WARN级别，可添加占位符
    }

    public static void e(String message) {
        if (message != null && !message.isEmpty())
            Logger.t(TAG).e(message); // ERROR级别，可添加占位符
    }

    public static void e(String TAG, String message) {
        if (message != null && !message.isEmpty())
            Logger.t(TAG).e(message); // ERROR级别，可添加占位符
    }

    public static void d(String TAG, String message) {
        if (message != null && !message.isEmpty())
            Logger.t(TAG).d(message); // DEBUG级别，可添加占位符
    }

    public static void v(String TAG, String message) {
        if (message != null && !message.isEmpty())
            Logger.t(TAG).v(message); // VERBOSE级别，可添加占位符
    }

    public static void e(Throwable throwable, String message) {
        if (message != null && !message.isEmpty())
            Logger.t(TAG).e(throwable, message); // ERROR级别，可添加占位符
    }

    public static void json(String json) {
        if (json != null && !json.isEmpty())
            Logger.t(TAG).json(json);
    }


}
