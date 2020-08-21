package com.example.ejerciciokotlinviewmodel.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ejerciciokotlinviewmodel.modelo.DrinkDBManager
import com.example.ejerciciokotlinviewmodel.modelo.Drinks
import com.example.ejerciciokotlinviewmodel.modelo.DrinksRoomDB
import kotlinx.coroutines.launch

class DrinksViewModel(application: Application): AndroidViewModel(application) {

    private val dbManager:DrinkDBManager
    val drinkList:LiveData<MutableList<Drinks>>

    init {
        dbManager = DrinkDBManager(DrinksRoomDB.getDB(application).getDAO())
        drinkList = dbManager.getDrunk()
    }

    fun insertDrink(drinks: Drinks) = viewModelScope.launch { dbManager.insertDrink(drinks) }

    fun insertDrinks(list:MutableList<Drinks>) = viewModelScope.launch { dbManager.insertDrinks(list) }

    fun updateDrink(drinks: Drinks) = viewModelScope.launch { dbManager.updateDrink(drinks) }

    fun deleteAll() = viewModelScope.launch { dbManager.deleteAll() }
}