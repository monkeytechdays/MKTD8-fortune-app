package io.monkeypatch.fortunes

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.github.tomakehurst.wiremock.junit.WireMockRule
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals


class FortuneRepositoryImplTest {
    @get:Rule
    val wireMockRule = WireMockRule(WireMockConfiguration().dynamicPort())

    @Test
    fun testFortuneRepositoryShouldFetchFortune() {
        stubFor(get("/fortunes").willReturn(
            aResponse().withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("""{id:1, quote: "Cool quote"}""")
        ))

        val repo = FortuneRepositoryImpl("http://localhost:${wireMockRule.port()}/fortunes")
        runBlocking {
            val fortune = repo.getRandomFortune()
            assertEquals(Fortune(1, "Cool quote"), fortune)
        }
    }
}