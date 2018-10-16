package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hualong.kekemei.R;
import com.hualong.kekemei.fragment.ShopDetailFragment;
import com.hualong.kekemei.fragment.ShopEvaluateFragment;
import com.hualong.kekemei.fragment.ShopHotProjectFragment;
import com.hualong.kekemei.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 设置页面
 */
public class ShopActivity extends BaseActivity {
    private static final String EXTRA_KEY_SHOP_NAME = "shopName";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.pageIndictor)
    PagerSlidingTabStrip pageIndictor;
    @BindView(R.id.pager)
    ViewPager pager;

    public static void start(Context context, String shopName) {
        Intent intent = new Intent(context, ShopActivity.class);
        intent.putExtra(EXTRA_KEY_SHOP_NAME, shopName);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_shop;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        TextView tv_title = toolbar.findViewById(R.id.tv_title);
        String shopName = super.getStringExtraSecure(EXTRA_KEY_SHOP_NAME);
        tv_title.setText(shopName);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ShopPageAdapter shopPagerAdapter = new ShopPageAdapter(this, getSupportFragmentManager());
        shopPagerAdapter.addFragment(ShopDetailFragment.newInstance());
        shopPagerAdapter.addFragment(ShopHotProjectFragment.newInstance());
        shopPagerAdapter.addFragment(ShopEvaluateFragment.newInstance());

        pager.setAdapter(shopPagerAdapter);
        pageIndictor.setViewPager(pager);
    }

    private class ShopPageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();
        private String[] titles;


        public ShopPageAdapter(Context context, FragmentManager fm) {
            super(fm);
            titles = context.getResources().getStringArray(R.array.shop_tabs);
        }

        public void addFragment(Fragment fragment) {
            fragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments == null || fragments.size() == 0
                    ? null
                    : fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments == null
                    ? 0
                    : fragments.size();
        }

        /**
         * 必须重写，否则PagerSlidingTabStrip报错
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
