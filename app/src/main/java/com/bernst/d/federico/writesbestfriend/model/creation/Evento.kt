package com.bernst.d.federico.writesbestfriend.model.creation

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

@Entity(indices = [(Index(value = arrayOf("codEstructura"))), (Index(value = arrayOf("codHistoria")))],
        foreignKeys = [(ForeignKey(
                entity = Historia::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codHistoria"),
                onDelete = ForeignKey.NO_ACTION,
                onUpdate = ForeignKey.CASCADE))])
class Evento(
        codigo: Long,
        @ColumnInfo var codHistoria: Long,
        codEstructura: Long,
        @Embedded(prefix = "info_") override var info: InformacionVersion = InformacionVersion.new()) : Creacion(codigo, codEstructura)