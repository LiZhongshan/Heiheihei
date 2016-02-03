package com.example.administrator.heiheihei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/28.
 */
public class MainActivity extends AppCompatActivity {

    public static MainActivity instance = null;

    private ViewPager mTabPager;
    private ImageView mTab1,mTab2,mTab3,mTab4;
    private TextView mText1,mText2,mText3,mText4;
    private int zero = 0;
    private int currIndex = 0;
    private int one;
    private int two;
    private int three;
    private LinearLayout mClose;
    private LinearLayout mCloseBtn;
    private View layout;
    private boolean menu_display = false;
    private PopupWindow menuWindow;
    private LayoutInflater inflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);
        instance = this;

        mTabPager = (ViewPager)findViewById(R.id.tabpager);
        mTabPager.setOnPageChangeListener(new MyOnPageChangeListener());

        mTab1 = (ImageView) findViewById(R.id.img_listmain);
        mTab2 = (ImageView) findViewById(R.id.img_address);
        mTab3 = (ImageView) findViewById(R.id.img_brother);
        mTab4 = (ImageView) findViewById(R.id.img_settings);
        mText1 = (TextView) findViewById(R.id.tv_friend);
        mText2 = (TextView) findViewById(R.id.tv_contact_list);
        mText3 = (TextView) findViewById(R.id.tv_find);
        mText4 = (TextView) findViewById(R.id.tv_profile);
        mTab1.setOnClickListener(new MyOnClickListener(0));
        mTab2.setOnClickListener(new MyOnClickListener(1));
        mTab3.setOnClickListener(new MyOnClickListener(2));
        mTab4.setOnClickListener(new MyOnClickListener(3));
        Display currDisplay = getWindowManager().getDefaultDisplay();
        int displayWidth = currDisplay.getWidth();
        int displayHeight = currDisplay.getHeight();
        one = displayWidth/4;
        two = one*2;
        three = one*3;
        LayoutInflater mLi = LayoutInflater.from(this);
        View view1 = mLi.inflate(R.layout.main_tab_list, null);
        View view2 = mLi.inflate(R.layout.main_tab_address, null);
        View view3 = mLi.inflate(R.layout.main_tab_brother, null);
        View view4 = mLi.inflate(R.layout.main_tab_settings, null);

        final ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);

        PagerAdapter mPagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public void destroyItem(View container, int position, Object object) {
                ((ViewPager)container).removeView(views.get(position));
            }

            @Override
            public Object instantiateItem(View container, int position) {
                ((ViewPager)container).addView(views.get(position));
                return views.get(position);
            }
        };
        mTabPager.setAdapter(mPagerAdapter);
    }

    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mTabPager.setCurrentItem(index);
        }
    };
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
                case 0:
                    mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_list_pressed));
                    mText1.setTextColor(getResources().getColor(R.color.greent));
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(one, 0, 0, 0);
                        mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_address_normal));
                        mText2.setTextColor(getResources().getColor(R.color.grayt));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, 0, 0, 0);
                        mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_frd_normal));
                        mText3.setTextColor(getResources().getColor(R.color.grayt));
                    }
                    else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, 0, 0, 0);
                        mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_settings_normal));
                        mText4.setTextColor(getResources().getColor(R.color.grayt));
                    }
                    break;
                case 1:
                    mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_address_pressed));
                    mText2.setTextColor(getResources().getColor(R.color.greent));
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(zero, one, 0, 0);
                        mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_list_normal));
                        mText1.setTextColor(getResources().getColor(R.color.grayt));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, one, 0, 0);
                        mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_frd_normal));
                        mText3.setTextColor(getResources().getColor(R.color.grayt));
                    }
                    else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, one, 0, 0);
                        mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_settings_normal));
                        mText4.setTextColor(getResources().getColor(R.color.grayt));
                    }
                    break;
                case 2:
                    mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_frd_pressed));
                    mText3.setTextColor(getResources().getColor(R.color.greent));
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(zero, two, 0, 0);
                        mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_list_normal));
                        mText1.setTextColor(getResources().getColor(R.color.grayt));
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, two, 0, 0);
                        mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_address_normal));
                        mText2.setTextColor(getResources().getColor(R.color.grayt));
                    }
                    else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, two, 0, 0);
                        mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_settings_normal));
                        mText4.setTextColor(getResources().getColor(R.color.grayt));
                    }
                    break;
                case 3:
                    mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_settings_pressed));
                    mText4.setTextColor(getResources().getColor(R.color.greent));
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(zero, three, 0, 0);
                        mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_list_normal));
                        mText1.setTextColor(getResources().getColor(R.color.grayt));
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, three, 0, 0);
                        mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_address_normal));
                        mText2.setTextColor(getResources().getColor(R.color.grayt));
                    }
                    else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, three, 0, 0);
                        mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_frd_normal));
                        mText3.setTextColor(getResources().getColor(R.color.grayt));
                    }
                    break;
            }
            currIndex = arg0;
            animation.setFillAfter(true);
            animation.setDuration(150);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            if(menu_display){
                menuWindow.dismiss();
                menu_display = false;
            }
            else {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Exit.class);
                startActivity(intent);
            }
        }

        else if(keyCode == KeyEvent.KEYCODE_MENU){
            if(!menu_display){
                inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
                layout = inflater.inflate(R.layout.activity_main, null);

                menuWindow = new PopupWindow(layout, WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                menuWindow.showAtLocation(this.findViewById(R.id.listmain), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                mClose = (LinearLayout)layout.findViewById(R.id.menu_close);
                mCloseBtn = (LinearLayout)layout.findViewById(R.id.menu_close_btn);
                mCloseBtn.setOnClickListener (new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,Exit.class);
                        startActivity(intent);
                        menuWindow.dismiss();
                    }
                });
                menu_display = true;
            }else{
                menuWindow.dismiss();
                menu_display = false;
            }

            return false;
        }
        return false;
    }
    public void btnmainright(View v) {
        Intent intent = new Intent (MainActivity.this,MainTopRightDialog.class);
        startActivity(intent);
    }
    public void startchat(View v) {
        Intent intent = new Intent (MainActivity.this,ChatActivity.class);
        startActivity(intent);
    }
    public void exit_settings(View v) {
        Intent intent = new Intent (MainActivity.this,ExitFromSettings.class);
        startActivity(intent);
    }
    public void btn_shake(View v) {
        Intent intent = new Intent (MainActivity.this,ShakeActivity.class);
        startActivity(intent);
    }
}
