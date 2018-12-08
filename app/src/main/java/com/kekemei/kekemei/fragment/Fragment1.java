package com.kekemei.kekemei.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
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
import com.kekemei.kekemei.utils.LQRPhotoSelectUtils;

import org.devio.takephoto.app.TakePhotoFragment;
import org.devio.takephoto.model.TResult;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

import static org.devio.takephoto.uitl.TConstant.RC_PICK_PICTURE_FROM_CAPTURE;
import static org.devio.takephoto.uitl.TConstant.RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends TakePhotoFragment {


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

    private LQRPhotoSelectUtils mLqrPhotoSelectUtils;
    private int type = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_1, container, false);
        unbinder = ButterKnife.bind(this, mView);
        init();
        return mView;
    }

    private void init() {
        // 1、创建LQRPhotoSelectUtils（一个Activity对应一个LQRPhotoSelectUtils）
        mLqrPhotoSelectUtils = new LQRPhotoSelectUtils(getActivity(), new LQRPhotoSelectUtils.PhotoSelectListener() {
            @Override
            public void onFinish(File outputFile, Uri outputUri, int requestCode) {
                // 4、当拍照或从图库选取图片成功后回调
//                mTvPath.setText(outputFile.getAbsolutePath());
//                mTvUri.setText(outputUri.toString());
//                Glide.with(MainActivity.this).load(outputUri).into(mIvPic);
                switch (requestCode) {
                    case RC_PICK_PICTURE_FROM_CAPTURE + 200://拍照
                    case RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + 200://图库
                        Glide.with(getActivity()).load(outputUri).into(ivZhengmian);
                        ivBtnZhengmian.setVisibility(View.GONE);
                        break;
                    case RC_PICK_PICTURE_FROM_CAPTURE + 300://拍照
                    case RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + 300://图库
                        Glide.with(getActivity()).load(outputUri).into(ivFanmian);
                        ivBtnFanmian.setVisibility(View.GONE);
                        break;
                    case RC_PICK_PICTURE_FROM_CAPTURE + 400://拍照
                    case RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + 400://图库
                        Glide.with(getActivity()).load(outputUri).into(ivZige);
                        ivBtnZige.setVisibility(View.GONE);
                        break;
                }
            }
        }, false);//true裁剪，false不裁剪
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

    private final int GET_PHOTO_BY_CAMERA = 100;
    private final int GET_PHOTO_BY_GALLERY = 200;

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
                            // 3、调用从图库选取图片方法
//                            PermissionGen.needPermission(Fragment1.this,
//                                    LQRPhotoSelectUtils.REQ_SELECT_PHOTO,
//                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
//                                            Manifest.permission.WRITE_EXTERNAL_STORAGE}
//                            );
                            getTakePhoto().onPickFromGallery(RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + type);
                            dialog.cancel();
                        } else if (item == 1) {
                            // 3、调用拍照方法
//                            PermissionGen.with(Fragment1.this)
//                                    .addRequestCode(RC_PICK_PICTURE_FROM_CAPTURE)
//                                    .permissions(Manifest.permission.READ_EXTERNAL_STORAGE,
//                                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                                            Manifest.permission.CAMERA
//                                    ).request();
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
    public void takeSuccess(TResult result,int requestCode) {
        super.takeSuccess(result, requestCode);
//        showImg(result.getImages());
        switch (requestCode) {
            case RC_PICK_PICTURE_FROM_CAPTURE + 200://拍照
            case RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + 200://图库
                Glide.with(getActivity()).load(result.getImages().get(0).getOriginalPath()).into(ivZhengmian);
                ivBtnZhengmian.setVisibility(View.GONE);
                break;
            case RC_PICK_PICTURE_FROM_CAPTURE + 300://拍照
            case RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + 300://图库
                Glide.with(getActivity()).load(result.getImages().get(0).getOriginalPath()).into(ivFanmian);
                ivBtnFanmian.setVisibility(View.GONE);
                break;
            case RC_PICK_PICTURE_FROM_CAPTURE + 400://拍照
            case RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + 400://图库
                Glide.with(getActivity()).load(result.getImages().get(0).getOriginalPath()).into(ivZige);
                ivBtnZige.setVisibility(View.GONE);
                break;
        }
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


    @PermissionSuccess(requestCode = LQRPhotoSelectUtils.REQ_TAKE_PHOTO)
    private void takePhoto() {
        mLqrPhotoSelectUtils.takePhoto(type);
    }

    @PermissionSuccess(requestCode = LQRPhotoSelectUtils.REQ_SELECT_PHOTO)
    private void selectPhoto() {
        mLqrPhotoSelectUtils.selectPhoto(type);
    }

    @PermissionFail(requestCode = LQRPhotoSelectUtils.REQ_TAKE_PHOTO)
    private void showTip1() {
//                Toast.makeText(getActivity(), "不给我权限是吧，那就别玩了", Toast.LENGTH_SHORT).show();
        showDialog();
    }

    @PermissionFail(requestCode = LQRPhotoSelectUtils.REQ_SELECT_PHOTO)
    private void showTip2() {
//                Toast.makeText(getActivity(), "不给我权限是吧，那就别玩了", Toast.LENGTH_SHORT).show();
        showDialog();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(Fragment1.this, requestCode, permissions, grantResults);
    }


//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        mLqrPhotoSelectUtils.attachToActivityForResult(requestCode, resultCode, data);
//    }

    public void showDialog() {
        //创建对话框创建器
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //设置对话框显示小图标
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        //设置标题
        builder.setTitle("权限申请");
        //设置正文
        builder.setMessage("在设置-应用-虎嗅-权限 中开启相机、存储权限，才能正常使用拍照或图片选择功能");

        //添加确定按钮点击事件
        builder.setPositiveButton("去设置", new DialogInterface.OnClickListener() {//点击完确定后，触发这个事件

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //这里用来跳到手机设置页，方便用户开启权限
                Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + getActivity().getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        //添加取消按钮点击事件
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        //使用构建器创建出对话框对象
        AlertDialog dialog = builder.create();
        dialog.show();//显示对话框
    }
}
