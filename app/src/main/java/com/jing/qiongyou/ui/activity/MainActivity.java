package com.jing.qiongyou.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.jing.qiongyou.R;
import com.jing.qiongyou.adapter.PagerAdapter;
import com.jing.qiongyou.base.BaseActivity;
import com.jing.qiongyou.ui.fragment.community.CommunityFragment;
import com.jing.qiongyou.ui.fragment.destination.DestinationFragment;
import com.jing.qiongyou.ui.fragment.homepage.HomePageFragment;
import com.jing.qiongyou.ui.fragment.mall.MallFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private TabLayout mTabLayout;
    private ImageView mImgMine;
    private ImageView mSearch;
    private ViewPager mViewPager;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }



    private void initView() {

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mImgMine = (ImageView) findViewById(R.id.img_mine);
        mSearch = (ImageView) findViewById(R.id.img_search);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

    }

    private void initData() {

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomePageFragment());
        fragments.add(new DestinationFragment());
        fragments.add(new MallFragment());
        fragments.add(new CommunityFragment());

        ArrayList<String> titles = new ArrayList<>();
        titles.add("首页");
        titles.add("目的地");
        titles.add("商城");
        titles.add("社区");

        adapter = new PagerAdapter(getSupportFragmentManager(),fragments,titles);
        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);

    }
}
