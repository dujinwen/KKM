package com.hualong.kekemei.utills;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zhangshaoming on 2017/12/13.
 */
public class SPUtils {


    private static final String name = "SharedPreferences";//表名


    private static SharedPreferences getSp(Context context) {
        SharedPreferences sp = context.getSharedPreferences(name,
                Context.MODE_PRIVATE);
        return sp;
    }

    private static SharedPreferences.Editor getSpEdit(Context context) {
        SharedPreferences sp = context.getSharedPreferences(name,
                Context.MODE_PRIVATE);
        return sp.edit();
    }

    public static boolean putBoolean(Context context, String key, boolean value) {
        return getSpEdit(context).putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        return getSp(context).getBoolean(key, defaultValue);
    }

    public static boolean putFloat(Context context, String key, float value) {
        return getSpEdit(context).putFloat(key, value).commit();
    }

    public static float getFloat(Context context, String key, float defaultValue) {
        return getSp(context).getFloat(key, defaultValue);
    }

    public static boolean putInt(Context context, String key, int value) {
        return getSpEdit(context).putInt(key, value).commit();
    }

    public static int getInt(Context context, String key, int defaultValue) {
        return getSp(context).getInt(key, defaultValue);
    }

    public static boolean putLong(Context context, String key, Long value) {
        return getSpEdit(context).putLong(key, value).commit();
    }

    public static long getLong(Context context, String key, Long defaultValue) {
        return getSp(context).getLong(key, defaultValue);
    }

    public static boolean putString(Context context, String key, String value) {
        return getSpEdit(context).putString(key, value).commit();
    }

    public static String getString(Context context, String key, String defaultValue) {
        return getSp(context).getString(key, defaultValue);
    }

    public static boolean putDouble(Context context, String key, double value) {
        return getSpEdit(context).putLong(key, Double.doubleToRawLongBits(value)).commit();
    }

    public static double getDouble(Context context, String key) {
        return Double.longBitsToDouble(getSp(context).getLong(key, 0));
    }

}