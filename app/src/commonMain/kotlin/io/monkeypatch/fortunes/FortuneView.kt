package io.monkeypatch.fortunes

import io.monkeypatch.mvp.BaseView

interface FortuneView : BaseView {
    fun showLoading(visible: Boolean)
    fun displayFortune(text: String)
}