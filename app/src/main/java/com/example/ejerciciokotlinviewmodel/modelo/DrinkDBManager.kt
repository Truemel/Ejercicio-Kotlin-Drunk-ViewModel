package com.example.ejerciciokotlinviewmodel.modelo

import androidx.lifecycle.LiveData

class DrinkDBManager(val dao: DrinkDAO) {

    suspend fun insertDrink(drinks: Drinks){
        dao.insertDrink(drinks)
    }

    suspend fun insertDrinks(list:MutableList<Drinks>){
        dao.insertDrinks(list)
    }

    suspend fun updateDrink(drinks: Drinks){
        dao.updateDrink(drinks)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }

    fun getDrunk():LiveData<MutableList<Drinks>>{
        return dao.getDrunk()
    }
}