package com.futurepastapps.notificationapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;

/**
 * Created by HP on 25-01-2019.
 */

public class CheckLaunchType {

    public enum AppStart {

        FIRST_TIME, FIRST_TIME_VERSION, NORMAL;
    }

    private static final String LAST_APP_VERSION = "last_app_version";

    public AppStart checkAppStart(Context context) {

        PackageInfo packageInfo;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        AppStart appStart = AppStart.NORMAL;

        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            float lastVersionCode = sharedPreferences.getFloat(LAST_APP_VERSION, -1);
            float currentVersionCode = packageInfo.versionCode;
            appStart = checkVersion(currentVersionCode, lastVersionCode);
            sharedPreferences.edit().putFloat(LAST_APP_VERSION, currentVersionCode).commit();
        } catch (PackageManager.NameNotFoundException e) {
        }

        return appStart;
    }

    private AppStart checkVersion(float currentVersionCode, float lastVersionCode) {

        if(lastVersionCode == -1)
            return AppStart.FIRST_TIME;
        else if(lastVersionCode < currentVersionCode)
            return AppStart.FIRST_TIME_VERSION;
        else if(lastVersionCode > currentVersionCode)
            return AppStart.NORMAL;
        else
            return AppStart.NORMAL;
    }
}
