package com.bernst.d.federico.writesbestfriend.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bernst.d.federico.writesbestfriend.model.creation.Evento

class EventsViewModel : ViewModel() {
    var eventos : LiveData<List<Evento>> = MutableLiveData()
}