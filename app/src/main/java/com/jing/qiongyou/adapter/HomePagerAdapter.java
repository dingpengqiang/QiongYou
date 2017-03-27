package com.jing.qiongyou.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jing.qiongyou.R;
import com.jing.qiongyou.model.homepage.Home;

import java.util.List;

/**
 * Created by Ding.pengqiang
 * on 2017/3/27.
 */

public class HomePagerAdapter extends BaseQuickAdapter<Home.DataBean.FeedBean.EntryBean,BaseViewHolder> {

    private  List<Home.DataBean.FeedBean.EntryBean> data;

    public HomePagerAdapter(int layoutResId, List<Home.DataBean.FeedBean.EntryBean> data) {
        super(layoutResId, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, Home.DataBean.FeedBean.EntryBean item) {
        helper.setText(R.id.tag,item.getColumn());
        ImageView image = helper.getView(R.id.image);
        Glide.with(mContext).load(item.getCover()).into(image);
        ImageView img = helper.getView(R.id.small_img);
        Glide.with(mContext).load(item.getIcon_url()).into(img);
        if (item.getAuthor() != null) {
            helper.setText(R.id.auth, item.getAuthor().getUsername());
            ImageView imageView = helper.getView(R.id.image_head);
            Glide.with(mContext).load(item.getAuthor().getPic()).into(imageView);
        }else {
            helper.getView(R.id.auth).setVisibility(View.GONE);
            helper.getView(R.id.image_head).setVisibility(View.GONE);
        }
        helper.setText(R.id.title,item.getTitle()).setText(R.id.content,item.getSubject());

    }
}
