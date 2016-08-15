package com.jiahui.base.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by jiahui.chen on 2016/8/15.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
    }

    protected int getLayoutResource() {
        return -1;
    }

}
