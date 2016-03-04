package com.cxw.drawerlayoutdemo.volly.base;

import android.app.Application;

import com.cxw.drawerlayoutdemo.volly.DVolley;

/**
 * Created by Administrator on 2016/3/4 0004.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DVolley.init(this);
    }
}
