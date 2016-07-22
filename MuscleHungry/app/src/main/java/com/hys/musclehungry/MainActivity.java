package com.hys.musclehungry;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hys.musclehungry.adapter.MyAdapter;
import com.hys.musclehungry.fragment.BuyFragment;
import com.hys.musclehungry.fragment.HomeFragment;
import com.hys.musclehungry.fragment.MeFragment;
import com.hys.musclehungry.fragment.OrderFragment;

import java.util.ArrayList;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Fragment> viewList;
    private ViewPager viewPager;
    private TextView tvHome;
    private ImageView ivHome;
    private TextView tvOrder;
    private ImageView ivOrder;
    private TextView tvMe;
    private ImageView ivMe;
    private ImageView ivBuy;
    private TextView tvBuy;
    private Resources res;
    private LinearLayout lyhome;
    private LinearLayout lyOrder;
    private LinearLayout lyMe;
    private LinearLayout lyBuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Bmob.initialize(this,"d60bb2cb24233b63224a1aeac7145a41");
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent();
//        intent.setAction("android.intent.action.VIEW");
//        Uri content_url = Uri.parse("http://a.eqxiu.com/s/s02ovXmU");
//        intent.setData(content_url);
//        startActivity(intent);

        LayoutInflater inflater = getLayoutInflater();//
        View v =inflater.inflate(R.layout.rv_header,null);
        LinearLayout linearLayout= (LinearLayout) v.findViewById(R.id.linearla);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "gongxinl ", Toast.LENGTH_SHORT).show();
            }
        });
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //  获取四个fragment
        initView();

        firstSelected();
        findViewById(R.id.wantbuy).setOnClickListener(this);
        Fragment order=new OrderFragment();
        Fragment home =new HomeFragment();
        Fragment me =new MeFragment();
        Fragment buy = new BuyFragment();
        viewList.add(home);
        viewList.add(buy);
        viewList.add(order);
        viewList.add(me);

        viewPager.setAdapter(new MyAdapter(this.getSupportFragmentManager(), viewList));
        viewPager.setCurrentItem(0);
        Intent ik=getIntent();
        String tmp = ik.getStringExtra("extra");
        if(tmp!=null)
        {
            viewPager.setCurrentItem(2);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        firstSelected();
                        secondUnselected();
                        thirdUnselected();
                        forthUnselected();
                        break;
                    case 1:
                        firstUnselected();
                        secondSelected();
                        thirdUnselected();
                        forthUnselected();
                        break;
                    case 2:
                        firstUnselected();
                        secondUnselected();
                        thirdSelected();
                        forthUnselected();
                        break;
                    case 3:
                        firstUnselected();
                        secondUnselected();
                        thirdUnselected();
                        forthSelected();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 初始化控件
     */
    public void initView() {
        /*
           底部导航栏控件初始化
         */
        tvHome = (TextView) findViewById(R.id.tvhome);
        tvOrder = (TextView) findViewById(R.id.tvorder);
        tvMe = (TextView) findViewById(R.id.tvme);
        tvBuy = (TextView) findViewById(R.id.tvBuy);

        ivHome = (ImageView) findViewById(R.id.ivhome);
        ivMe = (ImageView) findViewById(R.id.ivme);
        ivOrder = (ImageView) findViewById(R.id.ivorder);
        ivBuy = (ImageView) findViewById(R.id.ivBuy);

        //获得资源对象
        res = getResources();
        //初始化viewpager的子选项
        viewList = new ArrayList<Fragment>();

        /*
            底部导航栏初始化 添加监听事件
         */
        lyhome = (LinearLayout) findViewById(R.id.lyhome);
        lyOrder = (LinearLayout) findViewById(R.id.lyorder);
        lyMe = (LinearLayout) findViewById(R.id.lyme);
        lyBuy =  (LinearLayout) findViewById(R.id.lvbuy);

        lyhome.setOnClickListener(this);
        lyOrder.setOnClickListener(this);
        lyMe.setOnClickListener(this);
        lyBuy.setOnClickListener(this);

        /*
             初始化food 列表的控件
         */

    }
    /**
     * 底部导航栏中第一个选项选中时控件的变化
     */
    public void firstSelected() {

        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.homeu);
        ivHome.setImageBitmap(bmp);
        lyhome.setBackgroundColor(Color.rgb(139, 195, 74));
        tvHome.setTextColor(Color.rgb(255, 255, 255));

    }
    /**
     * 底部导航栏中第一个选项未选中时控件的变化
     */
    public void firstUnselected() {
        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.homes);
        ivHome.setImageBitmap(bmp);
        lyhome.setBackgroundColor(Color.rgb(250, 250, 250));
        tvHome.setTextColor(Color.rgb(0, 0, 0));
    }

    /**
     * 第二个未选中
     */
    public void secondUnselected() {
        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.buys);
        ivBuy.setImageBitmap(bmp);
        lyBuy.setBackgroundColor(Color.rgb(250, 250, 250));
        tvBuy.setTextColor(Color.rgb(0, 0, 0));
    }

    /**
     * 第二个选中
     */
    public void secondSelected() {

        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.buyu);
        ivBuy.setImageBitmap(bmp);
        lyBuy.setBackgroundColor(Color.rgb(139, 195, 74));
        tvBuy.setTextColor(Color.rgb(255, 255, 255));

    }
    /**
     * 底部导航栏中第三个选项选中时控件的变化
     */
    public void thirdSelected() {

        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.dingu);
        ivOrder.setImageBitmap(bmp);
        lyOrder.setBackgroundColor(Color.rgb(139, 195, 74));
        tvOrder.setTextColor(Color.rgb(255, 255, 255));

    }
    /**
     * 底部导航栏中第三个选项未选中时控件的变化
     */
    public void thirdUnselected() {
        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.dings);
        ivOrder.setImageBitmap(bmp);
        lyOrder.setBackgroundColor(Color.rgb(250, 250, 250));
        tvOrder.setTextColor(Color.rgb(0, 0, 0));
    }

    /**
     * 底部导航栏中第四个选项选中时控件的变化
     */
    public void forthSelected() {
        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.meu);
        ivMe.setImageBitmap(bmp);
        lyMe.setBackgroundColor(Color.rgb(139, 195, 74));
        tvMe.setTextColor(Color.rgb(255, 255, 255));

    }

    /**
     * 底部导航栏中第四个选项未选中时控件的变化
     */
    public void forthUnselected() {
        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.mes);
        ivMe.setImageBitmap(bmp);
        lyMe.setBackgroundColor(Color.rgb(250, 250, 250));
        tvMe.setTextColor(Color.rgb(0, 0, 0));
    }
      /**
     * 底部导航栏 menu的监听事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lyhome:
                viewPager.setCurrentItem(0);
                break;
            case R.id.lvbuy:
                viewPager.setCurrentItem(1);
                break;
            case R.id.lyorder:
                viewPager.setCurrentItem(2);
                break;
            case R.id.lyme:
                viewPager.setCurrentItem(3);
                break;
            case R.id.wantbuy:
                Intent i = new Intent(MainActivity.this,WantBuys.class);
                startActivity(i);
                break;

        }
    }

}
