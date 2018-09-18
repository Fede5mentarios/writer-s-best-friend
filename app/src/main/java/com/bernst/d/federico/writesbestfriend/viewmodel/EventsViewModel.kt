package com.bernst.d.federico.writesbestfriend.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bernst.d.federico.writesbestfriend.model.creation.Evento

class EventsViewModel : ViewModel() {
    var eventos : LiveData<List<Evento>> = MutableLiveData()
}