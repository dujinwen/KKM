package org.devio.takephoto.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.compress.CompressImage;
import org.devio.takephoto.compress.CompressImageImpl;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.MultipleCrop;
import org.devio.takephoto.model.TContextWrap;
import org.devio.takephoto.model.TException;
import org.devio.takephoto.model.TImage;
import org.devio.takephoto.model.TIntentWap;
import org.devio.takephoto.model.TResult;
import org.devio.takephoto.model.TakePhotoOptions;
import org.devio.takephoto.permission.PermissionManager;
import org.devio.takephoto.uitl.ImageRotateUtil;
import org.devio.takephoto.uitl.IntentUtils;
import org.devio.takephoto.uitl.TConstant;
import org.devio.takephoto.uitl.TFileUtils;
import org.devio.takephoto.uitl.TUriParse;
import org.devio.takephoto.uitl.TUtils;

import java.util.ArrayList;

/**
 * - 支持通过相机拍照获取图片
 * - 支持从相册选择图片
 * - 支持从文件选择图片
 * - 支持多图选择
 * - 支持批量图片裁切
 * - 支持批量图片压缩
 * - 支持对图片进行压缩
 * - 支持对图片进行裁剪
 * - 支持对裁剪及压缩参数自定义
 * - 提供自带裁剪工具(可选)
 * - 支持智能选取及裁剪异常处理
 * - 支持因拍照Activity被回收后的自动恢复
 * Date: 2016/9/21 0007 20:10
 * Version:4.0.0
 * 技术博文：http://www.devio.org
 * GitHub:https://github.com/crazycodeboy
 * Email:crazycodeboy@gmail.com
 */
public class TakePhotoImpl implements TakePhoto {
    private static final String TAG = IntentUtils.class.getName();
    private TContextWrap contextWrap;
    private TakeResultListener listener;
    private Uri outPutUri;
    private Uri tempUri;
    private CropOptions cropOptions;
    private TakePhotoOptions takePhotoOptions;
    private CompressConfig compressConfig;
    private MultipleCrop multipleCrop;
    private PermissionManager.TPermissionType permissionType;
    private TImage.FromType fromType; //CAMERA图片来源相机，OTHER图片来源其他
    /**
     * 是否显示压缩对话框
     */
    private boolean showCompressDialog;
    private ProgressDialog wailLoadDialog;

    public TakePhotoImpl(Activity activity, TakeResultListener listener) {
        contextWrap = TContextWrap.of(activity);
        this.listener = listener;
    }

    public TakePhotoImpl(Fragment fragment, TakeResultListener listener) {
        contextWrap = TContextWrap.of(fragment);
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            cropOptions = (CropOptions) savedInstanceState.getSerializable("cropOptions");
            takePhotoOptions = (TakePhotoOptions) savedInstanceState.getSerializable("takePhotoOptions");
            showCompressDialog = savedInstanceState.getBoolean("showCompressDialog");
            outPutUri = savedInstanceState.getParcelable("outPutUri");
            tempUri = savedInstanceState.getParcelable("tempUri");
            compressConfig = (CompressConfig) savedInstanceState.getSerializable("compressConfig");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("cropOptions", cropOptions);
        outState.putSerializable("takePhotoOptions", takePhotoOptions);
        outState.putBoolean("showCompressDialog", showCompressDialog);
        outState.putParcelable("outPutUri", outPutUri);
        outState.putParcelable("tempUri", tempUri);
        outState.putSerializable("compressConfig", compressConfig);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {

            case TConstant.RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + 200://从相册选择照片不裁剪
            case TConstant.RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + 300://从相册选择照片不裁剪
            case TConstant.RC_PICK_PICTURE_FROM_GALLERY_ORIGINAL + 400://从相册选择照片不裁剪
                if (resultCode == Activity.RESULT_OK) {
                    try {
                        takeResult(
                                TResult.of(TImage.of(TUriParse.getFilePathWithUri(data.getData(), contextWrap.getActivity()), fromType)), requestCode);
                    } catch (TException e) {
                        takeResult(TResult.of(TImage.of(data.getData(), fromType)), requestCode, e.getDetailMessage());
                        e.printStackTrace();
                    }
                } else {
                    listener.takeCancel();
                }
                break;
            case TConstant.RC_PICK_PICTURE_FROM_DOCUMENTS_ORIGINAL://从文件选择照片不裁剪
                if (resultCode == Activity.RESULT_OK) {
                    try {
                        takeResult(TResult.of(
                                TImage.of(TUriParse.getFilePathWithDocumentsUri(data.getData(), contextWrap.getActivity()), fromType)), requestCode);
                    } catch (TException e) {
                        takeResult(TResult.of(TImage.of(outPutUri, fromType)), requestCode, e.getDetailMessage());
                        e.printStackTrace();
                    }
                } else {
                    listener.takeCancel();
                }
                break;

            case TConstant.RC_PICK_PICTURE_FROM_CAPTURE + 200://拍取照片
            case TConstant.RC_PICK_PICTURE_FROM_CAPTURE + 300://拍取照片
            case TConstant.RC_PICK_PICTURE_FROM_CAPTURE + 400://拍取照片
                if (resultCode == Activity.RESULT_OK) {
                    if (takePhotoOptions != null && takePhotoOptions.isCorrectImage()) {
                        ImageRotateUtil.of().correctImage(contextWrap.getActivity(), outPutUri);
                    }
                    try {
                        takeResult(TResult.of(TImage.of(TUriParse.getFilePathWithUri(outPutUri, contextWrap.getActivity()), fromType)), requestCode);
                    } catch (TException e) {
                        takeResult(TResult.of(TImage.of(outPutUri, fromType)), requestCode, e.getDetailMessage());
                        e.printStackTrace();
                    }
                } else {
                    listener.takeCancel();
                }
                break;

            default:
                break;
        }
    }


    @Override
    public void onPickFromDocuments(int requestCode) {
        selectPicture(0, requestCode, false);
    }

    @Override
    public void onPickFromGallery(int requestCode) {
        selectPicture(1, requestCode, false);
    }

    private void selectPicture(int defaultIndex, int requestCode, boolean isCrop) {
        this.fromType = TImage.FromType.OTHER;

        if (PermissionManager.TPermissionType.WAIT.equals(permissionType)) {
            return;
        }
        ArrayList<TIntentWap> intentWapList = new ArrayList<>();
        intentWapList.add(new TIntentWap(IntentUtils.getPickIntentWithDocuments(),
                requestCode));
        intentWapList.add(new TIntentWap(IntentUtils.getPickIntentWithGallery(),
                requestCode));
        try {
            TUtils.sendIntentBySafely(contextWrap, intentWapList, defaultIndex, isCrop);
        } catch (TException e) {
            takeResult(TResult.of(TImage.of("", fromType)), requestCode, e.getDetailMessage());
            e.printStackTrace();
        }
    }


    @Override
    public void onPickFromCapture(Uri outPutUri, int requestCode) {
        this.fromType = TImage.FromType.CAMERA;
        if (PermissionManager.TPermissionType.WAIT.equals(permissionType)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.outPutUri = TUriParse.convertFileUriToFileProviderUri(contextWrap.getActivity(), outPutUri);
        } else {
            this.outPutUri = outPutUri;
        }

        try {
            TUtils.captureBySafely(contextWrap,
                    new TIntentWap(IntentUtils.getCaptureIntent(this.outPutUri), requestCode));
        } catch (TException e) {
            takeResult(TResult.of(TImage.of("", fromType)), requestCode, e.getDetailMessage());
            e.printStackTrace();
        }
    }


    @Override
    public void onEnableCompress(CompressConfig config, boolean showCompressDialog) {
        this.compressConfig = config;
        this.showCompressDialog = showCompressDialog;
    }

    @Override
    public void setTakePhotoOptions(TakePhotoOptions options) {
        this.takePhotoOptions = options;
    }

    @Override
    public void permissionNotify(PermissionManager.TPermissionType type) {
        this.permissionType = type;
    }

    private void takeResult(final TResult result, final int requestCode, final String... message) {
        if (null == compressConfig) {
            handleTakeCallBack(result, requestCode, message);
        } else {
            if (showCompressDialog) {
                wailLoadDialog = TUtils.showProgressDialog(contextWrap.getActivity(),
                        contextWrap.getActivity().getResources().getString(org.devio.takephoto.R.string.tip_compress));
            }

            CompressImageImpl.of(contextWrap.getActivity(), compressConfig, result.getImages(), new CompressImage.CompressListener() {
                @Override
                public void onCompressSuccess(ArrayList<TImage> images) {
                    if (!compressConfig.isEnableReserveRaw()) {
                        deleteRawFile(images);
                    }
                    handleTakeCallBack(result, requestCode);
                    if (wailLoadDialog != null && !contextWrap.getActivity().isFinishing()) {
                        wailLoadDialog.dismiss();
                    }
                }

                @Override
                public void onCompressFailed(ArrayList<TImage> images, String msg) {
                    if (!compressConfig.isEnableReserveRaw()) {
                        deleteRawFile(images);
                    }
                    handleTakeCallBack(TResult.of(images), requestCode,
                            String.format(contextWrap.getActivity().getResources().getString(org.devio.takephoto.R.string.tip_compress_failed),
                                    message.length > 0 ? message[0] : "", msg, result.getImage().getCompressPath()));
                    if (wailLoadDialog != null && !contextWrap.getActivity().isFinishing()) {
                        wailLoadDialog.dismiss();
                    }
                }
            }).compress();
        }
    }

    private void deleteRawFile(ArrayList<TImage> images) {
        for (TImage image : images) {
            if (TImage.FromType.CAMERA == fromType) {
                TFileUtils.delete(image.getOriginalPath());
                image.setOriginalPath("");
            }
        }
    }

    private void handleTakeCallBack(final TResult result, int requestCode, String... message) {
        if (message.length > 0) {
            listener.takeFail(result, message[0]);
        } else if (multipleCrop != null && multipleCrop.hasFailed) {
            listener.takeFail(result, contextWrap.getActivity().getResources().getString(org.devio.takephoto.R.string.msg_crop_failed));
        } else if (compressConfig != null) {
            boolean hasFailed = false;
            for (TImage image : result.getImages()) {
                if (image == null || !image.isCompressed()) {
                    hasFailed = true;
                    break;
                }
            }
            if (hasFailed) {
                listener.takeFail(result, contextWrap.getActivity().getString(org.devio.takephoto.R.string.msg_compress_failed));
            } else {
                listener.takeSuccess(result, requestCode);
            }
        } else {
            listener.takeSuccess(result, requestCode);
        }
        clearParams();
    }

    private void clearParams() {
        compressConfig = null;
        takePhotoOptions = null;
        cropOptions = null;
        multipleCrop = null;
    }
}