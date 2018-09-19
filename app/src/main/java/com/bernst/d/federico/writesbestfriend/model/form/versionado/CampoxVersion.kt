package com.bernst.d.federico.writesbestfriend.model.form.versionado

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import com.bernst.d.federico.writesbestfriend.model.creation.Version
import com.bernst.d.federico.writesbestfriend.model.form.Campo
import com.bernst.d.federico.writesbestfriend.model.form.Categoria

@Entity(primaryKeys = ["codCampo", "codCreacion", "codVersion"],
        indices = [Index("codCampo"), Index("codCreacion"),
            Index("codVersion"),Index("codCreacion","codVersion")],
        foreignKeys = [ForeignKey(
                entity = Version::class,
                parentColumns = arrayOf("codCreacion","codigo"),
                childColumns = arrayOf("codCreacion","codVersion"),
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE), ForeignKey(
                entity = Campo::class,
                parentColumns = arrayOf("codigo"),
                childColumns = arrayOf("codCampo"),
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)])
data class CampoxVersion(
        var codCampo: Long,
        var codCreacion: Long,
        var codVersion: Long,
        var visible: Boolean = true)