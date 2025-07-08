package com.simonbogutzky.sportappzeichen.gateways

import java.io.InputStreamReader

internal actual class SharedFileReader {
    actual fun loadJsonFile(fileName: String): String? {
        val stream = javaClass.classLoader?.getResourceAsStream(fileName)
        return InputStreamReader(stream).use { it.readText() }
    }
}