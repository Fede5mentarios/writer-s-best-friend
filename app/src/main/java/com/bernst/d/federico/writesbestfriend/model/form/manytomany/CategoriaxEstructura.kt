package com.bernst.d.federico.writesbestfriend.model.form.manytomany

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.Index
import com.bernst.d.federico.writesbestfriend.model.form.Categoria
import com.bernst.d.federico.writesbestfriend.model.form.Estructura

@Entity(primaryKeys = arrayOf("codEstructura", "codCategoria"),
        indices = arrayOf(Index("codEstructura"), Index("codCategoria")),
        foreignKeys = arrayOf(
                ForeignKey(
                        entity = Estructura::class,
                        parentColumns = arrayOf("codigo"),
                        childColumns = arrayOf("codEstructura"),
                        onDelete = CASCADE,
                        onUpdate = CASCADE),
                ForeignKey(
                        entity = Categoria::class,
                        parentColumns = arrayOf("codigo"),
                        childColumns = arrayOf("codCategoria"),
                        onDelete = CASCADE,
                        onUpdate = CASCADE)
        ))
data class CategoriaxEstructura(
        var codEstructura: Long,
        var codCategoria: Long)
