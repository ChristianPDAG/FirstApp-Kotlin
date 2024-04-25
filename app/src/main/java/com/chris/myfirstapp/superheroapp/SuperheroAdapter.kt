package com.chris.myfirstapp.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chris.myfirstapp.R

class SuperheroAdapter(
    var superheroList: List<SuperheroItemResponse> = emptyList(),
    private val onItemSelected: (String) -> Unit  //función lambda para llamar al item especifico
) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(superheroList: List<SuperheroItemResponse>) {
        this.superheroList = superheroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate((R.layout.item_superhero), parent, false)
        )
    }


    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {
        viewholder.bind(superheroList[position], onItemSelected)
    }

    override fun getItemCount() = superheroList.size
}
