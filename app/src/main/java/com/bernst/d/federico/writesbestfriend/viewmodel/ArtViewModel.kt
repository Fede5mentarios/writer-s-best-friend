package com.bernst.d.federico.writesbestfriend.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bernst.d.federico.writesbestfriend.model.creation.Art

class ArtViewModel : ViewModel() {

    var arte: LiveData<List<Art>> = MutableLiveData()
}