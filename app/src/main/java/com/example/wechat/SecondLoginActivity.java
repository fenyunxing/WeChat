package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litepal.usertable.UserOne;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class SecondLoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button backbtn, login_btn2;
    EditText inputnumber_et, inputpassword_et;
    String usernumber, userpassword;
    TextView messagelogin_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_login);
        init_view();
    }

    //控件初始化函数
    private void init_view() {
        //获取返回控件并设置监听
        backbtn = (Button) findViewById(R.id.back_btn);
        backbtn.setOnClickListener(this);
        //获取第二个登录界面登录按钮，设置监听
        login_btn2 = (Button) findViewById(R.id.login_btn2);
        login_btn2.setOnClickListener(this);
        //获取输入框
        inputnumber_et = (EditText) findViewById(R.id.inputnumber_et);
        inputpassword_et = (EditText) findViewById(R.id.inputpassword_et);
        //获取短信登录文本控件,并设置监听
        messagelogin_tv=(TextView)findViewById(R.id.message_login_tv);
        messagelogin_tv.setOnClickListener(this);
    }

    //获取用户登陆信息函数
    void get_login_infor() {
        usernumber = inputnumber_et.getText().toString();
        userpassword = inputpassword_et.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_btn:
                finish();//结束上一个动画
                //右滑出
                overridePendingTransition(android.R.anim.slide_out_right, 0);
                break;
            case R.id.login_btn2:
                get_login_infor();//获取登录信息
                if (usernumber.equals("") || userpassword.equals("")) {

                    Toast.makeText(SecondLoginActivity.this, "请输入完整信息", Toast.LENGTH_SHORT).show();

                } else if(LitePal.isExist(UserOne.class,"number=?",usernumber)){ //判断用户是否存在

                        //通过账号查询该条用户信息对象,存入用户集合。
                         List<UserOne> userOneList=LitePal.where("number=?",usernumber).find(UserOne.class);
                         //在集合中取出该条信息的密码与输入密码配对校验
                        if(userOneList.get(0).getPassword().equals(userpassword)){
                            Toast.makeText(SecondLoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            //界面跳转到主界面
                            startActivity(new Intent(SecondLoginActivity.this,MainActivity.class));
                            //左滑入
                            overridePendingTransition(android.R.anim.slide_in_left, 0);
                           // finish();
                        } else {
                            Toast.makeText(SecondLoginActivity.this, "密码与用户不匹配", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(SecondLoginActivity.this, "用户信息不存在", Toast.LENGTH_SHORT).show();

                    }


                break;

            case R.id.message_login_tv:
                //界面跳转
                startActivity(new Intent(SecondLoginActivity.this,MessageLoginActivity.class));
                //左滑入
                overridePendingTransition(android.R.anim.slide_in_left, 0);
                break;
            default:
                break;
        }

    }
}
