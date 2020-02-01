package com.example.wechat;

import android.app.Activity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements
        android.view.View.OnClickListener {

    private ViewPager mViewPager;// 用来放置界面切换
    private PagerAdapter mPagerAdapter;// 初始化View适配器
    private List<View> mViews = new ArrayList<View>();// 用来存放Tab01-04
    // 四个Tab，每个Tab包含一个按钮
    private LinearLayout mTabWeiXin;
    private LinearLayout mTabAddress;
    private LinearLayout mTabFrd;
    private LinearLayout mTabSetting;
    // 四个按钮
    private ImageView mWeiXinImg;
    private ImageView mAddressImg;
    private ImageView mFrdImg;
    private ImageView mSettingImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initViewPage();
        initEvent();
    }

    private void initEvent() {
        mTabWeiXin.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             *ViewPage左右改变时按钮颜色更改
             */
            @Override
            public void onPageSelected(int arg0) {
                int currentItem = mViewPager.getCurrentItem();
                switch (currentItem) {
                    case 0:
                        resetImg();
                        mWeiXinImg.setImageResource(R.drawable.wechat_press);
                        break;
                    case 1:
                        resetImg();
                        mAddressImg.setImageResource(R.drawable.contact_press);
                        break;
                    case 2:
                        resetImg();
                        mFrdImg.setImageResource(R.drawable.discover_press);
                        break;
                    case 3:
                        resetImg();
                        mSettingImg.setImageResource(R.drawable.my_press);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    /**
     * 初始化设置
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpage);
        // 初始化四个LinearLayout
        mTabWeiXin = (LinearLayout) findViewById(R.id.wechat_viewpage);
        mTabAddress = (LinearLayout) findViewById(R.id.contact_viewpage);
        mTabFrd = (LinearLayout) findViewById(R.id.discover_viewpage);
        mTabSetting = (LinearLayout) findViewById(R.id.my_viewpage);
        // 初始化四个按钮
        mWeiXinImg = (ImageView) findViewById(R.id.wechat_icon);
        mAddressImg = (ImageView) findViewById(R.id.contact_icon);
        mFrdImg = (ImageView) findViewById(R.id.discover_icon);
        mSettingImg = (ImageView) findViewById(R.id.mine_icon);
    }

    /**
     * 初始化ViewPage
     */
    private void initViewPage() {

        // 初妈化四个布局
        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        View tab01 = mLayoutInflater.inflate(R.layout.wechat_viewpage_mian, null);
        View tab02 = mLayoutInflater.inflate(R.layout.contact_viewpage_mian, null);
        View tab03 = mLayoutInflater.inflate(R.layout.discover_viewpage_mian, null);
        View tab04 = mLayoutInflater.inflate(R.layout.my_viewpage_mian, null);

        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);

        // 适配器初始化并设置
        mPagerAdapter = new PagerAdapter() {

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(mViews.get(position));

            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {

                return arg0 == arg1;
            }

            @Override
            public int getCount() {

                return mViews.size();
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }

    /**
     * 判断哪个要显示，及设置按钮图片
     */
    @Override
    public void onClick(View arg0) {

        switch (arg0.getId()) {
            case R.id.wechat_main:
                mViewPager.setCurrentItem(0);
                resetImg();
                mWeiXinImg.setImageResource(R.drawable.wechat_press);
                break;
            case R.id.wechat_contact:
                mViewPager.setCurrentItem(1);
                resetImg();
                mAddressImg.setImageResource(R.drawable.contact_press);
                break;
            case R.id.wechat_discover:
                mViewPager.setCurrentItem(2);
                resetImg();
                mFrdImg.setImageResource(R.drawable.discover_press);
                break;
            case R.id.wechat_mine:
                mViewPager.setCurrentItem(3);
                resetImg();
                mSettingImg.setImageResource(R.drawable.my_press);
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
        mSettingImg.setImageResource(R.drawable.my_normal);
    }

}