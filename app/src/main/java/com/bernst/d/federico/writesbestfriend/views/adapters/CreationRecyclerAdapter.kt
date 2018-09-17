package com.bernst.d.federico.writesbestfriend.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bernst.d.federico.writesbestfriend.R
import com.bernst.d.federico.writesbestfriend.utils.CreacionDTO

/**
 * Created by federico on 21/11/16.
 */

class CreationRecyclerAdapter : RecyclerView.Adapter<CreationRecyclerAdapter.CreationViewHolder>() {

    var creations: List<CreacionDTO> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CreationViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.row_creation, parent, false))

    override fun onBindViewHolder(holder: CreationViewHolder, position: Int) {
        TODO("not implemented")
    }

    override fun getItemCount() = creations.size

    class CreationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
