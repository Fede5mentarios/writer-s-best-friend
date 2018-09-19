package com.bernst.d.federico.writesbestfriend.model.form.versionado

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import com.bernst.d.federico.writesbestfriend.model.creation.Version
import com.bernst.d.federico.writesbestfriend.model.form.Categoria

@Entity(primaryKeys = ["codDato", "codCreacion", "codVersion"],
        indices = [Index("codDato"), Index("codCreacion"),
            Index("codVersion"), Index("codCreacion", "codVersion")],
        foreignKeys = [ForeignKey(
                entity = Version::class,
                parentColumns = arrayOf("codCreacion", "codigo"),
                childColumns = arrayOf("codCreacion", "codVersion"),
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE), ForeignKey(
                entity = Categoria::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codDato"),
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)])
data class DatoxVersion(
        var codDato: Long,
        var codCreacion: Long,
        var codVersion: Long)