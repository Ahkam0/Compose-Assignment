package com.ahkam.mediassist.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ahkam.mediassist.data.model.ProblemsResponse
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class AsthmaConverter(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun toAsthma(asthma: List<ProblemsResponse.Asthma>?): String {
        return jsonParser.toJson(
            asthma,
            object : TypeToken<List<ProblemsResponse.Asthma>>() {}.type
        ) ?: "[]"

    }


    @TypeConverter
    fun fromAsthma(json: String): List<ProblemsResponse.Asthma> {
        return jsonParser.fromJson<List<ProblemsResponse.Asthma>>(
            json,
            object : TypeToken<List<ProblemsResponse.Asthma>>() {}.type
        ) ?: emptyList()


    }

}