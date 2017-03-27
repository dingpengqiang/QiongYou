package com.jing.qiongyou.ui.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockApplication;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.jing.qiongyou.QiongYouApp;
import com.jing.qiongyou.R;
import com.jing.qiongyou.adapter.PagerAdapter;
import com.jing.qiongyou.base.BaseActivity;
import com.jing.qiongyou.ui.fragment.community.CommunityFragment;
import com.jing.qiongyou.ui.fragment.destination.DestinationFragment;
import com.jing.qiongyou.ui.fragment.homepage.HomePageFragment;
import com.jing.qiongyou.ui.fragment.mall.MallFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TabLayout mTabLayout;
    private ImageView mImgMine;
    private ImageView mSearch;
    private ViewPager mViewPager;
    private PagerAdapter adapter;
    private QiongYouApp application;
    private HomePageFragment mHomePagerFragment;
    private DestinationFragment mDestinationFragment;
    private MallFragment mMallFragment;
    private CommunityFragment mCommunityFragment;
    private String searchText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = ((QiongYouApp) getApplication());
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }



    private void initView() {

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mImgMine = (ImageView) findViewById(R.id.img_mine);
        mSearch = (ImageView) findViewById(R.id.img_search);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mSearch.setOnClickListener(this);
        mImgMine.setOnClickListener(this);
    }

    private void initData() {

        ArrayList<Fragment> fragments = new ArrayList<>();
        mHomePagerFragment = new HomePageFragment();
        fragments.add(mHomePagerFragment);
        mDestinationFragment = new DestinationFragment();
        fragments.add(mDestinationFragment);
        mMallFragment = new MallFragment();
        fragments.add(mMallFragment);
        mCommunityFragment = new CommunityFragment();
        fragments.add(mCommunityFragment);

        ArrayList<String> titles = new ArrayList<>();
        titles.add("首页");
        titles.add("目的地");
        titles.add("商城");
        titles.add("社区");

        adapter = new PagerAdapter(getSupportFragmentManager(),fragments,titles);
        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_mine:
                Intent intent = new Intent(this,MineActivity.class);
                startActivity(intent);
                break;
            case R.id.img_search:
                Intent intent1 = new Intent(this,SearchActivity.class);
                intent1.putExtra("text",searchText);
                startActivity(intent1);
                break;
        }

    }
    // 创建方法，为在Fragment中的对象提供调用，验证传值
    public void fragmentToActivity(String text){
        searchText = text;
    }

    private long firstTime = 0;
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {                                         //如果两次按键时间间隔大于2秒，则不退出
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = secondTime;//更新firstTime
                    return true;
                } else {                                                    //两次按键小于2秒时，退出应用
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }
}
