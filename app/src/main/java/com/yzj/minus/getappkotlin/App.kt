package com.yzj.minus.getappkotlin

import android.graphics.drawable.Drawable

class App(
    val appPackageName: String,
    val appName: String,
    val appIcon: Drawable,
    val appVersionCode: Long,
    val appVersionName: String,
    val appFirstInstallTime: Long,
    val appLastUpdateTime: Long,
    val appLaunchActivityName: String?,
    val appTargetSdkVersion: Int,
    val appMinSdkVersion: Int,
    val appDataDir: String,
    val appSourceDir: String,
    val appUid: Int,
    val appFlags: Int
)