package com.hys.musclehungry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.security.spec.ECField;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText email;
    private EditText emima;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    Bmob.initialize(this,"d60bb2cb24233b63224a1aeac7145a41");

    setContentView(R.layout.activity_login);
//        imageView=(ImageView)findViewById(R.id.tubiao);
//        imageView.setAlpha(95);
     emima = (EditText) findViewById(R.id.emima);
     email = (EditText) findViewById(R.id.eMail);
    findViewById(R.id.loginMain).setOnClickListener(this);
//    BmobUser.logOut(Login.this);
    //退出登录
    if(BmobUser.getCurrentUser(Login.this)!=null){
        Intent i = new Intent (Login.this,MainActivity.class);
        startActivity(i);
        finish();
    }
    findViewById(R.id.tzzc).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginMain:

                BmobUser m = new BmobUser();
                BmobUser.loginByAccount(Login.this, email.getText().toString(), emima.getText().toString(), new LogInListener<BmobUser>() {
                    @Override
                    public void done(BmobUser user, BmobException e) {
                        // TODO Auto-generated method stub
                        if(user!=null){
                            Toast.makeText(Login.this, "用户登录成功", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent (Login.this,MainActivity.class);
                            startActivity(i);}
                        else{
                            Toast.makeText(Login.this, "邮箱或密码错误！", Toast.LENGTH_SHORT).show();
                        }
                    }

                });

                break;
                case R.id.tzzc:
                Intent i = new Intent(Login.this,Register.class);
                startActivity(i);
                break;

        }
    }
}
