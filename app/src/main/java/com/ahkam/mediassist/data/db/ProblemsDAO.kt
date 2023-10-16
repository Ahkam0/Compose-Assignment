package com.ahkam.mediassist.data.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahkam.mediassist.data.model.ProblemsResponse

interface ProblemsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProblems(problems: List<ProblemsResponse.Problems>)

    @Query("DELETE FROM tbl_problems")
    suspend fun deleteAllProblems()

    @Query("SELECT * FROM tbl_problems")
    suspend fun getProblems(): List<ProblemsResponse.Problems>
}