package com.example.valorant.ui.agent.agents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorant.R
import com.example.valorant.common.gone
import com.example.valorant.common.viewBinding
import com.example.valorant.common.visible
import com.example.valorant.databinding.FragmentAgentsBinding
import com.example.valorant.ui.agent.agents.adapter.AgentsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentsFragment : Fragment(R.layout.fragment_agents) {

    private val binding by viewBinding(FragmentAgentsBinding::bind)
    private val viewModel by viewModels<AgentsViewModel>()
    private val agentsAdapter = AgentsAdapter(::itemSetClick)
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
                    binding.apply {
                        errorTextView.gone()
                        recyclerView.gone()
                        progressBar.visible()
                    }
                }
                is AgentsState.Error -> {
                    binding.apply {
                        errorTextView.text = it.error
                        errorTextView.visible()
                        recyclerView.gone()
                        progressBar.gone()
                    }
                }
                is AgentsState.Success -> {
                    agentsAdapter.agentsList = it.agents
                    binding.apply {
                        errorTextView.gone()
                        recyclerView.visible()
                        progressBar.gone()
                    }
                }
            }
        }
    }
    private fun initView() {
        binding.recyclerView.adapter = agentsAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun itemSetClick(agentUuid: String) {
        val action =AgentsFragmentDirections.actionAgentsFragmentToAgentDetailFragment(agentUuid = agentUuid)
        findNavController().navigate(action)
    }
}