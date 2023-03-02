package com.example.valorant.ui.agent.agents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorant.common.Resource
import com.example.valorant.domain.usecase.UseCase
import com.example.valorant.domain.usecase.agents.GetAgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private val _state = MutableLiveData<AgentsState>()
    val state: LiveData<AgentsState> = _state


    fun getAgents() {
        viewModelScope.launch() {
            useCase.getAgentsUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data.also {
                            delay(2000)
                            _state.value = AgentsState.Success(agents = it)
                        }
                    }
                    is Resource.Loading -> {
                        _state.value = AgentsState.Loading
                    }
                    is Resource.Error -> {
                        _state.value = AgentsState.Error(error = result.errorMessage)
                    }
                }
            }
        }
    }
}