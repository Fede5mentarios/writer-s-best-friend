package com.bernst.d.federico.writesbestfriend.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.bernst.d.federico.writesbestfriend.model.creation.Historia

@Dao
interface HistoriaDao : BaseDao<Historia> {

    @Query("SELECT * from historia")
    fun findAll(): List<Historia>
}