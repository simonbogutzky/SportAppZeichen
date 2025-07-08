package com.simonbogutzky.sportappzeichen.core

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val systemName: String = UIDevice.currentDevice.systemName()
}

actual fun getPlatform(): Platform = IOSPlatform()