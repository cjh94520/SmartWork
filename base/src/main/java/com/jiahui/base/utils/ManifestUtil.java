package com.jiahui.base.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

/**
 * Created by jiahui.chen on 2015/12/29.
 */
public class ManifestUtil {

    /**
     * 从application中获取metaData数据
     * 
     * @param name 查询字段
     * @return 返回结果
     */
    public static String getMetaDataInApplication(Context context, String name) {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo;
        Object value = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                value = applicationInfo.metaData.get(name);
            }
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
        return value == null ? null : value.toString();
    }

    /**
     * 从Activity中获取metaData数据
     * 
     * @param name 查询字段
     * @return 返回结果
     */
    public static String getMetaDataInActivity(Activity context, String name) {
        PackageManager packageManager = context.getPackageManager();
        ActivityInfo activityInfo;
        Object value = null;
        try {
            activityInfo = packageManager.getActivityInfo(context.getComponentName(), PackageManager.GET_META_DATA);
            if (activityInfo != null && activityInfo.metaData != null) {
                value = activityInfo.metaData.get(name);
            }
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
        return value == null ? null : value.toString();
    }

    /**
     * 从Service中获取metaData数据
     * 
     * @param name 查询字段
     * @return 返回结果
     */
    public static String getMetaDataInService(Context context, Class className, String name) {
        PackageManager packageManager = context.getPackageManager();
        ServiceInfo serviceInfo;
        Object value = null;
        try {
            ComponentName cn = new ComponentName(context, className);
            serviceInfo = packageManager.getServiceInfo(cn, PackageManager.GET_META_DATA);
            if (serviceInfo != null && serviceInfo.metaData != null) {
                value = serviceInfo.metaData.get(name);
            }
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
        return value == null ? null : value.toString();
    }

    /**
     * 从Receiver中获取metaData数据
     * 
     * @param name 查询字段
     * @return 返回结果
     */
    public static String getMetaDataInReceiver(Context context, Class className, String name) {
        PackageManager packageManager = context.getPackageManager();
        ActivityInfo activityInfo;
        Object value = null;
        try {
            ComponentName cn = new ComponentName(context, className);
            activityInfo = packageManager.getReceiverInfo(cn, PackageManager.GET_META_DATA);
            if (activityInfo != null && activityInfo.metaData != null) {
                value = activityInfo.metaData.get(name);
            }
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
        return value == null ? null : value.toString();
    }
}
