package com.example.levelbatteryandlocation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private lateinit var getLevelBatteryBtn: Button
    private lateinit var getMemoryBtn: Button
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        find()
        getLevelBattery()
        getMemory()
    }

    private fun find() {
        getLevelBatteryBtn = findViewById(R.id.getLevelBatteryBtn)
        getMemoryBtn = findViewById(R.id.getMemoryBtn)
        text = findViewById(R.id.hyinyaAneTema)
    }

    private fun getLevelBattery() {
        val myWorkRequest = PeriodicWorkRequest.Builder(
            MyWorker::class.java,
            15,
            TimeUnit.MINUTES
        )
            .build()
        getLevelBatteryBtn.setOnClickListener {
            WorkManager.getInstance(this).enqueue(myWorkRequest)
        }
    }

    private fun getMemory() {
        val myWorkRequest = PeriodicWorkRequest.Builder(
            MemoryWorker::class.java,
            15,
            TimeUnit.MINUTES
        )
            .build()
        getMemoryBtn.setOnClickListener {
            WorkManager.getInstance(this).enqueue(myWorkRequest)
        }
    }
}