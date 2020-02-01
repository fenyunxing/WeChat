package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.litepal.usertable.UserOne;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton exitbtn;
    EditText inputname_et, inputnumber_et, inputpassword_et;
    CheckBox protocol_checkBox;
    Button register_btn2;
    TextView protocol_tv;
    String username, usernumber,userpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //创建数据库
        Connector.getDatabase();
        init_view();//初始化控件

    }

    //控件初始化函数
    void init_view() {
        //返回按钮控件初始化
        exitbtn = (ImageButton) findViewById(R.id.exit_btn);
        exitbtn.setOnClickListener(this);
        //获取输入框
        inputname_et = (EditText) findViewById(R.id.register_inputname_et);
        inputnumber_et = (EditText) findViewById(R.id.register_inputnumber_et);
        inputpassword_et = (EditText) findViewById(R.id.register_inputpassword_et);
        //获取协议勾选框
        protocol_checkBox = (CheckBox) findViewById(R.id.protocol_checkBox);
        //获取注册按钮并设置监听
        register_btn2= (Button) findViewById(R.id.register_btn2);
        register_btn2.setOnClickListener(this);
        //获取软件协议文本控件
        protocol_tv=(TextView)findViewById(R.id.protocol_tv);
        protocol_tv.setOnClickListener(this);
    }

    void get_register_infor() {
        username = inputname_et.getText().toString();//获取昵称
        usernumber = inputnumber_et.getText().toString();//获取注册电话
        userpassword = inputpassword_et.getText().toString();//获取注册密码

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit_btn:
                finish();//结束上一个动画
                //右滑出
                overridePendingTransition(android.R.anim.slide_out_right, 0);
                break;
            case R.id.register_btn2:
                get_register_infor();//获取注册信息
                //判断输入信息是否为空,否则将输入信息保存到数据库
                if (username.equals("") || usernumber.equals("") || userpassword.equals("")||!protocol_checkBox.isChecked()) {

                   Toast.makeText(RegisterActivity.this, "请填写完整信息", Toast.LENGTH_SHORT).show();

                } else if (LitePal.isExist(UserOne.class,"number=?",usernumber)) {  //判断是否已经注册
                        //如果已经注册则提示已经注册
                        Toast.makeText(RegisterActivity.this, "该用户已经注册，无需重复", Toast.LENGTH_SHORT).show();

                    } else {

                        UserOne userOne=new UserOne();//创建一个用户对象
                        userOne.setName(username);
                        userOne.setNumber(Integer.valueOf(usernumber));//将字符串类型转成整形后再添加进去
                        userOne.setPassword(userpassword);
                        userOne.save();
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    }

                break;

            case R.id.protocol_tv:
                //界面跳转
                Intent intentsoftprotocl=new Intent(RegisterActivity.this,SoftProtocolActivity.class);
                startActivity(intentsoftprotocl);
                //淡入
                overridePendingTransition(android.R.anim.fade_in, 0);
                finish();
                break;
            default:
                break;
        }
    }
}
