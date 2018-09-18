package com.bernst.d.federico.writesbestfriend

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.bernst.d.federico.writesbestfriend.db.FormDataBase
import com.bernst.d.federico.writesbestfriend.db.dao.PersonajeDao
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion
import com.bernst.d.federico.writesbestfriend.model.creation.Personaje
import org.hamcrest.core.IsEqual.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by atixlabs on 02/03/17.
 */
@RunWith(AndroidJUnit4::class)
class PersonajeDaoTest {

    private lateinit var dao: PersonajeDao
    private lateinit var mDb: FormDataBase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        mDb = Room.inMemoryDatabaseBuilder(context, FormDataBase::class.java).build()
        dao = mDb.personajeDao()
    }

    @After
    fun closeDb() {
        mDb.clearAllTables()
        mDb.close()
    }

    @Test
    fun IOPersonaje() {
        val p = Personaje(1, "desc", 1, 1, InformacionVersion.new())

        dao.insert(p)
        val result = dao.findAll()
        assertThat(result.size, equalTo(1))
        assertThat(result.first(), equalTo(p))
    }
}