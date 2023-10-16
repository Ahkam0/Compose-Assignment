package com.ahkam.mediassist.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ahkam.mediassist.data.model.ProblemsResponse
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class DiabetesConverter(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun toDiabetes(diabetes: List<ProblemsResponse.Diabetes>?): String {
        return jsonParser.toJson(
            diabetes,
            object : TypeToken<List<ProblemsResponse.Diabetes>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromDiabetes(json: String): List<ProblemsResponse.Diabetes> {
        return jsonParser.fromJson<List<ProblemsResponse.Diabetes>>(
            json,
            object : TypeToken<List<ProblemsResponse.Diabetes>>() {}.type
        ) ?: emptyList()

    }

}