package com.zhuandian.android_study;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * http://blog.csdn.net/hanhailong726188/article/details/46738929
 */
public class MainActivity extends AppCompatActivity {

    //设置viewPaper
    ViewPager pager = null;
    ArrayList<Fragment> viewContainter = new ArrayList<>();
    private TextView home;
    private TextView fuxi;
    private TextView kuochong;
    private TextView about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initModule();
        changeFragment(new HomeFragment());




    }

    private void initModule() {


        //添加fragment
        viewContainter.add(new HomeFragment());
        viewContainter.add(new FuXiFragment());
        viewContainter.add(new KuoChongFragment());
        viewContainter.add(new AboutFragment());


        //设置适配器
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), viewContainter));

        //页面变化时的监听 改变按钮
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                switch (i) {

                    //如果是第一个页面
                    case 0:
                        home.setText("√");
                        fuxi.setText("复习");
                        kuochong.setText("扩充");
                        about.setText("关于");

                        break;

                    //如果是第二个页面
                    case 1:
                        home.setText("首页");
                        fuxi.setText("√");
                        kuochong.setText("扩充");
                        about.setText("关于");
                        break;

                    //如果是第三个页面
                    case 2:
                        home.setText("首页");
                        fuxi.setText("复习");
                        kuochong.setText("√");
                        about.setText("关于");
                        break;

                    //如果是第四个页面
                    case 3:
                        home.setText("首页");
                        fuxi.setText("复习");
                        kuochong.setText("扩充");
                        about.setText("√");
                        break;


                }

                pager.setCurrentItem(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initView() {

        home = (TextView) findViewById(R.id.home);
        fuxi = (TextView) findViewById(R.id.fuxi);
        kuochong = (TextView) findViewById(R.id.kuochong);
        about = (TextView) findViewById(R.id.about);

        pager = (ViewPager) this.findViewById(R.id.viewpager);

        //设置按钮跳转到相应的viewPaper页面
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //跳到第一个页面
                pager.setCurrentItem(0);
                changeFragment(new HomeFragment());


            }
        });

        fuxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //第二个页面
                pager.setCurrentItem(1);
                changeFragment(new FuXiFragment());

            }
        });

        kuochong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //第三个页面
                pager.setCurrentItem(2);
                changeFragment(new KuoChongFragment());

            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //第三个页面
                pager.setCurrentItem(3);
                changeFragment(new AboutFragment());


            }
        });


    }


    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment, null)
                .commit();

    }
}
