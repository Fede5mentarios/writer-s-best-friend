package com.bernst.d.federico.writesbestfriend.views.activities

import android.os.Bundle
import com.bernst.d.federico.writesbestfriend.R
import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents
import com.bernst.d.federico.writesbestfriend.viewmodel.HomeViewModel
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.ads_top.*


class HomeActivity : BasicActivity<HomeViewModel>(HomeViewModel::class.java) {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (intent.getBooleanExtra(EXIT_KEY, false)) finish()
        super.onCreate(savedInstanceState)
    }

    override fun iniciarObservers() {}  // Esta pantalla no se ve afectada por ningun cambio en la data (por ahora)

    override fun iniciarListeners() {
        linear_botonHitorias.setOnClickListener {
            navigator.goToHistorias(this)
        }

        linear_botonPersonajes.setOnClickListener {
            navigator.goToPersonajes(this)
        }

        linear_botonEventos.setOnClickListener {
            navigator.goToEventos(this)
        }

        linear_botonArte.setOnClickListener {
            navigator.goToArte(this)
        }
    }

    override val tituloId: Int
        get() = R.string.inicio

    override val adView: AdView?
        get() = adsView_top

    override val mainView: Int
        get() = R.layout.activity_home

    companion object {
        private const val EXIT_KEY = "EXIT_APP"
    }
}
