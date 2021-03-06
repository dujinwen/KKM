package com.kekemei.kekemei.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.Context.TELEPHONY_SERVICE;


/**
 * 工具类
 * Created by yzd on 2017/11/24 0024.
 */

public class AppUtil {

    private static AMapLocationClient mLocationClient;
    private static AMapLocationClientOption mLocationOption;

    public static String getFromAssets(Context ct, String fileName) {
        String Result = "";

        try {
            BufferedReader bufReader;
            String line;
            try (InputStreamReader inputReader = new InputStreamReader(
                    ct.getResources().getAssets().open(fileName))) {
                bufReader = new BufferedReader(inputReader);
            }
            line = "";

            while ((line = bufReader.readLine()) != null) {
                Result += line;
                Result += "\r\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result;
    }

    /**
     * bitmap转为base64
     *
     * @param bitmap
     * @return
     */
    public static String bitmapToBase64(Bitmap bitmap) {

        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 判断字符串是否为空，null、""、"null"，都为空
     *
     * @param str
     * @return
     */
    public static boolean isEmptyString(String str) {
        return (TextUtils.isEmpty(str) || "null".equals(str));
    }

    /**
     * base64转为bitmap
     *
     * @param base64Data
     * @return
     */
    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }


    //dip和px之间的转换
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取屏幕的Metrics，进而可以获取高度、宽度、密度
     *
     * @param context
     * @return
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        return dm;
    }

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = getDisplayMetrics(context);
        return dm.widthPixels;
    }


    // 获取资源字符串
    public static String getString(Context context, int strId) {
        return context.getResources().getString(strId);
    }


    public static String encodeURL(String url) {
        String encodeURL = null;
        try {
            encodeURL = URLEncoder.encode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeURL;
    }

    public static String decodeURL(String url) {
        String decodeURL = null;
        try {
            decodeURL = URLDecoder.decode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodeURL;
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
        /*
        移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		联通：130、131、132、152、155、156、185、186
		电信：133、153、180、189、（1349卫通）
		总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		*/
        String telRegex = "[1][3578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    // 拨打电话
    public static void callPhone(Context context, String phonenumber) {
        if (isExistsSIMCard(context)) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.CALL");
            intent.setData(Uri.parse("tel:" + phonenumber));
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "请插入SIM卡", Toast.LENGTH_LONG).show();
        }
    }

    // 判断是否存在SIM卡
    public static boolean isExistsSIMCard(Context context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        if (manager.getSimState() == TelephonyManager.SIM_STATE_READY) return true;
        return false;
    }

    /**
     * 判断当前的的网络是否可用
     *
     * @param context
     * @return
     */
    @SuppressWarnings("deprecation")
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] networkInfos = null;
        try {
            networkInfos = connectivityManager.getAllNetworkInfo();
        } catch (Throwable t) {

        }
        if (networkInfos == null) {
            return false;
        }
        for (NetworkInfo networkInfo : networkInfos) {
            try {
                if (networkInfo.getState() == State.CONNECTED) {
                    return true;
                }
            } catch (Throwable t) {

            }
        }
        return false;
    }

    /**
     * 跳转进入网络设置界面
     *
     * @param ctx 跳转起始位置
     * @author lilw
     * @CrateTime
     */
    public static void intoNetworkSetting(Context ctx) {
        ctx.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
    }

    //获取float两位小数
    public static String getFloatStr(float val) {
        DecimalFormat fnum = new DecimalFormat("##0.00");
        return fnum.format(val);
    }

    /**
     * bitmap转数组
     *
     * @param bmp
     * @param needRecycle
     * @return
     */

    public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 将字符串中的标点符号过滤掉
     *
     * @param str
     * @return
     */

    public static String trimPunctuation(String str) {
        String punct[] = {",", ".", "!", "?", ";", ":", "，", "。", "！", "？",
                "；", "：", "、", "[", "]"};
        List<String> punctList = Arrays.asList(punct); // 将String数组转List集合
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (punctList.contains(c.toString())) {

            } else {
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }

    // 取得屏幕分辨率
    //    public static Point getScreenResolution(Context context) {
    //        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    //        Display display = wm.getDefaultDisplay();
    //        return new Point(display.get(), display.getHeight());
    ////    }

    //获取设备分辨率
    public static String getResolution(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay(); //Activity#getWindowManager()
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        return height + "x" + width;
    }

    /**
     * 利用反射获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        //获取状态栏高度的资源id
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取设备名称 手机型号
     *
     * @return
     */
    public static String getDeviceName() {
        //        return android.os.Build.MANUFACTURER + Build.BRAND  + Build.MODEL;
        return Build.MODEL;
    }

    //    public static String getDeviceId(Context context) {
    //        //        return android.os.Build.MANUFACTURER + Build.BRAND  + Build.MODEL;
    //        TelephonyManager TelephonyMgr = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
    //        String szImei = TelephonyMgr.getDeviceId();
    //        return szImei;
    //    }

    /**
     * 获取操作系统版本
     */

    public static int getSystemVersion() {
        return Build.VERSION.SDK_INT;
    }


    /**
     * 版本名称
     *
     * @param context
     * @return 版本的名称 如：1.0.1；
     * @throws NameNotFoundException 没有写版本名称时报错
     * @author lilw
     * @CrateTime
     */
    public static String getVersionName(Context context) {
        String version = "0";
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo;
        try {
            packInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            version = packInfo.versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }


    /**
     * 应用名字
     *
     * @param context
     */
    public static String getAppName(Context context) {
        return context.getApplicationInfo()
                .loadLabel(context.getPackageManager()).toString();
    }

    public static void setShadow(Activity context, float shadow) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = shadow;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }

    //    public static void copyToClipboard(Context context, String copy) {
    //        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
    //        cmb.setText(copy);
    //    }


    /**
     * 判断应用是否已经启动
     *
     * @param
     * @return boolean
     * * 返回app运行状态
     * 1:程序在前台运行
     * 2:程序在后台运行
     * 3:程序未启动
     */
    //    public static boolean isAppAlive(Context context, String packageName) {
    //        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    //        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(20);
    //
    //        //判断程序是否在栈顶
    //        if (list.get(0).topActivity.getPackageName().equals(packageName)) {
    //            return true;
    //        } else {
    ////            判断程序是否在栈里
    //            for (ActivityManager.RunningTaskInfo info : list) {
    //                if (info.topActivity.getPackageName().equals(packageName)) {
    //                    return false;
    //                }
    //            }//栈里找不到，返回3
    //            return false;
    //        }
    //    }
    public static boolean checkPasswordRegex(String password) {
        if (password == null || password.isEmpty() || password.length() == 0) return false;

        String regex = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    /**
     * 判断当前系统时间是否在指定时间的范围内
     *
     * @return true表示在范围内，否则false
     */
    //    public static boolean isCurrentInTimeScope(int beginHour, int beginMin, int endHour, int endMin) {
    //        boolean result = false;
    //        final long aDayInMillis = 1000 * 60 * 60 * 24;
    //        final long currentTimeMillis = System.currentTimeMillis();
    //
    //        Time now = new Time();
    //        now.set(currentTimeMillis);
    //
    //        Time startTime = new Time();
    //        startTime.set(currentTimeMillis);
    //        startTime.hour = beginHour;
    //        startTime.minute = beginMin;
    //
    //        Time endTime = new Time();
    //        endTime.set(currentTimeMillis);
    //        endTime.hour = endHour;
    //        endTime.minute = endMin;
    //
    //        if (!startTime.before(endTime)) {
    //            // 跨天的特殊情况（比如22:00-8:00）
    //            startTime.set(startTime.toMillis(true) - aDayInMillis);
    //            result = !now.before(startTime) && !now.after(endTime); // startTime <= now <= endTime
    //            Time startTimeInThisDay = new Time();
    //            startTimeInThisDay.set(startTime.toMillis(true) + aDayInMillis);
    //            if (!now.before(startTimeInThisDay)) {
    //                result = true;
    //            }
    //        } else {
    //            // 普通情况(比如 8:00 - 14:00)
    //            result = !now.before(startTime) && !now.after(endTime); // startTime <= now <= endTime
    //        }
    //        return result;
    //    }
    public static void getUserPoint(Context context, AMapLocationListener locationListener) {
        //声明mLocationOption对象
        mLocationClient = new AMapLocationClient(context);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置单次定位
        mLocationOption.setOnceLocation(true);
        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(true);
        //设置定位监听
        mLocationClient.setLocationListener(locationListener);
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        //启动定位
        mLocationClient.startLocation();
    }


    public static float getDistance(double fromLatitude, double fromLongitude, double toLatitude, double toLongitude) {
        DPoint fromDPoint = new DPoint(fromLatitude, fromLongitude);
        DPoint toDPoint = new DPoint(toLatitude, toLongitude);

        float distance = CoordinateConverter.calculateLineDistance(fromDPoint, toDPoint);
        return distance;
    }


    public static void sendYanZhengMa(String mobile, String event, StringCallback stringCallback) {
        OkGo.<String>get(URLs.SEND).params("mobile", mobile)
                .params("event", event).execute(stringCallback);
    }

    public static void checkCaptcha(String mobile, String event, String captcha, StringCallback stringCallback) {
        OkGo.<String>get(URLs.SMS_CHECK)
                .params("mobile", mobile)
                .params("event", event)
                .params("captcha", captcha)
                .execute(stringCallback);
    }

    /**
     * @param time 传入毫秒，如果是1437538047，即10位，则应该乘以1000
     * @return
     */
    public static String getFormatTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if ((time + "").length() == 10) time *= 1000;
        return sdf.format(new Date(time));
    }

    public static String getFormatTime1(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        if ((time + "").length() == 10) time *= 1000;
        return sdf.format(new Date(time));
    }

    public static String getFormatTime2(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if ((time + "").length() == 10) time *= 1000;
        return sdf.format(new Date(time));
    }

    public static String getFormatTime3(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        if ((time + "").length() == 10) time *= 1000;
        return sdf.format(new Date(time));
    }

    /*
     * 将时间转换为时间戳
     */
    public static long dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);

        return date.getTime();
    }

    /* //日期转换为时间戳 */
    public static long timeToStamp(String timers) {
        Date d = new Date();
        long timeStemp = 0;
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            d = sf.parse(timers);// 日期转换为时间戳
        } catch (ParseException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        timeStemp = d.getTime();
        return timeStemp;
    }


    public static void shareUm(final Activity activity, final String titleText, final String content, final String imageUrl, final String url){
        /*增加自定义按钮的分享面板*/
        new ShareAction(activity).setDisplayList(
                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
                )
                .setShareboardclickCallback(new ShareBoardlistener() {
                    @Override
                    public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                        UMWeb web = new UMWeb(url);
                        web.setTitle(titleText);
                        web.setThumb(new UMImage(activity, imageUrl));
                        web.setDescription(content);
                        new ShareAction(activity).withMedia(web )
                                .setPlatform(share_media)
                                .setCallback(new UMShareListener() {
                                    @Override
                                    public void onStart(SHARE_MEDIA share_media) {
                                        LogUtil.d("LoginActivity",  "onStart");
                                    }

                                    @Override
                                    public void onResult(SHARE_MEDIA share_media) {
                                        LogUtil.d("LoginActivity",  "onResult");
                                    }

                                    @Override
                                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                                        LogUtil.d("LoginActivity",  "onError");
                                    }

                                    @Override
                                    public void onCancel(SHARE_MEDIA share_media) {
                                        LogUtil.d("LoginActivity",  "onCancel");
                                    }
                                }).share();
                    }
                }).open();
    }
}



