package com.simonbogutzky.sportappzeichen.core

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val systemName: String = "Android"
}

actual fun getPlatform(): Platform = AndroidPlatform()