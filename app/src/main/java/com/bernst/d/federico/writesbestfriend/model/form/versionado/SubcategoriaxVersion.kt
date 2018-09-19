package com.bernst.d.federico.writesbestfriend.model.form.versionado

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import com.bernst.d.federico.writesbestfriend.model.creation.Version
import com.bernst.d.federico.writesbestfriend.model.form.Categoria
import com.bernst.d.federico.writesbestfriend.model.form.SubCategoria

@Entity(primaryKeys = ["codSubcategoria", "codCreacion", "codVersion"],
        indices = [Index("codSubcategoria"), Index("codCreacion"),
            Index("codVersion"), Index("codCreacion", "codVersion")],
        foreignKeys = [ForeignKey(
                entity = Version::class,
                parentColumns = arrayOf("codCreacion", "codigo"),
                childColumns = arrayOf("codCreacion", "codVersion"),
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE), ForeignKey(
                entity = SubCategoria::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codSubcategoria"),
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)])
data class SubcategoriaxVersion(
        var codSubcategoria: Long,
        var codCreacion: Long,
        var codVersion: Long,
        var visible: Boolean = true)