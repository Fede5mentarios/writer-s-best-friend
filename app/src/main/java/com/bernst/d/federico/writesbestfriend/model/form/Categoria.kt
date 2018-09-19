package com.bernst.d.federico.writesbestfriend.model.form

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

@Entity(indices = [Index(value = arrayOf("codigo")), Index(value = arrayOf("codEstructura"))],
        foreignKeys = [ForeignKey(
                entity = Estructura::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codEstructura"),
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        )])
data class Categoria(
        @PrimaryKey(autoGenerate = true) var codigo: Long?,
        @ColumnInfo var codEstructura: Long,
        @ColumnInfo var descripcion: String,
        @Embedded var Division: Division,
        @Embedded var info: InformacionVersion)