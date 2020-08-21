package com.example.ejerciciokotlinviewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciokotlinviewmodel.modelo.Drinks

class RecyclerDrinkAdapter(var list: MutableList<Drinks>):RecyclerView.Adapter<RecyclerDrinkAdapter.Holder>() {

    class Holder(view: View):RecyclerView.ViewHolder(view){
        lateinit var name:TextView
        lateinit var price:TextView
        lateinit var quantity:TextView
    }

    fun update(list:MutableList<Drinks>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.drunk_adapter_layout, parent, false)
        var holder:Holder = Holder(view)
        holder.name = view.findViewById(R.id.drink_name)
        holder.price = view.findViewById(R.id.drink_price)
        holder.quantity = view.findViewById(R.id.drink_quantity)

        return holder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.name.text = list.get(position).name
        holder.price.text = "${list.get(position).price}"
        holder.quantity.text = list.get(position).quantity.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}