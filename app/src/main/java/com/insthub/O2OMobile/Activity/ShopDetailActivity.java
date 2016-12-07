package com.insthub.O2OMobile.Activity;

import android.os.Bundle;
import android.app.Activity;

import com.BeeFramework.activity.BaseActivity;
import com.BeeFramework.model.BusinessResponse;
import com.external.androidquery.callback.AjaxStatus;
import com.external.maxwin.view.IXListViewListener;
import com.insthub.O2OMobile.Model.ShopDetailModel;
import com.insthub.O2OMobile.Model.ShopInfoModel;
import com.insthub.O2OMobile.Protocol.ApiInterface;
import com.insthub.O2OMobile.Protocol.ShopDetailResponse;
import com.insthub.O2OMobile.R;
import com.insthub.O2OMobile.Utils.LocationManager;

import org.json.JSONException;
import org.json.JSONObject;

public class ShopDetailActivity extends BaseActivity implements BusinessResponse{

    public static final String SHOP_ID = "shop_id";
    ShopDetailModel mDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        mDataModel = new ShopDetailModel(this);
        mDataModel.addResponseListener(this);

        LocationManager.getInstance().refreshLocation();
    }

    @Override
    public void OnMessageResponse(String url, JSONObject jo, AjaxStatus status) throws JSONException {
        if(url.endsWith(ApiInterface.SHOPINFO_DETAIL)){
            if(null != jo){
                ShopDetailResponse response = new ShopDetailResponse();
                response.fromJson(jo);
            }
        }
    }
}
