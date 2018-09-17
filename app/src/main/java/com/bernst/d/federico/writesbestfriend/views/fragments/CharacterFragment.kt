package com.bernst.d.federico.writesbestfriend.views.fragments

import android.widget.TextView
import com.bernst.d.federico.writesbestfriend.R
import com.bernst.d.federico.writesbestfriend.viewmodel.CharacterViewModel
import com.bernst.d.federico.writesbestfriend.views.interfaces.CharacterView

class CharacterFragment : BasicFragment<CharacterViewModel>(CharacterViewModel::class.java), CharacterView {

    override val viewId: Int
        get() = R.layout.fragment_form

    override fun showPopUpFormFrom(title: String, data: String, v: TextView) {
        //TODO llamar al popupForm
    }

    override fun iniciarListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun iniciarObservers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {

        fun newInstance(): CharacterFragment {
            return CharacterFragment()
        }
    }
}
