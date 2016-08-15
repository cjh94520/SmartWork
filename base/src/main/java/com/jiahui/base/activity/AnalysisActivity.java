package com.jiahui.base.activity;

import com.jiahui.base.analytics.AnalyticsManager;

/**
 * Created by jiahui.chen on 2016/8/15.
 */
public class AnalysisActivity extends BaseActivity {

    @Override
    protected void onResume() {
        super.onResume();
        AnalyticsManager.getInstance().onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AnalyticsManager.getInstance().onPause(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
