package com.hys.musclehungry.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hys.musclehungry.Handler.ShopInfo2;
import com.hys.musclehungry.R;
import com.hys.musclehungry.UrlShop;
import com.hys.musclehungry.adapter.HeaderBottomAdapter;
import com.hys.musclehungry.adapter.ImageAdapter;
import com.hys.musclehungry.adapter.RecommendAdapter;
import com.hys.musclehungry.adapter.ShowPager;
import com.hys.musclehungry.entity.Recommend;
import com.hys.musclehungry.entity.ShopInfo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

public class HomeFragment extends Fragment {
    private ArrayList<View> viewList;
    private View view1;
    private View view2;
    private View view3;
    private View view4;
    Resources res;



    private RecyclerView mRecyclerView;
    private HeaderBottomAdapter adapter;
    GridLayoutManager gridLayoutManager;
    LinearLayoutManager layoutManager;
    private ViewPager viewShow;
    private ListView listView;
    private Handler handler = new Handler();
    private ArrayList<ShopInfo2> arrayList = new ArrayList<ShopInfo2>();//数据源
    ImageView imageViewtest;
    View view;
    private Bitmap  iam =null;
    String ustring;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this.getContext(), "d60bb2cb24233b63224a1aeac7145a41");
        handler.postDelayed(changed, 2000);
        res =HomeFragment.this.getActivity().getResources();
//        Recommend recommend1 = new Recommend("人丑就要多吃糕", R.mipmap.aa3, "丑糕", "￥5.00/个", "dfdf");
//        Recommend recommend2 = new Recommend("萌萌哒", R.mipmap.aa1, "盖饭", "￥15.00/盒", "订单");
//        Recommend recommend3 = new Recommend("猜猜我是谁", R.mipmap.aa2, "就不告诉你", "￥20.00/盒", "订单");
//
//        arrayList.add(recommend1);
//        arrayList.add(recommend2);
//        arrayList.add(recommend3);
        BmobQuery<ShopInfo> query = new BmobQuery<ShopInfo>();
        query.order("DianZan");
        query.findObjects(this.getContext(), new FindListener<ShopInfo>() {
            @Override
            public void onSuccess(List<ShopInfo> object) {
                int i = 1;
                for (ShopInfo shop : object) {
                    if(i>3){
                        break;
                    }
                    i++;
                    si = new ShopInfo2();
                    si.setDescript(shop.getDescript());
                    si.setDianZan(shop.getDianZan());
                    si.setShopName(shop.getShopName());
                    si.setShopPrice(shop.getShopPrice());
                    si.setHiddenID(shop.getObjectId());

                    ustring = shop.getShopPic().getUrl();
                    CheckRath(ustring);

//                    new AsyncTask<Void,Void,Void>(){
//
//                        @Override
//                        protected Void doInBackground(Void... params) {
//                            try {
//                                URL surl =new URL(ustring);
//                                InputStream is = surl.openStream();
//                                iam = BitmapFactory.decodeStream(is);
//                                is.close();
//                                System.out.println(iam.toString());
////                                si.setShoppic(iam);
//
//                                return null;
//                            } catch (MalformedURLException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            return null ;
//                        }
//
////                        @Override
////                        protected void onPostExecute(Bitmap bitmap) {
////                            super.onPostExecute(bitmap);
////                        }
//                    }.execute();

                    System.out.println(ustring);

                    arrayList.add(si);

                }
            }
            @Override
            public void onError(int code, String msg) {
                // TODO Auto-generated method stub
                Toast.makeText(HomeFragment.this.getContext(), "失败了", Toast.LENGTH_SHORT).show();
            }
        });
    }
    ShopInfo2 si;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);
        view1 = inflater.inflate(R.layout.view1, null);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://a.eqxiu.com/s/s02ovXmU");
                intent.setData(content_url);
                startActivity(intent);
            }
        });
        view2 = inflater.inflate(R.layout.view2, null);
        view3 = inflater.inflate(R.layout.view3, null);
        view4 = inflater.inflate(R.layout.view4, null);
        viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        View headView = inflater.inflate(R.layout.header, null);
        // Inflate the layout for this fragment
        viewShow = (ViewPager) headView.findViewById(R.id.viewShow);
        viewShow.setAdapter(new ImageAdapter(viewList));
        viewShow.setCurrentItem(0);
        ImageView i = (ImageView) view.findViewById(R.id.dh);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://a.eqxiu.com/s/s02ovXmU");
                intent.setData(content_url);
                startActivity(intent);
            }
        });


        /**
        * 异步查询数据
        */



        /*
        *初始化Listview
         */
        listView = (ListView) view.findViewById(R.id.lista);
        listView.addHeaderView(headView);
        listView.setAdapter(new RecommendAdapter(HomeFragment.this.getContext(), arrayList));
        return view;
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



    /**
     * 切换视图
     */
    private int index = 0;
    private Changed changed = new Changed();
    class Changed implements Runnable {
        @Override
        public void run() {
            index++;
            index = index % 4;
            viewShow.setCurrentItem(index);
            handler.postDelayed(changed, 2000);
        }
    }



}
