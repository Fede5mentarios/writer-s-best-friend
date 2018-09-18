package com.bernst.d.federico.writesbestfriend.dagger.modules

import com.bernst.d.federico.writesbestfriend.core.WritersbfApplication
import com.bernst.d.federico.writesbestfriend.db.FormDataBase
import com.bernst.d.federico.writesbestfriend.db.dao.EstructuraDao
import com.bernst.d.federico.writesbestfriend.db.dao.HistoriaDao
import com.bernst.d.federico.writesbestfriend.db.dao.PersonajeDao
import com.bernst.d.federico.writesbestfriend.repository.HistoriaRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideDB(app: WritersbfApplication) = app.db

    @Singleton
    @Provides
    fun personajeDao(db: FormDataBase) = db.personajeDao()

    @Singleton
    @Provides
    fun historiaDao(db: FormDataBase) = db.historiaDao()

    @Singleton
    @Provides
    fun estructuraDao(db: FormDataBase) = db.estructuraDao()

    @Provides
    fun historiaRepository(historiaDao: HistoriaDao, personajeDao: PersonajeDao, estructuraDao: EstructuraDao) = HistoriaRepository(historiaDao, personajeDao, estructuraDao)

}
