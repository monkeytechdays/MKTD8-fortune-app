package io.monkeypatch.fortunes

import io.monkeypatch.mvp.BasePresenter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class FortunePresenter(
    private val fortuneView: FortuneView,
    private val fortuneRepository: FortuneRepository,
    private val favoriteFortuneRepository: FavoriteFortuneRepository,
    private val uiDispatcher: CoroutineDispatcher
) : BasePresenter(fortuneView) {
    private var currentFortune: Fortune? = null

    override fun onCreate() {
        super.onCreate()
        TODO("implement this")
    }

    fun loadFortune() {
        launch(uiDispatcher) {
            TODO("implement this")
        }
    }

    fun saveAsFavorite() {
        TODO("implement this")
    }
}