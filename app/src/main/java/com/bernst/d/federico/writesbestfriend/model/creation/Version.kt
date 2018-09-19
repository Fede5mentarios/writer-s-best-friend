package com.bernst.d.federico.writesbestfriend.model.creation

import android.arch.persistence.room.*
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

@Entity(primaryKeys = ["codigo", "codCreacion"], indices = [Index(value = arrayOf("codCreacion")),
    Index(value = arrayOf("codigo")), Index(value = arrayOf("codigo", "codCreacion"))])
data class Version(
        var codigo: Long = -1,
        var codCreacion: Long = -1,
        @ColumnInfo var descripcion: String?,
        @Embedded(prefix = "info_") var info: InformacionVersion = InformacionVersion.new())