package com.bernst.d.federico.writesbestfriend.model.creation

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion
import com.bernst.d.federico.writesbestfriend.model.form.Estructura

@Entity(indices = arrayOf(
        Index(value = arrayOf("codEstructura"))),
        foreignKeys = arrayOf(ForeignKey(
                entity = Estructura::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codEstructura"),
                onDelete = ForeignKey.NO_ACTION,
                onUpdate = ForeignKey.CASCADE)))
abstract class Creacion(
        @PrimaryKey(autoGenerate = true) open var codigo: Long,
        @ColumnInfo open var codEstructura: Long,
        @Embedded open var info: InformacionVersion)