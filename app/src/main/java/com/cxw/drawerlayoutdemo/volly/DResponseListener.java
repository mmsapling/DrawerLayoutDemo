package com.cxw.drawerlayoutdemo.volly;


import com.cxw.drawerlayoutdemo.volly.bean.ReturnBean;

/**界面回调监听*/
public interface DResponseListener {
    public void onMessageResponse(ReturnBean bean, int result, String message, Throwable error);
}
