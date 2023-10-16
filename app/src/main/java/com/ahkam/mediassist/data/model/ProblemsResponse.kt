package com.ahkam.mediassist.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ProblemsResponse(
    @SerializedName("problems")
    val problems: List<Problems>
) {

    @Entity(tableName = "tbl_problem")
    data class Problems(
        @PrimaryKey
        @SerializedName("id")
        val id: Int,

        @SerializedName("Diabetes")
        val diabetes: List<Diabetes>? = null,

        @SerializedName("Asthma")
        val asthma: List<Asthma>? = null
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
        val associatedDrug2: List<AssociatedDrug2>
    )

    data class ClassName(
        val associatedDrug: List<AssociatedDrug>,
        val associatedDrug2: List<AssociatedDrug2>
    )

    data class AssociatedDrug(
        val name: String,
        val dose: String,
        val strength: String
    )

    data class AssociatedDrug2(
        val name: String,
        val dose: String,
        val strength: String
    )


    data class Asthma(
        val medications: List<Medications>,
        val labs: List<Labs>
    )
}