package com.hys.musclehungry.adapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Hover on 2016/4/9.
 */
public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm, ArrayList<Fragment> viewList) {
        super(fm);
        this.viewList = viewList;
    }

    private ArrayList<Fragment> viewList =new ArrayList<>();

    @Override
    public Fragment getItem(int position) {
        return viewList.get(position);
    }

    @Override
    public int getCount() {
        return viewList.size();
    }
}
