package com.insthub.O2OMobile.Protocol;

import com.external.activeandroid.DataBaseModel;
import com.external.activeandroid.annotation.Column;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by quwb on 2016/12/6.
 */

public class ShopDetailResponse extends DataBaseModel{
    @Column(name = "total")
    public int total;

    public ShopDetail shopDetail;

    @Column(name = "more")
    public int more;

    @Column(name = "succeed")
    public int succeed;

    @Column(name = "count")
    public int count;

    @Column(name = "error_code")
    public int error_code;

    @Column(name = "error_desc")
    public String   error_desc;

    public void  fromJson(JSONObject jsonObject)  throws JSONException
    {
        if(null == jsonObject){
            return ;
        }

        this.total = jsonObject.optInt("total");

        ShopDetail detail = new ShopDetail();
        detail.fromJson(jsonObject.optJSONObject("ShopDetail"));
        this.shopDetail = detail;
        this.more = jsonObject.optInt("more");
        this.succeed = jsonObject.optInt("succeed");
        this.count = jsonObject.optInt("count");
        this.error_code = jsonObject.optInt("error_code");
        this.error_desc = jsonObject.optString("error_desc");
        return ;
    }

    public JSONObject  toJson() throws JSONException
    {
        JSONObject localItemObject = new JSONObject();
        JSONArray itemJSONArray = new JSONArray();
        localItemObject.put("total", total);
        if(this.shopDetail != null)
            localItemObject.put("ShopDetail", this.shopDetail.toJson());
        localItemObject.put("more", more);
        localItemObject.put("succeed", succeed);
        localItemObject.put("count", count);
        localItemObject.put("error_code", error_code);
        localItemObject.put("error_desc", error_desc);
        return localItemObject;
    }
}
