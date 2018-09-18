package com.bernst.d.federico.writesbestfriend.exception

class EstructuraNoConcuerdaConLaCategoriaException(val error: String) : Exception(error) {
    constructor(estructura: Long, categoria: Long) : this("La estructura $estructura no concuerda con una perteneciente a $categoria")
}