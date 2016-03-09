package com.cxw.drawerlayoutdemo.base;

import android.content.Context;
import android.view.View;


public abstract class BaseHolder<HOLDERBEANTYPE>
{

	// 可以提供的视图
	public View				mHolderView;	// -->view
	public HOLDERBEANTYPE	mData;			// -->model
	public Context			mContext;
	// 1.初始化holder
	public BaseHolder() {
		mHolderView = initHolderView();
		// 4.mHolderView去找一个类,作为它的tag,绑定在自己身上,方便以后进行复用
		mHolderView.setTag(this);
	}
	public BaseHolder(Context context){
		mContext = context;
		mHolderView = initHolderView();
		mHolderView.setTag(this);
	}
	/**
	 * @des 初始化持有的视图
	 * @call 走到构造方法自动被调用
	 * @return
	 */
	protected abstract View initHolderView();

	/**
	 * @des 接收数据
	 * @des 绑定数据
	 * @des 必须实现,但是不知道具体实现,定义成为抽象方法,交给子类具体实现
	 * @call 外界刷新的时候
	 */
	public void setDataAndRefreshHolderView(HOLDERBEANTYPE data)
	{
		// 保存数据到成员变量
		mData = data;
		// 绑定数据
		refreshHolderView(data);
	}

	/**
	 * @des 绑定数据
	 * @des 必须实现,但是不知道具体实现,定义成为抽象方法,交给子类具体实现
	 * @call 外界调用了setDataAndRefreshHolderView()的时候
	 * @param data
	 */
	protected abstract void refreshHolderView(HOLDERBEANTYPE data);

}
