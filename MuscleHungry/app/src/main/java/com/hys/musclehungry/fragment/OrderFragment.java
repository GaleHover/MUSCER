package com.hys.musclehungry.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hys.musclehungry.R;
import com.hys.musclehungry.adapter.OrderAdapter;
import com.hys.musclehungry.adapter.wantBuyAdapter;
import com.hys.musclehungry.entity.Order;
import com.hys.musclehungry.entity.WantBuy;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {
    ArrayList<Order> arrayList =new ArrayList<>();
    View view;
    ListView listView;
    String username;
    Order wa;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        username  = (String) BmobUser.getObjectByKey(OrderFragment.this.getContext(), "username");

        BmobQuery<Order> query = new BmobQuery<Order>();
        query.addWhereEqualTo("userid",username);
        query.findObjects(this.getContext(), new FindListener<Order>() {
            @Override
            public void onSuccess(List<Order> object) {
                for (Order wB : object) {
                    wa= new Order();
                    wa.setUserid(wB.getUserid());
                    wa.setXinxi(wB.getXinxi());
                    wa.setPhone(wB.getPhone());
                    wa.setAddress(wB.getAddress());
                    wa.setZhuangtai(wB.getZhuangtai());
                    wa.setUserid(username);
                    arrayList.add(wa);
                }
            }
            @Override
            public void onError(int code, String msg) {

            }
        });

        listView = (ListView) view.findViewById(R.id.lst);
        listView.setAdapter(new OrderAdapter(this.getContext(),arrayList));


        return view;
    }

}
