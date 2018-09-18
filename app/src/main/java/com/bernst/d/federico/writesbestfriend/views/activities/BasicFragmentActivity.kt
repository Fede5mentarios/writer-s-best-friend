package com.bernst.d.federico.writesbestfriend.views.activities

import android.support.v4.app.Fragment
import com.bernst.d.federico.writesbestfriend.viewmodel.CommonViewModel
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


abstract class BasicFragmentActivity<T : CommonViewModel>(override val viewModelClazz: Class<T>) : BasicActivity<T>(viewModelClazz), HasActivityInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    fun fragmentInjector() = fragmentInjector
}
