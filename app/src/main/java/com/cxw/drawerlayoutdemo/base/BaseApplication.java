package com.cxw.drawerlayoutdemo.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.cxw.drawerlayoutdemo.utils.FileUtils;
import com.cxw.drawerlayoutdemo.volly.DVolley;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/4 0004.
 */
public class BaseApplication extends Application {
    private static Context mContext;                                                // member
    private static long    mMainThreadId;
    private static Handler mMainThreadHandler;

    /*--------------- 放置协议内容  begin---------------*/
    private Map<String, String> mCacheJsonStringMap = new HashMap<String, String>();

    public Map<String, String> getCacheJsonStringMap()
    {
        return mCacheJsonStringMap;
    }

	/*--------------- 放置协议内容 end ---------------*/

    public static Context getContext()
    {
        return mContext;
    }

    public static long getMainThreadId()
    {
        return mMainThreadId;
    }

    public static Handler getMainThreadHandler()
    {
        return mMainThreadHandler;
    }

    @Override
    public void onCreate() {
        // 1.上下文
        mContext = getApplicationContext();

        // 2.主线程的Id
        /**
         * Tid Thread Pid Process Uid User
         */
        mMainThreadId = android.os.Process.myTid();

        // 3.创建一个主线程的handler
        mMainThreadHandler = new Handler();
        DVolley.init(this);
        //初始化imageloader
        initImageLoader();
        super.onCreate();
    }

    private void initImageLoader() {
        File cacheDir = new File(FileUtils.getCacheDir());
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getContext())
                .diskCacheFileCount(100)
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .build();
        ImageLoader.getInstance().init(config);

    }
}
