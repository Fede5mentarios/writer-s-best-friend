package com.bernst.d.federico.writesbestfriend.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.bernst.d.federico.writesbestfriend.utils.CreacionDTO
import com.bernst.d.federico.writesbestfriend.utils.Filtro
import com.bernst.d.federico.writesbestfriend.utils.Ordenador

abstract class CreationViewModel : CommonViewModel() {
    abstract fun filtrarYOrdenarSegun(filtro: Filtro, ordenador: Ordenador)
    abstract fun mostrarTodos()
    var creations: MutableLiveData<List<CreacionDTO>> = MutableLiveData()
}