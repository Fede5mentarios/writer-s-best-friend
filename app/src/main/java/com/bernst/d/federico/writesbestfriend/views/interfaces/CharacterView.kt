package com.bernst.d.federico.writesbestfriend.views.interfaces

import android.widget.TextView

/**
 * Created by atixlabs on 13/04/17.
 */

interface CharacterView : FragmentView {

    /** Para cuando alguien quiere completar un campo */
    fun showPopUpFormFrom(title: String, data: String, v: TextView)
}
