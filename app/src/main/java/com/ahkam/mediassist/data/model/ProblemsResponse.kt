package com.ahkam.mediassist.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class ProblemsResponse(
    val problems: List<Problems>
) {

    @Entity(tableName = "tbl_problem")
    data class Problems(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: Int,
        @ColumnInfo(name = "diabetes")
        val diabetes: List<Diabetes>? = null,
        @ColumnInfo(name = "asthma")
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