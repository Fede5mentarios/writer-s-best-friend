package com.bernst.d.federico.writesbestfriend.model.form

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

class EstructuraConCategorias {

    @Embedded
    var estructura: Estructura = Estructura(-1, "", false, InformacionVersion.new())

    @Relation(parentColumn = "codigo",
            entityColumn = "codEstructura",
            entity = Categoria::class)
    var categorias: List<Categoria> = listOf()
}