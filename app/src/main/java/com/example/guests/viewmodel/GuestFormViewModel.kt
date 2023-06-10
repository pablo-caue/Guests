package com.example.guests.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guests.model.GuestModel
import com.example.guests.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    // Ligo o banco
    private val repository = GuestRepository(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel

    private val _saveGuest = MutableLiveData<String>()
    val saveGuest: LiveData<String> = _saveGuest

    fun save(guest: GuestModel) {

        if (guest.id == 0) {
            if (repository.insert(guest)){
                _saveGuest.value = "Inserção com sucesso!"
            }else{
                _saveGuest.value = "Falha"
            }
        } else {
            if(repository.update(guest)){
                _saveGuest.value = "Atualização com sucesso!"
            }else{
                _saveGuest.value = "Falha"
            }

        }
    }

    fun get(id: Int) {
        guestModel.value = repository.get(id)
    }
}