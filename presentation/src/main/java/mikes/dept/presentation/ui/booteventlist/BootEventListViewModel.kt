package mikes.dept.presentation.ui.booteventlist

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import mikes.dept.presentation.ui.core.IViewModel
import javax.inject.Inject

interface BootEventListViewModel : IViewModel {

    val navDirections: SharedFlow<NavDirections>

    fun onClickSettings()

}

class BootEventListViewModelImpl @Inject constructor() : ViewModel(), BootEventListViewModel {

    override val navDirections: MutableSharedFlow<NavDirections> = MutableSharedFlow(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    override fun onClickSettings() {
        navDirections.tryEmit(BootEventListFragmentDirections.navSettingsFragment())
    }

}
