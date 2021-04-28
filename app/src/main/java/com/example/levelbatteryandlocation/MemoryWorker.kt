package com.example.levelbatteryandlocation

import android.content.Context
import android.os.Build
import android.os.Environment
import android.os.StatFs
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MemoryWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        showToast()
        return Result.success()
    }

    private fun ads(): Long {
        val stat = StatFs(Environment.getExternalStorageDirectory().getPath())
        val bytesAvailable: Long
        bytesAvailable = if (Build.VERSION.SDK_INT >=
            Build.VERSION_CODES.JELLY_BEAN_MR2
        ) {
            stat.blockSizeLong * stat.availableBlocksLong
        } else {
            stat.blockSize.toLong() * stat.availableBlocks.toLong()
        }
        val megAvailable = bytesAvailable / (1024 * 1024)
        return megAvailable
    }

    private fun showToast() {
        CoroutineScope(Dispatchers.Main).launch {
            Toast.makeText(applicationContext, ads().toString(), Toast.LENGTH_SHORT).show()
        }
    }
}