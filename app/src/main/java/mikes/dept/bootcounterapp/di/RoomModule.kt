package mikes.dept.bootcounterapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import mikes.dept.data.database.BootCounterAppAppDatabase
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideBootCounterAppDatabase(context: Context): BootCounterAppAppDatabase = Room
        .databaseBuilder(context, BootCounterAppAppDatabase::class.java, "boot_counter_app_database")
        .build()

}
