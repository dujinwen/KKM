package com.hualong.kekemei.fragment.base;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hualong.kekemei.view.LoadingDialog;


/**
 * Created by yzd on 2017/12/14 0014.
 */

public abstract class BaseFragment extends Fragment {
    protected boolean onFragmentDestroy = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutId() != 0) {
            return inflater.inflate(getLayoutId(), null);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewsAndEvents(view);
    }

    protected abstract int getLayoutId();

    protected abstract void initViewsAndEvents(View view);

    protected void visibleView(View view) {
        if (null != view)
            view.setVisibility(View.VISIBLE);
    }

    protected void goneView(View view) {
        if (null != view)
            view.setVisibility(View.GONE);
    }

    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;
    private boolean isPrepared;

    private LoadingDialog mPrsDialog;

    protected void showLoadingDialogs(String msg) {
        if (null != mPrsDialog) {

            if (mPrsDialog.isSameMsg(msg)) {
                if (mPrsDialog.isShowing())
                    return;
                else
                    mPrsDialog.show();
            } else {
                mPrsDialog.close();
                mPrsDialog = null;
            }
        }
        if (null == mPrsDialog) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mPrsDialog = new LoadingDialog(getContext(),
                        TextUtils.isEmpty(msg) ? LoadingDialog.DEFULT_MSG : msg, false);
            }
            mPrsDialog.show();
        }
    }

    protected void dismissLoadingDialog() {
        if (null != mPrsDialog) {
            mPrsDialog.close();
            mPrsDialog = null;
        }
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
    }

    private synchronized void initPrepare() {
        if (isPrepared) {
            onFirstUserVisible();
        } else {
            isPrepared = true;
        }
    }


    //配合ViewPager ,FragmentPagerAdapter时候才会调用
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                initPrepare();
            } else {
                onUserVisible();
            }
        } else {
            if (isFirstInvisible) {
                isFirstInvisible = false;
                onFirstUserInvisible();
            } else {
                onUserInvisible();
            }
        }
    }

    //配合ViewPager ,FragmentPagerAdapter时候才会调用
    protected void onFirstUserVisible() {
    }

    //配合ViewPager ,FragmentPagerAdapter时候才会调用
    protected void onUserVisible() {
    }

    //配合ViewPager ,FragmentPagerAdapter时候才会调用
    private void onFirstUserInvisible() {
    }

    //配合ViewPager ,FragmentPagerAdapter时候才会调用
    protected void onUserInvisible() {
    }

    @Override
    public void onDestroy() {
        onFragmentDestroy = true;
        super.onDestroy();
    }
}
