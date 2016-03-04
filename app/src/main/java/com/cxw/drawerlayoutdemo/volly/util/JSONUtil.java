package com.cxw.drawerlayoutdemo.volly.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class JSONUtil {
	
	public static String getString(JSONObject object,String name) throws JSONException {
		if(!object.has(name)){
			return "";
		}
		if(object.isNull(name)){
			return "";
		}
		return object.getString(name);
	}
	public static int getInt(JSONObject object,String name) throws JSONException {
		if(!object.has(name)){
			return 0;
		}
		if(object.isNull(name)){
			return 0;
		}
		int value=0;
		try {
			value=Integer.parseInt(object.getString(name));
		} catch (Exception e) {
		}
		return value;
	}
	
	public static boolean getBoolean(JSONObject object,String name) throws JSONException {
		if(!object.has(name)){
			return false;
		}
		if(object.isNull(name)){
			return false;
		}
		String str=object.getString(name);
		return str.equals("1")?true:false;
	}
	
	public static JSONObject getJSONObject(JSONObject object,String name) throws JSONException {
		if(!object.has(name)){
			return null;
		}
		if(object.isNull(name)){
			return null;
		}
		return object.getJSONObject(name);
	}
	public static JSONArray getJSONArray(JSONObject object,String name) throws JSONException {
		if(!object.has(name)){
			return null;
		}
		if(object.isNull(name)){
			return null;
		}
		return object.getJSONArray(name);
	}
}
