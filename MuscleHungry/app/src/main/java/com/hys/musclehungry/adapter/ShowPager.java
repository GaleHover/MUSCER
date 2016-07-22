package com.hys.musclehungry.adapter;

import android.support.v4.util.ArrayMap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Hover on 2016/5/6.
 */
public class ShowPager extends PagerAdapter{
    private ArrayList<View> arrayList;

    public ShowPager(ArrayList<View> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(arrayList.get(position));
        return arrayList.get(position);
    }
    public void destroyItem(ViewGroup view, int position, Object object) {

        view.removeView(arrayList.get(position));

    }


}
