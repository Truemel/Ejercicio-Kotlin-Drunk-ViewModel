package com.example.ejerciciokotlinviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciokotlinviewmodel.ViewModel.DrinksViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    lateinit var recyclerV:RecyclerView
    lateinit var adapter:RecyclerDrinkAdapter
    lateinit var viewModel:DrinksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(DrinksViewModel::class.java)
        var view:View = inflater.inflate(R.layout.fragment_first, container, false)
        recyclerV = view.findViewById(R.id.recyclerV)
        viewModel.drinkList.observe(context as MainActivity, Observer { recyclerV.adapter = RecyclerDrinkAdapter(it) })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}