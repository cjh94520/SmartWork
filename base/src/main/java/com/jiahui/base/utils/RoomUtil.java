package com.jiahui.base.utils;

import android.os.Build;
import android.text.TextUtils;

import java.lang.reflect.Method;

/**
 * Created by jiahui.chen on 2016/8/15.
 */
public class RoomUtil {


    /* 判断是否是小米手机或rom */
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";

    /**
     * 判断手机是否为小米系统
     *
     * @return
     */
    public static boolean isMIUISystem() {
        try {
            return !TextUtils.isEmpty(get(KEY_MIUI_VERSION_CODE)) || !TextUtils.isEmpty(get(KEY_MIUI_VERSION_NAME))
                    || !TextUtils.isEmpty(get(KEY_MIUI_INTERNAL_STORAGE));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断手机是否为华为系统
     *
     * @return
     */
    private static final String HUAWEI_KEY = "huawei";

    public static boolean isHuaWeiSystem() {
        try {
            String brand = Build.BRAND;
            String manufacturer = Build.MANUFACTURER;
            return HUAWEI_KEY.equalsIgnoreCase(brand) || HUAWEI_KEY.equalsIgnoreCase(manufacturer);
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 判断手机是否为魅族系统
     *
     * @return
     */
    private static final String MEIZU_KEY = "Meizu";

    public static boolean isMeiZuSystem() {
        try {
            String brand = Build.BRAND;
            String manufacturer = Build.MANUFACTURER;
            return MEIZU_KEY.equalsIgnoreCase(brand) || MEIZU_KEY.equalsIgnoreCase(manufacturer);
        } catch (Exception e) {
            return false;
        }
    }

    private static Class<?> mClassType = null;
    private static Method mGetMethod = null;
    private static Method mGetIntMethod = null;

    // private static Method mSetMethod = null;

    private static void init() {
        try {
            if (mClassType == null) {
                mClassType = Class.forName("android.os.SystemProperties");
                mGetMethod = mClassType.getDeclaredMethod("get", String.class);
                mGetIntMethod = mClassType.getDeclaredMethod("getInt", String.class, int.class);
                /*
                 * set方法在特殊定制化的手机，这里会抛出java.lang.NoSuchMethodException: set [class
                 * java.lang.String]异常,普通读操作可屏蔽此方法*
                 */
                // mSetMethod = mClassType.getDeclaredMethod("set", String.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        init();
        String value = null;
        try {
            value = (String) mGetMethod.invoke(mClassType, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static int getInt(String key, int def) {
        init();
        int value = def;
        try {
            Integer v = (Integer) mGetIntMethod.invoke(mClassType, key, def);
            value = v.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

}
