package com.bernst.d.federico.writesbestfriend

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.bernst.d.federico.writesbestfriend.db.FormDataBase
import com.bernst.d.federico.writesbestfriend.db.dao.HistoriaDao
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion
import com.bernst.d.federico.writesbestfriend.model.creation.Historia
import com.bernst.d.federico.writesbestfriend.model.form.Estructura
import org.hamcrest.core.IsEqual.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*


/**
 * Created by atixlabs on 02/03/17.
 */
@RunWith(AndroidJUnit4::class)
class HistoriaDaoTest {

    private lateinit var dao: HistoriaDao
    private lateinit var mDb: FormDataBase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        mDb = Room.inMemoryDatabaseBuilder(context, FormDataBase::class.java).build()
        dao = mDb.historiaDao()
        mDb.estructuraDao().insert(Estructura(1, "Estructura Test", false, InformacionVersion(Calendar.getInstance(), Calendar.getInstance(), false)))
    }

    @After
    fun closeDB() {
        mDb.clearAllTables()
        mDb.close()
    }

    @Test
    fun IOHistoria() {
        val h = Historia(1, 1, 1, InformacionVersion.new())
        dao.insert(h)

        val result = dao.findAll()
        assertThat(result.size, equalTo(1))
        assertThat(result.first().codigo, equalTo(h.codigo))
        assertThat(result.first().portada, equalTo(h.portada))
        assertThat(result.first().codEstructura, equalTo(h.codEstructura))
        assertThat(result.first().info.fechaCreacion, equalTo(h.info.fechaCreacion))
        assertThat(result.first().info.fechaModificacion, equalTo(h.info.fechaModificacion))
        assertThat(result.first().info.delete, equalTo(h.info.delete))
    }
}