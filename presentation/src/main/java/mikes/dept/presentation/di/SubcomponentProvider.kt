package mikes.dept.presentation.di

import mikes.dept.presentation.ui.booteventlist.BootEventListSubcomponent
import mikes.dept.presentation.ui.main.MainSubcomponent
import mikes.dept.presentation.ui.settings.SettingsSubcomponent

interface SubcomponentProvider {

    fun provideMainSubcomponent(): MainSubcomponent

    fun provideBootEventListSubcomponent(): BootEventListSubcomponent

    fun provideSettingsSubcomponent(): SettingsSubcomponent

}
