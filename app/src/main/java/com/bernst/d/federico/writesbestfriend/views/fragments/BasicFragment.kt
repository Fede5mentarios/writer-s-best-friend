package com.bernst.d.federico.writesbestfriend.views.fragments

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.bernst.d.federico.writesbestfriend.core.WritersbfApplication
import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents
import com.bernst.d.federico.writesbestfriend.viewmodel.CommonViewModel
import com.bernst.d.federico.writesbestfriend.views.Navigator
import com.bernst.d.federico.writesbestfriend.views.activities.BasicActivity
import com.bernst.d.federico.writesbestfriend.views.interfaces.FragmentView
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BasicFragment<T : CommonViewModel>(private val viewModelClazz: Class<T>) : Fragment(), FragmentView {

    protected lateinit var viewModel: T

    @Inject
    protected lateinit var navigator: Navigator

    private val component: WritersbfComponents
        get() = (activity?.application as WritersbfApplication).component

    protected val basicActivity: BasicActivity<*>
        get() = activity as BasicActivity<*>

    protected abstract val viewId: Int

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        iniciarViewModel(this.component)
        super.onAttach(context)
    }

    private fun iniciarViewModel(component: WritersbfComponents) {
        viewModel = ViewModelProviders.of(this).get(viewModelClazz)
        viewModel.init(component)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(viewId, container, false)
        iniciarObservers()
        iniciarListeners()
        return view
    }

    protected abstract fun iniciarListeners()

    protected abstract fun iniciarObservers()

    override fun showToastError(error: String) {
        if (context != null) {
            val toast = Toast.makeText(context, error, LENGTH_SHORT)
            toast.show()
        }
    }
}
