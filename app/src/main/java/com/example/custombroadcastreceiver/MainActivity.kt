package com.example.custombroadcastreceiver

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.custombroadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val myBroadCastReceiver = MyBroadCastReceiver()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intentFilter = IntentFilter(getString(R.string.custom_broadcast_action))
        registerReceiver(
            myBroadCastReceiver,
            intentFilter,
            getString(R.string.custom_broadcast_permission_name),
            null
        )
    }

    override fun onStart() {
        super.onStart()
        val intent = intent
        binding.textView.text = intent.getStringExtra(getString(R.string.string_extra))
    }

    override fun onDestroy() {
        unregisterReceiver(myBroadCastReceiver)
        super.onDestroy()
    }
}