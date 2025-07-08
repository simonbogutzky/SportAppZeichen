package com.simonbogutzky.sportappzeichen

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform