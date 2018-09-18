package com.bernst.d.federico.writesbestfriend.model.form

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

@Entity(indices = [Index(value = arrayOf("codigo")), Index(value = arrayOf("codCategoria"))],
        foreignKeys = [ForeignKey(
                entity = Categoria::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codCategoria"),
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        )])
data class SubCategoria(
        @PrimaryKey(autoGenerate = true) var codigo: Long,
        @ColumnInfo var codCategoria: Long,
        @ColumnInfo var descripcion: String,
        @ColumnInfo var help: String?,
        @Embedded var Division: Division,
        @Embedded var info: InformacionVersion)