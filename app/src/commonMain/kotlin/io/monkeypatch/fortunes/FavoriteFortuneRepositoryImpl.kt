package io.monkeypatch.fortunes

import io.monkeypatch.utils.PreferencesHelper
import io.monkeypatch.utils.ThreadLocal
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list

class FavoriteFortuneRepositoryImpl(
    private val preferencesHelper: PreferencesHelper
) : FavoriteFortuneRepository {
    private val listSerializer: KSerializer<List<Fortune>> = TODO()

    private val favoritesList: MutableList<Fortune> =
        loadInitialList().toMutableList()

    private fun loadInitialList(): List<Fortune> {
        return preferencesHelper.loadString("favorites")?.let {
            println("Loading $it")
            JSON.parse(listSerializer, it)
        } ?: emptyList()
    }

    override fun saveToFavorite(fortune: Fortune) {
        favoritesList.add(fortune)
        val json = JSON.stringify(listSerializer, favoritesList)
        println("Saving $json")
        preferencesHelper.saveString("favorites", json)
    }
}