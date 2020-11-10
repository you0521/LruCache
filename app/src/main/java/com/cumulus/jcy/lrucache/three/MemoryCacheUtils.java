package com.cumulus.jcy.lrucache.three;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

/**
 * 创建者：  jcy
 * 日期：15:26
 * 时间：2019/4/25
 * 内容：内存缓存工具类
 */

public class MemoryCacheUtils {
    private LruCache<String, Bitmap> mMemoryCache;

    public MemoryCacheUtils() {
        int maxmemory = (int) Runtime.getRuntime().maxMemory();
        Log.i("Tag", "MemoryCacheUtils: " + maxmemory);
        mMemoryCache = new LruCache<String, Bitmap>(maxmemory / 8) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    public void putBitmapToMemory(Bitmap bitmap, String url) {
        Log.i("Tag", "putBitmapToMemory: ");
        mMemoryCache.put(url, bitmap);
    }

    public Bitmap getBitmapToMemory(String url) {
        Log.i("Tag", "getBitmapToMemory: ");
        Bitmap bitmap = mMemoryCache.get(url);
        return bitmap;
    }
}
