package com.jiahui.base.activity;

import android.app.Activity;
import android.os.Bundle;

import com.apkfuns.logutils.LogUtils;
import com.jiahui.jpinyin.PinyinException;
import com.jiahui.jpinyin.PinyinFormat;
import com.jiahui.jpinyin.PinyinHelper;

/**
 * Created by jiahui.chen on 2016/8/15.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(getLayoutResource());
    }

    protected int getLayoutResource() {
        return -1;
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            LogUtils.d(PinyinHelper.convertToPinyinString("市长", "", PinyinFormat.WITHOUT_TONE));
        } catch (PinyinException e) {
            e.printStackTrace();
        }
    }
}
