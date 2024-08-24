package mikes.dept.bootcounterapp

import android.app.Application
import mikes.dept.bootcounterapp.di.AppComponent
import mikes.dept.bootcounterapp.di.DaggerAppComponent
import mikes.dept.presentation.di.SubcomponentProvider
import mikes.dept.presentation.ui.booteventlist.BootEventListSubcomponent
import mikes.dept.presentation.ui.main.MainSubcomponent
import mikes.dept.presentation.ui.settings.SettingsSubcomponent

class App : Application(), SubcomponentProvider {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(applicationContext)
            .build()
    }

    override fun provideMainSubcomponent(): MainSubcomponent = appComponent.mainSubcomponentBuilder().build()

    override fun provideBootEventListSubcomponent(): BootEventListSubcomponent = appComponent.bootEventListSubcomponentBuilder().build()

    override fun provideSettingsSubcomponent(): SettingsSubcomponent = appComponent.settingsSubcomponentBuilder().build()

}
