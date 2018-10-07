package io.monkeypatch.utils

import platform.Foundation.NSUserDefaults

actual class PreferencesHelperImpl(
    private val defaults: NSUserDefaults
): PreferencesHelper {
    actual constructor() : this(NSUserDefaults.standardUserDefaults)

    override fun saveString(key: String, value: String) {
        TODO("implement this using NSUserDefaults")
    }
    override fun loadString(key: String): String? =
        TODO("implement this using NSUserDefaults")
}