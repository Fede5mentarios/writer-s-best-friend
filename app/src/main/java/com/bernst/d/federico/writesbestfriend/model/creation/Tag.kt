package com.bernst.d.federico.writesbestfriend.model.creation

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.bernst.d.federico.writesbestfriend.model.creation.manytomany.TagxCreacion

@Entity
data class Tag(@PrimaryKey var nombre: String)