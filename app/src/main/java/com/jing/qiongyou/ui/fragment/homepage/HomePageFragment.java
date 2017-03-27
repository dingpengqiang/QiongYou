package com.jing.qiongyou.ui.fragment.homepage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jing.qiongyou.QiongYouApp;
import com.jing.qiongyou.R;
import com.jing.qiongyou.adapter.HomePagerAdapter;
import com.jing.qiongyou.api.ApiUrl;
import com.jing.qiongyou.base.BaseFragment;
import com.jing.qiongyou.model.homepage.Home;
import com.jing.qiongyou.ui.activity.MainActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    private QiongYouApp app;

    private Home.DataBean data;
    private HomePagerAdapter adapter;
    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_homepage,container,false);
        app = ((QiongYouApp) getActivity().getApplication());

        initView(layout);
        initData();

        initRecyclerView();
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
        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(app.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        ApiUrl url = retrofit.create(ApiUrl.class);
        Call<Home> call = url.getHome(app.client_id, app.client_secret,"1",app.track_deviceid
                                        ,app.track_app_version,app.track_app_channel,
                app.track_device_info,app.track_os,app.app_installtime,app.lat,app.lng,"1");
        call.enqueue(new Callback<Home>() {


            @Override
            public void onResponse(Call<Home> call, Response<Home> response) {
                Home body = response.body();
                if (body != null){
                    data = body.getData();
                    initBanner();
                    initTextView();
                    adapter.addData(body.getData().getFeed().getEntry());
                }


            }

            @Override
            public void onFailure(Call<Home> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });

    }



    private void initBanner() {
        mBanner.setImageLoader(new GlideImageLoader());

        if (data ==  null){
            return;
        }
        List<Home.DataBean.SlideBean> slideList = data.getSlide();
        List<String> images = new ArrayList<>();

        for (Home.DataBean.SlideBean  slide:
                slideList) {
            String photo = slide.getPhoto();
            images.add(photo);
        }
        mBanner.setImages(images);
        mBanner.start();
    }
    private void initTextView() {
        if (data ==null){
            return;
        }
        Home.DataBean.CommentEntryBean commentEntry = data.getComment_entry();
        mMore.setText("\t"+commentEntry.getTitle());
    }
    private void initRecyclerView() {
        adapter = new HomePagerAdapter(R.layout.item_home,null);
        mRecyclerView.setAdapter(adapter);
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.add_header, null);
        adapter.addHeaderView(header);
    }
    private void initValue(){
        if (data == null){
            return;
        }
        String keyword = data.getKeyword();
        mainActivity.fragmentToActivity(keyword);
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = ((MainActivity) context);
    }
}
