package com.bernst.d.federico.writesbestfriend.db

import android.arch.persistence.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun fromTimestamp(time: Long?): Calendar? {
        time?.let {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = it
            return calendar
        }
        return null
    }

    @TypeConverter
    fun dateToTimestamp(calendar: Calendar?) = calendar?.timeInMillis
}