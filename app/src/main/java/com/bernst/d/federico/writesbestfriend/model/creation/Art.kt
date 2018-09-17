package com.bernst.d.federico.writesbestfriend.model.creation

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.bernst.d.federico.writesbestfriend.model.InformacionVersion

@Entity
data class Art(
        @PrimaryKey(autoGenerate = true) var codigo: Long,
        @ColumnInfo var pathImagen: String,
        @Embedded var link: Link,
        @Embedded var info: InformacionVersion)

data class Link(var id: Long, var tableName: String)