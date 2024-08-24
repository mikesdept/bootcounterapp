package mikes.dept.presentation.ui.booteventlist.adapter

import androidx.recyclerview.widget.RecyclerView
import mikes.dept.domain.entities.BootEventEntity
import mikes.dept.presentation.databinding.ViewItemBootEventBinding

class BootEventViewHolder(
    private val viewItemBootEventBinding: ViewItemBootEventBinding
) : RecyclerView.ViewHolder(viewItemBootEventBinding.root) {

    fun bind(bootEventEntity: BootEventEntity) {
        viewItemBootEventBinding.tvItem.text = bootEventEntity.timestamp.toString()
    }

}
