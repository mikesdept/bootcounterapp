package mikes.dept.presentation.ui.booteventlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import mikes.dept.domain.entities.BootEventEntity
import mikes.dept.presentation.databinding.ViewItemBootEventBinding
import javax.inject.Inject

class BootEventAdapter @Inject constructor() : ListAdapter<BootEventEntity, BootEventViewHolder>(BootEventDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BootEventViewHolder = BootEventViewHolder(
        ViewItemBootEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: BootEventViewHolder, position: Int) {
        getItem(position)?.let { event -> holder.bind(event) }
    }

}
