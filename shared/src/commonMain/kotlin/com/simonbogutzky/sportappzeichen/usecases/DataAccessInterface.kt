package com.simonbogutzky.sportappzeichen.usecases

interface DataAccessInterface {
    suspend fun <T> getData(): List<T>
}