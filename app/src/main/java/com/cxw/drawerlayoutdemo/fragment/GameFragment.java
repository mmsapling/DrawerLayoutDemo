package com.cxw.drawerlayoutdemo.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.cxw.drawerlayoutdemo.base.BaseFragment;

public class GameFragment
        extends BaseFragment {
    @Override
    public View initView() {
        TextView view = new TextView(getActivity());
        view.setText(this.getClass().getSimpleName());
        view.setGravity(Gravity.CENTER);
        view.setTextSize(20);
        return view;
    }
}
