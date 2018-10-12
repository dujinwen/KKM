package com.hualong.kekemei.fragment;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.bean.BaseBean;
import com.hualong.kekemei.bean.HomeBean;
import com.jcloud.image_loader_module.ImageLoaderUtil;

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
        if (type == 0) {
            HomeBean.DataBean.NewmemberdataBean item1 = (HomeBean.DataBean.NewmemberdataBean) item;
            //                setData(item1);
            helper.setText(R.id.tv_name, item1.getName());
            helper.setText(R.id.now_price, item1.getPrice() + "");
            ImageLoaderUtil.getInstance().loadImage(item1.getImage(), R.mipmap.beautician_photo, (ImageView) helper.getView(R.id.iv_beautician_photo));
            //        helper.setText(R.id.tv_renshu,item1.getPrice()+"");
            return;
        }


        if (type == 1) {

            HomeBean.DataBean.HotdataBean item2 = (HomeBean.DataBean.HotdataBean) item;
            //                setData(item1);
            helper.setText(R.id.tv_name, item2.getName());
            helper.setText(R.id.now_price, item2.getPrice() + "");
            ImageLoaderUtil.getInstance().loadImage(item2.getImage(), R.mipmap.beautician_photo, (ImageView) helper.getView(R.id.iv_beautician_photo));

            return;
        }
        if (type == 2) {
            HomeBean.DataBean.MemberdataBean item3 = (HomeBean.DataBean.MemberdataBean) item;
            //                setData(item1);
            helper.setText(R.id.tv_name, item3.getName());
            helper.setText(R.id.now_price, item3.getPrice() + "");
            ImageLoaderUtil.getInstance().loadImage(item3.getImage(), R.mipmap.beautician_photo, (ImageView) helper.getView(R.id.iv_beautician_photo));
            return;
        }
        if (type == 3) {
            HomeBean.DataBean.SpecialdataBean item4 = (HomeBean.DataBean.SpecialdataBean) item;
            //                setData(item1);
            helper.setText(R.id.tv_name, item4.getName());
            helper.setText(R.id.now_price, item4.getPrice() + "");
            ImageLoaderUtil.getInstance().loadImage(item4.getImage(), R.mipmap.beautician_photo, (ImageView) helper.getView(R.id.iv_beautician_photo));
            return;
        }

    }

}
