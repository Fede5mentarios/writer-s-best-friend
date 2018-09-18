package com.bernst.d.federico.writesbestfriend.model.creation

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion
import com.bernst.d.federico.writesbestfriend.model.form.Estructura

@Entity(indices = [Index(value = arrayOf("codEstructura"))],
        foreignKeys = [ForeignKey(
                entity = Estructura::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codEstructura"),
                onDelete = ForeignKey.NO_ACTION,
                onUpdate = ForeignKey.CASCADE)])
abstract class Creacion(
        @PrimaryKey(autoGenerate = true) open var codigo: Long = -1,
        @ColumnInfo open var codEstructura: Long = -1) {
    abstract var info: InformacionVersion
}