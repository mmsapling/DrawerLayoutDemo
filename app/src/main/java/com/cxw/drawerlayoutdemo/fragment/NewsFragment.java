package com.cxw.drawerlayoutdemo.fragment;

import android.util.Log;
import android.view.View;

import com.cxw.drawerlayoutdemo.R;
import com.cxw.drawerlayoutdemo.adapter.NewsAdapter;
import com.cxw.drawerlayoutdemo.base.BaseFragment;
import com.cxw.drawerlayoutdemo.model.NewsModel;
import com.cxw.drawerlayoutdemo.view.whaterfall.MultiColumnListView;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment
        extends BaseFragment
{
    private static final String TAG = "tylz";
    private MultiColumnListView mMultiColumnListView;
    private List<String>        mImageUrls;
    private NewsModel           mNewsModel;
    private NewsAdapter         mNewsAdapter;

    @Override public View initView() {
        Log.d(TAG, "initView");
        View view = View.inflate(getActivity(), R.layout.fragment_news, null);
        mMultiColumnListView = (MultiColumnListView) view.findViewById(R.id.news_whaterfall_listview);
        return view;
    }

    @Override public void initData() {
        super.initData();
        Log.d(TAG, "initData");
        mNewsModel = new NewsModel(getActivity());
        mImageUrls = new ArrayList<String>();
        mNewsAdapter = new NewsAdapter(getActivity(),mImageUrls);
        mMultiColumnListView.setAdapter(mNewsAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
        mImageUrls = mNewsModel.findImageUrls();
        Log.d(TAG,"size=" + mImageUrls.size());
       // mNewsAdapter.notifyDataSetChanged();
        mNewsAdapter.addAllList(mImageUrls);
    }
}
