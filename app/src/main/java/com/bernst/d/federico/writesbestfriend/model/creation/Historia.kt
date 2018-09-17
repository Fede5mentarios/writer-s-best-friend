package com.bernst.d.federico.writesbestfriend.model.creation

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

@Entity(indices = [Index(value = arrayOf("codEstructura"))])
class Historia(
        codigo: Long,
        @ColumnInfo var portada: Long,
        codEstructura: Long,
        info: InformacionVersion) : Creacion(codigo, codEstructura, info)