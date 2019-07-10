package com.kgc.utils;

public class SearchHouse extends PageUtil {
    private String title;
    private Integer typeid;
    private Integer districtid;
    private Integer streetid;
    private Integer minprice;
    private Integer maxprice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    public Integer getStreetid() {
        return streetid;
    }

    public void setStreetid(Integer streetid) {
        this.streetid = streetid;
    }

    public Integer getMinprice() {
        return minprice;
    }

    public void setMinprice(Integer minprice) {
        this.minprice = minprice;
    }

    public Integer getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(Integer maxprice) {
        this.maxprice = maxprice;
    }
}
