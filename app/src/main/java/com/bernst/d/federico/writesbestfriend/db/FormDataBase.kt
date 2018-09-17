package com.bernst.d.federico.writesbestfriend.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.bernst.d.federico.writesbestfriend.db.dao.*
import com.bernst.d.federico.writesbestfriend.exception.NoDataBaseCreatedException
import com.bernst.d.federico.writesbestfriend.model.creation.*
import com.bernst.d.federico.writesbestfriend.model.creation.manytomany.PersonajexEvento
import com.bernst.d.federico.writesbestfriend.model.creation.manytomany.TagxCreacion
import com.bernst.d.federico.writesbestfriend.model.form.*
import com.bernst.d.federico.writesbestfriend.model.form.manytomany.CategoriaxEstructura
import dagger.Module

@Module
@TypeConverters(Converters::class)
@Database(entities = [
    Estructura::class,
    Categoria::class,
    SubCategoria::class,
    Campo::class,
    Dato::class,
    Header::class,

    Creacion::class,
    Personaje::class,
    Evento::class,
    Historia::class,
    Art::class,
    Tag::class,
    CategoriaxEstructura::class,
    PersonajexEvento::class,
    TagxCreacion::class],
        version = WritersbfDB.VERSION, exportSchema = false)   // TODO Averiguar sobre exportSchema
abstract class FormDataBase : RoomDatabase() {

    abstract fun estructuraDao(): EstructuraDao
    abstract fun categoriaDao(): CategoriaDao
    abstract fun subcategoriaDao(): SubcategoriaDao
    abstract fun campoDao(): CampoDao

    abstract fun manyToManyDao(): ManyToManyDao

    abstract fun personajeDao(): PersonajeDao
    abstract fun historiaDao(): HistoriaDao


    companion object {
        fun getInstance(context: Context): FormDataBase {
            var db: FormDataBase? = null
            synchronized(FormDataBase::class) {
                db = Room.databaseBuilder(context.applicationContext,
                        FormDataBase::class.java, WritersbfDB.NAME)
                        .build()
            }
            if (db == null) {
                throw NoDataBaseCreatedException("DB is null after being created")
            }
            return db!!
        }
    }
}