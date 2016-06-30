package com.insthub.O2OMobile.Protocol;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.external.activeandroid.DataBaseModel;
import com.external.activeandroid.annotation.Column;
import com.external.activeandroid.annotation.Table;

/**
 * Created by quwb on 2016/6/19.
 */
@Table(name = "businesstypelistRequest")
public class businesstypelistRequest extends DataBaseModel{
    @Column(name = "BusinessID")
    public int BusinessID;

    @Column(name = "BusinessDes")
    public String BusinessDes;

    @Column(name = "SortNum")
    public int SortNum;

    @Column(name = "IsShow")
    public int IsShow;

    public void fromJson(JSONObject jsonObject) throws JSONException{
        if(null == jsonObject)
            return;

        this.BusinessID = jsonObject.optInt("BusinessID");
        this.BusinessDes = jsonObject.optString("BusinessDes");
        this.SortNum = jsonObject.optInt("SortNum");
        this.IsShow = jsonObject.optInt("IsShow");

        return;
    }

    public JSONObject toJson() throws JSONException{
        JSONObject localItemObject = new JSONObject();
        localItemObject.put("BusinessID", BusinessID);
        localItemObject.put("BusinessDes", BusinessDes);
        localItemObject.put("SortNum", SortNum);
        localItemObject.put("IsShow", IsShow);

        return localItemObject;
    }
}
