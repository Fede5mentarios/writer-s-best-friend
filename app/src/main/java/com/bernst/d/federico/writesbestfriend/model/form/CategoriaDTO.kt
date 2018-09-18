package com.bernst.d.federico.writesbestfriend.model.form

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

class CategoriaDTO {

    @Embedded
    var categoria: Categoria = Categoria(-1, "", Division.new(), InformacionVersion.new())

    @Relation(parentColumn = "codigo",
            entityColumn = "codCategoria",
            entity = SubCategoria::class)
    var subCategorias: List<SubCategoria> = listOf()
}