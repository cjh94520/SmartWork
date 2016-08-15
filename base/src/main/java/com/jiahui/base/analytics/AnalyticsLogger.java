package com.jiahui.base.analytics;

import android.content.Context;

/**
 * Created by jiahui.chen on 2016/8/15.
 */
public interface AnalyticsLogger {
    void onResume(Context context);

    void onPause(Context context);
}
