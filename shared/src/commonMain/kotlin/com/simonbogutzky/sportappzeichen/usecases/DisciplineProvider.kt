package com.simonbogutzky.sportappzeichen.usecases

import com.simonbogutzky.sportappzeichen.entities.Discipline
import com.simonbogutzky.sportappzeichen.gateways.LocalDisciplineFileStorage

class DisciplineProvider {
    private val localDisciplineFileStorage = LocalDisciplineFileStorage()

    suspend fun fetchDisciplines(): List<Discipline> {
        return localDisciplineFileStorage.getData()
    }
}