package com.bernst.d.federico.writesbestfriend.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents
import com.bernst.d.federico.writesbestfriend.model.form.SubCategoria

class FormViewModel : CommonViewModel() {
    override fun init(component: WritersbfComponents)  = component.inject(this)

    val subCategories: LiveData<List<SubCategoria>> = MutableLiveData()

}