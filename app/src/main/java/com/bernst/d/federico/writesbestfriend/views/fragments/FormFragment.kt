package com.bernst.d.federico.writesbestfriend.views.fragments

import android.widget.TextView
import com.bernst.d.federico.writesbestfriend.R
import com.bernst.d.federico.writesbestfriend.viewmodel.FormViewModel

class FormFragment : BasicFragment<FormViewModel>(FormViewModel::class.java) {

    override val viewId: Int
        get() = R.layout.fragment_form


    override fun iniciarObservers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iniciarListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun showPopUpFormFrom(title: String, data: String, v: TextView) {
        //TODO llamar al popupForm
    }

    companion object {

        fun newInstance(): FormFragment {
            return FormFragment()
        }
    }
}
