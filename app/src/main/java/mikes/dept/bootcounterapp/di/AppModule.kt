package mikes.dept.bootcounterapp.di

import dagger.Module

@Module(
    includes = [
        BindModule::class,
        RoomModule::class
    ]
)
interface AppModule
