package org.devio.takephoto.uitl;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Intent工具类用于生成拍照、
 * 从相册选择照片，裁剪照片所需的Intent
 * Author: JPH
 * Date: 2016/6/7 0007 13:41
 */
public class IntentUtils {
    private static final String TAG = IntentUtils.class.getName();



    /**
     * 获取拍照的Intent
     *
     * @return
     */
    public static Intent getCaptureIntent(Uri outPutUri) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);//设置Action为拍照
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outPutUri);//将拍取的照片保存到指定URI
        return intent;
    }

    /**
     * 获取选择照片的Intent
     *
     * @return
     */
    public static Intent getPickIntentWithGallery() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);//Pick an item from the data
        intent.setType("image/*");//从所有图片中进行选择
        return intent;
    }

    /**
     * 获取从文件中选择照片的Intent
     *
     * @return
     */
    public static Intent getPickIntentWithDocuments() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        return intent;
    }
}
