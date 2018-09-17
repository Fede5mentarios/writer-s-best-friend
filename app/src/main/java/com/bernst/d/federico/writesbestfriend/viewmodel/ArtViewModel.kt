package com.bernst.d.federico.writesbestfriend.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bernst.d.federico.writesbestfriend.model.creation.Art

class ArtViewModel : ViewModel() {

    var arte: LiveData<List<Art>> = MutableLiveData()
}