package com.bernst.d.federico.writesbestfriend.model

import java.util.*

data class InformacionVersion(
        var fechaModificacion: Calendar,
        var fechaCreacion: Calendar,
        var delete: Boolean) {
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