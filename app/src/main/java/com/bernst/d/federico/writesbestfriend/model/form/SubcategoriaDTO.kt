package com.bernst.d.federico.writesbestfriend.model.form

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

class SubcategoriaDTO {

    @Embedded
    var subcategoria: SubCategoria = SubCategoria(-1, -1, "", "", Division.new(), InformacionVersion.new())


    @Relation(parentColumn = "codigo",
            entityColumn = "codSubcategoria",
            entity = Campo::class)
    var campos: List<Campo> = listOf()
}