package com.ahkam.mediassist.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahkam.mediassist.data.model.ProblemsResponse


@TypeConverters(Converter::class)
@Database(
    entities = [ProblemsResponse.Problems::class],
    version = 1,
    exportSchema = false
)
abstract class MediAssistDatabase : RoomDatabase() {
    abstract fun problemDao(): ProblemsDAO

}