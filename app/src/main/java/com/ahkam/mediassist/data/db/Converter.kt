package com.ahkam.mediassist.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ahkam.mediassist.data.model.ProblemsResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converter() {
    @TypeConverter
    fun toDiabetes(diabetes: List<ProblemsResponse.Diabetes>?): String {
        return Gson().toJson(
            diabetes,
            object : TypeToken<List<ProblemsResponse.Diabetes>>() {}.type
        )
    }

    @TypeConverter
    fun fromDiabetes(json: String): List<ProblemsResponse.Diabetes> {
        return Gson().fromJson<List<ProblemsResponse.Diabetes>>(
            json,
            object : TypeToken<List<ProblemsResponse.Diabetes>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toAsthma(asthma: List<ProblemsResponse.Asthma>?): String {
        return Gson().toJson(asthma, object : TypeToken<List<ProblemsResponse.Asthma>>() {}.type)
    }

    @TypeConverter
    fun fromAsthma(json: String): List<ProblemsResponse.Asthma> {
        return Gson().fromJson<List<ProblemsResponse.Asthma>>(
            json,
            object : TypeToken<List<ProblemsResponse.Asthma>>() {}.type
        ) ?: emptyList()

    }


}