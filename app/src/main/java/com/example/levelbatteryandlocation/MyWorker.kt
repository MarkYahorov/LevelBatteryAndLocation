package com.example.levelbatteryandlocation

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        showToastBatteryLevel()
        return Result.success()
    }

    private fun getBatteryLevel(): Int {
        val batteryLevel =
            applicationContext.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        return batteryLevel.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
    }

    private fun showToastBatteryLevel(){
        CoroutineScope(Dispatchers.Main).launch {
            Toast.makeText(applicationContext, getBatteryLevel().toString(), LENGTH_SHORT).show()
        }
    }
}