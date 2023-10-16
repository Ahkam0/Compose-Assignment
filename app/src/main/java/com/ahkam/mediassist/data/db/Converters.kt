package com.ahkam.mediassist.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ahkam.mediassist.data.model.ProblemsResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters {
    @TypeConverter
    fun fromStringToDiabetes(value: String?): List<ProblemsResponse.Diabetes>? {
        val listType = object : TypeToken<List<String>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromStringToAsthama(value: String?): List<ProblemsResponse.Asthma>? {
        val listType = object : TypeToken<List<String>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun diabetesToString(diabetes: List<ProblemsResponse.Diabetes>): String? {
        val gson = Gson()
        return gson.toJson(diabetes)
    }

    @TypeConverter
    fun asthmaToString(asthama: List<ProblemsResponse.Asthma>): String? {
        val gson = Gson()
        return gson.toJson(asthama)
    }
}