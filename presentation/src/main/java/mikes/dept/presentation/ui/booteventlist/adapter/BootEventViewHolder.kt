package mikes.dept.presentation.ui.booteventlist.adapter

import androidx.recyclerview.widget.RecyclerView
import mikes.dept.domain.entities.BootEventEntity
import mikes.dept.presentation.databinding.ViewItemBootEventBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class BootEventViewHolder(
    private val viewItemBootEventBinding: ViewItemBootEventBinding
) : RecyclerView.ViewHolder(viewItemBootEventBinding.root) {

    private companion object {
        private const val DATE_FORMAT_PATTERN = "dd/MM/yyyy"
        private const val UNDEFINED_DATE = "Undefined"
    }

    fun bind(bootEventEntity: BootEventEntity) {
        viewItemBootEventBinding.tvItem.text = bootEventEntity.timestamp.convertTimestamp()
    }

    private fun Long.convertTimestamp(): String {
        return runCatching {
            val sdf = SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.getDefault())
            return sdf.format(Date(this))
        }.getOrElse { UNDEFINED_DATE }
    }

}
