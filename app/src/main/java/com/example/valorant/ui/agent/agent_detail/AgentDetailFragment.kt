package com.example.valorant.ui.agent.agent_detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.valorant.R
import com.example.valorant.common.gone
import com.example.valorant.common.viewBinding
import com.example.valorant.common.visible
import com.example.valorant.databinding.FragmentAgentDetailBinding
import com.example.valorant.databinding.FragmentAgentsBinding
import com.example.valorant.domain.model.Agent
import com.example.valorant.ui.agent.agents.AgentsState
import com.example.valorant.ui.agent.agents.AgentsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentDetailFragment : Fragment(R.layout.fragment_agent_detail) {

    private val binding by viewBinding(FragmentAgentDetailBinding::bind)
    private val viewModel by viewModels<AgentDetailViewModel>()
    private val args: AgentDetailFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        initView()
    }

    private fun observe() {
        viewModel.state.observe(viewLifecycleOwner) {
            when(it) {
                is AgentDetailState.Loading -> {
                    binding.apply {
                        progressBar.visible()
                        errorTextView.gone()
                        constraintLayoutData.gone()
                    }
                }
                is AgentDetailState.Error -> {
                    binding.apply {
                        progressBar.gone()
                        errorTextView.visible()
                        constraintLayoutData.gone()
                    }
                }
                is AgentDetailState.Success -> {
                    detailAgentData(agent = it.agent)
                    binding.apply {
                        progressBar.gone()
                        errorTextView.gone()
                        constraintLayoutData.visible()
                    }
                }
            }
        }
    }
    private fun initView() {
        val agentUuid = args.agentUuid
        viewModel.getAgentDetail(agentUuid = agentUuid)
    }

    private fun detailAgentData(agent: Agent) {
        binding.apply {
            agentNameTextView.text = agent.displayName
        }
    }
}