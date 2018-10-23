package com.hualong.kekemei.fragment;

import android.Manifest;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.google.android.flexbox.FlexboxLayout;
import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.activity.MeiRongShiActivity;
import com.hualong.kekemei.activity.PayActivity;
import com.hualong.kekemei.activity.SearchActivity;
import com.hualong.kekemei.activity.ShopListActivity;
import com.hualong.kekemei.adapter.DAVipAdapter;
import com.hualong.kekemei.adapter.EvaluateListAdapter;
import com.hualong.kekemei.adapter.MeiRongShiAdapter;
import com.hualong.kekemei.adapter.MyGridAdapter;
import com.hualong.kekemei.bean.CommentTagsBean;
import com.hualong.kekemei.bean.HomeBean;
import com.hualong.kekemei.utils.AppUtil;
import com.hualong.kekemei.utils.CollectionUtils;
import com.hualong.kekemei.utils.LogUtil;
import com.hualong.kekemei.utils.SPUtils;
import com.hualong.kekemei.utils.URLs;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.stx.xhb.xbanner.XBanner;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class HomeFragment extends Fragment implements AMapLocationListener {


    @BindView(R.id.iv_place)
    ImageView ivPlace;
    @BindView(R.id.place)
    TextView place;
    @BindView(R.id.ll_place)
    RelativeLayout llPlace;
    @BindView(R.id.text_msg)
    TextView textMsg;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.id_msg)
    LinearLayout idMsg;
    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.rv_meirongshi)
    RecyclerView rvMeirongshi;
    @BindView(R.id.rv_davip_kkm)
    RecyclerView rvDavipKkm;
    @BindView(R.id.iv_xinrenzhuanqu)
    ImageView ivXinrenzhuanqu;
    @BindView(R.id.rv_xinren)
    RecyclerView rvXinren;
    @BindView(R.id.iv_huiyuanzhuanqu)
    ImageView ivHuiyuanzhuanqu;
    @BindView(R.id.rv_huiyuan)
    RecyclerView rvHuiyuan;
    @BindView(R.id.iv_zuixinxiangmu)
    ImageView ivZuixinxiangmu;
    @BindView(R.id.rv_zuixinxiangmu)
    RecyclerView rvZuixinxiangmu;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.iv_remenxiangmu)
    ImageView ivRemenxiangmu;
    @BindView(R.id.rv_remenxiangmu)
    RecyclerView rvRemenxiangmu;
    @BindView(R.id.fujin_meirongshi)
    LinearLayout fujinMeirongshi;
    @BindView(R.id.fujin_dianpu)
    LinearLayout fujinDianpu;
    @BindView(R.id.ll_meirong)
    LinearLayout llMeirong;
    @BindView(R.id.ll_meiti)
    LinearLayout llMeiti;
    @BindView(R.id.ll_yangsheng)
    LinearLayout llYangsheng;
    @BindView(R.id.ll_qita)
    LinearLayout llQita;
    @BindView(R.id.userCommentNum)
    TextView userCommentNum;
    /*@BindView(R.id.kehupingjia)
    LinearLayout kehupingjia;*/
    @BindView(R.id.commentTabAll)
    TextView commentTabAll;
    @BindView(R.id.commentTabNew)
    TextView commentTabNew;
    @BindView(R.id.commentTabPhoto)
    TextView commentTabPhoto;
    @BindView(R.id.commentTagFlowLayout)
    FlexboxLayout commentTagFlowLayout;
    @BindView(R.id.rvCommentList)
    RecyclerView rvCommentList;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        try {
//            Thread.sleep(5000);
//            initData("", "");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        unbinder = ButterKnife.bind(this, view);

        //        llSearch.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //
        //            }
        //        });

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        } else {
            AppUtil.getUserPoint(getActivity(), this);
            Toast.makeText(getActivity(), "已开启定位权限", Toast.LENGTH_LONG).show();
        }
        commentTabAll.setSelected(true);
        initCommentTags();
        return view;
    }


    private void initData(String latitude, String longitude) {
        OkGo.<String>post(URLs.HOME_URL).params("longitude", 116.4072154982)
                .params("latitude", 39.9047253699).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.d("APPLOCALTION", response.toString());
                Gson gson = new Gson();
                HomeBean homeBean = gson.fromJson(response.body(), HomeBean.class);
                xbanner.setData(homeBean.getData().getBanneradv(), null);
                initBanner();


                LinearLayoutManager layout_meirongshi = new LinearLayoutManager(getActivity().getBaseContext());
                layout_meirongshi.setOrientation(LinearLayoutManager.HORIZONTAL);
                rvMeirongshi.setHasFixedSize(true);
                rvMeirongshi.setNestedScrollingEnabled(false);
                rvMeirongshi.setLayoutManager(layout_meirongshi);
                MeiRongShiAdapter adapter = new MeiRongShiAdapter(getActivity());
                rvMeirongshi.setAdapter(adapter);
                adapter.addData(homeBean.getData().getBeautician());

                LinearLayoutManager layout_vip = new LinearLayoutManager(getActivity().getBaseContext());
                layout_vip.setOrientation(LinearLayoutManager.HORIZONTAL);
                rvDavipKkm.setHasFixedSize(true);
                rvDavipKkm.setNestedScrollingEnabled(false);
                rvDavipKkm.setLayoutManager(layout_vip);
                DAVipAdapter adapter_vip = new DAVipAdapter(getActivity());
                rvDavipKkm.setAdapter(adapter_vip);
                adapter_vip.addData(homeBean.getData().getShop());

                rvXinren.setLayoutManager(new GridLayoutManager(getActivity().getBaseContext(), 2));
                MyGridAdapter adapter1 = new MyGridAdapter(getActivity().getBaseContext(), MyGridAdapter.NewmemberdataBean);
                rvXinren.setHasFixedSize(true);
                rvXinren.setNestedScrollingEnabled(false);
                rvXinren.setAdapter(adapter1);
                adapter1.addData(homeBean.getData().getNewmemberdata());


                rvRemenxiangmu.setLayoutManager(new GridLayoutManager(getActivity().getBaseContext(), 2));
                MyGridAdapter adapter4 = new MyGridAdapter(getActivity().getBaseContext(), MyGridAdapter.HotdataBean);
                rvRemenxiangmu.setHasFixedSize(true);
                rvRemenxiangmu.setNestedScrollingEnabled(false);
                rvRemenxiangmu.setAdapter(adapter4);
                adapter4.addData(homeBean.getData().getHotdata());


                rvHuiyuan.setLayoutManager(new GridLayoutManager(getActivity().getBaseContext(), 2));
                MyGridAdapter adapter2 = new MyGridAdapter(getActivity().getBaseContext(), MyGridAdapter.MemberdataBean);
                rvHuiyuan.setHasFixedSize(true);
                rvHuiyuan.setNestedScrollingEnabled(false);
                rvHuiyuan.setAdapter(adapter2);
                adapter2.addData(homeBean.getData().getMemberdata());


                rvZuixinxiangmu.setLayoutManager(new GridLayoutManager(getActivity().getBaseContext(), 2));
                MyGridAdapter adapter3 = new MyGridAdapter(getActivity().getBaseContext(), MyGridAdapter.SpecialdataBean);
                rvZuixinxiangmu.setHasFixedSize(true);
                rvZuixinxiangmu.setNestedScrollingEnabled(false);
                rvZuixinxiangmu.setAdapter(adapter3);
                adapter3.addData(homeBean.getData().getSpecialdata());

                rvCommentList.setLayoutManager(new LinearLayoutManager(getActivity()));
                EvaluateListAdapter commentAdapter = new EvaluateListAdapter(getActivity(), false);
                rvCommentList.setHasFixedSize(true);
                rvCommentList.setNestedScrollingEnabled(false);
                rvCommentList.setAdapter(commentAdapter);
                userCommentNum.setText(getActivity().getString(R.string.home_comment_num_format, homeBean.getData().getCommentdata().size()));
                commentAdapter.addData(homeBean.getData().getCommentdata());

            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                LogUtil.d("APPLOCALTION", response.toString());
            }
        });
    }

    private void initCommentTags() {
        OkGo.<String>post(URLs.COMMENT_TAG)
                .tag(this)
                .params("type", "1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUtil.e("comment", "body:" + response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            Object msg = jsonObject.opt("msg");
                            if (msg.equals("暂无数据")) {
                                fillTags(null);
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Gson gson = new Gson();
                        CommentTagsBean commentTagsBean = gson.fromJson(response.body(), CommentTagsBean.class);
                        fillTags(commentTagsBean.getData());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        LogUtil.e("TAG", response.message());
                        fillTags(null);
                    }
                });
    }

    /**
     * 填充评价标识
     *
     * @param result
     */
    private void fillTags(final List<String> result) {
        if (CollectionUtils.isEmpty(result)) {
            return;
        }
        commentTagFlowLayout.removeAllViews();
        for (int i = 0; i < result.size(); i++) {
            final TextView txt = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.item_comment_tag_layout, commentTagFlowLayout, false);
            if (!AppUtil.isEmptyString(result.get(i))) {
                txt.setText(result.get(i));
                txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String content = txt.getText().toString();
                    }
                });
                commentTagFlowLayout.addView(txt);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        xbanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        xbanner.stopAutoPlay();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    /**
     * 初始化XBanner
     */
    private void initBanner() {
        //设置广告图片点击事件
        xbanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                //                Toast.makeText(MainActivity.this, "点击了第" + (position+1) + "图片", Toast.LENGTH_SHORT).show();
            }
        });
        //加载广告图片
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                //在此处使用图片加载框架加载图片，demo中使用glide加载，可替换成自己项目中的图片加载框架
                //                Glide.with(MainActivity.this).load(((AdvertiseEntity.OthersBean) model).getThumbnail()).placeholder(R.drawable.default_image).error(R.drawable.default_image).into((ImageView) view);
                ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + ((HomeBean.DataBean.BanneradvBean) model).getImage(), (ImageView) view);
            }
        });
    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                double latitude = amapLocation.getLatitude();//获取纬度
                double longitude = amapLocation.getLongitude();//获取经度
                SPUtils.putString(getActivity(), "latitude", latitude + "");
                SPUtils.putString(getActivity(), "longitude", longitude + "");
                //                mPoint = new DPoint(latitude,longitude);
                //                loadData();//后续操作

                initData("39.9047253699", "116.4072154982");
                LogUtil.d("APPLOCALTION  HomeFragment", "LATITUDE : " + latitude + " --  LONGITUDE : " + longitude);
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                LogUtil.d("APPLOCALTION  HomeFragment", "location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());

            }
        }

    }

    @OnClick({R.id.ll_meirong, R.id.ll_meiti, R.id.ll_yangsheng, R.id.ll_qita, R.id.commentTabAll,
            R.id.commentTabNew, R.id.commentTabPhoto, R.id.fujin_meirongshi, R.id.fujin_dianpu, R.id.ll_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_meirong:

                break;
            case R.id.ll_meiti:
                break;
            case R.id.ll_yangsheng:
                break;
            case R.id.ll_qita:
                break;
            case R.id.commentTabAll:
                commentTabAll.setSelected(true);
                commentTabNew.setSelected(false);
                commentTabPhoto.setSelected(false);

                setPingJiaData(1);
                break;
            case R.id.commentTabNew:
                commentTabAll.setSelected(false);
                commentTabNew.setSelected(true);
                commentTabPhoto.setSelected(false);

                setPingJiaData(2);
                break;
            case R.id.commentTabPhoto:
                commentTabAll.setSelected(false);
                commentTabNew.setSelected(false);
                commentTabPhoto.setSelected(true);

                setPingJiaData(3);
                break;
            case R.id.ll_search:
                SearchActivity.start(getActivity());
                break;
            case R.id.fujin_dianpu:
//                ShopActivity.start(getActivity(),"克克美-西直门店");
                ShopListActivity.start(getActivity());
                break;
            case R.id.fujin_meirongshi:
                MeiRongShiActivity.start(getActivity());
                break;
        }
    }

    private void setPingJiaData(int i) {

    }

}
