package com.cxw.drawerlayoutdemo.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import java.util.HashMap;
import java.util.Map;



public class BaseApplication extends Application
{

	private static Context		mContext;												// member
	private static long			mMainThreadId;
	private static Handler		mMainThreadHandler;

	/*--------------- 放置协议内容  begin---------------*/
	private Map<String, String>	mCacheJsonStringMap	= new HashMap<String, String>();

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
	public void onCreate()
	{// 程序入口方法

		// 1.上下文
		mContext = getApplicationContext();

		// 2.主线程的Id
		/**
		 * Tid Thread Pid Process Uid User
		 */
		mMainThreadId = android.os.Process.myTid();

		// 3.创建一个主线程的handler
		mMainThreadHandler = new Handler();


		super.onCreate();
	}
}
