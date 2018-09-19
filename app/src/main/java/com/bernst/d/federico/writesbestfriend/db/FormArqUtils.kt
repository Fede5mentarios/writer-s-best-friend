package com.bernst.d.federico.writesbestfriend.db

import com.bernst.d.federico.writesbestfriend.db.dao.CategoriaDao
import com.bernst.d.federico.writesbestfriend.db.dao.EstructuraDao
import com.bernst.d.federico.writesbestfriend.db.dao.ManyToManyDao
import com.bernst.d.federico.writesbestfriend.exception.EstructuraNoConcuerdaConLaCategoriaException
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion
import com.bernst.d.federico.writesbestfriend.model.form.Campo
import com.bernst.d.federico.writesbestfriend.model.form.SubCategoria

lateinit var categoriaDao: CategoriaDao
lateinit var estructuraDao: EstructuraDao
lateinit var manyToManyDao: ManyToManyDao

fun crearNuevoCampo(subCategoria: SubCategoria, estructuraName: String): Campo {

    val categoria = categoriaDao.byID(subCategoria.codCategoria)

    val estructura = estructuraDao.byID(categoria.codEstructura)

    val nuevaEstructura = estructuraDao.insert(estructura
            .copy(codigo = null, descripcion = estructuraName, custom = true, info = InformacionVersion.new()))

//    manyToManyDao.findByEstructura(estructura.codigo).parallelStream()
//            .map { it.copy(codEstructura = nuevaEstructura) }
//


    TODO()
}
