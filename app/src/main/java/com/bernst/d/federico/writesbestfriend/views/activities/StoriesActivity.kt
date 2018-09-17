package com.bernst.d.federico.writesbestfriend.views.activities

import android.arch.lifecycle.Observer
import android.content.Intent
import com.bernst.d.federico.writesbestfriend.R
import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents
import com.bernst.d.federico.writesbestfriend.model.creation.Creacion
import com.bernst.d.federico.writesbestfriend.viewmodel.StoriesViewModel
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.ads_top.*

class StoriesActivity(override val tituloId: Int = R.string.historias) : ListActivity<StoriesViewModel>(StoriesViewModel::class.java) {

    override fun newCreation() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreationClick(creation: Creacion) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun injectDependencies(components: WritersbfComponents) {
//            components.inject(this)
    }

    override fun iniciarObservers() {
        viewModel.creations.observe(this, Observer { creations ->
            creations?.let { actualizarRecycler(it) }
        })
    }

    override fun iniciarListeners() {
//        floatingButton_new.setOnClickListener { newCreation() }
    }

    override val mainView: Int
        get() = R.layout.activity_list
    override val adView: AdView?
        get() = adsView_top

    companion object {
        fun getIntent(intent: Intent) = {
            val toReturn = Intent(intent)
        }
    }
}
