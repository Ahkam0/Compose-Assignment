package com.ahkam.mediassist.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahkam.mediassist.data.model.ProblemsResponse


@Database(
    entities = [ProblemsResponse.Problems::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = arrayOf(DiabetesConverter::class, AsthmaConverter::class))
abstract class MediAssistDatabase : RoomDatabase() {
    abstract fun problemDao(): ProblemsDAO

}