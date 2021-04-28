package com.example.levelbatteryandlocation

import android.content.Context
import android.os.BatteryManager
import android.os.storage.StorageManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class MemoryWorker(context: Context, workerParams: WorkerParameters):Worker(context, workerParams,) {
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
    
}