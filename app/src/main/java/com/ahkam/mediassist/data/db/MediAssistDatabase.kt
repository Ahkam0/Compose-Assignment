package com.ahkam.mediassist.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahkam.mediassist.data.model.ProblemsResponse


@Database(
    entities = [ProblemsResponse.Problems::class],
    version = 1,
    exportSchema = false
)
abstract class MediAssistDatabase : RoomDatabase() {
    abstract fun problemDao(): ProblemsDAO

}