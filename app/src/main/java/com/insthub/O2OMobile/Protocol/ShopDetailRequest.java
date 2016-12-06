package com.insthub.O2OMobile.Protocol;

import com.external.activeandroid.DataBaseModel;
import com.external.activeandroid.annotation.Column;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by quwb on 2016/12/6.
 */

public class ShopDetailRequest extends DataBaseModel{
    @Column(name = "uid")
    public int uid;

    @Column(name = "sid")
    public String   sid;

    @Column(name = "by_id")
    public int by_id;

    @Column(name = "by_no")
    public int by_no;

    @Column(name = "count")
    public int count;

    @Column(name = "sort_by")
    public int sort_by;

    @Column(name = "location")
    public LOCATION   location;

    @Column(name = "shopId")
    public int shopId;

    @Column(name = "ver")
    public int ver;

    public void fromJson(JSONObject jsonObject) throws JSONException{
        if(null == jsonObject){
            return;
        }

        this.uid = jsonObject.optInt("uid");
        this.sid = jsonObject.optString("sid");
        this.by_id = jsonObject.optInt("by_id");
        this.by_no = jsonObject.optInt("by_no");
        this.count = jsonObject.optInt("count");
        this.sort_by = jsonObject.optInt("sort_by");
        LOCATION  location = new LOCATION();
        location.fromJson(jsonObject.optJSONObject("location"));
        this.location = location;
        this.shopId = jsonObject.optInt("shopId");
        this.ver = jsonObject.optInt("ver");
        return;
    }

    public JSONObject  toJson() throws JSONException
    {
        JSONObject localItemObject = new JSONObject();
        JSONArray itemJSONArray = new JSONArray();
        localItemObject.put("uid", uid);
        localItemObject.put("sid", sid);
        localItemObject.put("by_id", by_id);
        localItemObject.put("by_no", by_no);
        localItemObject.put("count", count);
        localItemObject.put("sort_by", sort_by);
        if(null != location)
        {
            localItemObject.put("location", location.toJson());
        }
        localItemObject.put("shopId", shopId);
        localItemObject.put("ver", ver);
        return localItemObject;
    }
}
