package com.efly.flyhelper;

import android.content.Context;

import com.efly.flyhelper.ui.main.MainActivity;
import com.lys.base.base.BaseApplication;
import com.zxy.recovery.callback.RecoveryCallback;
import com.zxy.recovery.core.Recovery;

import java.util.logging.Logger;


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

        Recovery.getInstance()//crash崩溃监听处理
                .debug(false)
                .recoverInBackground(false)
                .recoverStack(true)
                .mainPage(MainActivity.class)
                .recoverEnabled(true)
                .callback(new MyCrashCallback())
                .silent(true, Recovery.SilentMode.RECOVER_ACTIVITY_STACK)
                .init(this);
    }

    /**获取系统上下文：用于ToastUtil类*/
    public static Context getAppContext()
    {
        return mContext;
    }

    static final class MyCrashCallback implements RecoveryCallback {
        @Override
        public void stackTrace(String exceptionMessage) {
//            Logger.("exceptionMessage:" + exceptionMessage);
        }

        @Override
        public void cause(String cause) {
//            Logger.e("cause:" + cause);
        }

        @Override
        public void exception(String exceptionType, String throwClassName, String throwMethodName, int throwLineNumber) {
//            Logger.e("exceptionClassName:" + exceptionType);
//            Logger.e("throwClassName:" + throwClassName);
//            Logger.e("throwMethodName:" + throwMethodName);
//            Logger.e("throwLineNumber:" + throwLineNumber);
        }

        @Override
        public void throwable(Throwable throwable) {

        }
    }

}
