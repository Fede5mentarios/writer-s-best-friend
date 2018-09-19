package com.bernst.d.federico.writesbestfriend.model.form.versionado

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import com.bernst.d.federico.writesbestfriend.model.creation.Version
import com.bernst.d.federico.writesbestfriend.model.form.Categoria

@Entity(primaryKeys = ["codCategoria", "codCreacion", "codVersion"],
        indices = [Index("codCategoria"), Index("codCreacion"),
            Index("codVersion"),Index("codCreacion","codVersion")],
        foreignKeys = [ForeignKey(
                entity = Version::class,
                parentColumns = arrayOf("codCreacion","codigo"),
                childColumns = arrayOf("codCreacion","codVersion"),
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE), ForeignKey(
                entity = Categoria::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codCategoria"),
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)])
data class CategoriaxVersion(
        var codCategoria: Long,
        var codCreacion: Long,
        var codVersion: Long,
        var visible: Boolean = true)