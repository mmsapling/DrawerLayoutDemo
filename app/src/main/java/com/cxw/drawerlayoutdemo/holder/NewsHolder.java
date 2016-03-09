package com.cxw.drawerlayoutdemo.holder;

import android.content.Context;
import android.view.View;

import com.cxw.drawerlayoutdemo.R;
import com.cxw.drawerlayoutdemo.base.BaseHolder;
import com.cxw.drawerlayoutdemo.view.whaterfall.ScaleImageView;
import com.cxw.drawerlayoutdemo.view.whaterfall.imageloader_lib.ImageLoader;

public class NewsHolder
        extends BaseHolder<String>
{
    private ScaleImageView mItemSIV;
    private ImageLoader mImageLoader;
    public NewsHolder(Context context,ImageLoader loader) {
        super(context);
        mImageLoader = loader;
    }

    @Override protected View initHolderView() {
        View view = View.inflate(mContext, R.layout.item_news, null);
        mItemSIV = (ScaleImageView) view.findViewById(R.id.item_news_image);
        return view;
    }

    @Override protected void refreshHolderView(String data) {
        mImageLoader.DisplayImage(data,mItemSIV);
    }
}
