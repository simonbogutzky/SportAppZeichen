package com.simonbogutzky.sportappzeichen.gateways

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCObjectVar
import kotlinx.cinterop.allocPointerTo
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.value
import platform.Foundation.NSBundle
import platform.Foundation.NSError
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.stringWithContentsOfFile
import platform.darwin.NSObject
import platform.darwin.NSObjectMeta

@OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
internal actual class SharedFileReader {
    private val bundle: NSBundle = NSBundle.Companion.bundleForClass(BundleMarker)

    actual fun loadJsonFile(fileName: String): String? {
        val (filename, type) = when (val lastPeriodIndex = fileName.lastIndexOf('.')) {
            0 -> {
                null to fileName.drop(1)
            }
            in 1..Int.MAX_VALUE -> {
                fileName.take(lastPeriodIndex) to fileName.drop(lastPeriodIndex + 1)
            }
            else -> {
                fileName to null
            }
        }
        val path = bundle.pathForResource(filename, type) ?: error("Couldn't get path of $fileName (parsed as: ${listOfNotNull(filename, type).joinToString(".")})")

        return memScoped {
            val errorPtr = allocPointerTo<ObjCObjectVar<NSError?>>()
            NSString.Companion.stringWithContentsOfFile(
                path,
                encoding = NSUTF8StringEncoding,
                error = errorPtr.value
            ) ?: run {
                error("Couldn't load resource: $fileName. Error: ${errorPtr.value?.rawValue}")
            }
        }
    }

    private class BundleMarker : NSObject() {
        companion object Companion : NSObjectMeta()
    }
}