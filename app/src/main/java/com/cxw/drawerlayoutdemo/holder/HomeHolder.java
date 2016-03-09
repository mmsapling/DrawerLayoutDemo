package com.cxw.drawerlayoutdemo.holder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cxw.drawerlayoutdemo.R;
import com.cxw.drawerlayoutdemo.base.BaseHolder;

public class HomeHolder
        extends BaseHolder<String>
{
    TextView     mItemText;
    LinearLayout mItemContainer;
    public HomeHolder(Context context){
        super(context);
        mContext = context;
    }
    @Override
    protected View initHolderView() {
        View view = View.inflate(mContext, R.layout.item_city, null);
        mItemText = (TextView) view.findViewById(R.id.item_text);
        mItemContainer = (LinearLayout) view.findViewById(R.id.item_container);
        return view;
    }

    @Override
    protected void refreshHolderView(String data) {
        mItemText.setText(data);
    }
}
