package com.hualong.kekemei.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.BaseBean;
import com.hualong.kekemei.bean.DataBean;
import com.hualong.kekemei.bean.HomeBean;

import java.util.List;

/**
 * Created by peiyangfan on 2018/10/12.
 */

class MyGridAdapter extends BaseQuickAdapter<BaseBean, BaseViewHolder> {
    private Context context;
    private int type;

    public MyGridAdapter(Context context, int type) {
        super(R.layout.huodong_layout);
        this.context = context;

        this.type = type;

    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {
//        switch (type) {
//            case 0:
////                newmemberdata = item.getData().getNewmemberdata();
////                newmemberdata.get()
//                HomeBean.DataBean.NewmemberdataBean item1 = (HomeBean.DataBean.NewmemberdataBean) item;
//                helper.setText(R.id.tv_name,item1.get)
//                break;
//            case 1:
////                hotdata = item.getData().getHotdata();
//                break;
//            case 2:
////                memberdata = item.getData().getMemberdata();
//                break;
//            case 3:
////                specialdata = item.getData().getSpecialdata();
//                break;
//            default:
//
//                break;
//        }



    }
}
