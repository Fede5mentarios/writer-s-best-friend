package com.bernst.d.federico.writesbestfriend.model.form

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

@Entity(indices = [Index(value = arrayOf("codigo")), Index(value = arrayOf("codSubcategoria"))],
        foreignKeys = [ForeignKey(
                entity = SubCategoria::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codSubcategoria"),
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        )])
data class Campo(
        @PrimaryKey(autoGenerate = true) var codigo: Long?,
        @ColumnInfo var codSubcategoria: Long,
        @ColumnInfo var descripcion: String,
        @ColumnInfo var help: String?,
        @ColumnInfo var filtrable: Boolean,
        @Embedded var Division: Division,
        @Embedded var info: InformacionVersion)