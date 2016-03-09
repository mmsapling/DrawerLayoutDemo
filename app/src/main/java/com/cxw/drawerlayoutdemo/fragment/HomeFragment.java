package com.cxw.drawerlayoutdemo.fragment;

import android.view.View;
import android.widget.ScrollView;

import com.cxw.drawerlayoutdemo.R;
import com.cxw.drawerlayoutdemo.adapter.HomeAdapter;
import com.cxw.drawerlayoutdemo.base.BaseFragment;
import com.cxw.drawerlayoutdemo.view.NoScrollListView;
import com.cxw.drawerlayoutdemo.view.pullrefresh.DScrollView;
import com.cxw.drawerlayoutdemo.view.pullrefresh.base.DOnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment
        extends BaseFragment
{
    DScrollView      mHomeScrollview;
    NoScrollListView mHomeListview;
    private ScrollView   mScrollView;
    private List<String> mDatas;
    private HomeAdapter  mHomeAdapter;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.pullrefresh_public_scrollview, null);
        mHomeScrollview = (DScrollView) view.findViewById(R.id.home_scrollview);
        mHomeScrollview.setPullDownEnabled(true); mHomeScrollview.setPullUpEnabled(false);
        mScrollView = mHomeScrollview.getRefreshableView();
        View contentView = View.inflate(getActivity(), R.layout.fragment_home, null);
        mHomeListview = (NoScrollListView) contentView.findViewById(R.id.home_listview);
        mScrollView.addView(contentView); return view;
    }


    @Override
    public void initData() {
        super.initData(); mDatas = new ArrayList<String>(); for (int i = 0; i < 100; i++) {
            mDatas.add("内容" + i);
        } mHomeAdapter = new HomeAdapter(getActivity(), mDatas);
        mHomeListview.setAdapter(mHomeAdapter);
    }

    @Override
    public void initListener() {
        super.initListener(); mHomeScrollview.setOnRefreshListener(new DOnRefreshListener() {
            @Override
            public void onPullDownToRefresh() {
                refreshData();
            }

            @Override
            public void onPullUpToRefresh() {

            }
        });
    }

    private void refreshData() {
        mHomeAdapter.clearAllList(); mHomeScrollview.onStopDownRefresh(true);
    }
}
