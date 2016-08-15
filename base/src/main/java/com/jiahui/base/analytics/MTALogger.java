package com.jiahui.base.analytics;

import android.content.Context;

import com.jiahui.base.BuildConfig;
import com.tencent.stat.MtaSDkException;
import com.tencent.stat.StatService;

/**
 * Created by jiahui.chen on 2016/8/15.
 */
public class MTALogger implements AnalyticsLogger {
    public MTALogger(Context context) {
        String appKey = BuildConfig.MTA_APP_KEY;
        try {
            StatService.startStatService(context, appKey,
                    com.tencent.stat.common.StatConstants.VERSION);
        } catch (MtaSDkException e) {
            // MTA初始化失败
            // TODO: 2016/8/15  
        }
    }

    @Override
    public void onResume(Context context) {
        StatService.onResume(context);
    }

    @Override
    public void onPause(Context context) {
        StatService.onPause(context);
    }

    @Override
    public void onStop(Context context) {
        StatService.onStop(context);
    }

    @Override
    public void onLowMemory(Context context) {
        StatService.onLowMemory(context);
    }
}
