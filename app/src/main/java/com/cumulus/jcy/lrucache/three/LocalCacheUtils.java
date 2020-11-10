package com.cumulus.jcy.lrucache.three;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import com.cumulus.jcy.lrucache.Md5Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 创建者：  jcy
 * 日期：15:27
 * 时间：2019/4/25
 * 内容：本地SD卡缓存工具类
 */

public class LocalCacheUtils {
    public static void putBitmapToLoacl(Bitmap bitmap, String url) {
        String encode = Md5Utils.encode(url);
        File file = new File(Environment.getExternalStorageDirectory(), encode);
        Log.i("Tag", "putBitmapToLoacl: " + file.toString());
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Bitmap getBitmapToLoacl(String url) {
        String encode = Md5Utils.encode(url);
        File file = new File(Environment.getExternalStorageDirectory(), encode);
        if (file.exists()) {
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inSampleSize = 3;
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file), null, opts);
                return bitmap;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
