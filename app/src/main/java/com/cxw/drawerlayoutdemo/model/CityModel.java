package com.cxw.drawerlayoutdemo.model;

import android.content.Context;
import android.util.Log;

import com.cxw.drawerlayoutdemo.bean.Bean;
import com.cxw.drawerlayoutdemo.bean.TCity;
import com.cxw.drawerlayoutdemo.conf.Constants;
import com.cxw.drawerlayoutdemo.volly.DCallResult;
import com.cxw.drawerlayoutdemo.volly.DResponseService;
import com.cxw.drawerlayoutdemo.volly.DVolley;
import com.cxw.drawerlayoutdemo.volly.DVolleyConstans;
import com.cxw.drawerlayoutdemo.volly.DVolleyModel;
import com.cxw.drawerlayoutdemo.volly.bean.ReturnBean;
import com.cxw.drawerlayoutdemo.volly.util.JSONUtil;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class CityModel
        extends DVolleyModel
{
    private static final String TAG = "tylz";

    public CityModel(Context context) {
        super(context);
    }

    private DResponseService cityResultResponse;
    private DResponseService cityResultChangeResponse;

    public void findCityList(String id) {
        Map<String, String> params = this.newParams();
        if (cityResultResponse == null) {
            cityResultResponse = new CityResultResponse(this);
        }
        DVolley.get(Constants.URL, params, cityResultResponse);
    }

    public void findChangeCityList(String id) {
        Map<String, String> params = this.newParams();
        params.put("id", id);
        if (cityResultChangeResponse == null) {
            cityResultChangeResponse = new CityResultChangeResponse(this);
        }
        DVolley.get(Constants.URL, params, cityResultChangeResponse);
    }

    private class CityResultChangeResponse
            extends DResponseService
    {

        public CityResultChangeResponse(DVolleyModel volleyModel) {
            super(volleyModel);
        }

        @Override
        protected void myOnResponse(DCallResult callResult)
                throws Exception
        {
            Gson gson = new Gson();
            
            ReturnBean bean = new ReturnBean();
            Bean       bean1 = gson.fromJson(callResult.getResponse()
                                                       .toString(), Bean.class);
            List<TCity> list = new ArrayList<>();
            for(int i = 0; i < bean1.content.size(); i++){
                TCity city = new TCity();
                city.cityId = bean1.content.get(i).id;
                city.city = bean1.content.get(i).name;
                list.add(city);
            }
            bean.setObject(list);
            bean.setType(DVolleyConstans.METHOD_CHANGE);
            volleyModel.onMessageResponse(bean,
                                          callResult.getResult(),
                                          callResult.getMessage(),
                                          null);
        }
    }

    private class CityResultResponse
            extends DResponseService
    {

        public CityResultResponse(DVolleyModel volleyModel) {
            super(volleyModel);
        }

        @Override
        protected void myOnResponse(DCallResult callResult)
                throws Exception
        {
            JSONObject response = callResult.getResponse();
            Log.d(TAG, "response=" + response.toString());
            JSONArray   jsonArray = callResult.getContentArray();
            List<TCity> list      = new ArrayList<TCity>();
            List<TCity> city      = new ArrayList<TCity>();
            ;
            if (jsonArray.length() != 0 && !jsonArray.equals("")) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = JSONUtil.getString(jsonObject, "name");
                    String id = JSONUtil.getString(jsonObject, "id");
                    if (id.equals("1")) {
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
                    } else {
                        list.add(new TCity(id, name));
                    }
                }
            }
            ReturnBean bean = new ReturnBean();
            bean.setType(DVolleyConstans.METHOD_CITY);
            bean.setObject(list);
            volleyModel.onMessageResponse(bean,
                                          callResult.getResult(),
                                          callResult.getMessage(),
                                          null);
        }
    }
}
