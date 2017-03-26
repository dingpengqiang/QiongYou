package com.jing.qiongyou.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jing.qiongyou.model.homepage.Home;

import java.util.List;

/**
 * Created by Ding.pengqiang
 * on 2017/3/27.
 */

public class HomePagerAdapter extends BaseQuickAdapter<Home,BaseViewHolder> {

    private  List<Home> data;

    public HomePagerAdapter(int layoutResId, List<Home> data) {
        super(layoutResId, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, Home item) {

    }
}
