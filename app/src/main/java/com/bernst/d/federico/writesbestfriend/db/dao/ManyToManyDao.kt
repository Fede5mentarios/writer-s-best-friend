package com.bernst.d.federico.writesbestfriend.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.bernst.d.federico.writesbestfriend.model.creation.manytomany.PersonajexEvento
import com.bernst.d.federico.writesbestfriend.model.creation.manytomany.TagxCreacion
import com.bernst.d.federico.writesbestfriend.model.form.manytomany.CategoriaxEstructura

@Dao
interface ManyToManyDao {

    @Insert(onConflict = REPLACE)
    fun insert(obj: CategoriaxEstructura)

    @Insert(onConflict = REPLACE)
    fun insert(vararg obj: CategoriaxEstructura)

    @Insert(onConflict = REPLACE)
    fun insert(obj: PersonajexEvento)

    @Insert(onConflict = REPLACE)
    fun insert(vararg obj: PersonajexEvento)

    @Insert(onConflict = REPLACE)
    fun insert(obj: TagxCreacion)

    @Insert(onConflict = REPLACE)
    fun insert(vararg obj: TagxCreacion)

    @Update(onConflict = REPLACE)
    fun update(obj: CategoriaxEstructura)

    @Update(onConflict = REPLACE)
    fun update(obj: PersonajexEvento)

    @Update(onConflict = REPLACE)
    fun update(obj: TagxCreacion)

    @Query("SELECT * from CategoriaxEstructura where codEstructura = :codigo")
    fun findByEstructura(codigo: Long): List<CategoriaxEstructura>
}
