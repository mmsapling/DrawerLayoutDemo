package com.cxw.drawerlayoutdemo.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;


public class MyBaseApdater<ITEMBEANTYPE> extends BaseAdapter
{
	protected List<ITEMBEANTYPE>	mDataSource	= new ArrayList<ITEMBEANTYPE>();
	protected Context				mContext;

	/**
	 * 通过构造方法,让外部传入具体的数据源
	 */
	public MyBaseApdater(List<ITEMBEANTYPE> dataSource) {
		super();
		mDataSource = dataSource;
	}

	public MyBaseApdater(Context context, List<ITEMBEANTYPE> dataSource) {
		super();
		mDataSource = dataSource;
		mContext = context;
	}

	@Override
	public int getCount()
	{
		if (mDataSource != null) { return mDataSource.size(); }
		return 0;
	}

	@Override
	public Object getItem(int position)
	{
		if (mDataSource != null) { return mDataSource.get(position); }
		return null;
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO
		return null;
	}

}
