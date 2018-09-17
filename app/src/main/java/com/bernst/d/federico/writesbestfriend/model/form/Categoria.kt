package com.bernst.d.federico.writesbestfriend.model.form

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

@Entity(indices = [(Index(value = arrayOf("codigo")))])
data class Categoria(
        @PrimaryKey(autoGenerate = true) var codigo: Long,
        @ColumnInfo var descripcion: String,
        @Embedded var Division: Division,
        @Embedded var info: InformacionVersion)