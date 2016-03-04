package com.cxw.drawerlayoutdemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/3/3 0003.
 */
public class TCity {
    public String preId;
    public String cityId;
    public String pre;
    public String city;
    public List<TCity> citys;
    public TCity(){}
    public TCity(String id, String name, List<TCity> city) {
        this.cityId = id;
        this.city = name;
        this.citys = city;
    }

    public TCity(String id, String name) {
        this.cityId = id;
        this.city = name;
    }
}
