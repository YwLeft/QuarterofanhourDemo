package com.example.asus.quarterofanhourdemo.model.net;

import android.content.pm.PackageManager;

/**
 * 类描述    获取版本号
 */
public class VersionUtils {
    private static int versionCode;

    public static int getVersoncode() throws PackageManager.NameNotFoundException {
        if (MyApp.getContext() != null) {
            versionCode = MyApp.getContext().getPackageManager().getPackageInfo(MyApp.getContext().getPackageName(), 0).versionCode;
        }
        return  versionCode;
    }
}
