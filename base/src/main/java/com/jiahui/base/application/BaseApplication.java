package com.jiahui.base.application;

import android.app.Application;

import com.apkfuns.logutils.LogLevel;
import com.apkfuns.logutils.LogUtils;
import com.jiahui.base.BuildConfig;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by jiahui.chen on 2016/8/15.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 配置log
        if (BuildConfig.LOG_SWITCH) {
            initLog();
        }

        // 配置LeakCanary
        if (BuildConfig.LEAK_SWITCH) {
            LeakCanary.install(this);
        }
    }

    private void initLog() {
        LogUtils.getLogConfig().configAllowLog(true).configTagPrefix("MyAppName").configShowBorders(true)
                .configFormatTag("%d{HH:mm:ss:SSS} %t %c{-5}").configLevel(LogLevel.TYPE_VERBOSE);
    }
}
