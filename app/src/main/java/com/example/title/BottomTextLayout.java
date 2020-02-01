package com.example.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wechat.R;

import static android.app.PendingIntent.getActivity;


//创建一个底部布局管理类
public class BottomTextLayout extends LinearLayout implements View.OnClickListener {
    TextView login_problem_tv,other_loginways_tv;
    public BottomTextLayout(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        //设置布局文件
        LayoutInflater.from(context).inflate(R.layout.bottomtext, BottomTextLayout.this);
        init_view();//控件初始化
    }

    //初始化控件函数
    void init_view(){
        login_problem_tv=(TextView)findViewById(R.id.login_problem_tv);
        other_loginways_tv=(TextView)findViewById(R.id.other_loginways_tv);
        login_problem_tv.setOnClickListener(this);
        other_loginways_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_problem_tv:
                //获取popmenu对象，参数1为显示背景内容，参数2为绑定的控件
                PopupMenu popup = new PopupMenu(getContext(), login_problem_tv);
                //动态加载布局文件
                popup.getMenuInflater().inflate(R.menu.bottomtext_popmenu_left, popup.getMenu());
                //设置菜单目录点击事件
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                       switch (item.getItemId()){
                           case R.id.find_back_password:
                               Toast.makeText(getContext(), "找回密码", Toast.LENGTH_SHORT).show();
                               break;
                           case R.id.apply_thaw:
                               Toast.makeText(getContext(), "申请解冻", Toast.LENGTH_SHORT).show();
                               break;
                           case R.id.safety_center:
                               Toast.makeText(getContext(), "安全中心", Toast.LENGTH_SHORT).show();
                               break;
                       }
                        return true;
                    }
                });
                popup.show(); //showing popup menu
                break;
            case R.id.other_loginways_tv:
                PopupMenu popup1 = new PopupMenu(getContext(), other_loginways_tv);
                popup1.getMenuInflater().inflate(R.menu.bottomtext_popmenu_right, popup1.getMenu());
                popup1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.find_back_password:
                                Toast.makeText(getContext(), "qq登录", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.apply_thaw:
                                Toast.makeText(getContext(), "邮箱登录", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.safety_center:
                                Toast.makeText(getContext(), "微信号登录", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popup1.show(); //showing popup menu

                break;
        }


        }



}
