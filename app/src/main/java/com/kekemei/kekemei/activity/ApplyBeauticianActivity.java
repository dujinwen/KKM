package com.kekemei.kekemei.activity;

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

import butterknife.BindView;
import butterknife.ButterKnife;


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
    ;
    private Fragment1 first = new Fragment1();
    private Fragment2 second = new Fragment2();
    private Fragment3 third = new Fragment3();

    @Override
    protected int setLayoutId() {
        return R.layout.activity_apply_beautician;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
                    Toast.makeText(getApplicationContext(),"isTag"+isTag,Toast.LENGTH_SHORT).show();
                    if (isTag == 1) {
                        switchFragment(second).commit();
                    }else {
                        switchFragment(first).commit();
                    }
                } else {
                    finish();
                }
            }
        });

        switchFragment(first).commit();

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

    }

    private int isTag = 0;

//    @OnClick(R.id.btn_next)
//    public void onViewClicked() {
//        isTag++;
//        if (isTag == 1) {
//            switchFragment(second).commit();
//        } else if (isTag == 2) {
//            switchFragment(third).commit();
//        }
//        Toast.makeText(getApplicationContext(),"isTag"+isTag,Toast.LENGTH_SHORT).show();
//    }


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
            Toast.makeText(getApplicationContext(),"isTag"+isTag,Toast.LENGTH_SHORT).show();
            if (isTag == 1) {
                switchFragment(second).commit();
            }else {
                switchFragment(first).commit();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        // 2、在Activity中的onActivityResult()方法里与LQRPhotoSelectUtils关联
////        mLqrPhotoSelectUtils.attachToActivityForResult(requestCode, resultCode, data);
//       first.onActivityResult(requestCode, resultCode, data);
//    }
}
