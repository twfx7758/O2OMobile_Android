package com.insthub.O2OMobile.Activity;

import android.os.Bundle;
import android.app.Activity;

import com.BeeFramework.activity.BaseActivity;
import com.BeeFramework.model.BusinessResponse;
import com.external.androidquery.callback.AjaxStatus;
import com.external.maxwin.view.IXListViewListener;
import com.insthub.O2OMobile.R;

import org.json.JSONException;
import org.json.JSONObject;

public class ShopDetailActivity extends BaseActivity implements BusinessResponse, IXListViewListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
    }

    @Override
    public void OnMessageResponse(String url, JSONObject jo, AjaxStatus status) throws JSONException {

    }

    @Override
    public void onRefresh(int id) {

    }

    @Override
    public void onLoadMore(int id) {

    }
}
