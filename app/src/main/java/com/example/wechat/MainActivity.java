package com.example.wechat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragment.Contact_Fragment;
import com.example.fragment.Discover_Fragment;
import com.example.fragment.My_Fragment;
import com.example.fragment.WeChat_Fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
ImageView  mWeiXinImg, mAddressImg,mFrdImg, mMyImg;
LinearLayout mWechat_Mian,mWechat_Contact,mWechat_Discover,mWechat_My;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    /**
     * 初始化设置
     */
    private void initView() {
        //获取四个线性布局
        mWechat_Mian=(LinearLayout)findViewById(R.id.wechat_main);
        mWechat_Contact=(LinearLayout)findViewById(R.id.wechat_contact);
        mWechat_Discover=(LinearLayout)findViewById(R.id.wechat_discover);
        mWechat_My=(LinearLayout)findViewById(R.id.wechat_mine);
        mWechat_Mian.setOnClickListener(this);
        mWechat_Contact.setOnClickListener(this);
        mWechat_Discover.setOnClickListener(this);
        mWechat_My.setOnClickListener(this);

        //获取四个图片控件
        mWeiXinImg=(ImageView)findViewById(R.id.wechat_icon);
        mAddressImg=(ImageView)findViewById(R.id.contact_icon);
        mFrdImg=(ImageView)findViewById(R.id.discover_icon);
        mMyImg=(ImageView)findViewById(R.id.mine_icon);

    }

    private void initEvent() {
        //初始化Fragment显示
        replaceFragment(new WeChat_Fragment());

    }





    /**
     * 判断哪个要显示，及设置按钮图片
     */
    @Override
    public void onClick(View arg0) {

        switch (arg0.getId()) {
            case R.id.wechat_main:
                replaceFragment(new WeChat_Fragment());
                resetImg();
                mWeiXinImg.setImageResource(R.drawable.wechat_press);
                break;
            case R.id.wechat_contact:
                replaceFragment(new Contact_Fragment());
                resetImg();
                mAddressImg.setImageResource(R.drawable.contact_press);
                break;
            case R.id.wechat_discover:
                replaceFragment(new Discover_Fragment());
                resetImg();
                mFrdImg.setImageResource(R.drawable.discover_press);
                break;
            case R.id.wechat_mine:
                replaceFragment(new My_Fragment());
                resetImg();
                mMyImg.setImageResource(R.drawable.my_press);
                break;
            default:
                break;
        }
    }

    /**
     * 把所有图片变暗
     */
    private void resetImg() {
        mWeiXinImg.setImageResource(R.drawable.wechat_normal);
        mAddressImg.setImageResource(R.drawable.contact_normal);
        mFrdImg.setImageResource(R.drawable.discover_normal);
        mMyImg.setImageResource(R.drawable.my_normal);
    }


    /* 替换fragment函数*/
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout,fragment);
        transaction.commit();
    }
}