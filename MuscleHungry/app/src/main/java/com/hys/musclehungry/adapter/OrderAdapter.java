package com.hys.musclehungry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hys.musclehungry.R;
import com.hys.musclehungry.entity.Order;

import java.util.ArrayList;

/**
 * Created by Hover on 2016/5/12.
 */
public class OrderAdapter extends BaseAdapter{
ArrayList<Order> arrayList =new ArrayList<>();
    private LayoutInflater mInflater = null;
    private Context context;

    public OrderAdapter(Context context, ArrayList<Order> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
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
            convertView = mInflater.inflate(R.layout.item_order,null);
            viewHolder.address = (TextView) convertView.findViewById(R.id.namesd);
            viewHolder.xinxi = (TextView) convertView.findViewById(R.id.pricesd);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Order re =arrayList.get(position);
        viewHolder.xinxi .setText(re.getXinxi());
        viewHolder.address.setText(re.getAddress());

        return convertView;
    }
    class ViewHolder
    {
        public TextView address;
        public TextView xinxi;
    }



}
