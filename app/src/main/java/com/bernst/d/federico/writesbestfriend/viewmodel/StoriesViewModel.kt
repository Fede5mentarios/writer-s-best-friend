package com.bernst.d.federico.writesbestfriend.viewmodel

import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents
import com.bernst.d.federico.writesbestfriend.db.repository.HistoriaRepository
import com.bernst.d.federico.writesbestfriend.utils.Filtro
import com.bernst.d.federico.writesbestfriend.utils.Ordenador
import javax.inject.Inject

class StoriesViewModel @Inject constructor() : CreationViewModel() {

    @Inject
    lateinit var historiaRepository: HistoriaRepository

    override fun init(component: WritersbfComponents) {
//        component.inject(this)
    }

    override fun filtrarYOrdenarSegun(filtro: Filtro, ordenador: Ordenador) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mostrarTodos() {
        historiaRepository.todasHistoriasDTO(this)
    }
}