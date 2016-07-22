package com.hys.musclehungry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.hys.musclehungry.Handler.ShopInfo2;
import com.hys.musclehungry.adapter.wantBuyAdapter;
import com.hys.musclehungry.entity.ShopInfo;
import com.hys.musclehungry.entity.WantBuy;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;

public class WantBuys extends AppCompatActivity implements View.OnClickListener {
private ArrayList<WantBuy> arrayList = new ArrayList<>();
    ListView listView;
    WantBuy wa;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"d60bb2cb24233b63224a1aeac7145a41");
        setContentView(R.layout.activity_want_buy);
         findViewById(R.id.jiesuan).setOnClickListener(this);
        username  = (String) BmobUser.getObjectByKey(WantBuys.this, "username");

        BmobQuery<WantBuy> query = new BmobQuery<WantBuy>();
        query.addWhereEqualTo("userid",username);

        query.findObjects(this, new FindListener<WantBuy>() {
            @Override
            public void onSuccess(List<WantBuy> object) {
                int i = 1;
                for (WantBuy wB : object) {
                    wa= new WantBuy();
                    wa.setUserid(wB.getUserid());
                    wa.setShopid(wB.getShopid());
                    wa.setShopprice(wB.getShopprice());
                    System.out.println(wB.getShopprice());
                    wa.setShopname(wB.getShopname());
                    wa.setUserid(username);
                    arrayList.add(wa);
                }
            }
            @Override
            public void onError(int code, String msg) {

            }
        });

        listView = (ListView) findViewById(R.id.lswt);
        listView.setAdapter(new wantBuyAdapter(arrayList,this));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jiesuan:
                Intent intent = new Intent(WantBuys.this,MainActivity.class);
                intent.putExtra("extra","dsd");
                startActivity(intent);

                break;
        }

    }
}
