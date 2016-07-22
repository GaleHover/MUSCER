package com.hys.musclehungry.fragment;


import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hys.musclehungry.Handler.ShopInfo2;
import com.hys.musclehungry.R;
import com.hys.musclehungry.UrlShop;
import com.hys.musclehungry.adapter.RecyclerViewAdapter;
import com.hys.musclehungry.entity.ShopInfo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChengPinFragment extends Fragment {

    private ArrayList<ShopInfo2> al=new ArrayList<>();
    Bitmap  iam ;
    Resources res;
    private RecyclerView mRecyclerView;
    private View view;
    String ustring;
    ShopInfo2 si;

    public ChengPinFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this.getContext(), "d60bb2cb24233b63224a1aeac7145a41");
        res =ChengPinFragment.this.getActivity().getResources();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cheng_pin, container, false);
        System.out.println("要进去了");

        BmobQuery<ShopInfo> query = new BmobQuery<ShopInfo>();
        query.order("score");
        query.findObjects(ChengPinFragment.this.getContext(), new FindListener<ShopInfo>() {
            @Override
            public void onSuccess(List<ShopInfo> object) {
                for (ShopInfo shop : object) {
                    si = new ShopInfo2();
                    si.setDescript(shop.getDescript());
                    si.setDianZan(shop.getDianZan());
                    si.setShopName(shop.getShopName());
                    si.setShopPrice(shop.getShopPrice());
                    si.setHiddenID(shop.getObjectId());
                    ustring = shop.getShopPic().getUrl();
                    CheckRath(ustring);
                    System.out.println(ustring+"成品");
                    al.add(si);

                }
                mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
                mRecyclerView.setAdapter(new RecyclerViewAdapter(view.getContext(), al));

                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                al=new ArrayList<ShopInfo2>();
                System.out.println("数组是多少："+al.size());
            }
            @Override
            public void onError(int code, String msg) {
            }
        });



        return view ;
    }/**
       *检测当前是竖屏还是横屏如果是竖屏则返回true
       */
    public static boolean isScreenOriatationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    public void CheckRath(String s){
        if(s.equals(UrlShop.aa1))
        {
            Bitmap bmp=BitmapFactory.decodeResource(res, R.mipmap.aa1);
            si.setShoppic(bmp);
        }
        else if(s.equals(UrlShop.aa3)){
            Bitmap bmp=BitmapFactory.decodeResource(res, R.mipmap.aa3);
            si.setShoppic(bmp);
        }
        else if(s.equals(UrlShop.aa4)){
            Bitmap bmp=BitmapFactory.decodeResource(res, R.mipmap.aa4);
            si.setShoppic(bmp);
        }
        else if(s.equals(UrlShop.aa5)){
            Bitmap bmp=BitmapFactory.decodeResource(res, R.mipmap.aa5);
            si.setShoppic(bmp);
        }
        else if(s.equals(UrlShop.aa8)){
            Bitmap bmp=BitmapFactory.decodeResource(res, R.mipmap.aa8);
            si.setShoppic(bmp);
        }
        else if(s.equals(UrlShop.aa6)){
            Bitmap bmp=BitmapFactory.decodeResource(res, R.mipmap.aa6);
            si.setShoppic(bmp);
        }
    }
}
