package fi.developer.designpattern_android.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fi.developer.basic_kotlin.system.DeviceInformation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(application: Application) : ViewModel()  {
    private val _deviceInfo = MutableStateFlow(DeviceInformation.from(application))
    val deviceInfo: StateFlow<DeviceInformation> = _deviceInfo.asStateFlow()
}