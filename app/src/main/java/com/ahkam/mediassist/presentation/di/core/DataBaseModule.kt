package com.ahkam.mediassist.presentation.di.core

import android.app.Application
import androidx.room.Room
import com.ahkam.mediassist.data.db.Converter
import com.ahkam.mediassist.data.db.MediAssistDatabase
import com.ahkam.mediassist.data.db.ProblemsDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideProblemDataBase(app: Application): MediAssistDatabase {
        return Room.databaseBuilder(app, MediAssistDatabase::class.java, "mediassist")
            .addTypeConverter(Converter())
            .build()
    }

    @Singleton
    @Provides
    fun provideProblemDao(mediAssistDatabase: MediAssistDatabase): ProblemsDAO {
        return mediAssistDatabase.problemDao()
    }

}