package com.bernst.d.federico.writesbestfriend.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.bernst.d.federico.writesbestfriend.model.form.Categoria
import com.bernst.d.federico.writesbestfriend.model.form.CategoriaDTO

@Dao
interface CategoriaDao : BaseDao<Categoria> {

    @Query("SELECT * from Categoria")
    fun findAll(): List<Categoria>

    @Query("SELECT * from Categoria")
    fun findAllDTOs(): List<CategoriaDTO>

    @Query("SELECT * from Categoria where codigo = :id")
    fun byID(id: Long): Categoria

    @Query("SELECT * from Categoria c join CategoriaxEstructura x on x.codCategoria = c.codigo where x.codEstructura = :estructura")
    fun findByParent(estructura: Long): List<Categoria>
}