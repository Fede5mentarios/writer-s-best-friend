package com.bernst.d.federico.writesbestfriend.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.bernst.d.federico.writesbestfriend.model.creation.Personaje

@Dao
interface PersonajeDao : BaseDao<Personaje> {

    @Query("SELECT * from personaje")
    fun findAll(): List<Personaje>
}