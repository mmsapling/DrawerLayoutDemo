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
    public Context context;
    public List<T> list;

    public AbstractBaseAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    public T getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return this.list;
    }

    public void add(T object) {
        this.list.add(object);
    }

    public void addAllList(Collection<? extends T> collection) {
        this.list.addAll(collection);
        this.notifyDataSetChanged();
    }

    public void clearAllList() {
        this.list.clear();
        this.notifyDataSetChanged();
    }
}
