package com.example.ejerciciokotlinviewmodel.modelo

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drinks")
data class Drinks(@PrimaryKey(autoGenerate = true) @NonNull val id:Short = 0, var name:String, var price:Int, var quantity:Short)