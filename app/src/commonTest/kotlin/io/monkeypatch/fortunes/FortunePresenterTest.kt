package io.monkeypatch.fortunes

import kotlinx.coroutines.Dispatchers
import kotlin.test.Test
import kotlin.test.assertEquals

class FortunePresenterTest {
    private val fortuneText = "Bananas are awesome ! A. Monkey"
    private val fortune1 = Fortune(1, fortuneText)

    private fun testOnCreate(): PresenterAndDependencies {
        //Given a fortune presenter
        val presenterAndDependencies = getPresenterAndDependencies()
        val (view, repository, _,  presenter) = presenterAndDependencies
        assertEquals(false, view.loading)

        // When the presenter is started
        presenter.onCreate()
        // Then it display a loading indicator, and call the fortune repository
        assertEquals(true, view.loading)

        // When the loading is complete

        repository.deferred?.complete(fortune1)
        // Then it remove the loading indicator and display the fortune text
        assertEquals(false, view.loading)
        assertEquals(fortuneText, view.text)
        return presenterAndDependencies
    }

    @Test
    fun onCreateShouldDisplayAFortune() {
        testOnCreate()
    }

    @Test
    fun loadFortuneShouldDisplayAnotherFortune() {
        val (view, repository, _, presenter) = testOnCreate()
        // When I load another fortune
        presenter.loadFortune()
        // Then it display a loading indicator, and call the fortune repository
        assertEquals(true, view.loading)

        // When the loading is complete
        val fortuneText2 = "To be monkey or not to be ? Chimpspeare"
        repository.deferred?.complete(Fortune(2, fortuneText2))

        // Then it remove the loading indicator and display the fortune text
        assertEquals(false, view.loading)
        assertEquals(fortuneText2, view.text)
    }

    @Test
    fun loadingErrorShouldBeDisplayedToUser() {
        //Given a fortune presenter
        val (view, repository, _, presenter) = getPresenterAndDependencies()
        assertEquals(false, view.loading)

        // When the presenter is started
        presenter.onCreate()
        // Then it display a loading indicator, and call the fortune repository
        assertEquals(true, view.loading)

        // When the loading is failed
        val errorMessage = "Loading error"
        repository.deferred?.completeExceptionally(Exception(errorMessage))

        // Then it remove the loading indicator and display the fortune text
        assertEquals(false, view.loading)
        assertEquals(errorMessage, view.text)
    }

    @Test
    fun saveAsFavoriteShouldSaveCurrentFortune() {
        val (_, _, favRepository, presenter) = testOnCreate()
        presenter.saveAsFavorite()
        assertEquals(listOf(fortune1), favRepository.savedFortunes)
    }

    private fun getPresenterAndDependencies(): PresenterAndDependencies {
        val view = MockFortuneView()
        val repository = MockFortuneRepository()
        val favRepository = MockFavoriteFortuneRepository()
        val presenter = FortunePresenter(view, repository, favRepository, Dispatchers.Unconfined)
        return PresenterAndDependencies(view, repository, favRepository, presenter)
    }
}

