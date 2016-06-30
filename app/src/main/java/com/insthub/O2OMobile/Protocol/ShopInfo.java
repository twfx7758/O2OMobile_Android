package com.insthub.O2OMobile.Protocol;

import com.external.activeandroid.DataBaseModel;
import com.external.activeandroid.annotation.Column;
import com.external.activeandroid.annotation.Table;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by quwb on 2016/6/30.
 */
@Table(name = "ShopInfo")
public class ShopInfo extends DataBaseModel{
    @Column(name = "AreaName")
    public String AreaName;

    @Column(name = "BurgName")
    public String BurgName;

    @Column(name = "CityName")
    public String CityName;

    @Column(name = "Mobile")
    public String Mobile;

    @Column(name = "ShopArea")
    public int ShopArea;

    @Column(name = "ShopDisc")
    public String ShopDisc;

    @Column(name = "ShopID")
    public long ShopID;

    @Column(name = "ShopPrice")
    public String ShopPrice;

    @Column(name = "ShopTitle")
    public String ShopTitle;

    @Column(name = "ShopName")
    public String ShopName;

    public void fromJson(JSONObject jsonObject) throws JSONException{
        if(null == jsonObject){
            return ;
        }

        JSONArray subItemArray;
        this.AreaName = jsonObject.optString("AreaName");
        this.BurgName = jsonObject.optString("BurgName");
        this.CityName = jsonObject.optString("CityName");
        this.Mobile = jsonObject.optString("Mobile");
        this.ShopArea = jsonObject.optInt("ShopArea");
        this.ShopDisc = jsonObject.optString("ShopDisc");
        this.ShopID = jsonObject.optLong("ShopID");
        this.ShopName = jsonObject.optString("ShopName");
        this.ShopPrice = jsonObject.optString("ShopPrice");
        this.ShopTitle = jsonObject.optString("ShopTitle");

        return ;
    }

    public JSONObject toJson() throws JSONException{
        JSONObject localItemObject = new JSONObject();
        localItemObject.put("AreaName", this.AreaName);
        localItemObject.put("BurgName", this.BurgName);
        localItemObject.put("CityName", this.CityName);
        localItemObject.put("Mobile", this.Mobile);
        localItemObject.put("ShopArea", this.ShopArea);
        localItemObject.put("ShopDisc", this.ShopDisc);
        localItemObject.put("ShopID", this.ShopID);
        localItemObject.put("ShopName", this.ShopName);
        localItemObject.put("ShopPrice", this.ShopPrice);
        localItemObject.put("ShopTitle", this.ShopTitle);
        return localItemObject;
    }
}
