package com.bernst.d.federico.writesbestfriend.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents
import com.bernst.d.federico.writesbestfriend.model.form.Categoria
import com.bernst.d.federico.writesbestfriend.utils.Filtro
import com.bernst.d.federico.writesbestfriend.utils.Ordenador

class CharacterViewModel : CreationViewModel() {
    override fun filtrarYOrdenarSegun(filtro: Filtro, ordenador: Ordenador) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mostrarTodos() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    var characterID: LiveData<Long> = MutableLiveData()
    val categorriasExtras: LiveData<List<Categoria>> = MutableLiveData()

    fun setCharacterID(characterID: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun init(component: WritersbfComponents)  = component.inject(this)
}