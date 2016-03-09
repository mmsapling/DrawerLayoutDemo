package com.cxw.drawerlayoutdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.cxw.drawerlayoutdemo.holder.NewsHolder;
import com.cxw.drawerlayoutdemo.view.whaterfall.imageloader_lib.ImageLoader;
import com.cxw.drawerlayoutdemo.volly.base.AbstractBaseAdapter;

import java.util.List;

public class NewsAdapter extends AbstractBaseAdapter<String> {

    private ImageLoader mImageLoader;
    public NewsAdapter(Context context, List<String> list) {
        super(context, list);
        mImageLoader = new ImageLoader(context);
        mImageLoader.setIsUseMediaStoreThumbnails(true);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        mImageLoader.setRequiredSize(width/3);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsHolder holder = null;
        if(convertView == null){
            holder = new NewsHolder(mContext,mImageLoader);
        }else{
            holder = (NewsHolder) convertView.getTag();
        }
        holder.setDataAndRefreshHolderView(getItem(position));
        return holder.mHolderView;

    }
}
