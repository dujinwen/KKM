package com.kekemei.kekemei.fragment;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.manager.AppFolderManager;
import com.kekemei.kekemei.utils.ImageCompressUtil;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.ToastUtil;
import com.kekemei.kekemei.utils.URLs;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.devio.takephoto.app.TakePhotoFragment;
import org.devio.takephoto.model.TResult;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static org.devio.takephoto.uitl.TConstant.RC_PICK_PICTURE_FROM_CAPTURE;
import static org.devio.takephoto.uitl.TConstant.RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends TakePhotoFragment {


    private static final String TAG = "fragment_1";
    @BindView(R.id.iv_zhengmian)
    ImageView ivZhengmian;
    @BindView(R.id.iv_btn_zhengmian)
    ImageView ivBtnZhengmian;
    @BindView(R.id.iv_fanmian)
    ImageView ivFanmian;
    @BindView(R.id.iv_btn_fanmian)
    ImageView ivBtnFanmian;
    @BindView(R.id.iv_zige)
    ImageView ivZige;
    @BindView(R.id.iv_btn_zige)
    ImageView ivBtnZige;
    Unbinder unbinder;
    @BindView(R.id.btn_next)
    Button btnNext;
    private View mView;
    private OnButtonClick onButtonClick;

    private int type = -1;
    private Thread compressThread;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_1, container, false);
        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }


//此方法在Fragment中

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            //Fragment隐藏时调用
            Toast.makeText(getActivity(), "隐藏fragment 1", Toast.LENGTH_SHORT).show();
        } else {
            //Fragment显示时调用
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_btn_zhengmian, R.id.iv_btn_fanmian, R.id.iv_btn_zige, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_btn_zhengmian:
                type = 200;
                checkPhoto();
                break;
            case R.id.iv_btn_fanmian:
                type = 300;
                checkPhoto();
                break;
            case R.id.iv_btn_zige:
                type = 400;
                checkPhoto();
                break;
            case R.id.btn_next:
                onButtonClick.onClick(btnNext);
                break;
        }
    }

    private void checkPhoto() {
        final CharSequence[] items = {"本地上传", "拍照上传"};
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("选择上传方式")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        Uri imageUri = Uri.fromFile(file);

                        if (item == 0) {
                            getTakePhoto().onPickFromGallery(RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + type);
                            dialog.cancel();
                        } else if (item == 1) {
                            getTakePhoto().onPickFromCapture(imageUri, RC_PICK_PICTURE_FROM_CAPTURE + type);
                            dialog.cancel();
                        }
                    }
                }).create();
        dialog.show();

    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeSuccess(TResult result, int requestCode) {
        super.takeSuccess(result, requestCode);
//        showImg(result.getImages());
        compressImage(result.getImages().get(0).getOriginalPath(), requestCode);

    }


    /**
     * 压缩图片
     *
     * @param resultImagePath
     */
    private void compressImage(final String resultImagePath, final int requestCode) {
        compressThread = new Thread(new Runnable() {
            @Override
            public void run() {
                ExecutorService taskExecutor = Executors.newFixedThreadPool(5);
                Map<String, String> map = new HashMap<>();
                final Map<String, String> synchronizedMap = Collections.synchronizedMap(map);
                final long timeStamp = System.currentTimeMillis();

               taskExecutor.execute(new Runnable() {
                   @Override
                   public void run() {
                       String compressedFileDirectory = AppFolderManager.getInstance().getImageCompressFolder();
                       //避免因文件名相同导致的图片重复的问题
                       String[] split = resultImagePath.split("\\.");
                       String compressedFileName = split[0] + "_" + timeStamp + "." + split[1];
                       File compressedFile = new File(compressedFileDirectory, resultImagePath);
                       boolean compressResult = ImageCompressUtil.handle(resultImagePath, compressedFile.getPath());
                       LogUtil.d(TAG, "compress image result is " + compressResult);
//                if (compressResult) {
//                    synchronizedMap.put(resultImagePath, compressedFile.getPath());
//                }
//                LogUtil.d(TAG, "taskExecutor shutdown");
//                LogUtil.d(TAG, "complete " + synchronizedMap.size());
//
//                if (synchronizedMap.size() == 0) {
//                    ToastUtil.showToastMsg(getActivity(), "图片处理出现错误，请稍后再试");
//                    return;
//                }

//                       uploadImage(compressedFile.getPath(), requestCode);//上传图片
                   }
               });
            }
        });
        compressThread.start();
    }

    /**
     * 上传图片
     *
     * @param uploadImagePath 选择的图片路径
     * @param requestCode
     */
    public void uploadImage(String uploadImagePath, final int requestCode) {
        ToastUtil.showToastMsg(getActivity(), "正在上传图片");
        File file = new File(uploadImagePath);
        OkGo.<String>post(URLs.UPLOAD_IMAGE).tag(this).params("file", file).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e("comment", "body:" + response.body());
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        return;
                    }
                    JSONObject data = jsonObject.optJSONObject("data");
                    if (data != null) {
                        ToastUtil.showToastMsg(getActivity(), "上传成功");
                        String url = data.optString("url");
                        switch (requestCode) {
                            case RC_PICK_PICTURE_FROM_CAPTURE + 200://拍照
                            case RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + 200://图库
                                Glide.with(getActivity()).load(URLs.BASE_URL + url).into(ivZhengmian);
                                ivBtnZhengmian.setVisibility(View.GONE);
                                break;
                            case RC_PICK_PICTURE_FROM_CAPTURE + 300://拍照
                            case RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + 300://图库
                                Glide.with(getActivity()).load(URLs.BASE_URL + url).into(ivFanmian);
                                ivBtnFanmian.setVisibility(View.GONE);
                                break;
                            case RC_PICK_PICTURE_FROM_CAPTURE + 400://拍照
                            case RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + 400://图库
                                Glide.with(getActivity()).load(URLs.BASE_URL + url).into(ivZige);
                                ivBtnZige.setVisibility(View.GONE);
                                break;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Response<String> response) {
                LogUtil.e("TAG", response.message());
            }
        });
    }

    public OnButtonClick getOnButtonClick() {
        return onButtonClick;
    }

    public void setOnButtonClick(OnButtonClick onButtonClick) {
        this.onButtonClick = onButtonClick;
    }

    public interface OnButtonClick {
        public void onClick(View view);
    }
}
