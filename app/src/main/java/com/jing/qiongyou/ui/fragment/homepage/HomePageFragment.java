package com.jing.qiongyou.ui.fragment.homepage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jing.qiongyou.R;
import com.jing.qiongyou.base.BaseFragment;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Ding.pengqiang
 * on 2017/3/27.
 *
 * 首页
 */

public class HomePageFragment extends BaseFragment {

    public static final String TAG = HomePageFragment.class.getSimpleName();
    private Banner mBanner;
    private TextView mMore;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_homepage,container,false);

        initView(layout);
        initData();

        return layout;
    }



    private void initView(View layout) {

        mBanner = (Banner)layout.findViewById(R.id.banner);
        mMore = ((TextView) layout.findViewById(R.id.more));
        mRecyclerView = ((RecyclerView) layout.findViewById(R.id.recyclerView));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    private void initData() {
        initBanner();
        initRecyclerView();
    }



    private void initBanner() {
        mBanner.setImageLoader(new GlideImageLoader());
//        mBanner.setImages();
        mBanner.start();
    }
    private void initRecyclerView() {
//        mRecyclerView.setAdapter()
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */
//            eg：

            //Glide 加载图片简单用法
            Glide.with(context).load(path).into(imageView);

//            //Picasso 加载图片简单用法
//            Picasso.with(context).load(path).into(imageView);
//
//            //用fresco加载图片简单用法，记得要写下面的createImageView方法
//            Uri uri = Uri.parse((String) path);
//            imageView.setImageURI(uri);
        }

//        //提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
//        @Override
//        public ImageView createImageView(Context context) {
//            //使用fresco，需要创建它提供的ImageView，当然你也可以用自己自定义的具有图片加载功能的ImageView
//            SimpleDraweeView simpleDraweeView=new SimpleDraweeView(context);
//            return simpleDraweeView;
//        }
    }
}
