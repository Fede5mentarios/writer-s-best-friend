package com.bernst.d.federico.writesbestfriend

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.bernst.d.federico.writesbestfriend.db.FormDataBase
import com.bernst.d.federico.writesbestfriend.db.dao.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion
import com.bernst.d.federico.writesbestfriend.model.creation.Personaje
import com.bernst.d.federico.writesbestfriend.model.form.*
import com.bernst.d.federico.writesbestfriend.model.form.manytomany.CategoriaxEstructura
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
class PersonajeCompletoTest {

    private var mDb: FormDataBase? = null
    private var personajeDao: PersonajeDao? = null
        get() = mDb!!.personajeDao()
    private var estructuraDao: EstructuraDao? = null
        get() = mDb!!.estructuraDao()
    private var categoriaDao: CategoriaDao? = null
        get() = mDb!!.categoriaDao()
    private var subcategoriaDao: SubcategoriaDao? = null
        get() = mDb!!.subcategoriaDao()
    private var campoDao: CampoDao? = null
        get() = mDb!!.campoDao()
    private var manyToManyDao: ManyToManyDao? = null
        get() = mDb!!.manyToManyDao()

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        mDb = Room.inMemoryDatabaseBuilder(context, FormDataBase::class.java).build()

        val estructura = Estructura(1, "Basico", false, InformacionVersion.new())
        estructuraDao!!.insert(estructura)

        val categoria = Categoria(1, "Datos Personales", Division.new().copy(custom = false), InformacionVersion.new())
        categoriaDao!!.insert(categoria)

        manyToManyDao!!.insert(CategoriaxEstructura(1, 1))

        val subCategoria1 = SubCategoria(1, 1, "Persona", "Datos basicos del personaje", Division(1, false, true), InformacionVersion.new())
        val subCategoria2 = SubCategoria(2, 1, "Descripción", null, Division(2, false, true), InformacionVersion.new())
        subcategoriaDao!!.insert(subCategoria1, subCategoria2)

        val campo1 = Campo(1, 1, "Nombre", null, false, Division(1, false, true), InformacionVersion.new())
        val campo2 = Campo(2, 1, "Alias", null, false, Division(2, false, true), InformacionVersion.new())
        val campo3 = Campo(3, 1, "Apellido", null, false, Division(3, false, true), InformacionVersion.new())
        val campo4 = Campo(4, 2, "Sexo", "Ni la cantidad ni la calidad", true, Division(1, false, true), InformacionVersion.new())
        val campo5 = Campo(5, 2, "Genero", "Si, ya se, soy progre", true, Division(2, false, true), InformacionVersion.new())
        val campo6 = Campo(6, 2, "Etnia", null, false, Division(3, false, true), InformacionVersion.new())
        campoDao!!.insert(campo1, campo2, campo3, campo4, campo5, campo6)

    }

    @After
    fun closeDb() {
        mDb = null
    }

    @Test
    fun IOPersonajeNuevo() {
        val personaje = Personaje(1, "Test", 1, 1, InformacionVersion.new())
        personajeDao!!.insert(personaje)

        personajeDao!!.insert(personaje)
        val result = personajeDao!!.findAll()
        assertThat(result.size, equalTo(1))
        assertThat(result.first(), equalTo(personaje))
    }
}