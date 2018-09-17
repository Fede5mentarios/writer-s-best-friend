package com.bernst.d.federico.writesbestfriend.viewmodel

import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents

class HomeViewModel : CommonViewModel() {
    override fun init(component: WritersbfComponents)  = component.inject(this)
}