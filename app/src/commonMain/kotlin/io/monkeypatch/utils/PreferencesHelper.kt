package io.monkeypatch.utils

interface PreferencesHelper {
    fun saveString(key: String, value: String)
    fun loadString(key: String): String?
}

expect class PreferencesHelperImpl() : PreferencesHelper