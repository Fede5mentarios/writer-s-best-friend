package com.bernst.d.federico.writesbestfriend.model

import android.arch.persistence.room.ColumnInfo
import java.util.*

data class InformacionVersion(
        @ColumnInfo var fechaModificacion: Calendar?,
        @ColumnInfo var fechaCreacion: Calendar?,
        @ColumnInfo var delete: Boolean?) {
    companion object {
        fun new(): InformacionVersion {
            return InformacionVersion(
                    Calendar.getInstance(),
                    Calendar.getInstance(),
                    false
            )
        }
    }
}