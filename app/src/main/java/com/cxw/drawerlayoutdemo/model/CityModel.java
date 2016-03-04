package com.cxw.drawerlayoutdemo.model;

import android.content.Context;
import android.util.Log;

import com.cxw.drawerlayoutdemo.bean.TCity;
import com.cxw.drawerlayoutdemo.conf.Constants;
import com.cxw.drawerlayoutdemo.volly.DCallResult;
import com.cxw.drawerlayoutdemo.volly.DResponseService;
import com.cxw.drawerlayoutdemo.volly.DVolley;
import com.cxw.drawerlayoutdemo.volly.DVolleyConstans;
import com.cxw.drawerlayoutdemo.volly.DVolleyModel;
import com.cxw.drawerlayoutdemo.volly.bean.ReturnBean;
import com.cxw.drawerlayoutdemo.volly.util.JSONUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/4 0004.
 */
public class CityModel extends DVolleyModel {
    private static final String TAG = "tylz";

    public CityModel(Context context) {
        super(context);
    }
    private DResponseService cityResultResponse;

    public void findCityList(String id){
        Map<String,String> params = this.newParams();
        params.put("id",id);
        if(cityResultResponse == null){
            cityResultResponse = new CityResultResponse(this);
        }
        DVolley.get(Constants.URL,params,cityResultResponse);
    }
    private class CityResultResponse extends DResponseService{

        public CityResultResponse(DVolleyModel volleyModel) {
            super(volleyModel);
        }

        @Override
        protected void myOnResponse(DCallResult callResult) throws Exception {
            JSONArray jsonArray = callResult.getContentArray();
            List<TCity> list = new ArrayList<TCity>();
            List<TCity> city = new ArrayList<TCity>();;
            if (jsonArray.length()!=0&&!jsonArray.equals("")) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = JSONUtil.getString(jsonObject, "name");
                    String id = JSONUtil.getString(jsonObject, "id");
                    if (i==0) {
                        JSONArray arraycity = jsonObject.getJSONArray("city");
                        for (int j = 0; j < arraycity.length(); j++) {
                            JSONObject objectCity = arraycity.getJSONObject(j);
                            String nameCity = JSONUtil.getString(objectCity, "name");
                            String idCity = JSONUtil.getString(objectCity, "id");
                            TCity tCity = new TCity();
                            tCity.city = nameCity;
                            tCity.cityId = idCity;
                            city.add(tCity);
                        }
                        list.add(new TCity(id, name, city));
                    }else{
                        list.add(new TCity(id, name));
                    }
                }
            }
            ReturnBean bean = new ReturnBean();
            bean.setType(DVolleyConstans.METHOD_CITY);
            Log.i(TAG,"size = " + list.size());
            bean.setObject(list);
            volleyModel.onMessageResponse(bean, callResult.getResult(), callResult.getMessage(), null);
        }
    }
}
