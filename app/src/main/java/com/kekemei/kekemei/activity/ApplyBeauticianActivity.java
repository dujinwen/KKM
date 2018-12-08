package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kekemei.kekemei.R;
import com.kekemei.kekemei.fragment.Fragment1;
import com.kekemei.kekemei.fragment.Fragment2;
import com.kekemei.kekemei.fragment.Fragment3;
import com.kekemei.kekemei.fragment.Fragment4;
import com.kekemei.kekemei.fragment.Fragment5;

import butterknife.BindView;


public class ApplyBeauticianActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl_sq)
    FrameLayout flSq;

    private Fragment currentFragment = new Fragment();
    private Fragment1 first = new Fragment1();
    private Fragment2 second = new Fragment2();
    private Fragment3 third = new Fragment3();
    private Fragment4 four = new Fragment4();
    private Fragment5 five = new Fragment5();

    public static void start(Context context, int code) {
        Intent intent = new Intent(context, ApplyBeauticianActivity.class);
        intent.putExtra("code", code);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_apply_beautician;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        tvTitle.setText("申请美容师资格");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTag != 0) {
                    isTag--;
                    Toast.makeText(getApplicationContext(), "isTag" + isTag, Toast.LENGTH_SHORT).show();
                    if (isTag == 1) {
                        switchFragment(second).commit();
                    } else {
                        switchFragment(first).commit();
                    }
                } else {
                    finish();
                }
            }
        });
        Intent intent = getIntent();
        int code = intent.getIntExtra("code", -1);
        switch (code) {
            case 1://登陆成功
                switchFragment(five).commit();
                break;
            case 2://正在审核
                switchFragment(second).commit();
                break;
            case 3://认证失败
                switchFragment(four).commit();
                break;
            case 4://未认证
                switchFragment(first).commit();
                break;
        }


        first.setOnButtonClick(new Fragment1.OnButtonClick() {
            @Override
            public void onClick(View view) {
                switchFragment(second).commit();
                isTag++;
            }
        });
        second.setOnButtonClick(new Fragment2.OnButtonClick() {
            @Override
            public void onClick(View view) {
                switchFragment(third).commit();
                isTag++;
            }
        });

        four.setOnButtonClick(new Fragment4.OnButtonClick() {
            @Override
            public void onClick(View view) {
                switchFragment(first).commit();
                isTag = 0;
            }
        });

    }

    private int isTag = 0;

    private FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().
                beginTransaction();
        if (!targetFragment.isAdded()) { //第一次使用switchFragment()时currentFragment为null，所以要判断一下


            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.fl_sq, targetFragment, targetFragment.getClass().getName());
        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        return transaction;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (isTag != 0) {
            isTag--;
            Toast.makeText(getApplicationContext(), "isTag" + isTag, Toast.LENGTH_SHORT).show();
            if (isTag == 1) {
                switchFragment(second).commit();
            } else {
                switchFragment(first).commit();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
