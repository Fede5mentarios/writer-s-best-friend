package com.bernst.d.federico.writesbestfriend.db.repository

import com.bernst.d.federico.writesbestfriend.db.dao.EstructuraDao
import com.bernst.d.federico.writesbestfriend.db.dao.HistoriaDao
import com.bernst.d.federico.writesbestfriend.db.dao.PersonajeDao
import com.bernst.d.federico.writesbestfriend.model.creation.Historia
import com.bernst.d.federico.writesbestfriend.utils.CreacionDTO
import com.bernst.d.federico.writesbestfriend.viewmodel.StoriesViewModel
import javax.inject.Inject

class HistoriaRepository @Inject constructor(private val historiaDao: HistoriaDao,
                                             private val personajeDao: PersonajeDao,
                                             private val estructuraDao: EstructuraDao) {
    fun todasHistoriasDTO(storiesViewModel: StoriesViewModel) {
        storiesViewModel.creations.postValue(historiaDao.findAll().map { historia -> toCreationDTO(historia) })
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun toCreationDTO(historia: Historia): CreacionDTO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}