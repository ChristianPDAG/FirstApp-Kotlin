package com.chris.myfirstapp.settings

data class SettingsModel(
    var volume: Int,
    var bluetooth: Boolean,
    var vibration: Boolean,
    var darkMode: Boolean
) {
}