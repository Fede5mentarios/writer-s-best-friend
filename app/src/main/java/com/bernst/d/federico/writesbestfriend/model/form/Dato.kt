package com.bernst.d.federico.writesbestfriend.model.form

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion


@Entity(indices = arrayOf(
        Index(value = arrayOf("codCampo")),
        Index(value = arrayOf("codCreacion")),
        Index(value = arrayOf("codCampo", "codCreacion"))),
        foreignKeys = arrayOf(
                ForeignKey(
                        entity = Campo::class,
                        parentColumns = arrayOf("codigo"),
                        childColumns = arrayOf("codCampo"),
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE),
                ForeignKey(
                        entity = SubCategoria::class,
                        parentColumns = arrayOf("codigo"),
                        childColumns = arrayOf("codCreacion"),
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE)
        ))
data class Dato(
        @PrimaryKey var codigo: Long,
        @ColumnInfo var codCreacion: Long,
        @ColumnInfo var codCampo: Long,
        @ColumnInfo var contenido: String?,
        @Embedded var info: InformacionVersion)