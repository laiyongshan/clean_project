package com.efly.flyhelper;

import android.content.Context;

import com.lys.base.base.BaseApplication;

/**
 * ARouter 这里必须在 这里初始化, 在 base里面初始化 无效,奇怪
 * Created by chenchangjun on 17/8/10.
 */

public class AppApplication extends BaseApplication {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext=getApplicationContext();
    }

    /**获取系统上下文：用于ToastUtil类*/
    public static Context getAppContext()
    {
        return mContext;
    }

}
