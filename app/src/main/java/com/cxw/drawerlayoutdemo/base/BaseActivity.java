package com.cxw.drawerlayoutdemo.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Timer;

public abstract class BaseActivity extends Activity
{
	/**
	 * 1.不用关心相关的生命周期方法,只需要关心自己定义的方法即可 2.可以决定哪些方法是必须实现,哪些方法是选择性实现
	 * 3.放置共有的属性或者方法-->减少代码的书写
	 */
	// activity的完全退出
	public static LinkedList<BaseActivity>	allActivitys	= new LinkedList<BaseActivity>();

	// 再按一次退出应用程序
	private long							mPreClickTime;
	// 属性

	public TextView							mTvTitle;												// 头标题
	public ImageView						mIvLeftHeader;											// 左菜单
	public ImageView						mIvRightHeader;
	public static final String				VALUE_PASS		= "pass_value";						// 传值
	public Gson								mGson;
	public boolean							isReceiveDriver	= true;								// 是否接受司机端消息
																									// 默认接受
	public boolean							isReceiveUser	= true;								// 是否接受用户端消息
																									// 默认接受


	// 右菜单
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		mGson = new Gson();
		init();
		initView();
		initActionBar();
		initData();
		initListener();
	}

	@Override
	protected void onResume()
	{
		allActivitys.add(this);
		super.onResume();
	}

	@Override
	protected void onDestroy()
	{
		allActivitys.remove(this);
		super.onDestroy();
	}

	public void init()
	{
		// TODO

	}

	public abstract void initView();

	public void initActionBar()
	{
		// TODO

	}

	public void initData()
	{
	}

	public void initListener()
	{

	}

	/**
	 * 完全退出
	 */
	public void exit()
	{
		for (BaseActivity activity : allActivitys)
		{
			activity.finish();
		}
	}

	@Override
	protected void onPause()
	{
		super.onPause();
	}



	@Override
	public void onBackPressed()
	{
		if (this instanceof BaseActivity)
		{
			if (System.currentTimeMillis() - mPreClickTime > 2000)
			{// 两次连续点击的时间间隔>2s
				Toast.makeText(getApplicationContext(), "再按一次,退出应用程序", Toast.LENGTH_SHORT).show();
				mPreClickTime = System.currentTimeMillis();
				return;
			}
			else
			{// 点的快
				exit();// 完全退出
			}
		}
		else
		{
			super.onBackPressed();// finish
		}
	}


	/**
	 * 判段集合是否为空
	 * 
	 * @param collection
	 * @return true :为空；false 不为空
	 */
	public boolean isListEmpty(Collection collection)
	{
		if (collection.size() > 0 && collection != null) { return false; }
		return true;
	}

	/***
	 * 設置空視圖
	 * 
	 * @param listview
	 * @param msg
	 *            說明文字
	 */
	public void setEmptyView(ListView listview, String msg)
	{
		TextView emptyView = new TextView(this);
		emptyView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		emptyView.setText(msg);
		emptyView.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
		emptyView.setVisibility(View.GONE);
		((ViewGroup) listview.getParent()).addView(emptyView);
		listview.setEmptyView(emptyView);
	}


	/**
	 * 获取Android手机唯一标志串
	 * 
	 * @return DEVICE_ID
	 */
	public String getDeviceId()
	{
		TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		String DEVICE_ID = tm.getDeviceId();
		return DEVICE_ID;
	}




	/**
	 * 打开或关闭软件盘
	 */
	public void openInputMethod()
	{
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		boolean isOpen = imm.isActive();
		if (!isOpen)
		{
			imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	/**
	 * 打开或关闭软件盘
	 */
	public void closeInputMethod()
	{
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		boolean isOpen = imm.isActive();
		if (isOpen)
		{
			imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

}
