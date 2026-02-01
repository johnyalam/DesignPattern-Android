package fi.developer.designpattern_android.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import fi.developer.basic_kotlin.system.DeviceInformation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(application: Application) : AndroidViewModel(application)  {
    private val _deviceInfo = MutableStateFlow(DeviceInformation.from(application))
    val deviceInfo: StateFlow<DeviceInformation> = _deviceInfo.asStateFlow()
}