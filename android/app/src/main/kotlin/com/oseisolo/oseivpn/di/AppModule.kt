package com.oseisolo.oseivpn.di

import android.content.Context
import androidx.room.Room
import com.oseisolo.oseivpn.data.local.AppDatabase
import com.oseisolo.oseivpn.repository.ServerRepositoryImpl
import com.oseisolo.oseivpn.repository.ServerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "oseivpn.db").build()
    }

    @Provides
    fun provideServerRepository(db: AppDatabase): ServerRepository = ServerRepositoryImpl(db.serverDao())
}
