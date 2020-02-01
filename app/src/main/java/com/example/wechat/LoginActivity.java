package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login_btn;
    Button register_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //获取控件
        login_btn=(Button)findViewById(R.id.login_btn);
        register_btn=(Button)findViewById(R.id.register_btn);
        login_btn.setOnClickListener(this);
        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:
                //界面跳转
                startActivity(new Intent(LoginActivity.this,SecondLoginActivity.class));
                //左滑入
                overridePendingTransition(android.R.anim.slide_in_left, 0);
                break;
            case R.id.register_btn:
                //界面跳转
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                //左滑入
                overridePendingTransition(android.R.anim.slide_in_left, 0);
                break;

            default:break;
        }
    }
}
