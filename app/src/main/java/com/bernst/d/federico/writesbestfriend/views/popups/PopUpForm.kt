package com.bernst.d.federico.writesbestfriend.views.popups

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import com.bernst.d.federico.writesbestfriend.R
import kotlinx.android.synthetic.main.layout_popup_form.*

class PopUpForm : DialogFragment() {

    private var title: String? = null
    private var desc: String? = null
    private var viewID: Int? = null


    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        title = getTitle(args)
        desc = getDescription(args)
        viewID = getViewID(args)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.activity!!)
        val convertView = activity?.layoutInflater?.inflate(R.layout.layout_popup_form, null, false)
        builder.setView(convertView)

        textview_formTitle.text = title
        edittext_formValue.setText(desc)

        iniciarListeners()
        return builder.create()
    }

    private fun iniciarListeners() {
        button_cancel.setOnClickListener({
            button_accept!!.isClickable = false
            button_cancel!!.isClickable = false
            targetFragment?.onActivityResult(targetRequestCode, android.support.v7.app.AppCompatActivity.RESULT_CANCELED, activity?.intent)
            dialog.cancel()
        })

        button_accept.setOnClickListener({
            button_accept!!.isClickable = false
            button_cancel!!.isClickable = false

            val intent = activity?.intent
            intent?.putExtra(POPUP_VIEW_ID, viewID)
            intent?.putExtra(POPUP_DESC, edittext_formValue.text.toString())
            intent?.putExtra(POPUP_TITLE, textview_formTitle.text.toString())
            targetFragment?.onActivityResult(targetRequestCode, android.support.v7.app.AppCompatActivity.RESULT_OK, intent)
            dialog.cancel()
        })

    }

    private fun getTitle(savedInstanceState: Bundle?): String {
        return savedInstanceState?.getString(POPUP_TITLE, "Falta Título").toString()
    }

    private fun getDescription(savedInstanceState: Bundle?): String {
        return savedInstanceState?.getString(POPUP_DESC, "Ingresar descripción").toString()
    }

    private fun getViewID(savedInstanceState: Bundle?): Int {
        return savedInstanceState?.getInt(POPUP_VIEW_ID)!!
    }

    companion object {

        val POPUP_TITLE = "POPUP_TITLE"
        val POPUP_DESC = "POUP_DESC"
        val POPUP_VIEW_ID = "POPUP_VIEW_ID"
    }
}

