package com.bernst.d.federico.writesbestfriend.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.bernst.d.federico.writesbestfriend.model.form.Estructura

@Dao
interface EstructuraDao : BaseDao<Estructura> {

    @Query("SELECT * from Estructura")
    fun findAll(): List<Estructura>

    @Query("SELECT * from Estructura where codigo = :id")
    fun byID(id: Long): Estructura

}