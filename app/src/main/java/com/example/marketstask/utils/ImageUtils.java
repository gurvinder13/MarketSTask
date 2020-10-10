package com.example.marketstask.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

public class ImageUtils {

    private LruCache<String, Bitmap> mMemoryCache;

    private static ImageUtils mInstance;

    private ImageUtils(){
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        final int cacheSize = maxMemory / 8;

        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    public static ImageUtils getInstance(){
        if(mInstance == null){
            mInstance = new ImageUtils();
        }
        return mInstance;
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        if(mMemoryCache != null && key != null){
            return mMemoryCache.get(key);
        }
        return null;
    }

}
