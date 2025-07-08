package com.simonbogutzky.sportappzeichen.gateways

internal expect class SharedFileReader() {
    fun loadJsonFile(fileName: String): String?
}