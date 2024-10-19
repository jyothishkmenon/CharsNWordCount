package com.truecaller.assignment.charsnwords

import com.truecaller.assignment.charsnwords.repository.TruecallerApiService
import com.truecaller.assignment.charsnwords.repository.TruecallerRepository
import com.truecaller.assignment.charsnwords.repository.TruecallerRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTruecallerApiService(): TruecallerApiService {
        return Retrofit.Builder()
            .baseUrl("https://www.truecaller.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
            .create(TruecallerApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideTruecallerRepository(apiService: TruecallerApiService): TruecallerRepository {
        return TruecallerRepositoryImpl(apiService)
    }
}