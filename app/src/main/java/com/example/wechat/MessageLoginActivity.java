package com.example.wechat;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.litepal.usertable.UserOne;

import org.litepal.LitePal;

import java.util.Random;

public class MessageLoginActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton back_btn;
    TextView number_login_tv;
    EditText message_login_inputnumber_et, message_login_inputchecknumber_et;
    Button login_btn3, sendmessage_btn;
    String message_login_inputnumber, message_login_inputchecknumber;
    int checknum, inputchecknum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_login);
        init_view();//初始化控件

    }

    private void init_view() {
        //获取返回按钮控件设置监听
        back_btn = (ImageButton) findViewById(R.id.exit_btn);
        back_btn.setOnClickListener(this);
        //获取手机号登录文本控件设置监听
        number_login_tv = (TextView) findViewById(R.id.number_login_tv);
        number_login_tv.setOnClickListener(this);
        //获取输入框信息
        message_login_inputnumber_et = (EditText) findViewById(R.id.message_login_inputnumber_et);
        message_login_inputchecknumber_et = (EditText) findViewById(R.id.message_login_inputchecknumber_et);
        //获取登陆按钮
        login_btn3 = (Button) findViewById(R.id.login_btn3);
        login_btn3.setOnClickListener(this);
        //获取发送验证码按钮
        sendmessage_btn = (Button) findViewById(R.id.sendmessage_btn);
        sendmessage_btn.setOnClickListener(this);
    }

    //获取用户登陆信息函数
    void get_login_infor() {
        message_login_inputnumber = message_login_inputnumber_et.getText().toString();
        message_login_inputchecknumber = message_login_inputchecknumber_et.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit_btn:
                finish();
                //右滑出
                overridePendingTransition(android.R.anim.slide_out_right, 0);
                break;
            case R.id.number_login_tv:
                finish();
                //右滑出
                overridePendingTransition(android.R.anim.slide_out_right, 0);
                break;

            case R.id.login_btn3:
                get_login_infor();
                //判断输入是否为空
                if (message_login_inputnumber.equals("") || message_login_inputchecknumber.equals("")) {
                    Toast.makeText(MessageLoginActivity.this, "请填写完整信息", Toast.LENGTH_SHORT).show();
                    //判断号码是否存在
                } else if (LitePal.isExist(UserOne.class, "number=?", message_login_inputnumber)) {
                    //获取输入的验证码
                    inputchecknum = Integer.valueOf(message_login_inputchecknumber);
                    if (inputchecknum == checknum) {
                        Toast.makeText(MessageLoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        //界面跳转到主界面
                        startActivity(new Intent(MessageLoginActivity.this,MainActivity.class));
                        //左滑入
                        overridePendingTransition(android.R.anim.slide_in_left, 0);
                    } else {
                        Toast.makeText(MessageLoginActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                    }
                }

                break;

            case R.id.sendmessage_btn:
                get_login_infor();
                //判断手机号是否输入完整
                if (message_login_inputnumber.equals("")) {
                    Toast.makeText(MessageLoginActivity.this, "请填写完整手机号", Toast.LENGTH_SHORT).show();
                } else if (LitePal.isExist(UserOne.class, "number=?", message_login_inputnumber)) {
                    //给手机发验证码
                    Random random = new Random();
                    checknum = random.nextInt(9999 - 1000 + 1) + 1000; // randNumber 将被赋值为一个 MIN 和 MAX 范围内的随机数

                    Toast.makeText(MessageLoginActivity.this, String.valueOf(checknum), Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(MessageLoginActivity.this, "手机号未注册", Toast.LENGTH_SHORT).show();
                }
                break;


            default:
                break;
        }

    }
}
