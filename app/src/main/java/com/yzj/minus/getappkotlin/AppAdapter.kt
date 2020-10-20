package com.yzj.minus.getappkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class AppAdapter(val appList:List<App>) : RecyclerView.Adapter<AppAdapter.ViewHolder>(){
    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val app = view.findViewById<TextView>(R.id.app)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_app, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val app = appList[position]
        val jsonObject = JSONObject().run {
            app.apply {
                put("app_package_name", appPackageName);
                put("app_name", appName);
                put("app_icon", appIcon);
                put("app_version_code", appVersionCode);
                put("app_version_name", appVersionName);
                put("app_first_install_time", appFirstInstallTime);
                put("app_last_update_time", appLastUpdateTime);
                put("app_launch_activity_name", appLaunchActivityName);
                put("app_target_sdk_version", appTargetSdkVersion);
                put("app_min_sdk_version", appMinSdkVersion);
                put("app_data_dir", appDataDir);
                put("app_source_dir", appSourceDir);
                put("app_uid", appUid);
                put("app_flags", appFlags);
            }
            toString(2)
        }
        holder.app.text =jsonObject
    }

    override fun getItemCount() = appList.size
}