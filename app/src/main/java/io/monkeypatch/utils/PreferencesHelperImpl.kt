package io.monkeypatch.utils

import android.content.SharedPreferences
import android.preference.PreferenceManager
import io.monkeypatch.fortunes.Application

actual class PreferencesHelperImpl(
    private val sharedPreferences: SharedPreferences
): PreferencesHelper {
    actual constructor() : this(PreferenceManager.getDefaultSharedPreferences(Application.instance))

    override fun saveString(key: String, value: String) {
        TODO("implement this using SharedPreferences")
    }
    override fun loadString(key: String): String? =
        TODO("implement this using SharedPreferences")
}