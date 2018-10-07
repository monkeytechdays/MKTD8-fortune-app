package io.monkeypatch.fortunes

interface FavoriteFortuneRepository {
    fun saveToFavorite(fortune: Fortune)
}