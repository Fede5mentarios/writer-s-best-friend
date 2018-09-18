package com.bernst.d.federico.writesbestfriend.model.form

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

@Entity(indices = [Index(value = arrayOf("codigo"))])
data class Estructura(
        @PrimaryKey(autoGenerate = true) var codigo: Long,
        @ColumnInfo var descripcion: String,
        @ColumnInfo var custom: Boolean,
        @Embedded var info: InformacionVersion)