package com.kekemei.kekemei.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.activity.BaseActivity;
import com.kekemei.kekemei.adapter.GridImageAdapter;
import com.kekemei.kekemei.bean.CommentTagsBean;
import com.kekemei.kekemei.manager.AppFolderManager;
import com.kekemei.kekemei.utils.AppUtil;
import com.kekemei.kekemei.utils.CollectionUtils;
import com.kekemei.kekemei.utils.ImageCompressUtil;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.ToastUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.view.LoadingDialog;
import com.kekemei.kekemei.view.NoScrollGridView;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 评价
 */
public class AddCommentActivity extends BaseActivity {
    private static final String TAG = AddCommentActivity.class.getSimpleName();
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.submitComment)
    TextView submitComment;

    @BindView(R.id.etCommentContent)
    EditText etCommentContent;

    @BindView(R.id.commentTagFlowLayout)
    FlexboxLayout commentTagFlowLayout;

    @BindView(R.id.commentImages)
    NoScrollGridView commentImages;

    private GridImageAdapter adapter;
    public static final int MAX_PIC = 4;
    public static final int REQUEST_ALBUM = 10;
    private static final int UPLOAD_IMAGE_COMPRESS_FINISH = 1000;
    private LoadingDialog compressImagesProgressDialog;
    private Thread compressThread;

    @SuppressLint("HandlerLeak")
    private Handler mHandlers = new Handler() {
        @SuppressWarnings("unchecked")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPLOAD_IMAGE_COMPRESS_FINISH:
                    ArrayList<String> imageUrls = (ArrayList<String>) msg.obj;
                    for (String imageUrl : imageUrls) {
                        uploadImage(imageUrl);//上传图片
                    }
                    break;
            }
        }
    };

    public static void start(Context context) {
        Intent intent = new Intent(context, AddCommentActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_add_comment;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        tv_title.setText("评价");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        etCommentContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                int detailLength = s.length();
//                vh.tvLength.setText(detailLength + mContext.getString(R.string.evaluate_product_list_edittext_text_length));
            }

            @Override
            public void afterTextChanged(Editable s) {
//                item.setContent(s.toString());
            }
        });
        adapter = new GridImageAdapter(this);
        commentImages.setAdapter(adapter);
        commentImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == adapter.infos.size()) {
                    openPhotoPicker();
                } else {
                    String imgUrl = (String) adapter.getItem(position);
                    openLargeImage(imgUrl);
                }
            }
        });
    }

    /**
     * 打开大图
     *
     * @param imgUrl
     */
    private void openLargeImage(String imgUrl) {

    }

    /**
     * 打开图片选择器
     */
    private void openPhotoPicker() {
//        EvaluateSubmitProduct.EvaluateData.EvaluateSku item = (EvaluateSubmitProduct.EvaluateData.EvaluateSku) listAdapter.getItem(position);
        Intent intent = new Intent(this, ImageGridActivity.class);
        startActivityForResult(intent, REQUEST_ALBUM);
    }

    @Override
    protected void initData() {
        super.initData();
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
                        List<CommentTagsBean> commentTagsBean = gson.fromJson(response.body(), new TypeToken<List<CommentTagsBean>>() {
                        }.getType());
                        fillTags(commentTagsBean);
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
    private void fillTags(final List<CommentTagsBean> result) {
        if (CollectionUtils.isEmpty(result)) {
            return;
        }
        commentTagFlowLayout.removeAllViews();
        for (int i = 0; i < result.size(); i++) {
            final TextView txt = (TextView) LayoutInflater.from(this).inflate(R.layout.item_comment_tag_layout, commentTagFlowLayout, false);
            if (!AppUtil.isEmptyString(result.get(i).getName())) {
                txt.setText(result.get(i).getName());
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

    /**
     * 提交评价
     */
    private void submitComment() {
        OkGo.<String>post(URLs.ADD_COMMENT)
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
//                                fillTags();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Gson gson = new Gson();
//                        HotSearchBean hotSearchBean = gson.fromJson(response.body(), HotSearchBean.class);
//                        fillTags();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        LogUtil.e("TAG", response.message());
//                        fillTags();
                    }
                });
    }

    @OnClick({R.id.submitComment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submitComment:
                submitComment();
                break;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == REQUEST_ALBUM) {
                ArrayList<ImageItem> images = data.getParcelableArrayListExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                if (CollectionUtils.isNotEmpty(images)) {
                    compressImage(images);
                }
            } else {
            }
        }
    }

    /**
     * 压缩图片
     *
     * @param resultImagePath
     */
    private void compressImage(final ArrayList<ImageItem> resultImagePath) {
        if (compressImagesProgressDialog == null) {
            compressImagesProgressDialog = new LoadingDialog(AddCommentActivity.this, "压缩中...", false);
           /* compressImagesProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    LogUtil.d(TAG, "dialog isCanceled");
                    if (compressThread != null) {
                        compressThread.interrupt();
                    }
                }
            });*/
        }

        compressImagesProgressDialog.show();
        compressThread = new Thread(new Runnable() {
            @Override
            public void run() {
                ExecutorService taskExecutor = Executors.newFixedThreadPool(resultImagePath.size());
                Map<String, String> map = new HashMap<>();
                final Map<String, String> synchronizedMap = Collections.synchronizedMap(map);
                final long timeStamp = System.currentTimeMillis();
                for (final ImageItem originalImageClone : resultImagePath) {
                    taskExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            LogUtil.d(TAG, "url is " + originalImageClone.path + ", thread id is " + Thread.currentThread().getId() + ",mimeType:" + originalImageClone.mimeType);
                            String compressedFileDirectory = AppFolderManager.getInstance().getImageCompressFolder();
                            String[] split = originalImageClone.mimeType.split("/");
                            LogUtil.d(TAG, "split mimeType:" + split[1]);
                            //避免因文件名相同导致的图片重复的问题
                            String compressedFileName = timeStamp + "_" + resultImagePath.indexOf(originalImageClone) + "." + split[1];
                            File compressedFile = new File(compressedFileDirectory, compressedFileName);
                            boolean compressResult = ImageCompressUtil.handle(originalImageClone.path, compressedFile.getPath());
                            LogUtil.d(TAG, "compress image result is " + compressResult);
                            if (compressResult) {
                                synchronizedMap.put(originalImageClone.path, compressedFile.getPath());
                            }
                        }
                    });
                }
                taskExecutor.shutdown();
                LogUtil.d(TAG, "taskExecutor shutdown");
                try {
                    taskExecutor.awaitTermination(4, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    LogUtil.e(TAG, "interrupted", e);
                }
                if (null != compressImagesProgressDialog) {
                    compressImagesProgressDialog.close();
                    compressImagesProgressDialog = null;
                }
                LogUtil.d(TAG, "complete " + synchronizedMap.size());

                if (synchronizedMap.size() == 0) {
                    ToastUtil.showToastMsg(AddCommentActivity.this, "图片处理出现错误，请稍后再试");
                    return;
                }

                ArrayList<String> uploadImages = new ArrayList<>();
                for (ImageItem originalImageClone : resultImagePath) {
                    if (synchronizedMap.containsKey(originalImageClone.path)) {
                        uploadImages.add(synchronizedMap.get(originalImageClone.path));
                    }
                }
                Message message = new Message();
                message.obj = uploadImages;
                message.what = UPLOAD_IMAGE_COMPRESS_FINISH;
                mHandlers.sendMessage(message);
            }
        });
        compressThread.start();
    }

    /**
     * 上传图片
     *
     * @param uploadImagePath 选择的图片路径
     */
    public void uploadImage(String uploadImagePath) {
        ToastUtil.showToastMsg(this, "正在上传图片");
        File file = new File(uploadImagePath);
        OkGo.<String>post(URLs.UPLOAD_IMAGE).tag(this).params("file", file).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e("comment", "body:" + response.body());
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
//                                fillTags();
                        return;
                    }
                    JSONObject data = jsonObject.optJSONObject("data");
                    if (data != null) {
                        String url = jsonObject.optString("url");
                        adapter.addItem(url);
                        adapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Response<String> response) {
                LogUtil.e("TAG", response.message());
//                        fillTags();
            }
        });
    }
}
