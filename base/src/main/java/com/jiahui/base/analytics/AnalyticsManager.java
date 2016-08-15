package com.jiahui.base.analytics;

import android.content.Context;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiahui.chen on 2016/8/15.
 */
public class AnalyticsManager implements AnalyticsLogger {
    private static AnalyticsManager manager = null;

    public static AnalyticsManager getInstance() {
        if (manager == null) {
            synchronized (AnalyticsManager.class) {
                if (manager == null) {
                    manager = new AnalyticsManager();
                }
            }
        }
        return manager;
    }

    public void init(Context context)
    {
        mAnalyticsSet.add(new MTALogger(context));
    }

    private static boolean isEnabled = false;

    public static void setSwitch(boolean isEnable) {
        isEnable = isEnable;
    }

    private Set<AnalyticsLogger> mAnalyticsSet = new HashSet<>();

    public void cleanAll() {
        if (mAnalyticsSet != null && !mAnalyticsSet.isEmpty()) {
            mAnalyticsSet.clear();
        }
    }

    public void destory() {
        cleanAll();
        manager = null;
    }

    @Override
    public void onResume(Context context) {
        if (!isEnabled) return;
        if (mAnalyticsSet != null && !mAnalyticsSet.isEmpty()) {
            for (AnalyticsLogger logger : mAnalyticsSet) {
                logger.onResume(context);
            }
        }
    }

    @Override
    public void onPause(Context context) {
        if (!isEnabled) return;
        if (mAnalyticsSet != null && !mAnalyticsSet.isEmpty()) {
            for (AnalyticsLogger logger : mAnalyticsSet) {
                logger.onPause(context);
            }
        }
    }

    @Override
    public void onStop(Context context) {
        if (!isEnabled) return;
        if (mAnalyticsSet != null && !mAnalyticsSet.isEmpty()) {
            for (AnalyticsLogger logger : mAnalyticsSet) {
                logger.onStop(context);
            }
        }
    }

    @Override
    public void onLowMemory(Context context) {
        if (!isEnabled) return;
        if (mAnalyticsSet != null && !mAnalyticsSet.isEmpty()) {
            for (AnalyticsLogger logger : mAnalyticsSet) {
                logger.onLowMemory(context);
            }
        }
    }
}
