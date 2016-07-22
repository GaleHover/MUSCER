package com.hys.musclehungry.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hys.musclehungry.R;
import com.hys.musclehungry.adapter.BuyAdapter;
import com.hys.musclehungry.adapter.RecyclerViewAdapter;

import java.util.ArrayList;


public class BuyFragment extends Fragment implements View.OnClickListener {
    private ViewPager viewPager;
    private Button btnZiZhi;
    private Button btnChengPin;
    private Fragment fragment;
    private Fragment fragment1;

    public BuyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buy, null);
        btnZiZhi = (Button) view.findViewById(R.id.zizhi);
        btnZiZhi.setOnClickListener(this);
        btnChengPin = (Button) view.findViewById(R.id.chengpin);
        btnChengPin.setOnClickListener(this);

        viewPager = (ViewPager) view.findViewById(R.id.buyShow);
        ArrayList<Fragment> viewList = new ArrayList<>();
        fragment= new ChengPinFragment();
        fragment1 =new ZiZhi();
        viewList.add(fragment);
        viewList.add(fragment1);

        viewPager.setAdapter(new BuyAdapter(this.getChildFragmentManager(), viewList));


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zizhi:
                viewPager.setCurrentItem(1);
                btnZiZhi.setBackgroundColor(Color.rgb(139,195,74));
                btnZiZhi.setTextColor(Color.rgb(255,255,255));
                btnChengPin.setBackgroundColor(Color.rgb(255,255,255));
                btnChengPin.setTextColor(Color.rgb(139,195,74));
                break;
            case R.id.chengpin:
                viewPager.setCurrentItem(0);
                btnChengPin.setBackgroundColor(Color.rgb(139,195,74));
                btnChengPin.setTextColor(Color.rgb(255,255,255));
                btnZiZhi.setBackgroundColor(Color.rgb(255,255,255));
                btnZiZhi.setTextColor(Color.rgb(139,195,74));
                break;
        }
    }


}
