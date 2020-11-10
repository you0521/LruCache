package com.cumulus.jcy.lrucache;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.cumulus.jcy.lrucache.three.LocalCacheUtils;
import com.cumulus.jcy.lrucache.three.MemoryCacheUtils;
import com.cumulus.jcy.lrucache.three.NetCacheUtils;

/**
 * 创建者：  jcy
 * 日期：15:25
 * 时间：2019/4/25
 * 内容：三级缓存工具类
 */

public class CacheUtils {
    private static final String TAG = "CacheUtils";
    //内存缓存
    private MemoryCacheUtils mMemoryCacheUtils;
    //磁盘缓存
    private LocalCacheUtils mLocalCacheUtils;
    //网络缓存
    private NetCacheUtils mNetCacheUtils;

    public CacheUtils() {
        mMemoryCacheUtils = new MemoryCacheUtils();
        mLocalCacheUtils = new LocalCacheUtils();
        mNetCacheUtils = new NetCacheUtils(mMemoryCacheUtils, mLocalCacheUtils);
    }

    public void diaplay(ImageView imageView, String url) {

        //内存缓存   生命周期同调用者
        Bitmap bitmap = mMemoryCacheUtils.getBitmapToMemory(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            Log.i(TAG, "diaplay: 221111111111");
            return;
        }


        //本地缓存
        bitmap = LocalCacheUtils.getBitmapToLoacl(url);
        if (bitmap != null) {
            Log.i(TAG, "diaplay: 1111111");
            imageView.setImageBitmap(bitmap);
            mMemoryCacheUtils.putBitmapToMemory(bitmap, url);
            return;
        }

        //网络缓存
        mNetCacheUtils.getBitmapFromNet(imageView, url);
    }
}
