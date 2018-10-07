package io.monkeypatch

import io.monkeypatch.fortunes.*
import io.monkeypatch.utils.CommonDispatcher
import io.monkeypatch.utils.PreferencesHelper
import io.monkeypatch.utils.PreferencesHelperImpl
import io.monkeypatch.utils.ThreadLocal
import kotlinx.coroutines.CoroutineDispatcher

@ThreadLocal
object Container {
    private val uiDispatcher: CoroutineDispatcher = CommonDispatcher.ui

    private val fortuneRepository: FortuneRepository =
        FortuneRepositoryImpl("https://monkeyconf.herokuapp.com/fortunes")

    private val preferencesHelper: PreferencesHelper by lazy {
        PreferencesHelperImpl()
    }

    private val favoriteFortuneRepository: FavoriteFortuneRepository by lazy {
        FavoriteFortuneRepositoryImpl(preferencesHelper)
    }

    fun fortunePresenter(fortuneView: FortuneView) =
            FortunePresenter(fortuneView, fortuneRepository, favoriteFortuneRepository, uiDispatcher)
}
