package io.monkeypatch.fortunes

import kotlinx.coroutines.CompletableDeferred

data class PresenterAndDependencies(
    val view: MockFortuneView,
    val repository: MockFortuneRepository,
    val favoriteRepository: MockFavoriteFortuneRepository,
    val presenter: FortunePresenter
)

class MockFortuneView : FortuneView {
    var loading: Boolean = false
    var text: String = ""

    override fun showLoading(visible: Boolean) {
        loading = visible
    }

    override fun displayFortune(text: String) {
        this.text = text
    }

    override fun displayError(e: Exception) {
        this.text = e.message!!
    }
}

class MockFortuneRepository : FortuneRepository {
    var deferred: CompletableDeferred<Fortune>? = null

    override suspend fun getRandomFortune(): Fortune {
        val deferred = CompletableDeferred<Fortune>()
        this.deferred = deferred
        return deferred.await()
    }
}

class MockFavoriteFortuneRepository : FavoriteFortuneRepository {
    var savedFortunes = mutableListOf<Fortune>()

    override fun saveToFavorite(fortune: Fortune) {
        savedFortunes.add(fortune)
    }
}