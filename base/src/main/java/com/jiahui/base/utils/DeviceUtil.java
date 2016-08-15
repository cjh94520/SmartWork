package com.jiahui.base.utils;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by jiahui.chen on 2016/8/15.
 */
public class DeviceUtil {

    /**
     * 获取屏幕Density
     */
    public static float getDensity() {
        return Resources.getSystem().getDisplayMetrics().density;
    }


    /**
     * 获取屏幕Dpi
     */
    public static int getDPI() {
        return Resources.getSystem().getDisplayMetrics().densityDpi;
    }


    /**
     * 获取屏幕宽度像素点
     */
    public static int getWidthPixel() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度像素点
     */
    public static int getHeightPixel() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }


    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return
     */
    public static int getStatusHeight(Context context) {
        Resources rs = context.getResources();
        int id = rs.getIdentifier("status_bar_height", "dimen", "android");
        if (id > 0) {
            int statusBarHeight = rs.getDimensionPixelSize(id);
            return statusBarHeight;
        }
        return 0;
    }


    /**
     * 获取虚拟按键高度
     *
     * @param context
     * @return
     */
    public static int getNavigationBarHeight(Context context) {
        int height = 0;
        boolean isVirtualKeyShow = isVirtualKeyShow(context);
        if (isVirtualKeyShow) {
            try {
                Resources resources = context.getResources();
                int resourceId = resources.getIdentifier("navigation_bar_height_landscape", "dimen", "android");
                height = resources.getDimensionPixelSize(resourceId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return height;
    }

    /**
     * 获取虚拟按键是否展示
     *
     * @param context
     * @return
     */
    private static boolean isVirtualKeyShow(Context context) {
        boolean hasNavigationBar = false;
        Resources rs = context.getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        return hasNavigationBar;
    }

    /**
     * 判断手机是否为中文环境
     *
     * @return
     */
    public static boolean isChinaEnvironment() {
        String language = Resources.getSystem().getConfiguration().locale.getLanguage();
        String country = Resources.getSystem().getConfiguration().locale.getCountry();
        return "CN".equalsIgnoreCase(country) || "ZH".equalsIgnoreCase(language);
    }
}
