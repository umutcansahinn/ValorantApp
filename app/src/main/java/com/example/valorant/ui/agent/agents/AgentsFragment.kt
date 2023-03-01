package com.example.valorant.ui.agent.agents

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorant.R
import com.example.valorant.common.viewBinding
import com.example.valorant.databinding.FragmentAgentsBinding
import com.example.valorant.ui.agent.agents.adapter.AgentsAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class AgentsFragment : Fragment(R.layout.fragment_agents) {

    private val binding by viewBinding(FragmentAgentsBinding::bind)
    private val viewModel by viewModels<AgentsViewModel>()
    private val agentsAdapter = AgentsAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAgents()
        observe()
        initView()
    }

    private fun observe() {
        viewModel.state.observe(viewLifecycleOwner) {
            when(it) {
                is AgentsState.Loading -> {
                    binding.errorTextView.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                }
                is AgentsState.Error -> {
                    binding.errorTextView.text = it.error
                    binding.errorTextView.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                    binding.progressBar.visibility = View.GONE
                }
                is AgentsState.Success -> {
                    agentsAdapter.agentsList = it.agents
                    binding.errorTextView.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }
    private fun initView() {
        binding.recyclerView.adapter = agentsAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}