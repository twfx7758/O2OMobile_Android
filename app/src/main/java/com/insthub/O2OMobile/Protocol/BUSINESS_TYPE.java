package com.insthub.O2OMobile.Protocol;

/**
 * Created by quwb on 2016/6/26.
 */
import com.external.activeandroid.DataBaseModel;
import com.external.activeandroid.annotation.Table;
import com.external.activeandroid.annotation.Column;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Table(name = "BUSINESS_TYPE")
public class BUSINESS_TYPE extends DataBaseModel {
    @Column(name = "BusinessID")
    public int BusinessID;

    @Column(name = "BusinessDes")
    public String BusinessDes;

    @Column(name = "SortNum")
    public short SortNum;

    @Column(name = "IsShow")
    public short IsShow;

    @Column(name = "Icon")
    public String Icon;

    @Column(name = "LargeIcon")
    public String LargeIcon;

    public void fromJson(JSONObject jsonObject) throws JSONException{
        if(null == jsonObject){
            return ;
        }

        JSONArray subItemArray;
        this.BusinessID = jsonObject.optInt("BusinessID");
        this.BusinessDes = jsonObject.optString("BusinessDes");
        this.SortNum = (short)jsonObject.optInt("SortNum");
        this.IsShow = (short)jsonObject.optInt("IsShow");
        this.Icon = jsonObject.optString("Icon");
        this.LargeIcon = jsonObject.optString("LargeIcon");

        return ;
    }

    public JSONObject toJson() throws JSONException{
        JSONObject localItemObject = new JSONObject();
        localItemObject.put("BusinessID", this.BusinessID);
        localItemObject.put("BusinessDes", this.BusinessDes);
        localItemObject.put("SortNum", this.SortNum);
        localItemObject.put("IsShow", this.IsShow);
        localItemObject.put("Icon", this.Icon);
        localItemObject.put("LargeIcon", this.LargeIcon);

        return localItemObject;
    }
}
