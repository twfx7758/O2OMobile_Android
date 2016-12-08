package com.insthub.O2OMobile.Activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.BeeFramework.activity.BaseActivity;
import com.BeeFramework.model.BusinessResponse;
import com.external.androidquery.callback.AjaxStatus;
import com.external.eventbus.EventBus;
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
    int                 mShopId;
    ShopDetailModel     mDataModel;
    ImageView           mBackButton;
    TextView            mTitleTextView;
    ImageView           mRightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        //商铺主键ID
        mShopId = (int)getIntent().getLongExtra(SHOP_ID, 0);
        //返回按钮
        mBackButton = (ImageView)findViewById(R.id.top_view_back);
        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //从Activity栈移除此Activity
                finish();
            }
        });
        //标题
        mTitleTextView = (TextView)findViewById(R.id.top_view_title);
        mTitleTextView.setText(Integer.toString(mShopId));
        //详情页隐藏筛选框
        mRightButton = (ImageView)findViewById(R.id.top_view_right_image);
        mRightButton.setVisibility(View.GONE);
        //Model
        mDataModel = new ShopDetailModel(this);
        mDataModel.addResponseListener(this);

        EventBus.getDefault().register(this);
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
