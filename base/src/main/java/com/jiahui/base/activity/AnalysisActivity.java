package com.jiahui.base.activity;

import com.tencent.stat.StatService;

/**
 * Created by jiahui.chen on 2016/8/15.
 */
public class AnalysisActivity extends BaseActivity {

    @Override
    protected void onResume() {
        super.onResume();
        StatService.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        StatService.onStop(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        StatService.onStop(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        StatService.onLowMemory(this);
    }
}
