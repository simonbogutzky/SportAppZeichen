package com.simonbogutzky.sportappzeichen.entities
import kotlinx.serialization.Serializable

@Serializable
data class Discipline(
    var name: String,
    var category: Category,
    var unit: Unit? = null,
    var performances: List<Performance>
) {
    @Serializable
    enum class Unit { MINUTES, SECONDS, METERS,  REPS }
    @Serializable
    enum class Category { ENDURANCE, STRENGTH, SPEED, COORDINATION }
}

@Serializable
data class Performance(
    var gender: Gender,
    var ageRange: AgeRange,
    var variant: String? = null,
    var requirements: Requirements? = null
) {
    @Serializable
    enum class Gender { MEN, WOMEN }
}

@Serializable
data class AgeRange(var min: Int, var max: Int)

@Serializable
data class Requirements(var bronze: Double, var silver: Double, var gold: Double)