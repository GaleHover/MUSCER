package com.hys.musclehungry.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hys.musclehungry.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZiZhi extends Fragment implements View.OnClickListener {


    public ZiZhi() {
        // Required empty public constructor
    }
    private LinearLayout lyshucai;
    private LinearLayout lyrou;
    private LinearLayout lymifan;
    private LinearLayout lygaodian;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_zi_zhi, container, false);
        view.findViewById(R.id.shucai).setOnClickListener(this);
        view.findViewById(R.id.rou).setOnClickListener(this);
        view.findViewById(R.id.mifan).setOnClickListener(this);
        view.findViewById(R.id.gaodian).setOnClickListener(this);

        lyshucai= (LinearLayout) view.findViewById(R.id.lyshucai);
        lyrou = (LinearLayout) view.findViewById(R.id.lyrou);
        lygaodian= (LinearLayout) view .findViewById(R.id.lygaodian);
        lymifan = (LinearLayout) view.findViewById(R.id.lymi);
        lyrou.setVisibility(View.GONE);
        lygaodian.setVisibility(View.GONE);
        lymifan.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shucai:
                lyshucai.setVisibility(View.VISIBLE);
                lyrou.setVisibility(View.GONE);
                lymifan.setVisibility(View.GONE);
                lygaodian.setVisibility(View.GONE);

                break;
            case R.id.rou:
                lyrou.setVisibility(View.VISIBLE);
                lyshucai.setVisibility(View.GONE);
                lymifan.setVisibility(View.GONE);
                lygaodian.setVisibility(View.GONE);


                break;
            case R.id.mifan:
                lymifan.setVisibility(View.VISIBLE);
                lyshucai.setVisibility(View.GONE);
                lyrou.setVisibility(View.GONE);
                lygaodian.setVisibility(View.GONE);

                break;
            case R.id.gaodian:
                lygaodian.setVisibility(View.VISIBLE);
                lyshucai.setVisibility(View.GONE);
                lyrou.setVisibility(View.GONE);
                lymifan.setVisibility(View.GONE);

                break;

        }
    }
}
