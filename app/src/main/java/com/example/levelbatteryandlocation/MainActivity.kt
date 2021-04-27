package com.example.levelbatteryandlocation

import android.app.NotificationManager
import android.os.BatteryManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.lifecycle.Observer
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private lateinit var getLevelBatteryBtn: Button
    private lateinit var getLocationButton: Button
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        find()
        getLevelBattery()
    }

    private fun find() {
        getLevelBatteryBtn = findViewById(R.id.getLevelBatteryBtn)
        getLocationButton = findViewById(R.id.getLocateBtn)
        text = findViewById(R.id.hyinyaAneTema)
    }

    private fun getLevelBattery() {
        val myWorkRequest = PeriodicWorkRequest.Builder(
            MyWorker::class.java,
            1,
            TimeUnit.HOURS
        )
            .build()
        getLevelBatteryBtn.setOnClickListener {
            WorkManager.getInstance(this).enqueue(myWorkRequest)
        }
    }
}