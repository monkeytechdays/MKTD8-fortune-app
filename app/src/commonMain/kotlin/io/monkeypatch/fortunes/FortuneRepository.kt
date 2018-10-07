package io.monkeypatch.fortunes

interface FortuneRepository {
    suspend fun getRandomFortune(): Fortune
}
