package mikes.dept.bootcounterapp.di

import dagger.Binds
import dagger.Module
import mikes.dept.data.repository.BootEventRepositoryImpl
import mikes.dept.domain.repository.BootEventRepository

@Module
interface BindModule {

    @Binds
    fun bindBootEventRepository(bootEventRepositoryImpl: BootEventRepositoryImpl): BootEventRepository

}
