package com.cxw.drawerlayoutdemo;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.cxw.drawerlayoutdemo.adapter.FirstAdapter;
import com.cxw.drawerlayoutdemo.adapter.SecondeAdapter;
import com.cxw.drawerlayoutdemo.bean.TCity;
import com.cxw.drawerlayoutdemo.model.CityModel;
import com.cxw.drawerlayoutdemo.volly.DResponseListener;
import com.cxw.drawerlayoutdemo.volly.DVolleyConstans;
import com.cxw.drawerlayoutdemo.volly.bean.ReturnBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity
        extends Activity
        implements View.OnClickListener, DResponseListener, FirstAdapter.OnChangeListener
{
    private static final String TAG = "tylz";
    private DrawerLayout   mDrawer;
    private TextView       mTvLeftText;
    private TextView       mTvRgihtText;
    private TextView       mTvDriverClose;
    private ListView       mFirstList;
    private ListView       mSecondList;
    private List<TCity>    mFirstDatas;
    private List<TCity>    mSecondDatas;
    private LinearLayout   mContainer;
    private CityModel      mCityModel;
    private FirstAdapter   mFirstAdapter;
    private SecondeAdapter mSecondeAdapter;
    private TextView       mTvDrawerContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "order=onCreate");
        setContentView(R.layout.activity_main);
        initModel();
        initView();
        initData();
        initListener();
    }

    private void initModel() {
        Log.d(TAG, "order=initModel");
        mCityModel = new CityModel(this);
        mCityModel.addResponseListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "order=onResume");
        mCityModel.findCityList("");
    }

    private void initListener() {
        mTvLeftText.setOnClickListener(this);
        mTvRgihtText.setOnClickListener(this);
        mTvDriverClose.setOnClickListener(this);
        mFirstAdapter.setOnChangeListener(this);
    }

    private void initData() {
        Log.d(TAG, "order=initData");
        mFirstDatas = new ArrayList<TCity>();
        mSecondDatas = new ArrayList<TCity>();
        mFirstAdapter = new FirstAdapter(this, mFirstDatas);
        mSecondeAdapter = new SecondeAdapter(this, mSecondDatas);
        mFirstList.setAdapter(mFirstAdapter);
        mSecondList.setAdapter(mSecondeAdapter);
    }

    private void initView() {
        Log.d(TAG, "order=initView");
        mDrawer = (DrawerLayout) findViewById(R.id.main_drawer);
        mContainer = (LinearLayout) findViewById(R.id.main_drawlayout);
        mTvLeftText = (TextView) findViewById(R.id.main_tv_lefttext);
        mTvRgihtText = (TextView) findViewById(R.id.main_tv_righttext);
        mTvDriverClose = (TextView) findViewById(R.id.drawer_tv_righttext);
        mFirstList = (ListView) findViewById(R.id.main_first_listview);
        mSecondList = (ListView) findViewById(R.id.main_sencond_listview);
        mTvDrawerContent = (TextView) findViewById(R.id.drawer_tv_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_tv_lefttext:
                mDrawer.closeDrawer(mContainer);
                break;
            case R.id.main_tv_righttext:
                mDrawer.openDrawer(mContainer);

                break;
            case R.id.drawer_tv_righttext:
                mDrawer.closeDrawer(mContainer);
                break;
            default:
                break;
        }
    }

    @Override
    public void onMessageResponse(ReturnBean bean, int result, String message, Throwable error) {
        Log.d(TAG, "order=onMessageRespense");
        if (result == 1) {
            if (bean.getType() == DVolleyConstans.METHOD_CITY) {
                mFirstDatas = (List<TCity>) bean.getObject();
                mFirstAdapter.addAllList(mFirstDatas);
                mSecondeAdapter.addAllList(mFirstDatas.get(0).citys);
                mTvDrawerContent.setText("数据的大小为=" + mFirstDatas.size());
            } else if(bean.getType() == DVolleyConstans.METHOD_CHANGE){
                mSecondDatas = (List<TCity>) bean.getObject();
                mSecondeAdapter.clearAllList();
                mSecondeAdapter.addAllList(mSecondDatas);
            }
        }
    }

    /**
     * 但所选的城市或者省发生变化的接口回调，
     * @param id
     * @param city
     */
    @Override
    public void onChange(String id, String city) {
             mCityModel.findChangeCityList(id);
    }
}
