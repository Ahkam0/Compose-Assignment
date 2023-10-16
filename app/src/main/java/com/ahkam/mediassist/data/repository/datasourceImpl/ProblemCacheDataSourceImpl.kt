package com.ahkam.mediassist.data.repository.datasourceImpl

import com.ahkam.mediassist.data.model.ProblemsResponse
import com.ahkam.mediassist.data.repository.datasource.ProblemCacheDataSource

class ProblemCacheDataSourceImpl : ProblemCacheDataSource {

    private var problemList = ArrayList<ProblemsResponse.Problems>()
    override suspend fun getProblemsFromCache(): List<ProblemsResponse.Problems> {
        return problemList
    }
    override suspend fun saveProblemsToCache(problems: List<ProblemsResponse.Problems>) {
        problemList.clear()
        problemList = ArrayList(problems)
    }
}