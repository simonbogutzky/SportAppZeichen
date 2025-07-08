package com.simonbogutzky.sportappzeichen.entities
import kotlinx.serialization.Serializable
/*
{
    "discipline": "3.000 m Lauf",
    "unit": "minutes",
    "categories": [
    {
        "gender": "men",
        "ageRange": {"min": 18, "max": 24},
        "performance": {"bronze": 17.83, "silver": 15.83, "gold": 13.83}
    },
    {
        "gender": "men",
        "ageRange": {"min": 25, "max": 29},
        "performance": {"bronze": 17.33, "silver": 15.33, "gold": 13.33}
    },
    {
        "gender": "men",
        "ageRange": {"min": 30, "max": 34},
        "performance": {"bronze": 17.67, "silver": 15.67, "gold": 13.67}
    },
    {
        "gender": "women",
        "ageRange": {"min": 18, "max": 24},
        "performance": {"bronze": 18.5, "silver": 16.5, "gold": 14.5}
    }
    ]
}
*/

@Serializable
data class Discipline(
    var name: String,
    var unit: Unit,
    var categories: List<Category>
) {
    @Serializable
    enum class Unit {
        MINUTES,
        SECONDS,
        METERS,
        KILOMETERS,
        POINTS
    }
}

@Serializable
data class Category(
    var gender: Gender,
    var ageRange: AgeRange,
    var performance: Performance) {

    @Serializable
    enum class Gender {
        MEN,
        WOMEN
    }
}

@Serializable
data class AgeRange(
    var min: Int,
    var max: Int
)

@Serializable
data class Performance (
    var bronze: Double,
    var silver: Double,
    var gold: Double
)
