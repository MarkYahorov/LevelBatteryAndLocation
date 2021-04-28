package com.example.levelbatteryandlocation

import android.content.Context
import android.widget.Toast
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit

class AllWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }

    private fun allWorkers() {
        val myWorkRequest = PeriodicWorkRequest.Builder(
            MemoryWorker::class.java,
            15,
            TimeUnit.MINUTES
        )
            .build()
        val myWork = PeriodicWorkRequest.Builder(
            MyWorker::class.java,
            15,
            TimeUnit.MINUTES
        )
            .build()
        WorkManager.getInstance(applicationContext).enqueue(myWorkRequest)
        WorkManager.getInstance(applicationContext).enqueue(myWork)
    }
}