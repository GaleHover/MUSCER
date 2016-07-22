package com.hys.musclehungry.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hys.musclehungry.Handler.ShopInfo2;
import com.hys.musclehungry.R;
import com.hys.musclehungry.entity.WantBuy;

import java.util.ArrayList;

/**
 * Created by Hover on 2016/5/12.
 */
public class wantBuyAdapter extends BaseAdapter {
    private ArrayList<WantBuy> wantBuys=new ArrayList<>();
    private LayoutInflater mInflater = null;
    private Context context;
    public wantBuyAdapter(ArrayList<WantBuy> wantBuys , Context context) {
        this.wantBuys = wantBuys;
        this.context = context;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return wantBuys.size();
    }

    @Override
    public Object getItem(int position) {
        return wantBuys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    ViewHolder viewHolder = null;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.list_want,null);
            viewHolder.u2name = (TextView) convertView.findViewById(R.id.u2name);
            viewHolder.u2price = (TextView) convertView.findViewById(R.id.u3price);
            viewHolder.uhidden = (TextView) convertView.findViewById(R.id.uhidd);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        WantBuy recommend =wantBuys.get(position);

        viewHolder.u2name.setText(recommend.getShopname());
        viewHolder.uhidden.setText(recommend.getShopid());
        viewHolder.u2price.setText(recommend.getShopprice()+"");
        return convertView;
    }
    class ViewHolder
    {
        public TextView u2name;
        public TextView u2price;
        public TextView uhidden;
    }
}
