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
import java.util.*


/**
 * Created by atixlabs on 02/03/17.
 */
@RunWith(AndroidJUnit4::class)
class EstructuraNavigationTest {

    private lateinit var mDb: FormDataBase
    private lateinit var estructuraDao: EstructuraDao
    private lateinit var categoriaDao: CategoriaDao
    private lateinit var subcategoriaDao: SubcategoriaDao
    private lateinit var campoDao: CampoDao
    private lateinit var manyToManyDao: ManyToManyDao

    private lateinit var campo: Campo

    private lateinit var subCategoria: SubCategoria

    private lateinit var categoria: Categoria

    private lateinit var estructura: Estructura

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        mDb = Room.inMemoryDatabaseBuilder(context, FormDataBase::class.java).build()
        estructuraDao = mDb.estructuraDao()
        categoriaDao = mDb.categoriaDao()
        subcategoriaDao = mDb.subcategoriaDao()
        campoDao = mDb.campoDao()
        manyToManyDao = mDb.manyToManyDao()


        estructura = Estructura(1, "Estructura", false, InformacionVersion.new())
        estructuraDao.insert(estructura)

        categoria = Categoria(1, "Categoria", Division.new().copy(custom = false), InformacionVersion.new())
        categoriaDao.insert(categoria)

        manyToManyDao.insert(CategoriaxEstructura(1, 1))

        subCategoria = SubCategoria(1, 1, "Subcategoria", "Ayuda", Division.new().copy(custom = false), InformacionVersion.new())
        subcategoriaDao.insert(subCategoria)

        campo = Campo(1, 1, "Campo", "Ayuda", false, Division.new().copy(custom = false), InformacionVersion.new())
        campoDao.insert(campo)
    }

    @Test
    fun lookUpCampo() {
        val result = campoDao.findAll()
        assertThat(result.size, equalTo(1))
        val campoResultado = Optional.of(result.first())
        campoResultado.map {
            assertThat(it, equalTo(campo))
            subcategoriaDao.byID(it.codSubcategoria)
        }.map {
            assertThat(it, equalTo(subCategoria))
            categoriaDao.byID(subCategoria.codCategoria)
        }.map {
            assertThat(it, equalTo(categoria))
            estructuraDao.byCategoriaID(it.codigo)
        }.map {
            assertThat(it.first(), equalTo(estructura))
        }
    }

    @Test
    fun lookDowCategoria() {
        val resultCat = categoriaDao.findAllDTOs()
        assertThat(resultCat.size, equalTo(1))

        assertThat(resultCat.first().categoria, equalTo(categoria))
        assertThat(resultCat.first().subCategorias, equalTo(subcategoriaDao.findAll()))
    }

    @Test
    fun lookDowSubCategoria() {
        val resultSub = subcategoriaDao.findAllDTOs()
        assertThat(resultSub.size, equalTo(1))

        assertThat(resultSub.first().subcategoria, equalTo(subCategoria))
        assertThat(resultSub.first().campos, equalTo(campoDao.findAll()))
    }

    @After
    fun closeDb() {
        mDb.clearAllTables()
        mDb.close()
    }
}