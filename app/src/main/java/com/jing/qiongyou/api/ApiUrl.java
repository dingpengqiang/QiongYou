package com.jing.qiongyou.api;

import com.jing.qiongyou.model.homepage.Home;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ding.pengqiang
 * on 2017/3/27.
 *
 *
 */

public interface ApiUrl {


    @GET("qyer/home/home_feed")
    Call<Home> getHome(@Query("client_id")String client_id,
                       @Query("client_secret")String client_secret,
                       @Query("v")String v,
                       @Query("track_deviceid")String track_deviceid,
                       @Query("track_app_version")String track_app_version,
                       @Query("track_app_channel")String track_app_channel,
                       @Query("track_device_info")String track_device_info,
                       @Query("track_os")String track_os,
                       @Query("app_installtime")Long app_installtime,
                       @Query("lat")String lat,
                       @Query("lon")String lon,
                       @Query("page")String page);
}
