package com.cxw.drawerlayoutdemo.utils;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

import com.cxw.drawerlayoutdemo.base.BaseApplication;

/*
 * @创建者     伍碧林
 * @创建时间   2015/12/8 08:58
 * @描述	     和ui相关的一些工具方法
 *
 * @更新者     $Author: admin $
 * @更新时间   $Date: 2015-12-11 15:17:52 +0800 (星期五, 11 十二月 2015) $
 * @更新描述   ${TODO}
 */
public class UIUtils {
    /**
     * 得到上下文
     */
    public static Context getContext() {
        return BaseApplication.getContext();
    }

    /**
     * 得到Resource对象
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * 得到String.xml中定义的字符信息
     */
    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    /**
     * 得到String.xml中定义的字符数组信息
     */
    public static String[] getStrings(int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * 得到color.xml中定义的颜色信息
     */
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**
     * 得到主线程的线程id
     */
    public static long getMainThreadId() {
        return BaseApplication.getMainThreadId();
    }

    /**
     * 得到主线程的一个handler
     */
    public static Handler getMainThreadHandler() {
        return BaseApplication.getMainThreadHandler();
    }

    /**
     * 安全的执行一个任务
     */
    public static void postTaskSafely(Runnable task) {
        // 得到当前的线程
        long curThreadId = android.os.Process.myTid();
        // 得到主线程的线程id
        long mainThreadId = getMainThreadId();
        if (curThreadId == mainThreadId) {
            // 如果当前是在主线程-->直接执行
            task.run();
        } else {
            // 如果当前是在子线程-->通过消息机制,把任务发送到主线程执行
            getMainThreadHandler().post(task);
        }
    }

    /**
     * 得到应用程序的包名
     */
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    /**
     * dp-->px
     */
    public static int dp2Px(int dp) {
        //1.px/dp = density    ==> px和dp倍数关系
        //2.px/(ppi/160) = dp  ==>ppi

        float density = getResources().getDisplayMetrics().density; //1.5
        //        int ppi = getResources().getDisplayMetrics().densityDpi;//160 240 320

        int px = (int) (dp * density + .5f);
        return px;
    }

    /**
     * px-->dp
     */
    public static int px2Dp(int px) {
        //1.px/dp = density    ==> px和dp倍数关系
        float density = getResources().getDisplayMetrics().density; //1.5
        int dp = (int) (px / density + .5f);
        return dp;
    }
}
