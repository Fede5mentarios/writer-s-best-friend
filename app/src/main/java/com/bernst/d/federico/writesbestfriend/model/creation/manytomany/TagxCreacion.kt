package com.bernst.d.federico.writesbestfriend.model.creation.manytomany

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import com.bernst.d.federico.writesbestfriend.model.creation.Creacion
import com.bernst.d.federico.writesbestfriend.model.creation.Tag

@Entity(primaryKeys = arrayOf("creacion", "tag"),
        indices = arrayOf(Index("creacion"), Index("tag"), Index("creacion", "tag")),
        foreignKeys = arrayOf(
                ForeignKey(
                        entity = Creacion::class,
                        parentColumns = arrayOf("codigo"),
                        childColumns = arrayOf("creacion"),
                        onDelete = ForeignKey.NO_ACTION,
                        onUpdate = ForeignKey.CASCADE),
                ForeignKey(
                        entity = Tag::class,
                        parentColumns = arrayOf("nombre"),
                        childColumns = arrayOf("tag"),
                        onDelete = ForeignKey.NO_ACTION,
                        onUpdate = ForeignKey.CASCADE)
        ))
data class TagxCreacion(
        var creacion: Long,
        var tag: String)