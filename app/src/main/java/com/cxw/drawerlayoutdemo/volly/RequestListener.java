package com.cxw.drawerlayoutdemo.volly;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

public abstract class RequestListener implements Listener, ErrorListener {

	@Override
	public void onErrorResponse(VolleyError error) {
		
	}
	
}
