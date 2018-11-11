package com.kekemei.kekemei.activity.splash;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.activity.BaseActivity;
import com.kekemei.kekemei.activity.LoginActivity;
import com.kekemei.kekemei.activity.MainActivity;
import com.kekemei.kekemei.utils.AppUtil;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.SPUtils;
import com.kekemei.kekemei.utils.UserHelp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity implements AMapLocationListener {

    private static final int[] imageList = {R.mipmap.guide_page_01, R.mipmap.guide_page_02, R.mipmap.guide_page_03};
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.btn_home)
    ImageView btnHome;
    @BindView(R.id.activity_guider)
    RelativeLayout activityGuider;


    private List<ImageView> viewList;


    @Override
    protected int setLayoutId() {
        return R.layout.activity_splash;
    }

    public void initData() {

        initList();
        initViewPager();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        } else {
            AppUtil.getUserPoint(this, this);
            Toast.makeText(this, "已开启定位权限", Toast.LENGTH_LONG).show();
        }
    }

    private void initList() {
        viewList = new ArrayList<>();
        int size = imageList.length;
        ImageView imageView = null;
        for (int i = 0; i < size; i++) {
            imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(imageList[i]);
            viewList.add(imageView);
        }

    }

    @OnClick(R.id.btn_home)
    public void onViewClicked() {
        if (UserHelp.getLogin(getBaseContext(),false)) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }
        finish();

    }

    private void initViewPager() {
        viewpager.setAdapter(pagerAdapter);
        viewpager.addOnPageChangeListener(pageChangeListener);
    }

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == imageList.length - 1) {
                btnHome.setVisibility(View.VISIBLE);
            } else {
                btnHome.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }
    };

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                double latitude = aMapLocation.getLatitude();//获取纬度
                double longitude = aMapLocation.getLongitude();//获取经度
                String city = aMapLocation.getCity();
                SPUtils.putString(getBaseContext(), "latitude", latitude + "");
                SPUtils.putString(getBaseContext(), "longitude", longitude + "");
                SPUtils.putString(getBaseContext(), "city", city);
                //                mPoint = new DPoint(latitude,longitude);
                //                loadData();//后续操作

                LogUtil.d("APPLOCALTION  HomeFragment", "LATITUDE : " + latitude + " --  LONGITUDE : " + longitude);
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                LogUtil.d("APPLOCALTION  HomeFragment", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());

            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
