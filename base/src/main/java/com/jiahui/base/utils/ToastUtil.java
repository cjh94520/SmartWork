package com.jiahui.base.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jiahui.chen on 2016/8/15.
 */
public class ToastUtil {
    private static Toast mToast = null;

    public static void showToast(Context context, String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
