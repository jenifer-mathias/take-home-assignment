package br.com.jenifer.airtable.di

import br.com.jenifer.airtable.data.repository.EventDataRepository
import br.com.jenifer.airtable.data.repository.EventDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindEventDataRepository(
        impl: EventDataRepositoryImpl
    ): EventDataRepository
}
