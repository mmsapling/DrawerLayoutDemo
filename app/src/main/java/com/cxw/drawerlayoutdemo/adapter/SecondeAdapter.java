package com.cxw.drawerlayoutdemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cxw.drawerlayoutdemo.R;
import com.cxw.drawerlayoutdemo.bean.TCity;
import com.cxw.drawerlayoutdemo.volly.base.AbstractBaseAdapter;

import java.util.List;

/**
 */
public class SecondeAdapter extends AbstractBaseAdapter<TCity> {
    private int mSelectItem = 0;
    public SecondeAdapter(Context context, List<TCity> list) {
        super(context, list);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item_city, null);
            convertView.setTag(holder);
            holder.mContainer = (LinearLayout) convertView.findViewById(R.id.item_container);
            holder.mTvCityName = (TextView) convertView.findViewById(R.id.item_text);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final TCity item = getItem(position);
        holder.mTvCityName.setText(item.city);
        if(position == mSelectItem){
            holder.mTvCityName.setTextColor(Color.RED);
        }else{
            holder.mTvCityName.setTextColor(Color.BLACK);
        }
        holder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });

        return convertView;
    }
    private class ViewHolder{
        LinearLayout mContainer;
        TextView     mTvCityName;
    }
}
