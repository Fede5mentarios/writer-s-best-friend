package com.bernst.d.federico.writesbestfriend.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents
import com.bernst.d.federico.writesbestfriend.model.creation.Personaje
import com.bernst.d.federico.writesbestfriend.utils.Filtro
import com.bernst.d.federico.writesbestfriend.utils.Ordenador

class CharactersViewModel : CreationViewModel() {

    override fun init(component: WritersbfComponents) {
        component.inject(this)
    }

    override fun filtrarYOrdenarSegun(filtro: Filtro, ordenador: Ordenador) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mostrarTodos() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var personajes: LiveData<List<Personaje>> = MutableLiveData()
}