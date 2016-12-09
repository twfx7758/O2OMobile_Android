package com.insthub.O2OMobile.Model;

import android.content.Context;

import com.BeeFramework.model.BaseModel;
import com.BeeFramework.model.BeeCallback;
import com.external.androidquery.callback.AjaxStatus;
import com.insthub.O2OMobile.O2OMobileAppConst;
import com.insthub.O2OMobile.Protocol.ApiInterface;
import com.insthub.O2OMobile.Protocol.ENUM_SEARCH_ORDER;
import com.insthub.O2OMobile.Protocol.LOCATION;
import com.insthub.O2OMobile.Protocol.ShopDetail;
import com.insthub.O2OMobile.Protocol.ShopDetailRequest;
import com.insthub.O2OMobile.Protocol.ShopDetailResponse;
import com.insthub.O2OMobile.SESSION;
import com.insthub.O2OMobile.Utils.LocationManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by quwb on 2016/12/6.
 */

public class ShopDetailModel extends BaseModel{
    public ShopDetail shopDetail;
    public static final int NUMPERPAGE = 1;
    public ShopDetailModel(Context context){
        super(context);
    }

    public void fetPreDetail(int shopId, ENUM_SEARCH_ORDER search_order){
        ShopDetailRequest shopDetailRequest = new ShopDetailRequest();
        shopDetailRequest.sid = SESSION.getInstance().sid;
        shopDetailRequest.uid = SESSION.getInstance().uid;
        shopDetailRequest.sort_by = search_order.value();
        shopDetailRequest.by_no = 1;
        shopDetailRequest.ver = O2OMobileAppConst.VERSION_CODE;
        shopDetailRequest.count = NUMPERPAGE;
        shopDetailRequest.location = new LOCATION();
        shopDetailRequest.location.lat = LocationManager.getLatitude();
        shopDetailRequest.location.lon = LocationManager.getLongitude();
        shopDetailRequest.shopId = shopId;

        BeeCallback<JSONObject> cb = new BeeCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject jo, AjaxStatus status) {
                //super.callback(url, jo, status);
                try {
                    ShopDetailModel.this.callback(this, url, jo, status);
                    if(null != jo){
                        ShopDetailResponse response = new ShopDetailResponse();
                        response.fromJson(jo);

                        if(response.succeed == 1){
                            shopDetail = response.shopDetail;
                            ShopDetailModel.this.OnMessageResponse(url, jo, status);
                        }else{
                            ShopDetailModel.this.callback(url, response.error_code, response.error_desc);
                        }
                    }
                }catch (JSONException e){

                }
            }
        };

        Map<String, Object> params = new HashMap<String, Object>();
        try{
            JSONObject jsonObject = shopDetailRequest.toJson();
            params.put("json", shopDetailRequest.toJson().toString());
        }catch (JSONException e){

        }

        if(isSendingMessage(ApiInterface.SHOPINFO_DETAIL)){
            return;
        }

        cb.url(ApiInterface.SHOPINFO_DETAIL).type(JSONObject.class).params(params);
        ajaxProgress(cb);
    }

    public void fetNextDetail(int shopId, ENUM_SEARCH_ORDER search_order){
        ShopDetailRequest shopDetailRequest = new ShopDetailRequest();
        shopDetailRequest.shopId = shopId;
        shopDetailRequest.sid = SESSION.getInstance().sid;
        shopDetailRequest.uid = SESSION.getInstance().uid;
        shopDetailRequest.sort_by = search_order.value();
        shopDetailRequest.ver = O2OMobileAppConst.VERSION_CODE;
        shopDetailRequest.by_no = 0;
        shopDetailRequest.count = NUMPERPAGE;
        shopDetailRequest.location = new LOCATION();
        shopDetailRequest.location.lat = LocationManager.getLatitude();
        shopDetailRequest.location.lon = LocationManager.getLongitude();

        BeeCallback<JSONObject> cb = new BeeCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject jo, AjaxStatus status) {
                try{
                    ShopDetailModel.this.callback(this, url, jo, status);
                    if(null != jo){
                        ShopDetailResponse response = new ShopDetailResponse();
                        response.fromJson(jo);

                        if(response.succeed == 1){
                            shopDetail = response.shopDetail;
                            ShopDetailModel.this.callback(url, response.error_code, response.error_desc);
                        }
                    }else{
                        ShopDetailModel.this.OnMessageResponse(url, jo, status);
                    }
                }catch (JSONException e){

                }
            }
        };

        Map<String, Object> params = new HashMap<String, Object>();
        try{
            JSONObject requestJson = shopDetailRequest.toJson();
            requestJson.remove("by_id");
            params.put("json", requestJson.toString());
        }catch (JSONException e){

        }

        if(isSendingMessage(ApiInterface.SHOPINFO_DETAIL)){
            return;
        }

        cb.url(ApiInterface.SHOPINFO_DETAIL).type(JSONObject.class).params(params);
        ajax(cb);
    }
}
