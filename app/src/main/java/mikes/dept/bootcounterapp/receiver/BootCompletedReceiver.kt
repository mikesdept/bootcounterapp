package mikes.dept.bootcounterapp.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import mikes.dept.bootcounterapp.App
import mikes.dept.domain.entities.BootEventEntity
import mikes.dept.domain.usecase.InsertBootEventUseCase
import javax.inject.Inject

class BootCompletedReceiver : BroadcastReceiver() {

    @Inject
    lateinit var insertBootEventUseCase: InsertBootEventUseCase

    private val scope: CoroutineScope = CoroutineScope(SupervisorJob())

    override fun onReceive(context: Context?, intent: Intent?) {
        (context?.applicationContext as? App)?.appComponent?.inject(this)
        if (Intent.ACTION_BOOT_COMPLETED == intent?.action) {
            scope.launch {
                insertBootEventUseCase(BootEventEntity(timestamp = System.currentTimeMillis()))
            }
        }
    }

}
