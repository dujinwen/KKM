package com.hualong.kekemei.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hualong.kekemei.R;
import com.hualong.kekemei.activity.OrderListActivity;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class MessageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        getActivity().startActivity(new Intent(getActivity(), OrderListActivity.class));
//        getActivity().finish();
        return inflater.inflate(R.layout.fragment_message, container, false);
    }



//    @Override
//    public void onStart() {
//        super.onStart();
//        getActivity().startActivity(new Intent(getActivity(), OrderListActivity.class));
//    }


}
