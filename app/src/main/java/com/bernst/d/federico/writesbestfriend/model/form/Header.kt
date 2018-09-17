package com.bernst.d.federico.writesbestfriend.model.form

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity
data class Header(
        @PrimaryKey(autoGenerate = true) var codigo: Long? = null,
        @ColumnInfo var codEstructura: Long? = null,
        @ColumnInfo var codCategoria: Long? = null,
        @ColumnInfo var codSubcategoria: Long? = null,
        @ColumnInfo var isDeleted: Boolean = false)
