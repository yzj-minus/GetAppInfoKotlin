package com.yzj.minus.getappkotlin

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

object AppData{
    @SuppressLint("QueryPermissionsNeeded")
    @RequiresApi(Build.VERSION_CODES.P)
    fun get(context:Context):List<App>{

        val appList = ArrayList<App>()

        val pm = context.packageManager
        val packageInfoList = pm.getInstalledPackages(0)
        for (info in packageInfoList){
            val appPackageName = info.packageName
            val appName = info.applicationInfo.loadLabel(pm).toString()
            val appIcon = info.applicationInfo.loadIcon(pm)
            val appVersionCode = info.longVersionCode
            val appVersionName = info.versionName
            val appFirstInstallTime = info.firstInstallTime
            val appLastUpdateTime = info.lastUpdateTime
            val appLaunchActivityName = pm.getLaunchIntentForPackage(appPackageName)
                ?.component?.className
            val applicationInfo = pm.getApplicationInfo(appPackageName, 0)
            val appTargetSdkVersion = applicationInfo.targetSdkVersion
            val appMinSdkVersion = applicationInfo.minSdkVersion
            val appDataDir = applicationInfo.dataDir
            val appSourceDir = applicationInfo.sourceDir
            val appUid = applicationInfo.uid
            val appFlags = applicationInfo.flags

            appList.add(
                App(appPackageName,
                appName,
                appIcon,
                appVersionCode,
                appVersionName,
                appFirstInstallTime,
                appLastUpdateTime,
                appLaunchActivityName,
                appTargetSdkVersion,
                appMinSdkVersion,
                appDataDir,
                appSourceDir,
                appUid,
                appFlags
            ))
        }
        return appList
    }
}