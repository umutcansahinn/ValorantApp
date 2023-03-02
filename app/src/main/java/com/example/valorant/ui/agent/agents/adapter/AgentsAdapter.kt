package com.example.valorant.ui.agent.agents.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.valorant.common.loadImage
import com.example.valorant.databinding.ItemAgentsAdapterBinding
import com.example.valorant.domain.model.Agent

class AgentsAdapter(private val itemClickListener: ( (String)-> Unit)?): RecyclerView.Adapter<AgentsAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemAgentsAdapterBinding): RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Agent>() {
        override fun areItemsTheSame(oldItem: Agent, newItem: Agent): Boolean {
            return oldItem.uuid == newItem.uuid
        }

        override fun areContentsTheSame(oldItem: Agent, newItem: Agent): Boolean {
            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, differCallback)

    var agentsList: List<Agent>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemAgentsAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return agentsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            itemImageView.loadImage(agentsList[position].displayIcon)
            itemImageView.setOnClickListener {
                itemClickListener?.invoke(agentsList[position].uuid)
            }
        }
    }
}