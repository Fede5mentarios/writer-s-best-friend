package com.characterdeveloper

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.characterdeveloper.db.FormDataBase
import com.characterdeveloper.db.dao.PersonajeDao
import com.characterdeveloper.model.InformacionVersion
import com.characterdeveloper.model.creation.Personaje
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

    private var dao: PersonajeDao? = null
    private var mDb: FormDataBase? = null

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        mDb = Room.inMemoryDatabaseBuilder(context, FormDataBase::class.java).build()
        dao = mDb!!.personajeDao()
    }

    @After
    fun closeDb() {
        mDb = null
    }

    @Test
    fun IOPersonaje() {
        val p = Personaje(1, "desc", 1, 1, InformacionVersion.new())

        dao!!.insert(p)
        val result = dao!!.findAll()
        assertThat(result.size, equalTo(1))
        assertThat(result.first(), equalTo(p))
    }
}