package com.simonbogutzky.sportappzeichen.gateways
import com.simonbogutzky.sportappzeichen.core.getPlatform
import com.simonbogutzky.sportappzeichen.entities.Discipline
import com.simonbogutzky.sportappzeichen.usecases.DataAccessInterface
import kotlinx.serialization.json.Json

class LocalDisciplineFileStorage: DataAccessInterface {

    private val platform = getPlatform()
    private val sharedFileReader = SharedFileReader()

    override suspend fun <T> getData(): List<T> {
        val jsonContent = try {
            sharedFileReader.loadJsonFile(if (platform.systemName == "iOS") "data.json" else "files/data.json")
        } catch (_: Exception) {
            return emptyList()
        }

        return try {
            val disciplines: List<Discipline> = Json.decodeFromString(jsonContent ?: return emptyList())
            disciplines as List<T>
        } catch (_: Exception) {
            emptyList()
        }
    }
}