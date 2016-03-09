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
 * Created by Administrator on 2016/3/4 0004.
 */
public class FirstAdapter extends AbstractBaseAdapter<TCity> {
    private OnChangeListener mOnChangerListener;
    private int mItemPosition = 0; //默认选中的位置为0
    public FirstAdapter(Context context, List<TCity> list) {
        super(context, list);
    }
    public void setSelectItem(int itemPosition){
        mItemPosition = itemPosition;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
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
        //如果是第一个位置设置为字体颜色为红色
        if(position == mItemPosition){
            holder.mTvCityName.setTextColor(Color.RED);
        }else{
            holder.mTvCityName.setTextColor(Color.BLACK);
        }
        final ViewHolder finalHolder = holder;
        holder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnChangerListener != null) {
                    mOnChangerListener.onChange(item.cityId, item.city);
                }
                mItemPosition = position;
                finalHolder.mTvCityName.setTextColor(Color.RED);
                notifyDataSetChanged();
            }

        });

        return convertView;
    }
    private class ViewHolder{
        LinearLayout mContainer;
        TextView     mTvCityName;
    }
    public void setOnChangeListener(OnChangeListener listener){
        this.mOnChangerListener = listener;
    }
    public interface OnChangeListener{
        void onChange(String id,String city);

    }
}
