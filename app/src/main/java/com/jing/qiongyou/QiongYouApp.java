package com.jing.qiongyou;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.Date;

/**
 * Created by Ding.pengqiang
 * on 2017/3/27.
 */

public class QiongYouApp extends Application{

    public  String baseUrl = "http://open.qyer.com/";

    public  String baseParms;

    public   String client_id;

    public   String client_secret;

    public   String track_deviceid;

    public   String track_app_version;

    public   String track_app_channel;

    public   String track_device_info;

    public   String track_os;

    public   String lat;

    public   String lng;

    public long app_installtime;

    private static final String TAG = QiongYouApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        initPhone();
    }

    private void initPhone() {
        TelephonyManager systemService = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);



        String imei = systemService.getDeviceId();//865091021242014
        String imsi = systemService.getSubscriberId();//460027894050051
        String mtype = android.os.Build.MODEL; // 手机型号vivo X3V
        String mtyb= android.os.Build.BRAND;//手机品牌vivo
        String numer = systemService.getLine1Number(); // 手机号码，有的可得，有的不可得

        String radioVersion = Build.getRadioVersion();//6-00140-M8926DAAAANAZM-1.10741.1
        String board = Build.BOARD;//MSM8226
        String bootloader = Build.BOOTLOADER;//unknown
        //手机品牌
        String brand = Build.BRAND;//vivo
        //手机cpu
        String device = Build.DEVICE;//msm8226
        String display = Build.DISPLAY;//KVT49L dev-keys
        String fingerprint = Build.FINGERPRINT;//vivo/msm8226/msm8226:4.4.2/KVT49L/user.compiler.20160328.160114:user/dev-keys
        //QCOM是Qualcomm的缩写，中文名字叫做高通，是一个CPU品牌
        String hardware = Build.HARDWARE;//qcom
        String host = Build.HOST;//compiler014
        String id = Build.ID;//KVT49L
        //手机的生产商
        String manufacturer = Build.MANUFACTURER;//vivo
        //手机的型号
        String model = Build.MODEL;//vivo X3V
        String product = Build.PRODUCT;//msm8226
        String serial = Build.SERIAL;//e05e8a2e
        String tags = Build.TAGS;//dev-keys
        long time = Build.TIME;//1459152467000
        String user = Build.USER;//compiler
        int sdkInt = Build.VERSION.SDK_INT;//19
        String codename = Build.VERSION.CODENAME;//REL
        String release = Build.VERSION.RELEASE;//4.4.2
//        String incremental = Build.VERSION.INCREMENTAL;//
//        int previewSdkInt = Build.VERSION.PREVIEW_SDK_INT;//
//        String securityPatch = Build.VERSION.SECURITY_PATCH;//

        client_id ="qyer_android";

        client_secret = "9fcaae8aefc4f9ac4915";

        track_deviceid = systemService.getDeviceId();

        track_app_version = "7.5.0";

        track_app_channel = Build.BRAND;

        track_device_info = Build.DEVICE;

        track_os = "Android"+Build.VERSION.RELEASE;

        lat = "30.17022";

        lng = "120.141753";

        app_installtime =  System.currentTimeMillis();


    }
}
