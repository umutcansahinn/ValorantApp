package com.example.valorant.ui.agent.agents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorant.common.Resource
import com.example.valorant.domain.usecase.agents.GetAgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val getAgentsUseCase: GetAgentsUseCase
) : ViewModel() {

    private val _state = MutableLiveData<AgentsState>()
    val state: LiveData<AgentsState> = _state


    fun getAgents() {
        viewModelScope.launch(Dispatchers.IO) {
            getAgentsUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data.also {
                            _state.value = AgentsState(agents = it)
                        }
                    }
                    is Resource.Loading -> {
                        _state.value = AgentsState(isLoading = true)
                    }
                    is Resource.Error -> {
                        _state.value = AgentsState(error = result.errorMessage)
                    }
                }
            }
        }
    }
}