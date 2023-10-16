package com.ahkam.mediassist.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ProblemsResponse(

    @SerializedName("problems")
    val problems: List<Problems>
) {

    @Entity(tableName = "tbl_problems")
    data class Problems(
        @PrimaryKey
        @SerializedName("id")
        val id: Int,
        @SerializedName("diabetes")
        val diabetes: List<Diabetes>,
        @SerializedName("asthma")
        val asthma: List<Asthma>
    )

    data class MedicationsClasses(
        val className: List<ClassName>,
        val className2: List<ClassName2>
    )

    data class Medications(

        val medicationsClasses: List<MedicationsClasses>
    )

    data class Labs(

        val missing_field: String
    )

    data class Diabetes(
        val medications: List<Medications>,
        val labs: List<Labs>
    )

    data class ClassName2(
        val associatedDrug: List<AssociatedDrug>,
        val associatedDrug2: List<AssociatedDrug>
    )

    data class ClassName(

        val associatedDrug: List<AssociatedDrug>,
        val associatedDrug2: List<AssociatedDrug>
    )

    data class AssociatedDrug(
        val name: String,
        val dose: String,
        val strength: String
    )


    data class Asthma(
        val name: String?
    )
}