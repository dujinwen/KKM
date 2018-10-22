package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.hualong.kekemei.R;
import com.hualong.kekemei.utills.LogUtil;
import com.hualong.kekemei.utills.StringUtils;
import com.hualong.kekemei.fragment.SearchAllFragment;
import com.hualong.kekemei.fragment.SearchBeauticianFragment;
import com.hualong.kekemei.fragment.SearchIPage;
import com.hualong.kekemei.fragment.SearchProjectFragment;
import com.hualong.kekemei.fragment.SearchTradeNameFragment;
import com.hualong.kekemei.view.PagerSlidingTabStrip;
import com.hualong.kekemei.view.XEditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 搜索结果页
 */
public class SearchActivity extends BaseActivity implements TextWatcher {
    private static final String TAG = SearchActivity.class.getSimpleName();
    public static final String EXTRA_KEY_KEYWORD = "keyword";
    private int mCurrentTab = 0;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.editTextSearch)
    XEditText editTextSearch;
    @BindView(R.id.txtSearch)
    TextView txtSearch;
    @BindView(R.id.searchIndictor)
    PagerSlidingTabStrip searchIndictor;
    @BindView(R.id.searchPage)
    ViewPager searchPager;
    private String keyWord = "";

    public static void start(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        editTextSearch.setFocusable(true);
        editTextSearch.setFocusableInTouchMode(true);
        editTextSearch.requestFocus();
        moveEditCursor();
        editTextSearch.addTextChangedListener(this);
        editTextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    editTextSearch.clearFocus();
                }
                return false;
            }
        });
        SearchPagerAdapter searchPagerAdapter = new SearchPagerAdapter(this, getSupportFragmentManager());
        searchPagerAdapter.addFragment(SearchAllFragment.newInstance(keyWord));
        searchPagerAdapter.addFragment(SearchProjectFragment.newInstance(keyWord));
        searchPagerAdapter.addFragment(SearchTradeNameFragment.newInstance(keyWord));
        searchPagerAdapter.addFragment(SearchBeauticianFragment.newInstance(keyWord));

        searchPager.setAdapter(searchPagerAdapter);
        searchIndictor.setViewPager(searchPager);

        searchPager.setOffscreenPageLimit(searchPagerAdapter.getCount() - 1);

        searchPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                keyWord = editTextSearch.getText().toString();
                mCurrentTab = position;
                searchPager.setCurrentItem(mCurrentTab, false);
                setOnEnter(mCurrentTab, keyWord);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        txtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyWord = editTextSearch.getText().toString();
                searchPager.setCurrentItem(1);
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    private class SearchPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();
        private String[] titles;


        public SearchPagerAdapter(Context context, FragmentManager fm) {
            super(fm);
            titles = context.getResources().getStringArray(R.array.search_tabs);
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

    private void moveEditCursor() {
        CharSequence s = editTextSearch.getText();
        if (StringUtils.isNotEmpty(s)) {
            Spannable spanText = (Spannable) s;
            Selection.setSelection(spanText, s.length());
        }
    }

    private void setOnEnter(int position, String keyWord) {
        LogUtil.d(TAG, "setOnEnter, position is " + position);
        Fragment fragment = getCurrentFragment(position);
        if (fragment == null) {
            LogUtil.w(TAG, "current fragment is null");
            return;
        }
        if (fragment instanceof SearchIPage) {
            SearchIPage page = (SearchIPage) fragment;
            page.onEnter(keyWord);
        }
    }

    private void setOnLeave(int position) {
        LogUtil.d(TAG, "setOnLeave, position is " + position);
        Fragment fragment = getCurrentFragment(position);
        if (fragment == null) {
            LogUtil.w(TAG, "current fragment is null");
            return;
        }
        if (fragment instanceof SearchIPage) {
            SearchIPage page = (SearchIPage) fragment;
            page.onLeave();
        }
    }

    @Nullable
    private Fragment getCurrentFragment(int position) {
        try {
            if (searchPager == null || searchPager.getAdapter() == null) {
                return null;
            }
            SearchPagerAdapter searchAdapter = (SearchPagerAdapter) searchPager.getAdapter();
            return searchAdapter.getItem(position);
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage(), e);
            return null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(TAG, "onResume, mCurrentTab is " + mCurrentTab);
        if (editTextSearch != null) {
            keyWord = editTextSearch.getText().toString();
        }
        setOnEnter(mCurrentTab, keyWord);
    }

    @Override
    protected void onPause() {
        LogUtil.d(TAG, "onPause, mCurrentTab is " + mCurrentTab);
        setOnLeave(mCurrentTab);
        super.onPause();
    }

}
