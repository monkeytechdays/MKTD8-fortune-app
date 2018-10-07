package io.monkeypatch.utils

import kotlinx.coroutines.CoroutineDispatcher

expect object CommonDispatcher {
    val ui: CoroutineDispatcher
}