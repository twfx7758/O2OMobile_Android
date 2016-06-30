package com.insthub.O2OMobile.Model;

import android.content.Context;

import com.BeeFramework.model.BaseModel;
import com.BeeFramework.model.BeeCallback;
import com.external.androidquery.callback.AjaxStatus;
import com.insthub.O2OMobile.O2OMobileAppConst;
import com.insthub.O2OMobile.Protocol.ApiInterface;
import com.insthub.O2OMobile.Protocol.ENUM_SEARCH_ORDER;
import com.insthub.O2OMobile.Protocol.LOCATION;
import com.insthub.O2OMobile.Protocol.ShopInfo;
import com.insthub.O2OMobile.Protocol.ShopInfoRequest;
import com.insthub.O2OMobile.Protocol.ShopInfoResponse;
import com.insthub.O2OMobile.SESSION;
import com.insthub.O2OMobile.Utils.LocationManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by quwb on 2016/6/30.
 */
public class ShopInfoModel extends BaseModel
{
    public ArrayList<ShopInfo> dataList = new ArrayList<ShopInfo>();
    public static final int NUMPERPAGE = 10;
    public ShopInfoModel(Context context)
    {
        super(context);
    }

    public void fetPreService(int serviceId,ENUM_SEARCH_ORDER search_order)
    {
        ShopInfoRequest shopInfoRequest = new ShopInfoRequest();
        shopInfoRequest.service_type = serviceId;
        shopInfoRequest.sid = SESSION.getInstance().sid;
        shopInfoRequest.uid = SESSION.getInstance().uid;
        shopInfoRequest.sort_by = search_order.value();
        shopInfoRequest.by_no = 1;
        shopInfoRequest.ver = O2OMobileAppConst.VERSION_CODE;
        shopInfoRequest.count = NUMPERPAGE;
        shopInfoRequest.location = new LOCATION();
        shopInfoRequest.location.lat = LocationManager.getLatitude();
        shopInfoRequest.location.lon = LocationManager.getLongitude();


        BeeCallback<JSONObject> cb = new BeeCallback<JSONObject>() {

            @Override
            public void callback(String url, JSONObject jo, AjaxStatus status) {
                try {
                    ShopInfoModel.this.callback(this, url, jo, status);
                    if (null != jo)
                    {
                        ShopInfoResponse response = new ShopInfoResponse();
                        response.fromJson(jo);

                        if(response.succeed == 1)
                        {
                            dataList.clear();
                            dataList.addAll(response.users);
                            ShopInfoModel.this.OnMessageResponse(url,jo,status);
                        }
                        else
                        {
                            ShopInfoModel.this.callback(url, response.error_code, response.error_desc);
                        }
                    }else{
                        ShopInfoModel.this.OnMessageResponse(url,jo,status);
                    }

                } catch (JSONException e) {

                }
            }
        };

        Map<String, Object> params = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = shopInfoRequest.toJson();
            params.put("json", shopInfoRequest.toJson().toString());

        } catch (JSONException e) {

        }
        if(isSendingMessage(ApiInterface.SHOPINFO_LIST)){
            return;
        }
        cb.url(ApiInterface.SHOPINFO_LIST).type(JSONObject.class).params(params);
        ajaxProgress(cb);

    }

    public void fetNextService(int serviceId,ENUM_SEARCH_ORDER search_order)
    {
        ShopInfoRequest shopInfoRequest = new ShopInfoRequest();
        shopInfoRequest.service_type = serviceId;
        shopInfoRequest.sid = SESSION.getInstance().sid;
        shopInfoRequest.uid = SESSION.getInstance().uid;
        shopInfoRequest.sort_by = search_order.value();
        shopInfoRequest.ver = O2OMobileAppConst.VERSION_CODE;
        if (dataList.size() > 0)
        {
            shopInfoRequest.by_no = (int)Math.ceil(dataList.size()*1.0/NUMPERPAGE) +1;
        }

        shopInfoRequest.count = NUMPERPAGE;
        shopInfoRequest.location = new LOCATION();
        shopInfoRequest.location.lat = LocationManager.getLatitude();
        shopInfoRequest.location.lon = LocationManager.getLongitude();


        BeeCallback<JSONObject> cb = new BeeCallback<JSONObject>() {

            @Override
            public void callback(String url, JSONObject jo, AjaxStatus status) {
                try {
                    ShopInfoModel.this.callback(this, url, jo, status);
                    if (null != jo)
                    {
                        ShopInfoResponse response = new ShopInfoResponse();
                        response.fromJson(jo);

                        if(response.succeed == 1)
                        {
                            dataList.addAll(response.users);
                            ShopInfoModel.this.OnMessageResponse(url,jo,status);
                        }
                        else
                        {
                            ShopInfoModel.this.callback(url, response.error_code, response.error_desc);
                        }
                    }else{
                        ShopInfoModel.this.OnMessageResponse(url,jo,status);
                    }

                } catch (JSONException e) {

                }
            }
        };

        Map<String, Object> params = new HashMap<String, Object>();
        try {
            JSONObject requestJson = shopInfoRequest.toJson();
            requestJson.remove("by_id");
            params.put("json", requestJson.toString());

        } catch (JSONException e) {

        }
        if(isSendingMessage(ApiInterface.SHOPINFO_LIST)){
            return;
        }
        cb.url(ApiInterface.SHOPINFO_LIST).type(JSONObject.class).params(params);
        ajax(cb);

    }
}
