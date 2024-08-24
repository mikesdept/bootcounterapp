package mikes.dept.presentation.ui.booteventlist

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Subcomponent(modules = [BootEventListModule::class])
interface BootEventListSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): BootEventListSubcomponent

    }

    fun inject(bootEventListFragment: BootEventListFragment)

}

@Module
interface BootEventListModule {

    @Binds
    @IntoMap
    @ClassKey(BootEventListViewModelImpl::class)
    fun bindViewModel(bootEventListViewModelImpl: BootEventListViewModelImpl): ViewModel

}
