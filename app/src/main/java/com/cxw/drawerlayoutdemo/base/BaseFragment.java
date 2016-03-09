package com.cxw.drawerlayoutdemo.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.Collection;

import butterknife.ButterKnife;


public abstract class BaseFragment extends Fragment
{
	public Gson				mGson;

	/**
	 * 1.不用关心相关的生命周期方法,只需要关心自己定义的方法即可 2.可以决定哪些方法是必须实现,哪些方法是选择性实现
	 * 3.放置共有的属性或者方法-->减少代码的书写
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		init();
		mGson = new Gson();
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return initView();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		initData();
		initListener();
		super.onActivityCreated(savedInstanceState);
	}

	/**
	 * @des 初始化
	 * @call 选择性覆写
	 */
	public void init()
	{

	}

	/**
	 * @des 初始化视图
	 * @des 必须要实现,但是不知道具体实现,定义成为一个抽象方法,交给子类具体实现
	 * @call 强制性的覆写
	 */
	public abstract View initView();

	/**
	 * @des 初始化数据
	 * @call 子类选择性覆写
	 */
	public void initData()
	{

	}

	/**
	 * @des 初始化监听器
	 * @call 子类选择性覆写
	 */
	public void initListener()
	{

	}
	/**
	 * 判段集合是否为空
	 * @param collection
	 * @return
	 *   	 true :为空；false 不为空
	 */
	public boolean isListEmpty(Collection collection){
		if(collection.size() > 0 && collection != null){
			return false;
		}
		return true;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
}
