package org.devio.takephoto.uitl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.widget.Toast;

import com.darsh.multipleimageselect.models.Image;

import org.devio.takephoto.R;
import org.devio.takephoto.model.TContextWrap;
import org.devio.takephoto.model.TException;
import org.devio.takephoto.model.TExceptionType;
import org.devio.takephoto.model.TImage;
import org.devio.takephoto.model.TIntentWap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 工具类
 * Author: JPH
 * Date: 2016/7/26 10:04
 */
public class TUtils {
    private static final String TAG = IntentUtils.class.getName();


    /**
     * 将Image集合转换成Uri集合
     *
     * @param images
     * @return
     */
    public static ArrayList<Uri> convertImageToUri(Context context, ArrayList<Image> images) throws TException {
        ArrayList<Uri> uris = new ArrayList();
        for (Image image : images) {
            uris.add(FileProvider.getUriForFile(context, TConstant.getFileProviderName(context), new File(image.path)));
        }
        return uris;
    }

    /**
     * 将Image集合转换成TImage集合
     *
     * @param images
     * @return
     */
    public static ArrayList<TImage> getTImagesWithImages(ArrayList<Image> images, TImage.FromType fromType) {
        ArrayList<TImage> tImages = new ArrayList();
        for (Image image : images) {
            tImages.add(TImage.of(image.path, fromType));
        }
        return tImages;
    }

    /**
     * 将Uri集合转换成TImage集合
     *
     * @param uris
     * @return
     */
    public static ArrayList<TImage> getTImagesWithUris(ArrayList<Uri> uris, TImage.FromType fromType) {
        ArrayList<TImage> tImages = new ArrayList();
        for (Uri uri : uris) {
            tImages.add(TImage.of(uri, fromType));
        }
        return tImages;
    }

    /**
     * @param contextWrap
     * @param intentWap
     */
    public static void startActivityForResult(TContextWrap contextWrap, TIntentWap intentWap) {
        if (contextWrap.getFragment() != null) {
            contextWrap.getFragment().startActivityForResult(intentWap.getIntent(), intentWap.getRequestCode());
        } else {
            contextWrap.getActivity().startActivityForResult(intentWap.getIntent(), intentWap.getRequestCode());
        }
    }

    /**
     * 安全地发送Intent
     *
     * @param contextWrap
     * @param intentWapList 要发送的Intent以及候选Intent
     * @param defaultIndex  默认发送的Intent
     * @param isCrop        是否为裁切照片的Intent
     * @throws TException
     */
    public static void sendIntentBySafely(TContextWrap contextWrap, List<TIntentWap> intentWapList, int defaultIndex, boolean isCrop)
        throws TException {
        if (defaultIndex + 1 > intentWapList.size()) {
            throw new TException(isCrop ? TExceptionType.TYPE_NO_MATCH_PICK_INTENT : TExceptionType.TYPE_NO_MATCH_CROP_INTENT);
        }
        TIntentWap intentWap = intentWapList.get(defaultIndex);
        List result = contextWrap.getActivity().getPackageManager().queryIntentActivities(intentWap.getIntent(), PackageManager.MATCH_ALL);
        if (result.isEmpty()) {
            sendIntentBySafely(contextWrap, intentWapList, ++defaultIndex, isCrop);
        } else {
            startActivityForResult(contextWrap, intentWap);
        }
    }

    /**
     * 拍照前检查是否有相机
     **/
    public static void captureBySafely(TContextWrap contextWrap, TIntentWap intentWap) throws TException {
        List result = contextWrap.getActivity().getPackageManager().queryIntentActivities(intentWap.getIntent(), PackageManager.MATCH_ALL);
        if (result.isEmpty()) {
            Toast.makeText(contextWrap.getActivity(), contextWrap.getActivity().getResources().getText(R.string.tip_no_camera),
                Toast.LENGTH_SHORT).show();
            throw new TException(TExceptionType.TYPE_NO_CAMERA);
        } else {
            startActivityForResult(contextWrap, intentWap);
        }
    }

    /**
     * 显示圆形进度对话框
     *
     * @param activity
     * @param progressTitle 显示的标题
     * @return
     * @author JPH
     * Date 2014-12-12 下午7:04:09
     */
    public static ProgressDialog showProgressDialog(final Activity activity, String... progressTitle) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        String title = activity.getResources().getString(R.string.tip_tips);
        if (progressTitle != null && progressTitle.length > 0) {
            title = progressTitle[0];
        }
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle(title);
        progressDialog.setCancelable(false);
        progressDialog.show();
        return progressDialog;
    }
}
