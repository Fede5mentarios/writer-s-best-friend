package com.bernst.d.federico.writesbestfriend.utils

data class Filtro(val valorBusqueda: String, val query: (String) -> String)
data class Ordenador(val valorBusqueda: String, val query: (String) -> String)