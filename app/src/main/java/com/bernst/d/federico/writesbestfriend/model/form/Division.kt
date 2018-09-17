package com.bernst.d.federico.writesbestfriend.model.form

data class Division(
        var orden: Int,
        var custom: Boolean,
        var visible: Boolean) {

    companion object {
        fun new(): Division {
            return Division(99999999,true,true)
        }
    }
}