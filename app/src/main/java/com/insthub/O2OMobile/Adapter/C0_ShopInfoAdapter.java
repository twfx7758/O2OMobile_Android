package com.insthub.O2OMobile.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.insthub.O2OMobile.Protocol.ShopInfo;
import com.insthub.O2OMobile.R;

import com.BeeFramework.adapter.BeeBaseAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by quwb on 2016/6/30.
 */
public class C0_ShopInfoAdapter extends BeeBaseAdapter{
    public ImageLoader mImageLoader = ImageLoader.getInstance();

    public C0_ShopInfoAdapter(Context c, ArrayList dataList){
        super(c, dataList);
    }

    public class C0_ShopCellHolder extends BeeCellHolder{
        ImageView headImage;
        TextView shoptitle;
        TextView shopaddr;
    }

    @Override
    protected BeeCellHolder createCellHolder(View cellView) {
        C0_ShopCellHolder holder = new C0_ShopCellHolder();
        holder.headImage = (ImageView)cellView.findViewById(R.id.c0_head_image);
        holder.shoptitle = (TextView)cellView.findViewById(R.id.c0_shoptitle);
        holder.shopaddr = (TextView)cellView.findViewById(R.id.c0_shopaddr);

        return holder;
    }

    @Override
    public View createCellView() {

        return mInflater.inflate(R.layout.c0_shopinfo_cell, null);
    }

    @Override
    protected View bindData(int position, View cellView, ViewGroup parent, BeeCellHolder h) {
        ShopInfo shopInfo = (ShopInfo)dataList.get(position);
        C0_ShopCellHolder holder = (C0_ShopCellHolder)h;
        holder.shoptitle.setText(shopInfo.ShopTitle);
        String strArea = shopInfo.CityName + "-" + shopInfo.AreaName;
        if(shopInfo.CityName == "" && shopInfo.AreaName == "")
            strArea = "北京";
        holder.shopaddr.setText(strArea);

        return null;
    }
}
