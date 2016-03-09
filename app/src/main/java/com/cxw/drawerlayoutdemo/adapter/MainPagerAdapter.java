package com.cxw.drawerlayoutdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/3/7 0007.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mDataSource;
    public MainPagerAdapter(FragmentManager fm,List<Fragment> data){
        super(fm);
        mDataSource = data;
    }
    @Override
    public Fragment getItem(int position) {
        if(mDataSource != null){
            return mDataSource.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if(mDataSource != null){
            return mDataSource.size();
        }
        return 0;
    }
}
