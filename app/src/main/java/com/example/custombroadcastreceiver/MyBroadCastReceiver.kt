package com.example.custombroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context, p1: Intent) {
        if(p0.getString(R.string.custom_broadcast_action).equals(p1.action)) {
            val stringValue = p1.getStringExtra(p0.getString(R.string.string_extra))
            val intent = Intent()
            intent.setClassName(p0.getString(R.string.package_name),
                p0.getString(R.string.main_activity_with_package_name))
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(p0.getString(R.string.string_extra),stringValue)
            p0.startActivity(intent);
        }
    }
}