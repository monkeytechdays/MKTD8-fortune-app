package io.monkeypatch.fortunes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.monkeypatch.Container
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FortuneView {
    private val presenter = Container.fortunePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onCreate()
        randomButton.setOnClickListener {
            presenter.loadFortune()
        }

        favoriteButton.setOnClickListener {
            presenter.saveAsFavorite()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    // You can use progressBar and textView imported from
    // kotlinx.android.synthetic.main.activity_main.*
    // to update the UI

    override fun showLoading(visible: Boolean) {
        TODO("Update the UI")
    }

    override fun displayFortune(text: String) {
        TODO("Update the UI")
    }

    override fun displayError(e: Exception) {
        TODO("Update the UI")
    }
}
