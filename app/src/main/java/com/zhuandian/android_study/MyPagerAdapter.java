package com.zhuandian.android_study;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
public class MyPagerAdapter extends FragmentPagerAdapter{


    private List<Fragment> fragmentList;
  //  private String titles [] = {"学校要闻","校园传真","通知通告","媒体关注"};

    public MyPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

//    /**
//     * 得到当前页卡的导航条标题
//     * @param position
//     * @return
//     */
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return titles[position];
//    }
}
