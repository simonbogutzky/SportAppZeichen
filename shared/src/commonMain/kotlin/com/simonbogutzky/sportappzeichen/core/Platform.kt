package com.simonbogutzky.sportappzeichen.core

interface Platform {
    val name: String
    val systemName: String
}

expect fun getPlatform(): Platform