package com.cxw.drawerlayoutdemo.volly.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Collection;
import java.util.List;

public class AbstractBaseAdapter<T>
        extends BaseAdapter
{
    public Context mContext;
    public List<T> mDataSource;

    public AbstractBaseAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mDataSource = list;
    }

    public int getCount() {
        return mDataSource.size();
    }

    public T getItem(int position) {
        return mDataSource.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public void setList(List<T> list) {
        this.mDataSource = list;
    }

    public List<T> getList() {
        return this.mDataSource;
    }

    public void add(T object) {
        this.mDataSource.add(object);
    }

    public void addAllList(Collection<? extends T> collection) {
        this.mDataSource.addAll(collection);
        this.notifyDataSetChanged();
    }

    public void clearAllList() {
        this.mDataSource.clear();
        this.notifyDataSetChanged();
    }
}
