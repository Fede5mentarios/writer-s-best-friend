package com.bernst.d.federico.writesbestfriend.model.creation.manytomany

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.Index
import com.bernst.d.federico.writesbestfriend.model.creation.Evento
import com.bernst.d.federico.writesbestfriend.model.creation.Personaje

@Entity(primaryKeys = ["codPersonaje", "codEvento"],
        indices = [Index("codPersonaje"), Index("codEvento")],
        foreignKeys = [ForeignKey(
                entity = Personaje::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codPersonaje"),
                onDelete = CASCADE,
                onUpdate = CASCADE), ForeignKey(
                entity = Evento::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codEvento"),
                onDelete = CASCADE,
                onUpdate = CASCADE)])
data class PersonajexEvento(
        var codPersonaje: Long,
        var codEvento: Long)
