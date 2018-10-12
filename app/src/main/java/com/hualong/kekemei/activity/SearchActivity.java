package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.IndictorWithNumber;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 搜索结果页
 */
public class SearchActivity extends BaseActivity {
    private static final String EXTRA_KEY_KEYWORD = "keyword";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.searchIndictor)
    IndictorWithNumber searchIndictor;
    @BindView(R.id.searchPage)
    ViewPager searchPager;

    private String[] titleArray = {"全部", "项目", "店面", "美容师"};

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
        IndictorWithNumber.TabModele tabModele = new IndictorWithNumber.TabModele();
        ArrayList<IndictorWithNumber.TabModele.TitleNumber> list = new ArrayList<>();
        for (int i = 0; i < titleArray.length; i++) {
            IndictorWithNumber.TabModele.TitleNumber titleNumber = new IndictorWithNumber.TabModele.TitleNumber();
            titleNumber.title = titleArray[i];
            titleNumber.status = i;
            list.add(titleNumber);
        }
        tabModele.setTitleNumList(list);

        searchPager.setAdapter(new IndictorWithNumber.MyPagerAdapter(getFragmentManager(), tabModele));
        searchIndictor.setViewPager(searchPager, tabModele);
    }
}
