package io.monkeypatch.fortunes

import kotlinx.serialization.json.JSON
import kotlin.test.Test
import kotlin.test.assertEquals

class FortuneTest {
    @Test
    fun thisTestShouldCompile() {
        val fortune1 = Fortune(id = 1, quote = "Cool fortune")
        val fortune2 = Fortune(2, "Cool fortune 2")
        val fortune1bis = fortune1.copy(quote = "Cool fortune bis")

        assertEquals(Fortune(1, "Cool fortune bis"), fortune1bis)
    }

    @Test
    fun fortunesShouldBeSerializable() {
        val fortune1 = Fortune(id = 1, quote = "Cool fortune")
        val fortune1Json = JSON.stringify(Fortune.serializer(), fortune1)

        assertEquals("{\"id\":1,\"quote\":\"Cool fortune\"}", fortune1Json)

        val fortune1Bis = JSON.parse(Fortune.serializer(), fortune1Json)
        assertEquals(fortune1, fortune1Bis)
    }
}