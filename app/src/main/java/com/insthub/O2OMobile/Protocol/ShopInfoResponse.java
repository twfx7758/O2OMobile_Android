package com.insthub.O2OMobile.Protocol;

import com.external.activeandroid.DataBaseModel;
import com.external.activeandroid.annotation.Column;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by quwb on 2016/6/30.
 */
public class ShopInfoResponse  extends DataBaseModel
{

    @Column(name = "total")
    public int total;

    public ArrayList<ShopInfo> users = new ArrayList<ShopInfo>();

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

        JSONArray subItemArray;

        this.total = jsonObject.optInt("total");

        subItemArray = jsonObject.optJSONArray("users");
        if(null != subItemArray)
        {
            for(int i = 0;i < subItemArray.length();i++)
            {
                JSONObject subItemObject = subItemArray.getJSONObject(i);
                ShopInfo subItem = new ShopInfo();
                subItem.fromJson(subItemObject);
                this.users.add(subItem);
            }
        }


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

        for(int i =0; i< users.size(); i++)
        {
            ShopInfo itemData = users.get(i);
            JSONObject itemJSONObject = itemData.toJson();
            itemJSONArray.put(itemJSONObject);
        }
        localItemObject.put("users", itemJSONArray);
        localItemObject.put("more", more);
        localItemObject.put("succeed", succeed);
        localItemObject.put("count", count);
        localItemObject.put("error_code", error_code);
        localItemObject.put("error_desc", error_desc);
        return localItemObject;
    }

}