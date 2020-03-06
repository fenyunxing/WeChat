package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wechat.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Contact_Fragment extends Fragment {

    private int[] image = {R.drawable.p1, R.drawable.p2, R.drawable.p3,
            R.drawable.p4, R.drawable.p5, R.drawable.p6,
            R.drawable.p7, R.drawable.p8, R.drawable.p9};
    private String[] fruitname = {"苹果", "橘子", "香蕉",
            "菠萝", "西瓜", "芒果",
            "葡萄", "哈密瓜", "火龙果"};
    private ListView lv;
    View contentView;
    SimpleAdapter mSimpleAdapter;
    ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
    @Override
    public void onStart() {
        super.onStart();
        /*在数组中存放数据*/
        for (int i = 0; i < 9; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", image[i]);//加入图片
            map.put("ItemTitle", "第" + (i + 1) + "行");
            map.put("ItemText", fruitname[i]);
            listItem.add(map);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //创建页面frament
        contentView=inflater.inflate(R.layout.contact_fragment, container, false);
        lv = (ListView) (contentView).findViewById(R.id.listview);
        mSimpleAdapter = new SimpleAdapter(getContext(), listItem,//需要绑定的数据
                R.layout.list_item_layout,//每一行的布局
                //动态数组中的数据源的键对应到定义布局的View中
                new String[]{"ItemTitle", "ItemImage", "ItemText"},
                new int[]{R.id.ItemTitle, R.id.ItemImage, R.id.ItemText}
        );
        lv.setAdapter(mSimpleAdapter);//为ListView绑定适配器
        // Inflate the layout for this fragment
        return contentView;
    }


}