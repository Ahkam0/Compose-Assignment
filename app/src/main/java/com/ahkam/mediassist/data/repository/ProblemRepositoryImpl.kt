package com.ahkam.mediassist.data.repository

import android.util.Log
import com.ahkam.mediassist.data.model.ProblemsResponse
import com.ahkam.mediassist.data.repository.datasource.ProblemCacheDataSource
import com.ahkam.mediassist.data.repository.datasource.ProblemLocalDataSource
import com.ahkam.mediassist.data.repository.datasource.ProblemRemoteDatasource
import com.ahkam.mediassist.domain.repository.ProblemRepository
import java.lang.Exception

class ProblemRepositoryImpl(
    private val problemRemoteDatasource: ProblemRemoteDatasource,
    private val problemLocalDataSource: ProblemLocalDataSource,
    private val problemCacheDataSource: ProblemCacheDataSource
) : ProblemRepository {

    override suspend fun getProblems(): List<ProblemsResponse.Problems>? {
        Log.i("TAG", "problem repository impl getProblem")
        return getProblemsFromCache()
    }

    override suspend fun updateProblems(): List<ProblemsResponse.Problems>? {
        val newListOfProblems = getProblemsFromAPI()
        problemLocalDataSource.clearAll()
        problemLocalDataSource.saveProblemsToDB(newListOfProblems)
        problemCacheDataSource.saveProblemsToCache(newListOfProblems)
        return newListOfProblems
    }


    suspend fun getProblemsFromAPI(): List<ProblemsResponse.Problems> {
        lateinit var problemList: List<ProblemsResponse.Problems>
        try {
            val response = problemRemoteDatasource.getProblems()
            val body = response.body()
            if (body != null) {
                problemList = body.problems
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return problemList
    }

    suspend fun getProblemsFromDB(): List<ProblemsResponse.Problems> {
        lateinit var problemList: List<ProblemsResponse.Problems>
        try {
            problemList = problemLocalDataSource.getProblemsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (problemList.isNotEmpty()) {
            return problemList
        } else {
            problemList = getProblemsFromAPI()
            problemLocalDataSource.saveProblemsToDB(problemList)
        }

        return problemList
    }

    suspend fun getProblemsFromCache(): List<ProblemsResponse.Problems> {
        lateinit var problemList: List<ProblemsResponse.Problems>
        try {
            problemList = problemCacheDataSource.getProblemsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (problemList.size > 0) {
            return problemList
        } else {
            problemList = getProblemsFromDB()
            problemCacheDataSource.saveProblemsToCache(problemList)
        }

        return problemList
    }


}