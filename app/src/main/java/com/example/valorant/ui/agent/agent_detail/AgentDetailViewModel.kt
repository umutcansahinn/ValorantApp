package com.example.valorant.ui.agent.agent_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorant.common.Resource
import com.example.valorant.domain.usecase.agents.GetAgentDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    private val getAgentDetailUseCase: GetAgentDetailUseCase
) : ViewModel() {

    private val _state = MutableLiveData<AgentDetailState>()
    val state: LiveData<AgentDetailState> = _state

    fun getAgentDetail(agentUuid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getAgentDetailUseCase(agentUuid = agentUuid).collect { result ->
                when(result) {
                    is Resource.Success -> {
                        _state.value = AgentDetailState(agent = result.data)
                    }
                    is Resource.Error -> {
                        _state.value = AgentDetailState(error = result.errorMessage)
                    }
                    is Resource.Loading -> {
                        _state.value = AgentDetailState(isLoading = true)
                    }
                }
            }
        }
    }
}