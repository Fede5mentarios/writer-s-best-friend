package com.bernst.d.federico.writesbestfriend.model.creation

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

@Entity(indices = [Index(value = arrayOf("codEstructura"))])
class Historia(
        codigo: Long = -1,
        @ColumnInfo var portada: Long = -1,  //  Que quise poner con esto ?? Sera una FK a una imagen para acceso rápido ??
        codEstructura: Long = -1,
        @Embedded(prefix = "info_") override var info: InformacionVersion = InformacionVersion.new()) : Creacion(codigo, codEstructura)