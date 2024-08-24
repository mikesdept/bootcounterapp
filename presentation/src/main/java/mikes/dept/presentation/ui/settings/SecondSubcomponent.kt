package mikes.dept.presentation.ui.settings

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Subcomponent(modules = [SettingsModule::class])
interface SettingsSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): SettingsSubcomponent

    }

    fun inject(settingsFragment: SettingsFragment)

}

@Module
interface SettingsModule {

    @Binds
    @IntoMap
    @ClassKey(SettingsViewModelImpl::class)
    fun bindViewModel(settingsViewModelImpl: SettingsViewModelImpl): ViewModel

}
