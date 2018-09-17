package com.bernst.d.federico.writesbestfriend.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.bernst.d.federico.writesbestfriend.model.form.Campo

@Dao
interface CampoDao : BaseDao<Campo> {

    @Query("SELECT * from Campo")
    fun findAll(): List<Campo>

    @Query("SELECT * from Campo where codigo = :id")
    fun byID(id: Long): Campo

    @Query("SELECT * from Campo where codSubcategoria = :subCategoria")
    fun findByParent(subCategoria: Long): List<Campo>
}