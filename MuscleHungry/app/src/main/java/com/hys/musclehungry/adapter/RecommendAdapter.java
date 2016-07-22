package com.hys.musclehungry.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hys.musclehungry.Handler.ShopInfo2;
import com.hys.musclehungry.R;
import com.hys.musclehungry.entity.Like;
import com.hys.musclehungry.entity.Recommend;
import com.hys.musclehungry.entity.ShopInfo;
import com.hys.musclehungry.entity.WantBuy;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Hover on 2016/5/8.
 */
public class RecommendAdapter extends BaseAdapter {
    private ArrayList<ShopInfo2> arrayList;
    private LayoutInflater mInflater = null;
    private Context context;
    public RecommendAdapter(Context context, ArrayList<ShopInfo2> arrayList) {
        this.context = context;
        mInflater=LayoutInflater.from(context);
        this.arrayList = arrayList;
        Bmob.initialize(context, "d60bb2cb24233b63224a1aeac7145a41");

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.recommendation,null);
            viewHolder.tuPian = (ImageView) convertView.findViewById(R.id.tuPian);
            viewHolder.foodname = (TextView) convertView.findViewById(R.id.name);
            viewHolder.foodPrice = (TextView) convertView.findViewById(R.id.price);
            viewHolder.jieShao = (TextView) convertView.findViewById(R.id.jieshao);
            viewHolder.hiddenId = (TextView) convertView.findViewById(R.id.spid);
            viewHolder.dianzanshu = (TextView)convertView.findViewById(R.id.dianzanshu);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final ShopInfo2 recommend =arrayList.get(position);
//        BmobQuery<Like> query = new BmobQuery<Like>();
//        String username = (String) BmobUser.getObjectByKey(context, "username");
//        query.addWhereEqualTo("username",username);
//        query.addWhereEqualTo("shopId",recommend.getHiddenID());
//        query.findObjects(context, new FindListener<Like>() {
//            @Override
//            public void onSuccess(List<Like> object) {
//               if(object.size()!=0){
//                  viewll.findViewById(R.id.dianzan).setEnabled(false);
//                  Button button= (Button) viewll.findViewById(R.id.dianzan);
//                   button.setText("已赞");
//                   button.setBackgroundColor(Color.rgb(240,240,240));
//             }
//            }
//
//            @Override
//            public void onError(int code, String msg) {
//                // TODO Auto-generated method stub
//                System.out.println("没有点赞的");
//            }
//        });
        Button btn = (Button) convertView.findViewById(R.id.buyNow);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WantBuy wantBuy2=new WantBuy();
                wantBuy2.setShopid(recommend.getHiddenID());
                wantBuy2.setShopname(recommend.getShopName());
                wantBuy2.setUserid( (String) BmobUser.getObjectByKey(context, "username"));
                wantBuy2.setShopprice(recommend.getShopPrice());
                wantBuy2.save(context, new SaveListener() {

                    @Override
                    public void onSuccess() {
                        Toast.makeText(context, "购买成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int code, String arg0) {
                        // 添加失败
                    }
                });
            }
        });


        Button btn2 = (Button) convertView.findViewById(R.id.dianz);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShopInfo spp = new ShopInfo();
                spp.setDianZan(recommend.getDianZan()+1);
                Toast.makeText(context, "hh", Toast.LENGTH_SHORT).show();
                String s =  recommend.getHiddenID();
                spp.update(context,s, new UpdateListener() {

                    @Override
                    public void onSuccess() {
                        // TODO Auto-generated method stub
                        Toast.makeText(context, "点赞成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        // TODO Auto-generated method stub
                        Toast.makeText(context, "点赞失败", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });





        viewHolder.hiddenId.setText(recommend.getHiddenID());
        viewHolder.tuPian.setImageBitmap(recommend.getShoppic());
        viewHolder.foodname.setText(recommend.getShopName());
        viewHolder.foodPrice.setText("￥"+recommend.getShopPrice()+"/份");
        viewHolder.jieShao.setText(recommend.getDescript());
        viewHolder.dianzanshu.setText("已赞： "+recommend.getDianZan());
        return convertView;
    }
         class ViewHolder
        {
                public ImageView tuPian;
                public TextView jieShao;
                public TextView foodname;
                public TextView foodPrice;
                public TextView hiddenId;
                public TextView dianzanshu;
        }

}
