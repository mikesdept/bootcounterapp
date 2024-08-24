package mikes.dept.presentation.ui.booteventlist.adapter

import androidx.recyclerview.widget.DiffUtil
import mikes.dept.domain.entities.BootEventEntity

class BootEventDiffUtil : DiffUtil.ItemCallback<BootEventEntity>() {

    override fun areItemsTheSame(oldItem: BootEventEntity, newItem: BootEventEntity): Boolean {
        return oldItem.timestamp == newItem.timestamp
    }

    override fun areContentsTheSame(oldItem: BootEventEntity, newItem: BootEventEntity): Boolean {
        return oldItem == newItem
    }

}
