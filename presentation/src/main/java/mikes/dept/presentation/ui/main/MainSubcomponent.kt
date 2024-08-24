package mikes.dept.presentation.ui.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Subcomponent(modules = [MainModule::class])
interface MainSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): MainSubcomponent

    }

    fun inject(mainActivity: MainActivity)

}

@Module
interface MainModule {

    @Binds
    @IntoMap
    @ClassKey(MainViewModelImpl::class)
    fun bindViewModel(mainViewModelImpl: MainViewModelImpl): ViewModel

}
