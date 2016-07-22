package com.hys.musclehungry.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hys.musclehungry.Login;
import com.hys.musclehungry.R;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class MeFragment extends Fragment implements View.OnClickListener {
//    private Button
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bmob.initialize(this.getContext(), "d60bb2cb24233b63224a1aeac7145a41");

        view = inflater.inflate(R.layout.fragment_me, container, false);
        view.findViewById(R.id.tuichudenglu).setOnClickListener(this);
        view.findViewById(R.id.shangjia).setOnClickListener(this);
       TextView t= (TextView) view.findViewById(R.id.nicheng);
        t.setText((String) BmobUser.getObjectByKey(this.getContext(), "username"));
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tuichudenglu:
                Intent i = new Intent (MeFragment.this.getContext(), Login.class);
                startActivity(i);
                BmobUser.logOut(MeFragment.this.getContext());
                this.getActivity().finish();
                break;
            case R.id.shangjia:
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://a.eqxiu.com/s/s02ovXmU");
                intent.setData(content_url);
                startActivity(intent);
                break;
        }
    }
}
