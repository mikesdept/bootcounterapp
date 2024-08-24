package mikes.dept.bootcounterapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import mikes.dept.bootcounterapp.receiver.BootCompletedReceiver
import mikes.dept.presentation.ui.booteventlist.BootEventListSubcomponent
import mikes.dept.presentation.ui.main.MainSubcomponent
import mikes.dept.presentation.ui.settings.SettingsSubcomponent
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent

    }

    fun mainSubcomponentBuilder(): MainSubcomponent.Builder

    fun bootEventListSubcomponentBuilder(): BootEventListSubcomponent.Builder

    fun settingsSubcomponentBuilder(): SettingsSubcomponent.Builder

    fun inject(bootCompletedReceiver: BootCompletedReceiver)

}
