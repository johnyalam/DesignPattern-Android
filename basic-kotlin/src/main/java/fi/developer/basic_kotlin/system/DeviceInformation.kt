package fi.developer.basic_kotlin.system

import android.content.Context
import android.os.Build
import android.provider.Settings

data class DeviceInformation(
    val manufacturer: String,
    val brand: String,
    val model: String,
    val device: String,
    val product: String,
    val androidVersion: String,
    val sdkInt: Int,
    val hardware: String,
    val board: String,
    val deviceId: String
) {
    companion object {
        fun from(context: Context): DeviceInformation {
            return DeviceInformation(
                manufacturer = Build.MANUFACTURER,
                brand = Build.BRAND,
                model = Build.MODEL,
                device = Build.DEVICE,
                product = Build.PRODUCT,
                androidVersion = Build.VERSION.RELEASE ?: "Unknown",
                sdkInt = Build.VERSION.SDK_INT,
                hardware = Build.HARDWARE,
                board = Build.BOARD,
                deviceId = Settings.Secure.getString(
                    context.contentResolver,
                    Settings.Secure.ANDROID_ID
                )
            )
        }
    }
}