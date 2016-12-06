package com.insthub.O2OMobile.Model;

import android.content.Context;

import com.BeeFramework.model.BaseModel;
import com.insthub.O2OMobile.Protocol.ENUM_SEARCH_ORDER;
import com.insthub.O2OMobile.Protocol.ShopDetail;

import java.util.ArrayList;

/**
 * Created by quwb on 2016/12/6.
 */

public class ShopDetailModel extends BaseModel{
    public ArrayList<ShopDetail> datalist = new ArrayList<ShopDetail>();
    public ShopDetailModel(Context context){
        super(context);
    }

    public  void fetPreService(int serviceId, ENUM_SEARCH_ORDER search_order){

    }
}
