package com.cxw.drawerlayoutdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.cxw.drawerlayoutdemo.holder.HomeHolder;
import com.cxw.drawerlayoutdemo.volly.base.AbstractBaseAdapter;

import java.util.List;

public class HomeAdapter extends AbstractBaseAdapter<String> {

    public HomeAdapter(Context context, List<String> dataSource) {
        super(context, dataSource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomeHolder holder = null;
        if(convertView == null){
            holder = new HomeHolder(mContext);
        }else{
            holder = (HomeHolder) convertView.getTag();
        }
        holder.setDataAndRefreshHolderView(mDataSource.get(position));
        return holder.mHolderView;
    }
}
