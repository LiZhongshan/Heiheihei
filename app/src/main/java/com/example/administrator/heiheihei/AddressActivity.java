package com.example.administrator.heiheihei;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/2/15.
 */
public class AddressActivity extends AppCompatActivity {
    private Context mContext;
    private GridView grid_photo;
    private BaseAdapter mAdapter = null;
    private ArrayList<Icon> mData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mContext = AddressActivity.this;
        grid_photo = (GridView) findViewById(R.id.grid_photo);

        mData = new ArrayList<Icon>();
        mData.add(new Icon(R.mipmap.iv_icon_1, "列表选项框"));
        mData.add(new Icon(R.mipmap.iv_icon_2, "可折叠列表"));
        mData.add(new Icon(R.mipmap.iv_icon_3, "菜单选项"));
        mData.add(new Icon(R.mipmap.iv_icon_4, "图标4"));
        mData.add(new Icon(R.mipmap.iv_icon_5, "图标5"));
        mData.add(new Icon(R.mipmap.iv_icon_6, "图标6"));
        mData.add(new Icon(R.mipmap.iv_icon_7, "图标7"));
        mData.add(new Icon(R.mipmap.iv_icon_8, "图标8"));
        mData.add(new Icon(R.mipmap.iv_icon_9, "图标9"));

        mAdapter = new MyAdapter<Icon>(mData, R.layout.item_grid_icon) {
            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };

        grid_photo.setAdapter(mAdapter);

        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
                /*if (position==0){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SpinnerActivity.class);
                    startActivity(intent);
                }
                if (position==1){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, KezhedieActivity.class);
                    startActivity(intent);
                }
                if (position==2){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                }*/
            }
        });

    }
}
