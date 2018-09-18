package com.bernst.d.federico.writesbestfriend

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.bernst.d.federico.writesbestfriend.db.FormDataBase
import com.bernst.d.federico.writesbestfriend.db.dao.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion
import com.bernst.d.federico.writesbestfriend.model.form.*
import com.bernst.d.federico.writesbestfriend.model.form.manytomany.CategoriaxEstructura
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by atixlabs on 02/03/17.
 */
@RunWith(AndroidJUnit4::class)
class EstructuraCompletaTest {

    private var mDb: FormDataBase? = null
    private var estructuraDao: EstructuraDao? = null
    private var categoriaDao: CategoriaDao? = null
    private var subcategoriaDao: SubcategoriaDao? = null
    private var campoDao: CampoDao? = null
    private var manyToManyDao: ManyToManyDao? = null

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
//        mDb = Room.databaseBuilder(context, FormDataBase::class.java, "testFormDataBase.db").build()
        mDb = Room.inMemoryDatabaseBuilder(context, FormDataBase::class.java).build()
        estructuraDao = mDb!!.estructuraDao()
        categoriaDao = mDb!!.categoriaDao()
        subcategoriaDao = mDb!!.subcategoriaDao()
        campoDao = mDb!!.campoDao()
        manyToManyDao = mDb!!.manyToManyDao()
    }

    @Test
    fun DBOpenTest() {
        assertThat(mDb?.isOpen, equalTo(true))
    }

    @Test
    fun IOEstructuraTest() {
        val estructura = Estructura(1, "Estructura", false, InformacionVersion.new())
        estructuraDao!!.insert(estructura)

        val result = estructuraDao!!.findAll()
        assertThat(result.size, equalTo(1))
        assertThat(result.first(), equalTo(estructura))
        assertThat(estructuraDao!!.byID(1), equalTo(estructura))
    }

    @Test
    fun IOCategoriaTest() {
        val estructura = Estructura(1, "Estructura", false, InformacionVersion.new())
        estructuraDao!!.insert(estructura)

        val categoria = Categoria(1, "Categoria", Division.new().copy(custom = false), InformacionVersion.new())
        categoriaDao!!.insert(categoria)

        manyToManyDao!!.insert(CategoriaxEstructura(1, 1))

        val result = categoriaDao!!.findAll()
        assertThat(result.size, equalTo(1))
        assertThat(result.first(), equalTo(categoria))

        assertThat(categoriaDao!!.findByParent(estructura.codigo).first(), equalTo(categoria))
    }

    @Test
    fun IOSubcategoriaTest() {
        val estructura = Estructura(1, "Estructura", false, InformacionVersion.new())
        estructuraDao!!.insert(estructura)

        val categoria = Categoria(1, "Categoria", Division.new().copy(custom = false), InformacionVersion.new())
        categoriaDao!!.insert(categoria)

        manyToManyDao!!.insert(CategoriaxEstructura(1, 1))

        val subCategoria = SubCategoria(1, 1, "Subcategoria", "Ayuda", Division.new().copy(custom = false), InformacionVersion.new())
        subcategoriaDao!!.insert(subCategoria)

        val result = subcategoriaDao!!.findAll()
        assertThat(result.size, equalTo(1))
        assertThat(result.first(), equalTo(subCategoria))

        assertThat(subcategoriaDao!!.findByParent(categoria.codigo).first(), equalTo(subCategoria))
    }

    @Test
    fun IOCampoTest() {
        val estructura = Estructura(1, "Estructura", false, InformacionVersion.new())
        estructuraDao!!.insert(estructura)

        val categoria = Categoria(1, "Categoria", Division.new().copy(custom = false), InformacionVersion.new())
        categoriaDao!!.insert(categoria)

        manyToManyDao!!.insert(CategoriaxEstructura(1, 1))

        val subCategoria = SubCategoria(1, 1, "Subcategoria", "Ayuda", Division.new().copy(custom = false), InformacionVersion.new())
        subcategoriaDao!!.insert(subCategoria)

        val campo = Campo(1, 1, "Campo", "Ayuda", false, Division.new().copy(custom = false), InformacionVersion.new())
        campoDao!!.insert(campo)

        val result = campoDao!!.findAll()
        assertThat(result.size, equalTo(1))
        assertThat(result.first(), equalTo(campo))

        assertThat(campoDao!!.findByParent(subCategoria.codigo).first(), equalTo(campo))
    }

    @After
    fun closeDb() {
        mDb?.close()
    }
}