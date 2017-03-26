package com.jing.qiongyou.api;

import com.jing.qiongyou.model.homepage.Home;

import retrofit2.Call;

/**
 * Created by Ding.pengqiang
 * on 2017/3/27.
 *
 *
 */

public interface ApiUrl {


    Call<Home> getHome();
}
