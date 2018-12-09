package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.WithDrawBean;
import com.kekemei.kekemei.utils.CollectionUtils;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.StringUtils;
import com.kekemei.kekemei.utils.ToastUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.AddCardDialog;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.stx.xhb.xbanner.XBanner;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 提现
 */
public class WithDrawActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.withDrawMoney)
    EditText withDrawMoney;
    @BindView(R.id.canWithDrawMoney)
    EditText canWithDrawMoney;
    @BindView(R.id.confirm)
    TextView confirm;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;
    @BindView(R.id.contentLayout)
    LinearLayout contentLayout;
    private WithDrawBean withDrawBean;

    public static void start(Context context) {
        Intent intent = new Intent(context, WithDrawActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_with_draw;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        tv_title.setText("提现");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
        multipleStatusView.showOutContentView(contentLayout);

        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                WithDrawBean.BankBean bankBean = (WithDrawBean.BankBean) model;
                if (bankBean != null && !bankBean.isNeedAddCard()) {
                    ImageView deleteCard = view.findViewById(R.id.deleteCard);
                    TextView cardName = view.findViewById(R.id.cardName);
                    TextView cardType = view.findViewById(R.id.cardType);
                    TextView isDefault = view.findViewById(R.id.isDefault);
                    TextView cardNumber = view.findViewById(R.id.cardNumber);
                    if (StringUtils.isNotEmpty(bankBean.getOpeningbank())) {
                        cardName.setText(bankBean.getOpeningbank());
                    }
                    if (StringUtils.isNotEmpty(bankBean.getCardnumber())) {
                        cardNumber.setText(bankBean.getCardnumber());
                    }
                } else {
                    View viewById = view.findViewById(R.id.addCardLayout);
                    viewById.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            new AddCardDialog(WithDrawActivity.this).show();
                        }
                    });
                }
            }
        });

        withDrawMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNotEmpty(editable.toString()) && (Float.valueOf(editable.toString()) > 0)) {
                    confirm.setSelected(true);
                } else {
                    confirm.setSelected(false);
                }
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        multipleStatusView.showLoading();
        long userId = UserHelp.getUserId(this);
        if (userId == -1L) {
            LoginActivity.start(this);
            return;
        }
        OkGo.<String>get(URLs.WANT_CASH).params("buautician_id", userId).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    String data = jsonObject.optString("data");
                    if (msg.equals("暂无数据") || StringUtils.isEmpty(data)) {
                        multipleStatusView.showError();
                        return;
                    }
                    multipleStatusView.showOutContentView(contentLayout);
                    Gson gson = new Gson();
                    withDrawBean = gson.fromJson(data, WithDrawBean.class);
                    canWithDrawMoney.setText(withDrawBean.getAccount() + "元");
                    if (CollectionUtils.isEmpty(withDrawBean.getBank())) {
                        List<WithDrawBean.BankBean> bankBeanList = new ArrayList<>();
                        WithDrawBean.BankBean bankBean = new WithDrawBean.BankBean();
                        bankBean.setNeedAddCard(true);
                        bankBeanList.add(bankBean);
                        xbanner.setData(R.layout.layout_no_bank_banner_item, bankBeanList, null);
                    } else {
                        xbanner.setData(R.layout.layout_bank_banner_item, withDrawBean.getBank(), null);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Response<String> response) {
                LogUtil.e("TAG", response.message());
                multipleStatusView.showError();
            }
        });
    }

    @OnClick(R.id.confirm)
    public void onClick(View view) {
        if (withDrawBean == null)
            return;
        if (CollectionUtils.isEmpty(withDrawBean.getBank())) {
            ToastUtil.showToastMsg(this, "请添加银行卡");
            return;
        }
        if (withDrawBean.getAccount() == 0) {
            ToastUtil.showToastMsg(this, "可提现金额为" + withDrawBean.getAccount());
            return;
        }
        String account = withDrawMoney.getText().toString();
        String[] money = account.split("元");
        if (StringUtils.isEmpty(money[0])) {
            ToastUtil.showToastMsg(this, "请输入提现金额");
            return;
        }
        int currentItem = xbanner.getViewPager().getCurrentItem();
        WithDrawBean.BankBean bankBean = withDrawBean.getBank().get(currentItem);
        OkGo.<String>get(URLs.WITH_DRAW).params("beautician_id", UserHelp.getUserId(this))
                .params("accountname", bankBean.getAccountname()).params("cardnumber", bankBean.getCardnumber())
                .params("openingbank", bankBean.getOpeningbank())
                .params("account", money[0]).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    ToastUtil.showToastMsg(WithDrawActivity.this, msg.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Response<String> response) {
                LogUtil.e("TAG", response.message());
                ToastUtil.showToastMsg(WithDrawActivity.this, "提现失败");
            }
        });
    }
}
