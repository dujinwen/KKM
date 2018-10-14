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

import com.hualong.kekemei.R;
import com.hualong.kekemei.fragment.SearchAllFragment;
import com.hualong.kekemei.fragment.SearchBeauticianFragment;
import com.hualong.kekemei.fragment.SearchProjectFragment;
import com.hualong.kekemei.fragment.SearchTradeNameFragment;
import com.hualong.kekemei.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 搜索结果页
 */
public class SearchActivity extends BaseActivity {
    private static final String EXTRA_KEY_KEYWORD = "keyword";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.searchIndictor)
    PagerSlidingTabStrip searchIndictor;
    @BindView(R.id.searchPage)
    ViewPager searchPager;


    private String[] titleArray = {"全  部", "项  目", "店  面", "美容师"};

    public static void start(Context context, String keyWord) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra(EXTRA_KEY_KEYWORD, keyWord);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // 调用getIntent api得不到，所以先调用setIntent，然后再调用getIntent api即可；
        setIntent(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        SearchPagerAdapter searchPagerAdapter = new SearchPagerAdapter(getSupportFragmentManager(), titleArray);
        searchPagerAdapter.addFragment(SearchAllFragment.newInstance());
        searchPagerAdapter.addFragment(SearchProjectFragment.newInstance());
        searchPagerAdapter.addFragment(SearchBeauticianFragment.newInstance());
        searchPagerAdapter.addFragment(SearchTradeNameFragment.newInstance());

        searchPager.setAdapter(searchPagerAdapter);
        searchIndictor.setViewPager(searchPager);
    }

    private class SearchPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();
        private String[] titles;


        public SearchPagerAdapter(FragmentManager fm, String[] titleArray) {
            super(fm);
            titles = titleArray;
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
