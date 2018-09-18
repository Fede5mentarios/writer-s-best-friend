package com.bernst.d.federico.writesbestfriend.views.activities

import android.support.v7.app.AppCompatActivity
import android.arch.lifecycle.Observer
import android.content.Intent
import android.view.View
import com.bernst.d.federico.writesbestfriend.R
import com.bernst.d.federico.writesbestfriend.model.creation.Creacion
import com.bernst.d.federico.writesbestfriend.utils.CreacionDTO
import com.bernst.d.federico.writesbestfriend.utils.Filtro
import com.bernst.d.federico.writesbestfriend.utils.Ordenador
import com.bernst.d.federico.writesbestfriend.viewmodel.CreationViewModel
import com.bernst.d.federico.writesbestfriend.views.adapters.CreationRecyclerAdapter
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.ads_top.*

abstract class ListActivity<T : CreationViewModel>(override val viewModelClazz: Class<T>) : BasicActivity<T>(viewModelClazz) {

    override fun iniciarObservers() {
        viewModel.creations.observe(this, Observer { creations ->
            creations?.let { actualizarRecycler(it) }
        })
    }

    override fun iniciarListeners() {
//        floatingButton_new.setOnClickListener { newCreation() }
    }


    abstract fun newCreation()

    abstract fun onCreationClick(creation: Creacion)

    fun filtrarYOrdenarSegun(filtro: Filtro, ordenador: Ordenador) {
        viewModel.filtrarYOrdenarSegun(filtro, ordenador)
    }

    fun mostrarTodos() {
        viewModel.mostrarTodos()
    }

    fun actualizarRecycler(creation: List<CreacionDTO>) {
        (recyclerView_listables.adapter as CreationRecyclerAdapter).creations = creation
        recyclerView_listables.adapter?.notifyDataSetChanged()
        relativeLayout_eternalProgressbar.visibility = View.GONE
        recyclerView_listables.visibility = View.VISIBLE
    }

    override val mainView: Int
        get() = R.layout.activity_list
    override val adView: AdView?
        get() = adsView_top

    companion object {
        fun getIntent(from: AppCompatActivity): Intent {
            val intent = Intent(from, ListActivity::class.java)

            return intent
        }
    }
}
