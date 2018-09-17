package com.bernst.d.federico.writesbestfriend.utils

import android.util.Log

/**
 * Created by Federico on 14/07/2017.
 */

public val LOG_ENABLED: Boolean = true;
public val TAG: String = "HNNotify"

public fun log(text: String) {
    if (LOG_ENABLED) {
        Log.d(TAG, text)
    }
}
