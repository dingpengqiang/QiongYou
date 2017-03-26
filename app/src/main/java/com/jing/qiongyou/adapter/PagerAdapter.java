package com.jing.qiongyou.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Ding.pengqiang
 * on 2017/3/27.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> data;

    private List<String> title;
    public PagerAdapter(FragmentManager fm,List<Fragment> data,List<String> title) {
        super(fm);
        this.data = data;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
