package com.jiahui.base.application;

import android.app.Application;

import com.jiahui.base.BuildConfig;
import com.jiahui.base.analytics.AnalyticsManager;

/**
 * Created by jiahui.chen on 2016/8/15.
 */
public class AnalyticsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AnalyticsManager.getInstance().setSwitch(BuildConfig.ANALYTICS_SWITCH);
        if (BuildConfig.ANALYTICS_SWITCH) {
            AnalyticsManager.getInstance().init(this);
        }
    }

}
