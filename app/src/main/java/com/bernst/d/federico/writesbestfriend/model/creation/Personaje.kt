package com.bernst.d.federico.writesbestfriend.model.creation

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

@Entity(indices = [(Index(value = arrayOf("codHistoria")))],
        foreignKeys = [(ForeignKey(
                entity = Historia::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codHistoria"),
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE))], inheritSuperIndices = true)
class Personaje(
        codigo: Long,
        @ColumnInfo var descripcion: String,
        @ColumnInfo var codHistoria: Long,
        codEstructura: Long,
        @Embedded(prefix = "info_") override var info: InformacionVersion = InformacionVersion.new()) : Creacion(codigo, codEstructura)