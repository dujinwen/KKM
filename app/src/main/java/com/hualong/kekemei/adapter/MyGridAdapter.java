package com.hualong.kekemei.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.URLs;
import com.hualong.kekemei.bean.BaseBean;
import com.hualong.kekemei.bean.ForYouBean;
import com.hualong.kekemei.bean.HomeBean;
import com.hualong.kekemei.bean.HotdataBean;
import com.jcloud.image_loader_module.ImageLoaderUtil;

/**
 * Created by peiyangfan on 2018/10/12.
 */

public class MyGridAdapter extends BaseQuickAdapter<BaseBean, BaseViewHolder> {
    public static final int PERSON_TUI_JIAN = 5;
    private Context context;
    private int type;

    public static final int NewmemberdataBean = 0;
    public static final int HotdataBean= 1;
    public static final int MemberdataBean = 2;
    public static final int SpecialdataBean = 3;
    public static final int ORDER_HOT_BEAN = 4;

    public MyGridAdapter(Context context, int type) {
        super(R.layout.huodong_layout);
        this.context = context;

        this.type = type;

    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean item) {
        if (type == NewmemberdataBean) {
            HomeBean.DataBean.NewmemberdataBean item1 = (HomeBean.DataBean.NewmemberdataBean) item;
            //                setData(item1);
            helper.setText(R.id.tv_name, item1.getName());
            helper.setText(R.id.now_price, item1.getPrice() + "");
            ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL+item1.getImage(), R.mipmap.beautician_photo, (ImageView) helper.getView(R.id.iv_beautician_photo));
            //        helper.setText(R.id.tv_renshu,item1.getPrice()+"");
            return;
        }


        if (type == HotdataBean) {

            HotdataBean item2 = (HotdataBean) item;
            //                setData(item1);
            helper.setText(R.id.tv_name, item2.getName());
            helper.setText(R.id.now_price, item2.getPrice() + "");
            ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL+item2.getImage(), R.mipmap.beautician_photo, (ImageView) helper.getView(R.id.iv_beautician_photo));

            return;
        }
        if (type == MemberdataBean) {
            HomeBean.DataBean.MemberdataBean item3 = (HomeBean.DataBean.MemberdataBean) item;
            //                setData(item1);
            helper.setText(R.id.tv_name, item3.getName());
            helper.setText(R.id.now_price, item3.getPrice() + "");
            ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL+item3.getImage(), R.mipmap.beautician_photo, (ImageView) helper.getView(R.id.iv_beautician_photo));
            return;
        }
        if (type == SpecialdataBean) {
            HomeBean.DataBean.SpecialdataBean item4 = (HomeBean.DataBean.SpecialdataBean) item;
            //                setData(item1);
            helper.setText(R.id.tv_name, item4.getName());
            helper.setText(R.id.now_price, item4.getPrice() + "");
            ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL+item4.getImage(), R.mipmap.beautician_photo, (ImageView) helper.getView(R.id.iv_beautician_photo));
            return;
        }
        if (type == ORDER_HOT_BEAN) {
//            HomeBean.DataBean.SpecialdataBean item4 = (HomeBean.DataBean.SpecialdataBean) item;
//            //                setData(item1);
//            helper.setText(R.id.tv_name, item4.getName());
//            helper.setText(R.id.now_price, item4.getPrice() + "");
//            ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL+item4.getImage(), R.mipmap.beautician_photo, (ImageView) helper.getView(R.id.iv_beautician_photo));
            return;
        }
        if (type == PERSON_TUI_JIAN){
            ForYouBean.DataBean item4 = (ForYouBean.DataBean) item;
            //                setData(item1);
            helper.setText(R.id.tv_name, item4.getName());
            helper.setText(R.id.now_price, item4.getPrice() + "");
            ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL+item4.getImage(), R.mipmap.beautician_photo, (ImageView) helper.getView(R.id.iv_beautician_photo));
            return;
        }

    }

}
