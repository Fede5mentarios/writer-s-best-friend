package com.bernst.d.federico.writesbestfriend.viewmodel

import android.arch.lifecycle.ViewModel
import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents

abstract class CommonViewModel : ViewModel() {
    abstract fun init(component: WritersbfComponents)
}