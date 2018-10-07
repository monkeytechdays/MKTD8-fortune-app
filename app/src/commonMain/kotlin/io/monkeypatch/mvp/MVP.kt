package io.monkeypatch.mvp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

interface BaseView {
    fun displayError(e: Exception)
}

abstract class BasePresenter(
    val view: BaseView
) : CoroutineScope {
    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job

    open fun onCreate() {
        job = Job()
    }

    open fun onDestroy() {
        job.cancel()
    }
}