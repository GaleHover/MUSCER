package com.hys.musclehungry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.EmailVerifyListener;
import cn.bmob.v3.listener.SaveListener;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private EditText mima;
    private EditText xingming;
    private EditText youxiang;
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"d60bb2cb24233b63224a1aeac7145a41");
        setContentView(R.layout.activity_register);
        mima = (EditText)findViewById(R.id.mima);
        xingming = (EditText) findViewById(R.id.xingMing);
        youxiang = (EditText) findViewById(R.id.eMail);
        phone = (EditText) findViewById(R.id.userphone);
        findViewById(R.id.register).setOnClickListener(this);
    }
     String ec ="";
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.register:

                BmobUser bu = new BmobUser();
                bu.setUsername(xingming.getText().toString());
                bu.setPassword(mima.getText().toString());
                bu.setMobilePhoneNumber(phone.getText().toString());
                 ec= youxiang.getText().toString();
                bu.setEmail(ec);
                bu.signUp(Register.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
yanzheng();
//
                        //通过BmobUser.getCurrentUser(context)方法获取登录成功后的本地用户信息
                        Intent i = new Intent(Register.this, Login.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        // TODO Auto-generated method stub
                        Toast.makeText(Register.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
                    break;
        }
    }
    public void yanzheng (){
        BmobUser.requestEmailVerify(Register.this, ec, new EmailVerifyListener() {
                            @Override
                            public void onSuccess() {
                                // TODO Auto-generated method stub
                                Toast.makeText(Register.this, "已经发送邮件 请验证", Toast.LENGTH_SHORT).show();                            }
                            @Override
                            public void onFailure(int code, String e) {
                                // TODO Auto-generated method stub
                                Toast.makeText(Register.this, e, Toast.LENGTH_SHORT).show();                            }

                        });

}
}
