package com.example.wechat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragment.Contact_Fragment;
import com.example.fragment.Discover_Fragment;
import com.example.fragment.My_Fragment;
import com.example.fragment.WeChat_Fragment;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
ImageView  mWeiXinImg, mAddressImg,mFrdImg, mMyImg;
LinearLayout mWechat_Mian,mWechat_Contact,mWechat_Discover,mWechat_My;
TextView mtop_title_text,mbottom_wechat_text,mbottom_contact_text,mbottom_discover_text,mbottom_my_text;
ImageView mtop_search_btn,mtop_plus_btn;
RelativeLayout mtop_title_layout;

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
        //获取线性布局
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

        //获取顶部标题文字控件
        mtop_title_text=(TextView)findViewById(R.id.top_title_text);
        mtop_title_layout =(RelativeLayout) findViewById(R.id.toptitle_layout);

        //获取底部文字控件
        mbottom_wechat_text=(TextView)findViewById(R.id.wechat_text);
        mbottom_contact_text=(TextView)findViewById(R.id.contact_text);
        mbottom_discover_text=(TextView)findViewById(R.id.discover_text);
        mbottom_my_text=(TextView)findViewById(R.id.mine_text);
        //获取顶部图片按钮
        mtop_search_btn=(ImageView) findViewById(R.id.top_search_btn);
        mtop_plus_btn=(ImageView) findViewById(R.id.top_plus_btn);
        mtop_search_btn.setOnClickListener(this);
        mtop_plus_btn.setOnClickListener(this);




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
                mtop_title_text.setText("微信(num)");//更改顶部标题
                replaceFragment(new WeChat_Fragment());//更改内容
                resetImg();//重置底部导航栏显示
                //设置选中颜色效果
                mWeiXinImg.setImageResource(R.drawable.wechat_press);
                mbottom_wechat_text.setTextColor(getResources().getColor(R.color.bottom_title_text_press));
                break;
            case R.id.wechat_contact:
                mtop_title_text.setText("联系人");
                replaceFragment(new Contact_Fragment());
                resetImg();
                mAddressImg.setImageResource(R.drawable.contact_press);
                mbottom_contact_text.setTextColor(getResources().getColor(R.color.bottom_title_text_press));
                break;
            case R.id.wechat_discover:
                mtop_title_text.setText("发现");
                replaceFragment(new Discover_Fragment());
                resetImg();
                mFrdImg.setImageResource(R.drawable.discover_press);
                mbottom_discover_text.setTextColor(getResources().getColor(R.color.bottom_title_text_press));
                break;
            case R.id.wechat_mine:
               // mtop_title_text.setText("我");
                replaceFragment(new My_Fragment());
                resetImg();
                mtop_title_layout.setVisibility(View.GONE);
                mMyImg.setImageResource(R.drawable.my_press);
                mbottom_my_text.setTextColor(getResources().getColor(R.color.bottom_title_text_press));
                break;
            default:
                break;
        }
    }

    /**
     * 把所有图片变暗
     */
    private void resetImg() {
        mtop_title_layout.setVisibility(View.VISIBLE);
        mWeiXinImg.setImageResource(R.drawable.wechat_normal);
        mAddressImg.setImageResource(R.drawable.contact_normal);
        mFrdImg.setImageResource(R.drawable.discover_normal);
        mMyImg.setImageResource(R.drawable.my_normal);
        mbottom_wechat_text.setTextColor(getResources().getColor(R.color.bottom_title_text_color));
        mbottom_contact_text.setTextColor(getResources().getColor(R.color.bottom_title_text_color));
        mbottom_discover_text.setTextColor(getResources().getColor(R.color.bottom_title_text_color));
        mbottom_my_text.setTextColor(getResources().getColor(R.color.bottom_title_text_color));
    }


    /* 替换fragment函数*/
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout,fragment);
        transaction.commit();
    }
}