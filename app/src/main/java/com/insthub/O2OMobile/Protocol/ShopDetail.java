package com.insthub.O2OMobile.Protocol;

import com.external.activeandroid.DataBaseModel;
import com.external.activeandroid.annotation.Column;
import com.external.activeandroid.annotation.Table;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by quwb on 2016/12/6.
 */
@Table(name="ShopDetail")
public class ShopDetail extends DataBaseModel{
    @Column(name = "ShopID")
    public int ShopID;

    @Column(name = "ShopTitle")
    public String ShopTitle;

    @Column(name = "ShopDes")
    public String ShopDes;

    public  void fromJson(JSONObject jsonObject) throws JSONException{
        if(jsonObject == null){
            return;
        }

        JSONArray subItemArray;
        this.ShopID = jsonObject.optInt("ShopID");
        this.ShopTitle = jsonObject.optString("ShopTitle");
        this.ShopDes = jsonObject.optString("ShopDes");

        return;
    }

    public  JSONObject toJson() throws JSONException{
        JSONObject localItmeObject = new JSONObject();
        localItmeObject.put("ShopID", this.ShopID);
        localItmeObject.put("ShopTitle", this.ShopTitle);
        localItmeObject.put("ShopDes", this.ShopDes);
        return localItmeObject;
    }
}
