package com.bernst.d.federico.writesbestfriend.views.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.bernst.d.federico.writesbestfriend.R

/**
 * Created by Federico on 25/06/2017.
 */

class FABMenuController : CoordinatorLayout {

    constructor(context: Context) : super(context) {
        iniciarComponente(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        iniciarComponente(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        iniciarComponente(context)
    }

    private fun iniciarComponente(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.component_floation_action_menu_circular, this)

    }
}
