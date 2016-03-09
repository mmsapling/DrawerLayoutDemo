package com.cxw.drawerlayoutdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import com.cxw.drawerlayoutdemo.adapter.MainPagerAdapter;
import com.cxw.drawerlayoutdemo.fragment.GameFragment;
import com.cxw.drawerlayoutdemo.fragment.HomeFragment;
import com.cxw.drawerlayoutdemo.fragment.MusicFragment;
import com.cxw.drawerlayoutdemo.fragment.NewsFragment;
import com.cxw.drawerlayoutdemo.fragment.SettingFragment;
import com.cxw.drawerlayoutdemo.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity
        extends FragmentActivity
        implements RadioGroup.OnCheckedChangeListener
{

    @Bind(R.id.main_viewpager)
    NoScrollViewPager mMainViewpager;
    @Bind(R.id.main_container_tab)
    RadioGroup        mMainContainerTab;
    private MainPagerAdapter mMainPagerAdapter;
    private List<Fragment>   mFragmentLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initListener();
    }


    public void initData() {
        mFragmentLists = new ArrayList<Fragment>();
        mFragmentLists.add(new HomeFragment());
        mFragmentLists.add(new NewsFragment());
        mFragmentLists.add(new GameFragment());
        mFragmentLists.add(new MusicFragment());
        mFragmentLists.add(new SettingFragment());
        mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), mFragmentLists);
        mMainViewpager.setAdapter(mMainPagerAdapter);
        //默认选中首页
        mMainContainerTab.check(R.id.main_tab_home);
    }

    public void initListener() {
        mMainContainerTab.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int currentItem = 0;
        switch (checkedId) {
            case R.id.main_tab_home:
                currentItem = 0;
                selectTab(currentItem);
                break;
            case R.id.main_tab_news:
                currentItem = 1;
                selectTab(currentItem);
                break;
            case R.id.main_tab_game:
                currentItem = 2;
                selectTab(currentItem);
                break;
            case R.id.main_tab_music:
                currentItem = 3;
                selectTab(currentItem);
                break;
            case R.id.main_tab_setting:
                currentItem = 4;
                selectTab(currentItem);
                break;
        }
    }

    /**
     * 切换菜单
     * @param currentItem 当前所选择的条目
     */
    private void selectTab(int currentItem) {
//        for (int i = 0; i < mMainContainerTab.getChildCount(); i++) {
//            mMainContainerTab.getChildAt(i)
//                             .setPressed(i == currentItem ?
//                                         true :
//                                         false);
//        }
        mMainViewpager.setCurrentItem(currentItem);
    }
}
