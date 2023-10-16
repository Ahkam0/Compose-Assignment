package com.ahkam.mediassist.data.repository.datasourceImpl

import com.ahkam.mediassist.data.db.ProblemsDAO
import com.ahkam.mediassist.data.model.ProblemsResponse
import com.ahkam.mediassist.data.repository.datasource.ProblemLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProblemLocalDataSourceImpl(private val problemsDao: ProblemsDAO) : ProblemLocalDataSource {

    override suspend fun getProblemsFromDB(): List<ProblemsResponse.Problems> {
        return problemsDao.getProblems()
    }

    override suspend fun saveProblemsToDB(problems: List<ProblemsResponse.Problems>) {
        CoroutineScope(Dispatchers.IO).launch {
            problemsDao.saveProblems(problems)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            problemsDao.deleteAllProblems()
        }
    }
}