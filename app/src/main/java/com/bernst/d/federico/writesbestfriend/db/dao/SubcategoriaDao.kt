package com.bernst.d.federico.writesbestfriend.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.bernst.d.federico.writesbestfriend.model.form.SubCategoria
import com.bernst.d.federico.writesbestfriend.model.form.SubcategoriaConCampos

@Dao
interface SubcategoriaDao : BaseDao<SubCategoria> {

    @Query("SELECT * from subcategoria")
    fun findAll(): List<SubCategoria>

    @Query("SELECT * from subcategoria")
    fun findAllDTOs(): List<SubcategoriaConCampos>

    @Query("SELECT * from subcategoria where codigo = :id")
    fun byID(id: Long): SubCategoria

    @Query("SELECT * from SubCategoria where codCategoria = :subcategoria")
    fun findByParent(subcategoria: Long): List<SubCategoria>
}